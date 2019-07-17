package com.example.zoopractice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.zoopractice.ZooApplication
import com.example.zoopractice.database.api.ApiInterface
import com.example.zoopractice.database.api.RetrofitClient
import com.example.zoopractice.database.room.ZooDatabase
import com.example.zoopractice.model.Results
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ZooRepository {

    private val list = ArrayList<Results>()
    private val liveData = MutableLiveData<List<Results>>()

    private val database = ZooDatabase.getInstance(ZooApplication.applicationContext())


    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        liveData.value = list
    }

    fun getZooData(): LiveData<List<Results>> {
        val observable = RetrofitClient.getInstance.create(
            ApiInterface::class.java).getZoo("resourceAquire","5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> response.result.results.forEach { results ->
                    list.add(results)
                    liveData.value = list } },
                { Timber.i("error = $it") }
            ).let { compositeDisposable.add(it) }

        return liveData
    }

}


