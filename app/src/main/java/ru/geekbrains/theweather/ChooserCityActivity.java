package ru.geekbrains.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChooserCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser_city);

        setClickListenersOnText(R.id.txtMsk);
        setClickListenersOnText(R.id.txtSpb);
        setClickListenersOnText(R.id.txtNsb);
    }

    private void setClickListenersOnText(int id){
        TextView txt = findViewById(id);
        txt.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String city = ((TextView) v).getText().toString();
            Intent intentResult = new Intent();
            intentResult.putExtra("RESULT", city);
            setResult(RESULT_OK, intentResult);
            finish();
        }
    };
}
