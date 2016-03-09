class UrlMappings {

    static mappings = {
        "/"(controller: "dashboard")
        "/update"

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
    }
}
