package uk.co.ribot.androidboilerplate.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import uk.co.ribot.androidboilerplate.data.DataManager
import uk.co.ribot.androidboilerplate.injection.ApplicationContext
import uk.co.ribot.androidboilerplate.injection.module.ApplicationModule
import uk.co.ribot.androidboilerplate.injection.module.DataModule
import uk.co.ribot.androidboilerplate.injection.module.WikiModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class))
interface ApplicationComponent {
    fun plus(wikiModule: WikiModule): WikiSubcomponent
    @ApplicationContext fun context(): Context
    fun application(): Application
    fun dataManager(): DataManager
}
