package com.srokowski.pawelcv.presentation.education

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.srokowski.pawelcv.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class EducationFragment: Fragment(R.layout.fragment_education), KodeinAware {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override val kodein: Kodein by kodein()
}