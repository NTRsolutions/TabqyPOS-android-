package com.askonlinesolutions.user.tabqy.customtext;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.askonlinesolutions.user.tabqy.R;


/**
 * Created by lenovo on 4/13/2018.
 */

public class CustomTextButtonTextView extends android.support.v7.widget.AppCompatTextView {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomTextButtonTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomTextButtonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CustomTextButtonTextView(Context context) {
        super(context);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Regular.ttf");
        setTextSize(getContext().getResources().getDimension(R.dimen.small_size));
        setTypeface(tf ,1);
        setBackground(getContext().getResources().getDrawable(R.drawable.button_bg));

    }

}

