package uk.co.ribot.androidboilerplate.data

import rx.Single
import uk.co.ribot.androidboilerplate.data.model.WikiPage
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import uk.co.ribot.androidboilerplate.data.remote.WikiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val wikiService: WikiService) {

    fun getWiki(pageName: String): Single<WikiPage> = wikiService.getWiki(pageName).map { WikiPage(it) }

    fun getRandom() : Single<RandomResponse> = wikiService.getRandom()

}
