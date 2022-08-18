<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  
<title>Hello World - JSP tutorial</title>
<style>
    @media screen and (min-device-width: 768px)  {
        .container {
        background-color:  #fff;   
        border-radius: 16px 16px 16px 16px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        width: 350px;
        height: 430px;
     }
    .user{
       color: darkslategray;
       width: 230px;
       height: 30px;
       font-size: 20px;
       background-color: transparent;
       border-top: none;
       border-right: none;
       border-left: none;
       border-bottom: 1.5px solid #001219;
    }
    .email{
       color: darkslategray;
       width: 230px;
       height: 30px;
       font-size: 20px;
       background-color: transparent;
       border-top: none;
       border-right: none;
       border-left: none;
       border-bottom: 1.5px solid #001219;
    }
    .pass{
       color: darkslategray;
       width: 230px;
       height: 30px;
       font-size: 20px;
       background-color: transparent;
       border-top: none;
       border-right: none;
       border-left: none;
       border-bottom: 1.5px solid #001219;
    }
    .sub
    {
       background-color: #8DA242;
       border: none;
       color: white;
       padding: 13px 30px;
       text-align: center;
       text-decoration: none;
       display: inline-block;
       font-size: 16px;
    }
    
    .form-horizontal {
        padding-top: 40px;
        padding-bottom: 40px;
   }
   .alert
            {
                margin-top: 10px;
                width: 300px;
                height: auto;
            }
    }
/* MOBILE SCRIPT */
@media screen and (orientation: portrait)  {
    .container {
        background-color:  #fff;   
        border-radius: 16px 16px 16px 16px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        width: auto;
        height: auto;
     }
    .user{
       color: darkslategray;
       width: 230px;
       height: 30px;
       font-size: 20px;
       background-color: transparent;
       border-top: none;
       border-right: none;
       border-left: none;
       border-bottom: 1.5px solid #001219;
    }
    .email{
       color: darkslategray;
       width: 230px;
       height: 30px;
       font-size: 20px;
       background-color: transparent;
       border-top: none;
       border-right: none;
       border-left: none;
       border-bottom: 1.5px solid #001219;
    }
    .pass{
       color: darkslategray;
       width: 230px;
       height: 30px;
       font-size: 20px;
       background-color: transparent;
       border-top: none;
       border-right: none;
       border-left: none;
       border-bottom: 1.5px solid #001219;
    }
    .sub
    {
       background-color: #8DA242;
       border: none;
       color: white;
       padding: 13px 30px;
       text-align: center;
       text-decoration: none;
       display: inline-block;
       font-size: 16px;
    }
    
    .form-horizontal {
        padding-top: 40px;
        padding-bottom: 40px;
   }
   .alert
            {
                margin-top: 10px;
                width: 300px;
                height: auto;
            }
    }
   </style>
</head>
<center>
<body class="body">
        
    <style>
        .body {
            background-color:#A7BC5B;
            padding-left: 40px;
            padding-right: 40px;
        }
        </style>
   <br><h2 class="h2" style="color:#fff;">JOIN US IN OUR JOURNEY
   </h2><br>
   <div class="container">
    <div class="row"></div>
    <div>
        <form class="form-horizontal" name="loginForm" method="post" action="/reg">
            <input class="user" type="text" name="username" placeholder="Username" /><br><br>
            <input class="email" type="email" name="email" placeholder="Email" /><br><br>
            <input class="pass" type="password" name="password" placeholder="Password" /><br><br>
            <input class="sub" type="submit" name="submit" value="Register" /><br><br>
            <p style="color: #fff;"> Alredy have an account ? </p>
            <a href="login.jsp">LOGIN</a>
            ${val}
        </form>
         
        </div>       
    </div>
</body>
</center>
</html>