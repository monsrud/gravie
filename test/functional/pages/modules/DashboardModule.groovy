package test.functional.pages.modules

import geb.Module

class DashboardModule extends Module {
    static content = {
        success(required: false) { $("span[data-name=successMessage]").text() }
        invalidLogin(required: false) { $("span[data-name=errorMessage]").text() }
        usernameRequired(required: false) { $(".form-group:nth-child(1) li").text() }
        passwordRequired(required: false) { $(".form-group:nth-child(2) li").text() }
        userNameMax(required: false)  { $("li").text() }
        loginError(required: false) { $("li").text() }

    }
}
