package com.example.strahpro.ui.result;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.strahpro.R;
import com.example.strahpro.adapter.ResultAdapter;
import com.example.strahpro.data.Strahovka;
import com.example.strahpro.db.DBAdapter;

import java.util.ArrayList;

public class ResultFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ArrayList<Strahovka> strahovki;
    ResultAdapter resultAdapter;
    DBAdapter adapter;
    private RecyclerView strahovkiList;

    public ResultFragment() {}

    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_result, container, false);

        strahovkiList = (RecyclerView) root.findViewById(R.id.list);
        adapter = new DBAdapter(root.getContext());
        adapter.open();

        strahovki = adapter.getStrahovki();
        strahovki.add(new Strahovka("111", 3333));
        Log.d("SIZE", Integer.toString(strahovki.size()));
        resultAdapter =  new ResultAdapter(getContext(), strahovki);
        strahovkiList.setHasFixedSize(true);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        strahovkiList.setLayoutManager(linearLayoutManager);


        strahovkiList.setAdapter(resultAdapter);
        adapter.close();
        return root;
    }
}