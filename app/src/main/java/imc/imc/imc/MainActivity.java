package imc.imc.imc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_imc.R;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(() ->{
            Intent intent = new Intent(MainActivity.this,Tela2.class);
            startActivity(intent);
            finish();

        }, 5000);

                 prog();

            }

            public void prog()
            {
                pb = (ProgressBar)findViewById(R.id.pb);
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run()
                    {
                      counter++;
                      pb.setProgress(counter);

                      if (counter == 100)
                       t.cancel();

                    }

                };

                t.schedule(tt,0,50);

            }

    }
