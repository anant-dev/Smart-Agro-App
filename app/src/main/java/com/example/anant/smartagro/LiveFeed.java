package com.example.anant.smartagro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LiveFeed extends AppCompatActivity {
    RequestQueue requestQueue;
    String url ="https://sagro.herokuapp.com/get/";
    String humidity,moisture,temp;
    boolean status;
    TextView humi,temper,relhum,st,moist;
    Button ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_feed);
        init();
        getdata();
        setdata();
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  reset();
                get();
                setdata();
            }
        });
    }



    private void getdata(){
        requestQueue = Volley.newRequestQueue(LiveFeed.this);
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try {
                            humidity=response.getString("humidity");
                            moisture=response.getString("moisture");
                            temp=response.getString("temp");
                            //System.out.println("the status is :"+status+humidity+moisture);
                            } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            // Show timeout error message
                            Toast.makeText(LiveFeed.this,"Please check your internet connection",Toast.LENGTH_LONG).show();
                        }

                        else {
                            Toast.makeText(LiveFeed.this, "Something went wrong please retry !!", Toast.LENGTH_LONG).show();
                        }
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                System.out.println("object");
                return headers;
            }
        };
        requestQueue.add(stringRequest);
    }

    void  get (){
        requestQueue = Volley.newRequestQueue(LiveFeed.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                humidity=response.getString("humidity");
                                moisture=response.getString("moisture");
                                temp=response.getString("temp");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    },
                    new Response.ErrorListener()

                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //progressDialog.dismiss();
                            Log.e("Volley", error.toString());

                        }
                    }

            ) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json");
                    return headers;
                }

            };
            requestQueue.add(jor);
        }
    void setdata(){
        humi.setText(humidity);
        moist.setText(moisture);
        temper.setText(temp);
        relhum.setText("");
        /*if(Boolean.parseBoolean(status)==true){
            st.setText("ON");
        }
        else {
            st.setText("OFF");
        }*/

    }
    void reset(){
        humi.setText("");
        moist.setText("");
        temper.setText("");
        st.setText("");
        humidity="";
        moisture="";
        temp="";

    }
    private void init() {
        humi=(TextView) findViewById(R.id.humidity);
        temper=(TextView) findViewById(R.id.temp);
        relhum=(TextView) findViewById(R.id.relhumidity);
        st=(TextView) findViewById(R.id.status);
        moist=(TextView) findViewById(R.id.smoisture);
        ref=(Button) findViewById(R.id.Refresh);
    }

}
