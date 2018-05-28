package com.askonlinesolutions.user.tabqy.errorHandler;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class VolleyErrorHandler {


    public static void networkErrorHandler(VolleyError error) {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
//            Toast.makeText(context,
//                    context.getString(R.string.error_network_timeout),
//                    Toast.LENGTH_LONG).show();
        } else if (error instanceof AuthFailureError) {
            //TODO
        } else if (error instanceof ServerError) {
            //TODO
        } else if (error instanceof NetworkError) {
            //TODO
        } else if (error instanceof ParseError) {
            //TODO
        }

    }
}
