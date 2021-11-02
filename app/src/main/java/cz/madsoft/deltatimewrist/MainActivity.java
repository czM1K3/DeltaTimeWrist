package cz.madsoft.deltatimewrist;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import cz.madsoft.deltatimewrist.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    private boolean isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isActive = true;
        DeltaTime deltaTime = new DeltaTime();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isActive) return;
                int hourId = deltaTime.getDeltaTime();
                String stringToShow = deltaTime.getString(hourId);
                mTextView.post(() -> mTextView.setText(stringToShow));
            }
        }, 0, 1000);
    }

    @Override
    protected void onStop() {
        isActive = false;
        super.onStop();
    }

    @Override
    protected void onStart() {
        isActive = true;
        super.onStart();
    }
}