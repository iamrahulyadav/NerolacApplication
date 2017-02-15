package com.abc.nerolac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.model.AwareModel;

import java.util.ArrayList;

/**
 * Created by abc on 13-Jan-17.
 */
public class AwareAdapter extends ArrayAdapter<AwareModel> {


    private final Context context;
    private final ArrayList<AwareModel> modelArrayList;

    public AwareAdapter(Context context, ArrayList<AwareModel> modelArrayList) {
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

        AwareModel awarePaintModel = modelArrayList.get(position);

        RelativeLayout relativeLayout = null;

        TextView textView;
        ImageView imageView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            relativeLayout = (RelativeLayout) inflater.inflate(R.layout.aware_list_view, null);
        } else {
            relativeLayout = (RelativeLayout) convertView;
        }

        textView = (TextView) relativeLayout.findViewById(R.id.textView);
        textView.setText(awarePaintModel.getName());

        imageView = (ImageView) relativeLayout.findViewById(R.id.imageView);
        imageView.setImageResource(awarePaintModel.getListImage());

        return relativeLayout;
    }
}
