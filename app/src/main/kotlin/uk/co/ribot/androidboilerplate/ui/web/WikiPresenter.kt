package uk.co.ribot.androidboilerplate.ui.web

import rx.Subscription
import timber.log.Timber
import uk.co.ribot.androidboilerplate.data.ParseInteractor
import uk.co.ribot.androidboilerplate.injection.ConfigPersistent
import javax.inject.Inject

@ConfigPersistent
class WikiPresenter
@Inject
constructor(val interactor: ParseInteractor) : WikiContract.Presenter() {

    private var subscription: Subscription? = null

    private lateinit var sourceTitle: String

    private lateinit var destTitle: String

    private var clicks = 0

    override fun detachView() {
        super.detachView()
        subscription?.unsubscribe()
    }

    override fun init(source: String, dest: String) {
        Timber.i("Init($source, $dest)")
        sourceTitle = source
        destTitle = dest
        onUrlSelected("https://ru.m.wikipedia.org/wiki/$source")
    }

    fun onUrlSelected(url: String) {
        onHtmlLoaded(url, interactor.getTitleFromUrl(url))
    }

    override fun onHtmlLoaded(url: String, title: String) {
        if (title != sourceTitle) {
            clicks++
            view.showClicks(clicks)
        }
        if (title == destTitle) view.onWin()
        view.loadUrl(url)
    }

}
