

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



public class DeleteUserServlet extends HttpServlet 
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
       String id= request.getParameter("id");//锟斤拷媒锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
       // String patientname=request.getParameter("id");
       // String sex=request.getParameter("sex");
       // String birthday=request.getParameter("birthday");
       // String content=request.getParameter("content");
       // String telephone=request.getParameter("telephone");
        Users u=new Users();
        u.setId(Integer.parseInt(id));
       // p.setBirthday(birthday);
       // p.setContent(content);
       // p.setPatientname(patientname);
       // p.setSex(sex);
       /// p.setTelephone(telephone);
       UsersDao userDao = new UsersDao();
       //check锟斤拷锟斤拷  锟斤拷锟斤拷锟斤拷菘锟饺斤拷 锟叫讹拷锟斤拷没锟斤拷锟矫伙拷
       userDao.deleteUsers(u);
        
	 request.getRequestDispatcher("listuser1.jsp").forward(request, response);    
    }

}
