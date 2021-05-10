package com.namespacermcw.arrestsearch

import android.app.Activity  //was using this as per:
import android.app.Application
import com.namespacermcw.arrestsearch.di.component.AppComponent
import com.namespacermcw.arrestsearch.di.component.DaggerAppComponent
import com.namespacermcw.arrestsearch.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
//import dagger.android.HasActivityInjector
import javax.inject.Inject

class ArrestSearchApplication: Application() {
    lateinit var ArrestSearchComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        ArrestSearchComponent = initDagger(this)
    }

    /*
    * You’ll likely notice an error called out by Android Studio on DaggerAppComponent.
    * Click Make Module ‘app’ from the Android Studio Build menu.
    * This will generate a new file, called DaggerAppComponent.java
    *
    * */

    private fun initDagger(app: ArrestSearchApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}
/*
class ArrestSearchApplication: Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
 */