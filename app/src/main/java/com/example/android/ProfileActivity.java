package com.example.android;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class ProfileActivity extends AppCompatActivity {

    MaterialToolbar toolbar;
    TextView tvName, tvAccount, tvLoginTime, tvEmail, tvPhone, tvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = findViewById(R.id.toolbar);
        tvName = findViewById(R.id.tvName);
        tvAccount = findViewById(R.id.tvAccount);
        tvLoginTime = findViewById(R.id.tvLoginTime);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvWeb = findViewById(R.id.tvWeb);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_settings) {
                finish();
                return true;
            }
            return false;
        });

        // Nhận dữ liệu Intent
        String username = getIntent().getStringExtra("username");
        String loginTime = getIntent().getStringExtra("login_time");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String web = getIntent().getStringExtra("web");

        if (username == null) username = "User";
        if (loginTime == null) loginTime = "-";
        if (email == null) email = "-";
        if (phone == null) phone = "-";
        if (web == null) web = "-";

        tvName.setText(username);
        tvAccount.setText("Account: " + username);
        tvLoginTime.setText("Logged at: " + loginTime);
        tvEmail.setText("Email: " + email);
        tvPhone.setText("Phone: " + phone);
        tvWeb.setText("Web: " + web);
    }
}
