package org.pursuit.mapappfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.mapappfromscratch.MapsActivity;
import org.pursuit.mapappfromscratch.R;
import org.pursuit.mapappfromscratch.model.Museum;

public class MuseumViewHolder extends RecyclerView.ViewHolder {

    public static final String MUSEUM_NAME = "name";
    public static final String MUSEUM_ADDRESS = "address";
    public static final String MUSEUM_CITY = "city";
    public static final String MUSEUM_STATE = "state";
    public static final String MUSEUM_ZIP = "zip";

    private TextView nameTextView;
    private TextView addressTextView;
    private TextView cityTextView;
    private TextView stateTextView;
    private TextView zipTextView;

    public MuseumViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.name_textView);
        addressTextView = itemView.findViewById(R.id.address_textView);
        cityTextView = itemView.findViewById(R.id.city_textView);
        stateTextView = itemView.findViewById(R.id.state_textView);
        zipTextView = itemView.findViewById(R.id.zip_textView);
    }

    public void onBind(final Museum museum){
        nameTextView.setText(museum.getName());
        addressTextView.setText(museum.getAddress());
        cityTextView.setText(museum.getCity());
        stateTextView.setText(museum.getState());
        zipTextView.setText(museum.getZip());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                intent.putExtra(MUSEUM_NAME, museum.getName());
                intent.putExtra(MUSEUM_ADDRESS, museum.getAddress());
                intent.putExtra(MUSEUM_CITY, museum.getCity());
                intent.putExtra(MUSEUM_STATE, museum.getState());
                intent.putExtra(MUSEUM_ZIP, museum.getZip());
                v.getContext().startActivity(intent);
            }
        });
    }

}
