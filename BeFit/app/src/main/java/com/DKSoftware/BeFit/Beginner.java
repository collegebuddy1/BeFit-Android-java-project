package com.DKSoftware.BeFit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Beginner extends AppCompatActivity {

    private int arr[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        arr = new int[]
        {
            R.id.bowPose,R.id.bridgePose,R.id.chairPose,R.id.childPose,R.id.cobblerPose,R.id.cowPose,R.id.playjiPose,R.id.pausejiPose,R.id.plankPose
            ,R.id.crunchesPose,R.id.situpPose,R.id.rotationPose,R.id.twistPose,R.id.legupPose,R.id.windmillPose,
        };
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Beginner.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.MenuPrivacyPolicy)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dksoftware.netlify.app/BeFit_PrivacyPolicy.txt"));
            startActivity(intent);
            return true;
        }
        else if(id == R.id.MenuAboutUs)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dksoftware.netlify.app/"));
            startActivity(intent);
            return true;
        }
        else if(id == R.id.MenuRateUs)
        {
            try
            {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            }
            catch (Exception es)
            {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }
            return true;
        }
        else if(id == R.id.MenuMoreApps)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=DK_Software"));
            startActivity(intent);
            return true;
        }
        else if(id == R.id.MenuShare)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBody = "This is best fitness app I have been using it from so many days.\nAll this has been written by me seriously\nDownload the app for free on PlayStore\n" + "https://play.google.com/store/apps/details?id=com.DKSoftware.BeFit&hle=el";
            String shareHub = "Be Fit";
            intent.putExtra(Intent.EXTRA_SUBJECT,shareHub);
            intent.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(intent,"Make your friend Healthy"));

            return true;
        }

        return true;
    }


    public void ImageButtonClick(View view)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if(view.getId() == arr[i])
            {
                int val = i+1;
                Log.i("FIRST",String.valueOf(val));
                Intent intent = new Intent(Beginner.this,Exercise.class);
                intent.putExtra("value",String.valueOf(val));
                startActivity(intent);
                finish();
            }
        }
    }
}