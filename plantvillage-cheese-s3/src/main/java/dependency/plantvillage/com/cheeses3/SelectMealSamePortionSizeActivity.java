package dependency.plantvillage.com.cheeses3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectMealSamePortionSizeActivity extends AppCompatActivity {
    Button btn_small;
    Button btn_large;
    //Button btn_undo;

    String food_name;
    String portion_size;
    ArrayList<String> food_list;
    ArrayList<String> portion_list;
    ArrayList<Integer> food_id_list;
    ArrayList<Integer> portion_id_list;
    int portion_id;
    int picType;
    int userID;
    int samePortions;
    String FROM_ACTIVITY;
    String dishType;
    ArrayList<String> recipeCodeList;
    String filename;
    int portionID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_meal_same_portion_size);
        Intent intent=getIntent();
        food_name= intent.getStringExtra("food_name");
        food_list = intent.getStringArrayListExtra("food_list");
        food_id_list = intent.getIntegerArrayListExtra("food_id_list");
        portion_id_list = intent.getIntegerArrayListExtra("portion_id_list");
        portion_list = intent.getStringArrayListExtra("portion_list");
        btn_small = (Button) findViewById(R.id.btn_small);
        btn_large = (Button) findViewById(R.id.btn_large);
        picType = intent.getIntExtra("picType", 0);
        userID = intent.getIntExtra("userID", 0);
        samePortions = intent.getIntExtra("samePortions", 0);
        FROM_ACTIVITY = intent.getStringExtra("FROM_ACTIVITY");
        dishType = intent.getStringExtra("dishType");
        recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
        portionID = intent.getIntExtra("portion_id", 0);

        if (recipeCodeList == null) {
            recipeCodeList = new ArrayList<String>();
        }
        filename = intent.getStringExtra("filename");

//        Toast.makeText(SelectMealSamePortionSizeActivity.this,  "dishType = " + dishType, Toast.LENGTH_SHORT).show();

        // btn_undo = (Button) findViewById(R.id.btn_undo);

        btn_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dishType.equals("FM") || dishType.equals("FP")) {
                    portion_size = "Medium";
                } else {
                    portion_size = "Small";
                }
                portion_id = 2;
                //Toast.makeText(SelectMealPortionSizeActivity.this, portion_size  + " Portion of " + food_name + " added", Toast.LENGTH_SHORT).show();
                if (FROM_ACTIVITY.equals("CAPTURE")){
                    filename = filename.replace("-"+Integer.toString(portionID)+"-","-"+Integer.toString(portion_id)+"-");
                    selectAddFoodCapture(view);
                }
                else {
                    selectAddRecipe(view);
                }
            }

        });

        btn_large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portion_size = "Large";
                portion_id = 3;
                //Toast.makeText(SelectMealPortionSizeActivity.this, portion_size + " Portion of " + food_name + " added", Toast.LENGTH_SHORT).show();
                if (FROM_ACTIVITY.equals("CAPTURE")){
                    filename = filename.replace("-"+Integer.toString(portionID)+"-","-"+Integer.toString(portion_id)+"-");
                    selectAddFoodCapture(view);
                }
                else {
                    selectAddRecipe(view);
                }            }

        });

    }

    public void selectAddFoodCapture(View view) {

        Intent intent;
        if(dishType.equals("IM") || dishType.equals("FM")) {
            intent = new Intent(this, CaptureImageUploadSamePortionsImFmActivity.class);
        } else {
            intent = new Intent(this, CaptureImageUploadSamePortionsActivity.class);
        }
        portion_list.clear();
        portion_id_list.clear();
        for (int i = 0; i<food_list.size();i++) {
            portion_list.add(portion_size);
            portion_id_list.add(portion_id);
        }
        intent.putExtra("food_list", food_list);
        intent.putExtra("food_id_list", food_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("portion_id", portion_id);
        intent.putExtra("portion_size", portion_size);
        intent.putExtra("dishType", dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("filename",filename);

        startActivity(intent);
    }

    public void selectAddRecipe(View view) {
        Intent intent = new Intent(this, SelectRecipeSamePortionActivity.class);
        portion_list.add(portion_size);
        portion_id_list.add(portion_id);
        intent.putExtra("food_list", food_list);
        intent.putExtra("food_id_list", food_id_list);
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("portion_id", portion_id);
        intent.putExtra("portion_size", portion_size);
        intent.putExtra("dishType", dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("filename",filename);


        startActivity(intent);
    }


/*
    public void undoAddFood(View view) {
        Intent intent = new Intent(this, SelectFoodActivity.class);
        food_list.remove(food_name);
        intent.putExtra("food_list", food_list);
        intent.putExtra("food_id_list", food_id_list);
        intent.putExtra("portion_list", portion_list);
        startActivity(intent);
    }

 */

}
