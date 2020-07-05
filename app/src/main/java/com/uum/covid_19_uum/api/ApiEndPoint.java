package com.uum.covid_19_uum.api;

import com.uum.covid_19_uum.model.CountryModel;
import com.uum.covid_19_uum.model.RingkasanModel;
import com.uum.covid_19_uum.model.RiwayatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();
}
