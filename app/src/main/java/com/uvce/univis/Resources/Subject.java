package com.uvce.univis.Resources;

import java.util.ArrayList;

/**
 * Created by sagar on 1/11/18.
 */




    public class Subject {

       String mSubjectName;
        String mUri;

        public Subject(String mSubjectName, String uri) {
            this.mSubjectName = mSubjectName;
            this.mUri = uri;
        }

    public String getSubjectName() {
        return mSubjectName;
    }
    public String getUri() {
            return mUri;
    }
}



