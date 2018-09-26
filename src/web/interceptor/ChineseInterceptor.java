package web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import domain.User;

public class ChineseInterceptor extends MethodFilterInterceptor  {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//解决中文乱码
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		return arg0.invoke();
	}

}
