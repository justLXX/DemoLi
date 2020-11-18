package com.yangcong345.support.base.ability

import android.annotation.SuppressLint
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 *@author  liuxiaodong
 *@date  2018/11/18
 *@description  扩展
 */

fun <T> Observable<T>.changeIOToMainThread(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.changeIOToMainThread(): Single<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.changeIOToMainThread(): Flowable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}


/**
 * replace fragment扩展
 */
fun AppCompatActivity.replaceFragment(fragment: androidx.fragment.app.Fragment, @IdRes container: Int, tag: String? = fragment.javaClass.simpleName) {
    val beginTransaction = supportFragmentManager.beginTransaction()
    beginTransaction?.replace(container, fragment, tag)
    beginTransaction?.commitNowAllowingStateLoss()
}