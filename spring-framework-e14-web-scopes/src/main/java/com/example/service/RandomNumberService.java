package com.example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
//@Scope("prototype")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.INTERFACES)

public class RandomNumberService implements NumberService  {

    private final  int value;

    public RandomNumberService() {
        this.value = new Random().nextInt(1000);
    }

    @Override
    public int getValue() {
        //StackTrace is good for debugging to see detail of what append , who is called in between.
        //new RuntimeException().printStackTrace();
        return value;
    }
}

/**
 * by default in spring the scope of the bean is a singleton - which is one instance at a time.
 that means that one instance is delivered again and again when ever it is asked.

 *Spring beans scopes:
 * singleton - a single Object instance per Spring IOC container.
 *
 * prototype - creates a new bean instance everytime a request for that specific bean is made.
   -This means that each time a bean with prototype scope is injected into another bean
    or requested by a client, a new instance of the bean is created.
    -This how you set it @Scope("prototype");
  -This scope is suitable for stateful beans where each instance has its own state
    and is not meant to be shared across multiple clients.
 **RuLE. Use you should use the prototype scope for all beans that are stateful,
    while the singleton scope should be used for stateless beans
-------------------------------------------------------------------------------
 **The other scopes, namely request, session, and global session are for use only in
   web-based applications

 *SCOPE_REQUEST - new bean per each HTTP request
      - and ensure that the same instance is used throughout the processing of that request.
     - the life time of the bean is for only one specific request.
   - This scope is useful for managing state that is specific to a particular HTTP request,
      and it prevents interference between concurrent requests.

 *Note: The proxyMode attribute is used when injecting request-scoped beans into singleton
   beans to create a proxy that can manage the scope correctly.

 proxyMode = ScopedProxyMode.TARGET_CLASS  - one can only use this for direct class non abstraction.
 proxyMode = ScopedProxyMode.INTERFACE - to use this it should use interfaces as shown.

 **SCOPE_SESSION - define bean with session scope.
 - The session scope means that a single instance of the bean is created and shared across
   all requests within the same HTTP session.
 - Like one bean per client connection. for example: different bean for d/nt browsers
   but the same bean for one browser.
 -This is particularly useful when you want to maintain stateful information specific
  to a user across multiple requests during their session on the web application.


 **In the context of web application, an HTTP session is a mechanism to maintain state information
  on server side across multiple  requests from the same client.

 **SCOPE_APPLICATION - one instance for entire duration of Application.

  **SCOPE_APPLICATION vs Singleton
   -SCOPE_APPLICATION - is specific to the web environment and is part of  'WebApplicationContext'
   - Singleton - is more general scope and is not tied to web environment.
            -> can be used in web applications or non-web applications.
 */
