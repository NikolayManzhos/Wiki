package uk.co.ribot.androidboilerplate.data.model.random;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 12.08.2017.
 */

public class Random {

    @SerializedName("id")
    public int id;

    @SerializedName("ns")
    public int ns;

    @SerializedName("title")
    public String title;

}