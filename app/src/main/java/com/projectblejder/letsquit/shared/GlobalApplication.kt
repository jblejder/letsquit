package com.projectblejder.letsquit.shared

import android.content.Context
import com.projectblejder.letsquit.shared.dagger.DaggerAppComponent
import com.projectblejder.letsquit.shared.models.MyObjectBox
import dagger.android.support.DaggerApplication
import io.objectbox.BoxStore

class GlobalApplication : DaggerApplication() {

    lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()
    }

    override fun applicationInjector() = DaggerAppComponent.builder().create(this)
}

val Context.boxStore: BoxStore
    get() = (applicationContext as GlobalApplication).boxStore