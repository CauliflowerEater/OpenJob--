package io.openjob.server.scheduler.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(SchedulerProperties.class)
public class SchedulerAutoConfiguration {
}
