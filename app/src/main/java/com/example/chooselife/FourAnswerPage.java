package com.example.chooselife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourAnswerPage extends AppCompatActivity {
    Button aButton, bButton, cButton, dButton;
    TextView questionText;
    Intent returnIntent = new Intent();
    class_TraitQuestion cur_que = new class_TraitQuestion();
    class_Helper Helper = new class_Helper();
    int stage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_question_page);

        String[] info = getIntent().getStringArrayExtra("info");
        stage = Integer.parseInt(info[0]);
        if (stage < 4)
            cur_que = Helper.get_trait_question(stage);
        else if (stage == 4)
            cur_que = Helper.get_stage4_question();
        else if (stage == 5)
            cur_que = Helper.get_stage5_question("Choose a skill", null);
        else if (stage == 6){
            cur_que = Helper.get_stage6_question();
        }
        else if (stage == 7){
            cur_que = Helper.get_stage7_question(info[1], info[2]);
        }
        else if (stage == 8){
            cur_que = Helper.get_stage8_question(info[1]);
        }

        //Initialize Buttons and Question Prompt
        aButton = (Button)findViewById(R.id.buttonA);
        bButton = (Button)findViewById(R.id.buttonB);
        cButton = (Button)findViewById(R.id.buttonC);
        dButton = (Button)findViewById(R.id.buttonD);
        questionText = (TextView) findViewById(R.id.textView);

        //Set texts for Questions and Answers
        aButton.setText(cur_que.getOptA().getText());
        bButton.setText(cur_que.getOptB().getText());
        cButton.setText(cur_que.getOptC().getText());
        dButton.setText(cur_que.getOptD().getText());
        questionText.setText(cur_que.getQuestion());

    }

       public String[] set_return(class_TraitAnswer option)
        {
            // Traits only
            if (option.get_Life_choice() ==  "") {
                String[] temp = {
                        option.getTrait(0).getTitle(),
                        Integer.toString(option.getTrait(0).getValue()),
                        option.getTrait(1).getTitle(),
                        Integer.toString(option.getTrait(1).getValue())
                };
                return temp;
            }
            // Life Choice Only
            else if (option.getTraitArray().length == 0)
            {
                String[] temp = {
                        option.get_Life_choice()
                };
                return temp;
            }
            //Choice + Trait
            String[] temp = {
                    option.get_Life_choice(),
                    option.getTrait(0).getTitle(),
                    Integer.toString(option.getTrait(0).getValue()),
                    option.getTrait(1).getTitle(),
                    Integer.toString(option.getTrait(1).getValue())
            };
            return temp;
        }

    public void aButton(View view) {
        class_TraitAnswer opt = cur_que.getOptA();
        String[] temp = set_return(opt);
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }
    public void bButton(View view){
        class_TraitAnswer opt = cur_que.getOptB();
        String[] temp = set_return(opt);
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }
    public void cButton(View view){
        class_TraitAnswer opt = cur_que.getOptC();
        String[] temp = set_return(opt);
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }
    public void dButton(View view){
        class_TraitAnswer opt = cur_que.getOptD();
        String[] temp = set_return(opt);
        returnIntent.putExtra("result", temp);
        setResult(stage, returnIntent);
        finish();
    }

}
