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
public class ShoppingPlacesFragment extends Fragment {

    private ArrayList<CustomItemClass> list = new ArrayList<>();
    private CustomAdapterClass customAdapterClass;
    public ShoppingPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_places, container, false);

        list.add(new CustomItemClass("Mall Al-Arab", R.drawable.mall_al_arab, 0, 0));
        list.add(new CustomItemClass("City Stars Mall", R.drawable.city_stars_mall, 30.0730, 31.3460));
        list.add(new CustomItemClass("Cairo Festival City Mall", R.drawable.cairo_festival_city_mall, 30.0296, 31.4073));
        list.add(new CustomItemClass("City Skape Mall", R.drawable.city_skape_mall, 0, 0));
        list.add(new CustomItemClass("Dandy Mall", R.drawable.dandy_mall, 0, 0));
        list.add(new CustomItemClass("First Mall", R.drawable.first_mall, 0, 0));
        list.add(new CustomItemClass("Genena Mall", R.drawable.genena_mall, 30.0610, 31.3322));
        list.add(new CustomItemClass("DownTown Mall", R.drawable.downtown_mall, 30.0168, 31.4121));
        list.add(new CustomItemClass("Cairo Mall", R.drawable.cairo_mall, 0, 0));

        ListView listView = (ListView) view.findViewById(R.id.shopping_places_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomItemClass customItemClass = list.get(position);
                if (customItemClass.getLatitude() == 0){
                    Toast.makeText(getContext(), getString(R.string.missing_latitude_longtude), Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                            .setTitle(getString(R.string.dialog_title_location));
                    if (customItemClass.getImageUri() == R.drawable.mall_al_arab){
                        builder.setMessage(getString(R.string.mall_of_arabia_location));
                    }else if (customItemClass.getImageUri() == R.drawable.city_skape_mall){
                        builder.setMessage(getString(R.string.cityskape_mall_location));
                    }else if (customItemClass.getImageUri() == R.drawable.dandy_mall){
                        builder.setMessage(getString(R.string.dandy_mall_location));
                    }else if (customItemClass.getImageUri() == R.drawable.first_mall){
                        builder.setMessage(getString(R.string.first_mall_location));
                    }else if (customItemClass.getImageUri() == R.drawable.cairo_mall){
                        builder.setMessage(getString(R.string.cairo_mall_location));
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
