package com.abhishek.chapphmansample.Activies;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.abhishek.chapphmansample.API.APIInterface;
import com.abhishek.chapphmansample.Model.MobileVerification;
import com.abhishek.chapphmansample.R;
import com.abhishek.chapphmansample.Utils.DataStore;

import static android.R.attr.fragment;


public class MainActivity extends AppCompatActivity {

    private EditText mobileNumberPicker;
    private Button submitButton;
    private MobileVerification mobileVerification;
    private ProgressDialog progressDialog;
    public static final String NETWORK_TAG = "NETWORK_TAG";
    MobileVerification response = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNumberPicker = (EditText) findViewById(R.id.numberPicker);
        submitButton = (Button) findViewById(R.id.submitButton);

        DataStore.deleteAuthToken(this);

        submitButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("wait for otp...");
                progressDialog.show();
                    mobileVerification = new MobileVerification(mobileNumberPicker.getText().toString());
                    mobileVerification.setListener(new MobileVerification.ApiListener() {
                    @Override
                    public void onCompletion() {
                        progressDialog.dismiss();
                        //This method will be called only after getting the response from the API.
                        loadOtpFragment(response);
                    }
                });
                if (mobileNumberPicker.getText().toString().length() >= 10) {
                    response = mobileVerification.verifyMobileNumber(mobileVerification, MainActivity.this);
                } else {
                    progressDialog.dismiss();
                }
            }
        });
    }


    public void loadOtpFragment(MobileVerification response) {
        if (response != null) {
            if(response.getMeta().getStatus() == 200) {
                FragmentManager manager =  this.getSupportFragmentManager();
                Fragment fragment = manager.findFragmentById(R.id.otpFragmentContainer);
                fragment = new otp_page();
                fragment = ((otp_page) fragment).newInstance(response);
                manager.beginTransaction().add(R.id.otpFragmentContainer, fragment).addToBackStack("").commit();
            }
        }
    }


}
