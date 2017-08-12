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
import uk.co.ribot.androidboilerplate.util.extension.replaceSpaces
import javax.inject.Inject


class FragmentWiki : Fragment(), WikiContract.View {

    @Inject
    lateinit var presenter: WikiPresenter

    private lateinit var sourceTitle: String

    private lateinit var destTitle: String
    @BindView(R.id.web_wiki)
    lateinit var webViewWiki: WebView

    @BindView(R.id.text_clicks)
    lateinit var textClicks: TextView

    companion object {

        private val ARG_RESPONCE_SOURCE_TITLE = "random_response_source_title"

        private val ARG_RESPONCE_DEST_TITLE = "random_response_dest_title"
        fun newInstance(randomResponse: RandomResponse): FragmentWiki {
            val fragment = FragmentWiki()
            val args = Bundle()
            args.putString(ARG_RESPONCE_SOURCE_TITLE, randomResponse.query.random[0].title)
            args.putString(ARG_RESPONCE_DEST_TITLE, randomResponse.query.random[1].title)
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            sourceTitle = arguments.getString(ARG_RESPONCE_SOURCE_TITLE).replaceSpaces()
            destTitle = arguments.getString(ARG_RESPONCE_DEST_TITLE).replaceSpaces()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_web, container, false)
        ButterKnife.bind(this, view)
        App.plusWiki().inject(this)
        presenter.attachView(this)
        presenter.init(sourceTitle, destTitle)
        val wikiWebViewClient = WikiWebViewClient()
        wikiWebViewClient.setOnUrlClickListener(presenter::onUrlSelected)
        webViewWiki.webViewClient = wikiWebViewClient
        return view
    }

    override fun onWin() {
        Toast.makeText(context, "You won!", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        App.clearWiki()
    }

    override fun loadUrl(url: String) {
        webViewWiki.loadUrl(url)
//        webViewWiki.loadUrl(title)
    }

    override fun showClicks(i: Int) {
        textClicks.text = "$i clicks"
    }

    override fun showError() {
    }

}
