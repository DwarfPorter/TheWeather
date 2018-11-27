package ru.geekbrains.theweather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ValueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ValueFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARCEL = "parcel";

    // TODO: Rename and change types of parameters
    private int temperature;
    private int pressure;
    private int humidity;

    public ValueFragment() {
        // Required empty public constructor
    }

    public static ValueFragment newInstance(Parcel parcel) {
        ValueFragment fragment = new ValueFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcel parcel = (Parcel) getArguments().getSerializable(ARG_PARCEL);
            temperature = parcel.getTemperature();
            pressure = parcel.getPressure();
            humidity = parcel.getHumidity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_value, container, false);

        TextView textTemp = layout.findViewById(R.id.textValueTemperature);
        textTemp.setText(Integer.toString(temperature));
        TextView textPress = layout.findViewById(R.id.textValuePreassure);
        textPress.setText(Integer.toString(pressure));
        TextView textHum = layout.findViewById(R.id.textValueHumidity);
        textHum.setText(Integer.toString(humidity));

        return layout;
    }

}
