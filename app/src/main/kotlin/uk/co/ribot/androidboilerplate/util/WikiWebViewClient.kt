package uk.co.ribot.androidboilerplate.util

import android.webkit.WebView
import android.webkit.WebViewClient


/**
 * Created by Vladimir Kondenko on 12.08.17.
 */
class WikiWebViewClient : WebViewClient() {

    var urlClickListener: ((String) -> Unit)? = null

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if (url != null) urlClickListener?.invoke(url.trim())
        return false
    }

/*
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            request?.url.apply {
                urlClickListener?.invoke(this.toString())
            }
        }
        return false
    }
*/

    fun setOnUrlClickListener(listener: (String) -> Unit) {
        urlClickListener = listener
    }

}