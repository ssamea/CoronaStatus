package com.example.covid;


import android.graphics.Path;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import android.os.Bundle;

public class Detatil_info extends Fragment {

    TextView decideCnt,deathCnt,examCnt,accExamCnt,careCnt,clearCnt,dateView,dayDecideCnt,dateValue;
    EditText date;
    Button search;
    public String data="";
    String yesterday="";

    public Detatil_info(){

    }
    public  Detatil_info(String data){
        this.data=data;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_detatil_info, container, false);
        deathCnt= v.findViewById(R.id.death_cnt);
        decideCnt=v.findViewById(R.id.decide_cnt);
        examCnt=v.findViewById(R.id.exam_cnt);
        accExamCnt=v.findViewById(R.id.acc_exam_cnt);
        careCnt=v.findViewById(R.id.care_cnt);
        clearCnt=v.findViewById(R.id.clear_cnt);
        dayDecideCnt=v.findViewById(R.id.dayDecideCnt);
        dateView=v.findViewById(R.id.dateView);
        search=v.findViewById(R.id.search);
        date=v.findViewById(R.id.date);
        dateValue=v.findViewById(R.id.dateValue);

        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMdd");
        Date dateV =new Date();
        dateV = new Date(dateV.getTime()+(1000*60*60*24*-1));
        dateValue.setText(simpleDate.format(dateV));
        ExampleThread2 ex1=new ExampleThread2();
        AsyncTask<String, String, String> tmp=ex1.execute();
        data=simpleDate.format(dateV).replaceAll(" ","");

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=date.getText().toString();
                ExampleThread2 ex1=new ExampleThread2();
                AsyncTask<String, String, String> tmp=ex1.execute();
                dateValue.setText(data);
            }
        });

        return v;
    }
    public class ExampleThread2 extends AsyncTask<String, String, String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... integers){
            try {
                StringBuilder urlBuilder = new
                        //StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
                        StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=aOKXvfshZJPd1moqnd%2FPfzkE5I5SGKANDf26uGzQZFOje1JSgylw99l8Hc5L3rib%2FR3PE0PFUFpUZLAPvsg24A%3D%3D&pageNo=1&numOfRows=10&startCreateDt="+data+"&endCreateDt="+data); /*URL*/

               // String serviceKey = "aOKXvfshZJPd1moqnd%2FPfzkE5I5SGKANDf26uGzQZFOje1JSgylw99l8Hc5L3rib%2FR3PE0PFUFpUZLAPvsg24A%3D%3D\n"; /*Service Key*/
                //String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");
               // urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /*??????????????????????????? ?????? ?????????*/
               // urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*???????????????*/
               // urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*??? ????????? ?????? ???*/
                //urlBuilder.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*????????? ????????? ????????? ??????*/
                //urlBuilder.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "=" + URLEncoder.encode("20200315", "UTF-8")); /*????????? ????????? ????????? ??????*

                Log.i("??????","1???");


                data=Integer.toString(Integer.parseInt(data)-1);
                StringBuilder urlBuilder2 = new
                        //StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
                        StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=aOKXvfshZJPd1moqnd%2FPfzkE5I5SGKANDf26uGzQZFOje1JSgylw99l8Hc5L3rib%2FR3PE0PFUFpUZLAPvsg24A%3D%3D&pageNo=1&numOfRows=10&startCreateDt="+data+"&endCreateDt="+data); /*URL*/

                //String serviceKey2 = "aOKXvfshZJPd1moqnd%2FPfzkE5I5SGKANDf26uGzQZFOje1JSgylw99l8Hc5L3rib%2FR3PE0PFUFpUZLAPvsg24A%3D%3D\n";
                //String serviceKeyDecoded2 = URLDecoder.decode(serviceKey2, "UTF-8");
                //urlBuilder2.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + URLEncoder.encode(serviceKeyDecoded2, "UTF-8")); /*??????????????????????????? ?????? ?????????*/
                //urlBuilder2.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*???????????????*/
                //urlBuilder2.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*??? ????????? ?????? ???*/
                //urlBuilder2.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*????????? ????????? ????????? ??????*/
                //urlBuilder2.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "=" + URLEncoder.encode("20200315", "UTF-8")); /*????????? ????????? ????????? ??????*/
                
                Log.i("??????","1???");


                URL url = new URL(urlBuilder.toString());
                URL url2 = new URL(urlBuilder2.toString());
                Log.i("??????","2???");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
                Log.i("??????","3???");
                conn.setRequestMethod("GET");
                conn2.setRequestMethod("GET");
                Log.i("??????","4???");
                conn.setRequestProperty("Content-type", "application/json");
                conn2.setRequestProperty("Content-type", "application/json");


                BufferedReader rd;
                BufferedReader rd2;

                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {
                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }

                if (conn2.getResponseCode() >= 200 && conn2.getResponseCode() <= 300) {
                    rd2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                } else {
                    rd2 = new BufferedReader(new InputStreamReader(conn2.getErrorStream()));
                }

                final StringBuilder sb = new StringBuilder();
                final StringBuilder sb2 = new StringBuilder();
                String line;
                String line2;
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }
                while ((line2 = rd2.readLine()) != null) {
                    sb2.append(line2);
                }

                rd.close();
                conn.disconnect();
                rd2.close();
                conn2.disconnect();
                new Handler(Looper.getMainLooper()).post(new Runnable(){
                    @Override
                    public void run() {
                        int count=sb.toString().indexOf("deathCnt");
                        int decide_cnt=sb.toString().indexOf("decideCnt");

                        deathCnt.setText(sb.toString().substring(count+6,count+20).replaceAll("[^0-9]", "")+"???");
                        decideCnt.setText(sb.substring(decide_cnt+6,decide_cnt+20).replaceAll("[^0-9]", "")+"???");

                        decide_cnt=sb2.toString().indexOf("decideCnt");
                        dayDecideCnt.setText("?????? ????????? : "+Integer.toString(Integer.parseInt(decideCnt.getText().toString().replaceAll("[^0-9]", ""))
                                -Integer.parseInt(sb2.substring(decide_cnt,decide_cnt+25).replaceAll("[^0-9]", "")))+"???");

                        count=sb.toString().indexOf("examCnt");
                        examCnt.setText(sb.toString().substring(count+6,count+20).replaceAll("[^0-9]", "")+"???");
                        count=sb.toString().indexOf("accExamCnt");
                        accExamCnt.setText(sb.toString().substring(count+6,count+20).replaceAll("[^0-9]", "")+"???");
                        count=sb.toString().indexOf("careCnt");
                        careCnt.setText(sb.toString().substring(count+6,count+20).replaceAll("[^0-9]", "")+"???");
                        count=sb.toString().indexOf("clearCnt");
                        clearCnt.setText(sb.toString().substring(count+6,count+20).replaceAll("[^0-9]", "")+"???");
                    }
                });

            }catch (Exception e){
                Log.i(e.toString(),"?????? ???");
            }
            return "ddd";
        }


        @Override
        protected void onProgressUpdate(String... params) {

        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }

    }
}