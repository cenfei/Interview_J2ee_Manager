package com.ddm.interview.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ddm.interview.IapUtil.MyStringUtils;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.pojo.QuestionHome;
import com.ddm.interview.service.QuestionHomeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @类名：SearchQuestionHomeAction.java
 * 
 * @功能说明：面试题列表
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
public class SearchQuestionHomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(SearchQuestionHomeAction.class);

	private QuestionHomeService questionHomeService;
	private PagerModel<QuestionHome> pm;
	private String nowPageOffet;

	private QuestionHome questionHome;
	private String superUrl;

	private String headPicUrl;

	public String indexInit() {

		return "success";
	}

	/**
	 * 
	 * 
	 * @功能说明：保存新闻
	 * 
	 * @返回类型：String
	 */
	public String saveSuperInfo() {

		try {

			if (MyStringUtils.isNotNullAndEmpty(questionHome)
					&& MyStringUtils.isNotNullAndEmpty(questionHome
							.getQueContent())) {

				questionHome.setQuePublishTime(new Date());
				// checkTitleUnqiue截取问题的前50个字符
				String contentQueString = questionHome.getQueContent();
				String checkTitleUnqiue = contentQueString.length() > 50 ? contentQueString
						.substring(0, 50) : contentQueString;
				questionHome.setCheckTitleUnqiue(checkTitleUnqiue);
				questionHomeService.save(questionHome);

			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	public String getNowPageOffet() {
		return nowPageOffet;
	}

	public void setNowPageOffet(String nowPageOffet) {
		this.nowPageOffet = nowPageOffet;
	}

	/**
	 * 
	 * 
	 * @功能说明：删除新闻
	 * 
	 * @返回类型：String
	 */
	public String deleteSuperInfo() {

		try {
			//
			// if (MyStringUtils.isNotNullAndEmpty(QuestionHome)) {
			// QuestionHomeService.delete(QuestionHome);
			// }
		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	/**
	 * 
	 * 
	 * @功能说明：更新新闻
	 * 
	 * @返回类型：String
	 */
	public String updateSuperInfo() {

		try {
			// QuestionHome.setPicUrlArray(superUrl.toString());
			//
			// QuestionHome.setPicUrl(headPicUrl);
			// if (MyStringUtils.isNotNullAndEmpty(QuestionHome)) {
			// QuestionHome.setCreateTimeDate(new Date());
			// QuestionHomeService.update(QuestionHome);
			// }
		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	/**
	 * 
	 * 
	 * @功能说明：查看新闻
	 * 
	 * @返回类型：String
	 */
	private List<String> picList = new ArrayList<String>();

	public String selectSuperInfo() {

		try {
			// if (MyStringUtils.isNotNullAndEmpty(QuestionHome)) {
			// QuestionHome =
			// QuestionHomeService.findById(QuestionHome.getId());
			// String picArrayStr = QuestionHome.getPicUrlArray();
			// String[] picArray = picArrayStr.split(",");
			// for (String pic : picArray) {
			//
			// picList.add(pic);
			// }
			//
			// }
		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	/**
	 * 
	 * 
	 * @功能说明：查找参加该活动的人员列表
	 * 
	 * @返回类型：String
	 */
	public String findQuestionHomeList() {

		try {

			// Pager pager = null;
			//
			// pager = new Pager();
			// if (nowPageOffet != null && !nowPageOffet.equals("")) {
			// Integer pageSize = 10;
			// Integer pageOffet = pageSize
			// * (Integer.valueOf(nowPageOffet) - 1);
			// pager.setOffset(pageOffet.toString());
			// pager.setPageSize(pageSize.toString());
			// }
			//
			// setPm(QuestionHomeService.getQuestionHomeBySelectSql(null,
			// pager));

		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	public void setPm(PagerModel<QuestionHome> pm) {
		this.pm = pm;
	}

	public PagerModel<QuestionHome> getPm() {
		return pm;
	}

	public void setSuperUrl(String superUrl) {
		this.superUrl = superUrl;
	}

	public String getSuperUrl() {
		return superUrl;
	}

	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}

	public String getHeadPicUrl() {
		return headPicUrl;
	}

	public void setPicList(List<String> picList) {
		this.picList = picList;
	}

	public List<String> getPicList() {
		return picList;
	}

	/**
	 * @return the questionHomeService
	 */
	public QuestionHomeService getQuestionHomeService() {
		return questionHomeService;
	}

	/**
	 * @param questionHomeService
	 *            the questionHomeService to set
	 */
	public void setQuestionHomeService(QuestionHomeService questionHomeService) {
		this.questionHomeService = questionHomeService;
	}

	/**
	 * @return the questionHome
	 */
	public QuestionHome getQuestionHome() {
		return questionHome;
	}

	/**
	 * @param questionHome
	 *            the questionHome to set
	 */
	public void setQuestionHome(QuestionHome questionHome) {
		this.questionHome = questionHome;
	}

}
