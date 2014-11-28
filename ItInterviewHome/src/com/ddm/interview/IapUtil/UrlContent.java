package com.ddm.interview.IapUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.params.CookiePolicy;
import org.apache.log4j.Logger;

/**
 * 功能：通过传入网址，返回该网页的所有信息
 * 
 * @author geek
 * 
 */
public class UrlContent {
	private static HttpClient client = null;
	private static Logger log = Logger.getLogger(UrlContent.class);

	public static String getUrlContent(String strurl) {

		String content = null;
		HttpMethod method = null;
		InputStream ins = null;
		BufferedReader br = null;

		try {

			client = new HttpClient(new HttpClientParams(),
					new SimpleHttpConnectionManager(true));
			client.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "gb2312");
			// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
			client.getParams().setCookiePolicy(
					CookiePolicy.BROWSER_COMPATIBILITY);
			// 让服务器知道访问源为浏览器
			// String agent1 = "Googlebot";
			// client.getParams()
			// .setParameter(HttpMethodParams.USER_AGENT, agent1);

			// 通过head对象来设置请求头参数

			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0"));
			headers.add(new Header("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
			headers.add(new Header("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3"));
			// Accept-Language必须的加，否则返回500
			headers.add(new Header("Cache-Control", "max-age=0"));
			headers.add(new Header("Connection", "keep-alive"));
			headers.add(new Header(
					"Cookie",
					"CNZZDATA1117973=cnzz_eid%3D1907047617-1368608889-http%253A%252F%252Fmember.vobao.com%26ntime%3D1369723669%26cnzz_a%3D0%26retime%3D1369723659866%26sin%3D%26ltime%3D1369723659866%26rtime%3D7; CNZZDATA30073763=cnzz_eid%3D2112327689-1368608889-http%253A%252F%252Fmember.vobao.com%26ntime%3D1369723669%26cnzz_a%3D0%26retime%3D1369723660693%26sin%3D%26ltime%3D1369723660693%26rtime%3D7; __utma=50892213.1757367826.1368608890.1369372661.1369723661.25; __utmz=50892213.1368608890.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none); ASPSESSIONIDSSRBBADD=MNIELHOBOFFIICDEDDBGFGGC; __utmb=50892213; __utmc=50892213; pageReferrInSession=; testcookie=testvalue; VisitorCapacity=1"));
			headers.add(new Header("Host", "member.vobao.com"));
			client.getHostConfiguration().getParams()
					.setParameter("http.default-headers", headers);

			method = new GetMethod(strurl);
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				Thread.sleep(500);
				// continue;
			}
			ins = method.getResponseBodyAsStream();
			br = new BufferedReader(new InputStreamReader(ins, "gb2312"));
			StringBuffer sbf = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				content = sbf.append(line).toString();
			}

			System.out.println(content);

			return content;
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ins.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			method.releaseConnection();
			client = null;
		}

