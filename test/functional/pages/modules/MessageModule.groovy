package pages.modules

import geb.Module

class MessageModule extends Module {
    static content = {
        success(required: false) { $("span[data-name=successMessage]").text() }
    }
}
