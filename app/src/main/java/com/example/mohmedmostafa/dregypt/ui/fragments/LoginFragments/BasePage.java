package com.example.mohmedmostafa.dregypt.ui.fragments.LoginFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mohmedmostafa.dregypt.R;
import com.example.mohmedmostafa.dregypt.utils.Utils;


public class BasePage extends Fragment {
    private static View view;
    private static FragmentManager fragmentManager;
    private static Button btnsignIn;
    private static TextView SignUphere;

    public BasePage() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_base_page, container, false);
        initViews();
        Click();


        // Inflate the layout for this fragment
        return view;
    }

    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        btnsignIn = view.findViewById(R.id.BPSignInWithEmail);
        SignUphere = view.findViewById(R.id.BPcreateAccount);
    }

    private void Click(){

        btnsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer,
                                new Login_Fragment(),
                                Utils.Login_Fragment).commit();

            }
        });

        SignUphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, new SignUp_Fragment(),
                                Utils.SignUp_Fragment).commit();

            }
        });

    }

}