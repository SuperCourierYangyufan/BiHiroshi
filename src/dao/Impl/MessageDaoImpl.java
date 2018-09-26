package dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import dao.MessageDao;
import domain.Message;

public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao{

	@Override
	public void saveMessage(Message message) {
		this.getHibernateTemplate().save(message);
	}
	
	@Override
	public List<Message> selectMessageList() {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Message>>() {

			@Override
			public List<Message> doInHibernate(Session session) throws HibernateException {
				String hql = "from Message";
				Query query = session.createQuery(hql);
				List<Message> list = query.list();
				session.close();
				return list;
			}
		});
	}

	@Override
	public Message getMessaeById(Integer message_id) {
		Message message = this.getHibernateTemplate().get(Message.class, message_id);
		return message;
	}

	@Override
	public void deleteMessae(Message ms) {
		this.getHibernateTemplate().delete(ms);
	}

	@Override
	public void updateMessage(Message message) {
		this.getHibernateTemplate().update(message);
	}

}
