package com.srokowski.pawelcv.presentation.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.srokowski.pawelcv.R
import com.srokowski.pawelcv.data.entities.Education
import com.srokowski.pawelcv.presentation.shared.Binder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.education_item.view.*

class EducationAdapter : RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    private var education: List<Education> = emptyList()
    private val diffCallback = EducationDiffCallback()


    fun setItems(education: List<Education>){
        diffCallback.setItems(this.education, education)
        val result = DiffUtil.calculateDiff(diffCallback)
        this.education = education
        result.dispatchUpdatesTo(this)
    }

    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer,
        Binder<Education> {
        override val containerView: View? = itemView
        override fun onBind(data: Education) {
            with(data) {
                itemView.dateTextView.text = itemView.context.getString(R.string.range_date, startDate, endDate ?: "Current")
                itemView.facultyTextView.text = faculty
                itemView.universityTextView.text = university
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.education_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = education.size

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.onBind(education[position])
    }
}