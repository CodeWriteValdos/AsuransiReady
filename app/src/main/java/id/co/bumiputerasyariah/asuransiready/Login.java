package id.co.bumiputerasyariah.asuransiready;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    ProgressDialog progressDialog;
    Button buttonlogin;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitViews();

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                progressDialog.setMessage("Mohon Tunggu...");
                Intent ilogin = new Intent(mContext, Homepage.class);
                startActivity(ilogin);
                progressDialog.dismiss();
                finish();
            }
        });
    }

    private void InitViews(){
        progressDialog = new ProgressDialog(this);
        mContext = this;
        buttonlogin = (Button)findViewById(R.id.btnLogin);
    }

}
