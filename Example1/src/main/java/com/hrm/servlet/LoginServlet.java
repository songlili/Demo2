

package com.hrm.servlet;




import com.hrm.dao.UsersDao;
import com.hrm.entity.Users;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet 
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
        String password=request.getParameter("password");
        Users users=new Users();
        users.setUsername(username);
        users.setPassword(password);
       UsersDao userDao = new UsersDao();
       //check锟斤拷锟斤拷  锟斤拷锟斤拷锟斤拷菘锟饺斤拷 锟叫讹拷锟斤拷没锟斤拷锟矫伙拷
       boolean value = userDao.loginUsers(users);
        if(value)
        {
            request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else
        {
             
                request.getRequestDispatcher("loginfaild.jsp").forward(request, response);
        }
        
        
        
        
         
    }

}
