package com.projectblejder.letsquit.habitSelection

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.counter.CounterActivity
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.databinding.NameBadHabitActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.Habit
import com.projectblejder.letsquit.shared.MyHabit
import org.jetbrains.anko.startActivity

class NameBadHabitActivity : BaseActivity() {

    lateinit var binding: NameBadHabitActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.name_bad_habit_activity)

        binding.getInspiredButtom.setOnClickListener {
            startActivity(Intent(this, SelectPredefinedBadHabitsActivity::class.java))
        }

        binding.startButton.setOnClickListener {
            val habitName = binding.inputText.text?.toString() ?: ""
            if (habitName.length > 0) {
                MyHabit(this).habit = Habit(habitName)
                startActivity<CounterActivity>()
            }
        }
    }
}

