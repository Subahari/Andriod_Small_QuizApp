package com.example.cst18010_ca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView  questionTv,questionNumberTv;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore =0,questionAttempted =1,currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTv=findViewById(R.id.idTVQuestion);
        questionNumberTv=findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModelArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos=random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos =random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos =random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });
option3Btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
            currentScore++;
        }
        questionAttempted++;
        currentPos =random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

    }
});

    option4Btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionAttempted++;
            currentPos =random.nextInt(quizModelArrayList.size());
            setDataToViews(currentPos);

        }
    });

    }
    private  void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog =new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV =bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn =bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n:"+currentScore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
private void setDataToViews(int currentPos){
        questionNumberTv.setText("Question Attempted : "+questionAttempted+"/10");
        if(questionAttempted ==10){
            showBottomSheet();
        }else {

            questionTv.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
}
    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("3 cats, 2 parrots, 1 cow are put together. How many legs will be there in all?","22","20","18","16","20"));
        quizModelArrayList.add(new QuizModel("If you take the first alphabet of each word in this proverb, Birds of same flock fly together, and reverse the order it will form the following word.","BOSFFT","TFFSOB","TFSFOB","TSSFOB","TFFSOB"));
        quizModelArrayList.add(new QuizModel(" The mirror image of a clock at 2:45 p.m. will show the following time:","9:15 p.m.","9:15 a.m.","9:15","None of these","9:15"));
        quizModelArrayList.add(new QuizModel(" How many meters will I be away from my home if I travel 5 metres towards north, take a right and travel 4 metres and travel 5 metres towards south?","5","4","10","14","4"));
        quizModelArrayList.add(new QuizModel(" (896)²-(205)² is divisible by 691","691","1101","Both a and b","None of these","Both a and b"));
        quizModelArrayList.add(new QuizModel(" What is the next number in the following series?\n" +"\n" + "1, 3, 8, 19,","38","42","41","40","42"));
        quizModelArrayList.add(new QuizModel(" Which is the odd one out?","Apple","Banana","Jujubes","Raisins","Raisins"));
        quizModelArrayList.add(new QuizModel(" EAT- 5120, BEAT-25120. What is TREAT?","35120","205120","185120","20185120","20185120"));
        quizModelArrayList.add(new QuizModel(" Cake: Bakery:: Beer: X\n" +"\n" + "What is X?","Distillery","Wine shop","Brewery","Vinification","Brewery"));
        quizModelArrayList.add(new QuizModel(" We need to cut a cake in more than 6 pieces. How many cuts we must make atleast to get this?","2","3","4","5","3"));

    }
}