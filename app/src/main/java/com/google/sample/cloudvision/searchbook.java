package com.google.sample.cloudvision;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class searchbook {
    public void sendPost(String val) {
        // Instantiate the RequestQueue.
        String url = "https://www.googleapis.com/books/v1/volumes?q=book+intitle:"+val+"&PrintType=books&orderBy=relevance&key=AIzaSyAWFmdp7t7_MtY8GbVdW3rYCR3zMbOcRuo";
        //textView.setText("Response is:");
        MainActivity hi = new MainActivity();
        RequestQueue queue = Volley.newRequestQueue(hi);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        int start, stop;
                        start = response.indexOf("authors");
                        stop = response.indexOf("],",start+8);
                        // text box with the author
                        hi.xtextView.setText(response.substring(start+12,stop-2));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hi.xtextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);

    }


}
