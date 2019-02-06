package org.pursuit.mapappfromscratch;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import org.pursuit.mapappfromscratch.fragment.MainFragment;
import org.pursuit.mapappfromscratch.model.Museum;
import org.pursuit.mapappfromscratch.model.MuseumsList;
import org.pursuit.mapappfromscratch.network.MuseumServices;
import org.pursuit.mapappfromscratch.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, MainFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
