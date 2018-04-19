package com.dummyapp.pdfChooser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dummyapp.R;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import java.io.File;
import java.util.List;

/**
 * Created by cl-macmini-86 on 4/25/17.
 */

public class ChoosePdfActivity extends AppCompatActivity implements ImageChooser.OnImageSelectListener {
    private Button btnChoosePdf;
    private ImageChooser mImageChooser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pdf);

        btnChoosePdf = (Button) findViewById(R.id.btnChoosePdf);
        mImageChooser = new ImageChooser(this);
        btnChoosePdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageChooser.selectImage();
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("application/pdf");
//                startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (resultCode == RESULT_OK) {

                switch (requestCode) {

                    case Picker.PICK_IMAGE_DEVICE:
                    case Picker.PICK_IMAGE_CAMERA:
                        mImageChooser.onActivityResult(requestCode, resultCode, data);
                        break;

                    case 100:
//                        mImageChooser.onActivityResult(requestCode, resultCode, data);
//                        Uri selectedPdf = data.getData();
//
////                    PdfSelected.setVisibility(View.VISIBLE);
//                        if (selectedPdf.getLastPathSegment().endsWith("pdf")) {
//
//
//                            System.out.println("Uri of selected pdf---->" + selectedPdf.toString());
//                        } else if (resultCode == RESULT_CANCELED) {
//                            Toast.makeText(this, "Invalid file type", Toast.LENGTH_SHORT).show();
//                        }

                        if ( data != null && data.getData() != null) {
                            Uri uri = data.getData();
                            Log.e("Uri-", "" + uri);
                            String strPath = CommonUtil.getRealPathFromURI(ChoosePdfActivity.this, uri);
                            if (strPath != null) {
                                Log.e("strPath", "" + strPath);
                                if (strPath.endsWith("pdf") || strPath.endsWith("doc") || strPath.endsWith("docx")) {
                                    setAttachedFile(strPath);
                                    //                        Log.e("file", file + "");
                                    //                        Log.e("File file", file.getAbsolutePath() + "  " + file.getName());

                                } else {
                                    //                        Util.displayPopUpDialog("Invalid file type", ResumeActivity.this);
                                }
                            } else {
//                                showAlertDialog("Please select file from phone.");
                            }
                        }

                        break;

                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setAttachedFile(String original) {
        if (original != null) {

            Log.d("Pdf",new File(original)+"");
//            fields1.put("attachment", new TypedFile("image/*", new File(original)));
        }
    }

    @Override
    public void loadImage(List<ChosenImage> list) {
        Log.d("Image",list.get(0).getThumbnailPath()+" image");

    }

    @Override
    public void pdfFile(Uri uri) {
        File file=new File(uri.toString());
        Log.d("Pdf",uri+" uri");
        Log.d("Pdf",file+" file");
    }
}
