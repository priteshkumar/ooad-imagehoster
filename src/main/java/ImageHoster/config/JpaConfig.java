package ImageHoster.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JpaConfig {

  @Bean
  public EntityManagerFactory entityManagerFactory() throws URISyntaxException {
    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();

    Properties props = new Properties();
    emfb.setPersistenceUnitName("imageHoster");
    emfb.setPersistenceProvider(new HibernatePersistenceProvider());
    emfb.setPackagesToScan("ImageHoster.model");
    emfb.setDataSource(dataSource());
    props.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL82Dialect");
    props.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
    props.setProperty("hibernate.hbm2ddl.auto","update");
    props.setProperty("hibernate.format_sql","true");
    props.setProperty("hibernate.show_sql","false");
    emfb.setJpaProperties(props);
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
