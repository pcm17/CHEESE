package dependency.plantvillage.com.cheeses3;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
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
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

public class CaptureImageUploadSamePortionsActivity extends AppCompatActivity {

    String key = "AKIAR5SR7XGQJFT2JFXB";
    String secret = "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";

    BasicAWSCredentials credentials;


    AmazonS3Client s3;

    TransferUtility transferUtility;

    ProgressBar pb;
    Button btn_45_photo, btn_90_photo, btn_new_dish, btn_change_portion_keep_food;
    String portion_size;


    TextView _status;
    ImageView imageView, imageView2;

    ImageView img_logo;
    protected static final int CAMERA_REQUEST = 0;
    protected static final int GALLERY_PICTURE = 1;
    private Intent pictureActionIntent = null;
    Bitmap bitmap;
    ArrayList<String> food_list;
    ArrayList<String> portion_list;
    ArrayList<Integer> unsorted_food_id_list;

    ArrayList<Integer> sorted_food_id_list;
    ArrayList<Integer> portion_id_list;
    ArrayList<Integer> sorted_portion_id_list = new ArrayList<>();
    String recipeName;
    String selectedImagePath;
    int picType;
    int userID;
    int portionID;
    String dishType;
    Boolean imageChosen = false;
    ArrayList<String> portion_food_id_list;
    String angle;
    ArrayList<String> recipeCodeList;
    String filename;






    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image_upload_same_portions);
        Intent intent=getIntent();

        pb = (ProgressBar) findViewById(R.id.progressBar);
        btn_45_photo = (Button) findViewById(R.id.btn_45_photo);
        btn_90_photo = (Button) findViewById(R.id.btn_90_photo);
        btn_new_dish = (Button) findViewById(R.id.btn_new_dish);

        //btn_change_food_keep_portion = (Button) findViewById(R.id.btn_change_food_keep_portion);
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
        recipeName= intent.getStringExtra("recipeName");
        portionID = intent.getIntExtra("portion_id", 0);
        dishType = intent.getStringExtra("dishType");
        recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
        filename = intent.getStringExtra("filename");
        System.out.println("\n\n\n\nFilename in Capture FP = " +filename);

        portion_food_id_list = new ArrayList<String>(food_list.size()); // Make a new list



        int food_list_length = food_list.size();
        for ( int n = 0; n < portion_id_list.size(); n++) { // Loop through portion id
           //System.out.println(portion_id_list.get(n));
        }
        if (food_list_length != portion_list.size()) { // Too many names, or too many numbers

        }
        ArrayList<String> food_and_portion_list = new ArrayList<String>(food_list_length); // Make a new list
        for (int i = 0; i < food_list_length; i++) { // Loop through every name/phone number combo
            food_and_portion_list.add(portion_list.get(i) +
                    " " + food_list.get(i)); // Concat the two, and add it
        }
        int food_and_portion_list_length = food_and_portion_list.size();
        if (food_and_portion_list_length != unsorted_food_id_list.size()) { // Too many names, or too many numbers
            // Fail
        }
        sorted_food_id_list = unsorted_food_id_list;
        Collections.sort(sorted_food_id_list);
        int i = 0;
        int j = 0;
        int tmp = 0;

        for (i = 0; i < sorted_food_id_list.size(); i++) {
            sorted_portion_id_list.add(0);
        }
        //System.out.println("sorted food list length = " + sorted_food_id_list.size());

        for (j = 0; j < sorted_food_id_list.size(); j++) {
            for (i = 0; i < sorted_food_id_list.size(); i++) {
                if(sorted_food_id_list.get(i) == unsorted_food_id_list.get(j)){
                    tmp = portion_id_list.get(j);
                    sorted_portion_id_list.set(i,tmp);
                }
            }
        }

        for ( i = 0; i < food_list_length; i++) { // Loop through every name/phone number combo
            portion_food_id_list.add(sorted_food_id_list.get(i)  + "-" + sorted_portion_id_list.get(i)); // Concat the two, and add it
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



        btn_change_portion_keep_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changePortionKeepFood(view, picType);
            }
        });
        /*
        btn_change_food_keep_portion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CaptureImageUploadSamePortionsActivity.this, "Edit recipe list has not been implemented yet.", Toast.LENGTH_SHORT).show();
            }
        });
         */

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
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });

    }

    public void changePortionKeepFood(View view, int picType) {
        Intent intent;
        if (picType == 2) {
            intent = new Intent(this, SelectPlateSamePortionSizeActivity.class);
        } else {
            intent = new Intent(this, SelectMealSamePortionSizeActivity.class);
        }
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
        intent.putExtra("filename",filename);
        intent.putExtra("portionID", portionID);
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
        filename = filename + dishType+ '_' + userID +  ".jpg";
        return filename;
    }

    private void processImageByPath(String path){

        credentials = new BasicAWSCredentials(key, secret);
        s3 = new AmazonS3Client(credentials);
        transferUtility = new TransferUtility(s3, CaptureImageUploadSamePortionsActivity.this);

        String myJpgPath = path;


        Bitmap myBitmap = BitmapFactory.decodeFile(myJpgPath);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
               Log.d("PV", myJpgPath);

        File file = new File(myJpgPath);

        if (!file.exists()) {
            Toast.makeText(CaptureImageUploadSamePortionsActivity.this, "File Not Found!", Toast.LENGTH_SHORT).show();
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
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        File f = new File(android.os.Environment
                                .getExternalStorageDirectory(), "temp.jpg");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(f));

                        startActivityForResult(intent,
                                CAMERA_REQUEST);

                    }
                });
        myAlertDialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        bitmap = null;
        selectedImagePath = null;

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

                Toast.makeText(getBaseContext(),
                        "Error while capturing image", Toast.LENGTH_LONG)
                        .show();
                return;
            }

            try {

                bitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
                bitmap = Bitmap.createBitmap(bitmap);

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

                bitmap = BitmapFactory.decodeFile(selectedImagePath); // load
                // preview image
                bitmap = Bitmap.createBitmap(bitmap);
                storeImageTosdCard(bitmap);

                //imageView.setImageBitmap(bitmap);


            } else {
                Toast.makeText(getApplicationContext(), "Cancelled",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }

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
            Toast.makeText(CaptureImageUploadSamePortionsActivity.this, "Saving file to DCIM/Cheese/"+name,Toast.LENGTH_LONG).show();

            File pictureFile = new File(directory, name);
            pictureFile.createNewFile();
            try {
                FileOutputStream out = new FileOutputStream(pictureFile);
                processedBitmap
                        .compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(CaptureImageUploadSamePortionsActivity.this, "Image Saved",Toast.LENGTH_LONG).show();


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
            new DownloadImageTask(imageView).execute(url1);
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

        //String url1 = value.toString();



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
