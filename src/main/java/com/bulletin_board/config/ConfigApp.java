package com.bulletin_board.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.bulletin_board.service", "com.bulletin_board.controller"})
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bulletin_board.repository")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(MailConfig.class)
@EnableScheduling
@PropertySource("classpath:db.properties")
public class ConfigApp implements WebMvcConfigurer, EnvironmentAware {

    private Environment environment;

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(factory);
        manager.setDataSource(dataSource());

        return manager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter, DataSource source) {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();

        String packageName = environment.getProperty("db.package_name");

        lcemfb.setDataSource(source);
        lcemfb.setJpaVendorAdapter(adapter);
        lcemfb.setPackagesToScan(packageName);
        return lcemfb;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String driverClassName = environment.getProperty("db.driver");
        String url = environment.getProperty("db.url");
        String username = environment.getProperty("db.username");
        String password = environment.getProperty("db.password");

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        String databasePlatform = environment.getProperty("db.platform");
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setDatabasePlatform(databasePlatform);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
