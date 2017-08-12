package uk.co.ribot.androidboilerplate.injection.component


import dagger.Subcomponent
import uk.co.ribot.androidboilerplate.injection.PerFragment
import uk.co.ribot.androidboilerplate.injection.module.WikiModule
import uk.co.ribot.androidboilerplate.ui.web.FragmentWiki


/**
 * Created by Vladimir Kondenko on 12.08.17.
 */

@PerFragment
@Subcomponent(modules = arrayOf(WikiModule::class))
interface WikiSubcomponent {
    fun inject(fragment: FragmentWiki)
}