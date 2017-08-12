package uk.co.ribot.androidboilerplate.ui.web

import rx.Subscription
import timber.log.Timber
import uk.co.ribot.androidboilerplate.injection.ConfigPersistent
import javax.inject.Inject

@ConfigPersistent
class WikiPresenter
@Inject
constructor() : WikiContract.Presenter() {

    private var subscription: Subscription? = null

    private lateinit var sourceUrl: String

    private lateinit var destUrl: String

    private var clicks = 0

    override fun detachView() {
        super.detachView()
        subscription?.unsubscribe()
    }

    override fun init(source: String, dest: String) {
        Timber.i("Initializing with source [$source] and destination [$dest]")
        sourceUrl = source
        destUrl = dest
        onUrlSelected(source)
    }

    override fun onUrlSelected(url: String) {
        Timber.i("Url click: $url")
        if (url != sourceUrl) {
            clicks++
            view.showClicks(clicks)
        }
        if (url == destUrl) view.onWin()
        view.loadUrl(url)
    }

}
