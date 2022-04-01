
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>


<div class="container">
        <div class="panel panel-success margin-top">
            <div class="panel-heading">Student : </div>
            <div class="panel-body">	
            	<h3><c:out value="${student.fname} ${student.lname}" /></h3>
            </div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">Subjects :</div>
            <div class="panel-body">
            	<c:forEach var="module" items='${requestScope.modules}'> 
					<h3><c:out value="${module.module_name }" /></h3> </br>
				</c:forEach>
            </div>
        </div>
</div>
</body>
</html>