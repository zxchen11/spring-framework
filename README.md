# <img src="src/docs/asciidoc/images/spring-framework.png" width="80" height="80"> Spring Framework

## 概览
spring源码阅读，理解spring核心模块的实现原理，实现流程。添加中文注释，以下内容已添加注释：
    
    1.spring上下文初始化核心流程（xml解析，注解方式解析加载启动-->Bean实例化完成整体流程），包含：
        1.xml解析SPI入口NamespaceHandler、BeanDefinitionParser常见实现逻辑。、注解解析入口。
        2.BeanDefinitionRegistryPostProcessor扩展
        3.BeanPostProcessor及其常见子接口的实现类。
        4.实例化过程等。
    2.BeanPostProcessor扩展 --> AOP实现逻辑
    3.BeanPostProcessor扩展 --> 事务实现逻辑，传播行为原理
    4.MVC中DispatcherServlet核心流程：HanlderMapping、HanlderAdapter扩展等。

## 源码下载及编译

1.源码下载：git clone --branch v5.1.3.RELEASE https://gitee.com/wanglizhi00/spring-framework.git

2.源码编译：
    
    到下载的spring源码路径执行gradle命令
        .\gradlew :spring-oxm:compileTestJava

3.使用IDEA打开项目后，如果在IDEA中使用gradle重新编译模块乱码，添加以下JVM参数

    -Dfile.encoding=UTF-8

## 源码引入到maven项目library中

# <img src="src/docs/asciidoc/images/open-library-settings.png" width="523" height="369">

# <img src="src/docs/asciidoc/images/set-jar-maven-library.png" width="1096" height="377">