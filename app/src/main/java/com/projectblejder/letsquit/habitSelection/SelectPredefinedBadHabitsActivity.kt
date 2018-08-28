package com.projectblejder.letsquit.habitSelection

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.google.gson.Gson
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.databinding.SelectPredefinedBadHabbitActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.extensions.COMMON_DATA
import com.projectblejder.letsquit.shared.models.Habit


class SelectPredefinedBadHabitsActivity : BaseActivity() {

    lateinit var binding: SelectPredefinedBadHabbitActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.select_predefined_bad_habbit_activity)

        val habits = getHabits()
        val adapter = BadHabitsAdapter().apply {
            feed = habits
        }
        binding.recyclerView.adapter = adapter
        adapter.callback = ::habitSelected
    }

    //    TODO: read async
    private fun getHabits(): List<Habit> {

        val builder = StringBuilder()
        resources.openRawResource(R.raw.bad_habit_examples)
                .bufferedReader()
                .useLines { lines ->
                    lines.forEach { builder.append(it) }
                }

        return Gson().fromJson(builder.toString(), Habits::class.java).habits
    }

    private fun habitSelected(habit: Habit) {
        val intent = Intent().apply {
            putExtra(COMMON_DATA, habit.name)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private class Habits {
        var habits: List<Habit> = emptyList()
    }
}
