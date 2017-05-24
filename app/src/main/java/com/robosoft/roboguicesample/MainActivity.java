package com.robosoft.roboguicesample;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

// Inject associated layout
@ContentView(R.layout.activity_main)

public class MainActivity extends RoboActivity implements View.OnClickListener {

    // Inject view
    @InjectView(R.id.nameTxt) private TextView mNameTxt;
    @InjectView(R.id.emailTxt) private TextView mEmailTxt;
    @InjectView(R.id.button) private Button mButton;

    // Injecting resources
    // @InjectResource(R.color.colorAccent) private Color mColor;
    @InjectResource(R.string.user_name) private String mUserName;
    @InjectResource(R.string.email) private String mUserEmail;

    //Injecting your own class object
    @Inject UserDetails mUserDetails; // equivalent to new UserDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButton.setOnClickListener(this);
        setData();
    }

    private void setData() {
        mUserDetails.setmUserName(mUserName);
        mUserDetails.setmUserEmail(mUserEmail);
        mNameTxt.setText(mUserDetails.getmUserName());
        mEmailTxt.setText(mUserDetails.getmUserEmail());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this , SecondActivity.class);
                intent.putExtra("Name" , mUserDetails.getmUserName());
                intent.putExtra("Email", mUserDetails.getmUserEmail());
                startActivity(intent);
                break;
        }
    }
}
