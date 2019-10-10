package com.example.chooselife;

public class class_TraitAnswer {
    private String text;
    private String life_choice;
    private class_Trait[] trait_array;

    public class_TraitAnswer(String txt, class_Trait[] array)
    {
        text = txt;
        trait_array = array;
    }
    public class_TraitAnswer(String txt, String lfe_chce, class_Trait[] array)
    {
        text = txt;
        trait_array = array;
        life_choice = lfe_chce;
    }
    public class_TraitAnswer(String txt, String lfe_chce)
    {
        text = txt;
        life_choice = lfe_chce;
    }
    public class_TraitAnswer()
    {
        text = "";
        trait_array = new class_Trait[7];
        life_choice = "";
    }


    public String getText(){return text;}

    public class_Trait[] getTraitArray(){return trait_array;}

    public class_Trait getTrait(int i){return trait_array[i];}

    public String get_Life_choice(){return life_choice;}
}
