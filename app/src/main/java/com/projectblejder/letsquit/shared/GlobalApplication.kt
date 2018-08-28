package com.projectblejder.letsquit.shared

import android.app.Application
import android.content.Context
import com.projectblejder.letsquit.shared.models.MyObjectBox
import io.objectbox.BoxStore

class GlobalApplication : Application() {

    lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()
    }
}

val Context.boxStore: BoxStore
    get() = (applicationContext as GlobalApplication).boxStore