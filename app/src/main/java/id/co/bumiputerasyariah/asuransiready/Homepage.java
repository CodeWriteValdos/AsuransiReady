package id.co.bumiputerasyariah.asuransiready;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    Context mContext;
    CardView asuransiperjalanan, asuransimobil, asuransikesehatan, asuransijiwaberjangka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        InitViews();

        asuransiperjalanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(mContext, PageAsuransiPerjalanan.class);
                startActivity(ap);
            }
        });

        asuransimobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent am = new Intent(mContext, PageAsuransiMobile.class);
                startActivity(am);
            }
        });

        asuransikesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ak = new Intent(mContext, PageAsuransiKesehatan.class);
                startActivity(ak);
            }
        });

        asuransijiwaberjangka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajb = new Intent(mContext, PageAsuransiJiwaBerjangka.class);
                startActivity(ajb);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menutab, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.help:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent ilogout = new Intent(mContext, Login.class);
                startActivity(ilogout);
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void InitViews(){
        mContext = this;
        asuransiperjalanan = (CardView)findViewById(R.id.cvasuransiperjalanan);
        asuransimobil = (CardView)findViewById(R.id.cvasuransimobil);
        asuransikesehatan = (CardView) findViewById(R.id.cvasuransikesehatan);
        asuransijiwaberjangka = (CardView)findViewById(R.id.cvasuransijiwaberlangka);
    }
}
