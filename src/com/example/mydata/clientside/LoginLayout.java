package com.example.mydata.clientside;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mydata.R;

@SuppressLint("NewApi")
public class LoginLayout extends Activity {
 EditText un, pw;
 TextView error;
 Button ok;
 String result;
 Integer uid;
 String name;
 private String errorMsg;
 private static final String TAG = "LoginLayout";  

 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  un = (EditText) findViewById(R.id.et_un);
  pw = (EditText) findViewById(R.id.et_pw);
  ok = (Button) findViewById(R.id.btn_login);
  error = (TextView) findViewById(R.id.tv_error);

  ok.setOnClickListener(new View.OnClickListener() {

   @Override
   public void onClick(View v) {
       // Creating alert Dialog with one Button
	   
    /** According with the new StrictGuard policy,  running long tasks on the Main UI thread is not possible
    So creating new thread to create and execute http operations */
    new Thread(new Runnable() {

     @Override
     public void run() {
      String username = un.getText().toString();
      String password = pw.getText().toString();

      User user = null;
      try {
    	 Log.i(TAG, "user name= "+username+" password ="+password); 
    	 user = SimpleHttpClient.getAuthenticateJsonFromPost(username,password);
    	 if(user != null){
    		 //Toast.makeText(getApplication(), user.getName(), Toast.LENGTH_SHORT).show();
    		 result = user.getFn();
    		 uid = user.getUid();
    		 name = user.getName();
    		 Log.i(TAG, "result ="+result);    		 
//    		 UserDetailLayout userDetail = new UserDetailLayout();
//    		 userDetail.setName(result.getName());
    		 
    	 }

      } catch (Exception e) {
       e.printStackTrace();
       errorMsg = e.getMessage();
      }
     }

    }).start();
    
    /** Inside the new thread we cannot update the main thread
    So updating the main thread outside the new thread */
    try {
     if (result != null && !result.isEmpty()) {
    	 error.setText("Welcome "+result +",\n Name:" + name  + "\n UID:"+uid);
    	 
     } else {
      //error.setText("Wrong username/password ");
     }
     if (null != errorMsg && !errorMsg.isEmpty()) {
      error.setText(errorMsg);
     }
    } catch (Exception e) {
     error.setText(e.getMessage());
    }
   }
  });
 }
}