package com.DKSoftware.BeFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tips extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        listView = findViewById(R.id.List);

        String[] tipsTitle = getResources().getStringArray(R.array.TipsTile);
        final String[] tipsDescription = getResources().getStringArray(R.array.TipsDescription);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.row,R.id.TxtTip,tipsTitle);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String description = tipsDescription[i];
                Intent intent = new Intent(Tips.this,TipsDescription.class);
                intent.putExtra("Description",description);
                startActivity(intent);
                finish();
            }
        });
    }

    public void TipsBackButton(View view)
    {
        Intent intent = new Intent(Tips.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Tips.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}