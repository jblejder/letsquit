package com.projectblejder.letsquit.shared

import com.projectblejder.letsquit.shared.dagger.DaggerAppComponent
import dagger.android.support.DaggerApplication

class GlobalApplication : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().create(this)
}
