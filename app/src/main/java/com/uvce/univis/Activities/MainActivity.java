package com.uvce.univis.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.uvce.univis.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar tools;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.syllabus:
                    // changing to the syllabus fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new SyllabusFragment()).commit();
                    return true;
                case R.id.questionPapers:
                    // Changing to the question paper fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new QPaperFragment()).commit();
                    return true;
            }


            return false;
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.changeSem:
                //Going to the settings activity
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                return true;
            case R.id.info:
                //Set up the info page
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new InfoFragment()).commit();
                return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the default syllabus fragment to the frame layout
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new SyllabusFragment()).commit();

        //Setting the bottom navigation bar
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Setting up the appbar
        tools = (Toolbar) findViewById(R.id.toolbar);
        tools.setTitle(Html.fromHtml("<font color='#ffffff'>UNIVIS</font>"));
        setSupportActionBar(tools);

    }

}
