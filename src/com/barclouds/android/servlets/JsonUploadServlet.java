package com.barclouds.android.servlets;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.barclouds.dao.impl.InfoDao;
import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.entity.Info;
import com.barclouds.entity.InfoIndex;
import com.barclouds.service.InfoIndexService;
import com.barclouds.service.InfoService;

public class JsonUploadServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		boolean isuploadSuccess=false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		File excelFile=null;
		
		InfoDao infoDao = new InfoDao();
		InfoIndexDao infoIndexDao = new InfoIndexDao();
		
		String uid="";
		
		// 创建文件项目工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置文件上传路径
		String upload = this.getServletContext().getRealPath("/upload/");
		// 获取系统默认的临时文件保存路径，该路径为Tomcat根目录下的temp文件夹
		String temp = System.getProperty("java.io.tmpdir");
		// 设置缓冲区大小为 5M
		factory.setSizeThreshold(1024 * 1024 * 5);
		// 设置临时文件夹为temp
		factory.setRepository(new File(temp));
		// 用工厂实例化上传组件,ServletFileUpload 用来解析文件上传请求
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

		//获取session中的用户名
//		String uid = request.getParameter("uid");
//		String uid = "sugood";
//		System.out.println("JsonUploadServlet:uid="+uid);
//		String uid=(String)request.getSession().getAttribute("userinfo");
		// 解析结果放在List中
		try
		{
			List<FileItem> lists = servletFileUpload.parseRequest(request);

			for (FileItem item : lists)
			{
				String name = item.getFieldName();
				InputStream is = item.getInputStream();

				if (name.contains("uid"))
				{
					uid=inputStream2String(is);
//					System.out.println(inputStream2String(is));
				} else if(name.contains("file"))
				{
					try
					{
						inputStream2File(is, upload + "\\" + item.getName());
						File uploadFile=new File(item.getName());
						//如果没有此文件夹，创建一个
						if (!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						excelFile=new File(upload, uploadFile.getName());
						isuploadSuccess=true;
					} catch (Exception e)
					{
						isuploadSuccess=false;
						e.printStackTrace();
					}
				}
			}
			System.out.println("uid="+uid);
			if(uid==null&&uid.equals("")){
				isuploadSuccess=false;
			}
			//如果文件上传成功,解析excel,存入List集合中,如果excel数据比较大，List可能放不下的问题,你可以分页读取excel，一个List里面放2W条数据应该没什么问题
			//根据excel的格式 解析自己的数据,我这里只是简单的给你个参考,
			//excel总共只4列 
			System.out.println("解析：excel");
			List<Info> list=new ArrayList<Info>();
//			List<InfoIndex> listIndex=new ArrayList<InfoIndex>();
			if (isuploadSuccess) {
				//poi解析
				FileInputStream fis=null;
				try {
					
					System.out.println(excelFile.getAbsolutePath());
					fis=new FileInputStream(excelFile);
					HSSFWorkbook book=new HSSFWorkbook(fis);
					HSSFSheet sheet=book.getSheetAt(0);//第一个sheet
					int lastRowNum=sheet.getLastRowNum();//最大行数 有数据的
					//一般excel第一行是标题
					
					HSSFRow row=null;
					for (int i = 0; i < lastRowNum; i++) {
						row=sheet.getRow(i);
						if(i==0){
							String name0=getCellValue(row, 0);
							String name1=getCellValue(row, 1);
							String name2=getCellValue(row, 2);
							String name3=getCellValue(row, 3);
							String name4=getCellValue(row, 4);
							String name5=getCellValue(row, 5);
							String name6=getCellValue(row, 6);
							String name7=getCellValue(row, 7);
							String name8=getCellValue(row, 8);
							String name9=getCellValue(row, 9);
							InfoIndex infoIndex=new InfoIndex(uid,name0, name1, name2, name3,name4, name5, name6, name7,name8, name9);
							//写入标题信息
			    	      	InfoIndexService infoIndexService = new InfoIndexService();
			    	      	infoIndexService.addDataGroup(uid, infoIndexDao, infoIndex);
						}else{
							String field0=getCellValue(row, 0);
							String field1=getCellValue(row, 1);
							String field2=getCellValue(row, 2);
							String field3=getCellValue(row, 3);
							String field4=getCellValue(row, 4);
							String field5=getCellValue(row, 5);
							String field6=getCellValue(row, 6);
							String field7=getCellValue(row, 7);
							String field8=getCellValue(row, 8);
							String field9=getCellValue(row, 9);
							Info info=new Info(uid,field0, field1, field2, field3,field4, field5, field6, field7,field8, field9);
							list.add(info);
						}
					}
					
				} catch (Exception e) {
					System.out.println("excel解析出错！！！");
					out.write("failure");
					e.printStackTrace();
				}
			}else {
				System.out.println("失败:");
				out.write("failure");
			}
			//解析excel成功
			//下面操作入库
//			response.getWriter().println("excel data:<br/>");
			InfoService infoService=new InfoService();
	      	infoService.addDataBatch(infoDao, list);
			out.write("success");
		} catch (FileUploadException e)
		{
			e.printStackTrace();
			out.write("failure");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write("failure");
		}

		out.flush();
		out.close();
	}

	// 流转化成字符串
	public static String inputStream2String(InputStream is) throws IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = is.read()) != -1)
		{
			baos.write(i);
		}
		return baos.toString();
	}

	// 流转化成文件
	public static void inputStream2File(InputStream is, String savePath)
			throws Exception
	{
		System.out.println("文件保存路径为:" + savePath);
		File file = new File(savePath);
		InputStream inputSteam = is;
		BufferedInputStream fis = new BufferedInputStream(inputSteam);
		FileOutputStream fos = new FileOutputStream(file);
		int f;
		while ((f = fis.read()) != -1)
		{
			fos.write(f);
		}
		fos.flush();
		fos.close();
		fis.close();
		inputSteam.close();
		
	}

	private String getCellValue(HSSFRow row,int cellIndex){
		String cellValue="";
		cellValue=row.getCell(cellIndex).getStringCellValue();
		
		return cellValue;
	}
}
