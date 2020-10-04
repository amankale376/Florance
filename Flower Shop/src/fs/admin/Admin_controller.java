package fs.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import fs.DAO_admin_about;
import fs.DAO_admin_aboutImg;
import fs.DAO_admin_contact;
import fs.DAO_admin_flowerImg;
import fs.DAO_admin_flowers;
import fs.DAO_admin_login;
import fs.DAO_admin_new_enq;
import fs.DAO_admin_old_enq;

import fs.entity.About;
import fs.entity.About_img;
import fs.entity.Contact;
import fs.entity.Flowers;
import fs.entity.Flowers_img;
import fs.entity.Login;
import fs.entity.New_enq;
import fs.entity.Old_enq;



@WebServlet("/admin_controller")
public class Admin_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String path1 = "C:\\Users\\Work\\eclipse-workspace\\Flower Shop\\WebContent\\all_images\\";
       String path2 = "C:\\Users\\Work\\eclipse-workspace\\Flower Shop\\WebContent\\flower_images\\";
       String status;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
		
		switch(action){
		case "AdminLogin":
			loginAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "aboutAdmin":
			aboutAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "enquires":
			enquires(request,response);
			navbarInfo(request,response);
			break;
		case "flowersAdmin":
			flowersAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "contactAdmin":
			contactAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "navbar_enq":
			enquires(request, response);
			navbarInfo(request,response);
			break;
		case "newEnquiresDelete":
			deleteNewEnquires(request, response);
			navbarInfo(request,response);
			break;
		case "oldEnquiresDelete":
			oldNewEnquires(request, response);
			navbarInfo(request,response);
			break;
		case "welcomeAdmin":
			welcomeAdmin(request,response);
			break;
		case "byeAdmin":
			byeAdmin(request,response);
			break;
		case "home1":
			homeMethod(request, response);
			break;
		case "deleteAboutImg":
			deleteAboutImg(request,response);
			navbarInfo(request,response);
			break;
		case "deleteflowerimg":
			deleteFlowerImg(request,response);
			break;
		
		case "profile":
		 status = "you can change your username and password here.";
			
			goToProfile(request,response);
			navbarInfo(request,response);
			break;

			default:
				homeMethod(request, response);
				break;
			
		}
		
		
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action){
		case "AdminLogin":
			loginAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "contactFormAdmin":
			contactFormAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "flowersFormAdmin":
			flowerFormAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "aboutFormAdmin":
			aboutFormAdmin(request,response);
			navbarInfo(request,response);
			break;
		case "aboutImg":
			aboutImg(request,response);
			navbarInfo(request,response);
			break;
		case "profileFormAdmin":
			updateProfile(request,response);
			navbarInfo(request,response);
			break;
		case "flowerImg":
			try {
				flowerImg(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			navbarInfo(request,response);
			break;
		}
	}

	
//*******************PROFILE PAGE*********************************************************************	

	
private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		Login info = new DAO_admin_login().getDetails();
			
				
				if(oldPassword.equals(info.getPassword())) {
					
					if(newPassword.equals(confirmPassword)) {
						new DAO_admin_login().updateInfo(username,confirmPassword);
						status= "Password Updated!!";
						goToProfile(request, response);
				
					}else {
						status="New Password and Confirm Password does not match!!";
						goToProfile(request, response);
					}
					
				}else {
					status="old password is incorrect!!";
					goToProfile(request, response);
				}
				
			

	}

	
	
	private void goToProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("status1", status);
		navbarInfo(request,response);
		Login info = new DAO_admin_login().getDetails();
		request.setAttribute("username", info.getUsername());
		request.getRequestDispatcher("ADMIN\\examples\\profile.jsp").forward(request, response);
		
	}

//**************************END PROFILE PAGE********************************************************************************
	
	
	
//*******************FLOWERS PAGE*********************************************************************	
		
	private void deleteFlowerImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		new DAO_admin_flowerImg().deleteImg(id);
		File file = new File(path2+name);
		if(file.delete()) {
		System.out.println("image deleted");}else {System.out.println("problem while deleteing image");}
		flowersAdmin(request, response);
		
	}
	
	
	private void flowerImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
 	ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
 	List<FileItem> images = upload.parseRequest(request);
 	for(FileItem img : images) {
 		String name=img.getName();
 		name = name.substring(name.lastIndexOf("\\")+1);
 		File file = new File(path2+name);
 		if(!file.exists()) {
 			img.write(file);
 			new DAO_admin_flowerImg().addImages(name);
 		}else {System.out.println("picture with this name already present in the data base.");}
			
 	}
		flowersAdmin(request, response);
	}

	private void flowerFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 1;
		String title = request.getParameter("title");
		String para = request.getParameter("para");
		Flowers getflow = new DAO_admin_flowers().getInfo();
		
	
		
		System.out.println(getflow.getTitle());
		Flowers flow = new Flowers(id, title, para);
		new DAO_admin_flowers().updateForm(flow);
		flowersAdmin(request, response);
		System.out.println("info updated with "+title+" and "+para);
		
	}

	private void flowersAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flowers getflow = new DAO_admin_flowers().getInfo();
		List<Flowers_img> imgs = new DAO_admin_flowerImg().getImages();
		request.setAttribute("getflow", getflow);
		request.setAttribute("username", "admin");
		request.setAttribute("path", path2);
		if(imgs.size()==0) {
			System.out.println("empty list recived");
			request.setAttribute("recievedList","no");
		}else {
			System.out.println("good to go ");
			request.setAttribute("recievedList","yes");
		}
		request.setAttribute("imgflowers", imgs);
		navbarInfo(request, response);
		request.getRequestDispatcher("ADMIN/examples/flowers.jsp").forward(request, response);
	}



