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

class FavoritesFragment : Fragment() {

    companion object {
        fun newInstance(): FavoritesFragment {
            val newsFragment = FavoritesFragment()
            return newsFragment
        }

        val FRAGMENT_TAG: String = "FavoritesFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_favorites, container, false)
        return v
    }
}