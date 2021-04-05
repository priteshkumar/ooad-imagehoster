package ImageHoster.config;

import java.net.URI;
import java.net.URISyntaxException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JpaConfig {

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
    emfb.afterPropertiesSet();
    return emfb.getObject();
  }

  @Bean
  public DataSource dataSource() throws URISyntaxException {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.postgresql.Driver");
    URI dbUri = new URI(
        "postgres://phwbnhhyoztnfo:aa586c3d9c4856b0b6329c46ad174b6f6b87a9b14c0d8655aae3254ee2af8dd1@ec2-18-206-20-102.compute-1.amazonaws.com:5432/d1u7g6gjl7sj7a");
    System.out.println("dbhost" + " " +dbUri.getHost());
    System.out.println(dbUri.getPort() + " " + dbUri.getPath());
    ds.setUrl("jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath());
    ds.setUsername("phwbnhhyoztnfo");
    ds.setPassword("aa586c3d9c4856b0b6329c46ad174b6f6b87a9b14c0d8655aae3254ee2af8dd1");
    return ds;
  }
}
