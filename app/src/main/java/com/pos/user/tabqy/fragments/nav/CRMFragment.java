package com.pos.user.tabqy.fragments.nav;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pos.user.tabqy.R;
import com.pos.user.tabqy.adapter.AdapterWalkinDraggedItems;
import com.pos.user.tabqy.adapter.MainItemListAdapter1;
import com.pos.user.tabqy.adapter.MainItemListAdapter2;
import com.pos.user.tabqy.fragments.ChargeFragment;
import com.pos.user.tabqy.fragments.SaveFragment;
import com.pos.user.tabqy.interfaces.CallbackItemTouch;
import com.pos.user.tabqy.model.TestData;
import com.pos.user.tabqy.utils.ItemOffsetDecoration;
import com.pos.user.tabqy.utils.SupportingWidgets;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRMFragment extends Fragment implements CallbackItemTouch, MainItemListAdapter2.Listener,
        View.OnClickListener, View.OnDragListener, MainItemListAdapter2.Interface_MainItemListAdapter2 {
    private View view;
    private RecyclerView recyclerView,dragged_items;
    private List<TestData> testDataList = new ArrayList<>();
    private MainItemListAdapter2 adapter;
    private TextView txt_addnote, txt_add_discount, txt_crm_charge, txt_save;
    private AdapterWalkinDraggedItems adapterWalkinDraggedItems;
    private int arr_size = 1;

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
        dragged_items = view.findViewById(R.id.crm_dragged_items);

        for (int i=0;i<35;i++){
            TestData testData = new TestData();
            testData.setName("Coca Cola");
            testDataList.add(testData);
        }


        adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
        dragged_items.setAdapter(adapterWalkinDraggedItems);

        dragged_items.setOnDragListener(this);


        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        dragged_items.setLayoutManager(verticalLayoutmanager);
//        dragged_items.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
        dragged_items.setAdapter(adapterWalkinDraggedItems);


        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

        adapter = new MainItemListAdapter2(getActivity(), testDataList,this, this);
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
                        R.id.main_frameDash,CRMFragment.class.getName());
                break;
            case R.id.fragment_crm_order_txtSave:
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new SaveFragment(),fragmentManager,
                        R.id.main_frameDash,CRMFragment.class.getName());
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

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {

    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        boolean isDropped = false;
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:

                break;

            case DragEvent.ACTION_DRAG_ENTERED:

                break;

            case DragEvent.ACTION_DRAG_EXITED:

                break;

            case DragEvent.ACTION_DROP:

                View view = (View) event.getLocalState();
                Log.d("MyId", view.getId() + "");

//                Toast.makeText(getContext(), "dropped", Toast.LENGTH_SHORT).show();
                if(v.getId() == R.id.fragment_crm_recycler_product){
//                    Toast.makeText(getContext(), "Main", Toast.LENGTH_SHORT).show();
                } else if(v.getId() == R.id.crm_dragged_items){
                    arr_size = arr_size + 1;

/*
                    tv_sub_total.setText("$" + (arr_size * 12) + ".00");
                    tv_total.setText("SAR " + ((arr_size * 12) + 40) + ".00");
*/
                    adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
                    dragged_items.setAdapter(adapterWalkinDraggedItems);

//                    adapter.notifyDataSetChanged();
                    adapterWalkinDraggedItems.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "out", Toast.LENGTH_SHORT).show();
                }
                isDropped = true;
                break;

            case DragEvent.ACTION_DRAG_ENDED:

                break;

            default:

                break;
        }

        if (!isDropped) {
            View vw = (View) event.getLocalState();
            vw.setVisibility(View.VISIBLE);
        }
        return true;
    }

    private int dragged_item_position = 0;

    @Override
    public void method(int position) {
        dragged_item_position = position;

    }
}
