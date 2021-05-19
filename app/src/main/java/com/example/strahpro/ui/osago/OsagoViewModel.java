package com.example.strahpro.ui.osago;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class OsagoViewModel extends ViewModel {

    private ArrayList<Integer> stageList;
    private ArrayList<String> categList;
    private ArrayList<String> regList;
    private MutableLiveData<ArrayList<Integer>> stageLiveData;
    private MutableLiveData<ArrayList<String>> categoriesLiveData;
    private MutableLiveData<ArrayList<String>> regionLiveData;


    public LiveData<ArrayList<Integer>> getStage() {
        if (stageLiveData == null) {
            stageLiveData = new MutableLiveData<>();
            loadStageData();
        }
        return stageLiveData;
    }

    // эмитация обращения в БД
    private void loadStageData() {
        stageList = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            stageList.add(i);
        }
        stageLiveData.postValue(stageList);
    }

    public LiveData<ArrayList<String>> getCategories() {
        if (categoriesLiveData == null) {
            categoriesLiveData = new MutableLiveData<>();
            loadCategoriesData();
        }
        return categoriesLiveData;
    }

    private void loadCategoriesData() {
        categList = new ArrayList<>();
        categList.add("A - мотоциклы");
        categList.add("B - легковые автомобили");
        categList.add("C - грузовые, меньше 16 тонн");
        categList.add("C - грузовые, больше 16 тонн");
        categList.add("D - автобусы, меньше 16 мест");
        categList.add("D - автобусы, больше 16 мест");

        categoriesLiveData.postValue(categList);
    }

    public LiveData<ArrayList<String>> getRegion() {
        if (regionLiveData == null) {
            regionLiveData = new MutableLiveData<>();
            loadRegionData();
        }
        return regionLiveData;
    }

    private void loadRegionData() {
        regList = new ArrayList<>();
        regList.add("Ставрополь");
        regList.add("Михайловск");
        regList.add("Кисловодск");
        regList.add("Невиномыск");
        regList.add("Минеральные воды");
        regList.add("Другой регион");

        regionLiveData.postValue(regList);
    }
}