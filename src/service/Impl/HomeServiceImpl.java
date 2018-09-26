package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import dao.HomeDao;
import domain.Dynamic;
import domain.Message;
import domain.User;
import service.HomeService;
import utils.FileIoUtils;
import utils.PageBean;

public class HomeServiceImpl implements HomeService {
	@Resource(name="homeDao")
	private HomeDao hd;
	
	@Override
	public List<Message> getMessageList(DetachedCriteria deta) {
		List<Message> messageList = (List<Message>) hd.getMessageList(deta);
		for(Message mess :messageList){
			//循环将文本内容地址转成成文本
			String  messageTest = FileIoUtils.ReadFileTest(mess.getMessage_text());
			mess.setMessage_text(messageTest);
		}
		
		return messageList;
	}
	
	
	
	
	@Override
	public List<User> getListUser(DetachedCriteria deta) {
		return hd.getListUser(deta);
	}




	@Override
	public List<Dynamic> getListDynamic(DetachedCriteria deta) {
		List<Dynamic> listdynamic = hd.getListDynamic(deta);
		//因为不需要文本详细内容所以不需要你转化文本
		return listdynamic;
	}




	@Override
	public PageBean getPageBean(Integer currentPage) {
		//创建pagebean
		PageBean pagebean = new PageBean();
		//封装
		//当前页数
		pagebean.setCurrentPage(currentPage);
		//总条数
		DetachedCriteria deta = DetachedCriteria.forClass(Dynamic.class); //封装类型
		deta.setProjection(Projections.rowCount()); //获得总条数
		Integer countRecord = hd.getDynamicCount(deta);
		deta.setProjection(null);
		pagebean.setCountRecord(countRecord);
		//每页条数  封装死 6 条
		pagebean.setCurrentRecord(6);
		//总页数
		Integer countPage  = (pagebean.getCountRecord()%6==0)?pagebean.getCountRecord()/6:pagebean.getCountRecord()/6+1;
		pagebean.setCountPage(countPage);
		if(countPage<currentPage){
			currentPage=countPage;
			pagebean.setCurrentPage(currentPage);
		}
		//数据
		deta.addOrder(Order.desc("dynamic_id"));
		List<Dynamic> listDynamic = hd.getPageListDynamic(deta,(pagebean.getCurrentPage()-1)*6,6);
		pagebean.setListDynamic(listDynamic);
		
		
		
		
		
		return pagebean;
	}

}
