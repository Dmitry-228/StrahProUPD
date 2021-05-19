package com.example.strahpro.ui.osago;

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

public class OsagoFragment extends Fragment {

    private OsagoViewModel osagoViewModel;
    private ArrayList<Integer> stageList;
    private ArrayList<String> categList;
    private ArrayList<String> regList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        osagoViewModel =
                new ViewModelProvider(this).get(OsagoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_osago, container, false);
        stageList = new ArrayList<>();
        categList = new ArrayList<String>();
        regList = new ArrayList<String>();

        Spinner spinCateg = (Spinner) root.findViewById(R.id.categAutoSpin);
        Spinner spinStages = (Spinner) root.findViewById(R.id.stageAutoSpin);
        Spinner spinRegion = (Spinner) root.findViewById(R.id.regionSpin);
        TextView selection = (TextView) root.findViewById(R.id.textView5);
        ArrayAdapter<String> adapterSpinCateg;
        ArrayAdapter<Integer> adapterSpinStages;
        ArrayAdapter<String> adapterSpinRegion;


        osagoViewModel.getStage().observe(getViewLifecycleOwner(), new Observer<ArrayList<Integer>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Integer> stages) {
                stageList.clear();
                stageList.addAll(0, stages);
            }
        });

        osagoViewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(@Nullable ArrayList<String> categories) {
                categList.clear();
                categList.addAll(0, categories);
            }
        });

        osagoViewModel.getRegion().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(@Nullable ArrayList<String> regions) {
                regList.clear();
                regList.addAll(0, regions);
            }
        });

        adapterSpinCateg = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, categList);
        adapterSpinCateg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCateg.setAdapter(adapterSpinCateg);

        adapterSpinStages = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, stageList);
        adapterSpinStages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStages.setAdapter(adapterSpinStages);

        adapterSpinRegion = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, regList);
        adapterSpinRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinRegion.setAdapter(adapterSpinRegion);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                spinCateg.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        spinCateg.setOnItemSelectedListener(itemSelectedListener);

        return root;
    }
}