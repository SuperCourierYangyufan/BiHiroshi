package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Message;
import domain.User;

public interface MessageService {
	//添加留言
	void saveMessage(User user, Message message);
	
	//查询所有留言
	List<Message> selectMessageList();
	
	//删除用户
	void deleteMessage(Message message);
	
	//得到一个留言
	Message getMessage(Message message);
	
	//更新用户留言
	void updateMessage(Message message, User user);

}
