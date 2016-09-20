

package com.hrm.servlet;




import com.hrm.dao.MaterialDao;
import com.hrm.dao.UsersDao;
import com.hrm.entity.Material;
import com.hrm.entity.Users;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DownloadMaterialServlet extends HttpServlet 
{
        
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        //得到下载文件的名字
     //  String filename=request.getParameter("file");
        
        //解决中文乱码问题
        String filename=new String(request.getParameter("file").getBytes("iso-8859-1"),"utf-8");

        //创建file对象
        File file=new File(filename);

        //设置response的编码方式
        response.setContentType("application/x-msdownload");

        //写明要下载的文件的大小
        response.setContentLength((int)file.length());

        //设置附加文件名
       // response.setHeader("Content-Disposition","attachment;filename="+filename);
        
        //解决中文乱码
    response.setHeader("Content-Disposition","attachment;filename="+new String

(filename.getBytes("utf-8"),"iso-8859-1"));        

        //读出文件到i/o流
        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream buff=new BufferedInputStream(fis);

        byte [] b=new byte[1024];//相当于我们的缓存

        long k=0;//该值用于计算当前实际下载了多少字节

        //从response对象中得到输出流,准备下载

        OutputStream myout=response.getOutputStream();

        //开始循环下载

        while(k<file.length()){

            int j=buff.read(b,0,1024);
            k+=j;

            //将b中的数据写到客户端的内存
            myout.write(b,0,j);

        }

        //将写入到客户端的内存的数据,刷新到磁盘
        myout.flush();
   	 request.getRequestDispatcher("listmaterial.jsp").forward(request, response);    


    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }

    //Clean up resources
    public void destroy() {
    }


}
