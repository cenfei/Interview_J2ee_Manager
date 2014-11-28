package com.ddm.interview.IapUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



public class AutheticationFilter implements Filter {

	private Logger log = Logger.getLogger(AutheticationFilter.class);

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		String suffix = url.substring(url.indexOf(".") + 1);

		
		log.info("hello  url=" + url);
		// 手机端直接跳过 有自己的过滤器
		if (url.contains(".action")) {

			log.info("**************" + url);
		}
		if(!url.contains(".action")&&!url.contains("/release.jsp")&&!url.contains("/resetpassword.jsp")&&!url.contains("/selfdetail.jsp")){
			chain.doFilter(request, response);
			return;
			
		}
		

		String redirectPage = request.getContextPath() + "/Jsp/signin/weixinLogin.jsp";

		String redirectAuthPage = request.getContextPath() + "/Jsp/signin/authpage.jsp";
		
//		Accountinfo accountinfo=AllStaticParams.accountinfo;
//		String managerName=AllStaticParams.mangerName;
		
		
//		Accountinfo accountinfo=	(Accountinfo) request.getSession(true).getAttribute("accountinfo");
		String managerName=(String) request.getSession(true).getAttribute("managerinfo");
		if(managerName!=null){
			
			chain.doFilter(request, response);
			return;
		}
		
		
		
//		if(url.contains("/resetpassword.jsp")||url.contains("/release.jsp")){
			
//		}
		
		
		
		if (url.contains("/login.jsp")|| url.contains("/Sendlogin.jsp")
				|| url.contains("/images")
			
				|| url.contains("/loginManger.action")
				|| url.contains("boolLogin.action")
				|| url.contains("/registrAccount.action")
				|| url.contains("/sendPhoneTestCode.action")
				|| url.contains("/blindPhoneNum.action")
				
				|| url.contains("/uploadHeadpic.action")
				|| url.contains("findOpenId.action")
				|| url.contains("/loginAccount.action")
				|| url.contains("/findAccountInfo.action")
				|| url.contains("/changeAccountInfo.action")
				|| url.contains("/upAccountInfo.action")
				
				
				|| url.contains("/loginByMomentTestCode.action")
		) {
			chain.doFilter(request, response);
			return;
		}
		/**
		 * 第一步：判断session中的对象是否为null,如果是，则直接跳到登录页
		 */


//		if (accountinfo == null) {
//			response.sendRedirect(redirectPage);
//
//			return;
//			}
//			else if((accountinfo!=null&&accountinfo.getStatus().equals("1"))){
//				if(!(url.contains("/resetpassword.jsp")&&url.contains("/selfdetail.jsp")))
//				
//				response.sendRedirect(redirectAuthPage);
//
//				return;
//				
//			}
		//通过session中的  意向参数 判断该用户是否可以访问所有客户意向信息  人员包括（zl/andy/justin/bulaiman）
//		Short type=managerinfo.getAuthority();
//		
//		if(intentVal!=null&&intentVal.equals("1")){
//			if(url.contains(".action"))
//			{
//				
//				if (url.contains("/sysfindCustomerList.action")||url.contains("/sysfindSingleCustomerVisit.action")) {
//					// 说明正常访问
//					chain.doFilter(request, response);
//					return;
//				}
//
//				
//			}
//			
//			
//		}
		
		
		
//		Integer type = managerinfo.getUserType();
		/**
		 * 当type=0的时候是普通销售人员，只能访问指定的action
		 * findCustomerList.action/addCustomerInfo
		 * .action/sysfindSingleCustomerVisit.action
		 * toCustomerVisit.action/addCustomerVisitInfo.action
		 * 
		 * 
		 * 当type=1时团队长 在一的基础上有
		 * crew_findCustomerList.action/findCrewCustomerVisitList.action
		 * 
		 * 当type=2时
		 * 有sysfindCustomerList.action/sysfindSingleCustomerVisit.action
		 * 
		 * 当type=3时
		 * kefu_findCustomerList.action/kefu_findSingleCustomerVisit.action
		 * 当type=4时 qiantai_findSingleCustomerVisit.action/
		 */
		
//		
//		if (url.contains(".action")) {
//		
//			
//			
//			
//			
//			
//			
//			switch (type) {
//			case 0:
//				if (url.contains("/entryMedicalInfo.action")||
//						url.contains("/changeMedicalInfo.action")||
//						url.contains("/checkSingleEntryinfo.action")
//						||
//						url.contains("/checkTheUserEntryInfo.action")
//						||
//						url.contains("/checkChangeTheUserEntryInfo.action")
//							||
//						url.contains("/checkChangeSingleEntryinfo.action")
//					||	url.contains("/UnsaveCheckSingleEntryinfo.action")
//							||
//						url.contains("/UnsaveCheckSingleEntryinfo.action")
//						
//						) {
//					// 说明正常访问
//					chain.doFilter(request, response);
//					return;
//				}
//
//				break;
//			case 1:
//				if (url.contains("/checkAllEntryinfo.action")
//						||url.contains("/checkSingleEntryinfo.action")
//						) {
//					// 说明正常访问
//					chain.doFilter(request, response);
//					return;
//				}
//				break;
//			case 2:
//				if (url.contains("/entryMedicalInfo.action")||
//						url.contains("/changeMedicalInfo.action")||
//						url.contains("/checkSingleEntryinfo.action")
//						||
//						url.contains("/checkAllEntryinfo.action")
//						||
//						url.contains("/checkChangeAllEntryinfo.action")
//							||
//						url.contains("/checkChangeSingleEntryinfo.action")
//					||	url.contains("/UnSavecheckAllEntryinfo.action")
//							||
//						url.contains("/UnSavecheckAllEntryinfo.action")
//						) {
//					// 说明正常访问
//					chain.doFilter(request, response);
//					return;
//				}
//				break;
//			
//
//			default:
//				break;
//			}
//
//			response.sendRedirect(redirectPage);
//			return;
//		}

		// 此通道是为后台操作留的接口 -- 续探讨探讨
		// if ( url.contains("/common/")||url.contains("/css/") )
		// {
		// chain.doFilter(request, response);
		// return;
		// }

		// 普通页面过滤

		// //静态文件放行
		// if(!url.endsWith(".jsp")&&!url.endsWith(".action") &&
		// !url.endsWith("/"))
		// {
		// chain.doFilter(request, response);
		// return;
		// }
		//
		//
		// response.sendRedirect(request.getContextPath() +
		// "/security/fillup_information.jsp");
		//
		// }
		// }
		chain.doFilter(request, response);
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
