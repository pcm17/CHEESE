package dependency.plantvillage.com.cheeses3;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EditRecipeListActivity extends AppCompatActivity {
    int picType;
    int userID;
    int portionID;
    String portionSize;
    String dishType;
    String filename;
    ArrayList<String> portion_list;
    ArrayList<Integer> food_id_list;
    ArrayList<Integer> portion_id_list;
    ArrayList<String> recipeCodeList;
    int outerIndex;
    ArrayList<String> recipeList = new ArrayList<>();
    ArrayList<String> recipeNameList = new ArrayList<>();
    ArrayList<ArrayList<String> > vietnam_foods_list_of_lists = new ArrayList<ArrayList<String> >();
    ArrayList<ArrayList<Integer> > vietnam_food_ids_list_of_lists = new ArrayList<>();
    Button btn_done;
    String FROM_ACTIVITY;
    ArrayList<String> food_list;


    List<String>recipe_list = Arrays.asList
            (//carbs
                    "Bánh mỳ",
                    "Bún đậu mắm tôm",
                    "Cơm rang trứng",
                    "Miến thịt gà, miền Bắc",
                    "Mỳ ăn liền nấu trứng",
                    "Mỳ gạo nấu thịt lợn",
                    "Phở bò xào",
                    "Xôi gấc",
                    "Xôi lạc miền Bắc",
                    "Xôi ruốc",

                    //proteins
                    "Cá trắm cỏ kho dưa chua thịt ba chỉ",
                    "Cánh gà chiên mắm",
                    "Thịt chân giò lợn, luộc",
                    "Thịt gà ta nướng",
                    "Thịt gà ta rang",
                    "Thịt lợn nửa nạc, nửa mỡ, luộc",

                    // vegetables
                    "Cá chép om dưa",
                    "Cải cúc nấu thịt băm",
                    "Cải xanh luộc",
                    "Cải xanh nấu canh",
                    "Canh chua thịt lợn nạc",
                    "Canh cua mướp, mồng tơi, rau đay",
                    "Canh riêu cua",
                    "Khoai tây ninh xương",
                    "Măng tươi nấu vịt",
                    "Ngao nấu chua",
                    "Rau muống xào",
                    "Rau ngót nấu thịt",

                    // fruit
                    "Bưởi",
                    "Cam",
                    "Dưa hấu",
                    "Quả thanh long",
                    "Quít",
                    "Táo tây",

                    // liquid
                    "Chè đỗ xanh",
                    "Chè hạt sen",
                    "Chè thập cẩm",
                    "Kem hộp Merino hương dâu",
                    "Kem que Merino Cacao - Sô cô la",
                    "Nước mía đá",

                    // snack
                    "Bánh tráng trộn",
                    "Khoai lang tẩm bột chiên/rán",
                    "Sữa chua đánh đá"
                    );







    ArrayList<String> recipeFoodsList1 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList2 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList3 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList4 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList5 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList6 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList7 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList8 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList9 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList10 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList11 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList12 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList13 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList14 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList15 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList16 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList17 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList18 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList19 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList20 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList21 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList22 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList23 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList24 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList25 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList26 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList27 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList28 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList29 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList30 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList31 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList32 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList33 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList34 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList35 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList36 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList37 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList38 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList39 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList40 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList41 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList42 = new ArrayList<String>();
    ArrayList<String> recipeFoodsList43 = new ArrayList<String>();



    ArrayList<Integer> recipeFoodIDsList1 = new ArrayList<>();
    ArrayList<Integer> recipeFoodIDsList2 = new ArrayList<>();
    ArrayList<Integer> recipeFoodIDsList3 = new ArrayList<>();
    ArrayList<Integer> recipeFoodIDsList4 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList5 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList6 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList7 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList8 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList9 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList10 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList11 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList12 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList13 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList14 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList15 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList16 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList17 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList18 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList19 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList20 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList21 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList22 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList23 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList24 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList25 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList26 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList27 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList28 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList29 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList30 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList31 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList32 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList33 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList34 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList35 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList36 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList37 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList38 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList39 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList40 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList41 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList42 = new ArrayList<Integer>();
    ArrayList<Integer> recipeFoodIDsList43 = new ArrayList<Integer>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe_list);
        Intent intent=getIntent();
        btn_done = (Button) findViewById(R.id.btn_done);
        food_list = intent.getStringArrayListExtra("food_list");
        food_id_list = intent.getIntegerArrayListExtra("food_id_list");
        portion_list= intent.getStringArrayListExtra("portion_list");
        portion_id_list = intent.getIntegerArrayListExtra("portion_id_list");
        picType = intent.getIntExtra("picType", 0);
        userID = intent.getIntExtra("userID", 0);
        portionID = intent.getIntExtra("portion_id", 0);
        portionSize = intent.getStringExtra("portion_size");
        dishType = intent.getStringExtra("dishType");
        recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
        FROM_ACTIVITY = intent.getStringExtra("FROM_ACTIVITY");
        filename = intent.getStringExtra("filename");
        System.out.println("Filename ON ARRIVE to Edit Recipe " + filename );
        if (filename == null) {
            filename = "";
        }
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(EditRecipeListActivity.this, "Done button has not been implemented yet.", Toast.LENGTH_SHORT).show();
                backToUploadCapture(view, filename);
            }
        });

        //System.out.println("                                            Old food list:");
        for (int i = 0; i < food_list.size();i++ ){
            //System.out.println("                                                              " + food_list.get(i));
        }

        recipeFoodsList1.add("Bánh mỳ không"); recipeFoodIDsList1.add(23);

        recipeFoodsList2.add("Bún"); recipeFoodIDsList2.add(8);
        recipeFoodsList2.add("Chả lợn"); recipeFoodIDsList2.add(31);
        recipeFoodsList2.add("Đậu phụ"); recipeFoodIDsList2.add(56);
        recipeFoodsList2.add("Lòng lợn"); recipeFoodIDsList2.add(37);
        recipeFoodsList2.add("Mắm tôm loãng"); recipeFoodIDsList2.add(271);
        recipeFoodsList2.add("Khác"); recipeFoodIDsList2.add(2);
        recipeFoodsList2.add("Sà lách"); recipeFoodIDsList2.add(81);
        recipeFoodsList2.add("Thịt lợn"); recipeFoodIDsList2.add(245);

        recipeFoodsList3.add("Cơm rang"); recipeFoodIDsList3.add(4);
        recipeFoodsList3.add("Trứng"); recipeFoodIDsList3.add(256);

        recipeFoodsList4.add("Miến "); recipeFoodIDsList4.add(10);
        recipeFoodsList4.add("Hành lá"); recipeFoodIDsList4.add(89);
        recipeFoodsList4.add("Nước dùng từ thịt/cá"); recipeFoodIDsList4.add(124);
        recipeFoodsList4.add("Thịt gà"); recipeFoodIDsList4.add(244);

        recipeFoodsList5.add("Mỳ  ăn liền"); recipeFoodIDsList5.add(12);
        recipeFoodsList5.add("Hành lá "); recipeFoodIDsList5.add(89);
        recipeFoodsList5.add("Nước dùng từ thịt/cá"); recipeFoodIDsList5.add(124);
        recipeFoodsList5.add("Trứng"); recipeFoodIDsList5.add(256);

        recipeFoodsList6.add("Cà chua"); recipeFoodIDsList6.add(79);
        recipeFoodsList6.add("Hành lá"); recipeFoodIDsList6.add(89);
        recipeFoodsList6.add("Nước dùng từ thịt/cá"); recipeFoodIDsList6.add(124);
        recipeFoodsList6.add("Mỳ gạo"); recipeFoodIDsList6.add(227);
        recipeFoodsList6.add("Thịt lợn"); recipeFoodIDsList6.add(245);

        recipeFoodsList7.add("Bánh phở"); recipeFoodIDsList7.add(6);
        recipeFoodsList7.add("Thịt bò "); recipeFoodIDsList7.add(38);
        recipeFoodsList7.add("Cải xanh"); recipeFoodIDsList7.add(70);
        recipeFoodsList7.add("Cà chua"); recipeFoodIDsList7.add(79);

        recipeFoodsList8.add("Xôi gấc"); recipeFoodIDsList8.add(262);

        recipeFoodsList9.add("Lạc"); recipeFoodIDsList9.add(59);
        recipeFoodsList9.add("Xôi trắng"); recipeFoodIDsList9.add(263);

        recipeFoodsList10.add("Xôi trắng"); recipeFoodIDsList10.add(263);
        recipeFoodsList10.add("Ruốc lợn "); recipeFoodIDsList10.add(146);

        recipeFoodsList11.add("Dưa cải bẹ"); recipeFoodIDsList11.add(88);
        recipeFoodsList11.add("Cá"); recipeFoodIDsList11.add(199);
        recipeFoodsList11.add("Thịt lợn"); recipeFoodIDsList11.add(245);

        recipeFoodsList12.add("Cánh gà"); recipeFoodIDsList12.add(202);
        recipeFoodsList12.add("Tỏi"); recipeFoodIDsList12.add(249);

        recipeFoodsList13.add("Thịt lợn"); recipeFoodIDsList13.add(245);

        recipeFoodsList14.add("Thịt gà"); recipeFoodIDsList14.add(244);

        recipeFoodsList15.add("Khác"); recipeFoodIDsList15.add(2);
        recipeFoodsList15.add("Thịt gà"); recipeFoodIDsList15.add(244);

        recipeFoodsList16.add("Thịt lợn"); recipeFoodIDsList16.add(245);

        recipeFoodsList17.add("Cá"); recipeFoodIDsList17.add(199);
        recipeFoodsList17.add("Cà chua"); recipeFoodIDsList17.add(79);
        recipeFoodsList17.add("Dưa cải bẹ"); recipeFoodIDsList17.add(88);
        recipeFoodsList17.add("Hành lá"); recipeFoodIDsList17.add(89);
        recipeFoodsList17.add("Nước dùng từ thịt/cá"); recipeFoodIDsList17.add(124);
        recipeFoodsList17.add("Khác"); recipeFoodIDsList17.add(2);

        recipeFoodsList18.add("Nước dùng từ thịt/cá"); recipeFoodIDsList18.add(124);
        recipeFoodsList18.add("Cải cúc"); recipeFoodIDsList18.add(130);
        recipeFoodsList18.add("Thịt lợn"); recipeFoodIDsList18.add(245);

        // mustard greens - left out of march9_2022 sheet
        recipeFoodsList19.add("Cải xanh"); recipeFoodIDsList19.add(70);

        recipeFoodsList20.add("Cải xanh"); recipeFoodIDsList20.add(70);
        recipeFoodsList20.add("Nước canh (từ rau củ)"); recipeFoodIDsList20.add(123);

        recipeFoodsList21.add("Cà chua"); recipeFoodIDsList21.add(79);
        recipeFoodsList21.add("Hành lá "); recipeFoodIDsList21.add(89);
        recipeFoodsList21.add("Dứa"); recipeFoodIDsList21.add(94);
        recipeFoodsList21.add("Nước dùng từ thịt/cá"); recipeFoodIDsList21.add(124);
        recipeFoodsList21.add("Thịt lợn"); recipeFoodIDsList21.add(245);

        recipeFoodsList22.add("Rau mồng tơi"); recipeFoodIDsList22.add(78);
        recipeFoodsList22.add("Nước dùng từ thịt/cá"); recipeFoodIDsList22.add(124);
        recipeFoodsList22.add("Mướp"); recipeFoodIDsList22.add(134);
        recipeFoodsList22.add("Cua"); recipeFoodIDsList22.add(147);

        recipeFoodsList23.add("Cà chua"); recipeFoodIDsList23.add(79);
        recipeFoodsList23.add("Hành lá"); recipeFoodIDsList23.add(89);
        recipeFoodsList23.add("Nước dùng từ thịt/cá"); recipeFoodIDsList23.add(124);
        recipeFoodsList23.add("Cua"); recipeFoodIDsList23.add(147);
        recipeFoodsList24.add("Khoai tây"); recipeFoodIDsList24.add(15);
        recipeFoodsList24.add("Xương "); recipeFoodIDsList24.add(36);
        recipeFoodsList24.add("Hành lá"); recipeFoodIDsList24.add(89);
        recipeFoodsList24.add("Nước dùng từ thịt/cá"); recipeFoodIDsList24.add(124);
        recipeFoodsList25.add("Hành lá"); recipeFoodIDsList25.add(89);
        recipeFoodsList25.add("Măng"); recipeFoodIDsList25.add(80);
        recipeFoodsList25.add("Nước dùng từ thịt/cá"); recipeFoodIDsList25.add(124);
        recipeFoodsList25.add("Thịt vịt"); recipeFoodIDsList25.add(248);
        recipeFoodsList26.add("Khác"); recipeFoodIDsList26.add(2);
        recipeFoodsList26.add("Ngao"); recipeFoodIDsList26.add(60);
        recipeFoodsList26.add("Cà chua"); recipeFoodIDsList26.add(79);
        recipeFoodsList26.add("Hành lá "); recipeFoodIDsList26.add(89);
        recipeFoodsList26.add("Nước dùng từ thịt/cá"); recipeFoodIDsList26.add(124);
        recipeFoodsList27.add("Rau muống"); recipeFoodIDsList27.add(73);
        recipeFoodsList27.add("Tỏi"); recipeFoodIDsList27.add(249);
        recipeFoodsList28.add("Rau ngót"); recipeFoodIDsList28.add(83);
        recipeFoodsList28.add("Nước dùng từ thịt/cá"); recipeFoodIDsList28.add(124);
        recipeFoodsList28.add("Thịt lợn"); recipeFoodIDsList28.add(245);

        recipeFoodsList29.add("Bưởi"); recipeFoodIDsList29.add(95);
        recipeFoodsList30.add("Cam"); recipeFoodIDsList30.add(91);
        recipeFoodsList31.add("Dưa hấu"); recipeFoodIDsList31.add(93);
        recipeFoodsList32.add("Thanh long"); recipeFoodIDsList32.add(169);
        recipeFoodsList33.add("Quít"); recipeFoodIDsList33.add(235);
        recipeFoodsList34.add("Táo tây"); recipeFoodIDsList34.add(96);

        recipeFoodsList35.add("Chè đỗ xanh"); recipeFoodIDsList35.add(142);
        recipeFoodsList36.add("Chè hạt sen"); recipeFoodIDsList36.add(217);
        recipeFoodsList37.add("Chè thập cẩm"); recipeFoodIDsList37.add(105);
        recipeFoodsList38.add("Kem"); recipeFoodIDsList38.add(107);
        recipeFoodsList39.add("Kem"); recipeFoodIDsList39.add(107);
        recipeFoodsList40.add("Nước mía đá"); recipeFoodIDsList40.add(232);

        recipeFoodsList41.add("Bánh tráng trộn"); recipeFoodIDsList41.add(117);
        recipeFoodsList42.add("Bánh khoai"); recipeFoodIDsList42.add(192);
        recipeFoodsList43.add("Sữa chua đánh đá"); recipeFoodIDsList43.add(237);





        //Populate list of list of food ids
        vietnam_foods_list_of_lists.add(recipeFoodsList1);    vietnam_foods_list_of_lists.add(recipeFoodsList2);
        vietnam_foods_list_of_lists.add(recipeFoodsList3);    vietnam_foods_list_of_lists.add(recipeFoodsList4);
        vietnam_foods_list_of_lists.add(recipeFoodsList5);    vietnam_foods_list_of_lists.add(recipeFoodsList6);
        vietnam_foods_list_of_lists.add(recipeFoodsList7);    vietnam_foods_list_of_lists.add(recipeFoodsList8);
        vietnam_foods_list_of_lists.add(recipeFoodsList9);    vietnam_foods_list_of_lists.add(recipeFoodsList10);
        vietnam_foods_list_of_lists.add(recipeFoodsList11);    vietnam_foods_list_of_lists.add(recipeFoodsList12);
        vietnam_foods_list_of_lists.add(recipeFoodsList13);    vietnam_foods_list_of_lists.add(recipeFoodsList14);
        vietnam_foods_list_of_lists.add(recipeFoodsList15);    vietnam_foods_list_of_lists.add(recipeFoodsList16);
        vietnam_foods_list_of_lists.add(recipeFoodsList17);    vietnam_foods_list_of_lists.add(recipeFoodsList18);
        vietnam_foods_list_of_lists.add(recipeFoodsList19);    vietnam_foods_list_of_lists.add(recipeFoodsList20);
        vietnam_foods_list_of_lists.add(recipeFoodsList21);    vietnam_foods_list_of_lists.add(recipeFoodsList22);
        vietnam_foods_list_of_lists.add(recipeFoodsList23);    vietnam_foods_list_of_lists.add(recipeFoodsList24);
        vietnam_foods_list_of_lists.add(recipeFoodsList25);    vietnam_foods_list_of_lists.add(recipeFoodsList26);
        vietnam_foods_list_of_lists.add(recipeFoodsList27);    vietnam_foods_list_of_lists.add(recipeFoodsList28);
        vietnam_foods_list_of_lists.add(recipeFoodsList29);    vietnam_foods_list_of_lists.add(recipeFoodsList30);
        vietnam_foods_list_of_lists.add(recipeFoodsList31);    vietnam_foods_list_of_lists.add(recipeFoodsList32);
        vietnam_foods_list_of_lists.add(recipeFoodsList33);    vietnam_foods_list_of_lists.add(recipeFoodsList34);
        vietnam_foods_list_of_lists.add(recipeFoodsList35);    vietnam_foods_list_of_lists.add(recipeFoodsList36);
        vietnam_foods_list_of_lists.add(recipeFoodsList37);    vietnam_foods_list_of_lists.add(recipeFoodsList38);
        vietnam_foods_list_of_lists.add(recipeFoodsList39);    vietnam_foods_list_of_lists.add(recipeFoodsList40);
        vietnam_foods_list_of_lists.add(recipeFoodsList41);    vietnam_foods_list_of_lists.add(recipeFoodsList42);
        vietnam_foods_list_of_lists.add(recipeFoodsList43);




        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList1);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList2);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList3);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList4);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList5);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList6);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList7);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList8);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList9);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList10);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList11);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList12);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList13);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList14);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList15);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList16);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList17);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList18);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList19);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList20);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList21);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList22);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList23);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList24);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList25);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList26);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList27);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList28);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList29);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList30);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList31);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList32);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList33);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList34);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList35);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList36);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList37);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList38);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList39);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList40);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList41);    vietnam_food_ids_list_of_lists.add(recipeFoodIDsList42);
        vietnam_food_ids_list_of_lists.add(recipeFoodIDsList43);


        //carbs
        recipeList.add("250");
        recipeList.add("214");
        recipeList.add("215");
        recipeList.add("11");
        recipeList.add("12");
        recipeList.add("14");
        recipeList.add("17");
        recipeList.add("21");
        recipeList.add("22");
        recipeList.add("245");

        //protein
        recipeList.add("34");
        recipeList.add("36");
        recipeList.add("62");
        recipeList.add("69");
        recipeList.add("70");
        recipeList.add("84");

        //vegetables
        recipeList.add("228");
        recipeList.add("109");
        recipeList.add("244");
        recipeList.add("114");
        recipeList.add("119");
        recipeList.add("120");
        recipeList.add("125");
        recipeList.add("136");
        recipeList.add("235");
        recipeList.add("144");
        recipeList.add("155");
        recipeList.add("159");

        // fruit

        recipeList.add("176");
        recipeList.add("177");
        recipeList.add("183");
        recipeList.add("185");
        recipeList.add("186");
        recipeList.add("187");

        // snack
        recipeList.add("190");
        recipeList.add("191");
        recipeList.add("194");

        // liquid

        recipeList.add("201");
        recipeList.add("202");
        recipeList.add("207");
        recipeList.add("208");
        recipeList.add("209");
        recipeList.add("211");


        for (int i = 0;i<recipeCodeList.size();i++) {
            // add recipe names to recipeNameList based on recipe codes in recipe code list
            String recipeCode = recipeCodeList.get(i);
            int recipeCodeIdx = recipeList.indexOf(recipeCode);
            String recipeName = recipe_list.get(recipeCodeIdx);
            recipeNameList.add(recipeName);
        }
        /*
        filename = "";
        for (int i = 0; i < recipeCodeList.size();i++) {
            //recipe_idx = recipe_list.indexOf(recipeName);
            filename = filename + recipeCodeList.get(i) + "-" + portion_id_list.get(i) + "-";
            int n = recipeList.indexOf(recipeCodeList.get(i));
            ArrayList<Integer> foodsToAdd = vietnam_food_ids_list_of_lists.get(n);
            Collections.sort(foodsToAdd);
            for (int j = 0;j<foodsToAdd.size();j++){
                // add food id's for this recipe to the filename
                if (j < foodsToAdd.size()-1) {
                    filename = filename + foodsToAdd.get(j).toString() + '-';
                } else {
                    filename = filename + foodsToAdd.get(j).toString() + '_';
                }
            }
        }

         */


        final ListView listview = (ListView) findViewById(R.id.listview);
        final CaptureImageUploadSamePortionsImFmActivity.StableArrayAdapter adapter = new CaptureImageUploadSamePortionsImFmActivity.StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, recipeNameList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int recipeIDX;
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(1000).alpha(10)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                // loop through recipe list to find the index for the selected recipe, so we can use that to find which foods to remove from the portion-food list
                                for (int i = 0; i < recipe_list.size(); i++) {
                                    String recipeName = recipe_list.get(i);
                                    String recipeToRemove = recipeNameList.get(position);

                                    if (recipeName.equals(recipeToRemove)) {
                                        recipeIDX = recipe_list.indexOf(recipeName);
                                        //System.out.println("                                                                   FOUND " + recipeName + " is at index " + recipeIDX + " in recipe_list" );
                                    }
                                }
                                //System.out.println("                 Here are the foods in the list CURRENTLY");
                                for (int i = 0; i < food_list.size();i++){
                                    String foodName = food_list.get(i);
                                    //System.out.println("                                                                   " + foodName + " is in the list" );
                                }

                                ArrayList<String> foodsToRemove = vietnam_foods_list_of_lists.get(recipeIDX);

                                if (FROM_ACTIVITY.equals("CAPTURE")) {
                                    // loop through foods list to find first food in list of foods to remove
                                    //System.out.println("                                         Looking for " + foodsToRemove.get(0) + " in list of " + food_list.size() + " foods");
                                    for (int i = 0; i < foodsToRemove.size(); i++) {
                                        //System.out.println("                                  food list item " + i + " = " + food_list.get(i));
                                        try {
                                            if (foodsToRemove.get(0).equals(food_list.get(i))) {
                                                //System.out.println("                                    FOUND " + foodsToRemove.get(0) + " Portion size for this food is " + portion_list.get(i) + " at position " + i + " out of " + portion_list.size() + " portions");
                                                for (int j = 0; j < foodsToRemove.size(); j++) {
                                                    // remove all portions associated with the foods in this recipe
                                                    if (i < portion_list.size() - 1 || portion_list.size() <= 2) {
                                                        //System.out.println("Removing portion size " + portion_list.get(i) + " from index " + i + " of the portion list with length " + portion_list.size());
                                                        portion_list.remove(i);
                                                        portion_id_list.remove(i);
                                                    } else {
                                                        //System.out.println("Removing portion size " + portion_list.get(i-1) + " from index " + (i-1) + " of the portion list with length " + portion_list.size());
                                                        portion_list.remove(i - 1);
                                                        portion_id_list.remove(i - 1);
                                                    }
                                                }
                                            }
                                        } catch (Exception e ) {
                                            Toast.makeText(EditRecipeListActivity.this,"Error", Toast.LENGTH_SHORT).show();
                                            backToUploadCapture(view, filename);
                                        }

                                    }

                                    //System.out.println("                                            Portion Sizes list:");
                                    for (int i = 0; i < portion_list.size();i++ ){
                                        System.out.println("                                                              " + portion_list.get(i));
                                    }
                                }
                                //System.out.println("                 Here are the foods to be REMOVED");
                                for (int i = 0; i<foodsToRemove.size();i++){
                                    String foodNameToRemove = foodsToRemove.get(i);
                                    food_list.remove(foodNameToRemove);
                                    /*
                                    String portionSize = portion_list.get(i);
                                    if(portionSize.equals("0")) {
                                        portion_list.remove(portionSize);
                                    }
                                    */

                                    //System.out.println("                                                                   _" + foodNameToRemove + "_ will be removed" );
                                }
                                //System.out.println("                 Here is the UPDATED LIST");
                                for (int i = 0; i < food_list.size();i++){
                                    String foodName = food_list.get(i);
                                    //System.out.println("                                                                   _" + foodName + "_ is in the list" );
                                }

                                startDialog(item, adapter, view, position, food_list);
                            }
                        });
            }
        });
    }

    public void backToUploadCapture(View view, String filename) {
        Intent intent;
        if (FROM_ACTIVITY.equals("CAPTURE_SAME_PORTIONS") ) {
            intent = new Intent(this, CaptureImageUploadSamePortionsImFmActivity.class);
        } else {
            intent = new Intent(this, CaptureImageUploadImFmActivity.class);
        }
        intent.putExtra("food_list", food_list);
        intent.putExtra("food_id_list", food_id_list);
        intent.putExtra("portion_list", portion_list);
        intent.putExtra("portion_id_list", portion_id_list);
        intent.putExtra("picType", picType);
        intent.putExtra("userID", userID);
        intent.putExtra("portion_size", portionSize);
        intent.putExtra("portion_id", portionID);
        intent.putExtra("FROM_ACTIVITY", "EDIT_RECIPE");
        intent.putExtra("dishType",dishType);
        intent.putExtra("recipeCodeList", recipeCodeList);
        intent.putExtra("filename",filename);
        startActivity(intent);
    }


    private void startDialog(final String item, final CaptureImageUploadSamePortionsImFmActivity.StableArrayAdapter adapter, final View view , final int position, final ArrayList<String> food_list ) {
        final AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                this);
        myAlertDialog.setTitle("Would you like to remove this recipe?");

        myAlertDialog.setPositiveButton("Delete recipe",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        System.out.println("Filename in Edit Recipe BEFORE update: " + filename);

                        String recipePacket;
                        for (int i = 0;i<recipeNameList.size();i++){
                            recipePacket = recipeCodeList.get(i);
                            //filename = filename.replace(recipePacket,"");
                            int a = item.indexOf(" "); // check where first space occurs
                            String s1 = item.substring (a+1);
                            int b = recipeNameList.get(i).indexOf(" ");
                            String recipeName = recipeNameList.get(i).substring(b+1);
                            //int idx = recipe_list.indexOf(s1);
                            if (s1.equals(recipeName)) {
                                int n = 0;
                                String tmp;
                                for (n = 0; n + 2 < filename.length(); n++) {

                                    tmp = "";
                                    tmp = tmp + Character.toString(filename.charAt(n));
                                    tmp = tmp + Character.toString(filename.charAt(n + 1));
                                    tmp = tmp + Character.toString(filename.charAt(n + 2));
                                    if (tmp.equals(recipePacket)) {
                                        for (int m = n; m < filename.length(); m++) {
                                            if (!Character.toString(filename.charAt(m)).equals("_")) {
                                                StringBuilder sb = new StringBuilder(filename);
                                                sb.deleteCharAt(m);
                                                filename = sb.toString();
                                            } else {
                                                StringBuilder sb = new StringBuilder(filename);
                                                sb.deleteCharAt(m);
                                                filename = sb.toString();
                                                break;
                                            }
                                            m = m - 1;
                                        }
                                    }
                                }
                            }
                        }



                        System.out.println("Filename in Edit Recipe AFTER update: " + filename);

                        recipeNameList.remove(position);
                        recipeCodeList.remove(position);
                        adapter.notifyDataSetChanged();
                        //adapter.remove(adapter.getItem(position));
                        //view.setAlpha(1);
                    }
                });

        myAlertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
        myAlertDialog.show();
    }
}