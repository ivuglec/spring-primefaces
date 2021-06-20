# Getting Started
This is a demo project that shows how to set up primefaces with SpringBoot. It contains simple security configuration with 3 pages to demonstrate basic login/logout functionality.
Project can be build (that is should be build) as bootable war to be runnable with java command ``` java -jar SOME_APPLICATION.war ```.

Project is using Primefaces version 10 and theme 'Saga'. additional themes (and other JSF/Primefaces config params) can be configured in project file.
```java
    @Override
    public void setServletContext(ServletContext sc) {
        sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        sc.setInitParameter("com.sun.faces.expressionFactory", "org.apache.el.ExpressionFactoryImpl");
        sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        sc.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString());
        sc.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        sc.setInitParameter("javax.faces.FACELETS_LIBRARIES", "springsecurity.taglib.xml");
        sc.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
        sc.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        sc.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString());
        sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        sc.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
        sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
        sc.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        sc.setInitParameter("primefaces.THEME", "saga");
    }
```

Additionaly there is a branch that demonstrate how to use Primefaces premium theme if you have it.
Branch: ``` primefaces_premium_demo ```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.0-SNAPSHOT/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.0-SNAPSHOT/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Primefaces](https://www.primefaces.org/showcase/index.xhtml)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

