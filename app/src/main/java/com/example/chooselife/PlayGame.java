package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

    public void trait_question(int stage){
        // Get Stage 1 Question
        Intent trait_que = new Intent(this, TraitQuestionPage.class);
        trait_que.putExtra("stage", stage);
        startActivityForResult(trait_que, stage);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 0){
            trait_question(1);
        }
        else if (requestCode == 1){
            String[] result = data.getStringArrayExtra("result");
            set_traits(result);
            trait_question(2);
        }
        else if (resultCode == 2){
            String[] result = data.getStringArrayExtra("result");
            set_traits(result);
            trait_question(3);
        }
        else if (requestCode == 3){
            String[] result = data.getStringArrayExtra("result");
            set_traits(result);
            // Stage 4 Question
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
