package com.mbhonsle.springandroidbarebone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import service.Greeting;
import service.MainService;
import service.MainServiceImpl;

public class MainActivity extends AppCompatActivity {

    private Button rfrshBtn;
    private TextView msgView;
    private MainService mainService;

    private void initViews() {
        this.rfrshBtn = findViewById(R.id.rfrshBtn);
        this.msgView = findViewById(R.id.msgView);
    }

    private void initService () {
        this.mainService = new MainServiceImpl(getString(R.string.service_endpoint));
    }

    public void get(View view) {
        Greeting greeting =  this.mainService.getGreeting();
        this.msgView.setText(greeting.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initService();
    }
}
