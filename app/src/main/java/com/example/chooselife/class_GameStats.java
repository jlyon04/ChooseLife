package com.example.chooselife;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class class_GameStats {
    private class_Trait[] trait_array;
    private String love;
    private String after_school;
    private String kids;
    private  String skill_1;
    private String crime;
    private String outcome;

    public class_GameStats(class_Trait[] t_trait_array){
        trait_array = t_trait_array;
    }

    public void addToTrait(int index, int value){trait_array[index].addValue(value);}

    // Setters
    public void set_love(String choice){love = choice;}
    public void set_kids(String choice){kids = choice;}
    public void set_after_school(String choice){after_school = choice;}
    public void setSkill_1(String choice){skill_1 = choice;}
    public void setCrime(String choice){crime = choice;}
    public void setOutcome(String outcom){outcome = outcom;}



    // Getters
    public String get_after_school(){return after_school;}
    public String get_love(){return love;}
    public String getSkill_1(){return skill_1;}
    public String getCrime(){return crime;}
    public String getKids(){return kids;}
    public class_Trait[] getTrait_array(){return trait_array;}
    public class_Trait getTrait(int index){return trait_array[index];}

}
