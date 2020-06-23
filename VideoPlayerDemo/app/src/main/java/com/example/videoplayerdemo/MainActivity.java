package com.example.videoplayerdemo;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView mySurfaceView;
    private Activity instance;
    private VideoRender mRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        setContentView(R.layout.activity_main);
        instance = this;
        mySurfaceView = (GLSurfaceView)findViewById(R.id.glSurfaceView);
        mySurfaceView.setEGLContextClientVersion(3);
        mySurfaceView.getHolder().setKeepScreenOn(true);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_player;
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//        path += "/sdcard/DCIM/video_player.mp4";
        mRenderer = new VideoRender(this, path);
        mySurfaceView.setRenderer(mRenderer);
    }

    private class surfaceCallBack implements SurfaceHolder.Callback {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            //画布被创建的时候
            mySurfaceView.setRenderer(mRenderer);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {
            //画布改变的时候
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            //画布被销毁的时候
        }
    }

}
//        String path = "HWVTR/sdcard/DCIM/videoPlayer001.mp4";
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void setupGL(){
//        VideoSurfaceView glSurfaceView = null;
//            String uri = "android.resource://" + getPackageName() + "/" + R.raw.video_player;
//            glSurfaceView = new VideoSurfaceView(this, uri);
//        glView.addView(glSurfaceView);
//    }

//    private void playVideo(){
//        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_player;
////        String path = "HWVTR/sdcard/DCIM/video_player.mp4";   // failed
//        Uri myUri = Uri.parse(path);
//        player.reset();
//        try {
//            player.setDataSource(this, myUri);
//            SurfaceHolder tmp = main_surface.getHolder();
//            player.setDisplay(tmp);
//            player.prepare();
//            player.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }