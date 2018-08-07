package com.projectblejder.letsquit

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.databinding.NameBadHabitActivityBinding

class NameBadHabitActivity : BaseActivity() {

    lateinit var binding: NameBadHabitActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.name_bad_habit_activity)

        binding.getInspiredButtom.setOnClickListener {
            startActivity(Intent(this, SelectPredefinedBadHabitsActivity::class.java))
        }
    }
}

