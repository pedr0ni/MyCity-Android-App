package com.projetomycity.mycity.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetomycity.mycity.Manager;
import com.projetomycity.mycity.R;
import com.squareup.picasso.Picasso;

/**
 * Created by PEDRONI on 15/08/2017.
 */

public class PerfilFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);

        ((TextView) rootView.findViewById(R.id.txt_name)).setText(Manager.logged_user.getNome());
        ((TextView) rootView.findViewById(R.id.txt_user)).setText("@"+Manager.logged_user.getUser());
        Picasso.with(rootView.getContext()).load(Manager.logged_user.getIcon()).into((ImageView) rootView.findViewById(R.id.img_profile));

        return rootView;
    }

}
