package com.example.rockpaperscissors.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rockpaperscissors.R;

public class ChooserActivity extends AppCompatActivity {
    public static int rounds;
    private RadioGroup chooserRadio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_chooser_view);

        chooserRadio = findViewById(R.id.roundsGroup);
        chooserRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.fiveRadio:
                        rounds = 5;
                        Log.e("Log Rounds: ", "" + rounds);
                        break;
                    case R.id.tenRadio:
                        rounds = 10;
                        Log.e("Log Rounds: ", "" + rounds);
                        break;
                    case R.id.fifteenRadio:
                        rounds = 15;
                        Log.e("Log Rounds: ", "" + rounds);
                        break;
                    default:
                        Log.e("Log Rounds: ", "" + rounds);
                        break;
                }
            }
        });
    }
}
