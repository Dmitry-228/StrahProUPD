package com.example.strahpro.ui.kasko;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.strahpro.R;

import java.util.ArrayList;

public class KaskoFragment extends Fragment {

    private KaskoViewModel kaskoViewModel;
    private ArrayList<Integer> ageList;
    private ArrayList<Integer> stageList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ageList = new ArrayList<>();
        stageList = new ArrayList<>();
        kaskoViewModel = new ViewModelProvider(this).get(KaskoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kasko, container, false);

        Spinner spinAges = (Spinner) root.findViewById(R.id.spinAges);
        Spinner spinStages = (Spinner) root.findViewById(R.id.spinStages);

        ArrayAdapter<Integer> adapterSpinAges;
        ArrayAdapter<Integer> adapterSpinStages;

        kaskoViewModel.getAges().observe(getViewLifecycleOwner(), new Observer<ArrayList<Integer>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Integer> ages) {
                ageList.clear();
                ageList.addAll(0, ages);
            }
        });

        kaskoViewModel.getStage().observe(getViewLifecycleOwner(), new Observer<ArrayList<Integer>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Integer> stages) {
                stageList.clear();
                stageList.addAll(0, stages);
            }
        });

        adapterSpinAges = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, ageList);
        adapterSpinAges.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAges.setAdapter(adapterSpinAges);
        spinAges.setAdapter(adapterSpinAges);

        adapterSpinStages = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, stageList);
        adapterSpinStages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStages.setAdapter(adapterSpinStages);


//        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Integer item = (Integer) parent.getItemAtPosition(position);
//                selection.setText(item);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        };

        return root;
    }
}