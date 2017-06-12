/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
/*
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
*/
//@MultipartConfig(maxFileSize = 1699999999)

/**
 * Servlet pour gérer les différents fichiers uploadés
 * @author Vincent
 */

/*
@WebServlet(name = "UploadFile", urlPatterns = {"/UploadFile"})
public class UploadFile extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();   
            if (isMultipart) 
            {  
                // Create a factory for disk-based file items  
                FileItemFactory factory = new DiskFileItemFactory();  
                // Create a new file upload handler  
                ServletFileUpload upload = new ServletFileUpload(factory);  
                try 
                {  
                    // Parse the request  
                    List items = upload.parseRequest(request);  
                    Iterator iterator = items.iterator();  
                    while (iterator.hasNext()) 
                    {  
                        FileItem item = (FileItem) iterator.next();  
                        if (!item.isFormField())  
                        {  
                            String fileName = item.getName();      
                            String root = getServletContext().getRealPath("/");  
                            File path = new File(root + "/uploads");  
                            if (!path.exists()){  
                                boolean status = path.mkdirs();  
                            }  
                            
                            File uploadedFile = new File(path + "/" + fileName); 
                            if(!uploadedFile.exists()){
                                System.out.println(uploadedFile.getAbsolutePath());  
                                if(fileName!=""){ 
                                    item.write(uploadedFile);  
                                }else{ 
                                    out.println("file not found");  
                                    out.println("<h1>File Uploaded Successfully....:-)</h1>");  
                                }
                            }else{
                                boolean status2 = uploadedFile.delete();
                                if(status2){
                                    System.out.println("successfully deleted");
                                    System.out.println(uploadedFile.getAbsolutePath());  
                                    if(fileName!=""){ 
                                        item.write(uploadedFile);  
                                    }else{ 
                                        out.println("file not found");  
                                        out.println("<h1>File Uploaded Successfully....:-)</h1>");  
                                    }
                                }else{
                                    System.err.println("Erreur lors de l'upload");
                                    out.println("file found"); 
                                }
                            }
                        }else{  
                            String abc = item.getString();  
                            out.println("<br><br><h1>"+abc+"</h1><br><br>");  
                        } 
                    }
                    response.sendRedirect("http://localhost:8080/poo-livraison/vue/Solution.jsp");
                }catch (FileUploadException e){  
                    out.println(e); 
                }
            }else{  
                out.println("Not Multipart");  
            }  
        }catch (Exception e){  
            out.println(e);  
        }  
    } 
}
*/
