package com.pos.user.tabqy.fragments.nav;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pos.user.tabqy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFragment extends Fragment implements View.OnClickListener {

    public OnlineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_online, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private LinearLayout status_layout_first, status_layout_two, status_layout_three, status_layout_four;
    private void init(){
        status_layout_first = getView().findViewById(R.id.fragment_online_online_status_one);
        status_layout_two = getView().findViewById(R.id.fragment_online_online_status_two);
        status_layout_three = getView().findViewById(R.id.fragment_online_online_status_three);
        status_layout_four = getView().findViewById(R.id.fragment_online_online_status_four);

        status_layout_first.setOnClickListener(this);
        status_layout_two.setOnClickListener(this);
        status_layout_three.setOnClickListener(this);
        status_layout_four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.fragment_online_online_status_one || id == R.id.fragment_online_online_status_two ||
                id == R.id.fragment_online_online_status_three || id == R.id.fragment_online_online_status_four){
            click_on_status(id);
        }
    }

    private void click_on_status(int id){
        status_layout_first.setBackgroundDrawable(null);
        status_layout_two.setBackgroundDrawable(null);
        status_layout_three.setBackgroundDrawable(null);
        status_layout_four.setBackgroundDrawable(null);

        LinearLayout layout = getView().findViewById(id);
        layout.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.shape_border_pink));
    }


}
