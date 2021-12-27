<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


    <style>
        body{
            background: url(‫images/juan-encalada-6mcVaoGNz1w-unsplash.jpg);
            background-size: cover;
            
        }
        div,img{
            width: 20px;
            height: 25px;
        }
        div,input{
            height: 30px;
            width: 200px;
            border-top: none;
            border-left: none;
            border-right: none;
            outline: none;
            background: transparent;
        }
        #login{
            margin-left: 150px;
            margin-top: 80px;
            height: 420px;
            width: 300px;
            padding-left: 40px;
            padding-top: 20px;
            background-color: rgb(228, 208, 208);
            border-radius: 30px ; 
            box-shadow: 0 0 15px rgb(255, 255, 255);   
        }
        .pngtitle{
            margin-left: 90px;
           
        }
        #buspng{
            border-radius: 50%;
            border: 1px solid black;
            height: 70px;
            width: 60px;
        }
        #buttonlogin{
            margin-left: 40px;
            
        }
        button{
            height: 35px;
            width: 180px;
            background-color: rgb(127, 127, 221);
            outline: none;
            border: none;
            
        }
        table,th{
            border-spacing: 5px;
        }
        button:hover{
            background-color: rgb(247, 112, 112);
        }
        a:hover{
            background-color:  rgb(247, 112, 112);
        }
        a{
             text-decoration: none;
        }
       #signup{
           font-weight:bolder;
           font-size: 20px;

       }


       /* register*/


    </style>
</head>
<body>

    <div id="login">
        <form action="loginWay">
       
        <h2 class="pngtitle" >LogIn</h2>

        <table id="tablee">
            <tr>
                <th><img src="images/profile.png"   ></th>
                <th><input name="name" type="text" placeholder="UserName" ><br><br></th>
                
            </tr>
            <tr>
                <th><img src="‫images/password.png" alt=""></th>
                <th><input name="password" type="text" placeholder="Password"><br><br></th>
            </tr>
            
        </table>
        <a href="forgetPassword.html">forgetPassword?</a><br><br>
            <button type="submit" id="buttonlogin">Login</button><br><br>

            <label for="signup">New User ? </label>
            <a id="signup" href="register.html">SignUp</a>


         </form>        
           
 </div>

</body>


</body>
</html>