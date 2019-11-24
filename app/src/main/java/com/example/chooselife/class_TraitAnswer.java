package com.example.chooselife;

import java.util.ArrayList;

public class class_TraitAnswer {
    private String text;
    private String life_choice;
    private class_Trait[] trait_array;
    private int storynum;
    private int readme_num;
    private String outcome;

    public class_TraitAnswer(String txt, class_Trait[] array)
    {
        text = txt;
        trait_array = array;
        life_choice = "";
        readme_num = 0;
    }
    public class_TraitAnswer(String txt, String lfe_chce, class_Trait[] array)
    {
        text = txt;
        trait_array = array;
        life_choice = lfe_chce;
        readme_num = 0;
    }
    public class_TraitAnswer(String txt, String lfe_chce)
    {
        text = txt;
        trait_array = new class_Trait[0];
        life_choice = lfe_chce;
        readme_num = 0;
    }
    public class_TraitAnswer(String txt, int stornum)
    {
        text = txt;
        storynum = stornum;
        readme_num = 0;
    }
    public class_TraitAnswer(String txt, int stornum, int readme_numV)
    {
        text = txt;
        storynum = stornum;
        readme_num = readme_numV;
    }
    public class_TraitAnswer(String txt, int stornum, int readme_numV, String outcomeV)
    {
        text = txt;
        storynum = stornum;
        readme_num = readme_numV;
        outcome = outcomeV;
    }
    public class_TraitAnswer()
    {
        text = "";
        trait_array = new class_Trait[0];
        life_choice = "";
        readme_num = 0;
        outcome = null;
    }


    public String getText(){return text;}
    public class_Trait[] getTraitArray(){return trait_array;}
    public class_Trait getTrait(int i){return trait_array[i];}
    public String get_Life_choice(){return life_choice;}
    public int getStorynum(){return storynum;}
    public String getOutcome(){return outcome;}
}

