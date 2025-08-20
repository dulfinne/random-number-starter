package com.dulfinne.randomnumberstarter.bbp

import com.dulfinne.randomnumberstarter.annotation.InjectRandomInt
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.util.ReflectionUtils
import kotlin.random.Random

class InjectRandomIntAnnotationBeanPostProcessor() : BeanPostProcessor {

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
        bean.javaClass.declaredFields.forEach { field ->
            field.getAnnotation(InjectRandomInt::class.java)?.let {
                field.isAccessible = true
                val randomValue = Random.nextInt(it.min, it.max + 1)
                ReflectionUtils.setField(field, bean, randomValue)
            }
        }
        return bean
    }
}