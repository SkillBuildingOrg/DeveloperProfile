package com.rohit.kotlin.developerprofile.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rohit.kotlin.developerprofile.R
import com.rohit.kotlin.developerprofile.models.summaryHtml
import com.rohit.kotlin.developerprofile.utils.HTMLUtils
import kotlinx.android.synthetic.main.fragment_about.view.*

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val summaryView = inflater.inflate(R.layout.fragment_about, container, false)
        HTMLUtils.loadHtmlText(summaryHtml, summaryView.experienceSummaryText)
        return summaryView
    }
}
