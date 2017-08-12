package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject lateinit var presenter: MainPresenter

    @BindView(R.id.toolbar) lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)

        presenter.attachView(this)
        presenter.loadRibots()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showEmpty() {
    }

    override fun showError() {
        Toast.makeText(this, R.string.error_loading, Toast.LENGTH_LONG).show()
    }
}
