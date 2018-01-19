package com.uvce.univis.Resources;

import java.util.UUID;

/**
 * Created by sagar on 1/11/18.
 */

public class QPaper {

    private static final String TAG = "QPaper";

    private UUID mId;
    private String mBranch;
    private String mTitle;
    private String mYear, mMonth;
    private String mCode;
    private String mLocation;



    public void QPaper(String branchName, String title, String year, String month, String code, String location) {
        mId = UUID.randomUUID();
        mBranch = branchName;
        mTitle = title;
        mYear = year;
        mMonth = month;
        mCode = code;
        mLocation = location;
    }


}
