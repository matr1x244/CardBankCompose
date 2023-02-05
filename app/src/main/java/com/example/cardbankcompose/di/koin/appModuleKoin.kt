package com.example.cardbankcompose.di.koin

import com.example.cardbankcompose.data.web.BinApi
import com.example.cardbankcompose.data.web.RetrofitRequestImpl
import com.example.cardbankcompose.domain.RepositoryBank
import com.example.cardbankcompose.domain.viewmodel.MainViewModels
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModuleKoin = module {

    val apiUrl = "https://lookup.binlist.net/"
    single<RepositoryBank> { RetrofitRequestImpl(get()) }
    single<BinApi> { get<Retrofit>().create(BinApi::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
    }

    factory<Converter.Factory> { GsonConverterFactory.create() }
    factory<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }

    viewModel { MainViewModels(get()) }
}