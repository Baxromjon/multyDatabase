package ai.ecma.appmultydb.ConfigDB;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(

        entityManagerFactoryRef = "universityEntityManagerFactory",
        transactionManagerRef = "universityTransactionManager",
        basePackages = {"ai.ecma.appmultydb.Repository.University"}
)

public class UniversityDbConfig {
    @Value(value = "${university_ddl_mode}")
    private String ddlMode;


    @Bean(name = "universityDBProperties")
    @ConfigurationProperties(prefix = "university.datasource")
    public DataSourceProperties properties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource universityDataSource(@Qualifier("universityDBProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "universityEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean internalEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", ddlMode);
        return builder
                .dataSource(universityDataSource(properties()))
                .packages("ai.ecma.appmultydb.Entity.University")
//                .persistenceUnit(INTERNAL)
                .properties(properties)
                .build();
    }

    @Bean(name = "universityTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("universityEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
