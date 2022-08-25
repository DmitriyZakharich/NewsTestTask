package com.example.newstesttask.di

import com.example.newstesttask.domain.GetAdapterNewsUseCase
import com.example.newstesttask.repository.NetworkRepository
import com.example.newstesttask.viewmodel.ListNewsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModel {

    @Provides
    fun provideListNewsViewModelFactory(
            getAdapterNewsUseCase: GetAdapterNewsUseCase): ListNewsViewModelFactory =
        ListNewsViewModelFactory(getAdapterNewsUseCase)

    @Provides
    fun provideGetAdapterNewsUseCase(networkRepository: NetworkRepository): GetAdapterNewsUseCase =
        GetAdapterNewsUseCase(networkRepository)

    @Provides
    fun provideNetworkRepository(): NetworkRepository = NetworkRepository()
}