package com.example.strahpro.ui.osago;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.strahpro.data.CategoryTransport;
import com.example.strahpro.data.RegionTransport;
import com.example.strahpro.data.StageTransport;

import java.util.ArrayList;

public class OsagoViewModel extends ViewModel {

    private ArrayList<StageTransport> stageList;
    private ArrayList<CategoryTransport> categList;
    private ArrayList<RegionTransport> regList;
    /*private MutableLiveData<ArrayList<Integer>> stageLiveData;
    private MutableLiveData<ArrayList<String>> categoriesLiveData;
    private MutableLiveData<ArrayList<String>> regionLiveData;*/


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

    public ArrayList<CategoryTransport> getCategories() {
        if (categList == null) {
           // categoriesLiveData = new MutableLiveData<>();
            loadCategoriesData();
        }
        return categList;
    }

    private void loadCategoriesData() {
        categList = new ArrayList<>();
        categList.add(new CategoryTransport("A - мотоциклы", 1036.0));
        categList.add(new CategoryTransport("B - легковые автомобили", 5436.0));
        categList.add(new CategoryTransport("C - грузовые, меньше 16 тонн", 2807.0));
        categList.add(new CategoryTransport("C - грузовые, больше 16 тонн", 4227.0));
        categList.add(new CategoryTransport("D - автобусы, меньше 16 мест", 1680.0));
        categList.add(new CategoryTransport("D - автобусы, больше 16 мест", 2807.0));
       // categoriesLiveData.postValue(categList);
    }

    public ArrayList<RegionTransport> getRegion() {
        if (regList == null) {
            loadRegionData();
        }
        return regList;
    }

    private void loadRegionData() {
        regList = new ArrayList<>();
        regList.add(new RegionTransport ("Ставрополь", 1.18));
        regList.add(new RegionTransport ("Михайловск", 1.18));
        regList.add(new RegionTransport ("Кисловодск", 1.18));
        regList.add(new RegionTransport ("Невиномыск", 1.0));
        regList.add(new RegionTransport ("Минеральные воды", 1.0));
        regList.add(new RegionTransport ("Другой регион", 0.8));

        //regionLiveData.postValue(regList);
    }
}