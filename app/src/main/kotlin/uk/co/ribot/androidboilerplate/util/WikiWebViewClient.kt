package uk.co.ribot.androidboilerplate.util

import android.webkit.WebView
import android.webkit.WebViewClient
import timber.log.Timber


/**
 * Created by Vladimir Kondenko on 12.08.17.
 */
class WikiWebViewClient : WebViewClient() {

    private var onUrlClick: ((String) -> Unit)? = null

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        url?.let {
            onUrlClick?.invoke(it)
            Timber.e("Url clicked - $it")
        }
        return false
    }

    fun setOnUrlClickListener(listener: (String) -> Unit) {
        onUrlClick = listener
    }
}