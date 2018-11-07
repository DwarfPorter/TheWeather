package ru.geekbrains.theweather;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != ChooseActivity) return;
        if (resultCode != RESULT_OK) return;
        if (data == null) return;

        TextView txtCity = findViewById(R.id.textCity);
        txtCity.setText(data.getStringExtra("RESULT"));
    }
}
