package ru.geekbrains.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int ChooseActivity = 869;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chooserCity = findViewById(R.id.buttonCity);
        chooserCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChooseCity = new Intent(getApplicationContext(), ChooserCityActivity.class);
                startActivityForResult(intentChooseCity, ChooseActivity);
            }
        });
    }
}
