package com.selfie.life.myxvideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.selfie.life.myxvideo.XPlayer.MxVideoPlayer;
import com.selfie.life.myxvideo.XPlayer.MxVideoPlayerWidget;
//import com.squareup.picasso.Picasso;

import static com.selfie.life.myxvideo.XPlayer.MxVideoPlayer.VIDEO_PROGRESS;

public class MainActivity extends AppCompatActivity implements MxVideoPlayerWidget.MxVideoPlayerWidgetListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    //String videoURL =  "http://selfilife.com/temp/4K_ULTRA_HD_SAMPLER.mp4";
    String videoURL =  "http://www.selfilife.com/temp/01.mp4";

    MxVideoPlayerWidget mPlayerWidget;

    ImageView sample;

    //String url = "http://www.mariaflowershop.com/assets/159/14/DimRegular/BF375-11KM.jpg";
    String url = "http://www.selfilife.com/temp/sample1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mx_activity_main);

        sample          =   (ImageView)findViewById(R.id.sample);

        mPlayerWidget   = (MxVideoPlayerWidget)findViewById(R.id.list_video_player);
        //mPlayerWidget.startPlay(videoURL, MxVideoPlayer.SCREEN_LAYOUT_LIST,"sample");
        mPlayerWidget.autoStartPlay(videoURL, MxVideoPlayer.SCREEN_LAYOUT_LIST,this,"sample");


        //Log.d(TAG,"mPlayerWidget.getDuration                        = "+mPlayerWidget.getDuration());
        //Log.d(TAG,"mPlayerWidget.mLoadingProgressBar.getProgress()  = "+mPlayerWidget.mLoadingProgressBar.getProgress());

        Log.d(TAG,"VIDEO_PROGRESS = "+VIDEO_PROGRESS);

        //Picasso.get().load(url).into(mPlayerWidget.mThumbImageView);
        //Picasso.get().load(url).into(sample);

        Glide.with(getApplicationContext()).load(url).into(mPlayerWidget.mThumbImageView);
        Glide.with(getApplicationContext()).load(url).into(sample);

    }

    @Override
    public void onVideoComplete() {
        Log.d(TAG,"receive the callback from MxVideoPlayerWidgetListener");
    }
}