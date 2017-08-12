package uk.co.ribot.androidboilerplate

import android.app.Application
import android.support.annotation.VisibleForTesting
import timber.log.Timber
import uk.co.ribot.androidboilerplate.injection.component.ApplicationComponent
import uk.co.ribot.androidboilerplate.injection.component.DaggerApplicationComponent
import uk.co.ribot.androidboilerplate.injection.component.WikiSubcomponent
import uk.co.ribot.androidboilerplate.injection.module.ApplicationModule
import uk.co.ribot.androidboilerplate.injection.module.WikiModule

open class App : Application() {

    companion object {

        lateinit var applicationComponent: ApplicationComponent
            private set

        var wikiSubcomponent: WikiSubcomponent? = null
            private set

        fun plusWiki(): WikiSubcomponent {
            if (wikiSubcomponent == null) wikiSubcomponent = applicationComponent.plus(WikiModule())
            return wikiSubcomponent as WikiSubcomponent
        }

        fun clearWiki() {
            wikiSubcomponent = null
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initDaggerComponent()
    }

    @VisibleForTesting
    fun initDaggerComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }


}
