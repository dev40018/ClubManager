# Spring MVC

https://docs.spring.io/spring-framework/reference/web/webmvc.html  



> **Spring Web MVC**  
is the original web framework built on the Servlet API and has been included in the Spring Framework from the very beginning. The formal name, "Spring Web MVC," comes from the name of its source module (spring-webmvc), but it is more commonly known as "Spring MVC".  
Parallel to Spring Web MVC, Spring Framework 5.0 introduced a reactive-stack web framework whose name, "Spring WebFlux," is also based on its source module (spring-webflux).


is a lib within Spring Framework that simplifies HTTP req and resp
Model View Controller, allows separation of business, presentation, and navigation logic  

controller layer is resp for you urls  
model is representation of DB tables

> **Dispatcher Servlet** -> a code pattern that allows actual request pass through it  
At the heart of a Spring Boot web application lies the `DispatcherServlet`.  
Upon receiving an HTTP request, this `servlet` acts as the gateway, intercepting the  
incoming call and initiating the process of handling the request.  
It serves as the central hub for managing the flow of requests and responses.  


**How Spring MVC Implements the Front Controller Pattern**

    Centralized Entry Point

    DispatcherServlet: In Spring MVC, the DispatcherServlet is configured to handle all incoming requests. It is defined in the web.xml or through Java-based configuration. This servlet is the single entry point for all HTTP requests to the Spring MVC application.

**Request Handling**

    Parsing and Routing: The DispatcherServlet parses the incoming request and determines the appropriate controller to handle the request based on the URL and other criteria. It uses a handler mapping to find the right controller.
    Pre-processing: Before dispatching the request to the controller, the DispatcherServlet can apply various pre-processing steps like authentication, logging, and request validation through interceptors or filters.

**3. Controller Dispatching**

    The DispatcherServlet dispatches the request to the appropriate controller, which then processes the request and returns a view name.

**4. View Resolution**

    After the controller returns the view name, the DispatcherServlet resolves the view using a ViewResolver and renders the response back to the client.

> **WebApplication Context**:
The DispatcherServlet operates within the context of the larger Spring application context.  
This context is essentially a container for managing beans, including controllers, services,  
and other components. The servlet uses this context to locate and invoke the appropriate components for handling the incoming request.  

> **Handler Mapping**, is going to check your URL  
you application URL that you specified lives here which HM will check the user's request
One of the crucial responsibilities of the DispatcherServlet is to consult the HandlerMapping. This mapping is responsible for determining which controller (handler) should process the incoming request based on factors such as the request URL, request method, or other parameters.

So once the handle mapper maps this request to this particular handler mapper then the handler mapper will return particular controller(handler) details to the dispatcher servlet.

https://medium.com/@lakshyachampion/the-dispatcherservlet-the-engine-of-request-handling-in-spring-boot-3a85c2bdbe6b

Controller, then request will be send in here, which will we executed

checkout front-controller pattern
 View


**Middleware and Pipelines**

Modern frameworks like ASP.NET Core introduced middleware and request pipelines:

    Middleware: Middleware components process requests in a sequential pipeline, handling cross-cutting concerns like authentication, logging, and error handling.
    Pipelines: Requests pass through a series of middleware components before reaching the MVC controller, allowing for flexible and centralized request processing.

https://justgokus.medium.com/step-into-mvc-front-controller-design-pattern-9589eb3572ce

## Spring Initlizer
https://amirmv2006.medium.com/spring-initializr-and-continuous-generation-3d9516865763

## Repostiory Pattern and N-Tier Arch
rep pattern is an abstraction layer for just communication with DB and lets you only works with Objects of that DB  
not working with that DB which it provides with CRUD functionality  
[anti-Repostiry](https://www.linkedin.com/pulse/repository-pattern-stupid-here-why-abdulrahman-fani-bu0vf)

## DTO
an Object which is transfered between Contorller and the user and the service  
and service only works with DB object while DTO is not DB object it just transfer it  
with its own format.  
sometimes you don't want to send some DB fields to the User Response and just sending specific 
stuff

> Think about `Sealed interfaces` 

> think about specifying base url with `@RequestMapping("url")`

turning FORM into JSON

## List/Detail Pattern
## Like Vs Contains in SQL performance