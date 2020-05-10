package com.srokowski.pawelcv.presentation.skill

import androidx.recyclerview.widget.DiffUtil

class SkillDiffCallback: DiffUtil.Callback() {
    private lateinit var oldList: List<SkillViewData>
    private lateinit var newList: List<SkillViewData>

    fun setItems(oldList: List<SkillViewData>, newList: List<SkillViewData>) {
        this.oldList = oldList
        this.newList = newList
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
