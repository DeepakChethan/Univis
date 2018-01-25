package com.uvce.univis.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.uvce.univis.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SyllabusDisplay extends AppCompatActivity {

    Toolbar tools;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_display);

        tv= (TextView)findViewById(R.id.syllabus_data);
        tools=(Toolbar)findViewById(R.id.toolbar);
        String subject=getIntent().getExtras().getString("sub_name");
        String file=getIntent().getExtras().getString("file_name");
        String path=getIntent().getExtras().getString("rel_add");
        tools.setTitle(subject);
        tools.setTitleTextColor(Color.WHITE);
        tools.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        setSupportActionBar(tools);
        tools.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        write_syllabus(path+file);

    }

    private void write_syllabus(String file) {
        String syll = "";
        BufferedReader bf=null;
        //Toast.makeText(this,getAssets().toString(),Toast.LENGTH_SHORT).show();
        try{
                bf= new BufferedReader(new InputStreamReader(getAssets().open(file)));
            if (bf != null) {
                StringBuilder sb = new StringBuilder();
                String temp_syll = "";
                while ((temp_syll = bf.readLine()) != null) {
                    sb.append(temp_syll);
                    sb.append("\n");
                }
                syll=sb.toString();
            }
        }catch (FileNotFoundException fn){
            Toast.makeText(this,"File not found",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Toast.makeText(this,"IO is doomed",Toast.LENGTH_SHORT).show();
        } finally {
            if (bf!= null){
                try{
                    bf.close();
                } catch (IOException e) {
                    Toast.makeText(this,"IO is doomed",Toast.LENGTH_SHORT).show();
                }
            }
        }
        tv.setText(syll);
    }

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
}
