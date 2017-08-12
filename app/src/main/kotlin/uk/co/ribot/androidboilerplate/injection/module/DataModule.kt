package uk.co.ribot.androidboilerplate.injection.module

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uk.co.ribot.androidboilerplate.data.remote.RandomService
import uk.co.ribot.androidboilerplate.data.remote.WikiService
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = arrayOf(ApiModule::class))
class DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("ribots", MODE_PRIVATE)
    }


    @Provides
    @Singleton
    fun provideWikiService(@Named("page") retrofit: Retrofit) : WikiService {
        return retrofit.create(WikiService::class.java)
    }
    @Provides
    @Singleton
    fun provideRandService(@Named("random") retrofit: Retrofit) : RandomService {
        return retrofit.create(RandomService::class.java)
    }

}
