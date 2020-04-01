package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Future;

public class PlayGame extends AppCompatActivity {
    int stage_count = 1;
    class_Helper Helper = new class_Helper();
    class_Stories Stories = new class_Stories();
    class_Trait Trait = new class_Trait();
    class_GameStats Stats = new class_GameStats(Trait.new_array());
    class_Future Future = new class_Future();
    class_TraitQuestion cur_que = new class_TraitQuestion();
    class_FutureQuestion fut_que = new class_FutureQuestion();
    static final int INTRO_README = 0;
    SharedPreferences gameData;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // Shared Preference
        gameData = getApplicationContext().getSharedPreferences("gameData", MODE_PRIVATE);
        editor = gameData.edit();

        //Initial Readme
        Intent starting_readme = new Intent(this, ReadMe.class);
        starting_readme.putExtra("Readme", getString(R.string.intro));
        startActivityForResult(starting_readme, INTRO_README);
    }

    public class_Trait get_stat_trait(String trait)
    {
        class_Trait temp = new class_Trait();
        switch(trait){
            case "intelligence":
                temp = Stats.getTrait(0);
                break;
            case "luck":
                temp = Stats.getTrait(1);
                break;
            case "courage":
                temp = Stats.getTrait(2);
                break;
            case "charisma":
                temp = Stats.getTrait(3);
                break;
            case "deviance":
                temp = Stats.getTrait(4);
                break;
            case "bizarre":
                temp = Stats.getTrait(5);
                break;
            case "athleticism":
                temp = Stats.getTrait(6);
                break;
        }
        return temp;
    }


    public void start_question(int stage, int storynum)
    {
        Intent question_page = new Intent();
        String[] vinfo_str = new String[]{};

        if (stage < 9)
            question_page = new Intent(this, FourAnswerPage.class);

        if (stage < 4)
            cur_que = Helper.get_trait_question(stage);
        else if (stage == 4)
            cur_que = Helper.get_stage4_question();
        else if (stage == 5)
            cur_que = Helper.get_stage5_question("choose a skill", null);
        else if (stage == 6)
            cur_que = Helper.get_stage6_question();
        else if (stage == 8)
            cur_que = Helper.get_stage8_question(Stats.get_love());
        else if (stage > 8) {
            // END OF Game
            if (storynum == 999) {
                if (Stats.getOutcome() != null)
                {
                    Set<String> futures_set = gameData.getStringSet("futures", null);
                    // New List
                    if (futures_set == null)
                    {
                        Set<String> new_set =  new HashSet<String>();
                        new_set.add(Stats.getOutcome());
                        //new futures
                        editor.putStringSet("futures", new_set);
                        editor.apply();
                    }
                    else {
                        // Already Unlocked
                        if (futures_set.contains(Stats.getOutcome())) {
                            finish();
                            return;
                        }
                        // Add to List
                        futures_set.add(Stats.getOutcome());
                        editor.putStringSet("futures", futures_set);
                        editor.apply();
                    }
                    // Read Me
                    Intent readme = new Intent(this, ReadMe.class);
                    readme.putExtra("Readme", "Your Future has been decided\n You are Awarded: "+Stats.getOutcome());
                    startActivityForResult(readme, INTRO_README);
                    finish();
                    return;
                }
            }
            fut_que = get_FutureQuestion(storynum);
        }
        // Set Info String and Extra
        if (stage < 9) {
            String[] info_str = {
                cur_que.getQuestion(),
                cur_que.getOptA().getText(),
                cur_que.getOptB().getText(),
                cur_que.getOptC().getText(),
                cur_que.getOptD().getText(),
            };
            vinfo_str = info_str;
            question_page.putExtra("info", info_str);
        }
        else{
            // 2 answer Page
            if (fut_que.getOptC() == null)
            {
                String[] info_str = {
                        fut_que.getQuestion(),
                        fut_que.getOptA().getText(),
                        fut_que.getOptB().getText()
                };
                vinfo_str = info_str;
                question_page = new Intent(this, TwoAnswerPage.class);
            }
            else{
                String[] info_str = {
                        fut_que.getQuestion(),
                        fut_que.getOptA().getText(),
                        fut_que.getOptB().getText(),
                        fut_que.getOptC().getText(),
                        fut_que.getOptD().getText(),
                };
                vinfo_str = info_str;
                question_page = new Intent(this, FourAnswerPage.class);
            }
            question_page.putExtra("info", vinfo_str);
        }
        startActivityForResult(question_page, stage);
        // Display Stats + Trait
        if (stage == 9){
            // Display Traits
            Intent display = new Intent(this, DisplayTrait.class);
            display.putExtra("trait_values", trait_value_strings());
            startActivity(display);
        }
    }

    public class_TraitAnswer getOpt(String option, int stage)
    {
        if(stage < 9) {
            switch (option) {
                case "a":
                    return cur_que.getOptA();
                case "b":
                    return cur_que.getOptB();
                case "c":
                    return cur_que.getOptC();
                case "d":
                    return cur_que.getOptD();
            }
        }
        else
            switch (option) {
                case "a":
                    return fut_que.getOptA();
                case "b":
                    return fut_que.getOptB();
                case "c":
                    return fut_que.getOptC();
                case "d":
                    return fut_que.getOptD();
            }
        return new class_TraitAnswer();
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        class_TraitAnswer opt = new class_TraitAnswer();
        String result;
        if(resultCode == 404)
        {
            finish();
            return;
        }
        if (requestCode > 0) {
            result = data.getStringExtra("result");
            opt = getOpt(result, requestCode);
        }
        // ReadMe
        if (requestCode == 0){
            start_question(1, 0);
        }
        // Trait 1-3 - Return
        else if (requestCode < 4){
            set_traits(opt.getTraitArray());
            start_question(requestCode+1,0);
        }
        // Q4 - Return
        else if (requestCode == 4)
        {
            if (opt.get_Life_choice().equals("No Love")) {
                Stats.set_love(null);
                set_traits(opt.getTraitArray());
            }
            else
                Stats.set_love("yes");
            // Stage 5 Question
            start_question(5,0);
        }
        //Q5 Return
        else if (requestCode == 5)
        {
            Stats.setSkill_1(opt.get_Life_choice());
            start_question(6,0);
        }
        //Q6 Return
        else if (requestCode == 6)
        {
            Stats.set_after_school(opt.get_Life_choice());
            start_question(8,0);
        }
        //Q8 Return
        else if (requestCode == 8){
            if (opt.get_Life_choice().equals("0"))
               Stats.set_kids(null);
            else if (opt.get_Life_choice().equals("1"))
                Stats.set_kids("1");
            else if (opt.get_Life_choice().equals("2"))
                Stats.set_love("yes");
            else
                Stats.setCrime("yes");

            // Set Future
            setFuture();
            // Set Game Started/Futures Achieved Stat
            int start = gameData.getInt("starts", 0);
            if (start == 0)
                editor.putInt("starts", 1);
            else
                editor.putInt("starts", start+1);
            editor.apply();
            start_question(9,0);
        }
        else if (requestCode > 8){
            if (opt.getOutcome() != null)
                Stats.setOutcome(opt.getOutcome());
            //TODO
            if (opt.getReadme_str() != null){
                //Attached Readme
                Intent attach_readme = new Intent(this, ReadMe.class);
                attach_readme.putExtra("Readme", opt.getReadme_str());
                startActivityForResult(attach_readme, INTRO_README);
            }
            start_question(requestCode+1, opt.getStorynum());
        }
    }

    public void set_traits(class_Trait[] answer_traits)
    {
        for (int i =0; i < answer_traits.length; i++)
        {
            class_Trait stat_trait = get_stat_trait(answer_traits[i].getTitle());
            stat_trait.addValue(answer_traits[i].getValue());
        }

    }

    public void setFuture()
    {
        Random rand = new Random();
        class_Future[] future_array = Stories.get_futureArray();
        ArrayList<class_Future> local_array = new ArrayList<>();
        int rare = rand.nextInt(101);

        //Loop through all Futures
        future_loop: for (int i =0; i < future_array.length; i++){
            // Rare
            if (future_array[i].rare > rare)
                continue;
            // Love
            if (future_array[i].love != null && !Stats.get_love().equals(future_array[i].love))
                continue;
            // Kids
            if (future_array[i].kids != null && Stats.getKids() == null)
                continue;
            // Crime
            if (future_array[i].crime != null && Stats.getCrime() == null)
                continue;
            // After School
            if (future_array[i].after_school != null) {
                for (int j = 0; j < future_array[i].after_school.length; j++) {
                    if (Stats.get_after_school() == future_array[i].after_school[j])
                        break;
                    // If no match
                    if (j == future_array[i].after_school.length - 1)
                        continue future_loop;
                }
            }
            // Trait Array
            if (future_array[i].trait_array != null) {
                // Trait Array
                // Future Trait Loop
                for (int k=0; k<future_array[i].trait_array.length; k++) {
                    // Stats Trait Loop
                    for (int l = 0; l < Stats.getTrait_array().length; l++) {
                        // Title Match
                        if (future_array[i].trait_array[k].getTitle().equals(Stats.getTrait(l).getTitle())) {
                            // Value Match
                            // Negative Value
                            if (future_array[i].trait_array[k].getValue() < 0) {
                                if (!(Stats.getTrait(l).getValue() <= future_array[i].trait_array[k].getValue()))
                                    continue future_loop;
                            }
                            // Positive Value
                            else {
                                if (!(Stats.getTrait(l).getValue() >= future_array[i].trait_array[k].getValue()))
                                    continue future_loop;
                            }
                        }
                    }
                }
            }

            // Fill Local Array
            local_array.add(future_array[i]);
        }

        // Grab random Qualified Future
        int index = rand.nextInt(local_array.size());
        Future = local_array.get(index);
    }

    public class_FutureQuestion get_FutureQuestion(int storynum)
    {
        ArrayList<class_FutureQuestion> local_array = new ArrayList<>();
        int rare = new Random().nextInt(101);
        future: for (int i = 0; i < Future.story.length; i++)
        {
            if (Future.story[i].getStorynum() == storynum)
            {
                // Rare
                if (Future.story[i].getRare() > rare)
                    continue;
                // skill
                if (Future.story[i].getQual_skill() != null && !Future.story[i].getQual_skill().equals(Stats.getSkill_1()))
                    continue;
                local_array.add(Future.story[i]);
            }
        }
        if (local_array.size() > 1)
        {
            for (int i=0; i<local_array.size(); i++){
                fut_que = local_array.get(i);
                if(local_array.get(i+1).getRare() > local_array.get(i).getRare())
                    fut_que = local_array.get(i+1);
                if(i == local_array.size() -1)
                    break;
            }
        }
        else
            fut_que = local_array.get(0);
        return fut_que;
    }

    public ArrayList<String> trait_value_strings()
    {
        ArrayList<String> ret = new ArrayList<>();

        ret.add(Integer.toString(Stats.getTrait(0).getValue()));
        ret.add(Integer.toString(Stats.getTrait(1).getValue()));
        ret.add(Integer.toString(Stats.getTrait(2).getValue()));
        ret.add(Integer.toString(Stats.getTrait(3).getValue()));
        ret.add(Integer.toString(Stats.getTrait(4).getValue()));
        ret.add(Integer.toString(Stats.getTrait(5).getValue()));
        ret.add(Integer.toString(Stats.getTrait(6).getValue()));
        ret.add(Future.title);
        return ret;
    }
}


