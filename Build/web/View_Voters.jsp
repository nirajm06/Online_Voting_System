<%-- 
    Document   : View_Voters
    Created on : 30 Dec, 2023, 6:16:45 AM
    Author     : INDIA
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
        
        <%  String user_id = (String) session.getAttribute("user_id");
            String name = (String) session.getAttribute("name");
            String email_Id = (String) session.getAttribute("mailid");
            String dob = (String) session.getAttribute("dob");
            String gender = (String) session.getAttribute("gender");
            String address = (String) session.getAttribute("address");
            String phoneNo = (String) session.getAttribute("phoneNo");
            String status = (String) session.getAttribute("status1");
            String email_id = (String) session.getAttribute("email_id");
            
            Statement st = null;
            ResultSet rs = null;
            int i=0;
                try {
                    st = DBConnecter.getStatement(); 
String query = "SELECT voters1.name,voters1.email_Id,voters1.dob,voters1.address,voters1.gender,voters1.phoneNo,status1.status1 FROM voters1 INNER JOIN STATUS1 ON voters1.email_Id = status1.email_Id;";
                    System.out.println("Query =" + query);
                    rs = st.executeQuery(query);
            %>
        <!--Content -->
        <div class="container mt-5">
            <table id ="myTable" class="table table-responsive table-bordered border-dark text-hover text-center text-capitalize">
            <tr class ="table-black table-action text-uppercase text-white">
                <th style="width:15%;background: #B87333;">Name</th>
                <th style="width:15%;background: #B87333;">Email ID</th>
                <th style="width:15%;background: #B87333;">DOB</th>
                <th style="width:15%;background: #B87333;">Gender</th>
                <th style="width:15%;background: #B87333;">Address</th>
                <th style="width:15%;background: #B87333;">Phone No</th>
                <th style="width:15%;background: #B87333;">Status</th>
                <th style="width:15%;background: #B87333;">Accept</th>
                <th style="width:15%;background: #B87333;">Reject</th>
                <th style="width:15%;background: #B87333;">Submit</th>
            </tr>
            <% while(rs.next())
            {  %>
             <tr>
                 <td><%=rs.getString("name")%></td>
                 <td><%=rs.getString("email_id")%></td>
                 <td><%=rs.getString("dob")%></td>
                 <td><%=rs.getString("gender")%></td>
                 <td><%=rs.getString("address")%></td>
                 <td><%=rs.getString("phoneNo")%></td>
                 <td><%=rs.getString("status1")%></td>
                              <form action="viewVotersChecker" method="post">
                                  <td><input type="radio" class="btn btn-warning"  value="Accept" name="radio1" /></td>                 
                                  <td><input type="radio" class="btn btn-warning"  value="Reject" name="radio1" /></td>
                                  <td><input type="submit" class="btn btn-warning" value="submit" id="submit" /></td>
                              </form> 
                 </tr>
              </div>
             <%          }
                        }
                     catch (SQLException ex) {
                        System.out.println(ex);
                    }%>
        </table>
        
        
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
      <script>
           let popup = document.getElementById("popup");;
          function openPopup(){
              popup.classList.add("open-popup");
          }
          function closePopup(){
              popup.classList.remove("open-popup");
          }
      </script>
      </script>
    </body>
</html>
