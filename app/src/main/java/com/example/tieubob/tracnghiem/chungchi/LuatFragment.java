package com.example.tieubob.tracnghiem.chungchi;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.tieubob.tracnghiem.MainActivity;
import com.example.tieubob.tracnghiem.R;
import com.example.tieubob.tracnghiem.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LuatFragment extends Fragment {


    ExamAdapter examAdapter;
    GridView gridView;
    ArrayList<Exam> exams = new ArrayList<Exam>();
    public LuatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ( (MainActivity) getActivity()).getSupportActionBar().setTitle("Trắc nghiệm luật");
        return inflater.inflate(R.layout.fragment_luat, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = getActivity().findViewById(R.id.gvExam);
        exams.add(new Exam("Đề số 1"));
        exams.add(new Exam("Đề số 2"));
        exams.add(new Exam("Đề số 3"));
        exams.add(new Exam("Đề số 4"));
        exams.add(new Exam("Đề số 5"));
        exams.add(new Exam("Đề số 6"));
        examAdapter = new ExamAdapter(getActivity(), exams);
        gridView.setAdapter(examAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);
            }
        });

    }
}
