package web.Action;

import java.io.File;
import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;
import service.UserService;
import utils.FileIoUtils;
import utils.oftenUtils;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	@Resource(name="userService")
	private UserService us;
	private Integer code;
	private File portrait;
	
	
	
	
	public String add() throws Exception {
		//封装为获得隐藏参数
			//1激活码
			Integer code = (int) ((Math.random()+1)*1000);
			user.setUser_code(code);;
			//未激活状态
			user.setUser_state(0);
		//将获得的user注册对象传入service
			us.saveUser(user);
		//转发
			ActionContext.getContext().getSession().put("user", user);
		return "add";
	}
	
	//激活
	public String code() throws Exception {
		//获得用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		boolean ExCode =  us.saveState(user,code);
		if(ExCode)
			return "tologin";
		else{
			 ActionContext.getContext().getSession().put("error", "激活码错误");
			return "errorCode";
		}
			
	}
	
	//登入
	public String login() throws Exception {
		//获得提交的用户,给予service
		DetachedCriteria deta = DetachedCriteria.forClass(User.class);
		deta.add(Restrictions.eq("user_Username", user.getUser_Username()));
		User loginUser =  us.getUserLogin(deta,user.getUser_password());
		//存入用户至session
		ActionContext.getContext().getSession().put("user", loginUser);
		return "success";
	}
	
	public String checkUsername() throws Exception {
		//获得用户名  封装查询条件
		DetachedCriteria deta = DetachedCriteria.forClass(User.class);
		deta.add(Restrictions.eq("user_Username",  user.getUser_Username()));
		boolean isExist = us.checkUsername(deta);
		//JSON
		String json = "{\"isExist\":"+isExist+"}" ;   //"{\"isExist\":"+isExist+"}";
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	//修改用户信息
	public String updateUsername() throws Exception {
		String uuid = null;
		String imgPath = null;
		if(portrait!=null){
			uuid = oftenUtils.getUUID();
		 	imgPath = FileIoUtils.getPortraitgeFile()+uuid+".jpg";
			portrait.renameTo(new File(imgPath));
			imgPath=uuid+".jpg";
		}
		System.out.println(user.getUser_id());
		User newuser =  us.updateUser(user,imgPath);
		//将新的user放入session
		ActionContext.getContext().getSession().put("user", newuser);
		return "toUser";
	}
	
	
	public String tologin() throws Exception {
		return "tousered";
	}
	
	public String gologin() throws Exception {
		return "gologin";
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return user;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public File getPortrait() {
		return portrait;
	}

	public void setPortrait(File portrait) {
		this.portrait = portrait;
	}
	
	
}
