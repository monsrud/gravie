@java.lang.SuppressWarnings('Println')
import java.lang.Object

grails.appName = appName
grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
                      all: '*/*', // 'all' maps to '*' or the first available format in withFormat
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      form: 'application/x-www-form-urlencoded',
                      html: ['text/html', 'application/xhtml+xml'],
                      js: 'text/javascript',
                      json: ['application/json', 'text/json'],
                      multipartForm: 'multipart/form-data',
                      rss: 'application/rss+xml',
                      text: 'text/plain',
                      hal: ['application/hal+json', 'application/hal+xml'],
                      xml: ['text/xml', 'application/xml']]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/img/*', '/css/*', '/js/*', '/plugins/*', '/fonts/*']

// fix for http://www.gopivotal.com/security/cve-2014-0053
grails.resources.adhoc.includes = ['/img/**', '/css/**/*.css', '/js/**/*.js', '/plugins/**', '/fonts/**']
grails.resources.adhoc.excludes = ['/WEB-INF/**', '/META-INF/**', '/db/**', '**/*.sql', '**/*.class', '**/*.groovy', '**/*.xml', '**/*.tld', '**/*.java', '**/*.gsp']

// The default codec used to encode data with ${}
grails.views.default.codec = "html" // none, html, base64
grails.controllers.defaultScope = 'singleton'

grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}

grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = ''

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

// packages to include in Spring bean scanning
grails.spring.bean.packages = ['com.gravie']

// whether to disable processing of multi part requests
grails.web.disable.multipart = false

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

grails.config.locations = ["classpath:log-config.groovy"]

