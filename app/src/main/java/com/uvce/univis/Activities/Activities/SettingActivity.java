package com.uvce.univis.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.uvce.univis.R;

public class SettingActivity extends AppCompatActivity {

    private Spinner course, semester;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        course = (Spinner) findViewById(R.id.course);
        semester = (Spinner) findViewById(R.id.semester);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Update the shared prefs
                String co;
                int se;
                co=course.getSelectedItem().toString();
                se= (int) semester.getSelectedItemId();

                //Start our main activity
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
