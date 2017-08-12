package uk.co.ribot.androidboilerplate.data

import org.jsoup.Jsoup
import rx.Single
import uk.co.ribot.androidboilerplate.data.model.WikiPage
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * Created by Mishkun on 12.08.2017.
 */
class ParseInteractor @Inject constructor(private val dataManager: DataManager) {

    fun getParsed(query: String): Single<WikiPage> {
        return dataManager.getWiki(query)
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
        val pattern = Pattern.compile("[/]([\\s\\S]|[^/]+)\$", Pattern.CASE_INSENSITIVE)
        return pattern.matcher(url).replaceAll("")
    }


}
