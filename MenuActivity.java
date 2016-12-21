package com.example.user.ki_word;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private static int REGISTER_ACTION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttVoca = (Button)findViewById(R.id.buttVoca);
        Button buttTale = (Button)findViewById(R.id.buttTale);
        Button buttGame = (Button)findViewById(R.id.buttGame);
        Button buttLogout = (Button)findViewById(R.id.buttLogout);

        buttVoca.setOnClickListener(new View.OnClickListener() { //단어학습 버튼
            public void onClick(View v) {
                //Intent intent = new Intent(MenuActivity.this, VocaActivity.class);
                //startActivityForResult(intent, REGISTER_ACTION);
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.kiword.kiword");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });

        buttTale.setOnClickListener(new View.OnClickListener() { //3D동화 버튼
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TaleActivity.class);
                startActivity(intent);
                //startActivityForResult(intent, REGISTER_ACTION);
            }
        });

        buttGame.setOnClickListener(new View.OnClickListener() {  //3D게임 버튼
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(intent);
                //startActivityForResult(intent, REGISTER_ACTION);
            }
        });

        buttLogout.setOnClickListener(new View.OnClickListener() {  //로그아웃(뒤로가기)
            public void onClick(View v) {
                //finish();
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
