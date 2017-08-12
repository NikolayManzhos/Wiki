package uk.co.ribot.androidboilerplate.data.remote

import retrofit2.http.GET
import rx.Single
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse

/**
 * Created on 12.08.2017.
 */
interface RandomService {

    @GET("w/api.php?action=query&format=json&list=random&rnnamespace=0&rnlimit=2")
    fun getRandom() : Single<RandomResponse>

}