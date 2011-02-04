<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Create Sitting Session</title>
</head>
<body>
  <div class="body">
  <g:form action="save" method="post" name="sessionForm">
  <table>
  	<g:hiddenField name="satFamily.id" value="1"/>
  	<tr>
  		<td>Start Date</td>
  		<td><joda:dateTimePicker name="startDate" value="${sessionInstance.startDate}" precision="hour"/></td>
	</tr>
	<tr>
		<td>End Date</td>
		<td><joda:dateTimePicker name="endDate" value="${sessionInstance.endDate}" precision="hour"/></td>
	</tr>
	<tr>
		<td>Number of Children</td>
		<td><g:textField name="children" value="${sessionInstance.children}"/></td>
	</tr>
	<tr>
		<td>Estimated Hours Awake</td>
		<td><g:textField name="hoursAwake" value="${sessionInstance.hoursAwake}"/></td>
	</tr>
	<tr>
		<td>Estimated Hours Asleep</td>
		<td><g:textField name="hoursAsleep" value="${sessionInstance.hoursAsleep}"/></td>
	</tr>
	<tr>
		<td colspan="2"><g:submitButton name="createButton" value="create"></g:submitButton></td>
	</tr>
  </table>
  </g:form>
  </div>
</body>
</html>