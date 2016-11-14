package com.example.android.quakereport;

/**
 * Created by jane on 11/14/16.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * EarthquakeAdapter is an ArrayAdapter that can provide the layout for the list based on a data source, which is a list of Earthquake objects.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * This is my own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data I want to populate into the list.
     *
     * @param context    The current context. Used to inflate the layout file.
     * @param earthquake A list of Earthquake objects to display in a list.
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }

    /**
     * Provices a view for an AdapterView(ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check is the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the Earthquake object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);

        //Get the magnitude from the current Earthquake object and set this text on the magnitude Textview.
        magnitudeTextView.setText(currentEarthquake.getMagnitude());

        //Find the TextView in the list_item.xml layout with the ID location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);

        //Get the magnitude from the current Earthquake object and set this text on the magnitude Textview.
        locationTextView.setText(currentEarthquake.getLocation());

        //Find the TextView in the list_item.xml layout with the ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        //Get the magnitude from the current Earthquake object and set this text on the magnitude Textview.
        dateTextView.setText(currentEarthquake.getDate());

        //Return the whole list item layout (containing 3 TextViews)
        //so that it can be shown in the listView
        return listItemView;
    }
}
