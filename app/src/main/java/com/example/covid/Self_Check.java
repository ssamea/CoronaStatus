package com.example.covid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.spark.submitbutton.SubmitButton;

import java.util.Arrays;

import javax.xml.transform.Result;

public class Self_Check extends Fragment {

    TextView[] questions=new TextView[5];
    boolean[] answers=new boolean[5];
    SubmitButton spark;
    Animation fadeIn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.activity_self__check, container, false);
        spark=v.findViewById(R.id.spark_button);
        fadeIn= AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in);
        Arrays.fill(answers,Boolean.FALSE);

        for (int i=0;i<5;i++){
            int id = getResources().getIdentifier("que"+(i+1), "id", "com.example.covid");
            questions[i]=v.findViewById(id);
            final int finalI = i;
            questions[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(answers[finalI]){
                        answers[finalI]=false;
                        questions[finalI].setTextColor(Color.parseColor("#000000"));

                    }else{
                        answers[finalI]=true;
                        questions[finalI].startAnimation(fadeIn);
                        questions[finalI].setTextColor(Color.parseColor("#728789"));
                    }
                }
            });
        }

        spark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String result;
                int count=0;
                for (int i =0;i<5;i++){
                    if(answers[i])
                        count++;
                }
                if (count >2 || answers[2]){
                    result="위험";
                }else{
                    result="조심";
                }
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            Thread.sleep(3500);
                            Intent intent=new Intent(getActivity(), result.class);
                            intent.putExtra("result", result);
                            startActivity(intent);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();

            }
        });


        return v;
    }
}