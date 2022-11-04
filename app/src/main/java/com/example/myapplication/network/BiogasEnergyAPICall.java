package com.example.myapplication.network;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.activities.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiogasEnergyAPICall {

    public static String selectedGroup = "";
    public static String selectedType = "";
    private static final String URL = "https://biteco-energy.com/biogas-calculator/";
    public static String QUANTITY = "";

    public static void energyResult(String input, Context context){
        QUANTITY = input;
        String summary = "{\"0\":{\"group\":"+"\""+selectedGroup+"\""+",\"type\":"+"\""+selectedType+"\""+",\"quantity\":"+"\""+input+"\""+"}}";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context,response,Toast.LENGTH_LONG).show();
                        System.out.println(response);
                        response = response.replaceAll("\\\\","");
                        Pattern p = Pattern.compile("<div class=\"calc\">rnttt(.*?)m<sup>3");
                        Matcher m = p.matcher(response);
                        m.find();
                        String result = m.group(1);
                        Intent intent = new Intent(context, Result.class);
                        intent.putExtra("result", result);
                        context.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("CalcForm[summary]",summary);
                params.put("CalcForm[group]",selectedGroup);
                params.put("CalcForm[type]",selectedType);
                params.put("CalcForm[quantity]",input);
                return params;
            }

            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("x-requested-with", "XMLHttpRequest");
                return headers;
            }

        };
        System.out.println(summary);
        System.out.println(stringRequest);
        Volley.newRequestQueue(context).add(stringRequest);
    }
}
