package com.uvce.univis.Resources;

import android.content.Context;

import com.uvce.univis.R;

/**
 * Created by sagar on 1/11/18.
 */

public  class Branch {

    public String mBranchName;

    public String mBaseUrl ;

    public Context mAppContext;

    CSE.SEM1_2 mSem1_2;

    CSE.SEM3 mSem3;

    CSE.SEM4 mSem4;

    CSE.SEM5 mSem5;

    CSE.SEM6 mSem6;

    CSE.SEM7 mSem7;

    CSE.SEM8 mSem8;

    Branch(Context context, String branchName) {
        this.mBranchName = branchName;
        this.mAppContext = context;
        this.mBaseUrl = mAppContext.getResources().getString(R.string.base_url);
    }

    public Semester getSemester(int semNo) {

        switch(semNo) {
            case 0: return (CSE.SEM1_2) mSem1_2;
            case 1: return (CSE.SEM3) mSem3;
            case 2: return (CSE.SEM4) mSem4;
            case 3: return (CSE.SEM5) mSem5;
            case 4: return (CSE.SEM6) mSem6;
            case 5: return (CSE.SEM7) mSem7;
            case 6: return (CSE.SEM8) mSem8;
            default: return (CSE.SEM3) mSem3;
        }

    }



}
