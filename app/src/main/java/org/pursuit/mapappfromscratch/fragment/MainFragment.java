package org.pursuit.mapappfromscratch.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.mapappfromscratch.R;
import org.pursuit.mapappfromscratch.controller.MuseumAdapter;
import org.pursuit.mapappfromscratch.model.Museum;
import org.pursuit.mapappfromscratch.model.MuseumsList;
import org.pursuit.mapappfromscratch.network.MuseumServices;
import org.pursuit.mapappfromscratch.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View rootview;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
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

        Retrofit retrofit = RetrofitSingleton.getInstance();
        MuseumServices museumServices = retrofit.create(MuseumServices.class);
        Call<MuseumsList> museumsListCall = museumServices.getMuseum();
        museumsListCall.enqueue(new Callback<MuseumsList>() {
            @Override
            public void onResponse(Call<MuseumsList> call, Response<MuseumsList> response) {
                Log.d("tag", response.body().getMuseums().get(1).getName());

                List<Museum> museumList = response.body().getMuseums();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                MuseumAdapter museumAdapter = new MuseumAdapter(museumList);
                recyclerView.setAdapter(museumAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);


            }

            @Override
            public void onFailure(Call<MuseumsList> call, Throwable t) {
                Log.d("tag", "onFailure"  + t.toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = rootview.findViewById(R.id.museum_recyclerView);

        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
