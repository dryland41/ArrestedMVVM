package com.namespacermcw.arrestsearch.di.modules

import com.namespacermcw.arrestsearch.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeArrestSearchActivity(): MainActivity
}