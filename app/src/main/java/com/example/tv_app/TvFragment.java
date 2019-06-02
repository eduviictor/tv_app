package com.example.tv_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TvFragment extends Fragment {

    public TvFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        WebView webView_video = view.findViewById(R.id.webView_video);
        String url = "https://www.google.com/";
        webView_video.loadUrl(url);
//        String header = "<iframe width=\"\" height=\"480\" src=\"https://www.youtube.com/embed/MM4ShEnKw3A\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
//        webView_video.loadData(header, "text/html", "UTF-8");
        webView_video.setWebViewClient(new WebViewClient());
        webView_video.getSettings().setJavaScriptEnabled(true);
//        webView_video.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                view.loadUrl(url);
//                return false;
//            }
//        });
        return view;
    }

}