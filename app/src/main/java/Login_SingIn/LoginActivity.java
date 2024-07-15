package Login_SingIn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dnmu.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnSignup;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);

        // Nhận dữ liệu từ SignupActivity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        if (username != null && password != null) {
            etUsername.setText(username);
            etPassword.setText(password);
        }

        // Nếu đã lưu dữ liệu từ trước, điền vào các trường đăng nhập
        String savedUsername = sharedPreferences.getString("username", null);
        String savedPassword = sharedPreferences.getString("password", null);
        if (savedUsername != null && savedPassword != null) {
            etUsername.setText(savedUsername);
            etPassword.setText(savedPassword);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = etUsername.getText().toString();
                String enteredPassword = etPassword.getText().toString();

                // Lấy username và password đã lưu trong SharedPreferences
                String savedUsername = sharedPreferences.getString("username", "");
                String savedPassword = sharedPreferences.getString("password", "");

                // So sánh username và password nhập vào với giá trị đã lưu
                if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, UserActivity.class); // Chuyển đến UserActivity sau khi đăng nhập thành công
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
