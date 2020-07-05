package com.uum.covid_19_uum.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uum.covid_19_uum.api.ApiEndPoint;
import com.uum.covid_19_uum.api.ApiService;
import com.uum.covid_19_uum.model.RingkasanModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RingkasanViewModel extends ViewModel {
    private MutableLiveData<RingkasanModel> mutableLiveData = new MutableLiveData<>();

    public void setSummaryWorldData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<RingkasanModel> call = apiEndpoint.getSummaryWorld();
        call.enqueue(new Callback<RingkasanModel>() {
            @Override
            public void onResponse(Call<RingkasanModel> call, Response<RingkasanModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RingkasanModel> call, Throwable t) {

            }
        });
    }

    public LiveData<RingkasanModel> getSummaryWorldData() { return mutableLiveData;

    }
}
