package ru.geekbrains.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ChooserCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chooser_city);
        RecyclerView recyclerView = findViewById(R.id.chooserCity);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ChooserCityAdapter adapter = new ChooserCityAdapter(getResources().getStringArray(R.array.cities));
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new ChooserCityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String cityName) {
                Intent intentResult = new Intent();
                intentResult.putExtra("RESULT", cityName);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
}
