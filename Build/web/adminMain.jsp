<%-- 
    Document   : Home
    Created on : 12 Dec, 2023, 10:40:53 AM
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
          <a class="nav-link" href="MainHome.jsp">Home</a>
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
      
      <!--contact section-->
      <section id="contact" class="contact section-padding">
          <div class="container">
              <div class="row">
                  <div class="col-md-12">
                      <div class="section-header text-center pb-5">
                          <h2>Sign In</h2>
                          <p>For Accessing over Services First you have to sign in according to your Eligibility.</p>
                      </div>
                  </div>
              </div>
              
              <div class="row m-0">
                  <div class="col-md-12 p-0 pt-4 pb-4">
                      <form action="AloginChecker" class="bg light p-4,m-auto" method="post">
                          <div class="row">
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="text" class="form-control" name="email_id" required placeholder="Your Email Here" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="password" class="form-control" name="password" required placeholder="Your Password Here" />
                              </div>
                          </div>
                          <input class="btn btn-warning btn-lg btn-black mt-3" style="color: white;" type="submit" value="Login" />
                          <div class="input-group mb-3">
                          <button class="btn btn-lg btn-light w-10 fs-6"><img src="images/google.png" style="width:20px;text-align:center;" class="me-2"><small>Sign In with Google</small></button>
                          </div>
                          <div class="row">
                          <small>For generating a Password Click on -><a href="AdminSet_Password.jsp">Set Password?</a></small>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </section>
      
      <!--contact section-->
      <section id="contact" class="contact section-padding">
          <div class="container">
              <div class="row">
                  <div class="col-md-12">
                      <div class="section-header text-center pb-5">
                          <h2>Registration</h2>
                          <p>For Accessing over Services First you have to sign in according to your Eligibility.</p>
                      </div>
                  </div>
              </div>
              
              <div class="row m-0">
                  <div class="col-md-12 p-0 pt-4 pb-4">
                       <form action="AregistrationChecker" class="bg light p-4,m-auto" method="post">
                          <div class="row">
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="text" name="name" class="form-control" required placeholder="Your full name" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="date" name="dob" class="form-control" required placeholder="Your Date of birtth Here" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="email" name="email_id" class="form-control" required placeholder="Your Email Here" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="text" name="gender" class="form-control" required placeholder="Your Gender Here" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="text" name="phoneno" class="form-control" required placeholder="Your Phone No Here" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="text" name="address" class="form-control" required placeholder="Your Address Here" />
                              </div>
                          </div>
                          <input class="btn btn-warning btn-lg btn-black mt-3" style="color: white;" type="submit" value="submit" />
                          </div>
                      </form>
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
