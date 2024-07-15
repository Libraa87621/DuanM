package Login_SingIn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dnmu.R;

public class SignupActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private CheckBox checkBox;
    private Button btnSignup;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        checkBox = findViewById(R.id.checkBox);
        btnSignup = findViewById(R.id.btnSignup);

        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Kiểm tra xem username và password không rỗng
                if (!username.isEmpty() && !password.isEmpty()) {
                    if (checkBox.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.apply();
                    }

                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    finish();
                } else {
                    // Thông báo lỗi nếu username hoặc password rỗng
                    Toast.makeText(SignupActivity.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
