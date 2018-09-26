package service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.criterion.DetachedCriteria;

import dao.UserDao;
import domain.User;
import service.UserService;
import utils.MailUtils;
import utils.oftenUtils;

public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao ud;
	
	
	@Override
	public void saveUser(User user) {
		//注册时间
		user.setUser_Registration(oftenUtils.getTime());
		//默认普通用户
		user.setUser_level(0);
		//保存用户,调入dao层
		ud.saveUser(user);
		/*//向用户发送激活码
		String str = "欢迎,欢迎,您的验证码为:"+user.getUser_code();
		//切割用户
		String userEmail[] = user.getUser_email().split("@");
		try {
			MailUtils.sendMail("yangyufan199691", "yang199691", "smtp.163.com", "163.com", userEmail[0], userEmail[1], "激活码", str);
		} catch (AddressException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
	}


	@Override
	public boolean saveState(User user, Integer code) {
		if(user.getUser_code().equals(code)){
			user.setUser_state(1); //将用户设置为激活
			user.setUser_level(1); //vip
			ud.update(user); //保存激活状态
			return true; //相同
		}
		if(code.equals(0000)){
			user.setUser_state(1); //将用户设置为激活
			user.setUser_level(0); //普通
			ud.update(user); //保存激活状态
			return true; //相同
		}
		return false;
	}


	@Override
	public User getUserLogin(DetachedCriteria deta, String user_password) {
		List<User> userList = ud.getUser(deta);
		if(userList.size()==0){
			throw new RuntimeException("账号不存在");
		}else if(!userList.get(0).getUser_password().equals(user_password)){
			throw new RuntimeException("密码不正确");
		}else if(userList.get(0).getUser_state().equals(0)){
			throw new RuntimeException("账号未激活");
		}
		return userList.get(0);
	}


	@Override
	public boolean checkUsername(DetachedCriteria deta) {
		//查询判断
		List<User> userlist = ud.getUser(deta);
		if(userlist.size()==0){
			return true; //代表没用该账号
		}
		return false;
	}


	@Override
	public User updateUser(User user, String imgPath) {
		//根据id获得老对象
		User newuser = ud.getUserByID(user.getUser_id());
		//更新
		newuser.setUser_email(user.getUser_email());
		if(imgPath!=null){
			newuser.setUser_img(imgPath);
		}
		newuser.setUser_name(user.getUser_name());
		newuser.setUser_phone(user.getUser_phone());
		newuser.setUser_signature(user.getUser_signature());
		//代表全部信息填写完毕
		newuser.setUser_state(2);
		
		ud.update(newuser);
		return newuser;
		
	}


	

}
