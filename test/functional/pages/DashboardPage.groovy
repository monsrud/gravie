package pages

class DashboardPage extends BasePage {
    static url = "dashboard/index"
    static at = { title == "Dashboard" }
    static content = {
        username { $("#username") }
        password { $("#password") }
    }
}

