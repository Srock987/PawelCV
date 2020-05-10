package com.srokowski.pawelcv.presentation.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.srokowski.pawelcv.R
import com.srokowski.pawelcv.di.fragmentViewModel
import com.srokowski.pawelcv.presentation.shared.CvSharedViewModel
import kotlinx.android.synthetic.main.fragment_info.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class InfoFragment: Fragment(R.layout.fragment_info), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: CvSharedViewModel by fragmentViewModel(CvSharedViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCvDate().observe(this, Observer {
            progress.hide()
            nameTextView.text = it.name
            occupationTextView.text = it.occupation
            addressTextView.text = it.address
            emailTextView.text = it.email
            phoneTextView.text = it.phone
        })
    }


}