package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Dynamic;
import domain.Message;
import domain.User;
import utils.PageBean;

public interface HomeService {
	
	//获得留言
	List<Message> getMessageList(DetachedCriteria deta);
	
	//用户
	List<User> getListUser(DetachedCriteria deta);
	
	//动态
	List<Dynamic> getListDynamic(DetachedCriteria deta);
	
	//分页
	PageBean getPageBean(Integer currentPage);

}
