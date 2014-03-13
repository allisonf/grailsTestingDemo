<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee</title>
</head>

<body>
    <h2 class="title">Employee List Page</h2>
    <ul>
        <% employees.each { employee -> %>
            <li>
                <g:link action="show" id="${employee.id}" class="employeeLink" elementId="${employee.id}">
                    ${employee.firstName} ${employee.lastName}
                </g:link>
            </li>
        <% } %>
    </ul>
</body>
</html>