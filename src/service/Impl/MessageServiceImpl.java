package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import dao.MessageDao;
import domain.Message;
import domain.User;
import service.MessageService;
import utils.FileIoUtils;
import utils.oftenUtils;

public class MessageServiceImpl implements MessageService {
	@Resource(name="messageDao")
	private MessageDao md;
	
	@Override
	public void saveMessage(User user, Message message) {
		//uuid
		String uuid = oftenUtils.getUUID();
		//将字符串转化成文本
		String filePath = FileIoUtils.saveTest(message.getMessage_text(), uuid,FileIoUtils.getMessageFile());
		//将文本清空
		message.setMessage_text(filePath);
		message.setMessage_uuid(uuid);
		//封装当前时间
		message.setMessage_time(oftenUtils.getTime());
		//user
		message.setUser(user);
		
		//传入dao保存
		md.saveMessage(message);
		
		
	}

	@Override
	public List<Message> selectMessageList() {
		List<Message> selectMessageList = md.selectMessageList();
		for(Message mess :selectMessageList){
			//循环将文本内容地址转成成文本
			String messageTest = FileIoUtils.ReadFileTest(mess.getMessage_text());
			mess.setMessage_text(messageTest);
		}
		return selectMessageList;
	}

	@Override
	public void deleteMessage(Message message) {
		//获得对象
		Message ms = md.getMessaeById(message.getMessage_id());
		//删除对象
		md.deleteMessae(ms);
	}

	@Override
	public Message getMessage(Message message) {
		Message mess = md.getMessaeById(message.getMessage_id());
		String messageTest = FileIoUtils.ReadFileTest(mess.getMessage_text());
		mess.setMessage_text(messageTest);
		return mess;
	}

	@Override
	public void updateMessage(Message message1, User user) {
		Message message = md.getMessaeById(message1.getMessage_id());
		//将字符串转化成文本
		String filePath = FileIoUtils.saveTest(message1.getMessage_text(), message.getMessage_uuid(),FileIoUtils.getMessageFile());
		//
		message.setMessage_text(filePath);
		//更新用户
		message.setUser(user);
		//更新更改时间
		message.setMessage_time(oftenUtils.getTime());
		
		//传入dao层保存
		md.updateMessage(message);
	}

}
