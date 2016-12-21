package com.example.user.ki_word;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


        String[][] temp =MainActivity.result;

        LatLng sample;

        LatLng defaultmap = new LatLng(37.284324,127.044314);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultmap));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultmap,17));

        for(int i=0;i<temp.length;i++){

           // System.out.println("temp0 : "+temp[i][0]);
           // System.out.println("temp1 : "+temp[i][1]);

           double a = Double.parseDouble(temp[i][0]);
            double b = Double.parseDouble(temp[i][1]);
           // double a = 37.284324;
          //  double b = 127.044314;
            sample = new LatLng(a,b);
            String location = "pal";

            mMap.addMarker(new MarkerOptions().position(sample).title("Marker in "+ location));


            String state = temp[i][2];

            if(state.equals("EMPTY")){
                mMap.addMarker(new MarkerOptions().position(sample).icon(BitmapDescriptorFactory.defaultMarker(150)));
            }

        }

/*
        // Add a marker in Sydney and move the camera
        LatLng paldal = new LatLng(37.284324, 127.044314);
        mMap.addMarker(new MarkerOptions().position(paldal).title("Marker in paldal"));
        //mMap.addMarker(new MarkerOptions().position(paldal).icon(BitmapDescriptorFactory.defaultMarker(300)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paldal));




        LatLng sungho = new LatLng(37.282947, 127.045292);
        mMap.addMarker(new MarkerOptions().position(sungho).title("Marker in sungho"));
        mMap.addMarker(new MarkerOptions().position(sungho).icon(BitmapDescriptorFactory.defaultMarker(150)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sungho));

*/


    }





}
