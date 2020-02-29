package com.example.chooselife;

import java.util.ArrayList;
import java.util.Random;

public class class_Helper {
    public static String tint = "intelligence";
    public static String tluck = "luck";
    public static String tcour = "courage";
    public static String tchar = "charisma";
    public static String tmor = "morality";
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

    class_Trait[] future_trait_array(String t1, int val1){
        return new class_Trait[]{ new class_Trait(t1, val1)};
    }

    class_Trait[] future_trait_array(String t1, int val1, String t2, int val2){
        return new class_Trait[]{ new class_Trait(t1, val1), new class_Trait(t2, val2)};
    }
    class_Trait[] future_trait_array(String t1, int val1, String t2, int val2, String t3, int val3){
        return new class_Trait[]{ new class_Trait(t1, val1), new class_Trait(t2, val2), new class_Trait(t3, val3)};
    }

    public static String[] readme_array = {
            //0 - Intro
            "Welcome to life where your answers will determine your outcome. Answer the multiple choice questions to avoid death and earn glory. In between each question there is a small chance for an event, many times this will mean your " +
                    "death but in very rare circumstance it may launch a secret event. Good luck and good life.",
            //1 - Firefighter
            "In the early part of your afternoon shift you are filling your coffee mug when the firehouse alarm bursts with ringing. You are startled, as it is the first time you have heard it. " +
                    "You glance at your colleague and he looks back stern faced, he rushes out of the common area. You follow, to your first fire. You are nervous.",
            //2
            "You hop into the seat and everyone yells out at you. \"Rookie get in the back!\"",
            //3
            "You stay away from the fire trying to help out on the hose but you let the older firefighters take the lead. Eventually the fire is contained and with only one injured. You just weren't needed today",
            //4
            "You charge to the fire, axe in hand, colleagues just behind you. You kick the door and it crashes to the floor. As the door falls oxygen rushes into the room causing the fire to swell." +
                    "You stumble backwards, the captain pulls you back and points to the truck. Eventually the fire is contained and with only one injured. You just weren't needed today",
            //5
            "You charge to the fire, ladder in hand, colleagues just behind you. You climb the ladder and break the window, oxygen rushes into the room causing the fire to swell." +
                    "The window is flooded with fire forcing you to retreat down the ladder. Eventually the fire is contained and with only one injured. You just weren't needed today",
            //6
            "You charge to the fire, axe in hand, colleagues just behind you. You kick the door and it crashes to the floor. As the door falls you step away allowing the fire to swell then recede." +
                    "With the receding flames comes a man running from the danger, you grab his arm and help him to safety. Eventually the fire is contained and with no one injured.",
            //5
            "You charge to the fire, ladder in hand, colleagues just behind you. You climb the ladder and break the window, oxygen rushes into the room causing it to swell." +
                    "You manage to avoid the flames and reach over and break a boarded window. The hose fires through the two new openings. Eventually the fire is contained and with no one injured",
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
                    new class_TraitAnswer("Give Angry Look",        quick_add(tcour, tmor, 1)),
                    new class_TraitAnswer("Reach for Mama",         quick_add(tchar, tint)),
                    new class_TraitAnswer("Force a bowel movement", quick_add(tath, tbiz))),
            new class_TraitQuestion("You have been put down to sleep in your crib by the Overlord that calls himself Dad, while lying down you quickly catch a glimpse of a spider crawling across your bed ",
                    new class_TraitAnswer("Squish it",                  quick_add(tath, tmor, 1)),
                    new class_TraitAnswer("Quickly Brush it off",       quick_add(tluck, tint)),
                    new class_TraitAnswer("Put hand down to greet it",  quick_add(tchar, tmor)),
                    new class_TraitAnswer("Eat it",                     quick_add(tbiz, tmor, 1)))

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
                    new class_TraitAnswer("Tell Dale you can share",          quick_add(tchar, tmor)),
                    new class_TraitAnswer("Cry, getting Dale in trouble",          quick_add(tint, tcour, 1)),
                    new class_TraitAnswer("Push Dale and Reclaim your Shovel",          quick_add(tcour, tmor, 1)),
                    new class_TraitAnswer("Lie, Tell Dale the Shovel is cursed",          quick_add(tint, tmor, 1)))
    };

    public class_TraitQuestion[] stage3_questions = {
            new class_TraitQuestion("Middle School gym class, oh what a joy. Your Teacher lets you decide on what activity to participate in.",
                    new class_TraitAnswer("Basketball",          quick_add(tchar, tath)),
                    new class_TraitAnswer("Board Games",          quick_add(tint, tath, 1)),
                    new class_TraitAnswer("Fake an Illness",          quick_add(tint, tmor, 1)),
                    new class_TraitAnswer("Skip and Smoke",          quick_add(tmor, 1, tint, 1)))
    };

    // Love
    public class_TraitQuestion get_stage4_question() {
        return new class_TraitQuestion("You have fallen for your first crush.",
                new class_TraitAnswer("Chase the girl", "Love"),
                new class_TraitAnswer("Focus on School", "No Love", quick_add(tint, tint)),
                new class_TraitAnswer("Focus on Athletics", "No Love", quick_add(tath, tath)),
                new class_TraitAnswer("Focus on Social", "No Love", quick_add(tchar, tchar)));
    }
    // Skill
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
    // After School
    public class_TraitQuestion get_stage6_question() {
        return new class_TraitQuestion("You Have Graduated High School.",
                new class_TraitAnswer("College",        "college"),
                new class_TraitAnswer("Trade School",   "trade"),
                new class_TraitAnswer("Get A  Job",     "job"),
                new class_TraitAnswer("Do Nothing",     "nothing"));
    }
    // Kids
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
                new class_TraitAnswer("Adopt Twins", "2"),
                new class_TraitAnswer("Live alone", "0"),
                new class_TraitAnswer(crime, crime));
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
    public String get_crime()
    {
        String[] crime_array = {"Rob a bank", "Rob a gas station", "Start Pyramid scheme", "Steal Rich Mans Identity"};
        Random rand = new Random();
        int index = rand.nextInt(crime_array.length);
        return crime_array[index];
    }

    public class_Future[] futureArray = {
            /*

            // Doctor
            new class_Future(0, 2, "Doctor", null, null, str_arr("college"), null, null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0,0, null, null, "It is the first day of your medical internship,  ",
                                    new class_TraitAnswer("2?",2),
                                    new class_TraitAnswer("2a?",2),
                                    new class_TraitAnswer("3?",3),
                                    new class_TraitAnswer("3a?",3)),
                    }
            ),


            new class_FutureQuestion(0,2, null, null, "",
                    new class_TraitAnswer("2?",2),
                    new class_TraitAnswer("2a?",2),
                    null,
                    null
            ),

*/
            // TEST
            new class_Future(100, 1, "Test", null, null, null, null, null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0,0, null, null, "Test 1?",
                                    new class_TraitAnswer("2?",2),
                                    new class_TraitAnswer("2a?",2),
                                    new class_TraitAnswer("3?",3),
                                    new class_TraitAnswer("3a?",3)),
                            new class_FutureQuestion(0,2, null, null, "Test 2?",
                                    new class_TraitAnswer("4?",4),
                                    new class_TraitAnswer("4a?",4),
                                    new class_TraitAnswer("5?",5),
                                    new class_TraitAnswer("5a?",5)),
                            new class_FutureQuestion(0,3, null, null, "Test 2?",
                                    new class_TraitAnswer("4?",4),
                                    new class_TraitAnswer("4a?",4),
                                    new class_TraitAnswer("5?",5),
                                    new class_TraitAnswer("5a?",5)),
                            new class_FutureQuestion(0,4, null, null, "Test 3?",
                                    new class_TraitAnswer("6?",6),
                                    new class_TraitAnswer("6a?",6),
                                    new class_TraitAnswer("6?",6),
                                    new class_TraitAnswer("6a?",6)),
                            new class_FutureQuestion(0,5, null, null, "Test 3?",
                                    new class_TraitAnswer("6?",6),
                                    new class_TraitAnswer("6a?",6),
                                    null,
                                    new class_TraitAnswer("6a?",6)),
                            new class_FutureQuestion(0,6, null, null, "Test 3?",
                                    new class_TraitAnswer("You Have Passed The Test!",999, "Dev Tester (Rare)"),
                                    new class_TraitAnswer("You Have Passed The Test!",999, "Dev Tester (Rare)"),
                                    new class_TraitAnswer("You Have Passed The Test!",999, "Dev Tester (Rare)"),
                                    new class_TraitAnswer("6b?",999, "Welcome Neo (Ultra-Rare)"))
                    }
            ),

            // Archaeologist
            new class_Future(0, 2, "Archaeologist", null, null, str_arr("college"), null, null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0,0, null, null, "Years of study and field work have made you a renowned archaeologist. You have finally tracked down the ancient artifact that you have spent your career searching for \"Piedra de Tigre\".",
                                    new class_TraitAnswer("Turn Back",2),
                                    new class_TraitAnswer("",2),
                                    new class_TraitAnswer("",3),
                                    new class_TraitAnswer("",3)),
                    }
            ),

            // Boxer
            new class_Future(0, 2, "Professional Boxer", future_trait_array(tath, 3), null, null, null, null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0, 0, null, null, "Aging and punched out you find yourself in the middle of a boxing match competing against a much younger and better opponent. You are dead tired at the start of the 3rd round but you may have an opening to finish.",
                                    new class_TraitAnswer("Save Energy", 1),
                                    new class_TraitAnswer("Final Burst", 999, "Boxer: Down in the Third"),
                                    null,
                                    new class_TraitAnswer("", 3)),
                            new class_FutureQuestion(0,1, null, null, "You manage to gain some energy back and notice your opponent dropping their guard after jabbing twice. If you time the right combo it will land big.",
                                    new class_TraitAnswer("Jab, Jab, Hook",2),
                                    new class_TraitAnswer("Jab, Hook, Jab",2),
                                    new class_TraitAnswer("Hook, Uppercut, Jab",3),
                                    new class_TraitAnswer("Uppercut, Uppercut",4)),
                            new class_FutureQuestion(0,1, null, null, "You manage to gain some energy back and notice your opponent dropping their guard after jabbing twice. If you time the right combo it will land big.",
                                    new class_TraitAnswer("Jab, Jab, Hook",2),
                                    new class_TraitAnswer("Jab, Hook, Jab",2),
                                    new class_TraitAnswer("Hook, Uppercut, Jab",3),
                                    new class_TraitAnswer("Uppercut, Uppercut",4)),
                            new class_FutureQuestion(0,1, null, null, "You manage to gain some energy back and notice your opponent dropping their guard after jabbing twice. If you time the right combo it will land big.",
                                    new class_TraitAnswer("Jab, Jab, Hook",2),
                                    new class_TraitAnswer("Jab, Hook, Jab",2),
                                    new class_TraitAnswer("Hook, Uppercut, Jab",3),
                                    new class_TraitAnswer("Uppercut, Uppercut",4)),
                    }
            ),

            // Plumber
            new class_Future(0, 2, "Plumber", null, null, str_arr("trade"), null, null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0,0, null, null, "Portrait of a man hard at work, your hands move quickly and effortlessly due to years of service, age 51 and after 4 hours of labor at a previous house you are exhausted.",
                                    new class_TraitAnswer("Rest your head on the sink cabinet",2),
                                    new class_TraitAnswer("Work but shut your eyes",2),
                                    new class_TraitAnswer("Work through it",4),
                                    new class_TraitAnswer("Shake your head to wake up",4)),
                            new class_FutureQuestion(0,2, null, null, "The client walks in  just as you do and yells \"Wow, really?! Wake up you're fired!",
                                    new class_TraitAnswer("Apologise, ask for second chance",999, "Polite Plumber"),
                                    new class_TraitAnswer("Insult client", 999, "Plumber Justice"),
                                    new class_TraitAnswer("Tell them you understand", 999, "Polite Plumber"),
                                    new class_TraitAnswer("Lie and say you understand", 3)),
                            new class_FutureQuestion(0,3, null, null, "You pack up your tools slowly looking around the bathroom, plotting your revenge.",
                                    new class_TraitAnswer("Clog Drain",999, "Plumber Justice"),
                                    new class_TraitAnswer("Break the Flush valve",999, "Plumber Justice"),
                                    new class_TraitAnswer("Connect the electrical outlet to the pipe under the sink",999, "Plumber in Jail"),
                                    new class_TraitAnswer("Steal fancy towels",999, "Plumber and a Thief (Rare)")),
                            new class_FutureQuestion(0,4, null, null, "As you work through exhaustion the client returns time and again calling you the wrong name and reminding you not to steal something.",
                                    new class_TraitAnswer("Ask for water",5),
                                    new class_TraitAnswer("Insult client",6),
                                    new class_TraitAnswer("Ask for privacy",5),
                                    new class_TraitAnswer("Continue work",7)),
                            new class_FutureQuestion(0,5, null, null, "The client spits on the bathroom floor, yelling \"This is my house. I do not answer to you.\"",
                                    new class_TraitAnswer("Smack client and leave",999, "Plumber Justice"),
                                    new class_TraitAnswer("Stand and leave",999, "Polite Plumber"),
                                    //TODO: Make a boxing future have this as option to win
                                    new class_TraitAnswer("Left uppercut, right hook", 999,"Plumber KO (Rare)"),
                                    new class_TraitAnswer("Continue work",7)),
                            new class_FutureQuestion(0,6, null, null, "You tell the client not to worry. \"I only steal from nice houses\". Wink. The client kicks your toolbox over spilling your tools to the ground.",
                                    new class_TraitAnswer("Quit in Spite",3),
                                    new class_TraitAnswer("Quit in Peace",999, "Polite Plumber"),
                                    new class_TraitAnswer("Break sink tile", 999,"Plumber Justice"),
                                    new class_TraitAnswer("Continue work",7)),
                            new class_FutureQuestion(0,7, null, null, "After working into overtime, you free the blockage and have finished your work. As your packing up the client accuses you of breaking a tile above the sink",
                                    new class_TraitAnswer("Insist you didn't and leave.",999, "Plumber with a bad review (Rare)"),
                                    new class_TraitAnswer("Double charge client",999, "Plumber Justice"),
                                    new class_TraitAnswer("Calmly explain you did not",999, "Polite Plumber"),
                                    new class_TraitAnswer("Attack and kidnap client",999, "Plumber in Jail"))
                    }
            ),

            // Camp Counselor
            new class_Future(0, 2, "Summer Camp Counselor", future_trait_array(tchar, 2, tmor, 2), null, str_arr("trade", "job"), "0", null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0,0, null, null, "The summer sun is out and the birds are chirping as the summer camp counselors arrive at Camp Clear Spring. The usual cast of characters is abound, which are you?",
                                    new class_TraitAnswer("Geek",1),
                                    new class_TraitAnswer("Jock",1),
                                    new class_TraitAnswer("Hippie",1),
                                    new class_TraitAnswer("Local",1)),

                            new class_FutureQuestion(0,1, null, null, "Preparing for the children to arrive you have finished your task of arranging your cabin, how will you spend your evening?",
                                    new class_TraitAnswer("Swim in the Lake",4),
                                    new class_TraitAnswer("Hike Alone",3),
                                    new class_TraitAnswer("Drink with Peers",4),
                                    new class_TraitAnswer("Sit by Fire",4)),

                            new class_FutureQuestion(0,3, null, null, "You are following the hiking trail. As the sun begins to set you hear the snapping of a tree branch just feet from you.",
                                    new class_TraitAnswer("Turn to see",999, "1st Counselor Dead"),
                                    new class_TraitAnswer("Hide in bushes",5),
                                    new class_TraitAnswer("Run for it",999, "1st Counselor Dead"),
                                    new class_TraitAnswer("Play Dead",999, "1st Counselor Dead")),

                            new class_FutureQuestion(0,4, null, null, "The music is loud and counselors are happy, when a terrible shriek comes from surrounding woods.",
                                    new class_TraitAnswer("Walk to Staff Lodge",5),
                                    new class_TraitAnswer("Run to investigate",999, "2nd Counselor Dead"),
                                    new class_TraitAnswer("Run to Staff Lodge",5),
                                    new class_TraitAnswer("Stay put",999, "2nd Counselor Dead")),

                            new class_FutureQuestion(0,5, null, null, "You arrive at the Staff Lodge confused and afraid, the other counselors shovel you through the door and lock it behind you. There has been an attack at the camp and you must devise an escape!",
                                    new class_TraitAnswer("Phone for help", 6),
                                    new class_TraitAnswer("Escape on foot", 999, "Counselor that got everyone killed"),
                                    new class_TraitAnswer("Fix the bus",9),
                                    new class_TraitAnswer("Take the row boats",15)),

                            new class_FutureQuestion(0,6, null, null, "The best plan is often the easiest, you walk to the kitchen to use the phone. Lifting the phone from the receiver you hear no dial tone, the phone is dead.",
                                    new class_TraitAnswer("Investigate Cut Wire",999, "Curiosity killed the Counselor"),
                                    new class_TraitAnswer("Send Kevin to Investigate",7),
                                    new class_TraitAnswer("Send Sara to Investigate",7),
                                    new class_TraitAnswer("Check next cabin's phone",999, "2nd Counselor Dead")),

                            new class_FutureQuestion(0,7, null, null, "Waiting...seconds...minutes, suddenly the phone clicks and comes to life. A celebratory moment is had in the lodge as you call for help. Though you notice the counselor you sent has not returned. The cops are on their way, you are almost saved! Creeeeek, you turn to see an open door and The Attacker standing.",
                                    new class_TraitAnswer("Help Jess escape",999, "Counselor Died a Hero"),
                                    new class_TraitAnswer("Defend Jim",999, "Counselor Died a Hero"),
                                    new class_TraitAnswer("Run past Jim",8),
                                    new class_TraitAnswer("Push aside Jess",8)),

                            new class_FutureQuestion(0,8, null, null, "Straight to your feet and out the back door, you look back and see the J named counselor snatched by The Attacker. A loud crash is heard as you escape through the backyard. Where to now?",
                                    new class_TraitAnswer("Swim to safety", 999,"Counselor Drowned"),
                                    new class_TraitAnswer("Hide in bush",999, "Counselor Survived: Phone (Rare)"),
                                    new class_TraitAnswer("Run to highway",999, "Counselor Survived: Phone (Rare)"),
                                    new class_TraitAnswer("Hide in next lodge",999, "Last Counselor Dead")),

                            new class_FutureQuestion(0,9, null, null, "The bus needs a new battery, located in the garage, and the keys, located in the maintenance cabin, in order to start.",
                                    new class_TraitAnswer("Send Kevin for the keys",10),
                                    new class_TraitAnswer("Go for the keys",12),
                                    new class_TraitAnswer("Go for the battery",11),
                                    new class_TraitAnswer("Send Kayla for battery",10)),

                            new class_FutureQuestion(0, 10, null, null, "Too afraid to go yourself you send your fellow counselor to save the day. Huddled together waiting nervously for help to arrive the door opens and the K letter counselor walks through. Oddly their walk is staggered and then boom. They fall flat and you can see The Attacker's Knife in their back.",
                                    new class_TraitAnswer("Run",999, "3rd Counselor Dead"),
                                    new class_TraitAnswer("Fight",999,"3rd Counselor Dead"),
                                    new class_TraitAnswer("Hide",999,"3rd Counselor Dead"),
                                    new class_TraitAnswer("Cry",999, "3rd Counselor Dead")),

                            new class_FutureQuestion(0, 11, null, null, "You put on a brave face and leave the Staff Cabin. Running quickly to the trail you hear glass breaking and another terrible shriek from the Staff Cabin. Out of breath you retrieve the battery, now where to go?",
                                    new class_TraitAnswer("Staff Lodge",999, "Curiosity killed the Counselor"),
                                    new class_TraitAnswer("Go to bus",13),
                                    new class_TraitAnswer("Catch breath",999,""),
                                    new class_TraitAnswer("Get the Keys",13)),

                            new class_FutureQuestion(0, 12, null, null, "You put on a brave face and leave the Staff Cabin. Running quickly to the trail you hear glass breaking and another terrible shriek from the Staff Cabin. Out of breath you retrieve the keys, now where to go?",
                                    new class_TraitAnswer("Staff Lodge",999, "Curiosity killed the Counselor"),
                                    new class_TraitAnswer("Go to bus",13),
                                    new class_TraitAnswer("Catch breath",999, "Counselor Dying to Rest (Rare"),
                                    new class_TraitAnswer("Get the battery",13)),

                            new class_FutureQuestion(0, 13, null, null, "Back on the trails and not much is visible but you do here a rustling in the woods as you walk. You increase your pace but so does the rustling, it is getting closer, catching up. Out from the bushes colliding with you comes a counselor holding the missing part.",
                                    new class_TraitAnswer("Go to Bus Together", 14),
                                    new class_TraitAnswer("Split Up",999, "Last Counselor Dead"),
                                    null,
                                    null),

                            new class_FutureQuestion(0, 14, null, null, "At the bus you finish installing the battery, you toss the keys to your coworker at the driver door. Keys floating in the air when...The Attacker swipes the keys with his right hand and then your coworker with his left.",
                                    new class_TraitAnswer("Run",999, "Last Counselor Dead"),
                                    new class_TraitAnswer("Grab Coworker",999, "Counselor Died a Hero"),
                                    new class_TraitAnswer("Grab Keys",999, "Counselor Survived: Bus (Rare)"),
                                    new class_TraitAnswer("Hot-wire and go",999, "Counselor Survived: Bus (Rare)")),

                            new class_FutureQuestion(0, 15, null, null, "You lead everyone to the Boat House, well almost everyone, as you look around you notice that one of the counselors is missing.",
                                    new class_TraitAnswer("Tell the group", 16),
                                    new class_TraitAnswer("Keep it Secret",17),
                                    null,
                                    null),

                            new class_FutureQuestion(0, 16, null, null, "The group begins to panic, you attempt to calm the group when Kyle storms out of the boat house in look for his friend.",
                                    new class_TraitAnswer("Run after Kyle",999, "Screw You Kyle! (Rare)"),
                                    new class_TraitAnswer("Send Kelly",17),
                                    new class_TraitAnswer("Calm group",17),
                                    new class_TraitAnswer("Join in Panic",999, "Counselor that got everyone killed")),

                            new class_FutureQuestion(0, 17, null, null, "Your group is calm and collected, whats left of them, as you plan your escape. The row boats need paddles and the counselors need life vests but time is running out!",
                                    new class_TraitAnswer("Take boats as is",999, "Counselor Died Floating"),
                                    new class_TraitAnswer("Search for supplies",18),
                                    null,
                                    null),

                            new class_FutureQuestion(0,18, null, null, "You make a run for the nearest cabin to look for paddles. Just as you open the door you hear a scream coming from the Boat House, you must hurry. After a long period of searching through storage you find the paddles.",
                                    new class_TraitAnswer("Return to Boat House",19),
                                    new class_TraitAnswer("Look for vests",20),
                                    null,
                                    null),

                            new class_FutureQuestion(0,20, null, null, "You make a run for the next nearest cabin to look for life vests. Just as you open the door you hear another scream coming from the Dock, you must hurry, where do you search?",
                                    new class_TraitAnswer("Closet",21),
                                    new class_TraitAnswer("Shelves",22),
                                    new class_TraitAnswer("Footlocker",21),
                                    new class_TraitAnswer("Restroom",21)),

                            new class_FutureQuestion(0,21, null, null, "You search the area but have no luck. Walking away you see the orange straps like that of a life vests sticking out from behind the footlocker.",
                                    new class_TraitAnswer("Return to Boat House",23),
                                    new class_TraitAnswer("Sneak to Dock",999, "Counselor Selfish Survived: Boat (Rare)"),
                                    null,
                                    null),

                            new class_FutureQuestion(0,22, null, null, "You search the shelves but find nothing. You think you hear a noise outside of your cabin but you can't be sure.",
                                    new class_TraitAnswer("Keep Searching",26),
                                    new class_TraitAnswer("Run to Boat House",19),
                                    null,
                                    null),

                            new class_FutureQuestion(0,23, null, null, "You return to the boat house to find that only two other members are present. How will you fill the boats?",
                                    new class_TraitAnswer("All together",24),
                                    new class_TraitAnswer("All separate",999, "Counselor Survived: Boat"),
                                    new class_TraitAnswer("Go alone",999, "Counselor Survived: Boat"),
                                    new class_TraitAnswer("Kenny goes alone",999, "Counselor Survived: Killed Kenny")),

                            new class_FutureQuestion(0,24, null, null, "You all pile into the boat and make your way across the lake. Paddling intensely a ripple in the water begins to chase the boat. The Attacker rises from the water capsizing the boat, you all are brought to the surface by your life vest.",
                                    new class_TraitAnswer("Swim to Safety",999, "Counselor Survived: Boat"),
                                    new class_TraitAnswer("Help Kenny",999, "Counselor Survived: Saved Kenny"),
                                    new class_TraitAnswer("Get on Boat",999, "Counselor Died with the Ship (Rare)"),
                                    new class_TraitAnswer("Help Both",999, "Counselor Died a Hero")),

                            // NO LIFE VEST
                            new class_FutureQuestion(0,19, null, null, "You return to the Boat House to find that only two other members are present. How will you fill the boats?",
                                    new class_TraitAnswer("All together",25),
                                    new class_TraitAnswer("All separate",999, "Counselor Survived: Boat"),
                                    new class_TraitAnswer("Go alone",999, "Counselor Survived: Boat"),
                                    new class_TraitAnswer("Kenny goes alone",999, "Counselor Survived: Killed Kenny")),

                            new class_FutureQuestion(0,25, null, null, "You all pile into the boat and make your way across the lake. Paddling intensely a ripple in the water begins to chase the boat. The Attacker rises from the water capsizing the boat, you sink to the bottom.",
                                    new class_TraitAnswer("Sink", 999, "Last Counselor Dead"),
                                    new class_TraitAnswer("Swim", 999, "Last Counselor Dead"),
                                    new class_TraitAnswer("Fight", 999, "Last Counselor Dead"),
                                    new class_TraitAnswer("Push off Kenny", 999, "Counselor Survived: Killed Kenny")),

                            // Keep Searching
                            new class_FutureQuestion(0,26, null, null, "You finally find the life vests behind the footlocker. You return to the Boat House to find that only two other members are present. How will you fill the boats?",
                                    new class_TraitAnswer("All together",24),
                                    new class_TraitAnswer("All separate",27),
                                    new class_TraitAnswer("Go Alone",27),
                                    new class_TraitAnswer("Kenny goes alone",999, "Counselor Survived: Killed Kenny")),

                            new class_FutureQuestion(0,27, null, null, "While taking your time deciding who will take which boat The Attacker storms through the Boat House doors sledgehammer in hand",
                                    new class_TraitAnswer("Hurry to Boat",25),
                                    new class_TraitAnswer("Push Attacker",28),
                                    new class_TraitAnswer("Run",999, "Last Counselor Dead"),
                                    new class_TraitAnswer("Grab life vests",999, "Counselor Died for a Life Preserver")),

                            new class_FutureQuestion(0,28, null, null, "You push the Attacker causing him to stumble into an assortment of hanging chains and boat anchors.",
                                    new class_TraitAnswer("Sweep the Leg",29),
                                    new class_TraitAnswer("Run",999, "Counselor Survived: Chained Up (Rare)"),
                                    null,
                                    new class_TraitAnswer("3a?",3)),

                            new class_FutureQuestion(0,29, null, null, "You sweep the leg sending The Attacker high into the air and then down bouncing out of the bay door and onto the dock.",
                                    new class_TraitAnswer("Slide Kick",30),
                                    new class_TraitAnswer("Run",999, "Counselor Survived: Dock Anchored (Rare)"),
                                    null,
                                    new class_TraitAnswer("3a?",3)),

                            new class_FutureQuestion(0,29, null, null, "Sliding across the dock planks your foot connects with The Attackers chest. With a heavy grunt The Attacker skids across then falls off the dock, chains dragging him deeper and deeper into the dark depths of the lake.",
                                    new class_TraitAnswer("Fist Pump",999, "Counselor Survived: Defeat the Attacker (Legendary)"),
                                    new class_TraitAnswer("Arm Swing",999, "Counselor Survived: Defeat the Attacker (Legendary)"),
                                    null,
                                    new class_TraitAnswer("3a?",3)),

                    }
            ),




