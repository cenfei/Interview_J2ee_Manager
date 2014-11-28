package com.ddm.interview.IapUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class GetSession {

	public static HttpSession getSession() {
		ActionContext ctx = ActionContext.getContext();

		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		
		HttpSession session=request.getSession();
		return session;
	}
}
