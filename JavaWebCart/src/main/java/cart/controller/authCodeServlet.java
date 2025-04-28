package cart.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/authcode")
public class authCodeServlet extends HttpServlet {
	
	private String generateAuthCode() {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer authcode = new StringBuffer();
		Random random = new Random();
		for(int i=0; i<4;i++) {
			int index = random.nextInt(chars.length());
			authcode.append(chars.charAt(index));
		}
		return authcode.toString();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Random random = new Random();
		//String authcode = String.format("%04d", random.nextInt(10000));
		String authcode = generateAuthCode();	
		
		// 將 autocode 存入到 HttpSession 屬性中
		HttpSession session = req.getSession();
		session.setAttribute("authcode", authcode);
		
		ImageIO.write(getAuthCodeImage(authcode), "JPEG", resp.getOutputStream());
	}
	
	// 利用 Java2D 產生動態圖像
	private BufferedImage getAuthCodeImage(String authcode) {
		// 建立圖像區域(80x30 RGB)
		BufferedImage img = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
		// 建立畫布
		Graphics g = img.getGraphics();
		// 設定顏色
		g.setColor(Color.yellow);
		// 塗滿背景
		g.fillRect(0, 0, 80, 30); // 全區域
		// 設定顏色
		g.setColor(Color.BLACK);
		// 設定字形
		g.setFont(new Font("Arial", Font.BOLD, 22)); // 字體, 風格, 大小
		// 繪文字
		g.drawString(authcode, 18, 22); // 表示繪文字左上角的起點
		// 加上干擾線
		g.setColor(Color.red);
		Random random = new Random();
		for(int i = 0; i < 15; i++) {
			int x1 = random.nextInt(80); // 0~79
			int y1 = random.nextInt(30); // 0~29
			int x2 = random.nextInt(80); // 0~79
			int y2 = random.nextInt(30); // 0~29
			// 繪直線
			g.drawLine(x1, y1, x2, y2);
		}
		
		return img;
		
		
	}
}

