package uk.co.ribot.androidboilerplate.util;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;


public class LoggingInterceptor implements Interceptor {

    private static final String TAG = "HTTP-Log";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response responce = chain.proceed(request);
        Timber.e(TAG, request.toString());
        Timber.e(TAG, responce.toString());
        return responce;
    }

}