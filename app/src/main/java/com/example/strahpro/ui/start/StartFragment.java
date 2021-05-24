package com.example.strahpro.ui.start;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.strahpro.OsagoFrag;
import com.example.strahpro.R;
import com.example.strahpro.ui.kasko.KaskoFragment;
import com.example.strahpro.ui.osago.HomeViewModel;
import com.example.strahpro.ui.osago.OsagoFragment;


public class StartFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button kaskoBut;
    private Button osagoBut;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_start, container, false);
        kaskoBut = (Button) root.findViewById(R.id.kaskobut);
        osagoBut = (Button) root.findViewById(R.id.osagobut);
        kaskoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.nav_host_fragment, KaskoFragment.class, null);
                transaction.commit();
            }
        });
        osagoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.nav_host_fragment, OsagoFragment.class, null);
                transaction.commit();
            }
        });
        return root;
    }
}