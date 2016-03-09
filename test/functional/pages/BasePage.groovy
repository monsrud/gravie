package pages

import geb.Page
import pages.modules.MessageModule

class BasePage extends Page {

    static content = {
        message { module MessageModule }
    }

    def hasError(input) {
        def elementWithError = input.closest('.has-error')
        def errorMessage = input.siblings('.error-content').find { it.displayed }?.text()
        def error = !elementWithError.empty ? (errorMessage ?: "") : false
        if (!error) {
            errorMessage = elementWithError.find('.error-content').find { it.displayed }?.text()
            error = !elementWithError.empty ? (errorMessage ?: "") : false
        }
        error
    }
}
