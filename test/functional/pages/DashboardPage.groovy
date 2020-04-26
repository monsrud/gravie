package test.functional.pages

import test.functional.pages.modules.DashboardModule

class DashboardPage extends BasePage {
    static url = "dashboard/index"
    static at = { title == "Dashboard" }
    static content = {
        username(required: true) { $("#username") }
        password(required: true) { $("#password") }
        signInButton(required: true) { $(id: "loginButton") }
        DashboardModule  { module DashboardModule }
    }
}

