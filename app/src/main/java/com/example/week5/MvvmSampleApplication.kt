package com.example.week5

import android.app.Application
import com.example.week5.network.ServiceConnector

class MvvmSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()
    }
}