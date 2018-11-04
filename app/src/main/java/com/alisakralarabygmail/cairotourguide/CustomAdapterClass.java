package com.alisakralarabygmail.cairotourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ali on 8/22/2017.
 */

public class CustomAdapterClass extends ArrayAdapter<CustomItemClass>{

    private AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
    public CustomAdapterClass(@NonNull Context context, ArrayList<CustomItemClass> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CustomItemClass customItemClass = getItem(position);
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.list_item_image_view);
        imageView.setImageResource(customItemClass.getImageUri());

        TextView textView = (TextView) view.findViewById(R.id.list_item_text_view);
        textView.setText(customItemClass.getLabel());

        return view;
    }

}
