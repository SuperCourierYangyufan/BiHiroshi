package web.Action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Message;
import domain.User;
import service.MessageService;

public class MessageAction extends ActionSupport implements ModelDriven<Message>{
	private Message message = new Message();
	@Resource(name="messageService")
	private MessageService ms;
	
	//添加留言
	public String add() throws Exception {
		//获得值并将从session获得user
		User user = (User) ActionContext.getContext().getSession().get("user");
		//传入service
		ms.saveMessage(user,message);
		//转发到留言列表
		return "toMessageList";
	}
	
	//留言列表
	public String messagelist() throws Exception {
		//直接查询所有留言
		List<Message> listmessage = ms.selectMessageList();
		//将所有信息转发至留言页面
		ActionContext.getContext().put("listmessage", listmessage);
		return "MessageList";
	}
	
	//删除用户
	public String deleteMessage() throws Exception {
		//将得到的id放入service
		ms.deleteMessage(message);
		//冲定向到留言列表
		return "deleteMessageList";
	}
	
	//得到留言
	public String getMessage() throws Exception {
		//将得带的id放入service
		Message getmessage = ms.getMessage(message);
		ActionContext.getContext().put("message", getmessage);
		return "getMessageToUpdate";
	}
	
	//更新用户
	public String updateMessage() throws Exception {
		//获得 uuid test user 
		User user = (User) ActionContext.getContext().getSession().get("user");
		ms.updateMessage(message,user);
		return "updateMessageToList";
	}
	
	

	@Override
	public Message getModel() {
		// TODO 自动生成的方法存根
		return message;
	}
	
	
}
