package com.riski.wonderfulpolinela;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.system.Os;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.kml.KmlDocument;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.BoundingBox;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.FolderOverlay;
import org.osmdroid.views.overlay.Marker;

public class LocationActivity extends AppCompatActivity {
    private MapView         map;
    private MapController mapController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //handle permissions first, before map is created. not depicted here


        //load/initialize the osmdroid configuration, this can be done
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string

        //inflate and create the map

        setContentView(R.layout.activity_location);



//        Drawable marker=getResources().getDrawable(R.drawable.pin_for_map);
//        int markerWidth = marker.getIntrinsicWidth();
//        int markerHeight = marker.getIntrinsicHeight();
//        marker.setBounds(0, markerHeight, markerWidth, 0);

        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);
        mapController = (MapController) map.getController();
        mapController.setZoom(15);
        GeoPoint startPoint = new GeoPoint(-5.35841, 105.23275);
        mapController.setCenter(startPoint);

        Marker marker = new Marker(map);
        marker.setPosition(new GeoPoint(-5.35841, 105.23275));
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
//        Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.pin_for_map, null);
//        Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
//        Drawable dr = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, (int) (48.0f * getResources().getDisplayMetrics().density), (int) (48.0f * getResources().getDisplayMetrics().density), true));
        Drawable currentDraw = ResourcesCompat.getDrawable(getResources(), R.drawable.pin_for_map, null);
        marker.setIcon(currentDraw);
        map.getOverlays().add(marker);
        map.invalidate();
//
//        Marker marker = new Marker(map);
//        marker.setPosition();
//        Drawable currentDraw = ResourcesCompat.getDrawable(getResources(), R.drawable.pin_for_map, null);
//        marker.setIcon(currentDraw);
    }
}