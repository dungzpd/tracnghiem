package com.example.tieubob.tracnghiem.chungchi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tieubob.tracnghiem.MainActivity;
import com.example.tieubob.tracnghiem.R;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ( (MainActivity) getActivity()).getSupportActionBar().setTitle("Trắc nghiệm xây dựng");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}
