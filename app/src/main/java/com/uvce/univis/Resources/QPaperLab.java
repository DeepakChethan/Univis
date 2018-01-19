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
        cse = new CSE();
        setUpCse();
        ece = new ECE();
        setUpEce();
        eee = new EEE();
        setUpEee();
        mech = new MECH();
        setUpMech();
        civil = new CIVIL();
        setUpCivil();
    }

    public static QPaperLab get(Context c) {
        if(sPaperLab == null ) {
            sPaperLab = new QPaperLab(c.getApplicationContext());
        }
        return sPaperLab;
    }

    public void setUpCse() {
        CSE.SEM3 mSem3 = cse.new SEM3();
    }

    public void setUpEce() {

    }

    public void setUpEee() {

    }

    public void setUpMech() {

    }

    public void setUpCivil() {

    }




}
