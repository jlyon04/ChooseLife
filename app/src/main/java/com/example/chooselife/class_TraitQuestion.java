package com.example.chooselife;

public class class_TraitQuestion {
    private int rarity;
    private String question;
    private class_TraitAnswer opta, optb, optc, optd;


    public class_TraitQuestion(int rare, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od)
    {
        rarity = rare;
        question = q;
        opta = oa;
        optb = ob;
        optc = oc;
        optd = od;
    }
    public class_TraitQuestion(String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od)
    {
        rarity = 0;
        question = q;
        opta = oa;
        optb = ob;
        optc = oc;
        optd = od;
    }
    public class_TraitQuestion()
    {
        rarity = 0;
        question = "";
        opta = new class_TraitAnswer();
    }

    public String getQuestion() {return question;}
    public class_TraitAnswer getOptA() { return opta;}
    public class_TraitAnswer getOptB() { return optb;}
    public class_TraitAnswer getOptC() {return optc;}
    public class_TraitAnswer getOptD() {return optd;}
    public int getRarity(){return rarity;}
}
