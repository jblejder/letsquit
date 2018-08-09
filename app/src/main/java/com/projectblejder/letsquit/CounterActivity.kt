package com.projectblejder.letsquit

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.databinding.IntroductionActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.MyHabit

class CounterActivity : BaseActivity() {

    lateinit var binding: IntroductionActivityBinding

    lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.counter_activity)

        counter = Counter(this)

        binding.title.text = MyHabit(this).habit?.name ?: "No habit :("
        binding.description.text = "${counter.number}"

        binding.root.setOnClickListener {
            counter.number = counter.number + 1
            binding.description.text = "${counter.number}"
        }
    }
}

