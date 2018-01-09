package com.uvce.univis.Activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import com.uvce.univis.Resources.Syllabus;
import com.uvce.univis.R;


public class SyllabusFragment extends Fragment {


    private GridLayout gl;
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
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);
        gl=(GridLayout)view.findViewById(R.id.gridLayout);
        String[] curr_sub_list=s.firstYearSubjects;
        final String[] curr_file_list=s.firstYearSubjects_files;
        for (i = 0; i < curr_sub_list.length ; ++i){
            cv = new CardView(getContext());
            tv = new TextView(getContext());
            tv.setText(curr_sub_list[i]);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
            cv.addView(tv);
            cv.setRadius(8);

            GridLayoutManager.LayoutParams params = new GridLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(16,0,16,16);
            cv.setLayoutParams(params);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cv.setElevation(8);
            }else cv.setMaxCardElevation(8);

            final int finalI = i;
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getContext(),SyllabusDisplay.class);
                    in.putExtra("file",curr_file_list[finalI]);
                    startActivity(in);
                }
            });
            gl.addView(cv);
        }

        return view;
    }

}

