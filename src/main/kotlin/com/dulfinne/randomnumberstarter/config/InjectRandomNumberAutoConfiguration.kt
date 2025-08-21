package com.dulfinne.randomnumberstarter.config

import com.dulfinne.randomnumberstarter.bbp.InjectRandomIntAnnotationBeanPostProcessor
import jakarta.annotation.PostConstruct
import mu.KLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(InjectRandomNumberProperties::class)
@ConditionalOnClass(InjectRandomNumberProperties::class)
@ConditionalOnProperty(prefix = "app.common.random-number", name = ["enabled"], havingValue = "true")
class InjectRandomNumberAutoConfiguration(private val properties: InjectRandomNumberProperties) {
    companion object : KLogging()

    @Bean
    fun injectRandomIntAnnotationBeanPostProcessor() = InjectRandomIntAnnotationBeanPostProcessor(properties)

    @PostConstruct
    fun init() {
        logger.info { "InjectRandomNumberAutoConfiguration initialized: $this" }
    }
}