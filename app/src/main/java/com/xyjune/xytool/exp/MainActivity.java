package com.xyjune.xytool.exp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.xyjune.tools.GsonTool;
import com.xyjune.tools.TimeUtil;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KV kv = new KV();
        kv.setA("sakldjnlaksd");
        kv.setDate(TimeUtil.getCurrentDate());

        Log.d(TAG, "onCreate: " + GsonTool.toJson(kv, GsonTool.GSON_LOGGER));
    }

    private class KV {

        private String a;

        private String b;

        private Date mDate;

        public Date getDate() {
            return mDate;
        }

        public void setDate(Date date) {
            mDate = date;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}