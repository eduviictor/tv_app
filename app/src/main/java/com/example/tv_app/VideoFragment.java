package com.example.tv_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class VideoFragment extends Fragment {
    public VideoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        WebView webView_list_videos = view.findViewById(R.id.webView_list_videos);
        String url = "https://www.youtube.com/results?search_query=the+noite";
        webView_list_videos.loadUrl(url);
        webView_list_videos.setWebViewClient(new WebViewClient());
        webView_list_videos.getSettings().setJavaScriptEnabled(true);
//        webView_list_videos.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                view.loadUrl(url);
//                return false;
//            }
//        });
        return view;
    }
}
