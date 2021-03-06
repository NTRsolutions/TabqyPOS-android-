package com.pos.user.tabqy.fragments.nav;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pos.user.tabqy.R;
import com.pos.user.tabqy.activities.MainDashBoardActivity;
import com.pos.user.tabqy.customtext.CustomTextView;
import com.pos.user.tabqy.utils.SupportingWidgets;

public class DashBoardFragment extends Fragment {
    private RelativeLayout nav_menu;
    private View view;
    private CustomTextView fragment_dash_new_order;

    public DashBoardFragment() {
        // Required empty public constructor
    }

    public static DashBoardFragment newInstance(String param1, String param2) {
        DashBoardFragment fragment = new DashBoardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        init(view);
        setListeners();
        return view;
    }
    FragmentManager fragmentManager;

    private void setListeners() {
        fragment_dash_new_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new NewOrderFragment(),
                        fragmentManager,R.id.main_frameDash,DashBoardFragment.class.getName());
            }
        });
        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainDashBoardActivity) getActivity()).showHideNavView();
            }
        });
    }

    private void init(View view) {
        fragment_dash_new_order = (CustomTextView) view.findViewById(R.id.fragment_dash_new_order);
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
    }


}
