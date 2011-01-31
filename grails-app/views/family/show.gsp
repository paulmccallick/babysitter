
<%@ page import="babysitter.Family" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'family.label', default: 'Family')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="family.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: familyInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="family.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: familyInstance, field: "name")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
                <table>
                	<thead>
                		<tr >
                			<td colspan="5">Sessions hosted by ${familyInstance.name}</td>
                		</tr>
                		<tr>
                			<td>Sat For</td>
                			<td>Hours Awake</td>
                			<td>Hours Asleep</td>
                			<td># of Children</td>
                			<td>Points</td>
                	</thead>
                	<tbody>
                		<g:each in="${satSessions}">
                			<tr>
                				<td>${it.sittingFamily.name }<td>
                				<td>${it.hoursAwake }</td>
                				<td>${it.hoursAsleep }</td>
                				<td>${it.children }</td>
                				<td>${it.points }</td>
               				</tr>
                		</g:each>
                	</tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${familyInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
