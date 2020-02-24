package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private TextView Home;
    private TextView Away;
    private ImageView AvahomeImage;
    private ImageView AvaawayImage;
    private TextView scoreHome;
    private TextView scoreAway;
    private Integer score1;
    private Integer score2;

    public static final String HASIL_KEY = "hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Home = findViewById(R.id.txt_home);
        Away = findViewById(R.id.txt_away);
        AvahomeImage = findViewById(R.id.home_logo);
        AvaawayImage = findViewById(R.id.away_logo);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);

        score1 = 0;
        score2 = 0;

        Bundle extrras = getIntent().getExtras();
        if (extrras != null){
            String hn = getIntent().getExtras().getString("home");
            String an = getIntent().getExtras().getString("away");
            Bundle extra = getIntent().getExtras();
            Bitmap bmp = extra.getParcelable("imhome");
            Bitmap bmp1 = extra.getParcelable("imaway");

            Home.setText(hn);
            Away.setText(an);
            AvahomeImage.setImageBitmap(bmp);
            AvaawayImage.setImageBitmap(bmp1);
        }
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }


    public void plusHome(View view) {
        score1++;
        scoreHome.setText(String.valueOf(score1));
    }

    public void plusAway(View view) {
        score2++;
        scoreAway.setText(String.valueOf(score2));
    }

    public void cekHasil(View view) {
        String hasil;
        if(score1 > score2){
            hasil = Home.getText().toString();
        }
        else if(score2 > score1){
            hasil = Away.getText().toString();
        }
        else {
            hasil = "Draw";
        }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(HASIL_KEY, hasil);
        startActivity(intent);
    }
}
