package com.projectblejder.letsquit.habitSelection

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.projectblejder.letsquit.shared.Habit
import com.projectblejder.letsquit.databinding.BadHabitListviewBinding

class BadHabitsAdapter : RecyclerView.Adapter<BadHabitsAdapter.ViewHolder>() {

    var feed = emptyList<Habit>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
            ViewHolder.create(parent)

    override fun getItemCount() = feed.size

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.bind(feed[index])
    }

    class ViewHolder(val binding: BadHabitListviewBinding) : RecyclerView.ViewHolder(binding.root) {

        var habit: Habit? = null

        companion object {
            fun create(parent: ViewGroup) =
                    ViewHolder(BadHabitListviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        fun bind(habit: Habit) {
            binding.name.text = habit.name
            this.habit = habit
        }
    }
}
