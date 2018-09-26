package domain;

import java.util.ArrayList;
import java.util.List;

public class Dynamic {
	private Integer dynamic_id;
	//输入文本
	private String dynamic_InputText;
	private String dynamic_uuid;
	//文本的地址
	private String dynamic_textPath;
	//标题
	private String dynamic_title;
	//图片的地址
	private String dynamic_photoPath;
	
	private String dynamic_time;
	
	private List<String> dynamic_list = new ArrayList<String>();
	
	
	private User user;

	public Integer getDynamic_id() {
		return dynamic_id;
	}

	public void setDynamic_id(Integer dynamic_id) {
		this.dynamic_id = dynamic_id;
	}

	public String getDynamic_InputText() {
		return dynamic_InputText;
	}

	public void setDynamic_InputText(String dynamic_InputText) {
		this.dynamic_InputText = dynamic_InputText;
	}

	public String getDynamic_uuid() {
		return dynamic_uuid;
	}

	public void setDynamic_uuid(String dynamic_uuid) {
		this.dynamic_uuid = dynamic_uuid;
	}

	public String getDynamic_textPath() {
		return dynamic_textPath;
	}

	public void setDynamic_textPath(String dynamic_textPath) {
		this.dynamic_textPath = dynamic_textPath;
	}

	public String getDynamic_title() {
		return dynamic_title;
	}

	public void setDynamic_title(String dynamic_title) {
		this.dynamic_title = dynamic_title;
	}

	public String getDynamic_photoPath() {
		return dynamic_photoPath;
	}

	public void setDynamic_photoPath(String dynamic_photoPath) {
		this.dynamic_photoPath = dynamic_photoPath;
	}

	public String getDynamic_time() {
		return dynamic_time;
	}

	public void setDynamic_time(String dynamic_time) {
		this.dynamic_time = dynamic_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getDynamic_list() {
		return dynamic_list;
	}

	public void setDynamic_list(List<String> dynamic_list) {
		this.dynamic_list = dynamic_list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
