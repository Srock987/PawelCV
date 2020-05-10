package com.srokowski.pawelcv.presentation.experience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.srokowski.pawelcv.R
import com.srokowski.pawelcv.data.entities.Experience
import com.srokowski.pawelcv.presentation.shared.Binder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.experience_item.view.*

class ExperienceAdapter : RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    private var experience: List<Experience> = emptyList()
    private val diffCallback = ExperienceDiffCallback()

    fun setItems(experience: List<Experience>){
        diffCallback.setItems(this.experience, experience)
        val result = DiffUtil.calculateDiff(diffCallback)
        this.experience = experience
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        return ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.experience_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = experience.size

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        holder.onBind(experience[position])
    }

    class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer,
        Binder<Experience> {
        override val containerView: View? = itemView

        override fun onBind(data: Experience) {
            with(data) {
                itemView.dateTextView.text = itemView.context.getString(R.string.range_date, startDate, endDate ?: CURRENT_DATE)
                itemView.companyTextView.text = data.company
                itemView.jobTitleTextView.text = data.jobTitle
                itemView.jobDescription.text = data.jobDescription
            }
        }

        companion object {
            private const val CURRENT_DATE = "Current"
        }

    }

}