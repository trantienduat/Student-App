package com.duatson.studentapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListAdapter extends ArrayAdapter{
    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] infoArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam) {
        super(context, R.layout.list_item , nameArrayParam);

        this.context = context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null,true);

        //this code gets references to objects in the list_item.xml file
        TextView tvListPrimaryText = rowView.findViewById(R.id.tvListPrimaryText);
        TextView tvListSecondaryText = rowView.findViewById(R.id.tvListSecondaryText);
        ImageView listPrimaryAction = rowView.findViewById(R.id.listPrimaryAction);

        //this code sets the values of the objects to values from the arrays
        tvListPrimaryText.setText(nameArray[position]);
        tvListSecondaryText.setText(infoArray[position]);
        listPrimaryAction.setImageResource(imageIDarray[position]);

        return rowView;
    };
}
