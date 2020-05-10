package com.srokowski.pawelcv.presentation.experience

import androidx.recyclerview.widget.DiffUtil
import com.srokowski.pawelcv.data.entities.Experience

class ExperienceDiffCallback: DiffUtil.Callback() {

    private lateinit var oldList: List<Experience>
    private lateinit var newList: List<Experience>

    fun setItems(oldList: List<Experience>, newList: List<Experience>){
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