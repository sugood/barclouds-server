package com.barclouds.controller;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;





import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;












import com.barclouds.model.DataCollectAction;
import com.barclouds.model.DataListByPageAction;
import com.barclouds.model.DeleteDataAction;
import com.barclouds.model.DeleteInfoAction;
import com.barclouds.model.DownAndroidAction;
import com.barclouds.model.DownLoadAction;
import com.barclouds.model.InfoListByPageAction;
import com.barclouds.model.IoManageAction;
import com.barclouds.model.ListByPageAction;
import com.barclouds.model.UserLoginAction;
//import com.barclouds.model.UserAddAction;
//import com.barclouds.model.UserDeleteAction;
//import com.barclouds.model.UserListAction;
//import com.barclouds.model.UserModifyAction;
import com.barclouds.model.UserRegisterAction;
//import com.barclouds.model.UserUpdateAction;
import com.barclouds.util.IModel;

/**
 * 核心处理器类，用来接收客户端的所有请求， 根据请求调用模型实现业务逻辑的处理， 在模型处理完后根据处理结果再进行视图的转发
 * 
 * @author Sugood
 * 
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		// 获取请求提交的参数，该参数用来标识执行的请求处理
		String cmd = req.getParameter("actionName");
		
		System.out.println("========接收到servlet,控制model=========");
		System.out.println("controller："+cmd);
		
		// 根据参数获取模型的实例
		IModel model = (IModel) getServletContext().getAttribute(cmd);
		// 通过模型对象进行业务逻辑处理，返回视图路径
		String url = model.execute(req, resp);
		System.out.println("url："+this.getServletConfig().getServletContext().getRealPath("/")+url);

		// 根据视图路径进行页面转发
		if (url != null) {
			if (url.equals("notforward")){
//				System.out.println("不跳转");
				return;
			}else
				req.getRequestDispatcher(url).forward(req, resp);
		} else {
			// 如果路径出错，跳转到错误页面
			req.getRequestDispatcher("WEB-INF/jsp/error.jsp")
					.forward(req, resp);
		}
	}

	@Override
	public void init() throws ServletException {
		// 获取application
		ServletContext application = getServletContext();
		// 将业务模型的实例写入application
		application.setAttribute("userRegisterAction", new UserRegisterAction());
		application.setAttribute("userLoginAction", new UserLoginAction());
		application.setAttribute("dataCollectAction", new DataCollectAction());
		application.setAttribute("listByPageAction", new ListByPageAction());
		application.setAttribute("ioManageAction", new IoManageAction());
		application.setAttribute("infoListByPageAction", new InfoListByPageAction());
		application.setAttribute("dataListByPageAction", new DataListByPageAction());
		application.setAttribute("deleteDataAction", new DeleteDataAction());
		application.setAttribute("deleteInfoAction", new DeleteInfoAction());
		application.setAttribute("downLoadAction", new DownLoadAction());
		application.setAttribute("downAndroidAction", new DownAndroidAction());
	}

}
