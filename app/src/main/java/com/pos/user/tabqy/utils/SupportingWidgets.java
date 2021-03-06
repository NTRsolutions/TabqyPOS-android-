package com.pos.user.tabqy.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;

import com.pos.user.tabqy.R;

public class SupportingWidgets {
    public static AlertDialog alertDialog;

    public  static AlertDialog myLoader(Activity activity){
      return alertDialog;
    }
   /* public  void callFragment(Activity activity, android.support.v4.app.Fragment fragment, int container){
        activity.getFragmentManager().beginTransaction().replace(container,fragment).commit();

        activity.getFragmentManager().beginTransaction().replace(container, fragment)
    }
*/
    public void callFragment(Activity activity, Fragment fragment, FragmentManager manager, int container, String tag){

        manager.beginTransaction().replace(container, fragment).addToBackStack(tag).commit();
    }

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
}
