package com.alisakralarabygmail.cairotourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ali on 8/21/2017.
 */

public class HistoricalPlacesFragment extends Fragment {

    private ArrayList<CustomItemClass> list = new ArrayList<>();
    private ListView listView;
    private CustomAdapterClass customAdapterClass;
    public HistoricalPlacesFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historical_places, container, false);

        list.add(new CustomItemClass("The Pyramids", R.drawable.the_pyramids, 29.9773, 31.1325));
        list.add(new CustomItemClass("The Azhar Masjed", R.drawable.azhar_masjid, 30.0457, 31.2627));
        list.add(new CustomItemClass("The Babylon Fortress", R.drawable.babylon_fortress, 30.0059, 31.2301));
        list.add(new CustomItemClass("The Baron Palace", R.drawable.baron_palace, 30.0867, 31.3303));
        list.add(new CustomItemClass("The Cairo Tower", R.drawable.cairo_tower, 30.0459, 31.2243));
        list.add(new CustomItemClass("The Coptic Museum", R.drawable.coptic_museum, 30.0060, 31.2302));
        list.add(new CustomItemClass("The Egyptian Museum", R.drawable.egyptian_museum, 30.0478, 31.2336));
        list.add(new CustomItemClass("Mohamed Ali Masjid", R.drawable.mohamed_ali_masjid, 30.0287, 31.2599));
        list.add(new CustomItemClass("The Opera House", R.drawable.opera_house, 30.0427, 31.2240));
        list.add(new CustomItemClass("The Pharaonic Village", R.drawable.pharaonic_village, 29.9973, 31.2152));

        listView = (ListView) view.findViewById(R.id.historical_places_list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomItemClass customItemClass = list.get(position);
                Uri uri = Uri.parse("geo:" + customItemClass.getLatitude() + ","
                        + customItemClass.getLongtude() + "?z=16");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
