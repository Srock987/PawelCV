package com.srokowski.pawelcv.presentation.experience

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.srokowski.pawelcv.R
import com.srokowski.pawelcv.di.fragmentViewModel
import com.srokowski.pawelcv.presentation.shared.CvSharedViewModel
import kotlinx.android.synthetic.main.fragment_experience.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class ExperienceFragment: Fragment(R.layout.fragment_experience), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: CvSharedViewModel by fragmentViewModel(CvSharedViewModel::class.java)
    private val adapter: ExperienceAdapter = ExperienceAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        experienceRecyclerView.layoutManager = LinearLayoutManager(context)
        experienceRecyclerView.adapter = adapter
        viewModel.getExperience().observe(viewLifecycleOwner, Observer {
            progress.hide()
            adapter.setItems(it)
        })
    }

}