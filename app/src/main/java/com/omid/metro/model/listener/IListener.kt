package com.omid.metro.model.listener

interface IListener<T> {

    fun onSuccess(response: T)
}