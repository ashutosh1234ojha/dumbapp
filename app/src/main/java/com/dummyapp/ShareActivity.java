package com.dummyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.widget.ShareDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by cl-macmini-86 on 10/4/17.
 */

public class ShareActivity extends AppCompatActivity {

    private Button btnFb, btnWhatt, btnGmail, btnGeneral;
    private boolean isFacebookInstalled = false;
    private String shareMsg;
    private String imageUrl = "http://biblechurch.s3.amazonaws.com/dev/customer_profile/QdJs1505802782272-Screenshot20170916120438.png";
    private final int MY_PERMISSIONS_LOCATION = 123;
    private String appLink = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_sub);

        init();
    }

    private void init() {
        btnFb = (Button) findViewById(R.id.btn);
        btnWhatt = (Button) findViewById(R.id.btnWhatt);
        btnGmail = (Button) findViewById(R.id.btnGmail);
        btnGeneral = (Button) findViewById(R.id.btnGeneral);

        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    checkPermission();
//                } else {
////                    shareImage();
//                    shareWithFacebookImage();
//                }

//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.butlervaletservices.com/"));
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(" https://jungleworks.fuguchat.com/#/"));
                startActivity(browserIntent);

            }
        });

        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                shareWithEmail();


            }
        });

        btnWhatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickWhatsApp(view);
            }
        });

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                shareWithFacebook();
            }
        });
    }

    private void checkPermission() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_LOCATION);
        } else {
            shareImage();
        }

    }

    private void shraeFeedFacebook(){
    }

    /**
     * This method share referral code on fb
     */
    private void shareWithFacebookImage() {


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rectangle_1953);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/LatestShare.jpg";
        OutputStream out = null;
        File file = new File(path);
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        path = file.getPath();
        Uri bmpUri = Uri.parse("file://" + path);



        String text = "YOUR TEXT=ashutosh \nName=Here\nGood=man" + "\n" + "Image=" + imageUrl;

        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(bmpUri)
                .build();


        SharePhoto sharePhoto1 = new SharePhoto.Builder()
                .setBitmap(bitmap)
                .setCaption("34534")
                .build();

        ShareContent shareContent = new ShareMediaContent.Builder()
                .addMedium(sharePhoto1)
                .build();

        ShareDialog shareDialog = new ShareDialog(this);
        shareDialog.show(shareContent, ShareDialog.Mode.AUTOMATIC);

//        ShareDialog.show(this, content);
    }


    private void shareImage() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rectangle_1953);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/LatestShare.jpg";
        OutputStream out = null;
        File file = new File(path);
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        path = file.getPath();
        Uri bmpUri = Uri.parse("file://" + path);
        Intent shareIntent = new Intent();
        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
//        shareIntent.setType("image/jpg");
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "act2imapact text with image\ngood morning" + "\n" + appLink);
        startActivity(Intent.createChooser(shareIntent, "Share with"));
    }

    /**
     * This method share referral code on fb
     */
    private void shareWithFacebook() {


        String text = "YOUR TEXT=ashutosh \nName=Here\nGood=man" + "\n" + "Image=" + appLink;

        ShareLinkContent content = new ShareLinkContent.Builder()
//                .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=" +"com.Act2ImpactFund"))
//                .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.trukkin.sp&hl=en"))
                .setContentUrl(Uri.parse(imageUrl))
                .setQuote(text)
                .build();

        ShareDialog.show(this, content);
    }

    public void onClickWhatsApp(View view) {

        PackageManager pm = getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "YOUR TEXT=ashutosh \nName=Here\nGood=man" + "\n" + "Image=" + imageUrl;

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }

    /**
     * This method share referral code on mail
     */
    private void shareWithEmail() {

//        String text = "YOUR TEXT=ashutosh \nName=Here\nGood=man"+"\n"+"Image="+imageUrl;
//
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri data = Uri.parse("mailto:?subject=" + "&body=" + text);
//        intent.setData(data);
//        startActivity(intent);


        //For image
//        Intent share = new Intent(Intent.ACTION_SEND);
//        share.setType("image/jpeg");
//
//        share.putExtra(Intent.EXTRA_STREAM,
//                Uri.parse("file:///sdcard/DCIM/Camera/myPic.jpg"));
//
//        startActivity(Intent.createChooser(share, "Share Image"));


//For text
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "I'm being sent!!");
        startActivity(Intent.createChooser(share, "Share Text"));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case MY_PERMISSIONS_LOCATION:

                if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Storage permission granted", Toast.LENGTH_SHORT).show();
                } else {
//                    Toast.makeText(this, "This permission is required to access app", Toast.LENGTH_SHORT).show();
                    checkPermission();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
