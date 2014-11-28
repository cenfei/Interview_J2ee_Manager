package com.ddm.interview.service;

import org.apache.log4j.Logger;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.LinkStringFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.ddm.interview.IapUtil.UrlContent;

/**
 * 数据抓取----it面试题库信息抓取
 * 
 * @author foxcen
 */
public class InterviewAppDataCrawler {

	private Parser parser = null; // 用于分析网页的分析器。

	private static Logger log = Logger.getLogger(InterviewAppDataCrawler.class);

	/**
	 * 获取面试题的内容
	 * 
	 * @param newsContentFilter
	 * @param parser
	 * @return content 面试题内容
	 */
	private String getNewsContent(Node node, Parser parserSon0) {
		String content = null;
		StringBuffer builder = new StringBuffer();

		try {
			log.debug("开始获取面试题内容！");
			// for (int i = 0; i < newsContentList.size(); i++) {
			Div newsContenTag = null;
			try {

				newsContenTag = (Div) node;

				builder = builder.append(newsContenTag.getStringText());
			} catch (Exception e) {
				// TODO: handle exception
				LinkTag linkTag = (LinkTag) node;
				builder = builder.append(linkTag.getStringText());

			}

			// }
			content = builder.toString(); // 转换为String 类型。
			if (content.indexOf("id=\"arctTailMark\"") > 0) {
				content = content.substring(0,
						content.indexOf("id=\"arctTailMark\""));
			} else if (content.indexOf("class=\"clear\"") > 0) {
				content = content.substring(0,
						content.indexOf("class=\"clear\""));
			}
			content = content.replaceAll("<p>", "xyz");

			content = content.replaceAll("</p>", "zyx");
			content = content.replaceAll("<P>", "xyz");

			content = content.replaceAll("</P>", "zyx");
			// System.out.println("content=" + content);
			if (content != null) {
				// parserSon.reset();
				Parser parserSon = Parser.createParser(content, "utf-8");
				StringBean sb = new StringBean();
				sb.setCollapse(true);
				parserSon.visitAllNodesWith(sb);
				content = sb.getStrings();
				// String s =
				// "\";} else{ document.getElementById('TurnAD444').innerHTML = \"\";} } showTurnAD444(intTurnAD444); }catch(e){}";
				if (content != null) {
					// content = content.replaceAll("\\\".*[a-z].*\\}", "");
					content = content.replaceAll("xyz", "<p>");
					content = content.replaceAll("\\n\\n", "\\n");
					content = content.replaceAll("&#39;", "\\'");
					content = content.replaceAll("zyx", "</p>");
					content = content.replaceAll("&gt;", "\\>");
					content = content.replaceAll("&lt;", "\\<");
					content = content.replaceAll("&amp;", "\\&");
					content = content.replaceAll("&quot;", "\"");
					content = content.replaceAll("\\?i\\. ", "\\? i、  ");
					// content = content.replaceAll("i\\. ", "i.");
					content = content.replaceAll("\\.ii\\. ", "\\. ii、  ");
					content = content.replaceAll("\\.iii\\. ", "\\. iii、  ");
					content = content.replaceAll("\\.iv\\. ", "\\. iv、  ");
					content = content.replaceAll("iv\\. ", "iv、  ");
					for (int i = 1; i < 10; i++) {
						content = content.replaceAll(i + "\\. ", i + "、  ");
					}

				}
				// content = content.replace("[我来说两句]", "");
				log.debug("获取面试题内容成功！！！！");
			} else {
				log.info("没有得到面试题内容！");
			}

		} catch (ParserException ex) {
			log.error("获取文章内容失败", ex);
		}

		return content;
	}

