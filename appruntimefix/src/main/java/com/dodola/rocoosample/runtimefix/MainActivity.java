/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.dodola.rocoosample.runtimefix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dodola.rocoofix.RocooFix;
import com.dodola.rocoosample.HelloHack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViewById(R.id.btnFixMeRuntime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelloHack hacks = new HelloHack();
                Log.i("hacks", hacks.showHello());
                RocooFix.initPathFromAssetsRuntime(MainActivity.this, "patch.jar");
                Log.i("hacks", hacks.showHello());
                HelloHack hack1 = new HelloHack();
                Log.i("hack1", hack1.showHello());
                Toast.makeText(MainActivity.this, hack1.showHello(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
