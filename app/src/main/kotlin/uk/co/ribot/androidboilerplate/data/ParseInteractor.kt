package uk.co.ribot.androidboilerplate.data

import rx.Single
import uk.co.ribot.androidboilerplate.data.model.WikiPage
import javax.inject.Inject

/**
 * Created by Mishkun on 12.08.2017.
 */
class ParseInteractor @Inject constructor(private val dataManager: DataManager) {
    fun getParsed(query: String): Single<WikiPage> {
        return dataManager.getWiki()
        //return Single.just(DummyData().data)
        //.map { Jsoup.parse(it.html) }
        //.map { Jsoup.parse(it) }
        //.map { it.select("header-container").remove()}
    }


}
