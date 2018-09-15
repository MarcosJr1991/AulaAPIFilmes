package marcosjr.com.apidefilmes.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import marcosjr.com.apidefilmes.ViewAdapter.AdapterRecyclerview;
import marcosjr.com.apidefilmes.ViewAdapter.ViewPagerAdapter;
import retrofit2.Call;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import marcosjr.com.apidefilmes.API.RetrofitConfig;
import marcosjr.com.apidefilmes.API.Service;
import marcosjr.com.apidefilmes.Model.Pojo;
import marcosjr.com.apidefilmes.Model.Result;
import marcosjr.com.apidefilmes.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentNowPlaying extends Fragment{

   View view;
   public String API_kEY = "954ba9004c6997d2d3be827169189186";
   public String Language = "pt-Br";
   public String category = "now_playing";
   public String region = "BR";
   public int page = 1;
   public List<Result>resultList;


    public FragmentNowPlaying() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.lista1_fragment,container,false);
        Service service = RetrofitConfig.getRetrofit().create(Service.class);
        Call<Pojo> call = service.getMovies(category,API_kEY,Language,page,region);

        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, @NonNull Response<Pojo> response) {

                    resultList = response.body().getResults();
                    RecyclerView recyclerView = view.findViewById(R.id.recycler);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                    AdapterRecyclerview adapterRecyclerview = new AdapterRecyclerview(resultList,view.getContext());
                    recyclerView.setAdapter(adapterRecyclerview);
                    recyclerView.setLayoutManager(layoutManager);


            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {

            }
        });

        return view;
    }
}
