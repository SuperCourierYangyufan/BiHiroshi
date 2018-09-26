package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Message;

public interface MessageDao {
	//保存留言
	void saveMessage(Message message);
	
	//查询留言列表
	List<Message> selectMessageList();
	
	//根据id获得对象
	Message getMessaeById(Integer message_id);
	
	//删除对象
	void deleteMessae(Message ms);
	
	//更新留言
	void updateMessage(Message message);
	
}
