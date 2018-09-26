package service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import domain.Dynamic;
import domain.User;

public interface DynamicService {
	
	
	//添加动态
	void addDynamic(String uuid, String imgPath, User user, String dynamic_InputText, String dynamic_title);
	
	
	//获得动态信息and标题
	Dynamic getDynamicTest(Integer dynamic_id);


	List<Dynamic> getByUserDynamicList(DetachedCriteria deta);

	//删除对象
	void deleteDynamic(Integer dynamic_id);

	//根据id获得对象
	Dynamic getDynamic(Integer dynamic_id);

	//更新
	void updateDynamic(Integer dynamic_id, String dynamic_InputText, String dynamic_title, String imgPath, String dynamic_uuid);

}
