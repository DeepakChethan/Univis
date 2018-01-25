package com.uvce.univis.Resources;

import android.content.Context;

/**
 * Created by sagar on 1/11/18.
 */

public class QPaperLab {
    CSE cse;
    ECE ece;
    EEE eee;
    MECH mech;
    CIVIL civil;

    private static QPaperLab sPaperLab;
    private static SemesterHelper mSemesterHelper;

    Context mAppContext;

    private QPaperLab(Context appContext) {
        mAppContext = appContext;

        cse = new CSE(mAppContext);

        ece = new ECE(mAppContext);

        eee = new EEE(mAppContext);

        mech = new MECH(mAppContext);

        civil = new CIVIL(mAppContext);

    }

    public Branch getCourse(int index) {
        switch(index) {
            case 0: return (CSE) cse;
            case 1: return (ECE) ece;
            case 2: return  (EEE) eee;
            case 4: return (MECH) mech;
            case 5: return (CIVIL) civil;
            default: return (CSE) cse;
        }
    }

    public static QPaperLab get(Context c) {
        if(sPaperLab == null ) {
            sPaperLab = new QPaperLab(c);
        }
        return sPaperLab;
    }






}
