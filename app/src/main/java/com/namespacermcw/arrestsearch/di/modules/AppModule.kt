package com.namespacermcw.arrestsearch.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.namespacermcw.arrestsearch.dao.ArrestSearchDao
import com.namespacermcw.arrestsearch.dao.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
* The @Module annotation tells Dagger that the
* AppModule class will provide dependencies for
* a part of the application.
* */
@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideRecordsDataBase(app: Application): Database =
        Room.databaseBuilder(app, Database::class.java, "records_db").build()

    @Provides
    @Singleton
    fun provideRecordsDao(database: Database): ArrestSearchDao = database.recordsDao()

    /*
    * @Provides annotation tells Dagger that the method provides
    * a certain type of dependency, in this case, a Context object.
    * When a part of the app requests that Dagger inject a Context,
    * the @Provides annotation tells Dagger where to find it.
    * */
    @Provides
    /*
    * The @Singleton annotation is not part of the Dagger API.
    * It’s contained inside the javax package you added to your build.gradle
    * at the beginning. It tells Dagger that there should only be a single
    * instance of that dependency. So when generating the code Dagger will
    * handle all the logic for you, and you won’t write all the boilerplate
    * code to check if another instance of the object is already available.
    * */
    @Singleton
    //fun provideApplication(): Application = app

    /* a private field to hold a reference to the app object
     * a constructor to configure app, and a provideContext()
     * method that returns the app object
     *
     * The method names for the providers, such as provideContext(),
     * are not important and can be named anything you like.
     * Dagger only looks at the return type. Using provide as a
     * prefix is a common convention.
     * */
    fun provideContext(): Context = app
}