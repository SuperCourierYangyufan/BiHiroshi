package dao.Impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


import dao.HomeDao;
import domain.Dynamic;
import domain.Message;
import domain.User;

public class HomeDaoImpl extends HibernateDaoSupport implements HomeDao{

	@Override
	public List<Message> getMessageList(DetachedCriteria deta) {
		List<Message> MesageList = (List<Message>) this.getHibernateTemplate().findByCriteria(deta, 0, 5);
		return MesageList;
	}

	@Override
	public List<User> getListUser(DetachedCriteria deta) {
		List<User> userList = (List<User>) this.getHibernateTemplate().findByCriteria(deta,0,3);
		return userList;
	}

	@Override
	public List<Dynamic> getListDynamic(DetachedCriteria deta) {
		List<Dynamic> findByCriteria = (List<Dynamic>) this.getHibernateTemplate().findByCriteria(deta,0,4);
		return findByCriteria;
	}

	@Override
	public Integer getDynamicCount(DetachedCriteria deta) {
		//设置查询的聚合函数,总记录数
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(deta);
		return list.get(0).intValue();
	}

	@Override
	public List<Dynamic> getPageListDynamic(DetachedCriteria deta1, int i, int j) {
		List<Dynamic> findByCriteria = (List<Dynamic>) this.getHibernateTemplate().findByCriteria(deta1,i,j);
		return findByCriteria;
	}

}
