package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.User;

//用户模块接口
public interface UserService {
	
	//保存新注册的用户
	void saveUser(User user);
	
	//判断激活
	boolean saveState(User user, Integer code);
	
	//登入 并返回用户 方便存入session
	User getUserLogin(DetachedCriteria deta, String user_password);
	
	//注册时检查用户是否重名
	boolean checkUsername(DetachedCriteria deta);
	
	//更新用户
	User updateUser(User user, String imgPath);
	
	



}
