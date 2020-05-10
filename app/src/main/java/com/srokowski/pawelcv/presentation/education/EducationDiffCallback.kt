package com.srokowski.pawelcv.presentation.education

import androidx.recyclerview.widget.DiffUtil
import com.srokowski.pawelcv.data.entities.Education

class EducationDiffCallback : DiffUtil.Callback() {
    private lateinit var oldList: List<Education>
    private lateinit var newList: List<Education>

    fun setItems(oldList: List<Education>, newList: List<Education>) {
        this.oldList = oldList
        this.newList = newList
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}