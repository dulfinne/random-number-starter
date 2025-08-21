package com.dulfinne.randomnumberstarter.bbp

import com.dulfinne.randomnumberstarter.annotation.InjectRandomInt
import com.dulfinne.randomnumberstarter.config.InjectRandomNumberProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.util.ReflectionUtils
import kotlin.random.Random

class InjectRandomIntAnnotationBeanPostProcessor(private val properties: InjectRandomNumberProperties) :
    BeanPostProcessor {

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
        bean.javaClass.declaredFields.forEach { field ->
            field.getAnnotation(InjectRandomInt::class.java)?.let {
                field.isAccessible = true
                val randomValue = Random.nextInt(properties.min, properties.max + 1)
                ReflectionUtils.setField(field, bean, randomValue)
            }
        }
        return bean
    }
}