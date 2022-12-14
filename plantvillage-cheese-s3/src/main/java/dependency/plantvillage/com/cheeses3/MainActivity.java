package dependency.plantvillage.com.cheeses3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btn_meal, btn_meal_family, btn_meal_same_portions, btn_family_meal_same_portions, btn_plate_same_portions;

    Button btn_plate;
    ArrayList<String> food_list = new ArrayList<String>();
    ArrayList<String> portion_list = new ArrayList<String>();
    ArrayList<Integer> food_id_list = new ArrayList<>();
    ArrayList<Integer> portion_id_list = new ArrayList<>();
    int userID;
    String dishType = "none";
    private static int selectedPosition = 0;
    String filename = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();

        userID = intent.getIntExtra("userID", 0);

        btn_meal = (Button) findViewById(R.id.btn_meal);
        //btn_meal_family = (Button) findViewById(R.id.btn_meal_family);
        //btn_plate = (Button) findViewById(R.id.btn_plate);
        btn_meal_same_portions = (Button) findViewById(R.id.btn_meal_same_portions);
        //btn_family_meal_same_portions = (Button) findViewById(R.id.btn_family_meal_same_portions);
        //btn_plate_same_portions = (Button) findViewById(R.id.btn_plate_same_portions);



        Spinner spinner = (Spinner) findViewById(R.id.personal_id_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.personal_id_spinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setSelection(selectedPosition);

        btn_meal.setOnClickListener(new View.OnClickListener() { // individual meal
            @Override
            public void onClick(View view) {
                if (userID != 0) {
                    nextActivity(view,0);
                } else {
                    Toast.makeText(MainActivity.this, "Please select a person ID number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_meal_same_portions.setOnClickListener(new View.OnClickListener() { // individual meal
            @Override
            public void onClick(View view) {
                if (userID != 0) {

                    nextActivity(view,  1);
                } else {
                    Toast.makeText(MainActivity.this, "Please select a personal ID number...", Toast.LENGTH_SHORT).show();
                }
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                userID = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void nextActivity(View view, int isSamePortions) {
       // Toast.makeText(getApplicationContext(),"picType = " + picType, Toast.LENGTH_SHORT).show();
        Intent intent;

        if (isSamePortions == 0) { // not same portion sizes
                intent = new Intent(this, SelectRecipeActivity.class);
        } else { // same portion sizes
                intent = new Intent(this, SelectPortionSizeActivity.class);

        }

        intent.putExtra("food_list", food_list);
        intent.putExtra("food_id_list", food_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("isSamePortions", isSamePortions);
        intent.putExtra("userID", userID);
        intent.putExtra("FROM_ACTIVITY", "MAIN");
        intent.putExtra("filename",filename);

        startActivityForResult(intent, 1);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}