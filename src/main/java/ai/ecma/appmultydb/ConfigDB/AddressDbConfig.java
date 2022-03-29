package ai.ecma.appmultydb.ConfigDB;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

        entityManagerFactoryRef = "addressEntityManagerFactory",
        transactionManagerRef = "addressTransactionManager",
        basePackages = {"ai.ecma.appmultydb.Repository.Address"}
)

public class AddressDbConfig {
    @Value(value = "${address_ddl_mode}")
    private String ddlMode;


    @Primary
    @Bean(name = "addressDBProperties")
    @ConfigurationProperties(prefix = "address.datasource")
    public DataSourceProperties properties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource addressDataSource(@Qualifier("addressDBProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "addressEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean internalEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", ddlMode);
        return builder
                .dataSource(addressDataSource(properties()))
                .packages("ai.ecma.appmultydb.Entity.Address")
//                .persistenceUnit(INTERNAL)
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "addressTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("addressEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