		return content;
	}

	public static String getUrlContent2(String url) {
		BufferedReader in = null;
		HttpURLConnection uc = null;
		InputStreamReader inputReader = null;
		StringBuffer sb = new StringBuffer();
		try {
			log.debug("开始读取网页信息");
			URL urls = new URL(url);

			uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
			uc.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			uc.setRequestProperty("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			uc.setRequestProperty("Connection", "keep-alive");

			inputReader = new InputStreamReader(uc.getInputStream(), "gb2312");
			in = new BufferedReader(inputReader);
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}


			log.debug("成功获取网页信息!!!!!!");
			return sb.toString();
		} catch (Exception e) {
			log.error("读取网页信息失败，url为" + e);
		} finally {
			// /释放资源
			try {
				in.close();
				inputReader.close();
				uc.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("读取网页信息，关闭资源失败，url为" + url);
			}

		}
		return sb.toString();
	}

	
	
	public static String getUrlContent3(String url,String code) {
		BufferedReader in = null;
		HttpURLConnection uc = null;
		InputStreamReader inputReader = null;
		StringBuffer sb = new StringBuffer();
		try {
			log.debug("开始读取网页信息");
			URL urls = new URL(url);

			uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
			uc.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			uc.setRequestProperty("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			uc.setRequestProperty("Connection", "keep-alive");

			inputReader = new InputStreamReader(uc.getInputStream(), code);
			in = new BufferedReader(inputReader);
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}


			log.debug("成功获取网页信息!!!!!!");
			return sb.toString();
		} catch (Exception e) {
			log.error("读取网页信息失败，url为" + e);
		} finally {
			// /释放资源
			try {
				in.close();
				inputReader.close();
				uc.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("读取网页信息，关闭资源失败，url为" + url);
			}

		}
		return sb.toString();
	}
	public static String getUrlContentHeXun(String url) {
		BufferedReader in = null;
		HttpURLConnection uc = null;
		InputStreamReader inputReader = null;
		StringBuffer sb = new StringBuffer();
		try {
			log.info("开始读取网页信息");
			URL urls = new URL(url);

			uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("GET");
			// uc.setRequestProperty("If-Modified-Since","Tue, 28 May 2013 06:47:22 GMT");
			// uc.setRequestProperty("If-None-Match","\"07976346f5bce1:0\"");
			uc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
			uc.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			// uc.setRequestProperty("Accept-Encoding",
			// "gzip, deflate");//不能加，加则乱码
			uc.setRequestProperty("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			// Accept-Language必须的加，否则返回500
			// uc.setRequestProperty("Cache-Control", "max-age=0");
			uc.setRequestProperty("Connection", "keep-alive");
			uc.setRequestProperty(
					"Cookie",
					"HexunTrack=SID=20130531094021146ecbcf5a00ad14a5e9c98f5f4a6a9b60c&CITY=31; bdshare_firstime=1369964411005; _ga=1.2.59086038.1369964423; __utma=194262068.59086038.1369964423.1369970636.1369970636.1; __utmz=194262068.1369970636.1.1.utmcsr=funds.hexun.com|utmccn=(referral)|utmcmd=referral|utmcct=/psnews/");
			// uc.setRequestProperty("Host", "	trust.hexun.com");

			// uc.setDoOutput(true);
			// uc.setDoInput(true);
			// uc.setReadTimeout(10000);
			// uc.setConnectTimeout(10000);
			// if(!StringUtils.isBlank(message)){
			// DataOutputStream dos = new
			// DataOutputStream(uc.getOutputStream());
			// dos.write(message.getBytes("UTF-8"));
			// dos.flush();
			// }

			inputReader = new InputStreamReader(uc.getInputStream(), "gb2312");
			in = new BufferedReader(inputReader);
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}

			// System.out.println(sb.toString());

			log.info("成功获取网页信息!!!!");
			return sb.toString();
		} catch (Exception e) {
			log.error("读取网页信息失败，url为" + e);
		} finally {
			// /释放资源
			try {
				in.close();
				inputReader.close();
				uc.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("读取网页信息，关闭资源失败，url为" + url);
			}

		}
		return sb.toString();
	}

	public static String getUrlContentSon(String url, Integer pageNum) {
		BufferedReader in = null;
		HttpURLConnection uc = null;
		InputStreamReader inputReader = null;
		StringBuffer sb = new StringBuffer();
		try {
			log.info("开始读取子网页信息");
			URL urls = new URL(url);
			uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			uc.setRequestProperty("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			// Accept-Language必须的加，否则返回500
			uc.setRequestProperty("Connection", "keep-alive");
			uc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
			// String
			// refererStr="http://member.vobao.com/index.asp?areaid1=0&areaid2=0&areaid3=0&classid1=0&classid2=0&classid3=0&lv=0&keyword=&orderrz=&ordernx=&orderhd=&page="+pageNum;
			// uc.setRequestProperty("Referer", refererStr);
			// uc.setDoOutput(true);
			// uc.setDoInput(true);
			// uc.setReadTimeout(10000);
			// uc.setConnectTimeout(10000);
			// if(!StringUtils.isBlank(message)){
			// DataOutputStream dos = new
			// DataOutputStream(uc.getOutputStream());
			// dos.write(message.getBytes("UTF-8"));
			// dos.flush();
			// }

			inputReader = new InputStreamReader(uc.getInputStream(), "utf-8");
			in = new BufferedReader(inputReader);
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}

			// System.out.println(sb.toString());
			log.info("成功获取网页信息!!!!");
			return sb.toString();
		} catch (Exception e) {
			log.error("读取网页信息失败，url为" + e);
		} finally {
			// /释放资源
			try {
				in.close();
				inputReader.close();
				uc.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("读取网页信息，关闭资源失败，url为" + url);
			}

		}
		return sb.toString();
	}

	public static void main(String args[]) {

		String content = UrlContent
				.getUrlContent2("http://192.168.1.49:8088/?access_token=123456");

		System.out.println(content);
	}

}
