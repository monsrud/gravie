<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Dashboard</title>
</head>

<body>
<g:form name="myForm" action="update">
  <g:if test="${flash.message}">
    <span data-name="successMessage">${flash.message}</span>
  </g:if>
  <g:if test="${flash.error}">
    <span data-name="errorMessage">${flash.error}</span>
  </g:if>

  <div class="form-group">
    <label for="username" class="sr-only">Username</label>
    <g:textField id="username" name="username" value="${user.username}" placeholder="Username"/>
    <g:hasErrors bean="${user}" field="username">
      <div class="errors">
        <g:renderErrors bean="${user}" field="username" as="list"/>
      </div>
    </g:hasErrors>
  </div>

  <div class="form-group">
    <label for="password" class="sr-only">Password</label>
    <g:passwordField id="password" name="password" value="" placeholder="Password" autocomplete="off"/>
    <g:hasErrors bean="${user}" field="password">
      <div class="errors">
        <g:renderErrors bean="${user}" field="password" as="list"/>
      </div>
    </g:hasErrors>
  </div>

  <div class="row form-submit">
    <div class="col-xs-12 text-right">
      <button type="submit" id="loginButton" class="btn btn-primary">Sign In</button>
    </div>
  </div>

</g:form>
</body>
</html>
