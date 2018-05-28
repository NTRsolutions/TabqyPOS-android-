package com.askonlinesolutions.user.tabqy.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;

import com.askonlinesolutions.user.tabqy.R;

public class SupportingWidgets {
    public static AlertDialog alertDialog;

    public  static AlertDialog myLoader(Activity activity){
      return alertDialog;
    }
    public  void callFragment(Activity activity, Fragment fragment,int container){
        activity.getFragmentManager().beginTransaction().replace(container,fragment).commit();
    }
}
