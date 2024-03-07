<%@ page import="com.dynamicsuperdupercalculator.model.Parameter" %>
<%@ page import="com.dynamicsuperdupercalculator.model.FunctionResult" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Dynamic Super Duper Calculator</title>
    <style>
        html {
            font-family: sans-serif;
        }

        table {
            border-collapse: collapse;
            border: 2px solid rgb(200, 200, 200);
            letter-spacing: 1px;
            font-size: 0.8rem;
        }

        td, th {
            border: 1px solid rgb(190, 190, 190);
            padding: 10px 20px;
        }

        th {
            background-color: rgb(235, 235, 235);
        }

        td {
            text-align: center;
        }

        tr:nth-child(even) td {
            background-color: rgb(250, 250, 250);
        }

        tr:nth-child(odd) td {
            background-color: rgb(245, 245, 245);
        }

        caption {
            padding: 10px;
        }
    </style>
</head>
<body>

<%!
    Parameter a = Parameter.A;
    Parameter b = Parameter.B;
    Parameter c = Parameter.C;
    Parameter d = Parameter.D;
%>

<h1>Dynamic Super Duper Calculator</h1>
<p>Please, choose the parameters a, b, c, d.</p>
<form action="${pageContext.request.contextPath}/dynamicsuperdupercalculator">
    <label for="<%=a%>"><%=a%>:</label>
    <input id="<%=a%>" name="<%=a%>" value="<%=request.getAttribute(a.name())%>">

    <label for="<%=b%>"><%=b%>:</label>
    <input id="<%=b%>" name="<%=b%>" value="<%=request.getAttribute(b.name())%>">

    <label for="<%=c%>"><%=c%>:</label>
    <input id="<%=c%>" name="<%=c%>" value="<%=request.getAttribute(c.name())%>">

    <label for="<%=d%>"><%=d%>:</label>
    <input id="<%=d%>" name="<%=d%>" value="<%=request.getAttribute(d.name())%>">

    <button type='submit'>Calculate</button>
</form>
<%
    List<FunctionResult> functionResults = (List<FunctionResult>) request.getAttribute("functionResults");

    if (functionResults != null) {
%>
<table>
    <tr>
        <th>&nbsp;</th>
        <th>a</th>
        <th>b</th>
        <th>c</th>
        <th>d</th>
        <th>Formula</th>
        <th>Formula with variables</th>
        <th>y</th>
    </tr>
        <%
        for (FunctionResult functionResult : functionResults) {
%>
    <tr>
        <td>case</td>
        <td><%=functionResult.getA()%>
        </td>
        <td><%=functionResult.getB()%>
        </td>
        <td><%=functionResult.getC()%>
        </td>
        <td><%=functionResult.getD()%>
        </td>
        <td><%=functionResult.getFunctionView()%>
        </td>
        <td><%=functionResult.getFunctionWithValuesView()%>
        </td>
        <td><%=functionResult.getResult()%>
        </td>
    </tr>
        <%
        }
    } else {
        %>
    <h1>
        <% List<String> errors = (List<String>) request.getAttribute("errors");
            for (String error : errors) {
        %>
        <%=error%>
        <br>
        <%}%>
    </h1>
        <%
    }
%>
</body>
</html>