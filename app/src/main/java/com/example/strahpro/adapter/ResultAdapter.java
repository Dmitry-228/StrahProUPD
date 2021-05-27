package com.example.strahpro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.strahpro.R;
import com.example.strahpro.data.Strahovka;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Strahovka> strahovki;

    public ResultAdapter(Context context, List<Strahovka> states) {
        this.strahovki = states;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.res_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultAdapter.ViewHolder holder, int position) {
        Strahovka strahovka = strahovki.get(position);
        holder.textViewDate.setText(strahovka.getDate());
        holder.textViewPrise.setText(Double.toString(strahovka.getPrice()));
    }

    @Override
    public int getItemCount() {
        return strahovki.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewDate, textViewPrise;
        ViewHolder(View view){
            super(view);
            textViewDate = (TextView) view.findViewById(R.id.textViewDate);
            textViewPrise = (TextView) view.findViewById(R.id.textViewPrise);
        }
    }
}