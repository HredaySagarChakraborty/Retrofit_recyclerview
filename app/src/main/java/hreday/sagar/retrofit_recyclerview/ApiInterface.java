package hreday.sagar.retrofit_recyclerview;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
//import retrofit2.http.GET;

public interface ApiInterface {

    @GET("feeds/flowers.json")
    Call<List<PojoClas>> getName();
    //Log.d("Creation","Here are the errors");
}
