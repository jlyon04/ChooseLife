package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;

public class PlayGame extends AppCompatActivity {
    int stage_count = 1;
    class_Helper Helper = new class_Helper();
    class_Trait Trait = new class_Trait();
    class_GameStats Stats = new class_GameStats(Trait.new_array());
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

    public void start_question(int stage){
        // Get Stage 1 Question
        Intent trait_que = new Intent(this, FourAnswerPage.class);
        trait_que.putExtra("stage", stage);
        startActivityForResult(trait_que, stage);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // ReadMe
        if (requestCode == 0){
            start_question(1);
        }
        // Trait Q1 - Return
        else if (requestCode == 1){
            String[] result = data.getStringArrayExtra("result");
            set_traits(result);
            start_question(2);
        }
        // Trait Q2 - Return
        else if (resultCode == 2){
            String[] result = data.getStringArrayExtra("result");
            set_traits(result);
            start_question(3);
        }
        // Trait Q3 - Return
        else if (requestCode == 3){
            String[] result = data.getStringArrayExtra("result");
            set_traits(result);
            // Stage 4 Question
            start_question(4);
        }
        // Q4 - Return
        else if (requestCode == 4)
        {
            String[] result = data.getStringArrayExtra("result");
            if (result[0].equals("Girl"))
            {
                Stats.set_girl(true);
            }
            else
            {
                Stats.set_girl(false);
                // Set traits minus the first array index
                set_traits(Arrays.copyOfRange(result, 1, result.length));
            }
            // Stage 5 Question
            start_question(5);
        }
        else if (requestCode == 5)
        {
            String[] result = data.getStringArrayExtra("result");
            Stats.set_after_school(result[0]);
            start_question(6);
        }
        else if (requestCode == 6)
        {

        }
    }

    public void set_traits(@org.jetbrains.annotations.NotNull String[] trait_array){
        int trait_val_1 = Integer.parseInt(trait_array[1]);
        int trait_val_2 = Integer.parseInt(trait_array[3]);
        int i=0;
        while (i < 4){
            int h=0;
            while(!trait_array[i].equalsIgnoreCase(Stats.getTrait(h).getTitle()))
                h++;
            if (i==0)
                Stats.addToTrait(h, trait_val_1);
            else
                Stats.addToTrait(h, trait_val_2);
            i += 2;
        }

    }


}
