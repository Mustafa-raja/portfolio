<!DOCTYPE html>
<html>
    <title>Registration Page</title>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  
        <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/> -->
        <style>
         @media screen and (min-device-width: 768px)  {
            .d{
                width: 350px;
                height: 430px;
                background-color:  #fff;   
                border-radius: 16px 16px 16px 16px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
            .form-horizontal {
                 padding-top: 40px;
                 padding-bottom: 40px;
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
             .pass{
                margin-top: 10px;

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
             .title 
                {
                    color: white;
                    padding-top: 15px;
                }
            .alert
            {
                margin-top: 10px;
                width: 300px;
                height: auto;
            }
            }
            @media screen and (orientation: portrait)  {
                .d{
                width: auto;
                height: auto;
                background-color:  #fff;   
                border-radius: 16px 16px 16px 16px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
            .form-horizontal {
                 padding-top: 40px;
                 padding-bottom: 40px;
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
             .pass{
                margin-top: 10px;

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
             .title 
                {
                    color: white;
                    padding-top: 15px;
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
    </body>
    <h2 class="title">FORGOT PASSWORD</h2>
    <br>
    <div class="d">
        <form class="form-horizontal" method="post" action="/forgot">
            <P>Enter your Email below to get a new password</p>
            <input type="text" name="Email" class="user" placeholder="Email / Username" ><br><br>
            <input type="submit" name="submit" class="sub" value="Enter" ><br><br>
            <a href="register.jsp">Register Now</a><br>
            ${val}
        </form>
    </div>