package com.DKSoftware.BeFit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Exercise extends AppCompatActivity {

    private TextView txtInstruction;
    private GifImageView gifExercise;
    private Button buttonStart;
    private TextView txtTime;

    private CountDownTimer countDownTimer;
    private long leftTime;
    private String buttonVal;
    private boolean isTimeRuning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Reference();
        OpenExercise();
    }

    private void Reference()
    {
        gifExercise = findViewById(R.id.GifExercise);
        txtInstruction = findViewById(R.id.TxtInstruction);
        buttonStart = findViewById(R.id.ButtonStart);
        txtTime = findViewById(R.id.TxtTime);

        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(isTimeRuning)
                {
                    StopTimer();
                }
                else
                {
                    StartTimer();
                }
            }
        });
    }

    private void OpenExercise()
    {
        Intent intent = getIntent();
        buttonVal = intent.getStringExtra("value");

        int val = Integer.valueOf(buttonVal);
        switch (val)
        {
            case 1:
                gifExercise.setImageResource(R.drawable.exersice_1);
                txtInstruction.setText(R.string.pose1);
                break;
            case 2:
                gifExercise.setImageResource(R.drawable.exersice_2);
                txtInstruction.setText(R.string.pose2);
                break;
            case 3:
                gifExercise.setImageResource(R.drawable.exersice_3);
                txtInstruction.setText(R.string.pose3);
                break;
            case 4:
                gifExercise.setImageResource(R.drawable.exersice_4);
                txtInstruction.setText(R.string.pose4);
                break;
            case 5:
                gifExercise.setImageResource(R.drawable.exersice_5);
                txtInstruction.setText(R.string.pose5);
                break;
            case 6:
                gifExercise.setImageResource(R.drawable.exersice_6);
                txtInstruction.setText(R.string.pose6);
                break;
            case 7:
                gifExercise.setImageResource(R.drawable.exersice_7);
                txtInstruction.setText(R.string.pose7);
                break;
            case 8:
                gifExercise.setImageResource(R.drawable.exersice_8);
                txtInstruction.setText(R.string.pose8);
                break;
            case 9:
                gifExercise.setImageResource(R.drawable.exersice_9);
                txtInstruction.setText(R.string.pose9);
                break;
            case 10:
                gifExercise.setImageResource(R.drawable.exersice_10);
                txtInstruction.setText(R.string.pose10);
                break;
            case 11:
                gifExercise.setImageResource(R.drawable.exersice_11);
                txtInstruction.setText(R.string.pose11);
                break;
            case 12:
                gifExercise.setImageResource(R.drawable.exersice_12);
                txtInstruction.setText(R.string.pose12);
                break;
            case 13:
                gifExercise.setImageResource(R.drawable.exersice_13);
                txtInstruction.setText(R.string.pose13);
                break;
            case 14:
                gifExercise.setImageResource(R.drawable.exersice_14);
                txtInstruction.setText(R.string.pose14);
                break;
            case 15:
                gifExercise.setImageResource(R.drawable.exersice_15);
                txtInstruction.setText(R.string.pose15);
                break;
        }
    }

    private void StopTimer()
    {
        countDownTimer.cancel();
        isTimeRuning = false;
        buttonStart.setText("START");
    }

    private void StartTimer()
    {
        final CharSequence timeChar = txtTime.getText();
        String timeStr = timeChar.toString();
        String minStr = timeStr.substring(0, 2);
        String secStr = timeStr.substring(3, 5);

        final int time = Integer.valueOf(minStr) * 60 + Integer.valueOf(secStr);
        leftTime = time * 1000;

        countDownTimer = new CountDownTimer(leftTime,1000) {
            @Override
            public void onTick(long l) {
                leftTime = l;
                UpdateTimer();
            }

            @Override
            public void onFinish() {
                int newVal = Integer.valueOf(buttonVal) + 1;
                if(newVal <= 7)
                {
                    Intent intent = new Intent(Exercise.this,Exercise.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newVal));
                    startActivity(intent);
                    finish();
                }
                else
                {
                    newVal = 1;
                    Intent intent = new Intent(Exercise.this,Exercise.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newVal));
                    startActivity(intent);
                    finish();
                }
            }
        }.start();

        buttonStart.setText("Pause");
        isTimeRuning = true;
    }

    private void UpdateTimer()
    {
        int min = (int)leftTime/60000;
        int sec = (int)leftTime%60000/1000;

        String timeLeft = "";

        if(min < 10)
            timeLeft = "0";
        timeLeft += + min +":";

        if(sec < 10)
            timeLeft += "0";
        timeLeft += sec;

        txtTime.setText(timeLeft);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Exercise.this,Beginner.class);
        startActivity(intent);
        finish();
    }
}