package com.hrupin.twitterandroid

import android.os.Bundle
import android.os.Handler
import android.os.Looper

import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.bindView
import com.twitter.sdk.android.core.identity.TwitterLoginButton


class SplashActivity : AppCompatActivity() {

    val loginButton: TwitterLoginButton by bindView(R.id.loginButton)
    val tvHello: TextView by bindView(R.id.tvHello)

    val TAG : String = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler : Handler = Handler(Looper.getMainLooper())
        handler.postDelayed({ checkForToken() }, 1000)
    }

    private fun checkForToken() {
        if (Prefs.with(this).isLoggedIn()){

        }else{

        }
    }
}
