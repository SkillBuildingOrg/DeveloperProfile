package com.rohit.kotlin.developerprofile.ui.fragments


import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rohit.kotlin.developerprofile.R
import com.rohit.kotlin.developerprofile.models.educationHtml
import com.rohit.kotlin.developerprofile.models.mobile2winHtml
import com.rohit.kotlin.developerprofile.ui.activities.ProjectsActivity
import com.rohit.kotlin.developerprofile.utils.HTMLUtils.Companion.loadHtmlText
import kotlinx.android.synthetic.main.fragment_contact.view.*
import kotlinx.android.synthetic.main.layout_project_info.view.*
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
        val personalInfoView = inflater.inflate(R.layout.fragment_contact, container, false)
        loadHtmlText(educationHtml, personalInfoView.personalEducationData)
        return personalInfoView
    }
}
