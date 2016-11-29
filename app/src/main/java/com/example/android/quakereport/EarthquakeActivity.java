/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    /** URL for earthquake data from the USGS dataset */
    private static final String USGS_REQUEST_URL =
            "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Get the list of earthquakes form {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        /*
        Create an EarthquakeAdapter, whose date source is a list of Earthquake objects.
        The adapter knows how to create list items in the list.
         */
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        /*
        Find the ListView object in the view hierarchy of the Activity.
        There should be a ListView with the view ID called list, which is declared in earthquake_activity xml layout file.
         */
        ListView listView = (ListView) findViewById(R.id.list);

        /*
        Make the ListView use the EarthquakeAdapter we created above, so that the ListView will display list items for each earthquake in the list.
         */
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Find the current earthquake that was clicked on
                Earthquake currentEarthquake = adapter. getItem(position);
                //Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());
                //Create a new intent to view the earthquake URI
                Intent websiteIntenet = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                //Send the intent to launch a new activity
                startActivity(websiteIntenet);
            }
        });
    }
}
