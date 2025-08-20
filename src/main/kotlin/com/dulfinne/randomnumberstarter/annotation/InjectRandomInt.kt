package com.dulfinne.randomnumberstarter.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class InjectRandomInt(val min: Int, val max: Int)
