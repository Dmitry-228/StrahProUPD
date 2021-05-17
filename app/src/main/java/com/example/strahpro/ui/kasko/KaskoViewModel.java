package com.example.strahpro.ui.kasko;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KaskoViewModel extends ViewModel {

    private MutableLiveData<Integer[]> ageLiveData;

    private Integer ages[] = {20, 23 , 34};

    public KaskoViewModel() {
        ageLiveData = new MutableLiveData<>();
        ageLiveData.setValue(ages);
    }

    public LiveData<Integer[]> getAges() {
        return ageLiveData;
    }
}