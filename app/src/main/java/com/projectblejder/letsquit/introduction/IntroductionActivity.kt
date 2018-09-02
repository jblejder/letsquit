package com.projectblejder.letsquit.introduction

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.counter.CounterActivity
import com.projectblejder.letsquit.databinding.IntroductionActivityBinding
import com.projectblejder.letsquit.habitSelection.NameBadHabitActivity
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.MyHabit
import com.projectblejder.letsquit.shared.boxStore
import com.projectblejder.letsquit.shared.framework.SystemClock
import org.jetbrains.anko.startActivity

class IntroductionActivity : BaseActivity() {

    lateinit var binding: IntroductionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.introduction_activity)

        if (MyHabit(boxStore, SystemClock).isHabitSelected) {
            startActivity<CounterActivity>()
            finish()
            return
        }

        binding.startButton.setOnClickListener {
            startActivity<NameBadHabitActivity>()
            finish()
        }
    }
}
