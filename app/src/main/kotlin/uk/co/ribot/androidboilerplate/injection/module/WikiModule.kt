package uk.co.ribot.androidboilerplate.injection.module

import dagger.Module
import dagger.Provides
import uk.co.ribot.androidboilerplate.injection.PerFragment
import uk.co.ribot.androidboilerplate.ui.web.WikiPresenter


/**
 * Created by Vladimir Kondenko on 12.08.17.
 */
@Module
class WikiModule {

    @Provides
    @PerFragment
    fun provideWebPresenter() = WikiPresenter()

}