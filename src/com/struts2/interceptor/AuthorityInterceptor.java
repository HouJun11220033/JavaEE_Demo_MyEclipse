package com.struts2.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ac = ai.getInvocationContext();
		Map session = ac.getSession();
		String user = (String) session.get("user");
		if (user != null && user.equals("root")) {
			return ai.invoke();
		}
		ac.put("tip", "如果你没有登陆，请先登录！");
		return Action.LOGIN;

	}

}
