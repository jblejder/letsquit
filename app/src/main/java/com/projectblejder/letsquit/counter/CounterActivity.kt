package com.projectblejder.letsquit.counter

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.databinding.CounterActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.MyHabit
import com.projectblejder.letsquit.shared.boxStore
import com.projectblejder.letsquit.shared.extensions.click
import com.projectblejder.letsquit.shared.framework.SystemClock

class CounterActivity : BaseActivity() {

    lateinit var binding: CounterActivityBinding

    lateinit var counter: Counter

    lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.counter_activity)

        counter = Counter(boxStore)
        viewModel = CounterViewModel(SystemClock(), MyHabit(boxStore), counter)


        setUpClicks()
        binding.model = viewModel
    }

    private fun setUpClicks() {
        binding.plusButton.click { viewModel.increment(1) }
        binding.minusButton.click { viewModel.increment(-1) }
        binding.editButton.click { }
        binding.nextDayButton.click { viewModel.nextDay() }
        binding.prevDayButton.click { viewModel.previousDate() }
    }
}

