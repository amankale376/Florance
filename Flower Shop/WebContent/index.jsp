<!DOCTYPE html>
<%@page import="fs.entity.Contact"%>
<%@page import="fs.entity.Flowers_img"%>
<%@page import="java.util.List"%>
<%@page import="fs.entity.Flowers"%>
<%@page import="fs.entity.About_img"%>
<%@page import="fs.entity.About"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Florance</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: iPortfolio - v1.4.0
  * Template URL: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
 <style>
 #hero {
  width: 100%;
  height: 100vh;
  background: url("assets/img/background/hero-bg.jpg") top center;
  background-size: cover;
}

#hero:before {
  content: "";
  background: rgba(5, 13, 24, 0.3);
  position: absolute;
  bottom: 0;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1;
}

#hero .hero-container {
  position: relative;
  z-index: 2;
  min-width: 300px;
}

#hero h1 {
  margin: 0 0 10px 0;
  font-size: 64px;
  font-weight: 700;
  line-height: 56px;
  color: #fff;
}

#hero p {
  color: #fff;
  margin-bottom: 50px;
  font-size: 26px;
  font-family: "Poppins", sans-serif;
}

#hero p span {
  color: #fff;
  padding-bottom: 4px;
  letter-spacing: 1px;
  border-bottom: 3px solid #149ddd;
}

@media (min-width: 1024px) {
  #hero {
    background-attachment: fixed;
  }
}

@media (max-width: 768px) {
  #hero h1 {
    font-size: 28px;
    line-height: 36px;
  }
  #hero h2 {
    font-size: 18px;
    line-height: 24px;
    margin-bottom: 30px;
  }
}
 </style>
 
</head>

<body>

  <!-- ======= Mobile nav toggle button ======= -->
  <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

  <!-- ======= Header ======= -->
  <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
      <br>
        <h1 class="text-light"><a href="index.html">FLORANCE</a></h1>
        <div class="social-links mt-3 text-center">
          <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
          <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
          <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
          <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
          <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
        </div>
      </div>

      <nav class="nav-menu">
        <ul>
          <li class="active"><a href="#hero"><i class="bx bx-home"></i> <span>Home</span></a></li>
          <li><a href="#about"><i class="bx bx-user"></i> <span>About</span></a></li>
          <li><a href="#portfolio"><i class="bx bx-book-content"></i> Flowers</a></li>
          <li><a href="#contact"><i class="bx bx-envelope"></i> Contact</a></li>
           <li><a href="<%=request.getContextPath()%>/admin_controller?action=welcomeAdmin"><i class="bx bx-server"></i> Admin</a></li>

        </ul>
      </nav><!-- .nav-menu -->
      <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex flex-column justify-content-center align-items-center">
    <div class="hero-container" data-aos="fade-in">
      <h1>Florance Flower Shop</h1>
      <p>We're <span class="typed" data-typed-items="Retailer, Event Decorator"></span></p>
    </div>
  </section><!-- End Hero -->

  <main id="main">
	<%
		
	About aboutInfo = (About)request.getAttribute("aboutInfo");
	About_img aboutImg = (About_img)request.getAttribute("aboutImg");
	Flowers flowersInfo = (Flowers)request.getAttribute("flowersInfo");
	List<Flowers_img> flowersImg= (List<Flowers_img>)request.getAttribute("flowersImg");
	Contact info = (Contact)request.getAttribute("contactInfo");	
	  String path1 = "C:\\Users\\Work\\eclipse-workspace\\Flower Shop\\WebContent\\all_images\\";
      String path2 = "C:\\Users\\Work\\eclipse-workspace\\Flower Shop\\WebContent\\flower_images\\";
	%>
    <!-- ======= About Section ======= -->
    <section id="about" class="about">
      <div class="container">

        <div class="section-title">
          <h2><%=aboutInfo.getTitle1()%></h2>
          <p><%--paragraph 2 --%> <%=aboutInfo.getParagraph1() %></p>
        </div>

        <div class="row">
          <div class="col-lg-4" data-aos="fade-right">
            <img src="<%= path1+aboutImg.getName()%>" class="img-fluid" alt="">
          </div>
          <div class="col-lg-8 pt-4 pt-lg-0 content" data-aos="fade-left">
            <h3><%-- title 2 --%> <%= aboutInfo.getTitle2() %></h3>

            <p>
              <%-- paragraph 2 --%> <%= aboutInfo.getParagraph2() %>
            </p>
          </div>
        </div>

      </div>
    </section><!-- End About Section -->

 

    

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio section-bg">
      <div class="container">

        <div class="section-title">
          <h2><%=flowersInfo.getTitle() %></h2>
          <p><%=flowersInfo.getParagraph() %></p>
        </div>
