package com.jkxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkxy.dao.impl.PoetriesDaoImpl;
import com.jkxy.dao.impl.PoetsDaoImpl;
import com.jkxy.entity.Poetries;
import com.jkxy.entity.Poets;
import com.jkxy.uitl.ConnectionFactory;

public class TangPoetryServlet extends HttpServlet {
	Connection conn = null;
	
	/**
	 * Constructor of the object.
	 */
	public TangPoetryServlet() {
		super();
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
			throws ServletException, IOException{
		conn = ConnectionFactory.getInstace().makeConnction();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		request.setCharacterEncoding("UTF-8");
		String selects = request.getParameter("lib");
		String keys = request.getParameter("k");
		String id = request.getParameter("id");  //作者id,用于标题相同时查询
		if(selects.equals("lbl_Title")){  //题目查询
			Poetries poetries=null;
			List poetriesList = null;
			if(id!=null && !"".equals(id)){
				try {
					poetries= new PoetriesDaoImpl().titleSearch(conn, keys,Integer.parseInt(id));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				try {
					poetriesList = new PoetriesDaoImpl().titleSearchList(conn,keys);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			 if(poetries != null){
				 Poets poets;
				try {
					poets = new PoetsDaoImpl().poet(conn,poetries.getPoet_id());
					HttpSession session = request.getSession();
					poetries.setName(poets.getName());
					session.setAttribute("poetries", poetries);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 request.getRequestDispatcher("../TitleTangPoetry.jsp").forward(request, response);
			 }else if (poetriesList.size()>0) {
				 HttpSession session = request.getSession();
				 session.setAttribute("poetriesList", poetriesList);
				 request.getRequestDispatcher("../TitleTangPoetry.jsp").forward(request, response);
			}else {
				 request.setAttribute("message", "查询失败,请核对查询内容是否匹配!");
				 request.getRequestDispatcher("../index.jsp").forward(request, response);
			}
		}else if(selects.equals("lbl_Author")){	//作者查询
			try {
				List poets = new PoetsDaoImpl().poetAuthor(conn,keys);
				 if(poets != null && poets.size()>0){
					 HttpSession session = request.getSession();
					 session.setAttribute("poets", poets);
					 session.setAttribute("name", keys);
					 request.getRequestDispatcher("../AuthorTangPoetry.jsp").forward(request, response);
					// response.sendRedirect("");
				 }else {
					 request.setAttribute("message", "查询失败,请核对查询内容是否匹配!");
					 request.getRequestDispatcher("../index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(selects.equals("lbl_Body")){	//诗歌内容查询
			 Poetries poetries;
			try {
				poetries = new PoetriesDaoImpl().bodySearch(conn,keys);
				if(poetries != null){
					 Poets poets = new PoetsDaoImpl().poet(conn,poetries.getPoet_id());
					 HttpSession session = request.getSession();
					 session.setAttribute("poetries", poetries);
					 session.setAttribute("poets", poets);
					 request.getRequestDispatcher("../BodyTangPoetry.jsp").forward(request, response);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			 request.setAttribute("message", "查询失败,请核对查询内容是否匹配!");
			 request.getRequestDispatcher("../index.jsp").forward(request, response);
		}
		//List poes = new PoetriesService().poetryList();
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	//关闭
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

}
