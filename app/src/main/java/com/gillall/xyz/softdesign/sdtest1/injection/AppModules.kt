package com.gillall.xyz.softdesign.sdtest1.injection

import com.gillall.xyz.softdesign.sdtest1.data.remote.SDService
import com.gillall.xyz.softdesign.sdtest1.ui.eventviewer.EventViewerViewModel
import com.gillall.xyz.softdesign.sdtest1.ui.sdevents.SDEventsViewModel
import com.gillall.xyz.softdesign.sdtest1.ui.sdevents.SDEventsRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {

    val SDTest1 = module {
        single(named("SDApi")) { sdService() }
        single { SDEventsRepository(get(named("SDApi"))) }
        viewModel { SDEventsViewModel(get()) }
        viewModel { EventViewerViewModel(get(),get()) }
    }

    private fun sdService(): SDService {
        return Retrofit.Builder()
            .baseUrl("http://5f5a8f24d44d640016169133.mockapi.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SDService::class.java)
    }
}