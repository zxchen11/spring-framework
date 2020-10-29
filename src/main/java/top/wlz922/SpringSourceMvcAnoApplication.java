package top.wlz922;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author Eddie
 */
public class SpringSourceMvcAnoApplication {
	private static final int PORT = 8080;
	private static final String CONTEXT_PATH = "";
	private static final Logger LOG = LoggerFactory.getLogger(SpringSourceMvcAnoApplication.class);

	public static void main(String[] args) throws Exception {
		SpringSourceMvcAnoApplication starter = new SpringSourceMvcAnoApplication();
		starter.start();
	}

	public void start() throws Exception {
		LOG.info("=================开始加载内嵌tomcat=====================");
		String userDir = System.getProperty("user.dir");
		String webappDir = userDir + File.separator + "/src/main/webapp";

		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(userDir);
		tomcat.setPort(PORT);

		tomcat.addWebapp(CONTEXT_PATH, webappDir);

		tomcat.enableNaming();
		LOG.info("BaseDir:{}", userDir);
		LOG.info("port:{}", PORT);
		LOG.info("context_path:{}", webappDir);

//		System.setProperty("tomcat.util.scan.StandardJarScanFilter.jarsToSkip", "\\,*");
		tomcat.start();
		LOG.info("==================tomcat加载成功==========================");
		LOG.info("测试地址：http://localhost:8080/index");
		tomcat.getServer().await();
	}
}
