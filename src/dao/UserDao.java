package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.User;

//用户类的dao接口
public interface UserDao {
	//保存用户
	void saveUser(User user);
	//更新用户
	void update(User user);
	//查找用户
	List<User> getUser(DetachedCriteria deta);
	//根据id获得用户
	User getUserByID(Integer user_id);
	

}
