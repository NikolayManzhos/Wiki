package uk.co.ribot.androidboilerplate.data.model.random;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 12.08.2017.
 */

public class Query {

    @SerializedName("random")
    public List<Random> random = null;

}
