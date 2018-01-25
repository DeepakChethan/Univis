package com.uvce.univis.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.uvce.univis.R;

public class SettingActivity extends AppCompatActivity {

    private Spinner course, semester;
    private Button button;
    private String co;
    private int se;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        course = (Spinner) findViewById(R.id.course);
        semester = (Spinner) findViewById(R.id.semester);
        button = (Button) findViewById(R.id.button);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            course.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            semester.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        // TODO set the text color of spinners to white
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Update the shared prefs
                co=course.getSelectedItem().toString();
                se= (int) semester.getSelectedItem().toString().charAt(0);
                // Save the user settings
                // se values are [0 for 1st year, 1 for 3rd sem, 2 for 4th sem and so on]
                SharedPreferences sharedPreferences = getSharedPreferences("sub_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit= sharedPreferences.edit();
                edit.putString("course",co);
                edit.putInt("sem",se);
                edit.apply();
                //Start our main activity
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
