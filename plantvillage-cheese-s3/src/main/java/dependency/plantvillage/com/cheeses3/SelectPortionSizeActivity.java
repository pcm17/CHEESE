package dependency.plantvillage.com.cheeses3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectPortionSizeActivity extends AppCompatActivity {
    Button btn_small;
    Button btn_medium;
    Button btn_large;
    Button btn_xl;

    String food_name;
    String portion_size;

    ArrayList<String> portion_list;
    ArrayList<Integer> portion_id_list;
    int portion_id;
    int picType;
    int userID;
    int numFoodsInRecipe;
    int isSamePortions;
    String dishType;
    ArrayList<String> recipeCodeList;
    String FROM_ACTIVITY;
    ArrayList<String> recipeNameList;

    String filename = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_plate_portion_size);
        Intent intent=getIntent();
        food_name= intent.getStringExtra("food_name");
        portion_id_list = intent.getIntegerArrayListExtra("portion_id_list");
        picType = intent.getIntExtra("picType", 0);
        portion_list = intent.getStringArrayListExtra("portion_list");
        userID = intent.getIntExtra("userID", 0);
        numFoodsInRecipe = intent.getIntExtra("numFoodsInRecipe", 1);
        dishType = intent.getStringExtra("dishType");
        recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
        filename = intent.getStringExtra("filename");
        recipeNameList = intent.getStringArrayListExtra("recipeNameList");
        FROM_ACTIVITY = intent.getStringExtra("FROM_ACTIVITY");
        isSamePortions = intent.getIntExtra("isSamePortions", 0);

        btn_small = (Button) findViewById(R.id.btn_small);
        btn_medium = (Button) findViewById(R.id.btn_medium);
        btn_large = (Button) findViewById(R.id.btn_large);
        btn_xl = (Button) findViewById(R.id.btn_xl);

        System.out.println("\n\n\n\nFilename in Select Plate Portion Size = " +filename);


        btn_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portion_size = "Small";
                portion_id = 1;
                //Toast.makeText(SelectPlatePortionSizeActivity.this, portion_size  + " Portion of " + food_name + " added", Toast.LENGTH_SHORT).show();
                filename = filename.replace("1000",Integer.toString(portion_id));
                nextActivity(view);
            }

        });
        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portion_size = "Medium";
                portion_id = 2;
                //Toast.makeText(SelectPlatePortionSizeActivity.this, portion_size +" Portion of " + food_name + " added", Toast.LENGTH_SHORT).show();
                filename = filename.replace("1000",Integer.toString(portion_id));
                nextActivity(view);
            }

        });
        btn_large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portion_size = "Large";
                portion_id = 3;
                //Toast.makeText(SelectPlatePortionSizeActivity.this, portion_size + " Portion of " + food_name + " added", Toast.LENGTH_SHORT).show();
                filename = filename.replace("1000",Integer.toString(portion_id));
                nextActivity(view);
            }

        });
        btn_xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portion_size = "Extra Large";
                portion_id = 4;
                //Toast.makeText(SelectPlatePortionSizeActivity.this, portion_size  +" Portion of " + food_name + " added", Toast.LENGTH_SHORT).show();
                filename = filename.replace("1000",Integer.toString(portion_id));
                nextActivity(view);
            }

        });

    }


    public void nextActivity(View view) {
        Intent intent;
        if (FROM_ACTIVITY.equals("MAIN")) {
            intent = new Intent(this, SelectRecipeActivity.class);
        } else if (FROM_ACTIVITY.equals("SELECT_RECIPE")){
            intent = new Intent(this, CaptureImageUploadImFmActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        for (int i = 0;i<numFoodsInRecipe;i++) {
            portion_list.add(portion_size);
            portion_id_list.add(portion_id);
        }
        System.out.println("portion list in portion size activity = " + portion_list);
        System.out.println("PORTION IsSamePortions = " + isSamePortions);

        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("portion_size", portion_size);
        intent.putExtra("portion_id", portion_id);
        intent.putExtra("dishType", dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("filename", filename);
        intent.putExtra("recipeNameList", recipeNameList);
        intent.putExtra("isSamePortions", isSamePortions);

        startActivity(intent);
    }


}
