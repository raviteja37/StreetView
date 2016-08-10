package com.example.iwsuser6.streetview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Add some code

        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = (SupportStreetViewPanoramaFragment) getSupportFragmentManager().findFragmentById(R.id.streetview);

        supportStreetViewPanoramaFragment.getStreetViewPanoramaAsync(new OnStreetViewPanoramaReadyCallback() {
            @Override
            public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {


                if (savedInstanceState == null) {
                    streetViewPanorama.setPosition(SYDNEY);
                    //streetViewPanorama.setPanningGesturesEnabled(false);
                    streetViewPanorama.setUserNavigationEnabled(false);
                    streetViewPanorama.setStreetNamesEnabled(false);
                }
            }
        });
    }
}
