package com.projectblejder.letsquit.introduction

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.databinding.IntroductionActivityBinding
import com.projectblejder.letsquit.habitSelection.NameBadHabitActivity
import com.projectblejder.letsquit.shared.BaseActivity

class IntroductionActivity : BaseActivity() {

    lateinit var binding: IntroductionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.introduction_activity)

        binding.startButton.setOnClickListener {
            startActivity(Intent(this, NameBadHabitActivity::class.java))
            finish()
        }
    }
}
