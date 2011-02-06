<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        	<th>Name</th>
                            <th>Points</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${familyList}" status="i" var="familyInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${familyInstance.id}">${fieldValue(bean: familyInstance, field: "name")}</g:link></td>
                            <td><g:link action="show" id="${familyInstance.id}">${fieldValue(bean: familyInstance, field: "points")}</g:link></td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div> 
  </div>
</body>
</html>