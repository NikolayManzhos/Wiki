package uk.co.ribot.androidboilerplate.data

import org.jsoup.Jsoup
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import uk.co.ribot.androidboilerplate.data.model.WikiPage
import javax.inject.Inject

/**
 * Created by Mishkun on 12.08.2017.
 */
class ParseInteractor @Inject constructor(private val dataManager: DataManager) {

    fun getParsed(query: String): Single<WikiPage> {
        return dataManager.getWiki(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach { Timber.e(it.toString()) }
                .map { it.html }
                .map { Jsoup.parse(it) }
                .map { it.apply { this.getElementsByClass("header-container").remove() } }
                .map { it.apply { this.getElementsByClass("banner-container").remove() } }
                .map { it.apply { this.getElementsByClass("footer-element").remove() } }
                .map { it.apply { this.getElementsByClass("footer-content").remove() } }
                .map { it.apply { this.getElementsByClass("footer-places").remove() } }
                .map { it.apply { this.getElementsByClass("footer-places").remove() } }
                .map { it.apply { this.getElementById("page-actions").remove() } }
                .map { it.html() }
                .map { WikiPage(it) }
    }

    fun getTitleFromUrl(url: String): String {
        val title = Regex("[/]([\\s\\S]|[^/]+)\$").find(url)!!.value
        Timber.e("Parsing $url - $title")
        return title
    }

}
