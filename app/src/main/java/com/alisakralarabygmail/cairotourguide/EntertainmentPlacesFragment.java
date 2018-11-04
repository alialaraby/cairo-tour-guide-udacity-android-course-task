package com.alisakralarabygmail.cairotourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentPlacesFragment extends Fragment {

    private ArrayList<CustomItemClass> list = new ArrayList<>();
    private CustomAdapterClass customAdapterClass;
    public EntertainmentPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_entertainment_places, container, false);

        list.add(new CustomItemClass("City Stars Cinema", R.drawable.city_stars_cinema, 30.0725, 31.3464));
        list.add(new CustomItemClass("Galaxy Cinema", R.drawable.galaxy_cinema, 30.0179, 31.2228));
        list.add(new CustomItemClass("Sun City Cinema", R.drawable.sun_city_cinema, 30.1028, 31.3867));
        list.add(new CustomItemClass("i Max Cinema", R.drawable.imax_cinema, 0, 0));
        list.add(new CustomItemClass("Dream Park", R.drawable.dream_park, 0, 0));
        list.add(new CustomItemClass("Fagnoon Village", R.drawable.fagnoon_village, 0, 0));
        list.add(new CustomItemClass("Skate Max", R.drawable.skate_max, 29.9628, 30.9269));
        list.add(new CustomItemClass("Adrenalin Park", R.drawable.adrenalin_park, 0, 0));
        list.add(new CustomItemClass("Kidzanya", R.drawable.kidzanya, 0, 0));
        list.add(new CustomItemClass("The National Theatre", R.drawable.national_theatre, 0, 0));
        list.add(new CustomItemClass("The Floating Theatre", R.drawable.floating_theatre, 0, 0));

        ListView listView = (ListView) view.findViewById(R.id.entertainment_places_list_view);
        customAdapterClass = new CustomAdapterClass(getActivity(), list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomItemClass customItemClass = list.get(position);
                if (customItemClass.getLatitude() == 0){
                    Toast.makeText(getContext(), getString(R.string.missing_latitude_longtude), Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                            .setTitle(getString(R.string.dialog_title_location));
                    if (customItemClass.getImageUri() == R.drawable.imax_cinema){
                        builder.setMessage(getString(R.string.i_max_location));
                    }else if (customItemClass.getImageUri() == R.drawable.dream_park){
                        builder.setMessage(getString(R.string.dream_park_location));
                    }else if (customItemClass.getImageUri() == R.drawable.fagnoon_village){
                        builder.setMessage(getString(R.string.fagnoon_location));
                    }else if (customItemClass.getImageUri() == R.drawable.adrenalin_park){
                        builder.setMessage(getString(R.string.adrinaline_park_location));
                    }else if (customItemClass.getImageUri() == R.drawable.kidzanya){
                        builder.setMessage(getString(R.string.kidzania_location));
                    }else if (customItemClass.getImageUri() == R.drawable.national_theatre){
                        builder.setMessage(getString(R.string.national_theatre_location));
                    }else if (customItemClass.getImageUri() == R.drawable.floating_theatre){
                        builder.setMessage(getString(R.string.floating_location));
                    }
                    builder.show();
                }else {
                    Uri uri = Uri.parse("geo:" + customItemClass.getLatitude() + ","
                            + customItemClass.getLongtude() + "?z=18");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
        listView.setAdapter(customAdapterClass);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        list.clear();
        customAdapterClass.notifyDataSetChanged();
    }
}
