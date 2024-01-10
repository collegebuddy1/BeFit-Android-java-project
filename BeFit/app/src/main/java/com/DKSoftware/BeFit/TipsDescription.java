package com.DKSoftware.BeFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TipsDescription extends AppCompatActivity {

    private TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_description);

        txtDescription = findViewById(R.id.TxtDescription);
        String description = getIntent().getStringExtra("Description");
        txtDescription.setText(description);
    }

    public void TipsDiscBackButton(View view)
    {
        Intent intent = new Intent(TipsDescription.this,Tips.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(TipsDescription.this,Tips.class);
        startActivity(intent);
        finish();
    }
}