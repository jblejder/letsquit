package com.projectblejder.letsquit

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.databinding.CounterActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.MyHabit

class CounterActivity : BaseActivity() {

    lateinit var binding: CounterActivityBinding

    lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.counter_activity)

        counter = Counter(this)

        binding.habitName.text = MyHabit(this).habit?.name ?: "No habit :("
        binding.counter.text = "${counter.number}"

        binding.root.setOnClickListener {
            counter.number = counter.number + 1
            binding.counter.text = "${counter.number}"
        }
    }
}

