package me.baron.gpermission.sample;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.baron.gpermission.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Permission(permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA})
    private void initView() {
    }
}
