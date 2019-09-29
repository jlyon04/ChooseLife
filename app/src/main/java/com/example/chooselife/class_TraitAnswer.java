package com.example.chooselife;

public class class_TraitAnswer {
    private String text;
    private class_Trait[] trait_array;

    public class_TraitAnswer(String txt, class_Trait[] array)
    {
        text = txt;
        trait_array = array;
    }


    public String getText(){return text;}

    public class_Trait[] getTraitArray(){return trait_array;}

    public class_Trait getTrait(int i){return trait_array[i];}
}
