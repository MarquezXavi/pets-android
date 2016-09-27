package com.sezzh.pets.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sezzh.pets.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setNewPetActivity();
            }
        });
    }

    private void setNewPetActivity() {
        Intent intent = new Intent(this, NewPetActivity.class);
        this.startActivity(intent);
    }
}
