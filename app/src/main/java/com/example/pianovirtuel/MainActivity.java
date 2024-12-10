package com.example.pianovirtuel;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Initialisation des boutons
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonD = findViewById(R.id.buttonD);
        Button buttonE = findViewById(R.id.buttonE);
        Button buttonF = findViewById(R.id.buttonF);
        Button buttonG = findViewById(R.id.buttonG);
        Button buttonA = findViewById(R.id.buttonA);
        Button buttonB = findViewById(R.id.buttonB);

        buttonC.setOnClickListener(v -> playSound(R.raw.note_c));
        buttonD.setOnClickListener(v -> playSound(R.raw.note_d));
        buttonE.setOnClickListener(v -> playSound(R.raw.note_e));
        buttonF.setOnClickListener(v -> playSound(R.raw.note_f));
        buttonG.setOnClickListener(v -> playSound(R.raw.note_g));
        buttonA.setOnClickListener(v -> playSound(R.raw.note_a));
        buttonB.setOnClickListener(v -> playSound(R.raw.note_b));
    }
            private void playSound(int soundResource) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(this, soundResource);
                mediaPlayer.start();
            }
            @Override
            protected void onDestroy() {
                super.onDestroy();
                // Libérer le MediaPlayer pour éviter les fuites de mémoire
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
            }
        }


