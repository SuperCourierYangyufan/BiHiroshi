package web.Action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Dynamic;
import domain.User;
import service.DynamicService;
import utils.FileIoUtils;
import utils.oftenUtils;

public class DynamicAction extends ActionSupport {
	private String dynamic_title;
	private String  dynamic_InputText;
	private String  dynamic_uuid;
	private Integer dynamic_id;
	private File photoFile;
	@Resource(name="dynamicService")
	private DynamicService ds;
	//添加动态
	public String add() throws Exception {
		//给予UUid
		String uuid = oftenUtils.getUUID();
		//图片存储地址
		String imgPath = null;
		if(photoFile!=null){
		 	imgPath = FileIoUtils.getPortraitgeFile()+uuid+".jpg";
			photoFile.renameTo(new File(imgPath));
			imgPath=uuid+".jpg";
		}
		
		
		
		
		//session获得用户信息
		User user = (User) ActionContext.getContext().getSession().get("user");
		ds.addDynamic(uuid,imgPath,user,dynamic_InputText,dynamic_title);
		
		return "toDynamicList";
	}

	
	public String toDynamic() throws Exception {
		//从session获得user
		User user = (User) ActionContext.getContext().getSession().get("user");
		//封装deta
		DetachedCriteria deta = DetachedCriteria.forClass(Dynamic.class);
		deta.add(Restrictions.eq("user.user_id", user.getUser_id()));
		List<Dynamic> dynamicList = ds.getByUserDynamicList(deta);
		
		//转发
		ActionContext.getContext().put("dynamicList", dynamicList);
		return "toDynamictable";
	}
	
	public String showDynamic() throws Exception {
		//获得动态id 
		//查询并返回title 与 文本集合
		Dynamic dynamic =  ds.getDynamicTest(dynamic_id);
		//转发
		
		ActionContext.getContext().put("dynamic", dynamic);
		return "toshow";
	}


	public String deleteDynamic() throws Exception {
		//获得id传入service
		ds.deleteDynamic(dynamic_id);
		return "deletetolist";
	}
	
	public String updateDynamic() throws Exception {
		//获得id传入service
		Dynamic dynamic = ds.getDynamic(dynamic_id);
		ActionContext.getContext().put("dynamic", dynamic);
		return "toupdate";
	}
	
	public String toupdateDynamic() throws Exception {
		String imgPath = null;
		if(photoFile!=null){
		 	imgPath = FileIoUtils.getPortraitgeFile()+dynamic_uuid+".jpg";
			photoFile.renameTo(new File(imgPath));
			imgPath=dynamic_uuid+".jpg";
		}
		
		
		
		
		
		//获得 值
		ds.updateDynamic(dynamic_id,dynamic_InputText,dynamic_title,imgPath,dynamic_uuid);
		return "toupdatefordynamic";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getDynamic_title() {
		return dynamic_title;
	}

	public void setDynamic_title(String dynamic_title) {
		this.dynamic_title = dynamic_title;
	}



	public String getDynamic_InputText() {
		return dynamic_InputText;
	}

	public void setDynamic_InputText(String dynamic_InputText) {
		this.dynamic_InputText = dynamic_InputText;
	}



	public File getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}


	public Integer getDynamic_id() {
		return dynamic_id;
	}


	public void setDynamic_id(Integer dynamic_id) {
		this.dynamic_id = dynamic_id;
	}


	public String getDynamic_uuid() {
		return dynamic_uuid;
	}


	public void setDynamic_uuid(String dynamic_uuid) {
		this.dynamic_uuid = dynamic_uuid;
	}

	
}
