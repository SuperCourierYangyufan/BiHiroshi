package service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import dao.DynamicDao;
import domain.Dynamic;
import domain.User;
import service.DynamicService;
import utils.FileIoUtils;
import utils.oftenUtils;

public class DynamicServiceImpl implements DynamicService {
	@Resource(name="dynamicDao")
	private DynamicDao dd;

	@Override
	public void addDynamic(String uuid, String imgPath, User user, String dynamic_InputText, String dynamic_title) {
		Dynamic dynamic =new Dynamic();
		//对dynamic封装
				dynamic.setDynamic_photoPath(imgPath);
				dynamic.setDynamic_uuid(uuid);
				dynamic.setUser(user);
				//保存时间
				dynamic.setDynamic_time(oftenUtils.getTime());
				//将字符串转化成文本
				String textPath = FileIoUtils.getDynamicText();
				textPath = FileIoUtils.saveTest(dynamic_InputText, uuid, textPath);
				//清空文本&&保存文本路径
				dynamic.setDynamic_InputText(null);
				dynamic.setDynamic_textPath(textPath);
				//标题
				dynamic.setDynamic_title(dynamic_title);
				//进入dao层保存
				dd.saveDynamic(dynamic);
				
				
	}

	@Override
	public Dynamic getDynamicTest(Integer dynamic_id) {
		//获得动态类
		Dynamic dynamic = dd.getDynamic(dynamic_id);
		//获得文本地址
		String path = dynamic.getDynamic_textPath();
		
		//转化成文本集合
		List<String> textline = FileIoUtils.ReadFileTestLine(path);
		dynamic.setDynamic_list(textline);
		
		return dynamic;
	}

	@Override
	public List<Dynamic> getByUserDynamicList(DetachedCriteria deta) {
		return dd.getByUserDynamicList(deta);
	}

	@Override
	public void deleteDynamic(Integer dynamic_id) {
	 	Dynamic dynamic =  dd.getDynamic(dynamic_id);
	 	dd.deleteDynamic(dynamic);
	}

	@Override
	public Dynamic getDynamic(Integer dynamic_id) {
		Dynamic dynamic = dd.getDynamic(dynamic_id);
		List<String> readFileTestLine = FileIoUtils.ReadFileTestLine(dynamic.getDynamic_textPath());
		for(int i=0;i<readFileTestLine.size();i++){
			readFileTestLine.set(i, readFileTestLine.get(i)+"\n");
		}
		dynamic.setDynamic_list(readFileTestLine);
		return dynamic;
	}

	@Override
	public void updateDynamic(Integer dynamic_id, String dynamic_InputText, String dynamic_title, String imgPath,String dynamic_uuid) {
		//获得对象
		Dynamic dynamic = dd.getDynamic(dynamic_id);
		//判断图是否上传
		if(imgPath!=null){
			dynamic.setDynamic_photoPath(imgPath);
		}
		System.out.println(dynamic.getDynamic_id());
		//更新
		dynamic.setDynamic_time(oftenUtils.getTime());
		dynamic.setDynamic_title(dynamic_title);
		//转化文本
		String textPath = FileIoUtils.getDynamicText();
		textPath = FileIoUtils.saveTest(dynamic_InputText, dynamic_uuid, textPath);
		dynamic.setDynamic_InputText(null);
		dynamic.setDynamic_textPath(textPath);
		System.out.println(textPath);
		//更新
		dd.updateDynamic(dynamic);
		
		
	}
}
