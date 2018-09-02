package com.projectblejder.letsquit.shared.dagger

import android.content.Context
import android.content.res.Resources
import com.projectblejder.letsquit.shared.GlobalApplication
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun context(app: GlobalApplication): Context
}

@Module
class AppModule {

    @Provides
    fun resources(context: Context): Resources = context.resources
}
