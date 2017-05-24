package com.robosoft.roboguicesample;

import android.os.Bundle;
import android.widget.TextView;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectView;

/**
 * Created by Rahul Kumar Pandey on 24-05-2017.
 */

@ContentView(R.layout.activity_second)
public class SecondActivity extends RoboActivity {

    @InjectView(R.id.nameTxtView) private TextView mNameText;
    @InjectView(R.id.emailTxtView) private TextView mEmailText;

    // Injecting Extras value that coming from intent
    // Note that @InjectExtra will cause a runtime error if the extra is not present. If the extra is optional,
    // you should include an optional flag whose value is set to true in order to avoid the error.
    @InjectExtra(value = "Name", optional = true) private String mName;
    @InjectExtra("Email") private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
    }

    private void setData() {
        mNameText.setText(mName);
        mEmailText.setText(mEmail);
    }
}
