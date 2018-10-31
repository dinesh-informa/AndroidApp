package com.dinesh.androidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDataActivity extends AppCompatActivity {

    @BindView(R.id.imgUserPic)
    ImageView imgUserPic;
    @BindView(R.id.txtPhoneno)
    EditText txtPhoneno;
    @BindView(R.id.txtPhoneNo)
    EditText txtPhoneNo;
    @BindView(R.id.txtAddress)
    EditText txtAddress;
    @BindView(R.id.btnSave)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imgUserPic)
    public void onImgUserPicClicked() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 101);
    }

    @OnClick(R.id.btnSave)
    public void onBtnSaveClicked() {
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 101:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imgUserPic.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imgUserPic.setImageURI(selectedImage);
                }
                break;
        }
    }
}
