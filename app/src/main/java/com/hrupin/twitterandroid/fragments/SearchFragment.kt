package com.hrupin.twitterandroid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hrupin.twitterandroid.R

/**
 * Created by Igor Khrupin www.hrupin.com on 6/4/17.
 */

class SearchFragment : android.support.v4.app.Fragment() {


    companion object {
        fun newInstance(): SearchFragment {
            val newsFragment = SearchFragment()
            return newsFragment
        }

        val FRAGMENT_TAG: String = "SearchFragment"
    }

    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): android.view.View? {
        val v = inflater!!.inflate(R.layout.fragment_search, container, false)
        return v
    }

}
