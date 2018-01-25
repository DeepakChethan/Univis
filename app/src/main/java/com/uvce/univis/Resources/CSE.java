package com.uvce.univis.Resources;

import android.content.Context;
import android.content.res.Resources;

import com.uvce.univis.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sagar on 1/11/18.
 */

public class CSE extends Branch {








    CSE(Context context) {

        super(context,"Computer Science & Engineering");
        mAppContext = context;

        mSem1_2 = new SEM1_2();

        mSem3 = new SEM3();

        mSem4 = new SEM4();

        mSem5 = new SEM5();

        mSem6 = new SEM6();

        mSem7 = new SEM7();

        mSem8 = new SEM8();
    }










    public class SEM3 extends Semester {

        public static final int SEMESTER_NO = 3;
        // defining all the Subject names as String constants

        public static final String ENGINEERING_MATHEMATICS_3 = "Engineering Mathematics-3";
        public static final String DATA_STRUCTURES_WITH_C = "Data Structures With C";
        public static final String DIGITAL_SYSTEM_DESIGN = "Digital System Design";
        public static final String DISCRETE_MATHEMATICAL_STRUCTURES = "Discrete Mathematical Structures";
        public static final String ELECTRONIC_CIRCUITS = "Electronic Circuits";
        public static final String OBJECT_ORIENTED_PROGRAMMING_WITH_CPP = "Object Oriented Programming With C++";

        public static final int THEORY_SUBJECTS_NO = 6;

        public String[] mUrlList = mAppContext.getResources().getStringArray(R.array.cse_third_sem);

        public String[] mQSubjectNames = {

                ENGINEERING_MATHEMATICS_3,
                DATA_STRUCTURES_WITH_C,
                DIGITAL_SYSTEM_DESIGN,
                DISCRETE_MATHEMATICAL_STRUCTURES,
                ELECTRONIC_CIRCUITS,
                OBJECT_ORIENTED_PROGRAMMING_WITH_CPP
        };




        /*  subjects is an ArrayList which contains objects of class 'Subject'.
         *  Each "Subject" object will have subjectName as String and an ArrayList that contains associated Question papers;
        */


        //    mQpaper is an array of ArrayList where each ArrayList stores the set of question papers for each subject
        public String[] mQpaper;




        void setUpQuestionPaper(int index) {

            mQpaper[index] = new String(mBaseUrl+mUrlList[index]);

        }

         SEM3() {


             //initialize the subjects ArrayList
            subjects = new ArrayList<Subject>();
            //initialize the mQpaper as an array of ArrayList

            mQpaper = new String[THEORY_SUBJECTS_NO];


            for(int i = 0; i < THEORY_SUBJECTS_NO; i++) {

                //initialize each array element as an ArrayList of Question Paper
                setUpQuestionPaper(i);

            }


            for(int i = 0; i < THEORY_SUBJECTS_NO; i++) {
                subjects.add(i, new Subject(mQSubjectNames[i], mQpaper[i]));
            }

        }

    }

    class SEM1_2 extends Semester{

        public static final String MATHEMATICS1 = "Engineering Mathematics-1";
        public static final String ENGINEERING_MECHANICS = "Engineering Mechanics";
        public static final String ELECTRICAL_SCIENCE = "Electrical Science";
        public static final String ENGINEERING_CHEMISTRY = "Engineering Chemistry";
        public static final String ENGINEERING_PHYSICS = "Engineering Physics";
        public static final String BASIC_ELECTRONICS = "Basic Electronics";
        public static final String ENGINEERING_PHYSICS_LAB = "Engineering Physics Lab";
        public static final String ENGINEERING_CHEMISTRY_LAB = "Engineering Chemistry Lab";
        public static final String PROGRAMMING_WITH_C = "Programming With C";
        public static final String C_PROGRAMMING_LAB = "C Programming Lab";
        public static final String MES = "Mes";
        public static final String WORK_SHOP_PRACTICE = "WorkShop Practice";
        public static final String ELECTRICAL_DRAWING = "Electrical Drawing";
        public static final String ENGINEERING_MATHEMATICS_2 = "Engineering Mathematics-2";
        public static final String ENGINEERING_DRAWING = "Engineering Drawing";






    }

