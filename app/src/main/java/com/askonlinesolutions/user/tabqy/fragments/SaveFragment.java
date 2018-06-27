package com.askonlinesolutions.user.tabqy.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.askonlinesolutions.user.tabqy.adapter.CustomerSearchAdapter;
import com.askonlinesolutions.user.tabqy.adapter.SavePastOrderAdapter;
import com.askonlinesolutions.user.tabqy.utils.SupportingWidgets;


public class SaveFragment extends Fragment implements SavePastOrderAdapter.SearchItemClick{
    private View view;
    private TextView txt_add_note, txt_add_discount, txt_not, txt_add_user;
    private RelativeLayout nav_menu;
    private RecyclerView recyclerView;


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
        recyclerView = view.findViewById(R.id.fragment_save_recycler);
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
        txt_add_user = view.findViewById(R.id.img_adduser);

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

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        setListener();
        setAdapter();
    }
    FragmentManager fragmentManager;

    private void setListener(){
        txt_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new AddUserFragment(),fragmentManager,
                        R.id.main_frameDash,SaveFragment.class.getName());
            }
        });
    }

    private void setAdapter(){
        SavePastOrderAdapter savePastOrderAdapter = new
                SavePastOrderAdapter(getContext(),this);
        recyclerView.setAdapter(savePastOrderAdapter);
    }

    @Override
    public void getSelected(int position) {

    }
}
