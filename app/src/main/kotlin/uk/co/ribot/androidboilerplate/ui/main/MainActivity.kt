package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity
import uk.co.ribot.androidboilerplate.ui.web.FragmentWiki

class MainActivity : BaseActivity(), OnPlayClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contentFrame, FragmentMain())
                    .commit()
        }
    }

    override fun onPlayClick(randomResponse: RandomResponse) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, FragmentWiki.newInstance(randomResponse))
                .addToBackStack(null)
                .commit()
    }
}
