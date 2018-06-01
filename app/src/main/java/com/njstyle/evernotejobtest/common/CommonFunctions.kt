package com.njstyle.evernotejobtest.common

import kotlin.reflect.KClass

fun <T: Any> KClass<T>.getTag() = this.java.simpleName
