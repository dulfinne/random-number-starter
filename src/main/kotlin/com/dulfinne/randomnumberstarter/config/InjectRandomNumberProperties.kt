package com.dulfinne.randomnumberstarter.config

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.common.random-number")
data class InjectRandomNumberProperties(
    /**
     * Enables or disables the random number injection
     */
    var enabled: Boolean
) {
    private val log = LoggerFactory.getLogger(InjectRandomNumberProperties::class.java)

    @PostConstruct
    fun init() {
        log.info("Inject Random Number properties initialized: enabled=$enabled")
    }
}