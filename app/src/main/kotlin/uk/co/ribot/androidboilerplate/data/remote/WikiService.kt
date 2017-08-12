package uk.co.ribot.androidboilerplate.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse

/**
 * Created on 12.08.2017.
 */
interface WikiService {
    @GET("")
    fun getWiki(@Query("curid") pageId: kotlin.Int): Single<String>
    
    @GET("w/api.php?action=query&format=json&list=random&rnnamespace=0&rnlimit=2")
    fun getRandom() : Single<RandomResponse>
}