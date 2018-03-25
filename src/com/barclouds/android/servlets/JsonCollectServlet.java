package com.barclouds.android.servlets;

import java.io.IOException;
import java.io.PrintWriter;






import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import com.barclouds.dao.impl.DataDao;
import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.dao.impl.UserDao;
import com.barclouds.entity.Data;
import com.barclouds.entity.Info;
import com.barclouds.entity.InfoIndex;
import com.barclouds.entity.PageBean;
import com.barclouds.service.DataService;
import com.barclouds.service.InfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonCollectServlet extends HttpServlet{
	// 获得数据库操作的DAO
	private DataDao dataDao;
	private Data data;
	/**
	 * Constructor of the object.
	 */
	public JsonCollectServlet() {
		dataDao = new DataDao();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * pageCode	当前页
		 * pageSize 设置每页显示的记录条数
		 * totalPage  总页数（计算出来的）
		 * totalCount （从数据库查询）
		 * beanList （从数据库查询）
		 */
		try{
			System.out.println("----JSON-正在采集数据-----/r/n");
	
			// 获取前台表单提交后的用户名
			response.setContentType("text/html;charset=utf-8");
			//获取前台表单提交的信息
	    	String uid=request.getParameter("uid");
	    	String field0=request.getParameter("field0");
	//		String uid = "sugood";
	
	    	data=new Data("","","","","","","","","","", "");
	    	DataService dataService=new DataService();
	    	Info info=dataService.searchInfo(uid, field0);
			
			if(info!=null){
				data.setUid(uid);
				data.setField0(field0);
				data.setField1(info.getField1());
				data.setField2(info.getField2());
				data.setField3(info.getField3());
				data.setField4(info.getField4());
				data.setField5(info.getField5());
				data.setField6(info.getField6());
				data.setField7(info.getField7());
				data.setField8(info.getField8());
				data.setField9(info.getField9());
			}else{
				data.setUid(uid);
				data.setField0(field0);
				data.setField1("");
				data.setField2("");
				data.setField3("");
				data.setField4("");
				data.setField5("");
				data.setField6("");
				data.setField7("");
				data.setField8("");
				data.setField9("");
			}
			dataService.addDataGroup(dataDao, data);

			PrintWriter pw = response.getWriter();
			//封装服务器返回的JSON对象
			JSONObject jsonReply = new JSONObject();
			jsonReply = JSONObject.fromObject(data);
	//		JSONArray array = new JSONArray();
	//		array = JSONArray.fromObject(page.getBeanList());
			//打印返回的JSON数据
			System.out.println("SEND:"+jsonReply);
			pw.println(jsonReply);
			pw.flush();
			pw.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	/**
	 * 获取当前页的信息（返回第一页，如果不是默认情况下，返回从客户端获取的当前页）
	 * @param request
	 * @return
	 */
	public int getPageCode(HttpServletRequest request){
		// 先获取从客户端传过来的参数
		String pc = request.getParameter("pageNo");
		// 进行判断
		if(pc == null || pc.trim().isEmpty()){
			// 返回第一页
			return 1;
		}
		return Integer.parseInt(pc);
	}
}
