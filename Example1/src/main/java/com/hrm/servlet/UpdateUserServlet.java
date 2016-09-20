

package com.hrm.servlet;





import com.hrm.dao.UsersDao;
import com.hrm.entity.Material;
import com.hrm.entity.Users;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UpdateUserServlet extends HttpServlet 
{
        
       public void init() throws ServletException
       {
           super.init();
                     //锟斤拷锟斤拷锟捷匡拷锟斤拷锟斤拷
         
       }
       public void destroy()
       {
        super.destroy();
              //锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
        //锟斤拷媒锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
        String username=request.getParameter("username");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String content=request.getParameter("content");
        String password=request.getParameter("password");
        String isadmin=request.getParameter("isadmin");
        String id=request.getParameter("id");
       Users u=new Users();
        u.setBirthday(birthday);
        u.setContent(content);
        u.setUsername(username);
        u.setSex(sex);
        u.setId(Integer.parseInt(id));
        u.setIsadmin(isadmin);
        u.setPassword(password);
       UsersDao userDao = new UsersDao();
       //check锟斤拷锟斤拷  锟斤拷锟斤拷锟斤拷菘锟饺斤拷 锟叫讹拷锟斤拷没锟斤拷锟矫伙拷
       userDao.updateUsers(u);;
        
	 request.getRequestDispatcher("listuser1.jsp").forward(request, response);    
    }

}