	// 单个文件测试网页
	public static void main(String[] args) throws Exception {

		// 分页访问主页----暂时先访问第一页
		// parser是获取该分页中的一个人员id的list返回,通过多线程处理\
		InterviewAppDataCrawler interviewAppDataCrawler = new InterviewAppDataCrawler();

		try {
			String url = "http://skillgun.com/android/interview-questions-and-answers/paper/14";

			String content = UrlContent.getUrlContent2(url);

			// content = content.replaceAll("<span class='pln'>",
			// "<span class='pln'>\n ");

			Parser parser1 = Parser.createParser(content, "utf-8");
			NodeFilter pageContentFilter = new LinkStringFilter(
					"http://skillgun.com/question/");

			NodeList newsPageContentList = (NodeList) parser1
					.parse(pageContentFilter);
			Parser parser2 = Parser.createParser(content, "utf-8");
			NodeFilter pageContentFilter_1 = new AndFilter(new TagNameFilter(
					"div"), new HasAttributeFilter("class", "ansdiv"));
			NodeList newsPageContentList_1 = (NodeList) parser2
					.parse(pageContentFilter_1);

			// 答案和描述
			Parser parser3 = Parser.createParser(content, "utf-8");
			NodeFilter pageContentFilter_3 = new AndFilter(new TagNameFilter(
					"div"), new HasAttributeFilter("class", "showans"));
			NodeList newsPageContentList_3 = (NodeList) parser3
					.parse(pageContentFilter_3);

			for (int i = 0; i < newsPageContentList.size(); i++) {

				if (i % 2 == 0) {
					String queContentString = interviewAppDataCrawler
							.getNewsContent(newsPageContentList.elementAt(i),
									parser1);
					queContentString = replaceTSChar(queContentString);
					// String
					// queContentString=newsPageContentList.elementAt(i).toPlainTextString();
					System.out.println("题目：\n" + queContentString);
					// System.out.println("题目（中文）：\n" +
					// TranslateApi.translate(queContentString));
					String chooseAnString = interviewAppDataCrawler
							.getNewsContent(
									newsPageContentList_1.elementAt(i / 2),
									parser2);
					chooseAnString = pjChooseABCD(chooseAnString == null ? ""
							: chooseAnString);

					System.out.println("选择答案：\n" + chooseAnString);

					// 题目推荐答案 和 描述
					String rightAnsString = interviewAppDataCrawler
							.getNewsContent(
									newsPageContentList_3.elementAt(i / 2),
									parser3);

					if (rightAnsString.indexOf(" Comments") > 0) {
						rightAnsString = rightAnsString.substring(0,
								rightAnsString.indexOf(" Comments") - 2);
					}
					rightAnsString = replaceTSChar(rightAnsString);
					System.out.println("正确答案：\n" + rightAnsString);
					// System.out.println("正确答案：（中文）：\n" +
					// TranslateApi.translate(rightAnsString));
					System.out
							.println("************************************"
									+ i
									/ 2
									+ "****************************************************");
				}
				// System.out.println(newsPageContentList_1.elementAt(i).toPlainTextString());
			}

			System.out.println("");
		} catch (Exception e) {
			log.error("获取单页题库数据失败", e);
		}

	}

	private static String[] tScharStrings = { "\\?", ":", ";", "\\}", "\\{",
			"\\. " };

	public static String replaceTSChar(String reContent) {

		for (String tschar : tScharStrings) {

			reContent = reContent.replaceAll(tschar, tschar + "\n");

		}

		return reContent;
	}

	/**
	 * 
	 * @功能：拼接答案
	 * @返回参数：String
	 * @输入参数：@param reContent
	 * @输入参数：@return
	 */
	public static String pjChooseABCD(String reContent) {

		String[] ansArrayStrings = reContent.split("\\\n");
		StringBuffer sbBuffer = new StringBuffer();

		for (int i = 0; i < ansArrayStrings.length; i++) {

			String charString = null;
			switch (i) {
			case 0:
				charString = "A:";
				break;
			case 1:
				charString = "B:";
				break;
			case 2:
				charString = "C:";
				break;
			case 3:
				charString = "D:";
				break;
			default:
				break;
			}

			sbBuffer.append(charString + ansArrayStrings[i]);
		}

		return sbBuffer.toString();
	}

}
