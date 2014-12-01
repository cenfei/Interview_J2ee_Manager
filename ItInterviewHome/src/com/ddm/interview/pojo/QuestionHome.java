package com.ddm.interview.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * QuestionHome entity. @author MyEclipse Persistence Tools
 */

public class QuestionHome implements java.io.Serializable {

	// Fields

	private Long queId;
	private Integer queLanguageType;
	private Integer queWayType;
	private Integer queSmallContentType;
	private Integer queDiffcultyType;
	private String queTag;
	private String queFromsource;
	private String queContent;
	private String queAnswer;
	private Integer queLikeSum;
	private Integer queCollectSum;
	private Integer queShareSum;
	private Date quePublishTime;
	private String queContentEnglish;
	private String queAnswerEnglish;
	private String queContentChooses;
	private String checkTitleUnqiue;
	private String publisherName;
	private Integer queBigContentType;

	// Constructors

	/** default constructor */
	public QuestionHome() {
	}

	public Long getQueId() {
		return this.queId;
	}

	public void setQueId(Long queId) {
		this.queId = queId;
	}

	public Integer getQueLanguageType() {
		return this.queLanguageType;
	}

	public void setQueLanguageType(Integer queLanguageType) {
		this.queLanguageType = queLanguageType;
	}

	public Integer getQueWayType() {
		return this.queWayType;
	}

	public void setQueWayType(Integer queWayType) {
		this.queWayType = queWayType;
	}

	public Integer getQueSmallContentType() {
		return this.queSmallContentType;
	}

	public void setQueSmallContentType(Integer queSmallContentType) {
		this.queSmallContentType = queSmallContentType;
	}

	public Integer getQueDiffcultyType() {
		return this.queDiffcultyType;
	}

	public void setQueDiffcultyType(Integer queDiffcultyType) {
		this.queDiffcultyType = queDiffcultyType;
	}

	public String getQueTag() {
		return this.queTag;
	}

	public void setQueTag(String queTag) {
		this.queTag = queTag;
	}

	public String getQueFromsource() {
		return this.queFromsource;
	}

	public void setQueFromsource(String queFromsource) {
		this.queFromsource = queFromsource;
	}

	public String getQueContent() {
		return this.queContent;
	}

	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}

	public String getQueAnswer() {
		return this.queAnswer;
	}

	public void setQueAnswer(String queAnswer) {
		this.queAnswer = queAnswer;
	}

	public Integer getQueLikeSum() {
		return this.queLikeSum;
	}

	public void setQueLikeSum(Integer queLikeSum) {
		this.queLikeSum = queLikeSum;
	}

	public Integer getQueCollectSum() {
		return this.queCollectSum;
	}

	public void setQueCollectSum(Integer queCollectSum) {
		this.queCollectSum = queCollectSum;
	}

	public Integer getQueShareSum() {
		return this.queShareSum;
	}

	public void setQueShareSum(Integer queShareSum) {
		this.queShareSum = queShareSum;
	}

	public Date getQuePublishTime() {
		return this.quePublishTime;
	}

	public void setQuePublishTime(Date quePublishTime) {
		this.quePublishTime = quePublishTime;
	}

	public String getQueContentEnglish() {
		return this.queContentEnglish;
	}

	public void setQueContentEnglish(String queContentEnglish) {
		this.queContentEnglish = queContentEnglish;
	}

	public String getQueAnswerEnglish() {
		return this.queAnswerEnglish;
	}

	public void setQueAnswerEnglish(String queAnswerEnglish) {
		this.queAnswerEnglish = queAnswerEnglish;
	}

	public String getQueContentChooses() {
		return this.queContentChooses;
	}

	public void setQueContentChooses(String queContentChooses) {
		this.queContentChooses = queContentChooses;
	}

	public String getCheckTitleUnqiue() {
		return this.checkTitleUnqiue;
	}

	public void setCheckTitleUnqiue(String checkTitleUnqiue) {
		this.checkTitleUnqiue = checkTitleUnqiue;
	}

	public String getPublisherName() {
		return this.publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Integer getQueBigContentType() {
		return this.queBigContentType;
	}

	public void setQueBigContentType(Integer queBigContentType) {
		this.queBigContentType = queBigContentType;
	}

}