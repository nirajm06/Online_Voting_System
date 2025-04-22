<%-- 
    Document   : AdminVotersVoted
    Created on : 20 Sep, 2024, 4:17:39 PM
    Author     : ratho
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="db.DBConnecter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
      5<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
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
                          <h2>ELECTIONS</h2>
                          <p>For Accessing over Services First you have to sign in according to your Eligibility.</p>
                      </div>
                  </div>
              </div>
              
              <div class="row m-0">
                  <div class="col-md-12 p-0 pt-4 pb-4">
                          <div class="row">
                          <div class="col-md-12">
                              <div class="mb-3">
                                      <!--Content -->
        <div class="container mt-5">
            
            <table id ="myTable" class="table table-responsive  table-bordered border-dark text-hover text-center text-capitalize">
            <tr class ="table-black table-action text-uppercase text-white">
                <th style="width:36%;background: #FFA500;">Voters Id</th>
                <th style="width:36%;background: #FFA500;">Election Name</th>
                <th style="width:37%;background: #FFA500;">Votes</th>
            </tr>
        <%  
            String Election_name = (String) session.getAttribute("election_name");
            System.out.println(Election_name);
            Statement st = null;
            ResultSet rs = null;
                try {
                    st = DBConnecter.getStatement();
                    String query = "SELECT * FROM votes";
                    System.out.println("Query =" + query);

                    rs = st.executeQuery(query);
            %>
                                      <% 
                                          while(rs.next())
                                        { %>
                                        <tr>
                 <td><%=rs.getString("email_Id")%></td>
                 <td><%=rs.getString("election_name")%></td>
                 <td><%=rs.getString("vote")%></td>
                 <td>
                                        <tr>
                            <%             }
                                    }
                     catch (SQLException ex) {
                        System.out.println(ex);
                    }%>
                    </table>
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
