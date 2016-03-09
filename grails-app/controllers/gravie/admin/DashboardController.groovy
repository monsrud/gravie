package gravie.admin

import grails.validation.Validateable

class DashboardController {
    static allowedMethods = [index: 'GET',
                             update: 'POST']

    def index() {
        render(view: "index", model: [user: new User()])
    }

    def update() {
        def username = params.username
        def password = params.password

        def user = new User(username: username, password: password)

        user.validate()
        flash.clear()
        if (!user.hasErrors()) {
            if (user.username == "a@a.com" && user.password == "Password1") {
                flash.message = "success"
            } else {
                flash.error = "error"
            }
        }
        render(view: "index", model: [user: user])
    }

    @Validateable
    public class User {
        String username
        String password

        static constraints = {
            username blank: false, email: true, maxSize: 60
            password nullable: false, blank: false
        }
    }
}
