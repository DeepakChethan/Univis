package com.uvce.univis.Activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uvce.univis.Resources.Syllabus;
import com.uvce.univis.R;


public class SyllabusFragment extends Fragment {


    private android.support.v7.widget.GridLayout gl;
    private CardView cv;
    private TextView tv;
    Syllabus s = new Syllabus();

    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int i;
        String[] curr_sub_list=s.firstYearSubjects;
        String[] curr_file_list=s.firstYearSubjects_files;
        String relative_address="first/";
        WindowManager wm=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        int width=display.getWidth();
        int height=display.getHeight();
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);
        gl=(android.support.v7.widget.GridLayout)view.findViewById(R.id.gridLayout);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("sub_info", Context.MODE_PRIVATE);
        String dope = sharedPreferences.getString("course","");
        int pope = sharedPreferences.getInt("sem", 0)-'0';
        //Toast.makeText(getContext(),pope+"",Toast.LENGTH_SHORT).show();
        if (pope != 1)
        switch (dope){
            case "ISE":
            case "CSE": relative_address="cse/";
                switch (pope){

                    case 3: curr_sub_list=s.CSE3;
                            curr_file_list=s.CSE3_files;
                            relative_address+="cse3/";
                            break;
                    case 4: curr_sub_list=s.CSE4;
                            curr_file_list=s.CSE4_files;
                             relative_address+="cse4/";
                            break;
                    case 5: curr_sub_list=s.CSE5;
                        curr_file_list=s.CSE5_files;
                        relative_address+="cse5/";
                        break;
                    case 6: curr_sub_list=s.CSE6;
                        curr_file_list=s.CSE6_files;
                        relative_address+="cse6/";
                        break;
                    case 7: curr_sub_list=s.CSE7;
                        curr_file_list=s.CSE7_files;
                        relative_address+="cse7/";
                        break;
                    case 8: curr_sub_list=s.CSE8;
                        curr_file_list=s.CSE8_files;
                        relative_address+="cse8/";
                        break;
                }break;
            case "CIVIL":
                    relative_address="civil/";
                switch (pope){
                    case 3: curr_sub_list=s.CIVIL3;
                        curr_file_list=s.CIVIL3_files;
                        relative_address+="civil3/";
                        break;
                    case 4: curr_sub_list=s.CIVIL4;
                        curr_file_list=s.CIVIL4_files;
                        relative_address+="civil4/";
                        break;
                    case 5: curr_sub_list=s.CIVIL5;
                        curr_file_list=s.CIVIL5_files;
                        relative_address+="civil5/";
                        break;
                    case 6: curr_sub_list=s.CIVIL6;
                        curr_file_list=s.CIVIL6_files;
                        relative_address+="civil6/";
                        break;
                    case 7:
                        curr_sub_list=s.CIVIL7;
                        curr_file_list=s.CIVIL7_files;
                        relative_address+="civil7/";
                        break;
                    case 8: curr_sub_list=s.CIVIL8;
                        curr_file_list=s.CIVIL8_files;
                        relative_address+="civil8/";
                        break;
                }break;
            case "MECH":
                relative_address="mech/";
                switch (pope){
                    case 3: curr_sub_list=s.MECH3;
                        curr_file_list=s.MECH3_files;
                        relative_address+="mech3/";
                        break;
                    case 4: curr_sub_list=s.MECH4;
                        curr_file_list=s.MECH4_files;
                        relative_address+="mech4/";
                        break;
                    case 5: curr_sub_list=s.MECH5;
                        curr_file_list=s.MECH5_files;
                        relative_address+="mech5/";
                        break;
                    case 6: curr_sub_list=s.MECH6;
                        curr_file_list=s.MECH6_files;
                        relative_address+="mech6/";
                        break;
                    case 7: curr_sub_list=s.MECH7;
                        curr_file_list=s.MECH7_files;
                        relative_address+="mech7/";
                        break;
                    case 8: curr_sub_list=s.MECH8;
                        curr_file_list=s.MECH8_files;
                        relative_address+="mech8/";
                        break;
                }break;
            case "EEE":
                relative_address="eee/";
                switch (pope){
                    case 3: curr_sub_list=s.EEE3;
                        curr_file_list=s.EEE3_files;
                        relative_address+="eee3/";
                        break;
                    case 4: curr_sub_list=s.EEE4;
                        curr_file_list=s.EEE4_files;
                        relative_address+="eee4/";
                        break;
                    case 5: curr_sub_list=s.EEE5;
                        curr_file_list=s.EEE5_files;
                        relative_address+="eee5/";
                        break;
                    case 6: curr_sub_list=s.EEE6;
                        curr_file_list=s.EEE6_files;
                        relative_address+="eee6/";
                        break;
                    case 7: curr_sub_list=s.EEE7;
                        curr_file_list=s.EEE7_files;
                        relative_address+="eee7/";
                        break;
                    case 8: curr_sub_list=s.EEE8;
                        curr_file_list=s.EEE8_files;
                        relative_address+="eee8/";
                        break;
                }break;
            case "ECE":
                relative_address="ece/";
                switch (pope){
                    case 3: curr_sub_list=s.ECE3;
                        curr_file_list=s.ECE3_files;
                        relative_address+="ece3/";
                        break;
                    case 4: curr_sub_list=s.ECE4;
                        curr_file_list=s.ECE4_files;
                        relative_address+="ece4/";
                        break;
                    case 5: curr_sub_list=s.ECE5;
                        curr_file_list=s.ECE5_files;
                        relative_address+="ece5/";
                        break;
                    case 6: curr_sub_list=s.ECE6;
                        curr_file_list=s.ECE6_files;
                        relative_address+="ece6/";
                        break;
                    case 7: curr_sub_list=s.ECE7;
                        curr_file_list=s.ECE7_files;
                        relative_address+="ece7/";
                        break;
                    case 8: curr_sub_list=s.ECE8;
                        curr_file_list=s.ECE8_files;
                        relative_address+="ece8/";
                        break;
                }break;
            case "OTH":
                relative_address="oth/";
                curr_sub_list=s.OTH;
                curr_file_list=s.OTH_files;
                break;
            
        }
        // its 18 because the margin value is 8+8+8+8 and padding
        int x=(width/2)-(int)(18*getResources().getDisplayMetrics().density);
        int y=(height/4);

        for (i = 0; i < curr_sub_list.length ; ++i){

            //Making cards to make it look pretty
            cv = new CardView(getContext());
            //Making textView and putting it on Cardview
            tv = new TextView(getContext());
            tv.setText(curr_sub_list[i]);
            tv.setTextAppearance(getContext(),android.R.style.TextAppearance_Medium);

            tv.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
            cv.addView(tv);
            // Making a good looking grid to display the cards


            android.support.v7.widget.GridLayoutManager.LayoutParams params = new GridLayoutManager.LayoutParams(x,y);
            params.setMargins(8,8,8,8);
            cv.setLayoutParams(params);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cv.setElevation(8);
            }else cv.setMaxCardElevation(8);
            cv.setRadius(4);
            // Setting up the onClick listener to the card
            final int finalI = i;   // Final int can only be used as an index
            final String[] ding = curr_sub_list;
            final String[] dong = curr_file_list;
            final String rel_add= relative_address;

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getContext(),SyllabusDisplay.class);
                    in.putExtra("file_name",dong[finalI]);
                    in.putExtra("sub_name",ding[finalI]);
                    in.putExtra("rel_add",rel_add);
                    startActivity(in);
                }
            });

            gl.addView(cv);
        }

        return view;
    }

}

