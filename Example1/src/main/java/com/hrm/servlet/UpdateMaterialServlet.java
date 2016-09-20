

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



public class UpdateMaterialServlet extends HttpServlet 
{
        
       public void init() throws ServletException
       {
           super.init();
                     //�����ݿ�����
         
       }
       public void destroy()
       {
        super.destroy();
              //�ر���ݿ����� 
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
         String id=request.getParameter("id");
          Material m=new Material();
          m.setDate(date);
          m.setFile(file);
          m.setId(Integer.parseInt(id));
          m.setDescription(description);
          m.setKeyword(keyword);
         MaterialDao materialDao = new MaterialDao();
         materialDao.updateMaterial(m);
        
	 request.getRequestDispatcher("listmaterial.jsp").forward(request, response);    
    }

}
