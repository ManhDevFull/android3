package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtUser, edtPass;
    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = edtUser.getText() != null ? edtUser.getText().toString().trim() : "";
            String pass = edtPass.getText() != null ? edtPass.getText().toString() : "";

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            String now = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault()).format(new Date());

            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            intent.putExtra("username", user);
            intent.putExtra("login_time", now);
            intent.putExtra("email", user + "@example.com");
            intent.putExtra("phone", "+84 9xx xxx xxx");
            intent.putExtra("web", "https://example.com/" + user);
            startActivity(intent);
        });
    }
}
