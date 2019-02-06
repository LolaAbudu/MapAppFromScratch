package org.pursuit.mapappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.mapappfromscratch.R;
import org.pursuit.mapappfromscratch.model.Museum;
import org.pursuit.mapappfromscratch.view.MuseumViewHolder;

import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumViewHolder> {
    private List<Museum> museumList;

    public MuseumAdapter(List<Museum> museumList) {
        this.museumList = museumList;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.museum_itemview, parent, false);
        return new MuseumViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumViewHolder museumViewHolder, int position) {
        museumViewHolder.onBind(museumList.get(position));
    }

    @Override
    public int getItemCount() {
        return museumList.size();
    }
}
