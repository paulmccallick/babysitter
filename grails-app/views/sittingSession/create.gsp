<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Create Sitting Session</title>
		<link type="text/css" href="/babysitter/css/ui-lightness/jquery-ui-1.8.9.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="/babysitter/js/jquery/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="/babysitter/js/jquery/jquery-ui-1.8.9.custom.min.js"></script>
		<script type="text/javascript" src="/babysitter/js/jquery/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript">
		$(function(){

			// Datepicker
			$('#startDate').datetimepicker({
					ampm: true,
					seperator:'@',
					timeFormat: 'h:mm TT',
					stepMinute:15,
					dateFormat:'m/d/y'});
			//$('#startDate').datetimepicker("setDate",new Date(2010,02,28))
			$('#endDate').datetimepicker({
				ampm:true,
				seperator:'@',
				timeFormat: 'h:mm TT',
				stepMinute:15,
				dateFormat:'m/d/y'});
		
		});
		</script>
		<style type="text/css">
		.ui-timepicker-div .ui-widget-header{ margin-bottom: 8px; }
		.ui-timepicker-div dl{ text-align: left; }
		.ui-timepicker-div dl dt{ height: 25px; }
		.ui-timepicker-div dl dd{ margin: -25px 0 10px 65px; }
		.ui-timepicker-div td { font-size: 90%; }
		</style>
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
  		<td class="${hasErrors(bean:sessionInstance,field:'startDate','errors')}">	<g:textField name="startDate" value="${fieldValue(bean:sessionInstance,field:'startDate')}" /></td>
	</tr>
	<tr>
		<td>End Date</td>
		<td class="${hasErrors(bean:sessionInstance,field:'endDate','errors')}"><g:textField name="endDate" value="${fieldValue(bean:sessionInstance,field:'endDate')}"/></td>
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