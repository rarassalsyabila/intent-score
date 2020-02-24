package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Hasil = findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String hs = getIntent().getExtras().getString("hasil");

            Hasil.setText(hs);
        }
    }
}
