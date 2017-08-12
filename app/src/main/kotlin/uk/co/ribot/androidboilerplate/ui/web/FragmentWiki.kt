package uk.co.ribot.androidboilerplate.ui.web

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.App
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import uk.co.ribot.androidboilerplate.util.WikiWebViewClient
import javax.inject.Inject


class FragmentWiki : Fragment(), WikiContract.View {
    @Inject
    lateinit var presenter: WikiPresenter

    private lateinit var urlSource: String

    private lateinit var urlDest: String
    @BindView(R.id.web_wiki)
    lateinit var webViewWiki: WebView

    @BindView(R.id.text_clicks)
    lateinit var textClicks: TextView

    companion object {

        private val ARG_SOURCE_URL = "source_url"

        fun newInstance(randomResponse: RandomResponse): FragmentWiki {
            val fragment = FragmentWiki()
            val args = Bundle()
            args.putString(ARG_SOURCE_URL, randomResponse.query.random[0].title)
            args.putString(ARG_DEST_URL, randomResponse.query.random[1].title)
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            urlSource = arguments.getString(ARG_SOURCE_URL)
            urlDest = arguments.getString(ARG_DEST_URL)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_web, container, false)
        ButterKnife.bind(this, view)
        App.plusWiki().inject(this)
        presenter.attachView(this)
        presenter.init(urlSource, urlDest)
        val wikiWebViewClient = WikiWebViewClient()
        wikiWebViewClient.setOnUrlClickListener(presenter::onUrlSelected)
        webViewWiki.webViewClient = wikiWebViewClient
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        App.clearWiki()
    }

    override fun showClicks(i: Int) {
        textClicks.text = "$i clicks"
    }

    override fun onWin() {
        Toast.makeText(this.context, "You won!", Toast.LENGTH_LONG).show()
    }

    override fun loadUrl(url: String) {
        webViewWiki.loadUrl(url)
    }

    override fun showError() {
        Toast.makeText(this.context, "Error", Toast.LENGTH_LONG).show()
    }

}
