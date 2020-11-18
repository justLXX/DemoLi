package com.example.sub_base

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.sub_base.ability.*
import kotlinx.android.synthetic.main.dialog_device.view.*

/**
 * @Author: liYuan
 * @Date: 2020/11/12 4:40 PM
 * @Description:
 */
val FAMILY_NAME_MONOSPACE = "monospace"

fun showVersionDialog(context: Context) {
    val binding = context.inflate(R.layout.dialog_device)
    binding.text.typeface = Typeface.create(FAMILY_NAME_MONOSPACE, Typeface.NORMAL)
    binding.text.text = getInfo(context)
    val builder = AlertDialog.Builder(context)
    builder.setView(binding)
    builder.show()
}

private fun getInfo(context: Context): String {
    return "Debug=${BuildConfigHelper.debug}" +
            "\nScreenWid=${context.getScreenWidth()}" +
            "\nScreenHeight=${context.getScreenHeight()}" +
            "\nScreenHeightDp=${context.getScreenHeight().toDp()}" +
            "\nScreenWidDp=${context.getScreenWidth().toDp()}" +
            "\nStatusBarHeightDP=${context.getStatusBarHeight().toDp()}" +
            "\nDeviceModel=${Build.MODEL}" +
            "\nDeviceBrand=${Build.BRAND}" +
            "\nDeviceBrand=${Build.BRAND}" +
            "\nDeviceVersionRelease=${Build.VERSION.RELEASE}" +
            "\nDeviceVersionSdk=${Build.VERSION.SDK_INT}"
}