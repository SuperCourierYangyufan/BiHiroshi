package web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Object user = ActionContext.getContext().getSession().get("user");
		if(user!=null){
			return arg0.invoke();
		}else{
			return "gologin";
		}
		
	}

}
