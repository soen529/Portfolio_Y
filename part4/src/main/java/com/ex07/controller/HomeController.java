package com.ex07.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ex07.fileVO.FileVO;

/**
 * Handles requests for the application home page.
 * @param <JSONArray>
 */
@Controller
public class HomeController<Resource,JSONArray> {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		*/
		String filename = (String)request.getAttribute("filename");
		
		System.out.println("--------------------------->"+filename);
		
		String dirName = "E:\\temp\\";
		File dir = new File(dirName);
		
		String files[] =dir.list();
		
		for(String fi: files) {
			System.out.println(fi);
		}
		
		File[] files2 =dir.listFiles();
		
		ArrayList arrList = new ArrayList();
		
		for(File fns:files2) {
			String fileName = fns.getName();
			
			if(fns.isDirectory()) {
				System.out.println("디렉토리입니다."+fileName);
			}else {
				System.out.println(fileName+"\t"+(fns.length()/1024/1024)+"Mbyte");
			
			
			long fiSize = (long) fns.length()/1024;
					
			String fileSize =Long.toString(fiSize);
			FileVO fileVo = new FileVO();
			fileVo.setFileName(fileName);
			fileVo.setFileSize(fileSize+"Kbyte");
			
			arrList.add(fileVo);
		}
	}	
		
		model.addAttribute("arrList", arrList );
		
		return "home";
	}
	
	@RequestMapping(value = "/uploadAjax",method = RequestMethod.POST)
	@ResponseBody
	public void FileUploadAjax(HttpServletResponse rs,FileVO fileVo) throws IOException {
		System.out.println("uploadAjax 호출");
		/*
		ArrayList arrList = new ArrayList();
		arrList.add("12345");
		
		JSONPObject json = new JSONPObject("arrList",arrList);*/
		rs.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = rs.getWriter();
/*		System.out.println(json.toString());*/
		out.print("성공 하였습니다.");
	
		
	/*	return json;*/
		/*
		System.out.println("uploadAjax 호출");
		System.out.println(fileVo.getFileName());
		
		Map <String,Object> result = new HashMap<String,Object>();
		
		result.put("fileVo", "OK");
		
		
		return result;
		
		/*
		File saveFile = new File("C:\\\\Users\\\\samsungpc\\\\download",mediaFile.getOriginalFilename());
		
		mediaFile.transferTo(saveFile);
		
		request.setAttribute("filename",mediaFile.getOriginalFilename());
		
		model.addAttribute("result", "OK");
		*/
		/*
		request.setAttribute("name", "홍길동");
		System.out.println(request.getAttribute("name");
		*/
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,
				headers = ("content-type=multipart/*")
				)
	public String FileUpload(HttpServletRequest request,HttpServletResponse response,@RequestParam("mediaFile"+"i") MultipartFile mediaFile) throws IllegalStateException, IOException, ServletException {
		ArrayList arrList = new ArrayList();
			
		File saveFolder = new File("E:\\temp\\1");
			arrList.add(1, "1");
			arrList.add(2, "2");
			arrList.add(3, "3");
			arrList.add(4, "4");
			arrList.add(5, "5");
			
			for(int i=1;i<arrList.size();i++) {
				 saveFolder.mkdir();
			}
			if(saveFolder.equals("i")) {
			File saveFile = new
					File(saveFolder,mediaFile.getOriginalFilename()+"i");
			
			/*File saveFile = new File("C:\\Users\\samsungpc\\Downloads",mediaFile.getOriginalFilename()); */
			mediaFile.transferTo(saveFile);
			
			request.setAttribute("filename",mediaFile.getOriginalFilename()+"i");
			}
			
			return "redirect"+"http://localhost/forwardTest?filename="+(mediaFile.getOriginalFilename()+"i");
			/* redirect는 전송할 수 없다.* */
			
			/*return "forward:"+"http://localhost:9000";*/

		}
	
	@RequestMapping(value = "/forwardTest", method = RequestMethod.GET)
	public void home(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException, ServletException {
		
		String filename = (String) request.getAttribute("filename");
		
		
		System.out.println("forwardTest========="+filename);
		
		request.setAttribute("filename", "forwardTest 에서 보낸 메시지");
		
		RequestDispatcher reDis = request.getRequestDispatcher("/");
		reDis.forward(request, response);	//forward 전송한 데이터 받을 수 있다.
	}
			
		@RequestMapping(value = "/download",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	
		/*public ResponseEntity<Resource> downloadFile(*/
				
		public ResponseEntity<File> downloadFile(	    
				@RequestHeader("User-Agent") String userAgent,String filename) throws UnsupportedEncodingException
		{
			
			Resource resource = (Resource) new FileSystemResource("C:\\Users\\samsungpc\\Downloads"+filename);
			
			/*
			if(( (FileSystemResource) resource).exists() == false)
			{
				return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
			}
			*/
			
			String resourceNmae = ((FileSystemResource) resource).getFilename();
			
			String resourceOrignalName = resourceNmae.substring(resourceNmae.indexOf("_")+1);
			
			
			HttpHeaders headers = new HttpHeaders();
			
			String downloadName = null;
			if(userAgent.contains("Trident"))
			{
				logger.info("IE browser");
				downloadName = URLEncoder.encode(resourceOrignalName,"UTF-8").replaceAll("\\+", " ");
			}else if(userAgent.contains("Edge")) {
				
				logger.info("Edge browser");
				downloadName = URLEncoder.encode(resourceOrignalName,"UTF-8");
			}else
			{
				logger.info("Chrome browser");
				downloadName = new String(resourceOrignalName.getBytes("UTF-8"),"ISO-8859-1");
			}
			
			logger.info("download:" + downloadName);
			
			headers.add("Content-Disposition","attachment; filename=" + downloadName);
			
			File fn = new File("C:\\Users\\samsungpc\\Downloads\\m.dll");
			
			return (ResponseEntity<File>) new ResponseEntity<File>
			((File) fn,
					headers,HttpStatus.OK);
			
//			return (ResponseEntity<Resource>) 
//					new ResponseEntity<FileSystemResource>
//			((FileSystemResource) resource,headers,HttpStatus.OK);
			
		}
	
}
