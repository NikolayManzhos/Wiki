package uk.co.ribot.androidboilerplate.data.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import rx.Completable
import rx.Single

/**
 * Created by Mishkun on 12.08.2017.
 */
const val HIGHSCORE_KEY: String = "HIGHSCORE"

class PrefsHelper(context: Context) {
    val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getHighscore(): Single<Int> = Single.fromCallable { sharedPreferences.getInt(HIGHSCORE_KEY, 0) }
    fun setHighscore(highscore: Int): Completable = Completable.fromAction { sharedPreferences.edit().putInt(HIGHSCORE_KEY, highscore).commit() }
}