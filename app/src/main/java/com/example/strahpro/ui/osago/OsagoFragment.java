package com.example.strahpro.ui.osago;

import android.icu.number.Precision;
import android.os.Bundle;
import android.util.Log;
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
import com.example.strahpro.data.CategoryTransport;
import com.example.strahpro.data.RegionTransport;
import com.example.strahpro.data.StageTransport;

import java.util.ArrayList;

public class OsagoFragment extends Fragment {
    Button rachet;
    EditText power;
    Switch trailer;
    private OsagoViewModel osagoViewModel;
    private ArrayList<StageTransport> stageList;
    private ArrayList<CategoryTransport> categList;
    private ArrayList<RegionTransport> regList;
    /* private double cafBT[] = {1036, 5436, 2807, 4227, 1680, 2807};
     private double cafStage[] = {1.2, 1, 0.8};
     private double cafReg[] = {1.18, 1, 0.8};*/
    private String spinCategPos;
    private String spinStagesPos;
    private String spinRegionPos;
    TextView itog;

    private void logical() {
        double tmpcafBT = 0.0;
        double tmpstcf = 0.0;
        double tmpregcf = 0.0;
        double tmpPowcf = 0.0;
        double tmpTcf = 0.0;

        if(power.getText().length() == 0){
            itog.setText("Укажите мощность!");
        } else {
            String guessStr = power.getText().toString();
            int theGuess = Integer.parseInt(guessStr);

            Log.d("POWER", guessStr );

            for (CategoryTransport categoryTransport : categList) {
                if (spinCategPos == categoryTransport.getName()) {
                    tmpcafBT = categoryTransport.getcBt();
                }
            }
            for (StageTransport stageTransport : stageList) {
                if (spinStagesPos == stageTransport.getName()) {
                    tmpstcf = stageTransport.getsBt();
                }
            }
            for (RegionTransport regionTransport : regList) {
                if (spinRegionPos == regionTransport.getName()) {
                    tmpregcf = regionTransport.getrBt();
                }
            }
            if (theGuess < 70) {
                tmpPowcf = 1;
            } else if (theGuess > 71 && theGuess < 100) {
                tmpPowcf = 1.1;
            } else if (theGuess > 101 && theGuess < 120) {
                tmpPowcf = 1.2;
            } else if (theGuess > 121 && theGuess < 150) {
                tmpPowcf = 1.4;
            } else if (theGuess > 151) {
                tmpPowcf = 1.6;
            }
            if (trailer != null) {
                tmpTcf = 1.18;
            } else {
                tmpTcf = 1;
            }

            Double tmpItog = tmpcafBT * tmpstcf * tmpregcf * tmpPowcf * tmpTcf;
            // Math.round(tmpItog);
            itog.setText(tmpItog.toString());
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        osagoViewModel =
                new ViewModelProvider(this).get(OsagoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_osago, container, false);
        stageList = new ArrayList<StageTransport>();
        categList = new ArrayList<CategoryTransport>();
        regList = new ArrayList<RegionTransport>();

        Spinner spinCateg = (Spinner) root.findViewById(R.id.categAutoSpin);
        Spinner spinStages = (Spinner) root.findViewById(R.id.stageAutoSpin);
        Spinner spinRegion = (Spinner) root.findViewById(R.id.regionSpin);
        rachet = (Button) root.findViewById(R.id.rachet);
        itog = (TextView) root.findViewById(R.id.itog);
        power = (EditText) root.findViewById(R.id.editTextNumberPower);
        trailer = (Switch) root.findViewById(R.id.trailer);
        ArrayAdapter<String> adapterSpinCateg;
        ArrayAdapter<String> adapterSpinStages;
        ArrayAdapter<String> adapterSpinRegion;


        regList = osagoViewModel.getRegion();
        categList = osagoViewModel.getCategories();
        stageList = osagoViewModel.getStage();

        ArrayList<String> categListName = new ArrayList<>();
        for (CategoryTransport categoryTransport : categList) {
            categListName.add(categoryTransport.getName());
        }
        ArrayList<String> regListName = new ArrayList<>();
        for (RegionTransport regionTransport : regList) {
            regListName.add(regionTransport.getName());
        }
        ArrayList<String> stageListName = new ArrayList<>();
        for (StageTransport stageTransport : stageList) {
            stageListName.add(stageTransport.getName());
        }

        adapterSpinCateg = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, categListName);
        adapterSpinCateg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCateg.setAdapter(adapterSpinCateg);

        adapterSpinStages = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, stageListName);
        adapterSpinStages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStages.setAdapter(adapterSpinStages);

        adapterSpinRegion = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, regListName);
        adapterSpinRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinRegion.setAdapter(adapterSpinRegion);

        spinCateg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinCategPos = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinRegionPos = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinStages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinStagesPos = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rachet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logical();
            }
        });
        return root;
    }
}