package id.co.bumiputerasyariah.asuransiready;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView mulai;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        InitViews();

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imulai = new Intent(mContext, Login.class);
                startActivity(imulai);
            }
        });
    }

    public void InitViews(){
        mContext = this;
        mulai = (ImageView)findViewById(R.id.startlogo);
    }
}
