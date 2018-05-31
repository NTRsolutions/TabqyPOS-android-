package com.askonlinesolutions.user.tabqy.fragments;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.activities.MainDashBoardActivity;
import com.askonlinesolutions.user.tabqy.adapter.CartAdapter;
import com.askonlinesolutions.user.tabqy.adapter.MainItemListAdapter;
import com.askonlinesolutions.user.tabqy.callbacks.MyItemTouchHelperCallback;
import com.askonlinesolutions.user.tabqy.data.AppData;
import com.askonlinesolutions.user.tabqy.interfaces.CallbackItemTouch;
import com.askonlinesolutions.user.tabqy.utils.ItemOffsetDecoration;
import com.askonlinesolutions.user.tabqy.utils.SupportingWidgets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NewOrderFragment extends Fragment implements CallbackItemTouch {
    private View view;
    private RelativeLayout nav_menu;
    private MainItemListAdapter adapter;
    private ImageView imgdot_menu;

    public NewOrderFragment() {
        // Required empty public constructor
    }

    public static NewOrderFragment newInstance(String param1, String param2) {
        NewOrderFragment fragment = new NewOrderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_order, container, false);
        init(view);
        setListeners();
        return view;
    }


    private void setListeners() {
        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainDashBoardActivity) getActivity()).showHideNavView();
            }
        });

        imgdot_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(getActivity(),findExchangeRateAndConvert("INR", "USD", 1000)+"",Toast.LENGTH_SHORT).show();
                //findExchangeRateAndConvert("INR", "USD", 1000);

//                popupwindow_obj = showMyPopup();
//                if (i == 0) {
//                    popupwindow_obj.showAsDropDown(imgdot_menu, 10, 20); // where u want show on view click event popupwindow.showAsDropDown(view, x, y);
//                    i = 1;
//                } else if (i == 1) {
//                    popupwindow_obj.dismiss();
//                    i = 0;
//                }
            }
        });


    }

    private static Double findExchangeRateAndConvert(String from, String to, int amount) {
        try {
            //Yahoo Finance API
            URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=SAR_INR" + from + to + "&compact=y");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line) * amount;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    int i = 0;
    PopupWindow popupwindow_obj;

    public PopupWindow showMyPopup() {

        final PopupWindow popupWindow = new PopupWindow(getActivity());

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dot_menulayout, null);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        popupWindow.setFocusable(true);
        popupWindow.setWidth(100);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setContentView(view);
        return popupWindow;
    }

    public RecyclerView recycler_viewmain, dragged_items;
    public CartAdapter adapterCart;

    private void init(View view) {
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
        ((MainDashBoardActivity) getActivity()).hideNav();
        recycler_viewmain = (RecyclerView) view.findViewById(R.id.recycler_viewmain);
        imgdot_menu = (ImageView) view.findViewById(R.id.imgdot_menu);
        dragged_items = (RecyclerView) view.findViewById(R.id.dragged_items);
        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        dragged_items.setLayoutManager(verticalLayoutmanager);
        //dragged_items.setLayoutManager(new LinearLayoutManager(getActivity())));
        recycler_viewmain.setLayoutManager(new GridLayoutManager(getActivity(), SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        recycler_viewmain.addItemDecoration(itemDecoration);
        adapter = new MainItemListAdapter(getActivity());
        adapterCart = new CartAdapter(getActivity());
        recycler_viewmain.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(this);// create MyItemTouchHelperCallback
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback); // Create ItemTouchHelper and pass with parameter the MyItemTouchHelperCallback
        touchHelper.attachToRecyclerView(recycler_viewmain); // Attach ItemTouchHelper to RecyclerView
        dragged_items.setAdapter(adapterCart);
    }


    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {

    }
}
