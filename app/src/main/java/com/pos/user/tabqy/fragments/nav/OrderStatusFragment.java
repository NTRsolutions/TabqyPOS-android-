package com.pos.user.tabqy.fragments.nav;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pos.user.tabqy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderStatusFragment extends Fragment {


    public OrderStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_status, container, false);
    }

}
