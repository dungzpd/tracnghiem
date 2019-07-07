package com.example.tieubob.tracnghiem.chungchi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tieubob.tracnghiem.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if( convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_exam, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.txtItem);
        ImageView imageView = convertView.findViewById(R.id.imgItem);
        Exam p = getItem(position);
        if (p != null){
            tvName.setText(p.getName() + "");
            imageView.setImageResource(R.drawable.information);
        }
        return convertView;
    }
}

