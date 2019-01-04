package com.projetomycity.mycity.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projetomycity.mycity.R;

/**
 * Created by PEDRONI on 15/08/2017.
 */

public class ChatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        
        return rootView;
    }

}
