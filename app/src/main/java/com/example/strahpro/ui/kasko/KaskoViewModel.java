package com.example.strahpro.ui.kasko;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.strahpro.data.AgeTransport;
import com.example.strahpro.data.StageTransport;

import java.util.ArrayList;

public class KaskoViewModel extends ViewModel {

    private ArrayList<AgeTransport> agesList;
    private ArrayList<StageTransport> stageList;
//    private MutableLiveData<ArrayList<Integer>> ageLiveData;
//    private MutableLiveData<ArrayList<Integer>> stageLiveData;

    public ArrayList<AgeTransport> getAges() {
        if (agesList == null) {
            //ageLiveData = new MutableLiveData<>();
            loadAgeData();
        }
        return agesList;
    }

    // эмитация обращения в БД
    private void loadAgeData() {
        agesList = new ArrayList<>();
        agesList.add(new AgeTransport("Меньше 23 лет", 0.6));
        agesList.add(new AgeTransport("Больше 23 лет", 0.4));
        agesList.add(new AgeTransport("Больше 30 лет", 0.3));
        //ageLiveData.postValue(agesList);
    }

    public ArrayList<StageTransport> getStage() {
        if (stageList == null) {
            //stageLiveData = new MutableLiveData<>();
            loadStageData();
        }
        return stageList;
    }

    // эмитация обращения в БД
    private void loadStageData() {
        stageList = new ArrayList<>();
        stageList.add(new StageTransport("Меньше 3 лет", 1.2));
        stageList.add(new StageTransport("Больше 3 лет", 1.0));
        stageList.add(new StageTransport("Больше 7 лет", 0.8));

        //stageLiveData.postValue(stageList);
    }
}