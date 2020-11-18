//通过@file: JvmName("ContextUtil")注解，将生成的类名修改为ContextUtil，并且调用的时候直接调用ContextUtil.foo()即可
//放在文件顶部，在package声明的前面
@file: JvmName("ContextUtil")

package com.example.sub_base.ability

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.graphics.Typeface
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes


/**
 * @author: drawf
 * @date: 2018/8/24
 * @see: <a href=""></a>
 */
//********************************
//* Toast相关
//********************************


//********************************
//* 尺寸转换
//********************************

fun Context.dp2px(dpValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

fun Context.px2dp(pxValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun Context.sp2px(spValue: Float): Int {
    val scale = resources.displayMetrics.scaledDensity
    return (spValue * scale + 0.5f).toInt()
}


fun Float.toPx(): Int {
    val scale: Float = Resources.getSystem().displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

fun Int.toPx(): Int {
    val scale: Float = Resources.getSystem().displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

fun Int.toDp(): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

fun Float.toDp(): Float {
    val scale = Resources.getSystem().displayMetrics.density
    return (this / scale + 0.5f).toFloat()
}


//----------屏幕尺寸----------


fun Context.getScreenWidth(): Int {
    var wm: WindowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    var point = Point()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        wm.defaultDisplay.getRealSize(point)
    } else {
        wm.defaultDisplay.getSize(point)
    }
    return point.x
}

fun Context.getScreenHeight(): Int {
    var wm: WindowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    var point = Point()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        wm.defaultDisplay.getRealSize(point)
    } else {
        wm.defaultDisplay.getSize(point)
    }
    return point.y
}

/**
 * 获取状态栏高度
 *
 * @return 高度
 */

fun Context.getStatusBarHeight(): Int {
    var result = 0
    val resId = resources.getIdentifier("status_bar_height", "dimen", "android");
    if (resId > 0) {
        result = getResources().getDimensionPixelSize(resId)
    }
    return result;
}

fun Context.layoutInflater(): LayoutInflater {
    return LayoutInflater.from(this)
}

fun Context.inflate(@LayoutRes res: Int, container: ViewGroup, attachToRoot: Boolean): View {
    return LayoutInflater.from(this).inflate(res, container, attachToRoot)
}

fun Context.inflate(@LayoutRes res: Int): View {
    return LayoutInflater.from(this).inflate(res, null)
}

val typefaceMap = hashMapOf<String, Typeface?>()

fun Context.getTypeFace(path: String): Typeface? {
    val mgr = this.assets
    var typeface = typefaceMap[path]
    if (typeface != null) {
        return typeface
    }
    try {
        val typeface = Typeface.createFromAsset(mgr, path)
        typefaceMap.put(path, typeface)
        return typeface
    } catch (e: Exception) {
    }
    return null
}