package com.askonlinesolutions.user.tabqy.fragments.nav;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.activities.MainDashBoardActivity;
import com.askonlinesolutions.user.tabqy.activities.SearchActivity;
import com.askonlinesolutions.user.tabqy.adapter.AdapterWalkinDraggedItems;
import com.askonlinesolutions.user.tabqy.adapter.MainItemListAdapter2;
import com.askonlinesolutions.user.tabqy.fragments.AddUserFragment;
import com.askonlinesolutions.user.tabqy.fragments.ChargeFragment;
import com.askonlinesolutions.user.tabqy.fragments.SaveFragment;
import com.askonlinesolutions.user.tabqy.interfaces.CallbackItemTouch;
import com.askonlinesolutions.user.tabqy.model.TestData;
import com.askonlinesolutions.user.tabqy.utils.CustomLayoutManager;
import com.askonlinesolutions.user.tabqy.utils.ItemOffsetDecoration;
import com.askonlinesolutions.user.tabqy.utils.SupportingWidgets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewOrderFragment extends Fragment implements CallbackItemTouch, MainItemListAdapter2.Listener,
        View.OnClickListener, View.OnDragListener, MainItemListAdapter2.Interface_MainItemListAdapter2 {
    private View view;
    private RelativeLayout nav_menu;
    private MainItemListAdapter2 adapter;
    private ImageView imgdot_menu, img_delete;
    TextView img_search, txt_add_user, txt_add_note, txt_add_discount;

    private int arr_size = 1;

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
        txt_add_user.setOnClickListener(this);
        txtChrage.setOnClickListener(this);
        img_search.setOnClickListener(this);
        txt_save.setOnClickListener(this);
        img_delete.setOnClickListener(this);
        txt_add_discount.setOnClickListener(this);
        txt_add_note.setOnClickListener(this);
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

    private List<TestData>testDataList = new ArrayList<>();

    public RecyclerView recycler_viewmain, dragged_items;
    private TextView txtChrage, txt_save;
    private TextView tv_sub_total, tv_total;

    private AdapterWalkinDraggedItems adapterWalkinDraggedItems;

    private void init(View view) {

        tv_sub_total = view.findViewById(R.id.walkin_sub_total);
        tv_total = view.findViewById(R.id.walkin_total);

        txt_add_user = view.findViewById(R.id.img_adduser);
        nav_menu = (RelativeLayout) view.findViewById(R.id.nav_menu);
        ((MainDashBoardActivity) getActivity()).hideNav();


        recycler_viewmain = (RecyclerView) view.findViewById(R.id.recycler_viewmain);
        imgdot_menu = (ImageView) view.findViewById(R.id.imgdot_menu);
        dragged_items =  view.findViewById(R.id.dragged_items);

        recycler_viewmain.setOnDragListener(this);
        dragged_items.setOnDragListener(this);

//        RelativeLayout relativeLayout = view.findViewById(R.id.deletetop);
//        relativeLayout.setOnDragListener(this);

        txtChrage = view.findViewById(R.id.fragment_new_order_txtCharge);
        img_search = view.findViewById(R.id.img_search);
        txt_save = view.findViewById(R.id.fragment_new_order_txtSave);
        img_delete = view.findViewById(R.id.fragment_new_order_delete);
        txt_add_note = view.findViewById(R.id.add_note);
        txt_add_discount = view.findViewById(R.id.add_discount);

        for (int i=0;i<15;i++){
            TestData testData = new TestData();
            testData.setName("Coca Cola");
            testDataList.add(testData);
        }


        CustomLayoutManager manager1 = new CustomLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };


        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        dragged_items.setLayoutManager(verticalLayoutmanager);
//        dragged_items.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterWalkinDraggedItems = new AdapterWalkinDraggedItems(arr_size);
        dragged_items.setAdapter(adapterWalkinDraggedItems);




        recycler_viewmain.setLayoutManager(new GridLayoutManager(getActivity(), SupportingWidgets.calculateNoOfColumns(getActivity())));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        recycler_viewmain.addItemDecoration(itemDecoration);

        adapter = new MainItemListAdapter2(getActivity(), testDataList,this, this);
        recycler_viewmain.setAdapter(adapter);

       /* MainItemListAdapter1 cartAdapter = adapter = new MainItemListAdapter1(getActivity(), testDataList,this);

        dragged_items.addItemDecoration(itemDecoration);
        dragged_items.setAdapter(cartAdapter);*/
    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {

    }

    @Override
    public void setEmptyList(boolean visibility) {
        dragged_items.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }

    FragmentManager fragmentManager;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_new_order_txtCharge:
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new ChargeFragment(),fragmentManager,
                        R.id.main_frameDash,NewOrderFragment.class.getName());

                break;
            case R.id.img_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.fragment_new_order_txtSave:
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new SaveFragment(),fragmentManager,
                        R.id.main_frameDash,NewOrderFragment.class.getName());
                break;
            case R.id.img_adduser:
                fragmentManager = getFragmentManager();
                new SupportingWidgets().callFragment(getActivity(), new AddUserFragment(),fragmentManager,
                        R.id.main_frameDash,NewOrderFragment.class.getName());
                break;
            case R.id.fragment_new_order_delete:
                createDeleteDialog();
                break;
            case R.id.add_note:
                addNoteDialog();
                break;
            case R.id.add_discount:
                addDiscoountDialog();
                break;
        }
    }

    private void createDeleteDialog(){
        final Dialog dialog= new Dialog(getContext());
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
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();

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
             if(v.getId() == R.id.recycler_viewmain){
//                    Toast.makeText(getContext(), "Main", Toast.LENGTH_SHORT).show();
                } else if(v.getId() == R.id.dragged_items){
//                    Toast.makeText(getContext(), "Re", Toast.LENGTH_SHORT).show();
//                    testDataList.remove(dragged_item_position);
                    arr_size = arr_size + 1;
                    Toast.makeText(getContext(), arr_size + "Re", Toast.LENGTH_SHORT).show();


                    tv_sub_total.setText("$" + (arr_size * 12) + ".00");
                    tv_total.setText("SAR " + ((arr_size * 12) + 40) + ".00");

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
//        Toast.makeText(getContext(), position + "", Toast.LENGTH_SHORT).show();
    }
}
