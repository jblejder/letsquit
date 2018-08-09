package com.projectblejder.letsquit.habitSelection

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.projectblejder.letsquit.databinding.BadHabitListviewBinding
import com.projectblejder.letsquit.shared.Habit

class BadHabitsAdapter : RecyclerView.Adapter<BadHabitsAdapter.ViewHolder>() {

    var callback: ((habit: Habit) -> Unit)? = null

    var feed = emptyList<Habit>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
            ViewHolder(BadHabitListviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = feed.size

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.bind(feed[index])
    }

    inner class ViewHolder(val binding: BadHabitListviewBinding) : RecyclerView.ViewHolder(binding.root) {

        var habit: Habit? = null

        init {
            binding.root.setOnClickListener { it ->
                habit?.also { callback?.invoke(it) }
            }
        }

        fun bind(habit: Habit) {
            binding.name.text = habit.name
            this.habit = habit
        }
    }
}
