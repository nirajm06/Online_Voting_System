<%-- 
    Document   : ElectionPage2
    Created on : 30 Dec, 2023, 11:31:07 AM
    Author     : INDIA
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="db.DBConnecter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <%   String mailid = (String) session.getAttribute("email_id");
         System.out.println("JSP :"+mailid);
         Cookie email_id = new Cookie("email_id",mailid);
         response.addCookie(email_id);%>
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
          <a class="nav-link" href="#home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Elections</a>
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
                <a href="userUpdatePage.jsp" class="sub-menu-link" >
                    <img src="images/profile.png">
                    <p>Edit Profile</p>
                </a>
                <a href="#" class="sub-menu-link">
                    <img src="images/help.png">
                    <p>Help & Support</p>
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
      
      <section id="contact" class="contact section-padding">
          
      <%    String name = (String) session.getAttribute("name");
            String party_name = (String) session.getAttribute("party_name");
            String Election_name = (String) request.getParameter("Election_name");
            session.setAttribute("Election_name",Election_name);
            Statement st = null;
            ResultSet rs = null,rs1 = null,rs2=null;
            String ename="";
                try {
             st = DBConnecter.getStatement();
             String query2="SELECT votes.election_name FROM votes WHERE votes.email_Id ='"+mailid+"' AND votes.election_name='"+Election_name+"'";
            System.out.println("Query=" +query2);
            
             rs2=st.executeQuery(query2);
            
            if(rs2.next()){
                ename=rs2.getString("election_name");
                System.out.println("rs2");
            }
            System.out.println(ename);
            System.out.println(Election_name);
            if(ename.equals(Election_name))
            {
                System.out.println("Response");
                response.sendRedirect("ElectionPage2Voted.jsp");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
            
                try {
                    st = DBConnecter.getStatement();
                    String query = "SELECT * FROM candidate1 WHERE election_name='"+Election_name+"'";
                    System.out.println("Query ="+ query);

                    rs = st.executeQuery(query);
                    if(rs.next())
                    {  %>
      <div class="container">
              <div class="row">
                  <div class="col-md-12">
                      <div class="section-header text-center pb-5">
                          <h2><%=rs.getString("Election_name")%></h2>
                      </div>
                  </div>
              </div>
      </div>    <%}%>  
                      
        <!--Content -->
        <div class="container mt-5">
            
            <table id ="myTable" class="table table-responsive table-bordered border-dark text-hover text-center text-capitalize">
            <tr class ="table-black table-action text-uppercase text-white">
                <th style="width:30%;background: #FFA500;">Candidate Profile</th>
                <th style="width:30%;background: #FFA500;">Candidate Name</th>
                <th style="width:30%;background: #FFA500;">Party Name</th>
                <th style="width:30%;background: #FFA500;">Voter</th>
            </tr>
            <%
                rs1 = st.executeQuery(query);
                while(rs1.next()) 
            {%>
             <tr>
                 <td>
            <img src="showimage.jsp?name=<%= rs1.getString("name") %>" height="300" width="300" alt="Image not found" />
                 </td>
                 <td><%=rs1.getString("name")%></td>
                 <td><%=rs1.getString("party_name")%></td>
                 <td><form action="electionpage2Checker" method="post">
                     <input type="hidden" name="vote" value="<%=rs1.getString("vote")%>"/>
                     <input type="hidden" name="party_name" value="<%=rs1.getString("party_name")%>"/>
                     <input type="submit" class="btn btn-warning" name="vote" value="vote" />
                     </form>
                 </td>
                 </tr>
                 <%}%>
             
        </table>
        </div>
      </section>
         <%             }
                        
                     catch (SQLException ex) {
                        System.out.println(ex);
                    }%>
     
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

