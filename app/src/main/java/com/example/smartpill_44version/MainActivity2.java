package com.example.smartpill_44version;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    String data = "";
    String url = "";
    private long pressedTime;
    String nTime =  "";
    String ss1 = "";
    String ss2 = "";
    String pp1 = "";
    String pp2 = "";
    int go = 0;
    String test = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        SharedPreferences sp = getSharedPreferences("ip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();


        final Button setAlarm = findViewById(R.id.button);
//       final Button alarmUpdate = findViewById(R.id.button2);
        final Button cancelAlarm = findViewById(R.id.button2);
        final EditText sName1 = findViewById(R.id.editTextText);
        final EditText sNameV1 = findViewById(R.id.editTextText2);
        final EditText smorning1 = findViewById(R.id.editTextText3);
        final EditText smorning1V = findViewById(R.id.editTextText6);
        final EditText safternoon1 = findViewById(R.id.editTextText18);
        final EditText safternoon1V = findViewById(R.id.editTextText7);
        final EditText sevening1 = findViewById(R.id.editTextText17);
        final EditText sevening1V = findViewById(R.id.editTextText8);
        final EditText sName2 = findViewById(R.id.editTextText9);
        final EditText sNameV2 = findViewById(R.id.editTextText10);
        final EditText smorning2 = findViewById(R.id.editTextText11);
        final EditText smorning2V = findViewById(R.id.editTextText14);
        final EditText safternoon2 = findViewById(R.id.editTextText29);
        final EditText safternoon2V = findViewById(R.id.editTextText15);
        final EditText sevening2 = findViewById(R.id.editTextText13);
        final EditText sevening2V = findViewById(R.id.editTextText16);

        final EditText pName1 = findViewById(R.id.editTextText19);
        final EditText pNameN1 = findViewById(R.id.editTextText20);
        final EditText pmorning1 = findViewById(R.id.editTextText21);
        final EditText pmorning1V = findViewById(R.id.editTextText23);
        final EditText pafternoon1 = findViewById(R.id.editTextText34);
        final EditText pafternoon1V = findViewById(R.id.editTextText24);
        final EditText pevening1 = findViewById(R.id.editTextText36);
        final EditText pevening1V = findViewById(R.id.editTextText25);
        final EditText pName2 = findViewById(R.id.editTextText26);
        final EditText pNameN2 = findViewById(R.id.editTextText27);
        final EditText pmorning2 = findViewById(R.id.editTextText28);
        final EditText pmorning2V = findViewById(R.id.editTextText31);
        final EditText pafternoon2 = findViewById(R.id.editTextText35);
        final EditText pafternoon2V = findViewById(R.id.editTextText32);
        final EditText pevening2 = findViewById(R.id.editTextText30);
        final EditText pevening2V = findViewById(R.id.editTextText33);
        final TextView Time = findViewById(R.id.textView20);
        final TextView s1 = findViewById(R.id.textView16);
        final TextView s2 = findViewById(R.id.textView17);
        final TextView p1 = findViewById(R.id.textView18);
        final TextView p2 = findViewById(R.id.textView19);

        sName1.setText(sp.getString("sName1", ""));
        sNameV1.setText(sp.getString("sNameV1", ""));
        smorning1.setText(sp.getString("smorning1", ""));
        smorning1V.setText(sp.getString("smorning1v", ""));
        safternoon1.setText(sp.getString("safternoon1", ""));
        safternoon1V.setText(sp.getString("safternoon1V", ""));
        sevening1.setText(sp.getString("sevening1", ""));
        sevening1V.setText(sp.getString("sevening1V", ""));
        sName2.setText(sp.getString("sName2", ""));
        sNameV2.setText(sp.getString("sNameV2", ""));
        smorning2.setText(sp.getString("smorning2", ""));
        smorning2V.setText(sp.getString("smorning2V", ""));
        safternoon2.setText(sp.getString("safternoon2", ""));
        safternoon2V.setText(sp.getString("safternoon2V", ""));
        sevening2.setText(sp.getString("sevening2", ""));
        sevening2V.setText(sp.getString("sevening2V", ""));
        pName1.setText(sp.getString("pName1", ""));
        pNameN1.setText(sp.getString("pNameN1", ""));
        pmorning1.setText(sp.getString("pmorning1", ""));
        pmorning1V.setText(sp.getString("pmorning1V", ""));
        pafternoon1.setText(sp.getString("pafternoon1", ""));
        pafternoon1V.setText(sp.getString("pafternoon1V", ""));
        pevening1.setText(sp.getString("pevening1", ""));
        pevening1V.setText(sp.getString("pevening1V", ""));
        pName2.setText(sp.getString("pName2", ""));
        pNameN2.setText(sp.getString("pNameN2", ""));
        pmorning2.setText(sp.getString("pmorning2", ""));
        pmorning2V.setText(sp.getString("pmorning2V", ""));
        pafternoon2.setText(sp.getString("pafternoon2", ""));
        pafternoon2V.setText(sp.getString("pafternoon2V", ""));
        pevening2.setText(sp.getString("pevening2", ""));
        pevening2V.setText(sp.getString("pevening2V", ""));




        setAlarm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == motionEvent.ACTION_UP) {
                    postDataUsingVolley("");

                    Toast.makeText(MainActivity2.this, "Alarm successfully set", Toast.LENGTH_SHORT).show();}

                if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                    edit.putString("sName1", sName1.getText().toString());
                    edit.putString("sNameV1", sNameV1.getText().toString());
                    edit.putString("smorning1", smorning1.getText().toString());
                    edit.putString("smorning1v", smorning1V.getText().toString());
                    edit.putString("safternoon1", safternoon1.getText().toString());
                    edit.putString("safternoon1V", safternoon1V.getText().toString());
                    edit.putString("sevening1", sevening1.getText().toString());
                    edit.putString("sevening1V", sevening1V.getText().toString());
                    edit.putString("sName2", sName2.getText().toString());
                    edit.putString("sNameV2", sNameV2.getText().toString());
                    edit.putString("smorning2", smorning2.getText().toString());
                    edit.putString("smorning2V", smorning2V.getText().toString());
                    edit.putString("safternoon2", safternoon2.getText().toString());
                    edit.putString("safternoon2V", safternoon2V.getText().toString());
                    edit.putString("sevening2", sevening2.getText().toString());
                    edit.putString("sevening2V", sevening2V.getText().toString());
                    edit.putString("pName1", pName1.getText().toString());
                    edit.putString("pNameN1", pNameN1.getText().toString());
                    edit.putString("pmorning1", pmorning1.getText().toString());
                    edit.putString("pmorning1V", pmorning1V.getText().toString());
                    edit.putString("pafternoon1", pafternoon1.getText().toString());
                    edit.putString("pafternoon1V", pafternoon1V.getText().toString());
                    edit.putString("pevening1", pevening1.getText().toString());
                    edit.putString("pevening1V", pevening1V.getText().toString());
                    edit.putString("pName2", pName2.getText().toString());
                    edit.putString("pNameN2", pNameN2.getText().toString());
                    edit.putString("pmorning2", pmorning2.getText().toString());
                    edit.putString("pmorning2V", pmorning2V.getText().toString());
                    edit.putString("pafternoon2", pafternoon2.getText().toString());
                    edit.putString("pafternoon2V", pafternoon2V.getText().toString());
                    edit.putString("pevening2", pevening2.getText().toString());
                    edit.putString("pevening2V", pevening2V.getText().toString());
                    edit.apply();

                    sName1.setText(sp.getString("sName1", ""));
                    sNameV1.setText(sp.getString("sNameV1", ""));
                    smorning1.setText(sp.getString("smorning1", ""));
                    smorning1V.setText(sp.getString("smorning1v", ""));
                    safternoon1.setText(sp.getString("safternoon1", ""));
                    safternoon1V.setText(sp.getString("safternoon1V", ""));
                    sevening1.setText(sp.getString("sevening1", ""));
                    sevening1V.setText(sp.getString("sevening1V", ""));
                    sName2.setText(sp.getString("sName2", ""));
                    sNameV2.setText(sp.getString("sNameV2", ""));
                    smorning2.setText(sp.getString("smorning2", ""));
                    smorning2V.setText(sp.getString("smorning2V", ""));
                    safternoon2.setText(sp.getString("safternoon2", ""));
                    safternoon2V.setText(sp.getString("safternoon2V", ""));
                    sevening2.setText(sp.getString("sevening2", ""));
                    sevening2V.setText(sp.getString("sevening2V", ""));
                    pName1.setText(sp.getString("pName1", ""));
                    pNameN1.setText(sp.getString("pNameN1", ""));
                    pmorning1.setText(sp.getString("pmorning1", ""));
                    pmorning1V.setText(sp.getString("pmorning1V", ""));
                    pafternoon1.setText(sp.getString("pafternoon1", ""));
                    pafternoon1V.setText(sp.getString("pafternoon1V", ""));
                    pevening1.setText(sp.getString("pevening1", ""));
                    pevening1V.setText(sp.getString("pevening1V", ""));
                    pName2.setText(sp.getString("pName2", ""));
                    pNameN2.setText(sp.getString("pNameN2", ""));
                    pmorning2.setText(sp.getString("pmorning2", ""));
                    pmorning2V.setText(sp.getString("pmorning2V", ""));
                    pafternoon2.setText(sp.getString("pafternoon2", ""));
                    pafternoon2V.setText(sp.getString("pafternoon2V", ""));
                    pevening2.setText(sp.getString("pevening2", ""));
                    pevening2V.setText(sp.getString("pevening2V", ""));


                    String data = ("{\"signal\"" + ":" + "\"A\"" + ",\"sName1\"" + ":" + "\"" + sName1.getText().toString() + "\"" + ",\"sNameV1\"" + ":" + "\"" + sNameV1.getText().toString()
                            + "\"" +",\"smorning1\"" + ":" + "\"" + smorning1.getText().toString() + "\"" + ",\"smorning1v\"" + ":" + "\"" + smorning1V.getText().toString() + "\"" +
                            ",\"safternoon1\"" + ":" + "\"" + safternoon1.getText().toString() + "\"" + ",\"safternoon1V\"" + ":" + "\"" + safternoon1V.getText().toString() + "\"" +
                            ",\"sevening1\"" + ":" + "\"" + sevening1.getText().toString() + "\"" + ",\"sevening1V\"" + ":" + "\"" + sevening1V.getText().toString() + "\"" +
                            ",\"sName2\"" + ":" + "\"" + sName2.getText().toString() + ",\"sNameV2\"" + ":" + "\"" + sNameV2.getText().toString() + "\"" +
                            ",\"smorning2\"" + ":" + "\"" + smorning2.getText().toString() + "\"" + ",\"smorningV2\"" + ":" + "\"" + smorning2V.getText().toString() + "\"" +
                            ",\"safternoon2\"" + ":" + "\"" + safternoon2.getText().toString()+ "\"" + ",\"safternoon2V\"" + ":" + "\"" + safternoon2V.getText().toString() + "\"" +
                            ",\"sevening2\"" + ":" + "\"" + sevening2.getText().toString()+ "\"" + ",\"sevening2V\"" + ":" + "\"" + sevening2V.getText().toString() + "\"" +
                            ",\"pName1\"" + ":" + "\"" + pName1.getText().toString() + "\"" + ",\"pNameN1\"" + ":" + "\"" + pNameN1.getText().toString()
                            + "\"" +",\"pmorning1\"" + ":" + "\"" + pmorning1.getText().toString() + "\"" + ",\"pmorning1v\"" + ":" + "\"" + pmorning1V.getText().toString() + "\"" +
                            ",\"pafternoon1\"" + ":" + "\"" + pafternoon1.getText().toString() + "\"" + ",\"pafternoon1V\"" + ":" + "\"" + pafternoon1V.getText().toString() + "\"" +
                            ",\"pevening1\"" + ":" + "\"" + pevening1.getText().toString()+ "\"" + ",\"pevening1V\"" + ":" + "\"" + pevening1V.getText().toString() + "\"" +
                            ",\"pName2\"" + ":" + "\"" + pName2.getText().toString() + "\"" + ",\"pNameN2\"" + ":" + "\"" + pNameN2.getText().toString() + "\"" +
                            ",\"pmorning2\"" + ":" + "\"" + pmorning2.getText().toString() + "\"" + ",\"pmorningV2\"" + ":" + "\"" + pmorning2V.getText().toString() + "\"" +
                            ",\"pafternoon2\"" + ":" + "\"" + pafternoon2.getText().toString() + "\"" + ",\"pafternoon2V\"" + ":" + "\"" + pafternoon2V.getText().toString() + "\"" +
                            ",\"pevening2\"" + ":" + "\"" + pevening2.getText().toString() + "\"" + ",\"pevening2V\"" + ":" + "\"" + pevening2V.getText().toString() +"}");
                    postDataUsingVolley(data);
                }
                return false;
            }
        });

