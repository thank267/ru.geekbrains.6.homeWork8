package com.geekbrains.spring.web.recommendation.configs;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InfluxConfig {

    @Value("${influx.db_url}")
    private String databaseURL;

    @Value("${influx.user}")
    private String userName;

    @Value("${influx.password}")
    private String password;

    @Value("${influx.db_name}")
    private String dbName;

    @Bean
    public InfluxDB influxDB() {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL, userName, password);
        influxDB.query(new Query("CREATE DATABASE " + dbName, dbName));
        influxDB.setDatabase(dbName);
        return influxDB;
    }
}
