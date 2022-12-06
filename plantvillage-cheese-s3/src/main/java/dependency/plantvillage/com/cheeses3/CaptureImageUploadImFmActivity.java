package dependency.plantvillage.com.cheeses3;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.AmazonS3Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class CaptureImageUploadImFmActivity extends AppCompatActivity {

    String key = "AKIAR5SR7XGQJFT2JFXB";
    String secret = "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";

    BasicAWSCredentials credentials;


    AmazonS3Client s3;

    TransferUtility transferUtility;

    ProgressBar pb;
    Button btn_45_photo, btn_90_photo, btn_more_food, btn_new_dish, btn_change_portion_keep_food, btn_change_food_keep_portion, btn_save;
    String portion_size;


    TextView _status;
    ImageView imageView, imageView2;

    protected static final int CAMERA_REQUEST = 0;
    protected static final int GALLERY_PICTURE = 1;
    private Intent pictureActionIntent = null;
    Bitmap bitmap;
    ArrayList<String> food_list;
    ArrayList<String> portion_list;
    ArrayList<Integer> unsorted_food_id_list;

    ArrayList<Integer> sorted_food_id_list;
    ArrayList<Integer> portion_id_list;
    String selectedImagePath;
    int picType;
    int userID;
    int samePortions;
    int portionID;
    String portionSize;
    String dishType;
    String angle;
    ArrayList<String> portion_food_id_list;
    Boolean imageChosen = false;
    ArrayList<String> recipeCodeList;
    String filename;
    ArrayList<String> recipeNameList;



    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image_upload_im_fm);
        Intent intent=getIntent();

        pb = (ProgressBar) findViewById(R.id.progressBar);
        btn_45_photo = (Button) findViewById(R.id.btn_45_photo);
        btn_90_photo = (Button) findViewById(R.id.btn_90_photo);
        btn_new_dish = (Button) findViewById(R.id.btn_new_dish);
        //btn_save = (Button) findViewById(R.id.btn_save);

        btn_change_food_keep_portion = (Button) findViewById(R.id.btn_change_food_keep_portion);
        btn_change_portion_keep_food= (Button) findViewById(R.id.btn_change_portion_keep_food);

        _status = (TextView) findViewById(R.id.txt_progress);
        //imageView = (ImageView) findViewById(R.id.image);
        //imageView2 = (ImageView) findViewById(R.id.image2);
        portion_size= intent.getStringExtra("portion_size");
        food_list = intent.getStringArrayListExtra("food_list");
        portion_list = intent.getStringArrayListExtra("portion_list");
        unsorted_food_id_list = intent.getIntegerArrayListExtra("food_id_list");
        portion_id_list = intent.getIntegerArrayListExtra("portion_id_list");
        picType = intent.getIntExtra("picType", 1);
        userID = intent.getIntExtra("userID", 0);
        samePortions = intent.getIntExtra("samePortions", 1);
        portionID = intent.getIntExtra("portion_id", 0);
        portionSize = intent.getStringExtra("portion_size");
        dishType = intent.getStringExtra("dishType");
        recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
        filename = intent.getStringExtra("filename");
        recipeNameList = intent.getStringArrayListExtra("recipeNameList");

        System.out.println("\n\n\n\nFilename in Capture IMFM = " + filename);


        btn_more_food = (Button) findViewById(R.id.btn_more_food);

        portion_food_id_list = new ArrayList<String>(recipeCodeList.size()); // Make a new list

        int food_list_length = recipeCodeList.size();
        if (food_list_length != portion_list.size()) { // Too many names, or too many numbers

        }
        System.out.println("portion list length = " + portion_list.size());
        System.out.println("recipe name list = " + recipeNameList);

        ArrayList<String> food_and_portion_list = new ArrayList<String>(food_list_length); // Make a new list
        for (int i = 0; i < recipeCodeList.size(); i++) { // Loop through every name/phone number combo
            food_and_portion_list.add(portion_list.get(i)
                    + " " + recipeNameList.get(i)); // Concat the two, and add it
        }



        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        requestForSpecificPermission();


        btn_45_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = "45";
                startDialog();
                imageChosen = true;
            }
        });
        btn_90_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = "90";
                startDialog();
                imageChosen = true;
            }
        });

        btn_more_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectFood(view);
            }
        });

        btn_change_food_keep_portion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editRecipe(view);

                //Toast.makeText(CaptureImageUploadImFmActivity.this, "Edit recipe is not implemented in this version.", Toast.LENGTH_SHORT).show();
            }
        });
        btn_change_portion_keep_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CaptureImageUploadImFmActivity.this, "Change portion for different portions has not been implemented yet.", Toast.LENGTH_SHORT).show();

            }
        });

        btn_new_dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOver(userID);
            }
        });

        final ListView listview = (ListView) findViewById(R.id.listview);

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, food_and_portion_list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                //food_list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });

    }

    public void editRecipe(View view) {
        Intent intent = new Intent(this, EditRecipeListActivity.class);
        intent.putExtra("food_list", food_list);
        intent.putExtra("food_id_list", unsorted_food_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("portion_size", portion_size);
        intent.putExtra("portion_id", portionID);
        intent.putExtra("FROM_ACTIVITY", "CAPTURE");
        intent.putExtra("dishType",dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("recipeNameList", recipeNameList);

        intent.putExtra("filename",filename);
        System.out.println("before edit recipe activity. recipeNameList = " + recipeNameList);
        startActivity(intent);
    }

    public void selectFood(View view) {
        Intent intent = new Intent(this, SelectRecipeActivity.class);

        intent.putExtra("portion_list", portion_list);
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("samePortions", samePortions);
        intent.putExtra("dishType", dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("filename",filename);
        intent.putExtra("recipeNameList", recipeNameList);

        startActivity(intent);
    }

    public void startOver(int userID) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

    public String createFilename(String baseFilename, String angle, int userID, String dishType){
        String filename = "";
        int i = 0;
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM_HH-mm-ss");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        filename = angle + '_' + thisDate  + "_" + baseFilename;
        filename = filename + userID +  ".jpg";
        return filename;
    }

    private void processImageByPath(String path){

        credentials = new BasicAWSCredentials(key, secret);
        s3 = new AmazonS3Client(credentials);
        //s3.setEndpoint("http://localhost:9444/s3");
        //s3.setS3ClientOptions(S3ClientOptions.builder().setPathStyleAccess(true).disableChunkedEncoding().build());
        //s3.setS3ClientOptions(S3ClientOptions.builder().setPathStyleAccess(true).d);
        transferUtility = new TransferUtility(s3, CaptureImageUploadImFmActivity.this);

        String myJpgPath = path;


        Bitmap myBitmap = BitmapFactory.decodeFile(myJpgPath);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        //byte[] byteArray = stream.toByteArray();



        Log.d("PV", myJpgPath);

        File file = new File(myJpgPath);

        //File file1 = new File(myJpgPath);

        if (!file.exists()) {
            Toast.makeText(CaptureImageUploadImFmActivity.this, "File Not Found!", Toast.LENGTH_SHORT).show();
            return;
        }


        Log.d("PV", file.getAbsolutePath() + " " + file.getName());

        /*
        String output = new Random().nextInt() + file.getName();
        final String s3Name;
        final String bucketName;


        bucketName = "nudging/food_atlas/ghana";
        s3Name = "https://s3.amazonaws.com/nudging/food_atlas/ghana/"+output;


        final TransferObserver observer = transferUtility.upload(
                bucketName,
                output,
                file
        );





        observer.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state.COMPLETED.equals(observer.getState())) {
                    //num_pics = num_pics + 1;
                    Toast.makeText(MainActivity.this, "File Upload Complete", Toast.LENGTH_SHORT).show();
                    new MainActivity.LongOperation().execute(s3Name);

                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {

                //Toast.makeText(MainActivity.this, "In Progress Changed", Toast.LENGTH_SHORT).show();

                long _bytesCurrent = bytesCurrent;
                long _bytesTotal = bytesTotal;

                float percentage = ((float) _bytesCurrent / (float) _bytesTotal * 100);
                Log.d("percentage", "" + percentage);
                pb.setProgress((int) percentage);
                _status.setText(percentage + "%");
            }

            @Override
            public void onError(int id, Exception ex) {

                Toast.makeText(MainActivity.this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        observer.refresh();
        */


    }

    private void startDialog() {
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                this);
        myAlertDialog.setTitle("Would you like to take a picture or select from gallery?");

        myAlertDialog.setPositiveButton("Select From Gallery",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent pictureActionIntent = null;

                        pictureActionIntent = new Intent(
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(
                                pictureActionIntent,
                                GALLERY_PICTURE);

                    }
                });

        myAlertDialog.setNegativeButton("Take a Picture",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent intent = new Intent(
                                MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                        File f = new File(android.os.Environment
                                .getExternalStorageDirectory(), "temp.jpg");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(f));
                        System.out.println("Before Camera Request");
                        startActivityForResult(intent,
                                CAMERA_REQUEST);

                    }
                });
        myAlertDialog.show();
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        bitmap = null;
        selectedImagePath = null;
        System.out.println("After Camera Request");
        System.out.println("resultCode = " + resultCode);
        System.out.println("requestCode = " + CAMERA_REQUEST);
        System.out.println("RESULT_OK = " + RESULT_OK);

        if (resultCode == RESULT_OK && requestCode == CAMERA_REQUEST) {

            File f = new File(Environment.getExternalStorageDirectory()
                    .toString());
            for (File temp : f.listFiles()) {
                if (temp.getName().equals("temp.jpg")) {
                    f = temp;
                    break;
                }
            }

            if (!f.exists()) {
                System.out.println("ERROR trying to get image saved path");
                Toast.makeText(getBaseContext(),
                        "Error while capturing image", Toast.LENGTH_LONG)
                        .show();
                return;
            }

            try {
                System.out.println("Trying to get bitmap");

                File file = new File(f.getAbsolutePath());
                ImageDecoder.Source source = ImageDecoder.createSource(file);
                bitmap = ImageDecoder.decodeBitmap(source);

                //bitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
                //bitmap = Bitmap.createBitmap(bitmap);

                int rotate = 0;
                try {
                    ExifInterface exif = new ExifInterface(f.getAbsolutePath());
                    int orientation = exif.getAttributeInt(
                            ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_NORMAL);

                    switch (orientation) {
                        case ExifInterface.ORIENTATION_ROTATE_270:
                            rotate = 270;
                            break;
                        case ExifInterface.ORIENTATION_ROTATE_180:
                            rotate = 180;
                            break;
                        case ExifInterface.ORIENTATION_ROTATE_90:
                            rotate = 90;
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
                Matrix matrix = new Matrix();
                matrix.postRotate(rotate);
                storeImageTosdCard(bitmap);

                //imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("Failed to get bitmap");

                e.printStackTrace();
            }

        } else if (resultCode == RESULT_OK && requestCode == GALLERY_PICTURE) {
            if (data != null) {

                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage, filePath,
                        null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                selectedImagePath = c.getString(columnIndex);
                c.close();

                if (selectedImagePath != null) {
                    //txt_image_path.setText(selectedImagePath);

                }
                File file = new File(selectedImagePath);

                ImageDecoder.Source source = ImageDecoder.createSource(file);
                try {
                    bitmap = ImageDecoder.decodeBitmap(source);
                } catch (IOException e) {
                    System.out.println("ERROR DECODING DRAWABLE BEFORE SAVE");
                    e.printStackTrace();
                }
                //bitmap = BitmapFactory.decodeFile(selectedImagePath); // loses exifdata?
                // preview image
                //bitmap = Bitmap.createBitmap(bitmap);
                System.out.println("INSIDE IMFM ACTIVITY BEFORE SAVE TO SD CARD");
                System.out.println("Saving file without storeImageTosdCard function");
                storeImageTosdCard(bitmap);

                //imageView.setImageBitmap(bitmap);


            } else {
                Toast.makeText(getApplicationContext(), "Cancelled",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private void storeImageTosdCard(Bitmap processedBitmap) {
        try {
            // TODO Auto-generated method stub
            // Find the DCIM path
            String photoDirPath = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DCIM + "/Cheese/";
            File directory = new File(photoDirPath);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String name = createFilename(filename, angle, userID, dishType);
            System.out.println("Saving image with filename: " + name);
            File pictureFile = new File(directory, name);
            Toast.makeText(CaptureImageUploadImFmActivity.this, "Saving file to DCIM/Cheese/"+name,Toast.LENGTH_LONG).show();
            System.out.println(pictureFile);

            //pictureFile.createNewFile();
            try {
                FileOutputStream out = new FileOutputStream(pictureFile);
                processedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(CaptureImageUploadImFmActivity.this, "Image Saved",Toast.LENGTH_LONG).show();

    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        public DownloadImageTask(ImageView bmImage) {
            imageView = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            imageView2.setImageBitmap(result);
        }
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {

                URL url = new URL("http://107.21.9.12/upload");

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("myfile", params[0]);
                Log.e("params", postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);


                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();

                if (false || responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line = "";

                    while ((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                } else {
                    return new String("false : " + responseCode);
                }
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }

        }

        public String getPostDataString(JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while(itr.hasNext()){

                String key= itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));



            }
            return result.toString();
        }

        public String getoutputString(JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while(itr.hasNext()){

                String key= itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));
                return value.toString();


            }
            return result.toString();
        }


    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            String url1 = getoutputString(jsonObject);
            new CaptureImageUploadImFmActivity.DownloadImageTask(imageView).execute(url1);
            URL url = null;
            try {
                url = new URL(url1);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("PV", result);




    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}
