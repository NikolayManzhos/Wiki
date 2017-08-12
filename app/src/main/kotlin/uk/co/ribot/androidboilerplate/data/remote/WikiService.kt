package uk.co.ribot.androidboilerplate.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

/**
 * Created on 12.08.2017.
 */
interface WikiService {

    @GET("wiki/{pageName}")
    fun getWiki(@Path("pageName") pageName: String): Single<ResponseBody>

}