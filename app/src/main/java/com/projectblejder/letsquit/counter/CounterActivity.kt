package com.projectblejder.letsquit.counter

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.databinding.CounterActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.extensions.click
import dagger.android.AndroidInjection
import javax.inject.Inject

class CounterActivity : BaseActivity() {

    lateinit var binding: CounterActivityBinding

    @Inject
    lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.counter_activity)

        setUpClicks()
        binding.model = viewModel


        binding.chart.also {
            it.setDrawGridBackground(false)
            it.legend.isEnabled = false
            it.description = null
            it.axisLeft.also {
                it.isEnabled = false
                it.setDrawGridLines(false)
                it.setDrawLabels(false)
            }
            it.axisRight.also {
                it.isEnabled = false
                it.setDrawGridLines(false)
                it.setDrawLabels(false)
            }
            it.xAxis.also {
                it.isEnabled = false
                it.setDrawGridLines(false)
                it.setDrawLabels(false)
            }
        }


        val data = viewModel.data.mapIndexed { index, i -> Entry(index.toFloat(), i.toFloat()) }

        binding.chart.data = LineData(LineDataSet(data, "").also {
            it.isHighlightEnabled = false
            it.lineWidth = 5f
            it.setDrawCircles(false)
        }).also {
            it.setDrawValues(false)
        }


        binding.chart.invalidate()

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

