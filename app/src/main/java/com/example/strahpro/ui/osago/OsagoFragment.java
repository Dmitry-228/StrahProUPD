package com.example.strahpro.ui.osago;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.strahpro.R;

public class OsagoFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_osago, container, false);

        Spinner spinCateg = (Spinner) root.findViewById(R.id.categAutoSpin);
        Spinner spinStages = (Spinner) root.findViewById(R.id.stageAutoSpin);
        Spinner spinRegion = (Spinner) root.findViewById(R.id.regionSpin);
        ArrayAdapter<String> adapterSpinCateg;
        ArrayAdapter<Integer> adapterSpinStages;
        ArrayAdapter<String> adapterSpinRegion;
        String categories[] = {"A", "B", "C"};
        Integer stages[] = {6, 8, 12};
        String region[] = {"Ставрополь", "Михайловск", "Кисловодск", "Невиномыск", "Мин. Воды", "Другие"};

        adapterSpinCateg = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, categories);
        // Определяем разметку для использования при выборе элемента
        adapterSpinCateg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinCateg.setAdapter(adapterSpinCateg);

        adapterSpinStages = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, stages);
        // Определяем разметку для использования при выборе элемента
        adapterSpinStages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinStages.setAdapter(adapterSpinStages);

        adapterSpinRegion = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, region);
        // Определяем разметку для использования при выборе элемента
        adapterSpinRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinRegion.setAdapter(adapterSpinRegion);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}