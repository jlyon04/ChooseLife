package com.example.chooselife;

import java.util.ArrayList;
import java.util.Random;

public class class_Helper {
    public static String tint = "intelligence";
    public static String tluck = "luck";
    public static String tcour = "courage";
    public static String tchar = "charisma";
    public static String tdev = "deviance";
    public static String tbiz = "bizarre";
    public static String tath = "athleticism";

    class_Trait[] quick_add(String trait1, String trait2)
    {
        Random rand = new Random();
        int rand_int1, rand_int2;
        rand_int1 = rand.nextInt(5) + 1;
        rand_int2 = rand.nextInt(5) + 1;
        return new class_Trait[]{new class_Trait(trait1, rand_int1), new class_Trait(trait2, rand_int2)};
    }
    class_Trait[] quick_add(String trait1, String trait2, int neg1)
    {
        Random rand = new Random();
        int rand_int1, rand_int2;
        rand_int1 = rand.nextInt(5) + 1;
        rand_int2 = rand.nextInt(5) - 6;
        return new class_Trait[]{new class_Trait(trait1, rand_int1), new class_Trait(trait2, rand_int2)};
    }
    class_Trait[] quick_add(String trait1, int neg1, String trait2, int neg2)
    {
        Random rand = new Random();
        int rand_int1, rand_int2;
        rand_int1 = rand.nextInt(5) - 6;
        rand_int2 = rand.nextInt(5) - 6;
        return new class_Trait[]{new class_Trait(trait1, rand_int1), new class_Trait(trait2, rand_int2)};
    }

    class_Trait[] future_trait_array(String t1, int val1, String t2, int val2){
        return new class_Trait[]{ new class_Trait(t1, val1), new class_Trait(t2, val2)};
    }
    class_Trait[] future_trait_array(String t1, int val1, String t2, int val2, String t3, int val3){
        return new class_Trait[]{ new class_Trait(t1, val1), new class_Trait(t2, val2), new class_Trait(t3, val3)};
    }

    public static class_ReadMe[] readme_array = {
            new class_ReadMe("start", "Welcome to life where your answers will determine your outcome. Answer the multiple choice questions to avoid death and earn glory. In between each question there is a small chance for an event, many times this will mean your " +
                    "death but in very rare circumstance it may launch a secret event. Good luck and good life.")
    };

    // Array of Stage 1 Questions
    public class_TraitQuestion[] stage1_questions = {
            new class_TraitQuestion("Tired from a long day of napping and crying, your infant self has finally made it to dinner. On the menu is.",
                    new class_TraitAnswer("Carrots",         quick_add(tath, tint)),
                    new class_TraitAnswer("Sweet Potato",    quick_add(tcour, tint, 1)),
                    new class_TraitAnswer("Apple",           quick_add(tath, tluck, 1)),
                    new class_TraitAnswer("Banana",          quick_add(tint, tluck))),
            new class_TraitQuestion("Your aunt Clara has decided to pick you up, pulling you away from your favorite spot on the kitchen floor right where the linoleum bubbles so that you can poke it with your tiny finger",
                    new class_TraitAnswer("Cry",                    quick_add(tint, tcour, 1)),
                    new class_TraitAnswer("Give Angry Look",        quick_add(tcour, tdev)),
                    new class_TraitAnswer("Reach for Mama",         quick_add(tchar, tint)),
                    new class_TraitAnswer("Force a bowel movement", quick_add(tath, tbiz))),
            new class_TraitQuestion("You have been put down to sleep in your crib by the Overlord that calls himself Dad, while lying down you quickly catch a glimpse of a spider crawling across your bed ",
                    new class_TraitAnswer("Squish it",                  quick_add(tath, tdev)),
                    new class_TraitAnswer("Quickly Brush it off",       quick_add(tluck, tint)),
                    new class_TraitAnswer("Put hand down to greet it",  quick_add(tchar, tdev, 1)),
                    new class_TraitAnswer("Eat it",                     quick_add(tbiz, tdev)))

            /*
            new class_TraitQuestion(" ",
                    new class_TraitAnswer("",          quick_add(t, t)),
                    new class_TraitAnswer("",          quick_add(t, t)),
                    new class_TraitAnswer("",          quick_add(t, t)),
                    new class_TraitAnswer("",          quick_add(t, t))),
            */
    };
    public class_TraitQuestion[] stage2_questions = {
            new class_TraitQuestion("You have entered the age of daycare, Welcome. On a day like any other you sit quiet and happy playing in a sandbox when Dale the oversized freckled toddler takes the shovel right from your hand.",
                    new class_TraitAnswer("Tell Dale you can share",          quick_add(tchar, tint)),
                    new class_TraitAnswer("Cry, getting Dale in trouble",          quick_add(tint, tcour, 1)),
                    new class_TraitAnswer("Push Dale and Reclaim your Shovel",          quick_add(tdev, tcour)),
                    new class_TraitAnswer("Lie, Tell Dale the Shovel is cursed",          quick_add(tdev, tint)))
    };

    public class_TraitQuestion[] stage3_questions = {
            new class_TraitQuestion("Middle School gym class, oh what a joy. Your Teacher lets you decide on what activity to participate in.",
                    new class_TraitAnswer("Basketball",          quick_add(tchar, tath)),
                    new class_TraitAnswer("Board Games",          quick_add(tint, tath, 1)),
                    new class_TraitAnswer("Fake an Illness",          quick_add(tint, tdev)),
                    new class_TraitAnswer("Skip and Smoke",          quick_add(tdev, tint, 1)))
    };

