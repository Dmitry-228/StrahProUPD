package com.example.strahpro.ui.kasko;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.strahpro.R;
import com.example.strahpro.data.AgeTransport;
import com.example.strahpro.data.StageTransport;

import java.util.ArrayList;

public class KaskoFragment extends Fragment {

    private Button rachetK;
    private TextView itogk;
    private Switch signal;
    private EditText price;
    private KaskoViewModel kaskoViewModel;
    private ArrayList<AgeTransport> ageList;
    private ArrayList<StageTransport> stageList;
    private String spinStagesPos;
    private String spinAgePos;

    private void logical(){
        double tmpScf = 0.0;
        double tmpcafBT = 0.0;
        String guessStr = price.getText().toString();
        int priceL = Integer.parseInt(guessStr);

        if (signal != null) {
            tmpScf = 1.18;
        } else {
            tmpScf = 1;
        }
        Double summa = priceL * tmpScf * tmpcafBT;
        itogk.setText(summa.toString());
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ageList = new ArrayList<AgeTransport>();
        stageList = new ArrayList<>();
        kaskoViewModel = new ViewModelProvider(this).get(KaskoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kasko, container, false);

        Spinner spinAges = (Spinner) root.findViewById(R.id.spinAges);
        Spinner spinStages = (Spinner) root.findViewById(R.id.spinStages);
        rachetK = (Button) root.findViewById(R.id.rachetK);
        signal = (Switch) root.findViewById(R.id.signal);
        itogk = (TextView) root.findViewById(R.id.itogK);
        price = (EditText) root.findViewById(R.id.editTextPrice);
        ArrayAdapter<String> adapterSpinAges;
        ArrayAdapter<String> adapterSpinStages;

        stageList = kaskoViewModel.getStage();
        ageList = kaskoViewModel.getAges();
        ArrayList<String> stageListName = new ArrayList<>();
        for (StageTransport stageTransport : stageList) {
            stageListName.add(stageTransport.getName());
        }
        ArrayList<String> ageListName = new ArrayList<>();
        for (AgeTransport ageTransport : ageList) {
            ageListName.add(ageTransport.getName());
        }

        adapterSpinAges = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, ageListName);
        adapterSpinAges.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAges.setAdapter(adapterSpinAges);

        adapterSpinStages = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, stageListName);
        adapterSpinStages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStages.setAdapter(adapterSpinStages);

        spinStages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinStagesPos = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinAges.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinAgePos = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rachetK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logical();
            }
        });

        return root;
    }
}