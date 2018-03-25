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

public class DownAndroidAction implements IModel{
	
	private String gotoUrl="";
	
	public DownAndroidAction() {
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)  {
		System.out.println("========DownLoadAction导出EXCEL=========");
		String apkPath = request.getSession().getServletContext()
				.getRealPath("/apkUpdata");

		String fileName = "BarClouds.apk";
		String filePath = apkPath +"/"+ fileName;
		//如果没有该路劲，先创建一个
		File upFile=new File(apkPath);
		if (!upFile.exists()) {
			upFile.mkdirs();
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
