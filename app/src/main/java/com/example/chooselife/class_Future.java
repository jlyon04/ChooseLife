package com.example.chooselife;

import java.util.concurrent.Future;

public class class_Future {
    public int rare;
    public String title;
    public class_Trait[] trait_array;
    public String love;
    public String[] after_school;
    public String kids;
    public String skill_1;
    public String skill_2;
    public String crime;
    public class_TraitQuestion[] story;


    public class_Future(){
        rare = 0;
        title = null;
        trait_array = null;
        love = null;
        after_school = null;
        kids = null;
        skill_1 = null;
        skill_2 = null;
        crime = null;
        story = null;
    }


    public class_Future(int rar, String titl, class_Trait[] ta, String vlove, String[] after, String kds, String sk1, String sk2,
                  String crm, class_TraitQuestion[] stry){
        rare = rar;
        title = titl;
        trait_array = ta;
        love = vlove;
        after_school = after;
        kids = kds;
        skill_1 = sk1;
        skill_2 = sk2;
        crime = crm;
        story = stry;
    }

}
