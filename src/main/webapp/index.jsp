<html>
<body>
<form subject="loginForm" method="post" action="questionaireservlet">
   Get questionaire by subject: <input type="text" name="subjectName"/> <br/>
                                <input type="submit" value="Get" />
</form>
<p1> Result on : <%=session.getAttribute("subject")%> </p1>
</body>
</html>