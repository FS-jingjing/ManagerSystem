package mil.jtaspect.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import mil.jtaspect.dao.Dao;
import mil.jtaspect.dao.DaoImpl;
import mil.jtaspect.entity.Student;
import mil.jtaspect.entity.User;

@WebServlet("*.action")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		Dao dao=new DaoImpl();
		Student stu=null;
		String uri=request.getRequestURI();
		String ple=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if(ple.equals("/add")){
			String username=request.getParameter("username");
			if(dao.queryOne(username)){
				request.setAttribute("zcname", "用户名已经被注册！");
				request.getRequestDispatcher("zhuce.jsp").forward(request, response);
			}
			String password=request.getParameter("password");
			stu=new Student(username,password);
			pw.print(stu);
				if(dao.add(stu)>0){
					HttpSession session=request.getSession();
					session.setAttribute("stu", stu);
					response.sendRedirect(response.encodeRedirectURL("load.jsp"));
				}else{
					response.sendRedirect(response.encodeRedirectURL("error.jsp"));
				}
			
		}else if(ple.equals("/login")){
			HttpSession session=request.getSession();
			String str=(String)session.getAttribute("str");
			String code=request.getParameter("code");
			if(code.length()==0||code==""){
				request.setAttribute("error1", "请输入验证码！");
				request.getRequestDispatcher("load.jsp").forward(request, response);
			}else if(!str.equalsIgnoreCase(code)){
				request.setAttribute("error1", "验证码输入有误！");
				request.getRequestDispatcher("load.jsp").forward(request, response);
			}else{
				String username=request.getParameter("username");
				if(username.length()==0||username==""){
					request.setAttribute("error2", "请输入用户名！");
					request.getRequestDispatcher("load.jsp").forward(request, response);
				}
				String password=request.getParameter("password");
				if(password.length()==0||password==""){
					request.setAttribute("error3", "请输入密码！");
					request.getRequestDispatcher("load.jsp").forward(request, response);
				}
				stu=dao.sel(username, password);
				if(stu!=null){session.setAttribute("stu", stu);
					response.sendRedirect(response.encodeRedirectURL("show.action"));
				}else{
					request.setAttribute("error2", "用户名或密码输入错误！");
					request.setAttribute("error3", "用户名或密码输入错误！");
					request.getRequestDispatcher("load.jsp").forward(request, response);
				}
			}
			
		}else if(ple.equals("/show")){
			stu=(Student)request.getSession().getAttribute("stu");
			if(stu!=null){
				List<Student>list=dao.query();
				request.setAttribute("list",list);
				request.getRequestDispatcher("query.jsp").forward(request,response);
			}else{
				response.sendRedirect(response.encodeRedirectURL("load.jsp"));
			}
			
		}else if(ple.equals("/del")){
			String username=request.getParameter("id");
			if(dao.del(username)){
				response.sendRedirect("show.action");
			}else{
				response.sendRedirect("show.action");
			}
		}
		
	}

}
