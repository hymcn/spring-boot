# 发生了什么？

首先假象一下假如我们需要实现一个类似的系统需要怎么做。

假如一个架构师想将一些常用的功能组件封装起来，做成易用的功能组件，新项目只要将相应的依赖导入进来，然后进行简单的配置，相应的功能就可以用了。

三个问题：
1.@SpringBootApplication做了什么事情？
    既然是spring项目，那么我们很容易猜到其首要完成的就是spring容器的初始化，至于怎么初始化，后边再介绍。
    
2.pom中的spring-boot-starter-web又做了什么？
可以简单过一下源码，发现spring-boot-starter-web是一个单纯的pom包，没有源码，目的就是加载相应依赖。

以此类推，spring-boot-starter-xxx都是加载相应的依赖包。
相应的依赖加载到项目中以后，下一步我们需要将相应的类 有选择 的加载到项目容器中，然后按照application.properties配置进行初始化。可是application.properties什么内容也没有配置，项目启动起来了。

3.相应的核心分装逻辑又是在哪里实现的？那么项目的默认初始化逻辑是在哪里实现的？
spring-boot-actuator-autoconfigure(看模块的名字大致可以猜出),里边包含了相应功能模块的初始化逻辑。








