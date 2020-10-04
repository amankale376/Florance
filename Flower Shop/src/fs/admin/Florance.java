package fs.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.DAO_admin_about;
import fs.DAO_admin_aboutImg;
import fs.DAO_admin_contact;
import fs.DAO_admin_flowerImg;
import fs.DAO_admin_flowers;
import fs.DAO_admin_new_enq;
import fs.entity.About;
import fs.entity.About_img;
import fs.entity.Contact;
import fs.entity.Flowers;
import fs.entity.Flowers_img;
import fs.entity.New_enq;

@WebServlet("/Florance")
public class Florance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action){
		case "":
			goToIndex(request, response);
			break;
			default:
				goToIndex(request, response);
				break;
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String action = request.getParameter("action");
	 switch(action) {
	 case "saveEnq":
		 saveEnq(request, response);
	 break;
	 }
	
	}

	
	
	public void goToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		aboutPage(request, response);
		flowersPage(request, response);
		contactPage(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void saveEnq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		New_enq info = new New_enq(name,email,subject,message);
		new DAO_admin_new_enq().saveEnq(info);
		goToIndex(request, response);
	}
	
	public void aboutPage(HttpServletRequest request, HttpServletResponse response) {
		About aboutInfo = new DAO_admin_about().getInfo();
		About_img aboutImg = new DAO_admin_aboutImg().getImg();
		request.setAttribute("aboutInfo", aboutInfo);
		request.setAttribute("aboutImg", aboutImg);
	}
	

	public void flowersPage(HttpServletRequest request, HttpServletResponse response) {
	
		Flowers flowersInfo = new DAO_admin_flowers().getInfo();
		List<Flowers_img> flowersImg = new DAO_admin_flowerImg().getImages();
		request.setAttribute("flowersInfo", flowersInfo);
		request.setAttribute("flowersImg", flowersImg);
	}

	public void contactPage(HttpServletRequest request, HttpServletResponse response) {		
	Contact info = new DAO_admin_contact().addInfo();
	request.setAttribute("contactInfo", info);
	}

}
