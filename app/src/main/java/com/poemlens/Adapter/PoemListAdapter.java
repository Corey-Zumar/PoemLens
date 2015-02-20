package com.poemlens.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Corey on 2/18/15.
 */

public class PoemListAdapter extends ArrayAdapter<Object> {

    public PoemListAdapter(Context context, int resource, List<Object> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
