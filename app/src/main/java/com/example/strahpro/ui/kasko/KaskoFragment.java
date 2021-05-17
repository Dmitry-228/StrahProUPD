package com.example.strahpro.ui.kasko;

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

public class KaskoFragment extends Fragment {

    private KaskoViewModel kaskoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kaskoViewModel = new ViewModelProvider(this).get(KaskoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kasko, container, false);

        Spinner spinAges = (Spinner) root.findViewById(R.id.spinAges);
        Spinner spinStages = (Spinner) root.findViewById(R.id.spinStages);
        ArrayAdapter<Integer> adapterspinAges;
        ArrayAdapter<Integer> adapterspinStages;
        //Integer[] age;
        Integer ages[] = {20, 23, 34};
        Integer stages[] = {6, 8, 12};
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner

        kaskoViewModel.getAges().observe(getViewLifecycleOwner(), new Observer<Integer[]>() {
            @Override
            public void onChanged(@Nullable Integer[] ages) {
                //age = ages;
            }
        });
        // ages
        adapterspinAges = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, ages);
        // Определяем разметку для использования при выборе элемента
        adapterspinAges.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinAges.setAdapter(adapterspinAges);

        adapterspinStages = new ArrayAdapter<Integer>(root.getContext(), android.R.layout.simple_spinner_item, stages);
        // Определяем разметку для использования при выборе элемента
        adapterspinAges.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinAges.setAdapter(adapterspinAges);


//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}