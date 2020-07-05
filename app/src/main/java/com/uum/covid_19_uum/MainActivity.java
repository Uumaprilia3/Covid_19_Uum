package com.uum.covid_19_uum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextView tvToday;
    String hariIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            fragment_ringkasan ringkasanFragment = new fragment_ringkasan();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.flMain, ringkasanFragment)
                    .commit();
        }

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getToday();

    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d MMMM yyyy", date);
        String formatFix = hariIni + ", " + tanggal;
        tvToday.setText(formatFix);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navigation_ringkasan:
                fragment_ringkasan ringkasanFragment = new fragment_ringkasan();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, ringkasanFragment)
                        .commit();
                return true;

            case R.id.navigation_indonesia:
                fragment_country countryFragment = new fragment_country();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, countryFragment)
                        .commit();
                return true;

            case R.id.navigation_riwayat:
                fragment_riwayat riwayatFragment = new fragment_riwayat();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, riwayatFragment)
                        .commit();
                return true;
        }
        return false;
    }
}

