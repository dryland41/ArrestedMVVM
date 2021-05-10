package com.namespacermcw.arrestsearch.di.component

import android.app.Application
import com.namespacermcw.arrestsearch.di.modules.AppModule
import com.namespacermcw.arrestsearch.di.modules.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

//@Singleton
//@Component(modules = [AppModule::class]) //
// modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class

//interface AppComponent //{
    //fun inject(app: Application)
//}

/*
* We’ve told Dagger that AppComponent is a singleton component interface for the app.
* The @Component annotation takes a list of modules as an input.
* We’re using the literal array syntax available in Kotlin, [AppModule::class].
* The component is used to connect objects to their dependencies,
* typically by use of overridden inject() methods. In order to use the component,
* it must be accessible from the parts of the app that need injection.
* Typically, that will happen from the app Application subclass
* */

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class)
)
interface AppComponent {
    fun inject(app: Application)
}