package com.askonlinesolutions.user.tabqy.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.util.DisplayMetrics;

import com.askonlinesolutions.user.tabqy.R;

public class SupportingWidgets {
    public static AlertDialog alertDialog;

    public  static AlertDialog myLoader(Activity activity){
      return alertDialog;
    }
    public  void callFragment(Activity activity, Fragment fragment,int container){
        activity.getFragmentManager().beginTransaction().replace(container,fragment).commit();
    }

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
}
