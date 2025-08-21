package com.dulfinne.randomnumberstarter.config

import com.dulfinne.randomnumberstarter.util.RandomConstants.DEFAULT_MAX
import com.dulfinne.randomnumberstarter.util.RandomConstants.DEFAULT_MIN
import jakarta.annotation.PostConstruct
import mu.KLogging
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.common.random-number")
data class InjectRandomNumberProperties(
    /**
     * Enables or disables the random number injection
     */
    var enabled: Boolean,

    /**
     * min bound of random number (by default = 1)
     */
    var min: Int = DEFAULT_MIN,

    /**
     * max bound of random number (by default = 10)
     */
    var max: Int = DEFAULT_MAX
) {
    companion object : KLogging()

    @PostConstruct
    fun init() {
        validate()
        logger.info { "Inject Random Number properties initialized: enabled=$enabled, min=$min, max=$max" }
    }

    private fun validate() {
        if (min > max) {
            logger.warn { "Inject Random Number properties app.common.random-number.min ($min) > app.common.random-number.max ($max), using defaults: min=$DEFAULT_MIN, max=$DEFAULT_MAX" }
            min = DEFAULT_MIN
            max = DEFAULT_MAX
        }
    }
}