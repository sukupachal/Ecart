<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
  
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; 
      margin: auto;
      min-height:200px;
  }

 
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  </style>
      
      <%@ include file="header.jsp" %>
      
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="C:\Users\USER\Desktop\Online Shop\9to5google-hero.jpg" alt="Image">
        <div class="carousel-caption">
          <h3>New Google Pixel2</h3>
          <p>This week's top stories...</p>
        </div>      
      </div>

      <div class="item">
        <img src="C:\Users\USER\Desktop\Online Shop\iphone-8-white.jpg" alt="Image">
        <div class="carousel-caption">
          <h3>iphone 8</h3>
          <p>This week's top stories...</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="container text-center">    
  <h3>What We Do</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="C:\Users\USER\Desktop\Online Shop\bbb.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>Buy This Is Not Your Story</p>
    </div>
    <div class="col-sm-4"> 
      <img src="C:\Users\USER\Desktop\Online Shop\front.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>Buy The Boy Who Loved</p>    
    </div>
    <div class="col-sm-4">
      <div class="well">
       <p>Buy This Is Not Your Story by SAVI SHARMA @just of Rs.75</p>
      </div>
      <div class="well">
       <p>Buy One Indian Girl by Chetan Bhagat @just of Rs.88</p>
      </div>
    </div>
  </div>
</div><br>
  
  <footer class="container-fluid text-center">
  <p>100% Purchase Protection</p>
</footer>
  
</head>
<body>


  

</body>
</html>
