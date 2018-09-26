package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Dynamic;
import domain.Message;
import domain.User;


public interface HomeDao {
	
	//获得留言
	List<Message> getMessageList(DetachedCriteria deta);
	
	//用户
	List<User> getListUser(DetachedCriteria deta);
	
	//获得留言 1-4
	List<Dynamic> getListDynamic(DetachedCriteria deta);
	
	//获得总数
	Integer getDynamicCount(DetachedCriteria deta);
	
	//获得当前页的内容
	List<Dynamic> getPageListDynamic(DetachedCriteria deta1, int i, int j);
	

}
