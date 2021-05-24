package com.example.strahpro.ui.osago;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.strahpro.data.CategoryTransport;

import java.util.ArrayList;

public class OsagoViewModel extends ViewModel {

    private ArrayList<Integer> stageList;
    private ArrayList<CategoryTransport> categList;
    private ArrayList<String> regList;
    /*private MutableLiveData<ArrayList<Integer>> stageLiveData;
    private MutableLiveData<ArrayList<String>> categoriesLiveData;
    private MutableLiveData<ArrayList<String>> regionLiveData;*/


    public ArrayList<Integer> getStage() {
        if (stageList == null) {
            //stageLiveData = new MutableLiveData<>();
            loadStageData();
        }
        return stageList;
    }

    // эмитация обращения в БД
    private void loadStageData() {
        stageList = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            stageList.add(i);
        }
        //stageLiveData.postValue(stageList);
    }

    public ArrayList<CategoryTransport> getCategories() {
        if (categList == null) {
           // categoriesLiveData = new MutableLiveData<>();
            loadCategoriesData();
        }
        return categList;
    }

    private void loadCategoriesData() {
        categList = new ArrayList<>();
        categList.add(new CategoryTransport("A - мотоциклы", 44.0));
        categList.add(new CategoryTransport("B - легковые автомобили", 121.0));
        categList.add(new CategoryTransport("C - грузовые, меньше 16 тонн", 12.0));
        categList.add(new CategoryTransport("C - грузовые, больше 16 тонн", 12.0));
        categList.add(new CategoryTransport("D - автобусы, меньше 16 мест", 12.0));
        categList.add(new CategoryTransport("D - автобусы, больше 16 мест", 12.0));
       // categoriesLiveData.postValue(categList);
    }

    public ArrayList<String> getRegion() {
        if (regList == null) {
            loadRegionData();
        }
        return regList;
    }

    private void loadRegionData() {
        regList = new ArrayList<>();
        regList.add("Ставрополь");
        regList.add("Михайловск");
        regList.add("Кисловодск");
        regList.add("Невиномыск");
        regList.add("Минеральные воды");
        regList.add("Другой регион");

        //regionLiveData.postValue(regList);
    }
}