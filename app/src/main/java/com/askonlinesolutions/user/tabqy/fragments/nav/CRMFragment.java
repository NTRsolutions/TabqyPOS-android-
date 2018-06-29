package com.askonlinesolutions.user.tabqy.fragments.nav;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.adapter.MainItemListAdapter1;
import com.askonlinesolutions.user.tabqy.fragments.ChargeFragment;
import com.askonlinesolutions.user.tabqy.fragments.NewOrderFragment1;
import com.askonlinesolutions.user.tabqy.fragments.SaveFragment;
import com.askonlinesolutions.user.tabqy.model.TestData;
import com.askonlinesolutions.user.tabqy.utils.ItemOffsetDecoration;
import com.askonlinesolutions.user.tabqy.utils.SupportingWidgets;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRMFragment extends Fragment implements MainItemListAdapter1.Listener, View.OnClickListener{
    private View view;
    private RecyclerView recyclerView;
    private List<TestData> testDataList = new ArrayList<>();
    private MainItemListAdapter1 adapter;
    private TextView txt_addnote, txt_add_discount, txt_crm_charge, txt_save;

    public CRMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_crm, container, false);
        init(view);
        setListener();
        return view;
    }


    private void setListener(){
        txt_addnote.setOnClickListener(this);
        txt_add_discount.setOnClickListener(this);
        txt_crm_charge.setOnClickListener(this);
        txt_save.setOnClickListener(this);
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.fragment_crm_recycler_product);
        txt_addnote = view.findViewById(R.id.fragment_crm_add_note);
        txt_add_discount = view.findViewById(R.id.fragment_crm_add_discount);
        txt_crm_charge = view.findViewById(R.id.fragment_crm_order_txtCharge);
        txt_save = view.findViewById(R.id.fragment_crm_order_txtSave);

        for (int i=0;i<15;i++){
            TestData testData = new TestData();
            testData.setName("Coca Cola");
            testDataList.add(testData);
        }

        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        adapter = new MainItemListAdapter1(getActivity(), testDataList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setEmptyList(boolean visibility) {

    }

    private FragmentManager fragmentManager;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_crm_add_note:
                addNoteDialog();
                break;
            case R.id.fragment_crm_add_discount:
                addDiscoountDialog();
                break;
            case R.id.fragment_crm_order_txtCharge:
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new ChargeFragment(),fragmentManager,
                        R.id.main_frameDash,NewOrderFragment1.class.getName());
                break;
            case R.id.fragment_crm_order_txtSave:
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new SaveFragment(),fragmentManager,
                        R.id.main_frameDash,NewOrderFragment1.class.getName());
                break;
        }
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
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(null);
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
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();

    }

}
