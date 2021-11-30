package com.bulletin_board.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig implements EnvironmentAware {

    private Environment environment;

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        String serverAddress = environment.getProperty("mail.server_address");
        String port = environment.getProperty("mail.port");
        String username = environment.getProperty("mail.username");
        String password = environment.getProperty("mail.password");
        String protocolName = environment.getProperty("mail.protocol_name");
        String protocolValue = environment.getProperty("mail.protocol_value");
        String authenticationName = environment.getProperty("mail.authentication_name");
        String authenticationValue = environment.getProperty("mail.authentication_value");
        String startTlsName = environment.getProperty("mail.start_tls_name");
        String startTlsValue = environment.getProperty("mail.start_tls_value");
        String sslTrustName = environment.getProperty("mail.ssl_trust_name");
        String sslTrustValue = environment.getProperty("mail.ssl_trust_value");

        mailSender.setHost(serverAddress);
        mailSender.setPort(Integer.parseInt(port));
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put(protocolName, protocolValue);
        properties.put(authenticationName, authenticationValue);
        properties.put(startTlsName, startTlsValue);
        properties.put(sslTrustName, sslTrustValue);

        return mailSender;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
