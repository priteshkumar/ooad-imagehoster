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
    String dbURI = System.getenv("DATABASE_URL");
    URI dbUri = new URI(dbURI);
    ds.setUrl("jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath());
    ds.setUsername(dbUri.getUserInfo().split(":")[0]);
    ds.setPassword(dbUri.getUserInfo().split(":")[1]);
    return ds;
  }
}