/*


                    }),



            // Doctor
            new class_Future(0, 2, "Doctor", null, null, str_arr("college"), null, null, null,
                    new class_FutureQuestion[]{
                            new class_FutureQuestion(0,0, null, null, "It is the first day of your medical residency, you have spent the first six hours running mindless errands and now are tasked with checking the heart rate of your attending's patient." +
                                    "As you enter the room you notice the patient has spilled her pills on the ground.",
                                    new class_TraitAnswer("Alert the nurse",2),
                                    new class_TraitAnswer("Place pills on the table",2),
                                    new class_TraitAnswer("Place pills in pocket",999),
                                    new class_TraitAnswer("Leave it alone",2)),
                            new class_FutureQuestion(0,2, null, null, "You have survived residency so far and are almost to the end. Your attending is giving you first choice between 4 new patients",
                                    new class_TraitAnswer("Chest pressure",3),
                                    new class_TraitAnswer("Bad Cough",4),
                                    new class_TraitAnswer("Burns when urinate",4),
                                    new class_TraitAnswer("Claim of flu",4)),
                            new class_FutureQuestion(0,3, null, null, "After taking an x-ray of the man's chest you discover that he has a rare congenital condition that causes his heart to point in the opposite direction. Your attending tells you to respect the patients privacy but " +
                                    "you feel the urge to write a paper on the subject",
                                    new class_TraitAnswer("Write the paper",4),
                                    new class_TraitAnswer("Don't write the paper",6),
                                    new class_TraitAnswer("Ask patient's permission to write paper",5),
                                    new class_TraitAnswer("Don't write the paper",6)),

                    }),

            // FIREFIGHTER
            new class_Future(0, 2, "Firefighter", future_trait_array(tmor, 2, tcour, 2), null, null, null, null, null,
                    new class_FutureQuestion[]{
                            //0
                            new class_FutureQuestion(0,0, null, null, "AGE 22: You are a Probie, a Probational Firefighter in your small town's fire station. Starting your third week you are exhausted on the night shift you find downtime away from the crew.",
                                    new class_TraitAnswer("Sneak in a quick nap", 12),
                                    new class_TraitAnswer("Study Street Maps",13),
                                    new class_TraitAnswer("Video Games",14),
                                    new class_TraitAnswer("Deadlift in the gym",11)),
                            //1-1
                            new class_FutureQuestion(0, 11, null, null, "AGE 26: Fires are few and far between in this town, you keep in shape best you can but you wonder what for if there is no action, you must something to pass the time",
                                    new class_TraitAnswer("Basketball",21),
                                    new class_TraitAnswer("Rock Climbing",21),
                                    new class_TraitAnswer("Sudoku",22),
                                    new class_TraitAnswer("Frogger",22)),
                            //1-2
                            new class_FutureQuestion(0,12, null, null, "AGE 26: Fires are few and far between in this little town, your habits so far are in question, but does it really matter in east kansas nowhere",
                                    new class_TraitAnswer("Learn From Older Colleague",21),
                                    new class_TraitAnswer("Break habits on your own",22),
                                    new class_TraitAnswer("Study to be a driver",23),
                                    new class_TraitAnswer("Collect paycheck, rinse, repeat",22)),
                            //1-3
                            new class_FutureQuestion(0, 13, null, null, "AGE 26: Fires are few and far between in this town, you keep in shape best you can but you wonder what for if there is no action, you must something to pass the time",
                                    new class_TraitAnswer("Basketball",24),
                                    new class_TraitAnswer("Rock Climbing",24),
                                    new class_TraitAnswer("Sudoku",23),
                                    new class_TraitAnswer("Frogger",23)),
                            //1-4
                            new class_FutureQuestion(0,14, null, null, "AGE 26: Fires are few and far between in this little town, your habits so far are in question, but does it really matter in east kansas nowhere",
                                    new class_TraitAnswer("Learn From Older Colleague",23),
                                    new class_TraitAnswer("Break habits on your own",22),
                                    new class_TraitAnswer("Study to be a driver",23),
                                    new class_TraitAnswer("Collect paycheck, rinse, repeat",22)),
                            //2-1
                            new class_FutureQuestion(0,21, null, null, "Age 30: You have become a Rescue Firefighter, there is a town emergency. Another elderly man has fallen at the community home in town.",
                                    new class_TraitAnswer("Gently Assist the elderly man",31),
                                    new class_TraitAnswer("Call in the paramedics",31),
                                    new class_TraitAnswer("Sweep him up by his ankles",32),
                                    new class_TraitAnswer("Fireman's carry this sucker",32)),
                            //2-2
                            new class_FutureQuestion(0,22, null, null, "Age 30: I don't know how buy you have become a Rescue Firefighter, there is a town emergency. A boys kite is stuck in the tree",
                                    new class_TraitAnswer("Climb Tree",32),
                                    new class_TraitAnswer("Ladder Time",32),
                                    new class_TraitAnswer("Shoot it down with hose",32),
                                    new class_TraitAnswer("Throw boy up to get it",32)),
                            //2-3
                            new class_FutureQuestion(0,23, null, null, "Age 30: You have earned your right as a Fire Truck Driver. ",
                                    new class_TraitAnswer("Climb Tree",33),
                                    new class_TraitAnswer("Ladder Time",33),
                                    new class_TraitAnswer("Shoot it down with hose",34),
                                    new class_TraitAnswer("Throw boy up to get it",34)),
                            //2-4
                            new class_FutureQuestion(0,24, null, null, "Age 30: You have fooled someone into letting you become a Fire Truck Driver. ",
                                    new class_TraitAnswer("Climb Tree",33),
                                    new class_TraitAnswer("Ladder Time",34),
                                    new class_TraitAnswer("Shoot it down with hose",34),
                                    new class_TraitAnswer("Throw boy up to get it",34)),
                            //3-1
                            new class_FutureQuestion(0,31, null, null, "Age 33: A popular cash-for-used-games business has caught fire, your first real fire since becoming a Firefighter in your early 20's. The Rescue team shows up to flames swallowing the front door.",
                                    new class_TraitAnswer("Order Water to the front door",42),
                                    new class_TraitAnswer("Ladder Time",33),
                                    new class_TraitAnswer("Shoot it down with hose",34),
                                    new class_TraitAnswer("Throw boy up to get it",34)),


                    }),
*/

    };

    public String[] str_arr(String s1, String s2){String[] str_arr = {s1, s2}; return str_arr;}
    public String[] str_arr(String s1){String[] str_arr = {s1}; return str_arr;}

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

    public String get_ReadMe(int index)
    {
        return readme_array[index];
    }

}
