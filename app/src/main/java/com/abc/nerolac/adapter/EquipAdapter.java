package com.abc.nerolac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.model.AwareModel;
import com.abc.nerolac.model.EquipModel;

import java.util.ArrayList;

/**
 * Created by abc on 18-Jan-17.
 */
public class EquipAdapter extends ArrayAdapter {

    Context context;
    ArrayList<EquipModel> modelArrayList;

    public EquipAdapter(Context context, ArrayList<EquipModel> modelArrayList) {
        super(context, 0);

        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*LayoutInflater inflater;
        LinearLayout linearLayout = null;

        if(convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linearLayout = (LinearLayout) inflater.inflate(R.layout.equip_list_view, null);
        }else {
            linearLayout = (LinearLayout) convertView;
        }

        EquipModel equipModel = modelArrayList.get(position);

        TextView textView = (TextView) linearLayout.findViewById(R.id.textView);
        textView.setText(equipModel.getName());

        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imageView);
        imageView.setImageResource(equipModel.getListImage());

        return linearLayout;*/

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.equip_list_view,null);

            EquipModel equipModel = modelArrayList.get(position);

            TextView textView = (TextView) convertView.findViewById(R.id.textView);
            textView.setText(equipModel.getName());

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(equipModel.getListImage());


        }
        return convertView;
    }
}
