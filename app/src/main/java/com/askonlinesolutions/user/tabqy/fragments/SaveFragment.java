package com.askonlinesolutions.user.tabqy.fragments;

import android.app.Dialog;
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


public class SaveFragment extends Fragment implements SavePastOrderAdapter.SearchItemClick, View.OnClickListener{
    private View view;
    private TextView txt_add_note, txt_add_discount, txt_not, txt_add_user, txt_add_address, txt_del_add;
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
        txt_add_address = view.findViewById(R.id.fragment_save_txt_add_address);
        txt_del_add = view.findViewById(R.id.fragment_save_txt_delete_address);

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
        txt_del_add.setOnClickListener(this);
        txt_add_address.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_save_txt_add_address:
                addAddressDialog();
                break;
            case R.id.fragment_save_txt_delete_address:
                createDeleteDialog();
                break;
        }
    }

    private void addAddressDialog(){
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_address);

        dialog.findViewById(R.id.dialog_address_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.dialog_address_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();

    }

    private void createDeleteDialog(){
        final Dialog dialog= new Dialog(getContext());
        TextView txt_title, txt_content;
        dialog.setContentView(R.layout.dialog_delete_item);

        dialog.findViewById(R.id.dialog_del_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.dialog_del_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        txt_content = dialog.findViewById(R.id.dialog_del_txt_content);
        txt_title = dialog.findViewById(R.id.dialog_del_txt_title);

        txt_content.setText(getResources().getString(R.string.dialog_add_address_content));
        txt_title.setText(getResources().getString(R.string.dialog_add_address_delete));
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();

    }


}
