package com.projectblejder.letsquit.shared.dagger

import android.content.Context
import android.content.res.Resources
import com.projectblejder.letsquit.shared.GlobalApplication
import com.projectblejder.letsquit.shared.framework.Clock
import com.projectblejder.letsquit.shared.framework.SystemClock
import com.projectblejder.letsquit.shared.models.MyObjectBox
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun context(app: GlobalApplication): Context

}

@Module
class AppModule {

    @Provides
    fun resources(context: Context): Resources = context.resources

    @Provides
    fun clock(): Clock = SystemClock

    @Provides
    @Singleton
    fun objectBox(context: Context): BoxStore =
            MyObjectBox.builder().androidContext(context).build()
}
