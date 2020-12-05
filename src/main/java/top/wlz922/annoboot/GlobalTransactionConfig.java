package top.wlz922.annoboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 事务
 *
 * @author Eddie
 */
@Configuration
@MapperScan(basePackages = "top.wlz922.dao")
@EnableTransactionManagement
public class GlobalTransactionConfig {
	@Autowired
	ApplicationContext context;


	@Bean
	public DataSourceTransactionManager getTransactionManager(@Autowired DataSource ds){
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(ds);
		return manager;
	}

	@Bean
	public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource ds) throws IOException {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(ds);
		ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(context);
		Resource[] resources = resolver.getResources("classpath:sqlmaps/*.xml");
		fb.setMapperLocations(resources);
		return fb;
	}

	@Bean
	public DruidDataSource getDruidDataSource(){
		DruidDataSource ds = new DruidDataSource();
		ds.setUsername("root");
		ds.setPassword("123456");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setMaxActive(1);
		return ds;
	}
}
