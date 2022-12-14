package dependency.plantvillage.com.cheeses3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ChangePortionActivity extends AppCompatActivity {
    Button btn_small;
    Button btn_medium;
    Button btn_large;
    Button btn_xl;

    String food_name;
    String portion_size;
    ArrayList<String> food_list;
    ArrayList<String> portion_list;
    ArrayList<Integer> food_id_list;
    ArrayList<Integer> portion_id_list;
    int portion_id;
    int picType;
    int userID;
    String FROM_ACTIVITY;
    String dishType;
    ArrayList<String> recipeCodeList;
    ArrayList<String> recipeNameList;

    String filename;
    int portionID;
    int numFoodsInRecipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_plate_portion_size );
        Intent intent=getIntent();
        food_name= intent.getStringExtra("food_name");
        food_list = intent.getStringArrayListExtra("food_list");
        food_id_list = intent.getIntegerArrayListExtra("food_id_list");
        portion_id_list = intent.getIntegerArrayListExtra("portion_id_list");
        picType = intent.getIntExtra("picType", 0);
        portion_list = intent.getStringArrayListExtra("portion_list");
        userID = intent.getIntExtra("userID", 0);
        FROM_ACTIVITY = intent.getStringExtra("FROM_ACTIVITY");
        dishType = intent.getStringExtra("dishType");
        recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
        filename = intent.getStringExtra("filename");
        portionID = intent.getIntExtra("portion_id", 0);
        recipeNameList = intent.getStringArrayListExtra("recipeNameList");
        numFoodsInRecipe = intent.getIntExtra("numFoodsInRecipe", 1);

        if (recipeCodeList == null) {
            recipeCodeList = new ArrayList<String>();
        }

        btn_small = (Button) findViewById(R.id.btn_small);
        btn_medium = (Button) findViewById(R.id.btn_medium);
        btn_large = (Button) findViewById(R.id.btn_large);
        btn_xl = (Button) findViewById(R.id.btn_xl);

        btn_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Old portion ID = " + portionID);
                portion_size = "Small";
                portion_id = 1;
                filename = filename.replace("-"+Integer.toString(portionID),"-"+Integer.toString(portion_id));
                selectAddFoodCapture(view);

            }

        });
        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Old portion ID = " + portionID);
                portion_size = "Medium";
                portion_id = 2;
                filename = filename.replace("-"+Integer.toString(portionID),"-"+Integer.toString(portion_id));
                selectAddFoodCapture(view);

            }

        });
        btn_large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Old portion ID = " + portionID);

                portion_size = "Large";
                portion_id = 3;

                filename = filename.replace("-"+Integer.toString(portionID),"-"+Integer.toString(portion_id));
                selectAddFoodCapture(view);

            }

        });
        btn_xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Old portion ID = " + portionID);
                portion_size = "Extra Large";
                portion_id = 4;

                filename = filename.replace("-"+Integer.toString(portionID),"-"+Integer.toString(portion_id));
                selectAddFoodCapture(view);

            }

        });

    }


    public void selectAddFoodCapture(View view) {
        Intent intent;
        intent = new Intent(this, CaptureImageUploadImFmActivity.class);

        portion_list.clear();
        portion_id_list.clear();
        for (int i = 0; i<recipeCodeList.size();i++) {
            portion_list.add(portion_size);
            portion_id_list.add(portion_id);
        }
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("portion_id", portion_id);
        intent.putExtra("portion_size", portion_size);
        intent.putExtra("dishType", dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("recipeNameList", recipeNameList);
        intent.putExtra("numFoodsInRecipe", numFoodsInRecipe);

        intent.putExtra("filename",filename);

        startActivity(intent);
    }



}
