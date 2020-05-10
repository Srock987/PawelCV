package com.srokowski.pawelcv.presentation.skill

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.srokowski.pawelcv.R
import com.srokowski.pawelcv.di.fragmentViewModel
import com.srokowski.pawelcv.presentation.shared.CvSharedViewModel
import kotlinx.android.synthetic.main.fragment_skill.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class SkillFragment: Fragment(R.layout.fragment_skill), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: CvSharedViewModel by fragmentViewModel(CvSharedViewModel::class.java)
    private val adapter = SkillAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        skillsRecyclerView.layoutManager = LinearLayoutManager(context)
        skillsRecyclerView.adapter = adapter
        viewModel.getSkillViewData().observe(viewLifecycleOwner, Observer {
            progress.hide()
            adapter.setItems(it)
        })
    }

}