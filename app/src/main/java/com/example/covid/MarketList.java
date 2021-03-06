package com.example.covid;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import kr.co.bootpay.Bootpay;
import kr.co.bootpay.BootpayAnalytics;
import kr.co.bootpay.enums.UX;
import kr.co.bootpay.listener.CancelListener;
import kr.co.bootpay.listener.CloseListener;
import kr.co.bootpay.listener.ConfirmListener;
import kr.co.bootpay.listener.DoneListener;
import kr.co.bootpay.listener.ErrorListener;
import kr.co.bootpay.listener.ReadyListener;
import kr.co.bootpay.model.BootExtra;
import kr.co.bootpay.model.BootUser;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

import static com.example.covid.R.id.handButton;
import static com.example.covid.R.id.start;


public class MarketList extends Fragment {
    ImageView maskButton,handButton;
    TextView[] maskInfo=new TextView[5];
    ImageView[] maskUrl=new ImageView[5];
    TextView[] maskPrice=new TextView[5];
    String[] title=new String[5];
    String[] url=new String[5];
    String[] price=new String[5];
    Handler handler;
    final Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_market_list, container, false);
        maskButton=v.findViewById(R.id.maskButton);
        handButton=v.findViewById(R.id.handButton);


        for (int i=0;i<5;i++){
            int id = getResources().getIdentifier("maskinfo"+(i+1), "id", "com.example.covid");
            maskInfo[i]=v.findViewById(id);
            id = getResources().getIdentifier("maskUrl"+(i+1), "id", "com.example.covid");
            maskUrl[i]=v.findViewById(id);
            id = getResources().getIdentifier("maskPrice"+(i+1), "id", "com.example.covid");
            maskPrice[i]=v.findViewById(id);
        }

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                int cnt=0;
                for (final String tmp: bundle.getStringArray("title")){
                    maskInfo[cnt].setText(tmp);
                    maskInfo[cnt].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(tmp)));
                        }
                    });
                    cnt++;
                }

                cnt=0;
                for (String tmp : bundle.getStringArray("price")){
                    maskPrice[cnt].setText(tmp);
                    cnt++;
                }
                cnt=0;
                for (final String tmp : bundle.getStringArray("url")){
                    final int idx=cnt;
                    maskUrl[cnt].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent=new Intent(getActivity(), PaymentActivity.class);
                            intent.putExtra("price",maskPrice[idx].getText().toString());
                            intent.putExtra("name",maskInfo[idx].getText().toString());
                            startActivity(intent);
                        }
                    });
                    cnt++;
                }
            }
        };
        MaskCrawling();

        maskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaskCrawling();
            }
        });

        handButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandCrawling();
            }
        });

        return v;
    }

    private void HandCrawling() {
        new Thread(){
            @Override
            public void run() {
                Document doc = null;
                int cnt =0;
                try {
                    doc = Jsoup.connect("http://browse.auction.co.kr/search?keyword=%EC%86%90%EC%86%8C%EB%8F%85%EC%A0%9C&itemno=&nickname=&frm=hometab&dom=auction&isSuggestion=No&retry=&Fwk=%EC%86%90%EC%86%8C%EB%8F%85%EC%A0%9C&acode=SRP_SU_0100&arraycategory=&encKeyword=%EC%86%90%EC%86%8C%EB%8F%85%EC%A0%9C").get();
                    Elements urls = doc.select(".link--itemcard");
                    Elements titles = doc.select(".link--itemcard .text--title");
                    Elements prices =doc.select(".price_seller .text--price_seller");
                    for (Element e: titles) {
                        title[cnt]=e.text();
                        cnt++;
                        if (cnt >4){
                            break;
                        }
                    }
                    cnt=0;
                    for (Element e: urls) {
                        url[cnt]=e.attr("href");
                        cnt++;
                        if (cnt >4){
                            break;
                        }
                    }
                    cnt=0;
                    for (Element e: prices) {
                        price[cnt]=e.text() +" ???";
                        cnt++;
                        if (cnt >4){
                            break;
                        }
                    }

                    bundle.putStringArray("title", title);
                    bundle.putStringArray("url",url);
                    bundle.putStringArray("price",price);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    public void MaskCrawling(){
        new Thread(){
            @Override
            public void run() {
                Document doc = null;
                int cnt =0;
                try {
                    doc = Jsoup.connect("http://browse.auction.co.kr/search?keyword=%EB%A7%88%EC%8A%A4%ED%81%AC&itemno=&nickname=&frm=hometab&dom=auction" +
                            "&isSuggestion=No&retry=&Fwk=%EB%A7%88%EC%8A%A4%ED%81%AC&acode=SRP_SU_0100&arraycategory=&encKeyword=%EB%A7%88%EC%8A%A4%ED%81%AC").get();
                    Elements urls = doc.select(".link--itemcard");
                    Elements titles = doc.select(".link--itemcard .text--title");
                    Elements prices =doc.select(".price_seller .text--price_seller");
                    for (Element e: titles) {
                        title[cnt]=e.text();
                        cnt++;
                        if (cnt >4){
                            break;
                        }
                    }
                    cnt=0;
                    for (Element e: urls) {
                        url[cnt]=e.attr("href");
                        cnt++;
                        if (cnt >4){
                            break;
                        }
                    }
                    cnt=0;
                    for (Element e: prices) {
                        price[cnt]=e.text() +" ???";
                        cnt++;
                        if (cnt >4){
                            break;
                        }
                    }


                    bundle.putStringArray("title", title);
                    bundle.putStringArray("url",url);
                    bundle.putStringArray("price",price);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}