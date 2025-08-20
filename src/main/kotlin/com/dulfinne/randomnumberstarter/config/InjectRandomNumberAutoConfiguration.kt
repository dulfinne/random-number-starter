package com.dulfinne.randomnumberstarter.config

import com.dulfinne.randomnumberstarter.bbp.InjectRandomIntAnnotationBeanPostProcessor
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(InjectRandomNumberProperties::class)
@ConditionalOnClass(InjectRandomNumberProperties::class)
@ConditionalOnProperty(prefix = "app.common.random-number", name = ["enabled"], havingValue = "true")
class InjectRandomNumberAutoConfiguration {
    private val log = LoggerFactory.getLogger(InjectRandomNumberAutoConfiguration::class.java)

    @Bean
    fun injectRandomIntAnnotationBeanPostProcessor(): InjectRandomIntAnnotationBeanPostProcessor =
        InjectRandomIntAnnotationBeanPostProcessor()

    @PostConstruct
    fun init() {
        log.info("InjectRandomNumberAutoConfiguration initialized: $this")
    }
}