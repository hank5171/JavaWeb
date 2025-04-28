package cart.service;

public interface UserRegisterService {
	
	// 新增 user
	void addUser(String username, String password, String email );
	
	
	// email 驗證成功
	void emailConfirmOK(String username);
	
}
