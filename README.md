# <img src="src/docs/asciidoc/images/spring-framework.png" width="80" height="80"> Spring Framework

## 概览
spring源码阅读，理解spring核心模块的实现原理，实现流程。添加中文注释，以下内容已添加注释：
    
    1.spring上下文初始化核心流程（refresh方法）
        1. prepareRefresh(); refresh之前的准备工作，内部调用逻辑已注释
        2. obtainFreshBeanFactory();重点方法：BeanFactory创建，XMl配置文件解析，BeanDefinition封装
            1.SPi（Service Provider Interface）思想，注册解析类
            2.NamespaceHandler init() decorate() parse() 处理默认及自定义标签解析
            3.BeanDefinitionParser，由NamespaceHandler.init()注册，负责标签属性解析
                1.PropertyPlaceholderBeanDefinitionParser 已添加注释
                2.PropertyOverrideBeanDefinitionParser 已添加注释
                3.AnnotationConfigBeanDefinitionParser 已添加注释
                4.ComponentScanBeanDefinitionParser 重点关注 已添加注释
                5.SpringConfiguredBeanDefinitionParser 已添加注释
                ...
            4.委托模式
            5.源码中类似路径正则解析的建议不看，调用链太深，容易陷进去出不来。
        3. prepareBeanFactory(beanFactory);注册一些对事件、监听器等内置功能的支持
        4. postProcessBeanFactory(beanFactory);钩子方法，BeanFactory创建后，对BeanFactory的自定义操作。
        5. invokeBeanFactoryPostProcessors(beanFactory);重点方法：
            这里调用了postProcessBeanDefinitionRegistry(registry)、postProcessBeanFactory(registry);
            springboot中很多激活自动配置的注解都是通过这里导入的。
            重点关注：AnnotationConfigUtils.registerAnnotationConfigProcessors，注册的内置的BeanDefinitionRegistryPostProcess
                1.ConfigurationClassPostProcessor，内部包含@Configuration、@Bean、@Import、@ImportSource、@Component、@ComponentScan、@PropertySources等注解的支持 
        6. registerBeanPostProcessors(beanFactory);重点方法：从beanFactory中获取所有的BeanPostProcessor，优先进行getBean操作，实例化
            接口及子接口
            BeanPostProcess 定义了类初始化之前、之后的方法回调
                InstantiationAwareBeanPostProcessor 定义了类实例化之前、之后、依赖注入的方法回调
                    SmartInstantiationAwareBeanPostProcessor 定义了获取早期Bean引用、获取候选构造函数方法
                        重点关注：
                        RequiredAnnotationBeanPostProcessor
                        AutowiredAnnotationBeanPostProcessor
                    CommonAnnotationBeanPostProcessor
                MergedBeanDefinitionPostProcessor 定义了类实例化之后，依赖注入之前的的方法回调
                DestructionAwareBeanPostProcessor 定义了bean销毁之前的方法回调
                    InitDestroyAnnotationBeanPostProcessor
        7. initMessageSource();国际化支持，不常用，未加注释。	
        8. initApplicationEventMulticaster();初始化ApplicationEventMulticaster。 如果上下文中未定义，则使用SimpleApplicationEventMulticaster。		
        9. onRefresh();钩子方法，springBoot中的嵌入式tomcat就是通过此方法实现的
        10. registerListeners();监听器注册
        11. finishBeanFactoryInitialization(beanFactory);重点方法：完成容器中bean的实例化，及代理的生成等操作。
        12. finishRefresh();完成此上下文的刷新，调用LifecycleProcessor的onRefresh（）方法并发布
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