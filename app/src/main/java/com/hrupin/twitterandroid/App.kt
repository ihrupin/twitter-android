package com.hrupin.twitterandroid

import android.app.Application
import com.twitter.sdk.android.core.Twitter

/**
 * Created by Igor Khrupin www.hrupin.com on 6/5/17.
 */
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        Twitter.initialize(this)
    }
}