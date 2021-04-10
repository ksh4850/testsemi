package semitest1.bidnow.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.coobird.thumbnailator.Thumbnails;
import semitest1.bidnow.post.model.dto.CategoryDTO;
import semitest1.bidnow.post.model.dto.ImgDTO;
import semitest1.bidnow.post.model.dto.PostDTO;
import semitest1.bidnow.post.model.service.PostService;
import semitest1.bidnow.user.model.dto.UserDTO;

/**
 * Servlet implementation class PostRegistServlet
 */
@WebServlet("/post/regist")
public class PostRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private String imgLocation;
//	private int fileSize;
	
	
//	@Override
//	public void init() throws ServletException{
//		ServletContext context = getServletContext();
//		//web에 저장한 param을 불러와서 전역변수에 넣는다
//		imgLocation = context.getInitParameter("file-location");
//		fileSize = Integer.valueOf(context.getInitParameter("max-file-size"));
//		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path ="/WEB-INF/views/post/postRegist.jsp";
		String backCode1 =request.getParameter("backCode1");
		String backCode2 =request.getParameter("backCode2");
		
//		System.out.println("get1" + backCode1);
//		System.out.println("get1" + backCode2);
		//전에 있던 카테고리 코드 값 넘겨 받아서 화면단으로 넘겨줌
		//게시물등록을 취소하면 다시 보던화면으로 돌아가기 위해서!!
		request.setAttribute("backCode1", backCode1);
		request.setAttribute("backCode2", backCode2);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String imgLocation = request.getServletContext().getInitParameter("file-location") + "/postImg";
		String thumbnailLocation = request.getServletContext().getRealPath("/") + "resources/thumbnail-image";
		int fileSize = Integer.valueOf(request.getServletContext().getInitParameter("max-file-size"));
		
		System.out.println(thumbnailLocation);
	
		
		File directory = new File(imgLocation);
		File thumbnaildirectory = new File(thumbnailLocation);
		
		//폴더가 없으면 생성해줘라
		if(!directory.exists()) {
			directory.mkdirs();
			System.out.println("폴더 생성");
		}
		
		if(!thumbnaildirectory.exists()) {
			thumbnaildirectory.mkdirs();
			System.out.println("폴더 생성");
		}
		
		
		//encType를 multipart/form-data 로 지정해서 넘오는 값을 받을때  
		if(ServletFileUpload.isMultipartContent(request)) {

			Map<String,String> postInfo = new HashMap<>();
			List<ImgDTO> imgList = new ArrayList<>();
			
			//파일 업로드할 위치 및 크기 
			DiskFileItemFactory fileUploadLocation = new DiskFileItemFactory();
			fileUploadLocation.setRepository(new File(imgLocation));	// 업로드 위치
			fileUploadLocation.setSizeThreshold(fileSize);				// 파일 크기 (int)
			
			//업로드할 위치랑 사이즈를 지정 (바로 위치랑 사이즈 지정 못하는 이유? 매개변수가 DiskFileItemFactory이므로 위에서 지정해주고 넣어줘야됨  )
			ServletFileUpload fileUpload = new ServletFileUpload(fileUploadLocation);			
			// request로 넘어온 값을 하나 하나 파싱해서 때어내줌 (file이든지 date(input태그))
			
			try {
				//파싱된 여러개의 값(file이든지 date(input태그))을 FileItem 자료형으로 리스트에 담음 
				
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
//				for(FileItem item: fileItems) {
//					System.out.println("list 저장값 : " + item);
//				}
				
				for(int i = 0 ; i < fileItems.size() ; i++) {
					
					FileItem file = fileItems.get(i);
					
					if(!file.isFormField()) { //isFormField (false = file , true =data(no file))
						
						if (0<file.getSize()) {
						System.out.println("파일확인안");
						String filedName = file.getFieldName();	 	//request  파라메터의 이름 (input태그의 name )
						String originFiledName = file.getName();	//사용자가 저장할떄 파일 이름 
						
						System.out.println("input태그의 name : " + filedName);
						System.out.println("파일 이름 : " + originFiledName);
						
						int dot = originFiledName.lastIndexOf(".");		//file 자료형 까지 인덱스 찾기 last  붙으면 뒤에서부 찾기
						String ext = originFiledName.substring(dot);	//file 자료형 만 잘라냄  substring index번호 부터 잘라냄
						
						String reFileNam = UUID.randomUUID().toString().replace("-", "") + ext;
						String thnFileName = UUID.randomUUID().toString().replace("-", "") + ext;
						
						System.out.println("saveFileName" + reFileNam);
						//파일의 명이 서로 안겹치게 하기위해서 UUID로 랜덤문자 생성 replace = 문자를 변경해줌 "-" 를 ""(공백)
						
						//파일의 경로와 이름 
						File storeFile = new File(imgLocation + "/" + reFileNam);
						
						//FileItem에서 제공하는 writer를 사용하여 파일저장
						file.write(storeFile);
						
						
						File saveFile = new File(imgLocation + "/" + reFileNam);
						String thnPath = thumbnaildirectory + "/" + thnFileName;
						Thumbnails.of(saveFile)
								.size(300,300)
								.toFile(thnPath);
						System.out.println("썸내일 변환성공 ");
						
						
						
						
						ImgDTO img = new ImgDTO();
						
						img.setOrgFileName(originFiledName);
						img.setReFileName(reFileNam);
						img.setThnFileName(thnFileName);
						
						
						
						imgList.add(img);
						}
					}else {
						
						postInfo.put( file.getFieldName(),  new String(file.getString().getBytes("ISO-8859-1"),"UTF-8"));
						
						System.out.println(file.getFieldName() + "=" + new String(file.getString().getBytes("ISO-8859-1"),"UTF-8") );
					}
					
					
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
				//어떤 종휴의 exception이 발생하더라도 실패시 올라간 파일은 삭제
				int cnt=0;
				for(int i =0 ; i < imgList.size() ; i++) {
					ImgDTO file = imgList.get(i);
					
					File deleteFile = new File(imgLocation+"/"+file.getSavePath());
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt==imgList.size()) {
					System.out.println("업로드성공");
				}else {
					System.out.println("업로드실패");
				}
				
				
			}
//			for(ImgDTO img: imgList) {
//				System.out.println(img);
//			}

			PostDTO postDTO = new PostDTO();
			
			postDTO.setImg(imgList);
			postDTO.setCategory(new CategoryDTO());
			postDTO.getCategory().setCtgLCode(postInfo.get("lCategory"));
			postDTO.getCategory().setCtgSCode(postInfo.get("sCategory"));
			postDTO.setTitle(postInfo.get("title"));
			postDTO.setDetails(postInfo.get("details"));
			postDTO.setMinPrice(Integer.valueOf(postInfo.get("minPrice")));
			
			if(postInfo.get("unOpenedchk") == null) {
				postDTO.setUnOpenedchk("N");
			}else {
				postDTO.setUnOpenedchk("Y");
			}
			postDTO.setBidEndDate(new java.sql.Timestamp(System.currentTimeMillis()+259200000));
			
			UserDTO user = (UserDTO)request.getSession().getAttribute("loginUser");
			postDTO.setSeller(new UserDTO());
			postDTO.getSeller().setNo(user.getNo());
			

//			System.out.println(postDTO.toString());
			
			int result = new PostService().PostRegist(postDTO);
			
			String page ="";
			
			if(result > 0) {
				
				page = "/WEB-INF/views/common/success.jsp";
				
				request.setAttribute("successCode", "PostRegist");
				request.setAttribute("scategory", postDTO.getCategory().getCtgSCode());
				
				
			} else {
				
				page = "/WEB-INF/views/common/failed.jsp";
				
				request.setAttribute("message", "게시물 등록실패! 실패!");
			}

			request.getRequestDispatcher(page).forward(request, response);
			
			
			
			
			
		}
			
		
	}

}
