<%-- 
    Document   : Add_CandidateImage
    Created on : 5 Sep, 2024, 6:00:46 PM
    Author     : ratho
--%>

<%@page import="db.DBConnecter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
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
          <div class="container">
              <div class="row">
                  <div class="col-md-12">
                      <div class="section-header text-center pb-5">
                          <h2>ADD CANDIDATE Image</h2>
                          <p>For Accessing over Services First you have to sign in according to your Eligibility.</p>
                      </div>
                  </div>
              </div>
              <form method="post" action="addCandidateImageChecker" class="bg light p-4,m-auto" enctype="multipart/form-data">
              <div class="row m-0">
                  <div class="col-md-12 p-0 pt-4 pb-4">
                      <%  
            Statement st = null;
            ResultSet rs = null;
                try {
                    st = DBConnecter.getStatement();
                    String query = "SELECT election_name,name FROM candidate1";
                    System.out.println("Query =" + query);
                    rs = st.executeQuery(query);
            %>
                          <div class="row">
                          <div class="col-md-12">
                              <div class="mb-3">
                                  <select id="select2" class="form-select" placeholder="select name" name="name">
                                   <% while(rs.next())
                                      {  %>
                                      <label for="select2">Pick a tour</label>
                                  <option name="name" value="<%=rs.getString("name")%>"><%=rs.getString("name")%></option>
                                  <%}%>
                                  </select>
                                  <%         
                                    }
                                   catch (SQLException ex) {
                                   System.out.println(ex);
                                   }%>
                              </div>
                          </div>
                      <div class="row">
                          <div class="col-md-6">
                              <div class="mb-3">
                                  <center>
                                  <figure class="image-container" style="width:90%;margin: 0 auto 30px auto;">
                                      <img id="chosen-image" style="display:block;position:relative;max-width:100%;max-height:400px;margin:auto;">
                                      <figcaption id="file-name" style="margin: 20px 0 30px 0;text-align:center;color:#FFA500">
                                      </figcaption>
                                  </figure>
                                  
                                    <label for="Upload-button" style="display:block;position:relative;background-color:#FFA500;color:#ffffff;font-size:18px;text-align:center;width:300px;padding:18px 0;border-radius:5px;margin:auto;cursor:pointer;">
                                      <i style="font-size: 5rem;" class="bi bi-cloud-arrow-up-fill" aria-hidden="true"></i> &nbsp;
                                      <p class="text-dark">Choose Your image To upload</p>
                                      <input type="file" name="empimage" size="20" id="upload-button" onclick="imagePreview()">
                                  </label>
                                  </center>
                              </div>
                          </div>
                          <input class="btn btn-warning btn-lg btn-black mt-3" type="submit" value="submit" />
                      </div>
                  </div>
              </div>
             </form>
          </div>
      </section>
        
        <!--footer -->

        <!--footer -->
      
      <footer class="bg-dark p-2 text-center">
          <div class="container">
              <p class="text-white"> All Right Reserved @website Name</p>
          </div>
      </footer> 

       <!--Script -->
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" ></script>
       <script>
           function imagePreview(){
let uploadButton = document.getElementById("upload-button");
let chosenImage = document.getElementById("chosen-image");
let fileName = document.getElementById("file-name");

uploadButton.onchange = () => {
    let reader = new FileReader();
    reader.readAsDataURL(uploadButton.files[0]);
    reader.onload = () => {
        chosenImage.setAttribute("src",reader.result);
    }
    fileName.textContent = uploadButton.files[0].name;
}
}
       </script>
       <script>
          let subMenu=document.getElementById("subMenu");
          function toggleMenu(){
              subMenu.classList.toggle("open-menu");
          }
      </script>
    </body>
</html>
