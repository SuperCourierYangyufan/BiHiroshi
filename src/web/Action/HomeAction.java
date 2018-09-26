package web.Action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Dynamic;
import domain.Message;
import domain.User;
import service.HomeService;
import utils.PageBean;

public class HomeAction extends ActionSupport{
	@Resource(name="homeService")
	private HomeService hs;
	private Integer currentPage;
	
	
	
	//得到初始页面所有信息 逐步开发
	public String homeList() throws Exception {
		//留言模块
		DetachedCriteria deta = DetachedCriteria.forClass(Message.class);
		deta.addOrder(Order.desc("message_id"));
		List<Message> messageList = hs.getMessageList(deta);
		//用户
		deta = DetachedCriteria.forClass(User.class);
		deta.add(Restrictions.eq("user_state", 2));
		deta.addOrder(Order.desc("user_id"));
		List<User> userlist = hs.getListUser(deta);
		//动态
		deta = DetachedCriteria.forClass(Dynamic.class);
		deta.addOrder(Order.desc("dynamic_id"));
		List<Dynamic> dynamiclist = hs.getListDynamic(deta);
		
		//存入域
		ActionContext.getContext().getSession().put("messageList", messageList);
		ActionContext.getContext().getSession().put("userList", userlist);
		ActionContext.getContext().getSession().put("dynamiclist", dynamiclist);
		return "toindex";
	}
	
	
	
	public String pageDynamic() throws Exception {
		//获得页数
		if(currentPage==null){
			//初始默认
			currentPage=1;
		}
		if(currentPage.equals(0)){
			currentPage=1;
		}
		
		//进行分页操作
		PageBean pagebean = hs.getPageBean(currentPage);
		//存入
		ActionContext.getContext().put("pagebean", pagebean);
		return "topage";
	}

	
	
	
	
	
	
	
	
	
	


	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
