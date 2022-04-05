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
<title>Notes</title>


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
     <sql:query var="listNotes"   dataSource="${db}">
        SELECT * FROM student_module n, student s, person p, module m where n.id_person=s.id_person and n.id_module=m.id_module and s.id_person=p.id_person;
    </sql:query>
    <sql:query var="listStudents"   dataSource="${db}">
        SELECT * FROM student s, person p where s.id_person=p.id_person;
    </sql:query>
    <sql:query var="listModules"   dataSource="${db}">
        SELECT * FROM module m;
    </sql:query>

  <div class="container">
    
    <h1 class="pagelabel">Notes</h1>

    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for student..">
    <input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Search for subject..">
    <input type="text" id="myInput3" onkeyup="myFunction3()" placeholder="Search for teacher.."> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <a class="btn btn-primary p-5 pt-3 pb-3 mb-3" style="font-size: medium;font-weight: bold;margin-top:12px;  " class="open-button" onclick="openForm()"> Add Note</a>


  <table id="myTable" class="table">
    <tr class="header">
      <th style="width:22%;">Student name</th>
      <th style="width:22%;">Subject Name</th>
      <th style="width:22%;">Teacher Name</th>
      <th style="width:22%;">Exam Date</th>
      <th style="width:22%;">Note</th>
      <th style="width:20%;">Action</th>
    </tr>
    
    </tr>
    
        <c:forEach var="notes" items="${listNotes.rows}">
              
                <tr>
                    <td><c:out value="${notes.first_name} ${notes.last_name}" /></td>
                    <td><c:out value="${notes.module_name}" /></td>
                    <td><c:out value="${notes.teacher_name}" /></td>
                    <td><c:out value="${notes.exam_date}" /></td>
                    <td><c:out value="${notes.note}" /></td>
                  
                  <td>
                  
                  
       			 <a href="editNote?id_person=${notes.id_person}&id_module=${notes.id_module}"  >
       		     <span class="glyphicon glyphicon-edit"></span>
     			 </a>
    			
    			 <a onclick="return confirm('Are you sure ?')" href="deleteNote?id_person=${notes.id_person}&id_module=${notes.id_module}">
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


<form action="insertNote" class="form-container">

<label>Student :</label>
<select name="id_person">
	<c:forEach var="Notes_S" items="${listStudents.rows}">
	<option  value="${Notes_S.id_person}">
		<c:out value="${Notes_S.first_name} ${Notes_S.last_name}" />
	</option>
	
	</c:forEach>
</select>
<br>

<label>Subject :</label>
<select name="id_module">
	<c:forEach var="Notes_M" items="${listModules.rows}">
	<option value="${Notes_M.id_module}">
		<c:out value="${Notes_M.module_name}" />
	</option>
	</c:forEach>
</select>
<br>
<input class="forminput" type="text" name="date" placeholder="Exam Date" required >
<input class="forminput" type="text" name="note" placeholder="Note" required >
<br>


<button type="submit" class="btn" id="btnAdd">Add Note</button>
</form>


</div>

        <!-- Edit -->
        
 

<div class="form-popup" id="myFormEdit">
    
    <button id = "x" class="btn cancel" onclick="closeEdit()">
        X
    </button>


<form action="editN" class="form-container" method="post">

<label>Student :</label>
<label ><c:out value="${student.fname} ${student.lname}"/></label>
<br>

<label>Subject :</label>
<label><c:out value="${ module.module_name }"/></label>
<br>
<input class="forminput" type="text" name="date" placeholder="Exam Date" required value="${ed_note.exam_date }">
<input class="forminput" type="text" name="note" placeholder="Note" required value="${ed_note.note }">
<br>


<button type="submit" class="btn" id="btnAdd">Edit Note</button>
</form>


</div>


<script>
 <% Object key = request.getAttribute("cle");
 System.out.print(key);
 if(key.equals(1)){ %>
	  openEdit();	
 <% } %>
</script>

</body>
</html>