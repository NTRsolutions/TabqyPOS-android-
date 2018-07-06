package com.pos.user.tabqy.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pos.user.tabqy.R;
import com.pos.user.tabqy.activities.MainDashBoardActivity;

public class ChargeFragment extends Fragment {

    private RelativeLayout nav_menu;
    private View view;

    public ChargeFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_charge, container, false);
        init(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainDashBoardActivity) getActivity()).showHideNavView();
            }
        });
    }

    private void init(View view) {
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
    }


    public static class DashBoardFragment extends Activity {
    }
}