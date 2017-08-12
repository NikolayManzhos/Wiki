package uk.co.ribot.androidboilerplate.util

import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast


/**
 * Created by Vladimir Kondenko on 12.08.17.
 */
class WikiWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        Toast.makeText(view?.context, "$url clicked", Toast.LENGTH_LONG).show()
        return false
    }


    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Toast.makeText(view?.context, "${request?.url} clicked", Toast.LENGTH_LONG).show()
        }
        return false
    }
}