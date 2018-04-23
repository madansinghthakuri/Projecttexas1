package com.example.ironman.projecttexas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ironman.projecttexas.Service.Api;
import com.example.ironman.projecttexas.Service.ApiClient;
import com.example.ironman.projecttexas.model.UserListDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome extends AppCompatActivity {
//    text project



    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecycleAdapter recycleAdapter;
    private List<UserListDto> userListDto;
    private Api api;



    public Welcome() {
    }
//    Toolbar toolbar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//        toolbar = (Toolbar)findViewById(R.id.toolbar);
        /*for toolbar*/
//        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        api = ApiClient.getApiClient().create(Api.class);

        Call<List<UserListDto>> call = api.getUsers(1, 1, 1,1,1,"1");
        call.enqueue(new Callback<List<UserListDto>>() {
            @Override
            public void onResponse(Call<List<UserListDto>> call, Response<List<UserListDto>> response) {
               userListDto = response.body();
               recycleAdapter = new RecycleAdapter(userListDto);
               recyclerView.setAdapter(recycleAdapter);

            }

            @Override
            public void onFailure(retrofit2.Call<List<UserListDto>> call, Throwable t) {

            }
        });


}

}
