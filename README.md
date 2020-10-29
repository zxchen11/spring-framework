# spring-source-mvc-ano

#### 介绍
测试spring-framework源码用的maven web项目，里面包含了xml启动 和 main方法启动手动创建的tomcat案例及其他一些测试用例，可以调试源码断点时直接使用。

#### 软件架构
软件架构说明


#### 安装教程

1.  使用IDEA将项目拉取到本地，或者使用git clone拉取。

2.  按照spring源码中的说明设置依赖包位置。

    传送门：https://gitee.com/wanglizhi00/spring-framework 

#### 注释事项

1.  使用main方法启动web容器时，将web.xml配置的内容注释掉。如果不注释掉，会连续加载两次监听器及DispacherServlet，造成冲突。
2.  使用web.xml时，将项目中WebApplicationInitializer的实现类MyWebAppInitializer注释掉，原因同上。