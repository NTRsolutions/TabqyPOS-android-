package com.askonlinesolutions.user.tabqy.controller;

import android.app.Activity;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.askonlinesolutions.user.tabqy.errorHandler.VolleyErrorHandler;

public class NetworkController {
    public String response_main;

    public String getResponse(Activity activity, String url) {
        //getting the progressbar
        //  final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //making the progressbar visible
        //  progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        //  progressBar.setVisibility(View.INVISIBLE);
                        response_main = response;

                        Log.d("response",response_main);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        VolleyErrorHandler.networkErrorHandler(error);
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(activity);

        //adding the string request to request queue
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);

        return response_main;
    }

}
