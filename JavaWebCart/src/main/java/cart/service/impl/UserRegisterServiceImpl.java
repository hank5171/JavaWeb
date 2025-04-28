package cart.service.impl;

import java.sql.SQLException;

import cart.dao.UserRegisterDAO;
import cart.dao.impl.UserRegisterDAOimpl;
import cart.model.entity.User;
import cart.service.UserRegisterService;
import cart.util.HashUtil;

public class UserRegisterServiceImpl implements UserRegisterService	 {

	// 取得 userRegisterDAO 物件
	private UserRegisterDAO userRegisterDAO = new UserRegisterDAOimpl();
	
	@Override
	public void addUser(String username, String password, String email) {
		try {
			// 取 Hash
			String hashSalt = HashUtil.generateSalt(); // 取得鹽
			String hashPassword = HashUtil.hashPassword(password, hashSalt);
			
			// 建立 User 物件
			// 注意 User 物件中不可以存放明碼 password 資料 (資訊安全)
			User user = new User();
			user.setUsername(username);
			user.setHashPassword(hashPassword);
			user.setHashSalt(hashSalt);
			user.setEmail(email);
			
			// 新增 user
			int rowcount = userRegisterDAO.addUser(user);
			if(rowcount < 1) {
				System.out.print("user 新增失敗");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void emailConfirmOK(String username) {
		if(username == null) {
			return;
		}
		userRegisterDAO.emailConfirmOK(username);
	}
}
