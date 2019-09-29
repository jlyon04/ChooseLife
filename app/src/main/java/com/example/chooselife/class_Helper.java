package com.example.chooselife;

public class class_Helper {

    public static class_ReadMe[] readme_array = {
            new class_ReadMe("start", "Welcome to life where your answers will determine your outcome. Answer the multiple choice questions to avoid death and earn glory. In between each question there is a small chance for an event, many times this will mean your " +
                    "death but in very rare circumstance it may launch a secret event. Good luck and good life.")
    };

    // Array of Stage 1 Questions
    public static class_TraitQuestion[] stage1_questions = {
            new class_TraitQuestion()
    };

    public String get_ReadMe(String t_title)
    {
        for (int i=0; i<readme_array.length; i++)
        {
            if (readme_array[i].getTitle() == t_title){
                return  readme_array[i].getText();
            }
        }
        return "Failed to Retrieve ReadMe";
    }

}
