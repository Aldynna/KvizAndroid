package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ONamaActivity extends FragmentActivity implements OnMapReadyCallback {

    private Button mPlusButton;
    private Button mMinusButton;
    private Button mNazad;
    private GoogleMap mMap;
    private String mJezik;
    private TextView mONama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onama);
        Intent nadjijezik=getIntent();
        mJezik=nadjijezik.getStringExtra("jezik");
        mNazad  = (Button) findViewById(R.id.nazad);
        mONama = (TextView) findViewById(R.id.textView);
        if(mJezik.equals("eng")) {
            mONama.setText(R.string.aboutus);
            mNazad.setText("BACK");
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mPlusButton  = (Button) findViewById(R.id.plus_button);
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });
        mPlusButton  = (Button) findViewById(R.id.minus_button);
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

        mNazad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent nazad = new Intent(ONamaActivity.this, MeniActivity.class);
                startActivity(nazad);
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sarajevo and move the camera
        LatLng sarajevo = new LatLng(43.8539966, 18.3940913);
        mMap.addMarker(new MarkerOptions().position(sarajevo).title("Marker in Sarajevo"));
        float zoomLevel = (float) 17.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sarajevo, zoomLevel));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

}
