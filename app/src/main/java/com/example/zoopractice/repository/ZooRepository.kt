package com.example.zoopractice.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.zoopractice.api.ApiInterface
import com.example.zoopractice.api.RetrofitClient
import com.example.zoopractice.model.Results
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ZooRepository {

    private val list = ArrayList<Results>()
    private val liveData = MutableLiveData<List<Results>>()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        liveData.value = list
    }

    fun getZooData(): MutableLiveData<List<Results>> {
        var observable = RetrofitClient.getInstance.create(ApiInterface::class.java).getZoo("resourceAquire","5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> response.result?.results?.forEach { results -> list.add(results)
                    liveData.value = list } },
                { Log.d("TAG", "error = $it") }
            ).let {
                compositeDisposable.add(it)
            }

        return liveData
    }
}


