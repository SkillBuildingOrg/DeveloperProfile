package com.rohit.kotlin.developerprofile.ui.fragments


import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rohit.kotlin.developerprofile.R
import me.saket.bettermovementmethod.BetterLinkMovementMethod

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    override fun onStart() {
        super.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BetterLinkMovementMethod.linkify(Linkify.ALL, view as ViewGroup)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }
}
