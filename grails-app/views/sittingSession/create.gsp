<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Create Sitting Session</title>
</head>
<body>
	<g:hasErrors bean="${sessionInstance}">
	<div class="errors"
	<g:renderErrors bean="${sessionInstance}"/>
	</div>
	</g:hasErrors>
  <g:form action="save" method="post" name="sessionForm">
  <table>
  	<g:hiddenField name="satFamily.id" value="${sessionInstance.satFamily.id}"/>
  	<tr>
  		<td>Start Date</td>
  		<td class="${hasErrors(bean:sessionInstance,field:'startDate','errors')}"><joda:dateTimePicker name="startDate" value="${sessionInstance.startDate}" precision="hour"/></td>
	</tr>
	<tr>
		<td>End Date</td>
		<td class="${hasErrors(bean:sessionInstance,field:'endDate','errors')}"><joda:dateTimePicker name="endDate" value="${sessionInstance.endDate}" precision="hour"/></td>
	</tr>
	<tr>
		<td>Number of Children</td>
		<td class="${hasErrors(bean:sessionInstance,field:'children','errors')}"><g:textField name="children" value="${fieldValue(bean:sessionInstance,field:'children')}" /></td>
	</tr>
	<tr>
		<td>Estimated Hours Awake</td>
		<td class="${hasErrors(bean:sessionInstance,field:'hoursAwake','errors')}"><g:textField name="hoursAwake" value="${fieldValue(bean:sessionInstance,field:'hoursAwake')}"/></td>
	</tr>
	<tr>
		<td>Estimated Hours Asleep</td>
		<td class="${hasErrors(bean:sessionInstance,field:'hoursAsleep','errors')}"><g:textField name="hoursAsleep" value="${fieldValue(bean:sessionInstance,field:'hoursAsleep')}"/></td>
	</tr>
	<tr>
		<td>Notes</td>
		<td class="${hasErrors(bean:sessionInstance,field:'notes','errors')}"><g:textArea name="notes" value="${fieldValue(bean:sessionInstance,field:'notes')}"/></td>
	</tr>
	<tr>
		<td colspan="2"><g:submitButton name="createButton" value="create"></g:submitButton></td>
	</tr>
  </table>
  </g:form>
  </div>
</body>
</html>