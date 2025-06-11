package org.example.spring_caw_ktk.config;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.example.spring_caw_ktk.dao.BmiDao;
import org.example.spring_caw_ktk.dao.ExerciseDao;
import org.example.spring_caw_ktk.dao.ExerciseRepository;
import org.example.spring_caw_ktk.dao.KcalDao;
import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.service.BmiService;
import org.example.spring_caw_ktk.service.MemberRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfig {
	 @Bean(destroyMethod = "close")
	 public DataSource dataSource() {
	 DataSource ds = new DataSource();
	 ds.setDriverClassName("com.mysql.jdbc.Driver");
	 ds.setUrl("jdbc:mysql://localhost:3307/spring_univ_project_db");
	 ds.setUsername("KTKCAW");
	 ds.setPassword("1234");
	 ds.setInitialSize(2);
	 ds.setMaxActive(10);
	 ds.setTestWhileIdle(true);
	 ds.setMinEvictableIdleTimeMillis(60000 * 3);
	 ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
	 return ds;
	 }
	 
	 @Bean
	 public MemberDao memberDao() {
	 return new MemberDao(dataSource());
	 }
	 
	 @Bean
	 public MemberRegisterService memberRegSvc() {
	 return new MemberRegisterService(memberDao());
	 }
	 
	    @Bean
	    public BmiDao bmiDao() {
	        return new BmiDao(dataSource());
	    }
	    
	    @Bean
	    public KcalDao kcalDao() {
	        return new KcalDao(dataSource());
	    }
	    
	    @Bean
	    public ExerciseDao exerciseDao() {
	        return new ExerciseDao(dataSource());
	    }
	    


	    
}
