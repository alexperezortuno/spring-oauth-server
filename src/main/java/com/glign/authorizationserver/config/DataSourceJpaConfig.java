package com.glign.authorizationserver.config;

import com.glign.authorizationserver.entity.AuthUser;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
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

import javax.sql.DataSource;
import java.util.Objects;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.glign.authorizationserver.repository",
        entityManagerFactoryRef = "jpaEntityManagerFactory",
        transactionManagerRef= "jpaTransactionManager"
)
public class DataSourceJpaConfig {

    private static final Class[] ENTITIES_TEMP = {
            AuthUser.class
    };

    @Primary
    @Bean(name = "jpaDataSourceProperties")
    @ConfigurationProperties("primary.datasource.tomcat")
    public DataSourceProperties jpaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "jpaDataSource")
    public DataSource jpaDataSource() {
        return jpaDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "jpaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(jpaDataSource())
                .packages(ENTITIES_TEMP)
                .build();
    }

    @Primary
    @Bean(name = "jpaTransactionManager")
    public PlatformTransactionManager jpaTransactionManager(
            final @Qualifier("jpaEntityManagerFactory") LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(jpaEntityManagerFactory.getObject()));
    }

}
