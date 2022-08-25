package com.example.newstesttask.di

import com.example.newstesttask.domain.GetAdapterNewsUseCaseImpl
import com.example.newstesttask.domain.interfaces.NetworkRepository
import com.example.newstesttask.repository.NetworkRepositoryImpl
import com.example.newstesttask.viewmodel.ListNewsViewModelFactory
import com.example.newstesttask.viewmodel.interfaces.GetAdapterNewsUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModel {

    @Provides
    fun provideListNewsViewModelFactory(
            getAdapterNewsUseCase: GetAdapterNewsUseCase): ListNewsViewModelFactory =
        ListNewsViewModelFactory(getAdapterNewsUseCase)

    @Provides
    fun provideGetAdapterNewsUseCase(
            networkRepository: NetworkRepository): GetAdapterNewsUseCase =
        GetAdapterNewsUseCaseImpl(networkRepository)

    @Provides
    fun provideNetworkRepository(): NetworkRepository = NetworkRepositoryImpl()
}