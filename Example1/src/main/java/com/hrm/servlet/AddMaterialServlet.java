

package com.hrm.servlet;




import com.hrm.dao.MaterialDao;
import com.hrm.dao.UsersDao;
import com.hrm.entity.Material;
import com.hrm.entity.Users;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddMaterialServlet extends HttpServlet 
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
        String keyword=request.getParameter("keyword");
        String date=request.getParameter("date");
        String file=request.getParameter("file");
        String description=request.getParameter("description");
        Material m=new Material();
        m.setDate(date);
        m.setFile(file);
        m.setDescription(description);
        m.setKeyword(keyword);
       MaterialDao materialDao = new MaterialDao();
       //check锟斤拷锟斤拷  锟斤拷锟斤拷锟斤拷菘锟饺斤拷 锟叫讹拷锟斤拷没锟斤拷锟矫伙拷
       materialDao.addMaterial(m);
        System.out.println(keyword);
        System.out.println(description);
	 request.getRequestDispatcher("listmaterial.jsp").forward(request, response);    
    }

}
