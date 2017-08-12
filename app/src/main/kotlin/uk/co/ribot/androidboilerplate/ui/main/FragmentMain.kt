package uk.co.ribot.androidboilerplate.ui.main

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
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import javax.inject.Inject

class FragmentMain: Fragment(), MainContract.View {

    @Inject lateinit var presenter: MainPresenter

    @BindView(R.id.fromPage) lateinit var fromPage: TextView
    @BindView(R.id.toPage) lateinit var toPage: TextView
    @BindView(R.id.playFab) lateinit var playFab: FloatingActionButton

    private lateinit var unbinder:Unbinder

    private var randomResponse = RandomResponse()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_main, container, false) as View
        unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        (activity as MainActivity).activityComponent.inject(this)
        presenter.attachView(this)
        presenter.loadRandomArticles()
        playFab.setOnClickListener {
            (activity as MainActivity).onPlayClick(randomResponse)
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
}