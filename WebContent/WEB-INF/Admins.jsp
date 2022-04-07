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
		
		
		  <link rel="stylesheet" href="css/table.css">
		  <script src="js/searchTab.js"></script>
		  
		
    

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

  </style>
  
  <script >
function openEdit() {
    document.getElementById("myFormEdit").style.display = "block";
  }
  
  function closeEdit() {
    document.getElementById("myFormEdit").style.display = "none";
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
       			 <a href="editAdmin?id_person=${admin.id_person}" >
       		     <span class="glyphicon glyphicon-edit"></span>
     			 </a> &nbsp;
    			
    			 <a onclick="return confirm('Are your sure ?')" href="deleteAdmin?id_person=${admin.id_person}">
          		 <span class="glyphicon glyphicon-trash"></span>
        		 </a>

     			 </td>
           
                 
                   
                </tr>
                  
            </c:forEach>
   

  </table>
  



  <div class="form-popup" id="myForm">  
    <button id = "x" class="btn cancel" onclick="closeForm()">
        X
    </button>
<form action="insertAdmin" class="form-container" method="post">
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

	 <!-- ***** Edit popup ***** -->
	

<div class="form-popup" id="myFormEdit">  
    <button id = "x" class="btn cancel" onclick="closeEdit()">
        X
    </button>
<form action="editAdmin" class="form-container" method="post">
	<input class="forminput" type="text" placeholder="Firstname" value="${admin.fname}" name="firstname" required>
	<input class="forminput" type="text" placeholder="lastname" value="${admin.lname}" name="lastname" required>
	<input class="forminput" type="text" placeholder="Username" value="${admin.username}" name="username" required>
	<input class="forminput" type="password" placeholder="Password" value="${admin.password}" name="password" required>
	<input class="forminput" type="text" placeholder="Email" value="${admin.email}" name="email" required>
	<input class="forminput" type="text" placeholder="Phone" value="${admin.phone}" name="phone" required>
	<br>
	<button type="submit" class="btn" id="btnAdd">Edit Admin</button>
</form>
</div>




  </div>

<script>
 <% Object key = request.getAttribute("cle");
 System.out.println(key);
 if(key.equals(1)){ %>
	  openEdit();	
	  <% } %>
</script>

</body>
</html>