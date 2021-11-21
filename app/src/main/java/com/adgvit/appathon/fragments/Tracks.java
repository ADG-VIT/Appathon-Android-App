package com.adgvit.appathon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adgvit.appathon.NetworkInterface.NetworkAPI;
import com.adgvit.appathon.R;
import com.adgvit.appathon.adapter.trackAdapter;
import com.adgvit.appathon.model.trackDomain;
import com.adgvit.appathon.networkmodels.Track;
import com.adgvit.appathon.NetworkUtils.NetworkUtils;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ScrollView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tracks extends Fragment {

    private RecyclerView recyclerView1;
    private ArrayList<Track> courseModelArrayList;
    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       /* setContentView(R.layout.fragment_track);
        recyclerView1 = findViewById(R.id.recyclerview);

        // here we have created new array list and added data to it.
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new trackDomain("Track 1", "Substantial Development", "About Hello, Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. About Hello, Lorem ipsum dolor sit amet."));
        courseModelArrayList.add(new trackDomain("Track 2", "Substantial Development", "About Hello, Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. About Hello, Lorem ipsum dolor sit amet."));
        trackAdapter customAdapter = new trackAdapter(this, courseModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(customAdapter);*/

    }

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_track, container, false);
       courseModelArrayList = new ArrayList<>();
        recyclerView1 = view.findViewById(R.id.recyclerview);
//        courseModelArrayList.add(new trackDomain("Track #1", "Substantial Development", "About Hello, Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
//                "About Hello, Lorem ipsum dolor sit amet."));
//        courseModelArrayList.add(new trackDomain("Track #2", "Substantial Development", "About Hello, Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
//                "About Hello, Lorem ipsum dolor sit amet."));

        try {
            Call<List<Track>> call = NetworkUtils.networkAPI.getTrack();
            call.enqueue(new Callback<List<Track>>() {
                @Override
                public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(getContext(), "Code "+ response.code() + " error "+response.message(),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    List<Track> tracks = response.body();
                    for (Track p:tracks){
                        courseModelArrayList.add(p);
                    }
                    System.out.println("Size" + courseModelArrayList.size());
                    adapter();
                }

                @Override
                public void onFailure(Call<List<Track>> call, Throwable t) {
                    Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                }
            });
        }
        catch (Exception e){
            Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }


        return view;
    }



    public void adapter(){
        trackAdapter customAdapter = new trackAdapter(this, courseModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(customAdapter);

    }

}