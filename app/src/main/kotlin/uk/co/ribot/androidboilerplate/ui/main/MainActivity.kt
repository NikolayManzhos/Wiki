package uk.co.ribot.androidboilerplate.ui.main

import android.os.Bundle
import uk.co.ribot.androidboilerplate.R
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity
import uk.co.ribot.androidboilerplate.ui.web.FragmentWiki

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)
        val mockFrom = "https://ru.m.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%B8%D1%82%D0%B5%D1%82_%D1%81%D0%BE%D0%BB%D0%B8%D0%B4%D0%B0%D1%80%D0%BD%D0%BE%D1%81%D1%82%D0%B8_%D0%93%D0%94%D0%A0#/random"
        val mockTo = "https://ru.m.wikipedia.org/wiki/%D0%90%D0%BB%D0%BE%D1%8D"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FragmentWiki.newInstance(mockFrom, mockTo))
                    .commit()
        }
    }

}
