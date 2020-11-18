package com.example.sub_base.ability

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @author: drawf
 * @date: 2018/12/10
 * @see: <a href=""></a>
 * @description: 数据转换的扩展方法
 */

/**
 * Serializable to json
 */
fun Serializable.toJson(): String {
    return Gson().toJson(this)
}

fun Parcelable.toJson(): String {
    return Gson().toJson(this)
}

/**
 * String Any类型的map to json
 */
fun Map<String, Any>.toJson(): String {
    return Gson().toJson(this)
}


/**
 * List<Any> to json
 */
fun List<Any>.toJson(): String {
    return Gson().toJson(this)
}

/**
 * String Any类型的map to entity
 */
inline fun <reified T> Map<String, Any>.toEntity(): T {
    return Gson().fromJson<T>(this.toJson(), T::class.java)
}

fun <T> Map<String, Any>.toEntityJava(clazz: Class<T>): T {
    return Gson().fromJson<T>(this.toJson(), clazz)
}


/**
 * Json String to Entity
 */
inline fun <reified T> String.toEntity(): T {
    return Gson().fromJson<T>(this, T::class.java)
}

/**
 * Json String to List<Entity>
 */
inline fun <reified T> String.toEntityList(): List<T> {
    val type = object : ParameterizedType {
        override fun getRawType(): Type {
            return List::class.java
        }

        override fun getOwnerType(): Type? {
            return null
        }

        override fun getActualTypeArguments(): Array<Type> {
            return arrayOf(T::class.java)
        }
    }
    return Gson().fromJson(this, type)
}

/**
 * Json String to List<Entity>
 */
inline fun <reified T> String.toMutableListEntityList(): MutableList<T> {
    val type = object : ParameterizedType {
        override fun getRawType(): Type {
            return MutableList::class.java
        }

        override fun getOwnerType(): Type? {
            return null
        }

        override fun getActualTypeArguments(): Array<Type> {
            return arrayOf(T::class.java)
        }
    }
    return Gson().fromJson(this, type)
}


fun String.toMap(): Map<String, Any> {
    val type = object : TypeToken<Map<String, Any>>() {}.type
    return Gson().fromJson(this, type)
}

fun Serializable.toMap(): Map<String, Any> {
    return Gson().toJson(this).toMap()
}

fun Parcelable.toMap(): Map<String, Any> {
    return Gson().toJson(this).toMap()
}

fun <T> String.toT(clazz: Class<T>): T {
    return Gson().fromJson<T>(this, clazz)
}

fun <T> T.toJsonNullable(): String? {
    if (this == null) {
        return null
    }
    return Gson().toJson(this)
}

fun <T> T.toMapNullable(): Map<String, Any>? {
    return this.toJsonNullable()?.toMap()
}