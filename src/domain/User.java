package domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer user_id;
	private String user_Username;
	private String user_password;
	private String user_phone;
	private String user_email;
	private Integer user_state;
	private Integer user_code; 
	private Set<Message> message = new HashSet<Message>();
	private Set<Dynamic> dynamic = new HashSet<Dynamic>();

	private String user_signature; //签名
	private String user_Registration; //注册时间
	private Integer user_level; //级别
	private String user_img; //头像图片路径
	private	 String user_name; //昵称
	
	
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_Username() {
		return user_Username;
	}
	public void setUser_Username(String user_Username) {
		this.user_Username = user_Username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Integer getUser_state() {
		return user_state;
	}
	public void setUser_state(Integer user_state) {
		this.user_state = user_state;
	}
	public Integer getUser_code() {
		return user_code;
	}
	public void setUser_code(Integer user_code) {
		this.user_code = user_code;
	}
	public Set<Message> getMessage() {
		return message;
	}
	public void setMessage(Set<Message> message) {
		this.message = message;
	}
	public String getUser_signature() {
		return user_signature;
	}
	public void setUser_signature(String user_signature) {
		this.user_signature = user_signature;
	}
	public String getUser_Registration() {
		return user_Registration;
	}
	public void setUser_Registration(String user_Registration) {
		this.user_Registration = user_Registration;
	}
	public Integer getUser_level() {
		return user_level;
	}
	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Set<Dynamic> getDynamic() {
		return dynamic;
	}
	public void setDynamic(Set<Dynamic> dynamic) {
		this.dynamic = dynamic;
	}
	
	
	
	
	
	
	
}