//**************************END FLOWER PAGE********************************************************************************

//**************************ABOUT PAGE********************************************************************************
	
	private void deleteAboutImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 1;
		About_img img = new DAO_admin_aboutImg().getImg();
		String name = img.getName();
		new DAO_admin_aboutImg().deleteImg(id);
		File file = new File(path1+name);
		if(file.delete()) {
		System.out.println("image deleted");}else {System.out.println("problem while deleteing image");}
		aboutAdmin(request, response);
	}

	private void aboutImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> images = upload.parseRequest(request);
			for(FileItem img: images) {
				String name=img.getName();
				name= name.substring(name.lastIndexOf("\\")+1);
				try {
					File file1 = new File(path1+name);
					if(!file1.exists()) {
						img.write(file1);
						new DAO_admin_aboutImg().addFileDb(name);
					}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			
		}
		
		aboutAdmin(request, response);
	}

	private void aboutFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title1 = request.getParameter("title1");
		String paragraph1= request.getParameter("paragraph1");
		String title2= request.getParameter("title2");
		String paragraph2= request.getParameter("paragraph2");
		int id= 1;
		About info = new About(id, title1, paragraph1, title2, paragraph2);
		new DAO_admin_about().saveInfo(info);	
		aboutAdmin(request, response);
		
	}
	
	private void aboutAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		About info = new DAO_admin_about().getInfo();
		request.setAttribute("about_info", info);
		request.setAttribute("username", "admin");
		About_img img = new DAO_admin_aboutImg().getImg();
		request.setAttribute("about_img", img);
		navbarInfo(request, response);
		request.getRequestDispatcher("ADMIN/examples/about.jsp").forward(request, response);
		
	}


//**************************END ABOUT PAGE********************************************************************************

	
//**************************ENQUIRES PAGE********************************************************************************

	private void oldNewEnquires(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new DAO_admin_old_enq().deleteAll();
		enquires(request, response);
	}


	private void deleteNewEnquires(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<New_enq> list=new DAO_admin_new_enq().new_enq_info();
		new DAO_admin_old_enq().addToOld(list);
		new DAO_admin_new_enq().deleteList();
		enquires(request, response);
		
	}

	private void enquires(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username", "admin");
		List<New_enq> list1 = new DAO_admin_new_enq().new_enq_info();
		List<Old_enq> list2 = new DAO_admin_old_enq().old_enq_info();
	request.setAttribute("new_enq_list", list1);
		 request.setAttribute("old_enq_list", list2);
		 navbarInfo(request, response);
		// response.sendRedirect("ADMIN/examples/home.jsp");
		 request.getRequestDispatcher("ADMIN/examples/home.jsp").forward(request, response);
	}

//**************************END ENQUIRES PAGE********************************************************************************

	
//**************************CONTACT PAGE********************************************************************************

	private void contactFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("username", "admin");
		int id=1;
		String email= request.getParameter("email");
		String location= request.getParameter("location");
		String paragraph= request.getParameter("paragraph");
		String call= request.getParameter("call");
		Contact contact = new Contact(call, email, location, paragraph, id);
		new DAO_admin_contact().storeInfo(contact);
		contactAdmin(request, response);
	}

	
	private void contactAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("username", "admin");
		Contact info  = new DAO_admin_contact().addInfo();
		request.setAttribute("info", info);
		navbarInfo(request, response);
		request.getRequestDispatcher("ADMIN/examples/contact.jsp").forward(request, response);
	}

	
//**************************END CONTACT PAGE********************************************************************************

//**************************LOGIN RELATED METHODS********************************************************************************

	private void navbarInfo(HttpServletRequest request, HttpServletResponse response) {
		List<New_enq> list1 = new DAO_admin_new_enq().new_enq_info();
		int length= list1.size();
		request.setAttribute("new_size", length);
		System.out.println(length);
	}

	
	private void homeMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new Florance().goToIndex(request, response);
	}
	
	private void byeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.removeAttribute("username");
		homeMethod(request, response);
	}


	private void welcomeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("ADMIN/examples/login.jsp").forward(request, response);
		
	}

	private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password = request.getParameter("pass");
		Login login = new DAO_admin_login().getDetails();
		if(login.getUsername().equals(username) && login.getPassword().equals(password)) {
			request.getSession().invalidate();
			HttpSession one = request.getSession(true);
			request.setAttribute("username", username);
			one.setMaxInactiveInterval(300);
		List<New_enq> list1 = new DAO_admin_new_enq().new_enq_info();
		List<Old_enq> list2 = new DAO_admin_old_enq().old_enq_info();
	request.setAttribute("new_enq_list", list1);
		 request.setAttribute("old_enq_list", list2);
		 navbarInfo(request, response);
		// response.sendRedirect("ADMIN/examples/home.jsp");
		 request.getRequestDispatcher("ADMIN/examples/home.jsp").forward(request, response);
	
			System.out.println("Login successfull");
		}else {
			response.sendRedirect("ADMIN/examples/login.jsp");

			System.out.println("Login unsuccessfull");
		}
		
	
	}
	

//**************************END LOGIN RELATED METHODS********************************************************************************
	
	

}
