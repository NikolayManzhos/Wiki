package uk.co.ribot.androidboilerplate.data

import rx.Single
import timber.log.Timber
import uk.co.ribot.androidboilerplate.data.model.WikiPage
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import uk.co.ribot.androidboilerplate.data.remote.WikiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val wikiService: WikiService) {

    fun getWiki(pageName: String): Single<WikiPage> {
        Timber.e("Page name $pageName")
        return wikiService.getWiki(pageName)
                .doOnEach { Timber.e(it.toString()) }
                .map { WikiPage(it) }
    }

    fun getRandom() : Single<RandomResponse> = wikiService.getRandom()

}
