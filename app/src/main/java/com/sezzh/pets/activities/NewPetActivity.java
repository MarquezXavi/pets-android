package com.sezzh.pets.activities;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.sezzh.pets.R;
import com.sezzh.pets.io.db.DbConstants;
import com.sezzh.pets.io.db.PetOpenHelper;
import com.sezzh.pets.io.models.Pet;

public class NewPetActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText mEditTextName;
    private ImageView mImageViewAvatar;
    private PetOpenHelper dbClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pet);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setSupportActionBar(mToolbar);
        mEditTextName = (EditText) findViewById(R.id.new_pet_name);
        mImageViewAvatar = (ImageView) findViewById(R.id.new_pet_avatar);
        dbClient = new PetOpenHelper(
                this, null, null, DbConstants.DATABASE_VERSION
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_pet, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_save_pet)
            savePet();
        else if (itemId == R.id.action_upload_image)
            dbClient.retrivePet(1);

        return super.onOptionsItemSelected(item);
    }

    private void savePet() {
        Pet pet = new Pet(mEditTextName.getText().toString());
        dbClient.createPet(pet);
        this.finish();
    }
}
