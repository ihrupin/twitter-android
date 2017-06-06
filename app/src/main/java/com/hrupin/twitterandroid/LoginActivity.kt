package com.hrupin.twitterandroid

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import butterknife.bindView
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.TwitterSession

import com.hrupin.twitterandroid.R
import android.content.pm.PackageInfo
import android.net.Uri
import android.view.View
import android.widget.Button


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    val loginButton: TwitterLoginButton by bindView(R.id.loginButton)
    val bInstallTwitter : Button by bindView(R.id.bInstallTwitter)
    val TAG : String = "SplashActivity"
    val TWITTER_PACKAGE_NAME : String = "com.twitter.android"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        bInstallTwitter.setOnClickListener(this)

        loginButton.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                startMainActivity()
            }

            override fun failure(exception: TwitterException) {
                Toast.makeText(this@LoginActivity, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(v: View?) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + TWITTER_PACKAGE_NAME)))
        } catch (anfe: android.content.ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + TWITTER_PACKAGE_NAME)))
        }
    }

    override fun onResume() {
        super.onResume()
        checkForTwitter()
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,  arrayOf(Manifest.permission.INTERNET), 100)
        }else{
            loginButton.visibility = View.VISIBLE
        }
    }

    private fun checkForTwitter() {
        try {
            val pkgInfo = packageManager.getPackageInfo(TWITTER_PACKAGE_NAME, 0)
            val getPkgInfo = pkgInfo.toString()
            if (getPkgInfo == TWITTER_PACKAGE_NAME) {
                bInstallTwitter.visibility = View.GONE
                checkPermissions()
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            loginButton.visibility = View.GONE
            bInstallTwitter.visibility = View.VISIBLE
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            100 -> {
                if (grantResults.size > 0 && grantResults[0] === PackageManager.PERMISSION_GRANTED) {
                    loginButton.visibility = View.VISIBLE
                } else {
                    Toast.makeText(this@LoginActivity, getString(R.string.please_grand_internet), Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    fun startMainActivity(){
        val intent : Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginButton.onActivityResult(requestCode, resultCode, data)
    }
}
