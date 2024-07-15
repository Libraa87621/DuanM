package Login_SingIn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dnmu.R;

public class ManhinhchoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhcho);

        // Chuyển sang LoginActivity sau 3 giây
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ManhinhchoActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Kết thúc ManhinhchoActivity để người dùng không thể quay lại
            }
        }, 3000); // 3000 milliseconds = 3 seconds
    }
}
