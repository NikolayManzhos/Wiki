package uk.co.ribot.androidboilerplate.data

import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import uk.co.ribot.androidboilerplate.data.model.WikiPage
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import uk.co.ribot.androidboilerplate.data.remote.RandomService
import uk.co.ribot.androidboilerplate.data.remote.WikiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val wikiService: WikiService, private val randomService: RandomService) {

    fun getWiki(pageName: String): Single<WikiPage> {
        Timber.e("Page name $pageName")
        return wikiService.getWiki(pageName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach { Timber.e(it.toString()) }
                .map { it.string() }
                .map { WikiPage(it) }
    }

    fun getRandom() : Single<RandomResponse> = randomService.getRandom()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}
