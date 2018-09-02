package com.projectblejder.letsquit.counter

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.databinding.CounterActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.MyHabit
import com.projectblejder.letsquit.shared.boxStore
import com.projectblejder.letsquit.shared.extensions.click
import com.projectblejder.letsquit.shared.framework.SystemClock
import org.joda.time.DateTime

class CounterActivity : BaseActivity() {

    lateinit var binding: CounterActivityBinding

    lateinit var counter: Counter

    lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.counter_activity)

        counter = Counter(boxStore)
        viewModel = CounterViewModel(SystemClock, MyHabit(boxStore, SystemClock), counter)


        setUpClicks()
        binding.model = viewModel


        val dataSet = LineDataSet(listOf(
                Entry(DateTime.now().millis.toFloat(), 10f)
        ), "data")

        viewModel.callback = {
            val data = it.map { Entry(it.day.toFloat(), it.amount.toFloat()) }
            binding.chart.data = LineData(LineDataSet(data, "data"))
            binding.chart.invalidate()
        }
    }

    private fun setUpClicks() {
        binding.plusButton.click { viewModel.increment(1) }
        binding.minusButton.click { viewModel.increment(-1) }
        binding.editButton.click { }
        binding.nextDayButton.click { viewModel.nextDay() }
        binding.prevDayButton.click { viewModel.previousDate() }
    }
}

