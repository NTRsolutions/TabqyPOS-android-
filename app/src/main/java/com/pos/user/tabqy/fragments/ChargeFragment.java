package com.pos.user.tabqy.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pos.user.tabqy.R;
import com.pos.user.tabqy.activities.MainDashBoardActivity;

public class ChargeFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private RelativeLayout nav_menu;
    private View view;
    private RadioGroup radioGroup;
    private TextView txt_add_discount, txt_add_note;

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
        txt_add_note.setOnClickListener(this);
        txt_add_discount.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainDashBoardActivity) getActivity()).showHideNavView();
            }
        });

    }

    private void init(View view) {
        radioGroup = view.findViewById(R.id.fragment_charge_radiogroup);
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
        txt_add_discount = view.findViewById(R.id.fragment_charge_add_discount);
        txt_add_note = view.findViewById(R.id.fragment_charge_add_note);
    }

    private void addNoteDialog(){
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add_note);

        dialog.findViewById(R.id.dialog_add_note_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.dialog_note_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();

    }

    private void addDiscoountDialog(){
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add_discount);

        dialog.findViewById(R.id.dialog_add_dis_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.dialog_discount_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_charge_add_discount:
                addDiscoountDialog();
                break;
            case R.id.fragment_charge_add_note:
                addNoteDialog();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId() == R.id.fragment_charge_radiogroup){
            int id = group.getCheckedRadioButtonId();
            RadioButton radioButton = group.findViewById(id);
            if(radioButton.getId() == R.id.fragment_charge_RadioCash){
                Toast.makeText(getActivity(), "Cash", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(getActivity(), "Card", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void payDialog(){

    }

}
