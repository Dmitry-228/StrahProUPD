package com.example.strahpro.ui.kasko;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class KaskoViewModel extends ViewModel {

    private ArrayList<Integer> agesList;
    private ArrayList<Integer> stageList;
    private MutableLiveData<ArrayList<Integer>> ageLiveData;
    private MutableLiveData<ArrayList<Integer>> stageLiveData;

    public LiveData<ArrayList<Integer>> getAges() {
        if(ageLiveData == null){
            ageLiveData = new MutableLiveData<>();
            loadAgeData();
        }
        return ageLiveData;
    }

    // эмитация обращения в БД
    private void loadAgeData(){
        agesList = new ArrayList<>();
        for (int i = 18; i<100; i++) {
            agesList.add(i);
        }
        ageLiveData.postValue(agesList);
    }

    public LiveData<ArrayList<Integer>> getStage() {
        if(stageLiveData == null){
            stageLiveData = new MutableLiveData<>();
            loadStageData();
        }
        return stageLiveData;
    }

    // эмитация обращения в БД
    private void loadStageData(){
        stageList = new ArrayList<>();
        for (int i = 0; i<51; i++) {
            stageList.add(i);
        }
        stageLiveData.postValue(stageList);
    }
}