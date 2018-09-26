package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Dynamic;

public interface DynamicDao {
	
	//添加留言
	void saveDynamic(Dynamic dynamic);
	
	
	//获得动态列表
	List<Dynamic> getByUserDynamicList(DetachedCriteria deta);

	//获得dynamic对象
	Dynamic getDynamic(Integer dynamic_id);


	//删除对象
	void deleteDynamic(Dynamic dynamic);

	//更新
	void updateDynamic(Dynamic dynamic);

}
