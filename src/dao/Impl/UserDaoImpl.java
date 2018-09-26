package dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.UserDao;
import domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public List<User> getUser(DetachedCriteria deta) {
		List<User> user = (List<User>) this.getHibernateTemplate().findByCriteria(deta);
		return user;
	}

	@Override
	public User getUserByID(Integer user_id) {
		User user = this.getHibernateTemplate().get(User.class, user_id);
		return user;
	}


}
