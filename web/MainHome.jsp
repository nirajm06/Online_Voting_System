<%-- 
    Document   : MainHome
    Created on : 30 Dec, 2023, 3:46:22 AM
    Author     : INDIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 5 Project</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.19.0/font/bootstrap-icons.css"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="adminHome.css">
  </head>
  <body>
       
  <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <div class="container">
      <a class="navbar-brand" href="#"><span class="text-warning">Voting</span>System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="#home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="adminMain.jsp">Admin</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="userMain.jsp">User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="mailto:rathoreaniket70@gmail.com">Contact</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
      
<div id="carouselExampleCaptions" class="carousel slide">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/flag.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption">
        <h5>Empower Your Voice</h5>
        <p>Everyone has the right to life, liberty and security of person</p>
      </div>
    </div>
  </div>
</div>
      
       <!--about section-->
      
      <section id="about" class="about section-padding">
          <div class="container">
              <div class="row">
                  <div class="col-lg-4 col-md-12 col-12">
                      <div class="about-img" style="margin-top: 40px;margin-left: 100px;">
                          <img src="images/about.jpg" alt="" class="img-fluid">
                      </div>
                  </div>
                  <div class="col-lg-8 col-md-12 col-12 ps-lg-5 mt-md-5">
                      <div class="about-text">
                          <h2> We Provide Best Quality<br>Services Ever</h2>
                          <p>Welcome to Online Voting System where your voice matters! Our cutting-edge platform ensures secure, seamless, 
                              and accessible voting experiences. Embrace democracy with confidence as we prioritize security, transparency,
                              and user-friendliness. Let's shape the future together, one vote at a time!</p>
                          <a href="#" class="btn btn-warning">Learn More</a>
                      </div>
                  </div>
              </div>
          </div>
      </section>
       
      <!--footer -->
      
      <footer class="bg-dark p-2 text-center">
          <div class="container">
              <p class="text-white"> All Right Reserved @website Name</p>
          </div>
      </footer> 



      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" ></script>

  </body>
</html>

