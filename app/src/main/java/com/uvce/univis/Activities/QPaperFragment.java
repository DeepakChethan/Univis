package com.uvce.univis.Activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.uvce.univis.R;
import com.uvce.univis.Resources.Branch;
import com.uvce.univis.Resources.CIVIL;
import com.uvce.univis.Resources.CSE;
import com.uvce.univis.Resources.ECE;
import com.uvce.univis.Resources.EEE;
import com.uvce.univis.Resources.MECH;
import com.uvce.univis.Resources.Semester;
import com.uvce.univis.Resources.Subject;
import com.uvce.univis.Resources.Syllabus;
import com.uvce.univis.Resources.QPaperLab;

import java.util.ArrayList;

public class QPaperFragment extends Fragment {

    private android.support.v7.widget.GridLayout gl;
    private CardView cv;
    private TextView tv;

    public QPaperLab mQPaperLab;



    public QPaperFragment() {
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mQPaperLab = QPaperLab.get(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int i;
        int courseNo = 0;
        int semesterNo = 1;

        Branch mBranch = mQPaperLab.getCourse(0);
        Semester mSemester = (CSE.SEM3)((CSE)mBranch).getSemester(semesterNo);
        ArrayList<Subject> mSubjects = mSemester.getSubjects();

        WindowManager wm=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        int width=display.getWidth();
        int height=display.getHeight();
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);
        gl=(android.support.v7.widget.GridLayout)view.findViewById(R.id.gridLayout);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("sub_info", Context.MODE_PRIVATE);

        String course = sharedPreferences.getString("course","");
        semesterNo = sharedPreferences.getInt("sem", 0)-'0';
        Log.i("semester No", "" + semesterNo);

        switch(course) {
            case "ISE":

            case "CSE":
                courseNo = 0;
                mBranch = (CSE)mQPaperLab.getCourse(courseNo);
                break;

            case  "ECE":
                courseNo = 1;
                mBranch = (ECE) mQPaperLab.getCourse(courseNo);
                break;

            case "EEE":
                courseNo = 2;
                mBranch =  (EEE)mQPaperLab.getCourse(courseNo);
                break;

            case "MECH":
                courseNo = 3;
                mBranch = (MECH) mQPaperLab.getCourse(courseNo);
                break;
            case "CIVIL":
                courseNo = 4;
                mBranch = (CIVIL) mQPaperLab.getCourse(courseNo);
                break;
            default: break;
        }


        mSemester =  mBranch.getSemester(semesterNo);
        mSubjects = mSemester.getSubjects();






        //Toast.makeText(getContext(),pope+"",Toast.LENGTH_SHORT).show();


        // its 18 because the margin value is 8+8+8+8 and padding
        int x=(width/2)-(int)(18*getResources().getDisplayMetrics().density);
        int y=(height/4);

        for (i = 0; i < mSubjects.size() ; ++i){

            //Making cards to make it look pretty
            cv = new CardView(getContext());
            //Making textView and putting it on Cardview
            tv = new TextView(getContext());

            final Subject subject = mSubjects.get(i);

            tv.setText(subject.getSubjectName());

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
            }
            else cv.setMaxCardElevation(8);
            cv.setRadius(4);
            // Setting up the onClick listener to the card

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(subject.getUri()));
                    startActivity(i);
                }
            });

            gl.addView(cv);
        }

        return view;
    }

}


