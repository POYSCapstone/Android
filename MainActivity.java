package com.example.user.ki_word;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


public class MainActivity extends AppCompatActivity {

    AsyncHttpClient client;
    Httpresponse httpresponse;
    RequestParams para;


    private final String link = "http://52.79.54.169/and1.php";
    private final String link2 = "http://52.79.54.169/db.php";
    public static  String[][] result;
    String userId = new String();



    String userPw = new String();
    private EditText editId;
    private EditText editPw;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        client = new AsyncHttpClient();
        httpresponse = new Httpresponse(this);
        para = new RequestParams();
        para.put("X", "Y");


        Button buttNew = (Button)findViewById(R.id.buttNew);
        Button buttLogin = (Button)findViewById(R.id.buttLogin);
        Button phpbutton = (Button)findViewById(R.id.phpbutton);
        editId = (EditText)findViewById(R.id.editId);
        editPw = (EditText)findViewById(R.id.editPw);

        client.post(link, para, httpresponse);

        buttNew.setOnClickListener(new View.OnClickListener() { //회원가입 버튼
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);


            }
        });


        phpbutton.setOnClickListener(new View.OnClickListener() { //회원가입 버튼
            public void onClick(View v) {

                System.out.println(result.length);




            }
        });

        buttLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //로그인 버튼(메뉴페이지)
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);



                userId = editId.getText().toString();
                userPw = editPw.getText().toString();

                int check = 0;

                    if(userId.equals("root")){
                        check = 1;
                        if(userPw.equals("1234")){
                            Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                        }

                    }

                System.out.println("!!!!!!!!!!!!!!!!!!!!!userId!!!!!!!!!!!!!!!!!!!!!!!!!!");
                //System.out.println(result[0]);
                System.out.println(userId);
                System.out.println(userPw);
                if(check==0) {
                    Toast.makeText(getApplicationContext(), "Wrong Id", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    //
    //

    private class Httpresponse extends AsyncHttpResponseHandler {

        Activity activity;

        public Httpresponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onSuccess(String content) {

          System.out.println(content);

            String[] consplit = content.split("\"");

            int count1 =0;
            for(String k : consplit){

                if(!k.equals("")){
                    count1++;
                }
            }

            int row = count1 / 3;

            String[] temp = new String[count1];
            int aa=0;
            for(String k : consplit){

                if(!k.equals("")){
                    temp[aa] = k;
                    aa++;
                }
            }


            result = new String[row][3];

            int count =0;

            for(int i =0 ; i< row;i++){

                for(int j=0; j<3;j++){
                    result[i][j] = temp[count++];
                }

            }


        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
            super.onFailure(statusCode, error, content);
            Toast.makeText(activity, "Please check your network", Toast.LENGTH_SHORT).show();
        }
    }


}
