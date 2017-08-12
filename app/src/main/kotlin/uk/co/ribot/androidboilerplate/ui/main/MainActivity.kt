package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import android.widget.Toast
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        presenter.attachView(this)
        presenter.loadRibots()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contentFrame, FragmentMain())
                    .commit()
        }

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
