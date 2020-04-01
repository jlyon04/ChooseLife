package com.example.chooselife;

import java.util.ArrayList;
import java.util.Random;

public class class_Helper {
    private static String tint = "intelligence";
    private static String tluck = "luck";
    private static String tcour = "courage";
    private static String tchar = "charisma";
    private static String tmor = "morality";
    private static String tbiz = "bizarre";
    private static String tath = "athleticism";
    private Random rand = new Random();

    private class_Trait[] quick_add(String trait1, String trait2) {
        int rand_int1 = rand.nextInt(5) + 1;
        int rand_int2 = rand.nextInt(5) + 1;
        return new class_Trait[]{new class_Trait(trait1, rand_int1), new class_Trait(trait2, rand_int2)};
    }

    private class_Trait[] quick_add(String trait1, String trait2, int neg1) {
        int rand_int1 = rand.nextInt(5) + 1;
        int rand_int2 = rand.nextInt(5) - 6;
        return new class_Trait[]{new class_Trait(trait1, rand_int1), new class_Trait(trait2, rand_int2)};
    }

    private class_Trait[] quick_add(String trait1, int neg1, String trait2, int neg2) {
        int rand_int1 = rand.nextInt(5) - 6;
        int rand_int2 = rand.nextInt(5) - 6;
        return new class_Trait[]{new class_Trait(trait1, rand_int1), new class_Trait(trait2, rand_int2)};
    }

    // 1. Stage 1
    private class_TraitQuestion get_stage1_question() {
        class_TraitQuestion[] stage_1_questions = {
            new class_TraitQuestion("Tired from a long day of napping and crying, your infant self has finally made it to dinner. On the menu is.",
                new class_TraitAnswer("Carrots", quick_add(tath, tint)),
                new class_TraitAnswer("Sweet Potato", quick_add(tcour, tint, 1)),
                new class_TraitAnswer("Apple", quick_add(tath, tluck, 1)),
                new class_TraitAnswer("Banana", quick_add(tint, tluck))),
            new class_TraitQuestion("Your aunt Clara has decided to pick you up, pulling you away from your favorite spot on the kitchen floor right where the linoleum bubbles so that you can poke it with your tiny finger",
                new class_TraitAnswer("Cry", quick_add(tint, tcour, 1)),
                new class_TraitAnswer("Give Angry Look", quick_add(tcour, tmor, 1)),
                new class_TraitAnswer("Reach for Mama", quick_add(tchar, tint)),
                new class_TraitAnswer("Force a bowel movement", quick_add(tath, tbiz))),
            new class_TraitQuestion("You have been put down to sleep in your crib by the Overlord that calls himself Dad, while lying down you quickly catch a glimpse of a spider crawling across your bed ",
                new class_TraitAnswer("Squish it", quick_add(tath, tmor, 1)),
                new class_TraitAnswer("Quickly Brush it off", quick_add(tluck, tint)),
                new class_TraitAnswer("Put hand down to greet it", quick_add(tchar, tmor)),
                new class_TraitAnswer("Eat it", quick_add(tbiz, tmor, 1)))
        };
        // Return Random
        return stage_1_questions[rand.nextInt(stage_1_questions.length - 1)];
    }

    // 2. Grade School
    public class_TraitQuestion get_stage2_question() {
        class_TraitQuestion[] stage_2_questions = {
            new class_TraitQuestion("You have entered the age of daycare, Welcome. On a day like any other you sit quiet and happy playing in a sandbox when Dale the oversized freckled toddler takes the shovel right from your hand.",
                new class_TraitAnswer("Tell Dale you can share", quick_add(tchar, tmor)),
                new class_TraitAnswer("Cry, getting Dale in trouble", quick_add(tint, tcour, 1)),
                new class_TraitAnswer("Push Dale and Reclaim your Shovel", quick_add(tcour, tmor, 1)),
                new class_TraitAnswer("Lie, Tell Dale the Shovel is cursed", quick_add(tint, tmor, 1)))
        };
        // Return Random
        return stage_2_questions[rand.nextInt(stage_2_questions.length - 1)];
    }

    // 3. Middle School
    public class_TraitQuestion get_stage3_question() {
        class_TraitQuestion[] stage_3_questions = {
            new class_TraitQuestion("Middle School gym class, oh what a joy. Your Teacher lets you decide on what activity to participate in.",
                new class_TraitAnswer("Basketball", quick_add(tchar, tath)),
                new class_TraitAnswer("Board Games", quick_add(tint, tath, 1)),
                new class_TraitAnswer("Fake an Illness", quick_add(tint, tmor, 1)),
                new class_TraitAnswer("Skip and Smoke", quick_add(tmor, 1, tint, 1)))
        };
        // Return Random
        return stage_3_questions[rand.nextInt(stage_3_questions.length - 1)];
    }

    // 4. Love
    public class_TraitQuestion get_stage4_question() {
        return new class_TraitQuestion("You have fallen for your first crush.",
            new class_TraitAnswer("Chase the girl", "Love"),
            new class_TraitAnswer("Focus on School", "No Love", quick_add(tint, tint)),
            new class_TraitAnswer("Focus on Athletics", "No Love", quick_add(tath, tath)),
            new class_TraitAnswer("Focus on Social", "No Love", quick_add(tchar, tchar)));
    }

    // 5. Skill
    public class_TraitQuestion get_stage5_question(String question_string, String taken_skill) {
        ArrayList<String> skill_array = get_skill_array();
        String opta, optb, optc, optd;
        // -1??
        if (taken_skill != null) {
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

    // 6. After School
    public class_TraitQuestion get_stage6_question() {
        return new class_TraitQuestion("You Have Graduated High School.",
            new class_TraitAnswer("College", "college"),
            new class_TraitAnswer("Trade School", "trade"),
            new class_TraitAnswer("Get A  Job", "job"),
            new class_TraitAnswer("Do Nothing", "nothing"));
    }

    // 7. Kids
    public class_TraitQuestion get_stage8_question(String love) {
        String crime = get_crime();
        if (love.equals("Love")) {
            return new class_TraitQuestion("You are married and ready to start your family, choose your assortment of family.",
                new class_TraitAnswer("0 Children", "0"),
                new class_TraitAnswer("1 Child", "1"),
                new class_TraitAnswer("2 Children", "2"),
                new class_TraitAnswer("No kids, Bonnie and Clyde", crime));
        }
        return new class_TraitQuestion("You are single and lonely, you want to fill this bottomless whole in your life.",
            new class_TraitAnswer("Adopt a Child", "1"),
            new class_TraitAnswer("2nd Chance at Love", "2"),
            new class_TraitAnswer("Live alone", "0"),
            new class_TraitAnswer(crime, crime));
    }

    // Helpers
    public ArrayList<String> get_skill_array() {
        ArrayList<String> skills = new ArrayList<String>() {
            {
                add("Art");
                add("Combat");
                add("Lock Pick");
                add("Crafting");
                add("First Aid");
                add("Diplomacy");
                add("Computer");
                add("Sales");
                add("Speed");
                add("Strength");
                add("Investigative");
                add("Gambling");
            }
        };
        return skills;
    }

    public String get_crime() {
        String[] crime_array = {"Rob a bank", "Rob a gas station", "Start Pyramid scheme", "Steal Rich Mans Identity"};
        int index = rand.nextInt(crime_array.length);
        return crime_array[index];
    }

    public class_TraitQuestion get_trait_question(int stage) {
        if (stage == 1)
            return get_stage1_question();
        else if (stage == 2)
            return get_stage2_question();
        return get_stage3_question();
    }
}
