package com.example.strahpro.ui.osago;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.strahpro.R;
import com.example.strahpro.data.CategoryTransport;

import java.util.ArrayList;

public class OsagoFragment extends Fragment {
    Button rachet;
    private OsagoViewModel osagoViewModel;
    private ArrayList<Integer> stageList;
    private ArrayList<CategoryTransport> categList;
    private ArrayList<String> regList;
   /* private double cafBT[] = {1036, 5436, 2807, 4227, 1680, 2807};
    private double cafStage[] = {1.2, 1, 0.8};
    private double cafReg[] = {1.18, 1, 0.8};*/
    private String spinCategPos;
    private String spinStagesPos;
    private String spinRegionPos;
    TextView itog;

    private void logical() {
        double tmpcafBT = 0.0;

        for (CategoryTransport categoryTransport : categList) {
            if(spinCategPos == categoryTransport.getName()){
                tmpcafBT = categoryTransport.getcBt();
            }
        }

        Double tmpItog = tmpcafBT*tmpcafBT;
        itog.setText(tmpItog.toString());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        osagoViewModel =
                new ViewModelProvider(this).get(OsagoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_osago, container, false);
        stageList = new ArrayList<>();
        categList = new ArrayList<CategoryTransport>();
        regList = new ArrayList<String>();

        Spinner spinCateg = (Spinner) root.findViewById(R.id.categAutoSpin);
        Spinner spinStages = (Spinner) root.findViewById(R.id.stageAutoSpin);
        Spinner spinRegion = (Spinner) root.findViewById(R.id.regionSpin);
        rachet = (Button) root.findViewById(R.id.rachet);
        itog = (TextView) root.findViewById(R.id.itog);
        ArrayAdapter<String> adapterSpinCateg;
        ArrayAdapter<Integer> adapterSpinStages;
        ArrayAdapter<String> adapterSpinRegion;


        regList = osagoViewModel.getRegion();
        categList = osagoViewModel.getCategories();
        stageList = osagoViewModel.getStage();

        ArrayList<String> categListName = new ArrayList<>();
        for (CategoryTransport categoryTransport : categList) {
            categListName.add(categoryTransport.getName());
        }
        //

        adapterSpinCateg = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, categListName);
        adapterSpinCateg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCateg.setAdapter(adapterSpinCateg);

        adapterSpinStages = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, stageList);
        adapterSpinStages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStages.setAdapter(adapterSpinStages);

        adapterSpinRegion = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, regList);
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