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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * EarthquakeAdapter is an ArrayAdapter that can provide the layout for the list based on a data source, which is a list of Earthquake objects.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    String primaryLocation;
    String locationOffset;

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
        //Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        //Display the magnitude of the current earthquake in that TextView.
        magnitudeTextView.setText(formattedMagnitude);

        //Get the String of Location from currentEarthquake Object
        String locationString = currentEarthquake.getLocation();

        //Test beforehand if the string contains "of"
        if (locationString.contains(LOCATION_SEPARATOR)) {
            String[] parts = locationString.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = locationString;
        }

        //Find the TextView in the list_item.xml layout with the ID location_offset
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        //Get the rest location (part 1) from the current Earthquake object and set this text on the restLocation Textview.
        locationOffsetTextView.setText(locationOffset);

        //Find the TextView in the list_item.xml layout with the ID primary_location
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        //Get the rest location (part 1) from the current Earthquake object and set this text on the restLocation Textview.
        primaryLocationTextView.setText(primaryLocation);

        //Create a new Date Object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        //Find the TextView in the list_item.xml layout with the ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        //Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        //Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        //Find the TextView in the list_item.xml layout with the ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        //Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        //Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        //Return the whole list item layout (containing 3 TextViews)
        //so that it can be shown in the listView
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Rerurn the formatted magnitude string shoing 1 decimal place (i.e."3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
