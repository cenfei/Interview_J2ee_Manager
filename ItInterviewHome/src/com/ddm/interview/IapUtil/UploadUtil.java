
package com.ddm.interview.IapUtil;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.log4j.Logger;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class UploadUtil {

	private static Logger log=Logger.getLogger(UploadUtil.class);
	public static String getRandomFileName(String filename) {

		String time = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		String newext = filename.substring(filename.lastIndexOf(".") + 1, filename.length()).toLowerCase();
		String newfilename = time + StringUtil.getRandomString(5) + "." + newext;
		return newfilename;
	}

	public static void makeDirs(String path) {

		File dir = new File(path);
		if ( !dir.exists() )
		{
			dir.mkdirs();
		}
	}

	/**
	 * 文件上传类，自定义上传路径，上传文件统一用时间戳命名，防止重复，如需保存原文件名，请自行获取，然后单独保存为一字段
	 * 
	 * @param file //File文件
	 * @param path //上传路径
	 * @param filename //原文件名
	 * @return 保存文件名
	 */

	public static String upload(File file, String path, String filename) {

		String newfilename = getRandomFileName(filename);// 当前时间随机的文件名
		try
		{
			System.out.println("path=" + path);  

			String
			 loadUrl=UploadUtil.class.getResource("/").getFile();
			 loadUrl=loadUrl.substring(0,loadUrl.indexOf("WEB-INF/"))+path+"/";
			 if(loadUrl.contains(":")){
			if(loadUrl.substring(0, 1).equals("/")){
				loadUrl=loadUrl.substring(1);
				
				
			}
			 }
			 
			 log.info("文件保存路径："+loadUrl); 
			/**
			 * 假如在linuc环境下  绝对路径应该是/root/tomcat/webapps/AluminRecordSystem/UploadHeadPic
			 * 但是window下应该是D:\Workspaces\MyEclipse10\xiaoyoulu2\WebRoot\UploadHeadPic
			 */
			 
			 
			
			makeDirs(loadUrl);// 不存在则 新建目录 在项目的webroot下的文件路径
			
			loadUrl=loadUrl+newfilename;
			File destFile = new File(loadUrl);// 在path目录下新建 随机的文件
			
			
			
			
			
			InputStream is = new FileInputStream(file);// 新建流对象
			
			OutputStream os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ( ( length = is.read(buffer) ) > 0 )
			{
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			// 将上传的文件流写入到新建的文件中

		}
		catch ( Exception e )
		{
			System.err.println(e.getMessage());
			return "";
		}

		return newfilename;
	}

	public static String uploadInputStream(InputStream Stream, String path, String filename) {

		String newfilename = getRandomFileName(filename);// 当前时间随机的文件名
		try
		{
			System.out.println("path=" + path);  

			InputStream is = Stream;// 新建流对象
			makeDirs(path);// 不存在则 新建目录 在d:/chuanyueke/upload/addressType
			File destFile = new File(path, newfilename);// 在path目录下新建 随机的文件
			OutputStream os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ( ( length = is.read(buffer) ) > 0 )
			{
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			// 将上传的文件流写入到新建的文件中

		}
		catch ( Exception e )
		{
			System.err.println(e.getMessage());
			return "";
		}

		return newfilename;
	}

	
	
	public static String upload(InputStream is, String path, String filename) {

		String newfilename = getRandomFileName(filename);
		try
		{

			makeDirs(path);
			File destFile = new File(path, newfilename);
			OutputStream os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ( ( length = is.read(buffer) ) > 0 )
			{
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();

		}
		catch ( Exception e )
		{
			System.err.println(e.getMessage());
			return "";
		}

		return newfilename;
	}

	public static void cutImage(File src, String suffix, int x, int y, int w, int h, File desc) throws IOException {

		FileInputStream is = null;
		ImageInputStream iis = null;

		try
		{
			// 读取图片文件
			is = new FileInputStream(src);

			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(suffix);
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();

			Rectangle rect = new Rectangle(x, y, w, h);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, suffix, desc);
		}

		finally
		{
			if ( is != null )
				is.close();
			if ( iis != null )
				iis.close();
		}

	}

	public static String uploadThumbimage(File file, String path, String filename) {

		String newfilename = upload(file, path, filename);
		File src = new File(path, newfilename);
		createThumbnail(src, path + "\\thumb_" + newfilename, 100, 100);
		if ( src.exists() )
		{
			src.delete();
		}
		return "thumb_" + newfilename;
	}

	public static String imageUpload(File file, String path, String filename) {

		String newfilename = upload(file, path, filename);
		File destFile = new File(path, newfilename);
		try
		{
			// 创建缩略图
			String dest = path + "\\.thumbnail\\";
			makeDirs(dest);
			createThumbnail(destFile, dest + "." + newfilename, 200, 200);

		}
		catch ( Exception e )
		{
			System.err.println(e.getMessage());
			return "";
		}
		return newfilename;
	}

	/**
	 * 创建图片缩略图(等比缩放)
	 * 
	 * @param src 源图片文件完整路径
	 * @param dist 目标图片文件完整路径
	 * @param width 缩放的宽度
	 * @param height 缩放的高度
	 */
	public static void createThumbnail(File srcfile, String dist, float width, float height) {

		try
		{
			BufferedImage image = ImageIO.read(srcfile);

			// 获得缩放的比例
			double ratio = 1.0;
			// 判断如果高、宽都不大于设定值，则不处理
			if ( image.getHeight() > height || image.getWidth() > width )
			{
				if ( image.getHeight() > image.getWidth() )
				{
					ratio = height / image.getHeight();
				} else
				{
					ratio = width / image.getWidth();
				}
			}
			// 计算新的图面宽度和高度
			int newWidth = (int) ( image.getWidth() * ratio );
			int newHeight = (int) ( image.getHeight() * ratio );

			BufferedImage bfImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			bfImage.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);

			FileOutputStream os = new FileOutputStream(dist);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			encoder.encode(bfImage);
			os.close();
			// System.out.println("缩略图路径为：" + dist);
		}
		catch ( Exception e )
		{
			System.out.println("创建缩略图发生异常" + e.getMessage());
		}
	}

	public static void main(String[] args) {

		// createThumbnail("C:\\a.jpg", "C:\\b.jpg", 100, 100);

	}

}
