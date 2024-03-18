package com.omid.metro.api

import com.omid.metro.api.InitRetrofit.iService
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import com.omid.metro.model.models.Stations
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class WebServiceCaller {

    fun getLines(iListener: IListener<Lines>) {
        CompositeDisposable().apply {
            val disposable = iService.getLines()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ lines ->
                    iListener.onSuccess(lines)
                }, { error ->

                })
            this.add(disposable)
        }
    }

    suspend fun getStations(id: String): Stations? {
        iService.getStations(id).apply { return if (this.isSuccessful) this.body() else null }
    }
}