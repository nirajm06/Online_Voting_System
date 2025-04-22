<%-- 
    Document   : Add_Election
    Created on : 30 Dec, 2023, 6:54:17 AM
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
    <link rel="stylesheet" href="Homepage.css">
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
          <a class="nav-link" href="AdminHome.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Add_Election.jsp">ADD Election</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Add_Candidate.jsp">ADD Candidate</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="AdminView_result.jsp">View Result</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="AdminVotersVoted.jsp">Voters Voted</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Rejected.jsp">View Rejected</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="View_Voters.jsp">View Voters</a>
        </li>
      </ul>
         <img src="images/google.png" class="user-pic" onclick="toggleMenu()">
        
        <div class="sub-menu-wrap" id="subMenu">
            <div class="sub-menu">
                <div class="user-info">
                    <img src="images/user.png">
                    <h3>James Aldrino</h3>
                </div>
                <hr>
                <a href="adminUpdatePage.jsp" class="sub-menu-link" >
                    <img src="images/profile.png">
                    <p>Edit Profile</p>
                </a>
                <a href="#" class="sub-menu-link">
                <form action="Mainlogout.jsp" method="post" class="sub-menu-link">
                    <img src="images/logout.png">
                    <input style="background: #FFFFFF;border: 0;" type="submit" value="Logout" />
                </form>
                </a>
            </div>
        </div>
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
                          <h2>Election Add</h2>
                      </div>
                  </div>
              </div>
              
              <div class="row m-0">
                  <div class="col-md-12 p-0 pt-4 pb-4">
                      <form action="AddelectionChecker" class="bg light p-4,m-auto" method="post">
                          <div class="row">
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <input type="text" name="ename" class="form-control" required placeholder="Election name" />
                              </div>
                          </div>
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <h4>End Date</h4>
                                  <input type="date" name="Edate" class="form-control" required placeholder="End Date" />
                              </div>
                          </div>
                          <input class="btn btn-warning btn-lg btn-black mt-3" type="submit" value="Add" />
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
      <script>
          let subMenu=document.getElementById("subMenu");
          
          function toggleMenu(){
              subMenu.classList.toggle("open-menu");
          }
      </script>
  </body>
</html>

