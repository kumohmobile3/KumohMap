package com.example.kumohmap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	GoogleMap mGoogleMap;
	LatLng loc = new LatLng(36.144425,128.393269);
	
	PolylineOptions rectOptions = new PolylineOptions()
	.add(new LatLng(36.144425, 128.393269))
	.add(new LatLng(36.136263, 128.39874))
	.add(new LatLng(36.136523, 128.401895))
	.add(new LatLng(36.13602, 128.407688))
	.color(Color.RED);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mGoogleMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1)).getMap();
		mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 15));
		mGoogleMap.addMarker(new MarkerOptions().position(loc)
				.title("IconTest").icon(BitmapDescriptorFactory
						.fromResource(R.drawable.kumohicon)));
		Polyline polyline = mGoogleMap.addPolyline(rectOptions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
