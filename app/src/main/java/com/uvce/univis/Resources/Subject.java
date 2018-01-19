package com.uvce.univis.Resources;

import java.util.ArrayList;

/**
 * Created by sagar on 1/11/18.
 */




    public class Subject {

        public String mSubjectName;
        ArrayList<QPaper> mQPapers;

        public Subject(String mSubjectName, ArrayList<QPaper> mQPapers) {
            this.mSubjectName = mSubjectName;
            this.mQPapers = mQPapers;
        }

    }