    class SEM4 extends Semester {

        public static final String ENGINEERING_MATHEMATICS_4 = "Engineering Mathematics-4";
        public static final String MICROPROCESSORS = "Microprocessors";
        public static final String COMPUTER_ORGANISATION = "Computer Organisation And Architecture";
        public static final String DESIGN_AND_ANALYSIS_OF_ALGORITHMS = "Design And Analysis Of Algorithms";
        public static final String FINITE_AUTOMATA_AND_FORMAL_LANGUAGE = "Finite Automata And Formal Languages";
        public static final String JAVA_AND_INTERNET_PROGRAMMING = "Java and Internet Programming";
        public static final String MICROPROCESSOR_LAB = "Microprocessors Lab";
        public static final String ALGORITHM_LAB_USING_CPP = "Algorithms Lab Using C++";

    }

    class SEM5 extends Semester {

        public static final String DATABASE_MANAGEMENT_SYSTEM= "Database Management System";
        public static final String OPERATING_SYSTEM = "Operating System";
        public static final String COMPUTER_NETWORKS_1 = "Computer Networks-1";
        public static final String SOFTWARE_ENGINEERING_AND_TESTING = "Software Engineering And Testing";
        public static final String COMPUTER_GRAPHICS = "Computer Graphics";
        public static final String OPERATION_RESEARCH = "Operational Research";
        public static final String COMPUTER_GRAPHICS_LAB = "Computer Graphics Lab";
        public static final String JAVA_PROGRAMMING_LAB = "Java Programming Lab";

    }

    class SEM6 extends Semester{

        public static final String COMPUTER_NETWORKS_2 = "Computer Networks-2";
        public static final String PROBABILITY_AND_STOCHASTIC_PROCESS = "Probability And Stochastic Process";
        public static final String SYSTEM_SOFTWARE = "System Software";
        public static final String UNIX_SYSTEM_PROGRAMMING = "Unix System Programming";
        public static final String ARTIFICIAL_INTELLIGENCE = "Artificial Intelligence And Machine Learning";
        public static final String DATA_MINING = "Data Mining";
        public static final String UNIX_AND_SYSTEM_SOFTWARE_LAB = "Unix And System Software Lab";
        public static final String DBMS_LAB = "DBMS Lab";

    }

    class SEM7 extends Semester{
        public String[] CSE7={"Advanced Computer Architecture","Soft Computing","Cryptography and Network Security","Simulation and Modelling",
                "Networking laboratory","IP lab","Project"};
        public static final String ADVANCED_COMPUTER_ARCHITECTURE = "Advanced Computer Architecture";
        public static final String SOFT_COMPUTING = "Soft Computing";
        public static final String CRYPTOGRAPHY_AND_NETWORK_SECURITY = "Cryptography and Network Security";
        public static final String SIMULATION_AND_MODELING = "Simulation and Modeling";
        public static final String NETWORKING_LABORATORY = "Networking Laboratory";
        public static final String IP_LAB = "IP Lab";
        public static final String PROJECT = "Project";

    }

    class SEM8 extends Semester{

        public String[] CSE8={"Compiler Design","Distributed Operating System","Mobile Computing","Wireless Sensor Networks","C# laboratory","Project"};
        public static final String COMPILER_DESIGN = "Compiler Design";
        public static final String DISTRIBUTED_OS = "Distributed Operating System";
        public static final String MOBILE_COMPUTING = "Mobile Computing";
        public static final String WIRELESS_SENSOR_NETWORKS = "Wireless Sensor Networks";
        public static final String C_SHARP_LABORATORY = "C# Laboratory";
        public static final String PROJECT = "Project";

    }


}
