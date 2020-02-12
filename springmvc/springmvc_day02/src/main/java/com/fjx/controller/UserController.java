package com.fjx.controller;


import com.fjx.domain.User;
import com.fjx.exception.SysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, String username, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了");
        System.out.println(username);
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(User user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        user.setId(5);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items){
            if(!item.isFormField()){
                String filename = item.getName();
                String name = UUID.randomUUID().toString().replace("-", "")+filename;
                item.write(new File(file,name));
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/testFileUpload2")
    public String testFileUpload2(HttpServletRequest request, MultipartFile file) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File f = new File(realPath);
        if(!f.exists()){
            f.mkdirs();
        }
        String originalFilename= file.getOriginalFilename();

        String filename = UUID.randomUUID().toString().replace("-","")+originalFilename;
        file.transferTo(new File(f,filename));
        return "success";
    }

    @RequestMapping("/testFileUpload3")
    public String testFileUpload3(MultipartFile file) throws IOException {
        String path = "http://localhost:9090/springmvc_day02_uploadService/upload/";
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString().replace("-","")+originalFilename;
        Client client = Client.create();
        WebResource resource = client.resource(path + filename);
        resource.put(file.getBytes());
        return "success";
    }

    @RequestMapping("/testSysException")
    public String testSysException() throws SysException {
        try {
            System.out.println("testSysException");
            int i = 1 / 0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("错误");
        }
        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
