## 微服务

微服务，或者SaaS的定义是怎样的？应该遵循怎样的准则

The Twelve-factor App作为一种常用的方法论，可以作为一种开发参考。

综述
使用标准化流程自动配置，从而使新的开发者花费最少的学习成本加入这个项目。（灵活标准配置）
和操作系统之间尽可能的划清界限，在各个系统中提供最大的可移植性。（减少依赖，包括系统）
适合部署在现代的云计算平台，从而在服务器和系统管理方面节省资源。（部署容易，兼容各种平台）
将开发环境和生产环境的差异降至最低，并使用持续交付实施敏捷开发。（减少差异，避免环境变化所需的改动）
可以在工具、架构和开发流程不发生明显变化的前提下实现扩展。（扩展性强）

1. 一份基准代码（代码管理和部署相关）
2. 显式依赖申明（告知全部依赖项，方便通过依赖工具完成项目启动或部署）
3. 环境配置
4. 后端服务（微服务，每个服务即使使用者又是服务提供者）
5. 构建、发布、运行分离
6. 无状态
7. 并发
8. 启动、关机优雅
9. 端口绑定
10. 环境一致性，开发、测试、线上尽量保持一致
11. 日志（日志作为事件流）
12. 管理进程（管理和监控工具）


按照12-factor，基于springcloud构建

1. git代码管理
2. maven完成依赖管理
3. 配置中心采用alibaba nacos
4. 服务导出采用alibaba dubbo 
5. maven
6. 无状态
7. 


项目构建
1.读取nacos配置数据
    主要nacos的相关配置需要在bootstrap.ymal中
2.提供服务
    启动privder服务
    nacos控制台可以看到如下服务列表

3.服务消费
    启动consumer服务
    
    访问地址验证调用是否成功
    http://localhost:8081/echo/asdfsdf
         	
         	
4.关于nacos可用性对服务调用的影响

    - 关掉nacos服务
    
5.logging use logback

6.增加断路器

7.消费端的负载均衡(ribbon)
    增加privider的数量，which provider do i use?
    
    
    client side load balancer
    @FeignClient 包含 ribbon
    
    RibbonClientConfiguration
    组件
    IloadBalancer RestClient ServerListFilter
    
    config ribbon client
    <client>.ribbon.*
    
    @Configuration
    @RibbonClient(name = "foo", configuration = FooConfiguration.class)
    public class TestConfiguration {
    }
    注意： 下面这段话
        
    The FooConfiguration has to be @Configuration but take care that it is not in a @ComponentScan for the main application context, otherwise it will be shared by all the @RibbonClients. If you use @ComponentScan (or @SpringBootApplication) you need to take steps to avoid it being included (for instance put it in a separate, non-overlapping package, or specify the packages to scan explicitly in the @ComponentScan
    
    IClientConfig ribbonClientConfig: DefaultClientConfigImpl
    IRule ribbonRule: ZoneAvoidanceRule
    IPing ribbonPing: NoOpPing
    ServerList<Server> ribbonServerList: ConfigurationBasedServerList
    ServerListFilter<Server> ribbonServerListFilter: ZonePreferenceServerListFilter
    ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer
    
    Feign ： Declarative Rest client
    