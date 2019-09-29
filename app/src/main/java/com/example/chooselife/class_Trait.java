package com.example.chooselife;

public class class_Trait {
    private String title;
    private int value;

    public class_Trait(String aTitle, int aValue){
        title = aTitle;
        value = aValue;
    }
    public class_Trait()
    {
        title = "";
        value = 0;
    }

    public class_Trait[] new_array()
    {
        class_Trait[] return_array = new class_Trait[7];
        return_array[0] = new class_Trait("intelligence", 0);
        return_array[1] = new class_Trait("luck", 0);
        return_array[2] = new class_Trait("courage", 0);
        return_array[3] = new class_Trait("charisma", 0);
        return_array[4] = new class_Trait("deviance", 0);
        return_array[5] = new class_Trait("bizarre", 0);
        return_array[6] = new class_Trait("athleticism", 0);

        return return_array;
    }

    public String getTitle() {return title;}
    public int getValue() {return value;}
    public int addValue(int addition){ return value = value + addition;}
}
