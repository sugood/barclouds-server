package com.barclouds.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

public class IoManageAction implements IModel{
	
	private String gotoUrl="";
	private InfoIndexDao infoIndexDao;
	private InfoDao infoDao;
	
	public IoManageAction() {
		infoDao = new InfoDao();
		infoIndexDao = new InfoIndexDao();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)  {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		boolean isuploadSuccess=false;
		File excelFile=null;
		try {
			//获取session中的用户名
			System.out.println("----导入导出页面-----/r/n");
			String uid=(String)request.getSession().getAttribute("userinfo");
			
			String uploaddir=request.getSession().getServletContext().getRealPath("/upload");
			File upFile=new File(uploaddir);
			if (!upFile.exists()) {
				upFile.mkdirs();
			}
			if (isMultipart == true) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items;
				items = upload.parseRequest(request);
				Iterator<FileItem> itr = items.iterator();
				while (itr.hasNext()) {//单文件上传
					FileItem item = (FileItem) itr.next();
					if (!item.isFormField()) {//文件，不包含普通表单内容
						File uploadFile=new File(item.getName());
						excelFile=new File(uploaddir, uploadFile.getName());
						try {
							item.write(excelFile);
							isuploadSuccess=true;
						} catch (Exception e) {
							e.printStackTrace();
							isuploadSuccess=false;
							System.out.println("上传失败！！");
						}
					}else {
						//普通表单内容 不处理
						System.out.println(item.toString());
					}
				}
				//如果文件上传成功,解析excel,存入List集合中,如果excel数据比较大，List可能放不下的问题,你可以分页读取excel，一个List里面放2W条数据应该没什么问题
				//根据excel的格式 解析自己的数据,我这里只是简单的给你个参考,
				//excel总共只4列 
				System.out.println("解析：excel");
				List<Info> list=new ArrayList<Info>();
//				List<InfoIndex> listIndex=new ArrayList<InfoIndex>();
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
						response.setCharacterEncoding("gbk");
						response.setContentType("text/html;charset=gbk");
//						response.setContentType("charset=gb2312");
						PrintWriter out = response.getWriter();
						out.print("<script>alert('excel解析出错，请重新选择文件...'); window.location='/BarClouds/system/ioManage.jsp'</script>");
						out.flush();
						out.close();
//						gotoUrl="system/ioManage.jsp";
						e.printStackTrace();
					}
				}else {
					System.out.println("失败:");
					response.setCharacterEncoding("gbk");
					response.setContentType("text/html;charset=gbk");
//					response.setContentType("charset=gb2312");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('excel导入失败，请重新导入...'); window.location='/BarClouds/system/ioManage.jsp'</script>");
					out.flush();
					out.close();
//					gotoUrl="system/ioManage.jsp";
					
				}
				//解析excel成功
				//下面操作入库
//				response.getWriter().println("excel data:<br/>");
				InfoService infoService=new InfoService();
    	      	infoService.addDataBatch(infoDao, list);
//				for (Info info : list) {
////					response.getWriter().println("uid:"+info.getUid()+"            field0:"+info.getField0()+"       field1:"+info.getField1()+"<br/>");
////					System.out.println("名称："+info.getUid()+"地址："+info.getField0()+"邮箱："+info.getField1());
//
//	    	      	InfoService infoService=new InfoService();
//	    	      	infoService.addDataGroup(infoDao, info);
//				}
			} else {
				System.out.print("the enctype must be multipart/form-data");
			}
//			response.getWriter().println("load data success!!!");
//			response.getWriter().println("<a href='system/infoListByPage.jsp' >back</a>");
			gotoUrl="infoListByPage.do?actionName=infoListByPageAction";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gotoUrl;
	}
	
	private String getCellValue(HSSFRow row,int cellIndex){
		String cellValue="";
		cellValue=row.getCell(cellIndex).getStringCellValue();
		
		return cellValue;
	}
}
