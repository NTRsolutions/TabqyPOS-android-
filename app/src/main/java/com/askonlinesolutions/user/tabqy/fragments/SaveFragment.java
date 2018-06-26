package com.askonlinesolutions.user.tabqy.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.activities.MainDashBoardActivity;


public class SaveFragment extends Fragment {
    private View view;
    private TextView txt_add_note, txt_add_discount, txt_not;
    private RelativeLayout nav_menu;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_save, container, false);

        init(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void init(View view){
        txt_add_discount = view.findViewById(R.id.add_discount);
        txt_add_note = view.findViewById(R.id.add_note);
        txt_add_discount.setVisibility(View.GONE);
        txt_add_note.setVisibility(View.GONE);
        txt_not = view.findViewById(R.id.fragment_save_not_name);
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);

        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainDashBoardActivity) getActivity()).showHideNavView();
            }
        });

        String s = "Not John? Create new Customer";
        Spannable wordtoSpan = new SpannableString(s);

        wordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorappPink)), 8, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        txt_not.setText(wordtoSpan);
    }


}
