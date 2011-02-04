<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Show Sitting Session</title>
</head>
<body>
  <div class="body">
  <table>
  	<tr>
  		<td>Sat Family<td>
  		<td><g:fieldValue bean="${sessionInstance}" field="satFamily.name"/></td>
	</tr>
	<tr>
		<td>Sitting Family</td>
		<td><g:fieldValue bean="${sessionInstance}" field="sittingFamily.name"/></td>
		
  	<tr>
  		<td>Start Date</td>
  		<td><joda:format value="${sessionInstance.startDate}" style="MS"/></td>
	</tr>
	<tr>
		<td>End Date</td>
		<td><joda:format value="${sessionInstance.endDate}" style="MS"/></td>
	</tr>
	<tr>
		<td>Number of Children</td>
		<td>${sessionInstance.children}</td>
	</tr>
	<tr>
		<td>Estimated Hours Awake</td>
		<td>${sessionInstance.hoursAwake}</td>
	</tr>
	<tr>
		<td>Estimated Hours Asleep</td>
		<td>${sessionInstance.hoursAsleep}</td>
	</tr>
  </table>
  </div>
</body>
</html>