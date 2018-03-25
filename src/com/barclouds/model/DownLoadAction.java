package com.barclouds.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.barclouds.service.DataService;
import com.barclouds.service.InfoIndexService;
import com.barclouds.service.InfoService;
import com.barclouds.util.IModel;
import com.barclouds.dao.impl.DataDao;
import com.barclouds.dao.impl.InfoDao;
import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.entity.Data;
import com.barclouds.entity.Info;
import com.barclouds.entity.InfoIndex;
import com.barclouds.entity.PageBean;

public class DownLoadAction implements IModel{
	
	private String gotoUrl="";
	private InfoIndexDao infoIndexDao;
	private InfoDao infoDao;
	
	public DownLoadAction() {
		infoDao = new InfoDao();
		infoIndexDao = new InfoIndexDao();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)  {
		System.out.println("========DownLoadAction导出EXCEL=========");
		String docsPath = request.getSession().getServletContext()
				.getRealPath("/download");

		String fileName = "export2007_" + System.currentTimeMillis() + ".xlsx";
		String filePath = docsPath +"/"+ fileName;
		//如果没有该路劲，先创建一个
		File upFile=new File(docsPath);
		if (!upFile.exists()) {
			upFile.mkdirs();
		}
//		String filePath = "d:\\" + fileName;
		int pageSize = 1000;
		//获取session中的用户名
		String uid=(String)request.getSession().getAttribute("userinfo");
		
		try {
			// 处理数据
			DataService cs = new DataService();
			//获取总数
			int totalPage = cs.getTotalPage(pageSize, uid);
			// 输出流
			OutputStream os = new FileOutputStream(filePath);
			// 工作区
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("sheet");
			for (int i = 1; i <= totalPage; i++) {
				// 分页的查询后台
				PageBean<Data> page = cs.findByPage(uid,i,pageSize);
				for(int j =0 ; j < page.getBeanList().size(); j++){
					// 创建第一个sheet
					// 生成第一行
					XSSFRow row = sheet.createRow(j);
					// 给这一行的第1列赋值
					row.createCell(0).setCellValue(page.getBeanList().get(j).getField0());
					// 给这一行的第2列赋值
					row.createCell(1).setCellValue(page.getBeanList().get(j).getField1());
					// 给这一行的第3列赋值
					row.createCell(2).setCellValue(page.getBeanList().get(j).getField2());
					// 给这一行的第4列赋值
					row.createCell(3).setCellValue(page.getBeanList().get(j).getField3());
					// 给这一行的第5列赋值
					row.createCell(4).setCellValue(page.getBeanList().get(j).getField4());
					// 给这一行的第6列赋值
					row.createCell(5).setCellValue(page.getBeanList().get(j).getField5());
					// 给这一行的第7列赋值
					row.createCell(6).setCellValue(page.getBeanList().get(j).getField6());
					// 给这一行的第8列赋值
					row.createCell(7).setCellValue(page.getBeanList().get(j).getField7());
					// 给这一行的第9列赋值
					row.createCell(8).setCellValue(page.getBeanList().get(j).getField8());
					// 给这一行的第10列赋值
					row.createCell(9).setCellValue(page.getBeanList().get(j).getField9());

//					System.out.println(i);
				}
			}
			// 写文件
			wb.write(os);
			// 关闭输出流
			os.close();
		} catch (Exception e) {
			System.out.println("========DownLoadAction-异常=========");
			e.printStackTrace();
		}
		System.out.println("begin to dowaload");
		download(filePath, response);
		gotoUrl="notforward";
		return gotoUrl;
	}
	
	private void download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=gb2312");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
