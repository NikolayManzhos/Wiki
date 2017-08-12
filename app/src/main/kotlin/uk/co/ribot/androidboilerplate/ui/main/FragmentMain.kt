package uk.co.ribot.androidboilerplate.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.data.model.random.Query
import uk.co.ribot.androidboilerplate.data.model.random.Random
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import javax.inject.Inject

class FragmentMain: Fragment(), MainContract.View {

    @Inject lateinit var presenter: MainPresenter

    @BindView(R.id.fromPage) lateinit var fromPage: TextView
    @BindView(R.id.toPage) lateinit var toPage: TextView
    @BindView(R.id.playFab) lateinit var playFab: FloatingActionButton
    @BindView(R.id.refreshFab) lateinit var refreshFab: FloatingActionButton

    private lateinit var unbinder:Unbinder

    private var randomResponse = RandomResponse()

    private var isFakeStart = true

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_main, container, false) as View
        unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        (activity as MainActivity).activityComponent.inject(this)
        presenter.attachView(this)
        if (isFakeStart) {
            isFakeStart = false
            showArticles(fakeStart())
        } else {
            presenter.loadRandomArticles()
        }
        playFab.setOnClickListener {
            (activity as MainActivity).onPlayClick(randomResponse)
        }
        refreshFab.setOnClickListener {
            presenter.loadRandomArticles()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
        presenter.detachView()
    }

    override fun showArticles(randomResponse: RandomResponse) {
        this.randomResponse = randomResponse
        fromPage.text = randomResponse.query.random[0].title
        toPage.text = randomResponse.query.random[1].title
    }

    override fun showEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun fakeStart(): RandomResponse {
        var fakeResponse = RandomResponse()
        fakeResponse.query = Query()
        fakeResponse.query.random = ArrayList<Random>()
        fakeResponse.query.random.add(Random())
        fakeResponse.query.random.add(Random())
        fakeResponse.query.random[0].title = "Яндекс"
        fakeResponse.query.random[0].id = "6880819"
        fakeResponse.query.random[1].title = "Наполеон_I"
        fakeResponse.query.random[1].id = "26555"
        return fakeResponse
    }
}