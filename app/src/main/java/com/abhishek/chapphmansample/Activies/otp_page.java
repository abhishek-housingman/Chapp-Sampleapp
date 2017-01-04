package com.abhishek.chapphmansample.Activies;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhishek.chapphmansample.Model.MobileVerification;
import com.abhishek.chapphmansample.Model.VerifyOtp;
import com.abhishek.chapphmansample.R;
import com.abhishek.chapphmansample.Utils.DataStore;

import static android.R.attr.data;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link otp_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class otp_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String RESPONSE_KEY = "com.response.key";

    public MobileVerification mobileVerification;

    private EditText otpNumberPicker;
    private Button sendOtpButton;
    private TextView appNameTextView;
    private ImageView imageBackGround;
    private ProgressDialog progressDialog;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public otp_page() {
        // Required empty public constructor
    }

    private void setResponseObject(MobileVerification verification) {
        this.mobileVerification = verification;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment otp_page.
     */
    // TODO: Rename and change types and number of parameters
    //remember there was static for newInstance.
    public otp_page newInstance(MobileVerification verification) {
        otp_page fragment = new otp_page();
        //Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        fragment.setResponseObject(verification);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_otp_page, container, false);
        otpNumberPicker = (EditText)v.findViewById(R.id.otpNumberPicker);
        sendOtpButton = (Button)v.findViewById(R.id.otpSubmitButton);
        imageBackGround = (ImageView)v.findViewById(R.id.hmanLogoImage);
        appNameTextView = (TextView)v.findViewById(R.id.textViewAppName);
        sendOtpButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("wait for otp...");
                progressDialog.show();
                makeVerifyOtpCall();
            }
        });
        return v;
    }

    public void makeVerifyOtpCall() {
        String otpStr = otpNumberPicker.getText().toString();
        final VerifyOtp otpObj = new VerifyOtp(mobileVerification.getMobile(), otpStr);
        otpObj.verifyOtpCall(otpObj, getActivity());

        otpObj.setListener(new VerifyOtp.ResponseListener() {
            @Override
            public void onCompletion() {

                if(otpObj.responseData.getMeta().getStatus() == 201) {
                    DataStore data = new DataStore();
                    data.storeUserInfo(otpObj.responseData, getActivity());
                    progressDialog.dismiss();
                    Intent intent = new Intent(getActivity(), HomeTabbedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
