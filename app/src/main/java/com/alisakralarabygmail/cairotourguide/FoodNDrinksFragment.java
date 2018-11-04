package com.alisakralarabygmail.cairotourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodNDrinksFragment extends Fragment {

    private ArrayList<CustomItemClass> list = new ArrayList<>();
    private CustomAdapterClass customAdapterClass;
    public FoodNDrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_ndrinks, container, false);

        list.add(new CustomItemClass("Zooba Restaurant", R.drawable.zooba_restaurant, 30.0612, 31.2190));
        list.add(new CustomItemClass("Zitouni Restaurant", R.drawable.zitouni_restaurant, 30.0362, 31.2294));
        list.add(new CustomItemClass("Abu El Seid Restaurant", R.drawable.abu_el_seid_restaurant, 30.0594, 31.2242));
        list.add(new CustomItemClass("Bella Restaurant", R.drawable.bella_restaurant, 30.0363, 31.2295));
        list.add(new CustomItemClass("Left Bank Restaurant", R.drawable.left_bank_restaurant, 30.0730, 31.2219));
        list.add(new CustomItemClass("Ristorante Tuscany", R.drawable.ristorante_tuscany, 30.0571, 31.2246));
        list.add(new CustomItemClass("Nola Sweets Restaurant", R.drawable.nola_sweets_restaurant, 30.0614, 31.2227));
        list.add(new CustomItemClass("El-Fishawy Cafe", R.drawable.el_fishawy_cafe, 30.0474, 31.2623));
        list.add(new CustomItemClass("Garden Promenade cafe", R.drawable.garden_promenade_cafe, 30.0571, 31.2244));
        list.add(new CustomItemClass("Naguib Mahfouz cafe", R.drawable.naguib_mahfouz_cafe, 30.0480, 31.2616));

        ListView listView = (ListView) view.findViewById(R.id.food_n_drinks_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomItemClass customItemClass = list.get(position);
                Uri uri = Uri.parse("geo:" + customItemClass.getLatitude() + ","
                        + customItemClass.getLongtude() + "?z=18");
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
