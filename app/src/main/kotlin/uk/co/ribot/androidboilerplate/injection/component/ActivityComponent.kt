package uk.co.ribot.androidboilerplate.injection.component

import dagger.Subcomponent
import uk.co.ribot.androidboilerplate.injection.PerActivity
import uk.co.ribot.androidboilerplate.injection.module.ActivityModule
import uk.co.ribot.androidboilerplate.ui.main.FragmentMain

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainFragment: FragmentMain)
}
