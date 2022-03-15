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
  
      <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="css/owl.css">
    <link rel="stylesheet" href="css/lightbox.css">
  <link rel="stylesheet" type="text/css" href="css/table.css">
<title>Admins</title>

  
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

<%@include file="MenuAdmin.jsp" %>
  <div class="container">
  
    
    <h1 class="admin-label">Admins</h1>

    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
    <input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Search for username..">
    <input type="text" id="myInput3" onkeyup="myFunction3()" placeholder="Search for email.."> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <a href="#" class="btn btn-primary p-5 pt-3 pb-3 mb-3" style="font-size: medium;font-weight: bold; "> Add Admin</a>


  <table id="myTable" class="table">
    <tr class="header">
      <th style="width:20%;">Full Name</th>
      <th style="width:20%;">Username</th>
      <th style="width:20%;">Email</th>
      <th style="width:10%;">Action</th>
    </tr>
    <tr>
      <td>Youssef El Goumri</td>
      <td>y7goumri</td>
      <td>yel@gmail.com</td>
      <td>
        <a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a> &nbsp;
        <a href="">
          <span class="glyphicon glyphicon-trash"></span>
        </a>

      </td>
    </tr>
    <tr>
      <td>Test</td>
      <td>test</td>
      <td>test@gmail.com</td>
      <td>
        <a href="#">
          <span class="glyphicon glyphicon-edit"></span> 
        </a> &nbsp;
        <a href="">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
      </td>
    </tr>
    <tr>
      <td>Ayoub Izourane</td>
      <td>ayoub</td>
      <td>ayoub@gmail.com</td>
      <td>
        <a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a> &nbsp;
        <a href="">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
        
      </td>
    </tr>
    <tr>
      <td>Admin Name</td>
      <td>admin2</td>
      <td>admin2@gmail.com</td>
      <td>
        <a href="#">
          <span class="glyphicon glyphicon-edit"></span> 
        </a>&nbsp;
        <a href="">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
      </td>
    </tr>
  </table>
  </div>
  
</body>
</html>