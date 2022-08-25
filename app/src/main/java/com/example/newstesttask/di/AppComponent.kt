package com.example.newstesttask.di

import com.example.newstesttask.presentation.ListNewsFragment
import dagger.Component

@Component(modules = [AppModel::class])
interface AppComponent {
    fun inject(listNewsFragment: ListNewsFragment)
}