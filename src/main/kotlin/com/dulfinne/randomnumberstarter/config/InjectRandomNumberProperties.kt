package com.dulfinne.randomnumberstarter.config

import jakarta.annotation.PostConstruct
import mu.KLogging
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.common.random-number")
data class InjectRandomNumberProperties(
    /**
     * Enables or disables the random number injection
     */
    var enabled: Boolean
) {
    companion object : KLogging()

    @PostConstruct
    fun init() {
        logger.info { "Inject Random Number properties initialized: enabled=$enabled" }
    }
}