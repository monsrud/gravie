log4j.main = {
    root {
        warn 'mainlog'
    }
    environments {
        development {
            root {
                warn 'stdout'
            }
            debug 'com.gravie'
        }
        test {
            root {
                warn 'stdout'
            }
            debug 'com.gravie'
        }
    }
}
