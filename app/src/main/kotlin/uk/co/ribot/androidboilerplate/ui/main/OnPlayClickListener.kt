package uk.co.ribot.androidboilerplate.ui.main

import uk.co.ribot.androidboilerplate.data.model.random.RandomResponse

interface OnPlayClickListener {
    fun onPlayClick(randomResponse: RandomResponse)
}