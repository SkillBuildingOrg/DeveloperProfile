package com.rohit.kotlin.developerprofile.utils

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.util.TypedValue
import android.widget.TextView
import me.saket.bettermovementmethod.BetterLinkMovementMethod

class HTMLUtils {
    companion object {
        fun loadHtmlText(htmlString: String, textView: TextView) {
            @Suppress("DEPRECATION")
            val htmlSpannable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(htmlString, Html.FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(htmlString, null, LiTagHandler())
            }

            val spannableBuilder = SpannableStringBuilder(htmlSpannable)
            val bulletSpans = spannableBuilder.getSpans(0, spannableBuilder.length, BulletSpan::class.java)
            bulletSpans.forEach {
                val start = spannableBuilder.getSpanStart(it)
                val end = spannableBuilder.getSpanEnd(it)
                spannableBuilder.removeSpan(it)
                spannableBuilder.setSpan(
                        OptimizedBulletSpan(bulletPointRadius = dip(3, textView.resources), gapWidth = dip(8, textView.resources)),
                        start,
                        end,
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
            }
            textView.text = spannableBuilder
            BetterLinkMovementMethod.linkifyHtml(textView)
        }

        fun dip(dp: Int, resources: Resources): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()
        }
    }
}