package com.uum.covid_19_uum;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uum.covid_19_uum.model.RiwayatModel;
import com.uum.covid_19_uum.view.RiwayatViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_riwayat extends Fragment {

    private history_item_holder adapter;
    private ProgressDialog mProgressApp;

    public fragment_riwayat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_riwayat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressApp = new ProgressDialog(getActivity());
        mProgressApp.setTitle("Mohon tunggu");
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage("Sedang menampilkan data...");

        RecyclerView recyclerView = view.findViewById(R.id.listRecycler);
        adapter = new history_item_holder(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
     //   loadListData();
    }

    private void loadListData() {
        RiwayatViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(RiwayatViewModel.class);
        viewModel.setTodayData();
        mProgressApp.show();
        viewModel.getTodayListData().observe(getViewLifecycleOwner(), new Observer<ArrayList<RiwayatModel>>() {
            @Override
            public void onChanged(ArrayList<RiwayatModel> riwayatModels) {
                adapter.setRiwayatModels(riwayatModels);
                mProgressApp.dismiss();
            }
        });
    }
}