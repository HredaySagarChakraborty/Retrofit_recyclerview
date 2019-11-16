package hreday.sagar.retrofit_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://services.hanselandpetal.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Log.d("Creation","Here are the errors");

            ApiInterface apiInterface = retrofit.create(ApiInterface.class);
            Call<List<PojoClas>> call = apiInterface.getName();
            call.enqueue(new Callback<List<PojoClas>>() {
                @Override
                public void onResponse(Call<List<PojoClas>> call, Response<List<PojoClas>> response) {
                    showIt(response.body());
                    Log.d("Creation","Here are the errors");
                }

                @Override
                public void onFailure(Call<List<PojoClas>> call, Throwable t) {

                }
            });
        }catch (Exception e){


        }


    }

    private void showIt(List<PojoClas> response) {

        Adapter adapter=new Adapter(getApplicationContext(),response);
        Log.d("Creation","Here are the errors");
        recyclerView.setAdapter(adapter);
        Log.d("Creation","Here are the errors");

    }
}