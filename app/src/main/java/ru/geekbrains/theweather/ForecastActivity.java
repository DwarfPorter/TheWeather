package ru.geekbrains.theweather;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ValueFragment todayFragment = ValueFragment.newInstance(new Parcel(15, 780, 50));
        ValueFragment tomorrowFragment = ValueFragment.newInstance(new Parcel(18, 770, 60));
        ValueFragment afterTomorrowFragment = ValueFragment.newInstance(new Parcel(14, 750, 70));

        fragmentTransaction.add(R.id.frameToday, todayFragment);
        fragmentTransaction.add(R.id.frameTomorrow, tomorrowFragment);
        fragmentTransaction.add(R.id.frameAfterTomorrow, afterTomorrowFragment);

        fragmentTransaction.commit();
    }
}
