package com.pos.user.tabqy.fragments.nav;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pos.user.tabqy.R;
import com.pos.user.tabqy.adapter.AdapterTableMain;
import com.pos.user.tabqy.utils.ItemOffsetDecoration;
import com.pos.user.tabqy.utils.SupportingWidgets;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TableFragment extends Fragment implements AdapterTableMain.Interface_TableMain {


    public TableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv_main;
    private ArrayList<String> arr = new ArrayList<>();
    private AdapterTableMain adapter;

    private void init(){

        rv_main = getView().findViewById(R.id.fragment_table_recycler);
        rv_main.setLayoutManager(new GridLayoutManager(getActivity(),
                SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        rv_main.addItemDecoration(itemDecoration);

        arr.clear();
        for(int i=0; i<35; i++){
            arr.add("0");
        }

        adapter = new AdapterTableMain(arr, this);
        rv_main.setAdapter(adapter);
    }

    @Override
    public void method_Table_Main(int position) {
        if (position >= 0) {
            if (arr.get(position).equals("0")) {
                arr.set(position, "1");
            } else {
                arr.set(position, "0");
            }
            adapter.notifyDataSetChanged();
        }
    }
}
