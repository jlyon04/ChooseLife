package com.example.chooselife;

public class class_GameStats {
    private class_Trait[] trait_array;
    private boolean girl;
    private String after_school;
    private boolean marriage;
    private int kids;

    public class_GameStats(class_Trait[] t_trait_array){
        trait_array = t_trait_array;
    }

    public class_Trait[] getTraitArray(){return trait_array;}

    public void addToTrait(int index, int value){trait_array[index].addValue(value);}

    public class_Trait getTrait(int index){return trait_array[index];}

    public void set_girl(boolean choice){girl = choice;}
    public void set_marriage(boolean choice){marriage = choice;}
    public void set_kids(int choice){kids = choice;}
    public void set_after_school(String choice){after_school = choice;}
    public String get_after_school(){return after_school;}
    public boolean get_girl(){return girl;}

}
