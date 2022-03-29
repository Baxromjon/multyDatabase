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

        entityManagerFactoryRef = "companyEntityManagerFactory",
        transactionManagerRef = "companyTransactionManager",
        basePackages = {"ai.ecma.appmultydb.Repository.Company"}
)

public class CompanyDbConfig {
    @Value(value = "${company_ddl_mode}")
    private String ddlMode;


    @Bean(name = "companyDBProperties")
    @ConfigurationProperties(prefix = "company.datasource")
    public DataSourceProperties properties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource companyDataSource(@Qualifier("companyDBProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "companyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean internalEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", ddlMode);
        return builder
                .dataSource(companyDataSource(properties()))
                .packages("ai.ecma.appmultydb.Entity.Company")
//                .persistenceUnit(INTERNAL)
                .properties(properties)
                .build();
    }

    @Bean(name = "companyTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("companyEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
