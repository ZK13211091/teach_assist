package com.gao.ta.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class uploadservlet extends HttpServlet {
	
	private  String[] fileExts={"doc","zip","rar","jpg","txt"};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Boolean  isMultipart = ServletFileUpload.isMultipartContent(req);
		String name = req.getParameter("username");
		
		if(isMultipart){
			DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024*5,new File("D:\\temp"));
			
			ServletFileUpload upload=new ServletFileUpload(factory); 
			upload.setSizeMax(1024*1024*50);  
            upload.setFileSizeMax(1024*1024*5);
            
            try{
            	
            	List<FileItem> items = upload.parseRequest(req);
            	for(FileItem fileItem : items){
            		
            		if(fileItem.isFormField()){
            			
            			System.out.println(fileItem.toString());
            		}
            		
            		
            		else{
            			String filename = fileItem.getName();
            			String fileExt = filename.substring(filename.lastIndexOf(".")+1,filename.length());
            			
            			if(Arrays.binarySearch(fileExts, fileExt)!=-1){
            				
            				try{
            					fileItem.write(new File("C:\\Users\\Mr.Gao\\Desktop\\uploadFile"+"\\"+name+UUID.randomUUID().toString()+"."+fileExt));
            					System.out.println("successful!");
            				}catch(Exception e){
            					e.printStackTrace();
            				}
            			}
            			
            			else{
            				
            				System.out.println("failed!");
            			}
            		}
            	}
            }catch(SizeLimitExceededException e){
            	System.out.println("overflow");
            }
            catch(FileSizeLimitExceededException e){
            	System.out.println("too large");
            }
            catch(FileUploadException e){
            	e.printStackTrace();
            }
			
		}
	}

}
