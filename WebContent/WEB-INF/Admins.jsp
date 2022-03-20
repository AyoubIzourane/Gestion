<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <link rel="stylesheet" type="text/css" href="../font/font-awesome.min.css">
<title>Admins</title>


    <!-- Menu -->
    
  
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="css/owl.css">
    <link rel="stylesheet" href="css/lightbox.css">
    
    
        <!-- Menu -->
    
    

        <script src="js/addform.js"></script>
		<link rel="stylesheet" href="css/addform.css">
    

  <style>
  
  body{
  background-color: #666565;
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;}
    #myInput,#myInput2,#myInput3 {
  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 25%; /* Full-width */
  font-size: 16px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */

}

.pagelabel{
  color:#eb9f28;
}

input{
  background-color: rgb(245, 245, 245);
}



input:hover {
  background-color: white;
}

button{
  size: 40%;
}
table{
  border-radius: 3px;
}

#myTable {
  border-collapse: collapse; /* Collapse borders */
  width: 100%; /* Full-width */
  font-size: 18px; /* Increase font-size */
  background-color: rgb(245, 245, 245);
  border: 2px solid #eb9f28 !important;
}

#myTable th, #myTable td {
  text-align: left; /* Left-align text */
  padding: 12px; /* Add padding */
}

#myTable tr {
  /* Add a bottom border to all table rows */
  border-bottom: 1px solid #ddd;
}

#myTable tr.header {
  /* Add a grey background color to the table header and on hover */
  background-color: #eb9f28;
  color: white;
}
#myTable tr:hover:not(.header) {
  /* Add a grey background color to the table header and on hover */
  background-color: white;
}

h1{
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
  font-size: xx-large;
  padding: 20px;
}

a{
  color: #eb9f28;
}
a:hover{
  background-color: white;
  color: black;
}
.btn-primary{
  background-color: #eb9f28;
  border-color: #eb9f28;
  color: white;
}
.btn-primary:hover, .btn-primary:focus, .btn-primary:active, .btn-primary.active, .open>.dropdown-toggle.btn-primary {
    color: #eb9f28;
    background-color: white;
    border-color: #eb9f28; /*set the color you want here*/
}
  </style>
  
  <script>
    function myFunction() {
      // Declare variables
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("myInput");
      filter = input.value.toUpperCase();
      table = document.getElementById("myTable");
      tr = table.getElementsByTagName("tr");
    
      // Loop through all table rows, and hide those who don't match the search query
      for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
          txtValue = td.textContent || td.innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    }

    function myFunction2() {
      // Declare variables
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("myInput2");
      filter = input.value.toUpperCase();
      table = document.getElementById("myTable");
      tr = table.getElementsByTagName("tr");
    
      // Loop through all table rows, and hide those who don't match the search query
      for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
          txtValue = td.textContent || td.innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    }

    function myFunction3() {
      // Declare variables
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("myInput3");
      filter = input.value.toUpperCase();
      table = document.getElementById("myTable");
      tr = table.getElementsByTagName("tr");
    
      // Loop through all table rows, and hide those who don't match the search query
      for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[2];
        if (td) {
          txtValue = td.textContent || td.innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    }
    </script>

</head>

<body>

 <!-- ***** Menu Bar ***** -->
<div style="margin-bottom:150px;"><%@include file="MenuAdmin.jsp" %></div>
 
<sql:setDataSource
        var="db"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3308/jeeproject"
        user="root" password=""
    />     
     <sql:query var="listUsers"   dataSource="${db}">
        SELECT * FROM person where role=1;
    </sql:query>

  <div class="container">
    
    <h1 class="pagelabel">Admins</h1>

    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
    <input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Search for username..">
    <input type="text" id="myInput3" onkeyup="myFunction3()" placeholder="Search for email.."> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <a class="btn btn-primary p-5 pt-3 pb-3 mb-3" style="font-size: medium;font-weight: bold;margin-top:12px; " class="open-button" onclick="openForm()"> Add Admin</a>


  <table id="myTable" class="table">
    <tr class="header">
    
      <th style="width:20%;">Full Name</th>
      <th style="width:20%;">Username</th>
      <th style="width:20%;">Email</th>
      <th style="width:20%;">Phone</th>
      <th style="width:10%;">Action</th>
    </tr>
 
    
    
    <c:forEach var="admin" items="${listUsers.rows}">
              
                <tr>
                    
                    <td><c:out value="${admin.first_name} ${admin.last_name}" /></td>
                    <td><c:out value="${admin.username}" /></td>
                    <td><c:out value="${admin.email}" /></td>
                    <td><c:out value="${admin.phone}" /></td>
                  
                  <td>
       			 <a href="#" onclick='openForm()'>
       		     <span class="glyphicon glyphicon-edit"></span>
     			 </a> &nbsp;
    			
    			 <a onclick="return confirm('Are your sure ?')" href="deleteAdmin?id_person=${admin.id_person}">
          		 <span class="glyphicon glyphicon-trash"></span>
        		 </a>

     			 </td>
           
                 
                   
                </tr>
                  
            </c:forEach>
   

  </table>
  </div>
  



  <div class="form-popup" id="myForm">
    
    <button id = "x" class="btn cancel" onclick="closeForm()">
        X
    </button>


<form action="insertAdmin" class="form-container">



<input class="forminput" type="text" placeholder="Firstname" name="firstname" required>

<input class="forminput" type="text" placeholder="lastname" name="lastname" required>


<input class="forminput" type="text" placeholder="Username" name="username" required>

<input class="forminput" type="password" placeholder="Password" name="password" required>

<input class="forminput" type="text" placeholder="Email" name="email" required>

<input class="forminput" type="text" placeholder="Phone" name="phone" required>



<br>


<button type="submit" class="btn" id="btnAdd">Add Admin</button>

</form>
</div>




</body>
</html>