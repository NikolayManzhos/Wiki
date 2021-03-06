package uk.co.ribot.androidboilerplate.ui.main

import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import uk.co.ribot.androidboilerplate.ui.base.BasePresenter
import uk.co.ribot.androidboilerplate.ui.base.MvpView

object MainContract {

    interface View: MvpView {
        fun showArticles(randomResponse: RandomResponse)
        fun showEmpty()
        fun showError()
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun loadRandomArticles()
    }
}
