package uk.co.ribot.androidboilerplate.ui.web

import uk.co.ribot.androidboilerplate.ui.base.BasePresenter
import uk.co.ribot.androidboilerplate.ui.base.MvpView

object WikiContract {

    interface View : MvpView {
        fun showClicks(i: Int)
        fun loadUrl(url: String)
        fun showError()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun init(source: String, dest: String)
        abstract fun onUrlSelected(url: String)
    }
}
