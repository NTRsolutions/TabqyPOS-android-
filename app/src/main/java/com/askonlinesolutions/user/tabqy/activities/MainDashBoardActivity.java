package com.askonlinesolutions.user.tabqy.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.controller.NetworkController;
import com.askonlinesolutions.user.tabqy.fragments.DashBoardFragment;
import com.askonlinesolutions.user.tabqy.fragments.NewOrderFragment1;
import com.askonlinesolutions.user.tabqy.fragments.nav.CRMFragment;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainDashBoardActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private RelativeLayout custom_nav1,dashboardLayout, walkin_layoutLayout, crm_layout, table_layout, online_layout,
    charity_layout, order_status_layout;

    private NavigationView nav_view;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setListeners();

    }

    public void showHideNavView() {
        if (flag == 0) {
            nav_view.setVisibility(View.VISIBLE);
            flag = 1;
        } else if (flag == 1) {
            nav_view.setVisibility(View.GONE);
            flag = 0;
        }
    }

    public void hideNav() {
        nav_view.setVisibility(View.GONE);
    }

    private void setListeners() {
//        dashboardLayout.setOnClickListener(this);
//        walkin_layoutLayout.setOnClickListener(this );
    }

    private void init() {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_dash_board);
        custom_nav1 = (RelativeLayout) findViewById(R.id.custom_nav1);
        nav_view = (NavigationView) findViewById(R.id.nav_view);

        dashboardLayout = findViewById(R.id.dashboard);
        walkin_layoutLayout = findViewById(R.id.walkin_layout);
        crm_layout = findViewById(R.id.crm_layout);
        table_layout = findViewById(R.id.table);
        online_layout = findViewById(R.id.online_layout);
        charity_layout = findViewById(R.id.charity);
        order_status_layout = findViewById(R.id.order_status);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new DashBoardFragment()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_sales) {
            // Handle the camera action
        } else if (id == R.id.nav_customer) {

        } else if (id == R.id.nav_edit) {

        } else if (id == R.id.nav_close_register) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_support) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_item) {

        } else if (id == R.id.nav_receipts) {

        }

        return true;
    }



    @Override
    public void onClick(View v) {

    }


    public void nav_click(View view){
        setNavBacground();
        switch (view.getId()){
            case R.id.walkin_layout:
                walkin_layoutLayout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new NewOrderFragment1()).commit();
                break;
            case R.id.dashboard:
                dashboardLayout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new DashBoardFragment()).commit();
                break;

            case R.id.crm_layout:
                crm_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new CRMFragment()).commit();
                break;
            case R.id.table:
                table_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new DashBoardFragment()).commit();
                break;
                case R.id.online_layout:
                online_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new NewOrderFragment1()).commit();
                break;
            case R.id.charity:
                charity_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new DashBoardFragment()).commit();
                break;
            case R.id.order_status:
                order_status_layout.setBackgroundColor(getResources().getColor(R.color.colorDark));
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameDash, new DashBoardFragment()).commit();
                break;
            default:
                break;
        }
    }

    private void setNavBacground(){
        dashboardLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        walkin_layoutLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        crm_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        table_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        online_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        charity_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        order_status_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}
