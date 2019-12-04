

spring cloud 系列

1. 关于版本号
    
    <dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>Finchley.SR1</version>
				<type>pom</type>
				<scope>runtime</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>



spring-cloud包含一堆子项目，各个子项目都有自己的研发进度，Spring Cloud项目的特点，项目的版本号采用字母，便于与子项目版本区分，版本发布顺序按照首字母自增的顺序,名称为伦敦地铁站的名称。项目的协调发布通过下面这个项目

https://github.com/spring-cloud/spring-cloud-release

Spring Cloud Release Train is a curated set of dependencies across a range of Spring Cloud projects. You consume it by using the spring-cloud-dependencies POM to manage dependencies in Maven or Gradle. The release trains have names, not versions, to avoid confusion with the sub-projects. The names are an alphabetic sequence (so you can sort them chronologically) with names of London Tube stations ("Angel" is the first release, "Brixton" is the second).

spring-cloud-config
External configuration (server and client) for Spring Cloud


### OTHERS

1. The twelve-factor app

The Twelve Factors
I. Codebase
One codebase tracked in revision control, many deploys
一份基准代码，多份部署
II. Dependencies
Explicitly declare and isolate dependencies
显式申明和隔离依赖项，不要隐含的依赖已有的系统包。把所有的系统依赖项全部列出来，即使是最常见的系统工具包。
III. Config
Store config in the environment
关于配置项应该存到哪里的问题，首先不建议将配置项硬编码到代码中，建议将部署相关的配置存储在环境变量中吗，存储的时候按照环境分组。
IV. Backing services
Treat backing services as attached resources
把所有后端服务作为一种通用资源服务，可以通过配置可以切换其他资源，只保留资源的操作句柄和配置，不关心资源的存在形式。
核心在于与后端服务解耦。
V. Build, release, run
Strictly separate build and run stages
严格将构建、发布和运行分开。
构建的过程是将代码转换为可执行的程序
发布包含了构建好的程序和相应的配置

VI. Processes
Execute the app as one or more stateless processes
程序执行的进程无状态不共享数据，这样做是为了方便程序扩展，通过更多的进程来提升系统的性能。
VII. Port binding
Export services via port binding
通过端口的形式提供服务，这样方便服务的共享，可以被其他服务作为后端服务引用。
VIII. Concurrency
Scale out via the process model
进程是头等公民，能力不够，进程来凑

参考资源
https://adam.herokuapp.com/past/2011/5/9/applying_the_unix_process_model_to_web_apps/

IX. Disposability
Maximize robustness with fast startup and graceful shutdown
快速启动，优雅关闭，应急响应要快，这样才能增加鲁棒性。
X. Dev/prod parity（平等）
Keep development, staging, and production as similar as possible
XI. Logs
Treat logs as event streams
XII. Admin processes
Run admin/management tasks as one-off processes

