package com.namespacermcw.arrestsearch.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.namespacermcw.arrestsearch.api.ApiClient
import com.namespacermcw.arrestsearch.model.JailHouse
import com.namespacermcw.arrestsearch.model.Record
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RecordsListViewModel : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val arrestRecords: MutableLiveData<List<Record>> = MutableLiveData()
    private val apiRepo: ApiClient = ApiClient()

    fun getRecents(): LiveData<List<Record>> {
        disposables.add(
            apiRepo.getRecentsObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(this::loadSuccess, this::onError)
        )
        return arrestRecords
    }

    private fun loadSuccess(jailHouse: JailHouse) {
        // Get the list of records from the top level object
        // and post the value of the arrest records
        arrestRecords.postValue(jailHouse.records)
    }

    private fun onError(throwable: Throwable) {
        Log.e("_ERROR", "Fail to load $throwable")
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}