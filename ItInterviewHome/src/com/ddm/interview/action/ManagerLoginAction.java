package com.ddm.interview.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ddm.interview.IapUtil.GetSession;
import com.ddm.interview.IapUtil.MyStringUtils;
import com.ddm.interview.IapUtil.UploadUtil;
import com.ddm.interview.IapUtil.WebvarPropertyUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @类名：AccountInfoAction.java
 * 
 * @功能说明：账号信息管理
 * 
 * @创建人： foxcen
 * 
 * @创建日期： #build 2013-12-22 -0
 * 
 * @修改人： foxcen
 * 
 * @修改日期： #change 2013-12-22 -0
 * 
 * @版本号：1.00
 */
public class ManagerLoginAction extends ActionSupport {

	private Logger log = Logger.getLogger(ManagerLoginAction.class);

	private String userName;
	private String passWord;

	/**
	 * 
	 * 
	 * @功能说明：上传头像
	 * 
	 * @返回类型：String
	 */
	// 上传图片
	private File tfile;

	private String tfileFileName;

	public String uploadPic() {

		System.out.println("tfileFileName=" + tfileFileName);

		String root = "UploadHeadPic";

		String filename = UploadUtil.upload(tfile, root, tfileFileName);
		// filename是新建目录下的新文件名（将上传的文件的流写入了filename文件中）

		// 测试代码
		System.out.println("new  filename=" + filename);
		// resultFileName=filename;
		if (!filename.equals("")) {
			String resultFileName = root + "/" + filename;
			HttpServletResponse response = ServletActionContext.getResponse();
			try {
				response.getWriter().println(resultFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return Action.NONE;
		} else {
			return INPUT;
		}

	}

	/**
	 * 
	 * 
	 * @功能说明：管理员登陆
	 * 
	 * @返回类型：String
	 */
	public String loginManger() {
		String isSuccess = "faild";
		try {
			if (MyStringUtils.isNotNullAndEmpty(userName)
					&& MyStringUtils.isNotNullAndEmpty(passWord)) {

				String pwd = WebvarPropertyUtil.getValueByKey(userName);
				if (pwd.equals(passWord)) {

					isSuccess = "success";
					GetSession.getSession().setAttribute("managerinfo",
							userName);
					// AllStaticParams.mangerName=userName;
					// GetSession.getSession().setAttribute("accountinfo", new
					// Accountinfo());
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
		}

		return isSuccess;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public File getTfile() {
		return tfile;
	}

	public void setTfile(File tfile) {
		this.tfile = tfile;
	}

	public String getTfileFileName() {
		return tfileFileName;
	}

	public void setTfileFileName(String tfileFileName) {
		this.tfileFileName = tfileFileName;
	}
}
