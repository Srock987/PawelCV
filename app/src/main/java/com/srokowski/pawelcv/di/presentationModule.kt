package com.srokowski.pawelcv.di

import androidx.lifecycle.ViewModelProvider
import com.srokowski.pawelcv.presentation.shared.CvModel
import com.srokowski.pawelcv.presentation.shared.CvSharedViewModel
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val presentationModule = Kodein.Module("PresentationModule"){

    bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein.direct) }

    bind<CvModel>() with provider {
        CvModel(
            repository = instance()
        )
    }

    bindViewModel<CvSharedViewModel>() with provider {
        CvSharedViewModel(
            model = instance()
        )
    }
}