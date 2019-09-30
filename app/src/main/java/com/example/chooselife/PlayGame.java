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
    static final int STAGE_1_REQUEST = 1;
    static final int INTRO_README = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        //Initial Readme
        Intent starting_readme = new Intent(this, ReadMe.class);
        starting_readme.putExtra("Readme", Helper.get_ReadMe("start"));
        startActivityForResult(starting_readme, INTRO_README);
    }

    public void play_game(){
        // Get Stage 1 Question
        Intent stage1 = new Intent(this, TraitQuestionPage.class);
        stage1.putExtra("stage", 1);
        startActivityForResult(stage1, STAGE_1_REQUEST);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String[] result = data.getStringArrayExtra("result");
                set_traits(result);
            }
            if (requestCode == Activity.RESULT_CANCELED){
            }
        }
        else if (requestCode == 2){
                play_game();
        }
    }

    public void set_traits(@org.jetbrains.annotations.NotNull String[] trait_array){
        int trait_val_1 = Integer.parseInt(trait_array[1]);
        int trait_val_2 = Integer.parseInt(trait_array[3]);
        int i=0;
        while (i < 4){
            int h=0;
            while(trait_array[i] != Stats.getTraitArray()[h].getTitle())
                h++;
            if (i==0)
                Stats.addToTrait(h, trait_val_1);
            else
                Stats.addToTrait(h, trait_val_2);
            i += 2;
        }

    }


}
