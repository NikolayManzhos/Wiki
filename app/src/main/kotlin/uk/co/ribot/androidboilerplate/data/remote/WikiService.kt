package uk.co.ribot.androidboilerplate.data.remote

import retrofit2.http.GET
import rx.Single

/**
 * Created on 12.08.2017.
 */
interface WikiService {
    @GET("")
    fun getWiki(): Single<String>
}