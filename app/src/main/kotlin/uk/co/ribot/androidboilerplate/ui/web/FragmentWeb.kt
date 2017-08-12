package uk.co.ribot.androidboilerplate.ui.web

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uk.co.ribot.androidboilerplate.R

class FragmentWeb : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_web, container, false)
    }
}