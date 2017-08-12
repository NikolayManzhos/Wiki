package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity
import uk.co.ribot.androidboilerplate.ui.web.FragmentWiki

class MainActivity : BaseActivity() {
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        val from = "https://ru.m.wikipedia.org/wiki/%D0%90%D0%BF%D0%BF%D0%B8%D0%B9_%D0%9A%D0%BB%D0%B0%D0%B2%D0%B4%D0%B8%D0%B9_%D0%A6%D0%B5%D0%BA"
        val to = "https://ru.m.wikipedia.org/wiki/%D0%AF%D0%B7%D1%8B%D0%BA"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
//                    .replace(R.id.contentFrame, FragmentMain())
                    .replace(R.id.contentFrame, FragmentWiki.newInstance(from, to))
                    .commit()
        }
    }

}
