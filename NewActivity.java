package com.example.user.ki_word;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class NewActivity extends AppCompatActivity {

    private static int REGISTER_ACTION = 100;

    private EditText newId;
    private EditText newPw;
    private EditText newNick;

    private final String link = "http://52.78.164.46/new.php";
    AsyncHttpClient client;
    HttpResponse httpresponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        client = new AsyncHttpClient();
        httpresponse = new HttpResponse(this);

        Button buttRegister = (Button)findViewById(R.id.buttRegister);
        Button buttBack = (Button)findViewById(R.id.buttBack);
        newId = (EditText)findViewById(R.id.editNewId);
        newPw = (EditText)findViewById(R.id.editNewPw);
        newNick = (EditText)findViewById(R.id.editNewNick);



        buttRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  //회원가입 버튼 (디비와 연결)
              //  System.out.println("1111111111111111111111111");
                RequestParams params = new RequestParams();
               // System.out.println("2222222222222222222222222");
                String id = newId.getText().toString();
                String pw = newPw.getText().toString();
                String nick = newNick.getText().toString();
             //   System.out.println("33333333333333333333333333");
               // System.out.println(id);
               // System.out.println(pw);
               // System.out.println(nick);
              //  System.out.println("4444444444444444444444444444");
                params.put("ID", id.trim());
                params.put("PW", pw.trim());
                params.put("Name", nick.trim());
              //  System.out.println(params);
              //  System.out.println(link);
               // System.out.println("555555555555555555555555555555");


               client.post(link, params, httpresponse);
                Intent intent = new Intent(NewActivity.this, MainActivity.class);
                //startService(intent);
                startActivity(intent);
            }
        });

        buttBack.setOnClickListener(new View.OnClickListener() { //뒤로가기 버튼
            public void onClick(View v) {
                finish();
            }
        });
    }

    private class HttpResponse extends AsyncHttpResponseHandler {

        Activity activity;

        public HttpResponse(Activity activity) {
            this.activity=activity;
        }

        @Override
        public void onSuccess(String content) {
            System.out.println("!!!!!!!onsuccess!!!!!1");
            //Log.d("Result", content);
            Toast.makeText(getApplicationContext(), "Success to register", Toast.LENGTH_SHORT).show();

            //String resNames = "";

            //String res[] = content.split("/");

            //resNames = res[res.length-1];

            //Log.d("Result",resNames);

          //  Intent intent=new Intent(NewActivity.this, MainActivity.class);
          //  startActivity(intent);
        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
            System.out.println("!111!!!!!!!!!!!!!1onFailure!!!!!!!!!!!!!!!!!");
           // Toast.makeText(getApplicationContext(), "Failed to register", Toast.LENGTH_SHORT).show();

        }


    }


}
