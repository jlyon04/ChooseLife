package com.example.chooselife;

public class class_GameStats {
    private class_Trait[] trait_array;
    private String after_school;
    private boolean love;
    private boolean kids;

    public class_GameStats(class_Trait[] t_trait_array){
        trait_array = t_trait_array;
    }

    public class_Trait[] getTraitArray(){return trait_array;}
    public void addToTrait(int index, int value){
        trait_array[index].addValue(value);
    }

}
