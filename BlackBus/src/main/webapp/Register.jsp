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
            background-repeat: no-repeat    ;
            
        }
        .signup{
            width: 400px;
            height: 400px;
            margin-left: 130px;
            margin-top: 50px ;
            
        }
        th,td{
            /* padding: 0 25px;
            padding: 10px 0; */
            padding: 5px;
        }
        #buttontable{
            margin-left: 30px;
            padding-top: 20px;
            
        }
        button{
            height: 35px;
            width: 100px;
            border: none;
            outline: none;
        }
        button:hover{
            background-color: tomato;
        }
        label,h2{
            color: white;
        }
        #male{
            margin-left: 0%;
            padding: 0 40px   ;
        }
        input{
            outline: none;
        }
    </style>
</head>


<body>

<form action="reg">
    <fieldset class="signup">
        <legend><h2>Registeration</h2></legend>

        <table id="signuptable" style="border-spacing: 5px;">
            <tr>
                <th><label for="name">UserName</label></th>
                <th><input type="text" name="name" id="name" required autofocus></th>
            </tr>
            <tr>
                <th><label for="emailId">EmailId</label></th>
                <th><input name="emailId" type="email" id="emailId" ></th>
            </tr>
            <tr>
                <th><label for="mobile">MobileNumber</label></th>
                <th><input name="mobile" type="text" id="mobile" ></th>
            </tr>
            <tr>
                <th><label for="password">Password</label></th>
                <th><input name="password" type="password" id="password" ></th>
            </tr>
            <tr>
                <th><label for="age">Age</label></th>
                <th><input name="age" type="number" id="age" ></th>
            </tr>
            <tr>
                <th><label for="gender">Gender</label></th>
                <th id="male"><input type="radio" name="gender" value="Male"><label for="Male"> Male</label> 
                    <input type="radio" value="Female" name="gender"><label for="Female">Female</label></th>
            </tr>
            
        </table>
        <br>
        <input type="checkbox">
        <label for="terms">I agree to the Terms Of the Service</label>
        <br>
        <table id="buttontable">
            <tr>
                <td><button type="submit">Register</button></td>
                <td><button type="reset">Reset</button></td>
                <td><button type="submit"><a href="index.html"> Home</a></button></td>
            </tr>
        </table>
        
        

    </fieldset>
</form>
</body>
</html>

</body>
</html>