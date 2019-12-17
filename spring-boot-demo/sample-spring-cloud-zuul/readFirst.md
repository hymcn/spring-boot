Zuul reverse proxy

- functions 

authentiction
insights
stress test
canary test

- dependency
    spring-cloud-starter-netflix-zuul
    
- enable it work
    @EnableZuulProxy
    
-  Zuul timeout
If Zuul uses service discovery, you need to configure these timeouts with the ribbon.ReadTimeout
and ribbon.SocketTimeout Ribbon properties.

If you have configured Zuul routes by specifying URLs, you need to use zuul.host.connect-timeoutmillis
and zuul.host.socket-timeout-millis.
