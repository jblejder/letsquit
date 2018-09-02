package com.projectblejder.letsquit.shared.dagger

import com.projectblejder.letsquit.counter.CounterActivity
import com.projectblejder.letsquit.habitSelection.NameBadHabitActivity
import com.projectblejder.letsquit.introduction.IntroductionActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BaseActivitiesModule {

    @ContributesAndroidInjector
    fun counterActivity(): CounterActivity

    @ContributesAndroidInjector
    fun introductionActivity(): IntroductionActivity

    @ContributesAndroidInjector
    fun nameBadHabitActivity(): NameBadHabitActivity
}
