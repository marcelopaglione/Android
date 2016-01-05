package com.example.marcelopaglione.sensores_exe3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Activity_video extends AppCompatActivity {

    VideoView videoView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        videoView1 = (VideoView) findViewById(R.id.videoView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        i.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 7);

        if(i.resolveActivity(Activity_video.this.getPackageManager()) != null) {
            startActivityForResult(i, 33);
        }
        else {
            Toast.makeText(Activity_video.this, "There is no app to capture video!", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 33) {
            if (resultCode == RESULT_OK) {
                Uri recordedVideoUri = data.getData();
                MediaController controller = new MediaController(Activity_video.this);
                videoView1.setVideoURI(recordedVideoUri);
                videoView1.setMediaController(controller);
            }
            else {
                Toast.makeText(this, "Video was not recorded!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
