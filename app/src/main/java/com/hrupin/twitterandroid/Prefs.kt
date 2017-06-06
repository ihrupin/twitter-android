package com.hrupin.twitterandroid

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Igor Khrupin www.hrupin.com on 6/4/17.
 */

class Prefs {

    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    private constructor(context: Context) {
        preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    companion object {
        private var instance : Prefs? = null

        fun with(context: Context): Prefs {
            if (instance == null) {
                instance = Prefs(context)
            }
            return instance!!
        }
    }
}