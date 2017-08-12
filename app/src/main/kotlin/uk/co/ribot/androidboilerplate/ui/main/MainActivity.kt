package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import android.widget.Toast
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.data.model.Ribot
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    companion object {
        val EXTRA_TRIGGER_SYNC_FLAG =
                "uk.co.ribot.androidboilerplate.ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG"
    }

    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var ribotsAdapter: RibotsAdapter


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
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showRibots(ribots: List<Ribot>) {
        ribotsAdapter.ribots = ribots
        ribotsAdapter.notifyDataSetChanged()
    }

    override fun showRibotsEmpty() {
        ribotsAdapter.ribots = emptyList()
        ribotsAdapter.notifyDataSetChanged()
        Toast.makeText(this, R.string.empty_ribots, Toast.LENGTH_LONG).show()
    }

    override fun showError() {
        Toast.makeText(this, R.string.error_loading_ribots, Toast.LENGTH_LONG).show()
    }
}
