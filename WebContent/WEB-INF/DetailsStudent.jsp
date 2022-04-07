<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
  <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="css/owl.css">
    <link rel="stylesheet" href="css/lightbox.css">
    <style>
     body{
  background-color: #666565;
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;}
    </style>
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
    
    
    <!-- ***** For Student Information ***** -->
     <sql:query var="listStudents"   dataSource="${db}">
        SELECT * FROM person p join student s on p.id_person = s.id_person where p.id_person =  '${id}';
    </sql:query>

<div class="container">
        <div class="panel panel-success margin-top">
            <div class="panel-heading">Student : </div>
            <div class="panel-body">	
            <table>
             <c:forEach var="student" items="${listStudents.rows}">
            <tr>
            	<td>Name : </td>
            	<td style="padding-left:300px"><c:out value="${student.first_name} ${student.last_name}" /></td>      
            </tr>
            <tr>
           		<td>CNE :</td>
            	<td style="padding-left:300px"><c:out value="${student.username}" /></td>
            </tr>
            <tr>
            	<td>Class : </td>
            	<td style="padding-left:300px"><c:out value="${student.classe}" /></td>
            </tr>
            </c:forEach>
            </table>
           		
            </div>
        </div>
        
        
        
        <!-- ***** For Student's Subject Information ***** -->
        
       <sql:query var="listSubjects"   dataSource="${db}">
        SELECT * FROM person p join student_module sm on p.id_person = sm.id_person join module m on sm.id_module = m.id_module where p.id_person =  '${id}';
    </sql:query>
        

        <div class="panel panel-primary">
            <div class="panel-heading">Subjects :</div>
            <div class="panel-body">
            	 <table>
            	 <th  style="color:blue;padding-bottom:30px;">
            	 Subject
            	 </th>
            	 <th style="color:blue;padding-left:300px;padding-bottom:30px">
            	 Note
            	 </th>
            	 
            	 <!-- ***** Declare Variables to calculate result total and Sum of Subjects***** -->
             <c:set var="total" value="${0}"/>
             <c:set var="NumbersOfSubject" value="${0}"/>
             
             
             <c:forEach var="subject" items="${listSubjects.rows}">
            <tr>
            	<td><c:out value="${subject.module_name}" /></td>    
            	<td style="padding-left:300px"><c:out value="${subject.note}" />
            	 <c:set var="total" value="${total + subject.note}" />
            	 <c:set var="NumbersOfSubject" value="${NumbersOfSubject+1}" /></td>    
            </tr>
            
            </c:forEach>
            <tr style="color:blue;">
            <td style="padding-top:40px;font-weight: 700;"> Resultat:</td>
            <td style="padding-left:300px;padding-top:40px;font-weight: 700;"> <c:out value="${total/NumbersOfSubject}" /></td>
            <td style="padding-left:300px;padding-top:40px;font-weight: 700;">
            <c:if test="${total/NumbersOfSubject>=10}"><c:out value="this semister is validated"/></c:if>
            <c:if test="${total/NumbersOfSubject<10}"><c:out value="this semister is not Validated"/></c:if></td>
            </tr>
            </table>
            
            
    	
            
            </div>
        </div>
        
            
           
</div>

</body>
</html>