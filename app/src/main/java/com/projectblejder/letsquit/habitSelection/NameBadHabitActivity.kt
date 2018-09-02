package com.projectblejder.letsquit.habitSelection

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.projectblejder.letsquit.R
import com.projectblejder.letsquit.counter.CounterActivity
import com.projectblejder.letsquit.databinding.NameBadHabitActivityBinding
import com.projectblejder.letsquit.shared.BaseActivity
import com.projectblejder.letsquit.shared.MyHabit
import com.projectblejder.letsquit.shared.extensions.COMMON_DATA
import com.projectblejder.letsquit.shared.framework.SystemClock
import com.projectblejder.letsquit.shared.models.Habit
import dagger.android.AndroidInjection
import io.objectbox.BoxStore
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class NameBadHabitActivity : BaseActivity() {

    lateinit var binding: NameBadHabitActivityBinding

    companion object {
        const val REQUEST_CODE = 42
    }

    @Inject
    lateinit var boxStore: BoxStore

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.name_bad_habit_activity)

        binding.getInspiredButtom.setOnClickListener {
            startActivityForResult(intentFor<SelectPredefinedBadHabitsActivity>(), REQUEST_CODE)
        }

        binding.startButton.setOnClickListener {
            val habitName = binding.inputText.text?.toString() ?: ""
            if (habitName.isNotEmpty()) {
                selectBadHabit(habitName)
            }
        }
    }

    private fun selectBadHabit(name: String) {
        MyHabit(boxStore, SystemClock).createBadHabit(Habit(name = name))
        startActivity<CounterActivity>()
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != REQUEST_CODE || resultCode != Activity.RESULT_OK || data == null) {
            return
        }
        binding.inputText.setText(data.getStringExtra(COMMON_DATA)!!)
    }
}
