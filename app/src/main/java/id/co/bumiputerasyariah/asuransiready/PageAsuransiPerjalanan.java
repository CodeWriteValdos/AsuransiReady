package id.co.bumiputerasyariah.asuransiready;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PageAsuransiPerjalanan extends AppCompatActivity {

    Context mContext;
    Calendar calendar = Calendar.getInstance();
    DateFormat dateFormat = DateFormat.getDateInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Button tawal, takhir;
    TextView awal, akhir;
    ProgressDialog progressDialog;

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    DatePickerDialog.OnDateSetListener dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updatelost();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_asuransi_perjalanan);

        InitViews();
        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(toolbar);

        tawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                progressDialog.dismiss();
                new DatePickerDialog(mContext, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                updateLabel();
            }
        });

        takhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                progressDialog.dismiss();
                new DatePickerDialog(mContext, dateSetListener2, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                updatelost();
            }
        });

    }

    private void InitViews(){
        mContext = this;
        takhir = (Button)findViewById(R.id.tglakhir);
        tawal = (Button)findViewById(R.id.tglawal);
        awal = (TextView)findViewById(R.id.tvawal);
        akhir = (TextView)findViewById(R.id.tvakhir);
        progressDialog = new ProgressDialog(this);
    }

    private void updateLabel(){
        awal.setText(dateFormat.format(calendar.getTime()));
    }

    private void updatelost(){
        akhir.setText(dateFormat.format(calendar.getTime()));
    }
}
