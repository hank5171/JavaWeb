package servlet;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 表示瀏覽器可以透過 http://localhost:8080/JavaWeb/hello 網址執行到此 Servlet 程式
@WebServlet("/hello")  //精簡配置寫法
//@WebServlet(urlPatterns = "/hello") //標準寫法
//@WebServlet(urlPatterns = {"/hello","/welcome","/aaa/bbb/ccc/hello","/hi.php"})
//@WebServlet("/*") // 不建議 /後面隨便打都可以
public class HelloServlet extends HttpServlet {

	@Override //網址的請求 doGet
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Hello JavaServlet"); //將字串回應給瀏覽器
	}

	/*
	@Override //表單的請求
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	} */
}
