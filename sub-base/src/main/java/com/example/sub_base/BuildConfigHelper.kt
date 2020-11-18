package com.example.sub_base

/**
 * 获取 BuildConfig 中的配置信息
 * 因为非 app-math 的其他 module 自动生成的 BuildConfig 的信息是不准确的
 * 比如 com.yangcong345.common.temp.BuildConfig VERSION_NAME 为 1.0，而非真实版本
 * 所以此处使用反射获取 com.yangcong345.android.phone.BuildConfig 中的信息
 * 其他非 app-math module 都应该使用此类获取 BuildConfig 中信息
 */
class BuildConfigHelper {

    companion object {
        @JvmField
        var debug = false

        @JvmField
        var applicationId = ""

        @JvmField
        var buildType = ""

        @JvmField
        var flavor = ""

        @JvmField
        var versionCode = 1

        @JvmField
        var versionName = ""

        init {
            val buildConfigClassName = "com.example.demoli.BuildConfig"
            try {
                val buildConfigClass = Class.forName(buildConfigClassName)
                debug = buildConfigClass.getField("DEBUG").getBoolean(null)
                applicationId = buildConfigClass.getField("APPLICATION_ID").get(null) as String
                buildType = buildConfigClass.getField("BUILD_TYPE").get(null) as String
                flavor = buildConfigClass.getField("FLAVOR").get(null) as String
                versionCode = buildConfigClass.getField("VERSION_CODE").getInt(null)
                versionName = buildConfigClass.getField("VERSION_NAME").get(null) as String
            } catch (e: Exception) {
            }
        }
    }
}

