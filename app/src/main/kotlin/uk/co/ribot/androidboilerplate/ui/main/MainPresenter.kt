package uk.co.ribot.androidboilerplate.ui.main

import rx.Subscription
import uk.co.ribot.androidboilerplate.data.DataManager
import uk.co.ribot.androidboilerplate.injection.ConfigPersistent
import javax.inject.Inject

@ConfigPersistent
class MainPresenter
@Inject
constructor(private val dataManager: DataManager) : MainContract.Presenter() {

    private var subscription: Subscription? = null

    override fun detachView() {
        super.detachView()
        subscription?.unsubscribe()
    }

    override fun loadRibots() {
    }
}
