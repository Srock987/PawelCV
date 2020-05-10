package com.srokowski.pawelcv

import android.app.Application
import com.srokowski.pawelcv.di.dataModule
import com.srokowski.pawelcv.di.presentationModule
import com.srokowski.pawelcv.di.retrofitModule
import com.srokowski.pawelcv.di.roomModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class App : Application(), KodeinAware{
    override val kodein: Kodein by Kodein.lazy {
        import(androidXModule(this@App))
        import(retrofitModule)
        import(roomModule)
        import(dataModule)
        import(presentationModule)
    }

}