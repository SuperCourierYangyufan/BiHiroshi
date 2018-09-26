package dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.DynamicDao;
import domain.Dynamic;

public class DynamicDaoImpl extends HibernateDaoSupport implements DynamicDao {

	@Override
	public void saveDynamic(Dynamic dynamic) {
		this.getSessionFactory().getCurrentSession().save(dynamic);
	}

	@Override
	public List<Dynamic> getByUserDynamicList(DetachedCriteria deta) {
		List<Dynamic> listDynamic = (List<Dynamic>) this.getHibernateTemplate().findByCriteria(deta);
		return listDynamic;
	}

	@Override
	public Dynamic getDynamic(Integer dynamic_id) {
		Dynamic dynamic = this.getHibernateTemplate().get(Dynamic.class, dynamic_id);
		return dynamic;
	}

	@Override
	public void deleteDynamic(Dynamic dynamic) {
		this.getHibernateTemplate().delete(dynamic);
	}

	@Override
	public void updateDynamic(Dynamic dynamic) {
		this.getHibernateTemplate().update(dynamic);
		
	}

}