    public class_TraitQuestion get_stage4_question() {
        return new class_TraitQuestion("You have fallen for your first crush.",
                new class_TraitAnswer("Chase the girl", "Girl"),
                new class_TraitAnswer("Focus on School", "No Girl", quick_add(tint, tint)),
                new class_TraitAnswer("Focus on Athletics", "No Girl", quick_add(tath, tath)),
                new class_TraitAnswer("Focus on Social", "No Girl", quick_add(tchar, tchar)));
    }

    public class_TraitQuestion get_stage5_question(String question_string, String taken_skill) {
        ArrayList<String> skill_array = get_skill_array();
        String opta, optb, optc, optd;
        Random rand = new Random();
        // -1??
        if (taken_skill != null){
            skill_array.remove(taken_skill);
        }
        //A
        int index = rand.nextInt(skill_array.size());
        opta = skill_array.get(index);
        skill_array.remove(index);
        //B
        index = rand.nextInt(skill_array.size());
        optb = skill_array.get(index);
        skill_array.remove(index);
        //C
        index = rand.nextInt(skill_array.size());
        optc = skill_array.get(index);
        skill_array.remove(index);
        //D
        index = rand.nextInt(skill_array.size());
        optd = skill_array.get(index);
        skill_array.remove(index);

        return new class_TraitQuestion(question_string,
                new class_TraitAnswer(opta, opta),
                new class_TraitAnswer(optb, optb),
                new class_TraitAnswer(optc, optc),
                new class_TraitAnswer(optd, optd));
    }

    public class_TraitQuestion get_stage6_question() {
        return new class_TraitQuestion("You Have Graduated High School.",
                new class_TraitAnswer("College",        "college"),
                new class_TraitAnswer("Trade School",   "trade", quick_add(tint, tint)),
                new class_TraitAnswer("Get A  Job",     "job", quick_add(tath, tath)),
                new class_TraitAnswer("Do Nothing",     "nothing", quick_add(tchar, tchar)));
    }

    public ArrayList<String> get_skill_array(){
        ArrayList<String> skills = new ArrayList<String>() {
            {
                add("Art"); add("Combat"); add("Lock Pick"); add("Crafting"); add("First Aid");
                add("Diplomacy"); add("Computer"); add("Sales"); add("Speed"); add("Strength");
                add("Investigative"); add("Gambling");
            }
        };
        return skills;
    }

    public class_TraitQuestion get_stage7_question(String love, String taken_skill){
        class_TraitQuestion ret_que = new class_TraitQuestion();
        if (love.equals("true")){
           return get_stage5_question("You have just married the love of your life, " +
                   "you return from the honey moon and decide to start a hobby before your future is set", taken_skill);
        }
        ArrayList<String> skill_array = get_skill_array();
        String optb, optc, optd;
        Random rand = new Random();
        if (taken_skill != null){
            skill_array.remove(taken_skill);
        }
        //B
        int index = rand.nextInt(skill_array.size());
        optb = skill_array.get(index);
        skill_array.remove(index);
        //C
        index = rand.nextInt(skill_array.size());
        optc = skill_array.get(index);
        skill_array.remove(index);
        //D
        index = rand.nextInt(skill_array.size());
        optd = skill_array.get(index);
        skill_array.remove(index);

        return new class_TraitQuestion("You are preparing for your future but the dating life " +
                "has not been so great, your friend would like to set you up with a blind date",
                new class_TraitAnswer("Take your 2nd Chance at love", "love"),
                new class_TraitAnswer("Deny Love focus on : "+optb, optb),
                new class_TraitAnswer("Stay alone and start a new hobby : "+optc, optc),
                new class_TraitAnswer("Seriously Last Chance but no try : "+optd, optd));
    }

    public String get_crime()
    {
        String[] crime_array = {"Rob a bank", "Rob a gas station", "Start Pyramid scheme", "Steal Rich Mans Identity"};
        Random rand = new Random();
        int index = rand.nextInt(crime_array.length);
        return crime_array[index];
    }

    public class_TraitQuestion get_stage8_question(String love) {
        String crime = get_crime();
        if (love.equals("true")) {
            return new class_TraitQuestion("You are married and ready to start your family, choose your assortment of family.",
                    new class_TraitAnswer("0 Children", "0"),
                    new class_TraitAnswer("1 Child", "1"),
                    new class_TraitAnswer("2 Children", "2"),
                    new class_TraitAnswer("No kids, Bonnie and Clyde", crime));
        }
        return new class_TraitQuestion("You are single and lonely, you want to fill this bottomless whole in your life.",
                new class_TraitAnswer("Adopt a Child", "1"),
                new class_TraitAnswer("Adopt Twins", "2"),
                new class_TraitAnswer("Live alone", "0"),
                new class_TraitAnswer(crime, crime));
    }

    public class_Future[] futureArray = {
        //new class_Future(null, null, null, null, null, null, null, null, null)
        new class_Future(0, "Firefighter", future_trait_array(tcour, 4, tdev, -3), null, new String[]{"job, trade, college"}, null, null, null,  null, new class_TraitQuestion[]{})
    };

    public class_TraitQuestion get_trait_question(int stage)
    {
        Random rand = new Random();
        int rare_num = rand.nextInt(105);
        class_TraitQuestion[] questions_array = {};
        ArrayList<class_TraitQuestion> local_array = new ArrayList<>();
        if (stage == 1)
            questions_array = stage1_questions;
        else if (stage == 2)
            questions_array = stage2_questions;
        else if (stage == 3)
            questions_array = stage3_questions;

        for (int i=0; i<questions_array.length; i++)
        {
            if (questions_array[i].getRarity() <= rare_num)
                local_array.add(questions_array[i]);
        }
        if (local_array.size() < 1)
        {
            rare_num = rand.nextInt(questions_array.length);
            return questions_array[rare_num];
        }
        rare_num = rand.nextInt(local_array.size());
        return local_array.get(rare_num);
    }

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
