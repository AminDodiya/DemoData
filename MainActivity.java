package com.example.brevity.retropostdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.brevity.retropostdemo.been.LoginHandler.LoginReq;
import com.example.brevity.retropostdemo.been.LoginHandler.LoginRes;
import com.example.brevity.retropostdemo.utils.ApiInterface;
import com.example.brevity.retropostdemo.utils.CryptLib;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;
    Button btnlogin;
    EditText edtemail, edtpass;
    String userEmail, suppid, supptypeid, supptype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        castingControl();
        eventControl();
    }
    private void eventControl() {
        btnlogin.setOnClickListener(this);


    }
    private void castingControl() {
        btnlogin = (Button) findViewById(R.id.btnlogin);
        edtemail = (EditText) findViewById(R.id.edtuname);
        edtpass = (EditText) findViewById(R.id.edtpass);
    }

    @Override
    public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnlogin:
                    CheckConnectionForLogin();
                    break;
            }
    }

    private void CheckConnectionForLogin() {
        LoginReq httpReq = new LoginReq();
        httpReq.setEmail(encryptString(context, edtemail.getText().toString().trim()));
        httpReq.setPassword(encryptString(context, edtpass.getText().toString().trim()));


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginRes> call = apiService.getLoginResCall("Supplier/Login",
                RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(httpReq)));
        call.enqueue(new Callback<LoginRes>(){

            @Override
            public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {

                if(response.body().getData() != null) {
                    Log.d("response=", "" + response.body().getData().getEmail());
                }else{
                    Log.d("response=", "" + response.body().getStatusMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginRes> call, Throwable t) {

                Log.d("","invalid id pass");
            }
        });

    }
    public static String encryptString(Context context, String strToEncrypt) {
        String output = "";
        try {
            CryptLib _crypt = new CryptLib();
            String key = CryptLib.SHA256(context.getString(R.string.encrypt_decrypt_key), 32);
            output = _crypt.encrypt(strToEncrypt, key, context.getString(R.string.random_string));
            if (output.substring(output.length() - 1).equals("\n")) {
                output = output.substring(0, output.length() - 1);
            }
           Log.i("Encrypt string",output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
