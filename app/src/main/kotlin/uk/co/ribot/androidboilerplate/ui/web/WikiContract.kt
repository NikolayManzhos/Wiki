package uk.co.ribot.androidboilerplate.ui.web

import uk.co.ribot.androidboilerplate.ui.base.BasePresenter
import uk.co.ribot.androidboilerplate.ui.base.MvpView

object WikiContract {

    interface View : MvpView {
        fun onWin()
        fun showClicks(i: Int)
        fun loadUrl(html: String)
        fun showError()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun init(source: String, dest: String)
        abstract fun onHtmlLoaded(url: String, title: String)
    }
}
