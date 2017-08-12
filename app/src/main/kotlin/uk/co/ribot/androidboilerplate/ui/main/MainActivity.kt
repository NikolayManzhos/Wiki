package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity

class MainActivity : BaseActivity() {

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
}