//        alarmUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data = ("{\"signal\"" + ":" + "\"C\"" +"}");
//                postDataUsingVolley(data);
//                Toast.makeText(MainActivity2.this, "Checking For Update", Toast.LENGTH_SHORT).show();
//            }
//
//        });

        cancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ("{\"signal\"" + ":" + "\"D\"" +"}");
                postDataUsingVolley(data);

                Toast.makeText(MainActivity2.this, "Alarm successfully Cancel", Toast.LENGTH_SHORT).show();
            }

        });

        Handler handler = new Handler();

        Runnable r=new Runnable() {
            public void run() {
                postDataUsingVolley("");
                try {
                    // get JSONObject from JSON file
                    JSONObject obj = new JSONObject(data);
                    // fetch JSONObject named employee
//                    JSONObject employee = obj.getJSONObject("time");
                    // get employee name and salary

                    nTime = obj.getString("time");
                    ss1 = obj.getString("s1");
                    ss2 = obj.getString("s2");
                    pp1 = obj.getString("p1");
                    pp2 = obj.getString("p2");

//                    salary = employee.getString("salary");
//                    // set employee name and salary in TextView's
//                    employeeName.setText("Name: "+name);
//                    employeeSalary.setText("Salary: "+salary);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Time.setText(nTime);
                s1.setText(ss1);
                s2.setText(ss2);
                p1.setText(pp1);
                p2.setText(pp2);
//                Toast.makeText(MainActivity2.this, test, Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, 1500);
            }
        };

        handler.post(r);


    }

    private void postDataUsingVolley(String name) {

        String url = "http://192.168.4.1/post";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(MainActivity2.this);
//        String URL = ("http://" + url);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                data = response;
//                Toast.makeText(MainActivity2.this, data, Toast.LENGTH_SHORT).show();

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override

            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(MainActivity2.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.

                params.put("data", name);


                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }



    @Override
    public void onBackPressed() {

        super.onBackPressed();
        if (pressedTime + 2000 > System.currentTimeMillis()) {

            Intent i = new Intent(MainActivity2.this, MainActivity2.class);
            startActivity(i);
            finish();

        } else {
            Toast.makeText(getBaseContext(), "Press back again to logout", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}