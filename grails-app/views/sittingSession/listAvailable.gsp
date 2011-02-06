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
                        	<th>ID</th>
                        	<th>Requesting Family</th>
                            <th>Date</th>
                            <th>Start Time</th>
                            <th>End Time</th>
                            <th>Points</th>
                            <th>status</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sessionList}" status="i" var="sessionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${sessionInstance.id}">${fieldValue(bean: sessionInstance, field: "id")}</g:link></td>
                            <td><g:link action="show" id="${sessionInstance.id}">${fieldValue(bean: sessionInstance, field: "satFamily.name")}</g:link></td>
                            <td><g:link action="show" id="${sessionInstance.id}"><joda:format value="${sessionInstance.startDate}" style="M-"/></g:link></td>
                            <td><g:link action="show" id="${sessionInstance.id}"><joda:format value="${sessionInstance.startDate}" style="-S"/></g:link></td>
                            <td><g:link action="show" id="${sessionInstance.id}"><joda:format value="${sessionInstance.endDate}" style="-S"/></g:link></td>
                            <td><g:link action="show" id="${sessionInstance.id}">${sessionInstance.points}</g:link></td>
                            <td><g:link action="show" id="${sessionInstance.id}">${sessionInstance.status}</g:link></td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div> 
  </div>
</body>
</html>