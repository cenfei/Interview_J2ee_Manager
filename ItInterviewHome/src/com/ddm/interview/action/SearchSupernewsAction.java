package com.ddm.interview.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ddm.interview.IapUtil.GetSession;
import com.ddm.interview.IapUtil.MyStringUtils;
import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.IapUtil.WebvarPropertyUtil;
import com.ddm.interview.pojo.Supernews;
import com.ddm.interview.service.SupernewsService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @类名：SearchSupernewsAction.java
 * 
 * @功能说明：查询校友录列表
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
public class SearchSupernewsAction extends ActionSupport {

	private Logger log = Logger.getLogger(SearchSupernewsAction.class);

	private SupernewsService supernewsService;
	private PagerModel<Supernews> pm;
	private String nowPageOffet;

	private Supernews supernews;
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

			supernews.setPicUrlArray(superUrl.toString());

			supernews.setPicUrl(headPicUrl);

			if (MyStringUtils.isNotNullAndEmpty(supernews)) {

				supernews.setCreateTimeDate(new Date());
				supernewsService.save(supernews);

			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	public SupernewsService getSupernewsService() {
		return supernewsService;
	}

	public void setSupernewsService(SupernewsService supernewsService) {
		this.supernewsService = supernewsService;
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

			if (MyStringUtils.isNotNullAndEmpty(supernews)) {
				supernewsService.delete(supernews);
			}
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
			supernews.setPicUrlArray(superUrl.toString());

			supernews.setPicUrl(headPicUrl);
			if (MyStringUtils.isNotNullAndEmpty(supernews)) {
				supernews.setCreateTimeDate(new Date());
				supernewsService.update(supernews);
			}
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
			if (MyStringUtils.isNotNullAndEmpty(supernews)) {
				supernews = supernewsService.findById(supernews.getId());
				String picArrayStr = supernews.getPicUrlArray();
				String[] picArray = picArrayStr.split(",");
				for (String pic : picArray) {

					picList.add(pic);
				}

			}
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
	public String findSupernewsList() {

		try {

			Pager pager = null;

			pager = new Pager();
			if (nowPageOffet != null && !nowPageOffet.equals("")) {
				Integer pageSize = 10;
				Integer pageOffet = pageSize
						* (Integer.valueOf(nowPageOffet) - 1);
				pager.setOffset(pageOffet.toString());
				pager.setPageSize(pageSize.toString());
			}

			setPm(supernewsService.getSupernewsBySelectSql(null, pager));

		} catch (Exception e) {
			// TODO: handle exception
			log.info("", e);
		}
		return "success";
	}

	public void setPm(PagerModel<Supernews> pm) {
		this.pm = pm;
	}

	public PagerModel<Supernews> getPm() {
		return pm;
	}

	public void setSupernews(Supernews supernews) {
		this.supernews = supernews;
	}

	public Supernews getSupernews() {
		return supernews;
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

}
