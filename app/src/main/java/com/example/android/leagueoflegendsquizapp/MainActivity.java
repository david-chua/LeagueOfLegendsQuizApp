package com.example.android.leagueoflegendsquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitExam(View view) {
        totalScore = 0;

        RadioButton questionOneButton = (RadioButton) findViewById(R.id.q1A);
        boolean q1AisChecked = questionOneButton.isChecked();

        RadioButton questionTwoButton = (RadioButton) findViewById(R.id.q2C);
        boolean q2CisChecked = questionTwoButton.isChecked();

        EditText questionFormBox = (EditText) findViewById(R.id.third_question);
        String thirdAnswer = questionFormBox.getText().toString().toLowerCase();

        RadioButton questionFourButton = (RadioButton) findViewById(R.id.q4D);
        boolean q4DisChecked = questionFourButton.isChecked();

        RadioButton questionFiveButton = (RadioButton) findViewById(R.id.q5A);
        boolean q5AisChecked = questionFiveButton.isChecked();

        CheckBox firstChoice = (CheckBox) findViewById(R.id.q6A);
        boolean luluIsChecked = firstChoice.isChecked();

        CheckBox secondChoice = (CheckBox) findViewById(R.id.q6C);
        boolean gnarisChecked = secondChoice.isChecked();

        CheckBox thirdChoice = (CheckBox) findViewById(R.id.q6D);
        boolean corkiisChecked = thirdChoice.isChecked();

        double finalScore = calculateScore(q1AisChecked, q2CisChecked, thirdAnswer, q4DisChecked, q5AisChecked, luluIsChecked, gnarisChecked, corkiisChecked);

        String scoreMessage = createScoreMessage(finalScore);
        displayMessage(scoreMessage);

    }

    private String createScoreMessage(double finalScore) {
        String scoreMessage = "Your total score is: " + finalScore;
        scoreMessage += "\n You have scored " + ((finalScore / 6) * 100) + "%";
        return scoreMessage;
    }

    private void displayMessage(String message) {
        TextView scoreSummaryTextView = (TextView) findViewById(R.id.total_score_view);
        scoreSummaryTextView.setText(message);
    }

    private String resetMessage() {
        String scoreMessage = "Total Score: " + totalScore;
        return scoreMessage;
    }


    private int calculateScore(boolean q1AisChecked, boolean q2CisChecked, String thirdAnswer, boolean q4DisChecked, boolean q5AisChecked, boolean luluIsChecked, boolean gnarisChecked, boolean corkiisChecked) {
        if (q1AisChecked) {
            totalScore = totalScore + 1;
        }

        if (q2CisChecked) {
            totalScore = totalScore + 1;
        }

        if (thirdAnswer.equals("vi")) {
            totalScore = totalScore + 1;
        }

        if (q4DisChecked) {
            totalScore = totalScore + 1;
        }
        if (q5AisChecked) {
            totalScore = totalScore + 1;
        }
        if (luluIsChecked && gnarisChecked && corkiisChecked) {
            totalScore = totalScore + 1;
        }
        return totalScore;
    }


    public void resetScore(View view) {
        totalScore = 0;
        RadioGroup radioGroupOne = (RadioGroup) findViewById(R.id.radioGroupOne);
        radioGroupOne.clearCheck();

        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);
        radioGroupTwo.clearCheck();

        EditText questionFormBox = (EditText) findViewById(R.id.third_question);
        questionFormBox.setText("");

        RadioGroup radioGroupThree = (RadioGroup) findViewById(R.id.radioGroupThree);
        radioGroupThree.clearCheck();

        RadioGroup radioGroupFour = (RadioGroup) findViewById(R.id.radioGroupFour);
        radioGroupFour.clearCheck();

        CheckBox optionA = (CheckBox) findViewById(R.id.q6A);
        optionA.setChecked(false);

        CheckBox optionB = (CheckBox) findViewById(R.id.q6B);
        optionB.setChecked(false);

        CheckBox optionC = (CheckBox) findViewById(R.id.q6C);
        optionC.setChecked(false);

        CheckBox optionD = (CheckBox) findViewById(R.id.q6D);
        optionD.setChecked(false);

        CheckBox optionE = (CheckBox) findViewById(R.id.q6E);
        optionE.setChecked(false);

        String resetMessage = resetMessage();
        displayMessage(resetMessage);


    }


}



