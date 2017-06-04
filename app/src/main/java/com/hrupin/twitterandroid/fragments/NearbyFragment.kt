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
class NearbyFragment : android.support.v4.app.Fragment() {

    companion object {
        fun newInstance(): NearbyFragment {
            val newsFragment = NearbyFragment()
            return newsFragment
        }

        val FRAGMENT_TAG: String = "NearbyFragment"
    }

    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): android.view.View? {
        val v = inflater!!.inflate(R.layout.fragment_nearby, container, false)
        return v
    }
}