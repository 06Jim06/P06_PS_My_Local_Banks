package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button DBSw;
    Button DBSc;
    Button OCBCw;
    Button OCBCc;
    Button UOBw;
    Button UOBc;
    String url = "";
    String Translate1 = "";
    String Translate2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBSw = findViewById(R.id.DBS_web);
        DBSc = findViewById(R.id.DBS_contact);
        OCBCw = findViewById(R.id.OCBC_web);
        OCBCc = findViewById(R.id.OCBC_contact);
        UOBw = findViewById(R.id.UOB_web);
        UOBc = findViewById(R.id.UOB_contact);

        DBSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://www.dbs.com.sg/index/default.page";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
        DBSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
            }
        });

        OCBCw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://www.ocbc.com/group/gateway.page";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
        OCBCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(intentCall);
            }
        });

        UOBw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://www.uobgroup.com/uobgroup/default.page";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
        UOBc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 222 2121"));
                startActivity(intentCall);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.EnglishSelection) { //check whether the selected menu item ID is 0
            //code for action
            Toast.makeText(MainActivity.this, "Translated to English", Toast.LENGTH_LONG).show();
            Translate1 = "Website";
            Translate2 = "Contact the bank";
            DBSw.setText(Translate1);
            DBSc.setText(Translate2);
            OCBCw.setText(Translate1);
            OCBCc.setText(Translate2);
            UOBw.setText(Translate1);
            UOBc.setText(Translate2);

            return true; //menu item successfully handled
        }
        else if(item.getItemId() == R.id.ChineseSelection) {
            Toast.makeText(MainActivity.this, "已翻译成中文", Toast.LENGTH_LONG).show();
            Translate1 = "网页";
            Translate2 = "联系银行";
            DBSw.setText(Translate1);
            DBSc.setText(Translate2);
            OCBCw.setText(Translate1);
            OCBCc.setText(Translate2);
            UOBw.setText(Translate1);
            UOBc.setText(Translate2);
            return true; //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}