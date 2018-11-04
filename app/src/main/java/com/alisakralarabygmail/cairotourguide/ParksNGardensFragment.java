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
public class ParksNGardensFragment extends Fragment {

    private ArrayList<CustomItemClass> list = new ArrayList<>();
    private CustomAdapterClass customAdapterClass;
    public ParksNGardensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parks_ngardens, container, false);

        list.add(new CustomItemClass("Al-Azhar Park", R.drawable.azhar_park, 30.0410, 31.2653));
        list.add(new CustomItemClass("Al-Andalus Garden", R.drawable.andalus_garden, 0, 0));
        list.add(new CustomItemClass("Al-Asmak Garden", R.drawable.asmak_park, 0, 0));
        list.add(new CustomItemClass("Botanical Garden", R.drawable.botanical_garden, 0, 0));
        list.add(new CustomItemClass("Family Park", R.drawable.family_park, 0, 0));
        list.add(new CustomItemClass("International Garden", R.drawable.international_garden, 0, 0));
        list.add(new CustomItemClass("Japanese Garden", R.drawable.japanese_garden, 29.5056, 31.2025));

        ListView listView = (ListView) view.findViewById(R.id.parks_n_gardens_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomItemClass customItemClass = list.get(position);
                if (customItemClass.getLatitude() == 0){
                    Toast.makeText(getContext(), getString(R.string.missing_latitude_longtude), Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                            .setTitle(getString(R.string.dialog_title_location));
                    if (customItemClass.getImageUri() == R.drawable.andalus_garden){
                        builder.setMessage(R.string.andalus_park_location);
                    }else if (customItemClass.getImageUri() == R.drawable.asmak_park){
                        builder.setMessage(R.string.asmak_park_location);
                    }else if (customItemClass.getImageUri() == R.drawable.botanical_garden){
                        builder.setMessage(R.string.orman_botanical_park_location);
                    }else if (customItemClass.getImageUri() == R.drawable.family_park){
                        builder.setMessage(R.string.family_park_location);
                    }else if (customItemClass.getImageUri() == R.drawable.international_garden){
                        builder.setMessage(R.string.international_park_location);
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
        customAdapterClass = new CustomAdapterClass(getActivity(), list);
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
