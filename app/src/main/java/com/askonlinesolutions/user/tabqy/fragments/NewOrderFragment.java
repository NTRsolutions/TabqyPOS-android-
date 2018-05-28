package com.askonlinesolutions.user.tabqy.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.activities.MainDashBoardActivity;

public class NewOrderFragment extends Fragment {
    private View view;
    private RelativeLayout nav_menu;

    public NewOrderFragment() {
        // Required empty public constructor
    }

    public static NewOrderFragment newInstance(String param1, String param2) {
        NewOrderFragment fragment = new NewOrderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_order, container, false);
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


}
