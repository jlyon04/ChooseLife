package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlayGame extends AppCompatActivity {
    int stage_count = 1;
    class_Helper Helper = new class_Helper();
    class_Trait Trait = new class_Trait();
    class_GameStats Stats = new class_GameStats(Trait.new_array());
    class_Future Future = new class_Future();
    class_TraitQuestion cur_que = new class_TraitQuestion();
    class_FutureQuestion fut_que = new class_FutureQuestion();
    static final int INTRO_README = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        //Initial Readme
        Intent starting_readme = new Intent(this, ReadMe.class);
        starting_readme.putExtra("Readme", Helper.get_ReadMe("start"));
        startActivityForResult(starting_readme, INTRO_README);
    }

    public void start_question(int stage, int storynum)
    {
        Intent trait_que = new Intent(this, FourAnswerPage.class);
        if (stage < 4)
            cur_que = Helper.get_trait_question(stage);
        else if (stage == 4)
            cur_que = Helper.get_stage4_question();
        else if (stage == 5)
            cur_que = Helper.get_stage5_question("choose a skill", null);
        else if (stage == 6)
            cur_que = Helper.get_stage6_question();
        else if (stage == 7)
            cur_que = Helper.get_stage7_question(Stats.get_love(), Stats.getSkill_1());
        else if (stage == 8)
            cur_que = Helper.get_stage8_question(Stats.get_love());
        // TODO
        else if (stage == 9)
            fut_que = Helper.get_FutureQuestion(0, Future.title);


        if (stage < 9) {
                String[] info_str = {
                        cur_que.getQuestion(),
                        cur_que.getOptA().getText(),
                        cur_que.getOptB().getText(),
                        cur_que.getOptC().getText(),
                        cur_que.getOptD().getText(),
            };
            trait_que.putExtra("info", info_str);
        }
        else{
            String[] info_str = {
                    fut_que.getQuestion(),
                    fut_que.getOptA().getText(),
                    fut_que.getOptB().getText(),
                    fut_que.getOptC().getText(),
                    fut_que.getOptD().getText(),
            };
            trait_que.putExtra("info", info_str);
        }
        startActivityForResult(trait_que, stage);
    }


    public class_TraitAnswer getOpt(String option)
    {
        switch(option) {
            case "a":
                return cur_que.getOptA();
            case "b":
                return cur_que.getOptB();
            case "c":
                return cur_que.getOptC();
            case "d":
                return cur_que.getOptD();
        }
        return new class_TraitAnswer();
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        class_TraitAnswer opt = new class_TraitAnswer();
        String result = data.getStringExtra("result");
        opt = getOpt(result);
        //TODO: Move results outside of oif statements
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
            Stats.set_love(opt.get_Life_choice());
            if (opt.get_Life_choice().equals("No Love"))
                set_traits(opt.getTraitArray());
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
            start_question(7,0);
        }
        //Q7 Return
        else if (requestCode == 7)
        {
            if (opt.get_Life_choice().equals("Love"))
                Stats.set_love("Love");
            else
                Stats.setSkill_2(opt.get_Life_choice());
            start_question(8,0);
        }
        //Q8 Return
        else if (requestCode == 8){
            if (opt.get_Life_choice().equals("0"))
               Stats.set_kids("0");
            else if (opt.get_Life_choice().equals("1"))
                Stats.set_kids("1");
            else if (opt.get_Life_choice().equals("2"))
                Stats.set_kids("2");
            else
                Stats.setCrime(opt.get_Life_choice());
            setFuture();
            start_question(9,0);
        }
        //TODO
        else if (requestCode > 8){

        }
    }

    public void set_traits(class_Trait[] answer_traits)
    {
        for (int i =0; i < answer_traits.length; i++)
        {
            for (int j=0; j<Stats.getTrait_array().length;j++)
            {
                if(Stats.getTrait(j).getTitle().equals(answer_traits[i]))
                {
                    Stats.getTrait(j).addValue(answer_traits[i].getValue());
                }
            }
        }

    }

    public void setFuture()
    {
        Random rand = new Random();
        class_Future[] future_array = Helper.futureArray;
        ArrayList<class_Future> local_array = new ArrayList<>();
        //Loop through all Futures
        future_loop: for (int i =0; i < future_array.length; i++){
            // Love
            if (future_array[i].love != null && !Stats.get_love().equals(future_array[i].love))
                continue;
            // Kids
            if (future_array[i].kids != null && !Stats.getKids().equals(future_array[i].kids))
                continue;
            // Skill 1
            if (future_array[i].skill_1 != null && !Stats.getSkill_1().equals(future_array[i].skill_1))
                continue;
            // Skill 2
            if (future_array[i].skill_2 != null && !Stats.getSkill_2().equals(future_array[i].skill_2))
                continue;
            // Crime
            if (future_array[i].crime != null && !Stats.getCrime().equals(future_array[i].crime))
                continue;
            // After School
            for (int j=0; j<future_array[i].after_school.length; j++) {
                if (future_array[i].after_school == null || Stats.get_after_school() == future_array[i].after_school[j])
                    break;
                else if (j == future_array[i].after_school.length - 1)
                    continue;
            }

            // Trait Array
            // Future Trait Loop
            for (int k=0; k<future_array[i].trait_array.length; k++){
                // Stats Trait Loop
                for (int l=0; l<Stats.getTrait_array().length; l++){
                    // Title Match
                    if (future_array[i].trait_array[k].getTitle().equals(Stats.getTrait(l).getTitle())){
                        // Value Match
                        // Negative Value
                        if (future_array[i].trait_array[k].getValue() < 0){
                            if (!(Stats.getTrait(l).getValue() <= future_array[i].trait_array[k].getValue()))
                                continue future_loop;
                        }
                        // Positive Value
                        else{
                            if (!(Stats.getTrait(l).getValue() >= future_array[i].trait_array[k].getValue()))
                                continue future_loop;
                        }
                    }
                }
            }
            // Fill Local Array
            local_array.add(future_array[i]);
        }
        int index = rand.nextInt(local_array.size());
        Future = local_array.get(index);
    }
}
