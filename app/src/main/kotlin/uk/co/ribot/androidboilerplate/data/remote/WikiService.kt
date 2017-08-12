package uk.co.ribot.androidboilerplate.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse

/**
 * Created on 12.08.2017.
 */
interface WikiService {
    @GET("wiki/{pageName}")
    fun getWiki(@Path("pageName") pageName: String): Single<String>

    @GET("/w/api.php?action=query&format=json&list=random&rnnamespace=0&rnlimit=1")
    fun getRandom() : Single<RandomResponse>
}