package com.projetomycity.mycity.fragmentos;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.projetomycity.mycity.R;
import com.projetomycity.mycity.adapter.CustomAdapter;
import com.projetomycity.mycity.modules.PostModel;
import com.projetomycity.mycity.webapi.WebManager;

import java.util.ArrayList;

/**
 * Created by PEDRONI on 15/08/2017.
 */

public class HomeFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<PostModel> posts;
    private ProgressBar loading;

    private WebManager wmanager = new WebManager();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        loading = (ProgressBar) rootView.findViewById(R.id.loading_bar);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.post_recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new Thread(new Runnable() {
            @Override
            public void run() {
                posts = wmanager.getPosts();
            }
        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter = new CustomAdapter(posts);
                recyclerView.setAdapter(adapter);
                loading.setVisibility(View.INVISIBLE);
            }
        },2000);



        return rootView;
    }

}
