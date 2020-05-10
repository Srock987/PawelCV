package com.srokowski.pawelcv.presentation.skill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.srokowski.pawelcv.R
import com.srokowski.pawelcv.presentation.shared.Binder
import com.srokowski.pawelcv.presentation.skill.SkillAdapter.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.skill_header_item.view.*
import kotlinx.android.synthetic.main.skill_item.view.*
import kotlinx.android.synthetic.main.skill_proficient_item.view.*

class SkillAdapter : RecyclerView.Adapter<SkillViewHolder>() {

    private var skills: List<SkillViewData> = emptyList()
    private val diffCallback = SkillDiffCallback()

    fun setItems(skills: List<SkillViewData>){
        diffCallback.setItems(this.skills, skills)
        val result = DiffUtil.calculateDiff(diffCallback)
        this.skills = skills
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val resId = when (viewType) {
            HEADER_TYPE -> R.layout.skill_header_item
            PROFICIENT_SKILL -> R.layout.skill_proficient_item
            else -> R.layout.skill_item
        }
        return SkillViewHolder(
            LayoutInflater.from(parent.context).inflate(
                resId,
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return when (skills[position]) {
            is SkillViewData.Header -> HEADER_TYPE
            is SkillViewData.ProficientSkill -> PROFICIENT_SKILL
            is SkillViewData.Skill -> SKILL
        }
    }

    override fun getItemCount(): Int = skills.size

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.onBind(skills[position])
    }

    class SkillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer,
        Binder<SkillViewData> {
        override val containerView: View? = itemView
        override fun onBind(data: SkillViewData) {
            when(data){
                is SkillViewData.Header -> {
                    itemView.skillHeaderTextView.text = data.header
                }
                is SkillViewData.ProficientSkill -> {
                    itemView.proficientSkillNameTextView.text = data.skillName
                    itemView.proficientLevelTextView.text = data.proficiency
                }
                is SkillViewData.Skill -> {
                    itemView.skillTextView.text = data.skillName
                }
            }
        }
    }

    companion object {
        const val HEADER_TYPE = 1
        const val PROFICIENT_SKILL = 2
        const val SKILL = 3
    }
}