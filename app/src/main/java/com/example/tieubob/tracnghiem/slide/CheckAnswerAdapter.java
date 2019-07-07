package com.example.tieubob.tracnghiem.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {
    ArrayList lsData;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList lsData, Context context) {
        this.lsData = lsData;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
        }
        return null;
    }
    private static class ViewHolder {
        TextView tvNumAns, tvAnswer;

    }
}