<% 
 int i = 1;
int j = 1;
int k = 1;
%>

		
        <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="100">
        <% for(Flowers_img a: flowersImg){ %>
		<% if(i<4){ %>
          <div class="col-lg-4 col-md-6 portfolio-item filter-app">
            <div class="portfolio-wrap">
              <img src="<%= path2+a.getName()%>" class="img-fluid" alt="">
              <div class="portfolio-links">
                <a href="<%= path2+a.getName()%>" data-gall="portfolioGallery" class="venobox" title="App 1"><i class="bx bx-plus"></i></a>
              
              </div>
            </div>
          </div>
           <%} %>
           <%   i++;} %>
        </div>
       
       
        <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="100">
		  <% for(Flowers_img a: flowersImg){ %>
		 <% if((j==4)&&(j<7)){ %>
          <div class="col-lg-4 col-md-6 portfolio-item filter-app">
            <div class="portfolio-wrap">
              <img src="<%= path2+a.getName()%>" class="img-fluid" alt="">
              <div class="portfolio-links">
                <a href="<%= path2+a.getName()%>" data-gall="portfolioGallery" class="venobox" title="App 1"><i class="bx bx-plus"></i></a>
              
              </div>
            </div>
          </div>
          <%} %> 
            <%  j++; } %>
        </div>
       
       
        <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="100">
          <% for(Flowers_img a: flowersImg){ %>
		 <% if((k==7)&&(k<10)){ %>
          <div class="col-lg-4 col-md-6 portfolio-item filter-app">
            <div class="portfolio-wrap">
              <img src="<%= path2+a.getName()%>" class="img-fluid" alt="">
              <div class="portfolio-links">
                <a href="<%= path2+a.getName()%>" data-gall="portfolioGallery" class="venobox" title="App 1"><i class="bx bx-plus"></i></a>
              
              </div>
            </div>
          </div>
             <%  } %>
                  <% k++;} %>
        </div>
     
      

      </div>
    </section><!-- End Portfolio Section -->

    
    

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container">

        <div class="section-title">
          <h2>Contact</h2>
          <p><%= info.getParagraph() %></p>
        </div>

        <div class="row" data-aos="fade-in">

          <div class="col-lg-5 d-flex align-items-stretch">
            <div class="info">
              <div class="address">
                <i class="icofont-google-map"></i>
                <h4>Location:</h4>
                <p><%= info.getLocation() %></p>
              </div>

              <div class="email">
                <i class="icofont-envelope"></i>
                <h4>Email:</h4>
                <p><%= info.getEmail() %></p>
              </div>

              <div class="phone">
                <i class="icofont-phone"></i>
                <h4>Call:</h4>
                <p><%= info.getCall() %></p>
              </div>

              <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" style="border:0; width: 100%; height: 290px;" allowfullscreen></iframe>
            </div>

          </div>

          <div class="col-lg-7 mt-5 mt-lg-0 d-flex align-items-stretch">
            <form action="<%= request.getContextPath()%>/Florance?action=saveEnq" method="post" class="php-email-form">
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="name">Your Name</label>
                  <input type="text" name="name" class="form-control" id="name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validate"></div>
                </div>
                <div class="form-group col-md-6">
                  <label for="name">Your Email</label>
                  <input type="email" class="form-control" name="email" id="email" data-rule="email" data-msg="Please enter a valid email" />
                  <div class="validate"></div>
                </div>
              </div>
              <div class="form-group">
                <label for="name">Subject</label>
                <input type="text" class="form-control" name="subject" id="subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                <div class="validate"></div>
              </div>
              <div class="form-group">
                <label for="name">Message</label>
                <textarea class="form-control" name="message" rows="10" data-rule="required" data-msg="Please write something for us"></textarea>
                <div class="validate"></div>
              </div>
              
              <button type="submit">Send Message</button>
            </form>
          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="container">
      <div class="copyright">
       
      </div>
      <div class="credits">
       
      </div>
    </div>
  </footer><!-- End  Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/typed.js/typed.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>