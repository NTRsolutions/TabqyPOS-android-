package com.askonlinesolutions.user.tabqy.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.customtext.CustomTextButtonTextView;


public class LoginFragment extends Fragment {


    private View view;
    private CustomTextButtonTextView login_button;

    public LoginFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        init(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.main_frame, new PinFragment()).commit();

            }
        });
    }

    private void init(View view) {
        login_button = (CustomTextButtonTextView) view.findViewById(R.id.login_button);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
