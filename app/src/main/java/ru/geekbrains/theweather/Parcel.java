package ru.geekbrains.theweather;

import java.io.Serializable;

public class Parcel implements Serializable {
    private int temperature;
    private int pressure;
    private int humidity;

    public Parcel(int temperature, int pressure, int humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

}
