package uk.co.ribot.androidboilerplate.ui.main

import uk.co.ribot.androidboilerplate.ui.base.BasePresenter
import uk.co.ribot.androidboilerplate.ui.base.MvpView

object MainContract {

    interface View: MvpView {
        fun showEmpty()
        fun showError()
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun loadRibots()
    }
}
