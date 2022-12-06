package dependency.plantvillage.com.cheeses3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SelectRecipeActivity extends AppCompatActivity {
  ExpandableListView expandableListView;
  ExpandableListAdapter expandableListAdapter;
  List<String> expandableListTitle;
  Map<String, List<String>> expandableListDetail;
  String recipeName;
  String FROM_ACTIVITY;
  ArrayList<String> portion_list;
  ArrayList<Integer> portion_id_list;
  ArrayList<String> recipeCodeList = new ArrayList<>();
  ArrayList<String> recipeNameList = new ArrayList<>();

  int isSamePortions;
  int userID;
  String filename = "";

  int portionID;
  String portionSize;
  int recipe_idx;
  List<String>recipe_list = Arrays.asList
          (       // 1
                  "BIRIYANI, CHICKEN",
                  "BREAD, WHITE",
                  "BUN, CURRANT",
                  "BUN, FISH",
                  "BUN, JAM",
                  "BUN, SEENI",
                  "BUN, SEENI SAMBOL",
                  "BURGER, CHICKEN, WITH BUN",
                  "CHINESE ROLLS, FISH",
                  "CORN, BOILED",
                  "CUP CAKE, ICED",
                  "CUTLET, FISH",
                  "DONUT",
                  "FRIED RICE, CHICKEN",
                  "HOPPERS",
                  "HOPPERS, EGG",
                  "HOPPERS, HONEY",
                  "KOTTU, CHICKEN",
                  "MACARONI, MIXED WITH VEGETABLES",
                  "MILK RICE",
                  "NOODLES, ADDED WITH VEGETABLES",
                  "NOODLES, PLAIN, BOILED",
                  "PARATA",
                  "PASTA, MIXED WITH VEGETABLE",
                  "PASTRY, VEGETABLE",
                  "PATTIS, VEGETABLE",
                  "PITTU, W/ RICE FLOUR",
                  "PIZZA, WITH CHICKEN TOPPING",
                  "POPCORN, SALTED",
                  "RICE, RED, SAMBA, BOILED",
                  "RICE, WHITE, SAMBA, BOILED",
                  "ROTI, COCONUT",
                  "ROTI, EGG",
                  "ROTI, VEGETABLE",
                  "SAMAPOSHA/THRIPOSHA, PORRIDGE",
                  "SAMOSA, VEGETABLE",
                  "SANDWICH, VEGETABLE",
                  "STRING HOPPERS, W/ RICE FLOUR",
                  "THALAPA",
                  "VIYANA ROLLS",
                  // 2
                  "CASSAVA, BOILED",
                  "CASSAVA, CURRY W/ COCONUT MILK",
                  "FRENCH FRIES",
                  "POTATO AND BEANS, CURRY W/ COCONUT MILK",
                  "POTATO AND CAPSICUM, CURRY W/ COCONUT MILK",
                  "POTATO AND DRIED FISH, CURRY W/ COCONUT MILK",
                  "POTATO, CURRY W/ COCONUT MILK",
                  "POTATO, TEMPERED",
                  "SWEET POTATO, BOILED",
                  // 3
                  "CARROT AND BEANS, BOILED",
                  "CARROT AND POTATO, CURRY W/ COCONUT MILK",
                  "CARROT, CURRY W/ COCONUT MILK",
                  "CARROT, SALAD W/ TOMATO",
                  "CARROT, SALAD W/SCRAPED COCONUT",
                  "PUMPKIN, CURRY W/ COCONUT MILK",
                  "RADDISH, CURRY W/ COCONUT MILK",
                  "SWEET POTATO, CURRY W/ COCONUT MILK",
                  // 4
                  "AMARANTHUS LEAVES (THAMPALA), MALLUM, TEMPERED",
                  "CABBAGE LEAVES, MALLUM, TEMPERED",
                  "CABBAGE LEAVES, TEMPERED",
                  "DRUMSTICK LEAVES, MALLUM, TEMPERED",
                  "GOTUKOLA, SALAD, RAW",
                  "GREEN LEAFY VEGETABLE PORRIDGE (KOLA KENDA)",
                  "KANKUN, TEMPERED",
                  "KATHURUMURUNGA (AGATI), MALLUM, TEMPERED",
                  "KATHURUMURUNGA, MALLUM, TEMPERED",
                  "LEEKS, TEMPERED",
                  "MUKUNUWENNA, MALLUM, TEMPERED",
                  "ONION LEAVES, TEMPERED",
                  "SPINACH, CURRY W/ COCONUT MILK",
                  // 5
                  "AMBARELLA, CURRY W/COCONUT MILK",
                  "ASH PLANTAIN, DEEP FRIED",
                  "ASH PUMPKING, CURRY W/COCONUT MILK",
                  "ASHPLANTAIN, CURRY W/COCONUT MILK",
                  "BEET ROOT, CURRY W/ COCONUT MILK",
                  "BEET ROOT, TEMPERED",
                  "BELL PEPPER, GREEN, RAW",
                  "BITTER GOURD, CURRY W/ COCONUT MILK",
                  "BITTER GOURD, DEEP FRIED, SALAD",
                  "BITTER GOURD, TEMPERED",
                  "BREAD FRUIT, BOILED",
                  "BREAD FRUIT, CURRY W/ COCONUT MILK",
                  "BRINJAL AND DRIED FISH, TEMPERED",
                  "BRINJAL, CURRY W/ COCONUT MILK",
                  "BRINJAL, MOJU",
                  "BRINJAL, TEMPERED",
                  "CABBAGE, CURRY W/ COCONUT MILK",
                  "CAPSICUM, CURRY W/ COCONUT MILK",
                  "CAPSICUM, TEMPERED",
                  "CAULI FLOWER, CURRY W/COCONUT MILK",
                  "CUCUMBER, CURRY W/ COCONUT MILK",
                  "CUCUMBER, SALAD W/ TOMATO",
                  "DRUMSTICK, CURRY W/ COCONUT MILK",
                  "GREEN EGG PLANT, TEMPERED",
                  "GREEN EGGPLANT, CURRY W/ COCONUT MILK",
                  "GREEN SALAD, RAW",
                  "JACK, BOILED",
                  "JACK, MALLUM",
                  "JACKFRUIT, CURRY W/ COCONUT MILK, TEMPERED",
                  "LADIES FINGERS, CURRY W/ COCONUT MILK",
                  "LADIES FINGERS, TEMPERED",
                  "LASIA STEM, CURRY W/COCONUT MILK",
                  "LEEKS, CURRY W/ COCONUT MILK",
                  "LONG BEANS, CURRY W/ COCONUT MILK",
                  "LONG BEANS, TEMPERED",
                  "LUNU MIRIS (CHILI SAMBOL)",
                  "MANGO, CURRY W/COCONUT MILK",
                  "MUSHROOM, CURRY W/ COCONUT MILK",
                  "MUSHROOM, DEEP FRIED (BATTER FRIED)",
                  "MUSHROOM, TEMPERED",
                  "ONION, SAMBOL, TEMPERED",
                  "PLANTAIN FLOWER, CURRY W/ COCONUT MILK",
                  "PLANTAIN STEM, CURRY W/ COCONUT MILK",
                  "RIDGE GOURD, CURRY W/ COCONUT MILK",
                  "SAAMBAR",
                  "SALAD LEAVES, RAW",
                  "SNAKE GOURD, CURRY W/ COCONUT MILK",
                  "SPINY GOURD, CURRY W/COCONUT MILK",
                  "TENDER JACK FRUIT (POLOS), CURRY W/ COCONUT MILK",
                  "TENDER JACKFRUIT (POLOS), MALLUM",
                  "TURKEY BERRY, MALLUM, TEMPERED",
                  "WINGED BEANS, CURRY W/ COCONUT MILK",
                  "WINGED BEANS, TEMPERED",
                  // 6
                  "MANGO, KARTHAKOLOMBAN, RAW",
                  "MANGO, RIPE, RAW",
                  "ORANGES",
                  "PAPAYA, RIPE",
                  "PASSION FRUIT, RAW",
                  "PINEAPPLE, RAW",
                  "STAR FRUIT, RAW",
                  // 7
                  "AMBARELLA, RAW",
                  "APPLE, BIG, RAW",
                  "AVACADO",
                  "BANANA, AMBUL, RAW",
                  "BANANA, ANAMALU, RAW",
                  "BANANA, CAVENDISH, RAW",
                  "CEYLON OLIVES, RAW",
                  "CUSTARD APPLE, RAW",
                  "DATES, DRY, PALE BROWN, RAW",
                  "GOOSEBERRY, RAW",
                  "GRAPES, SEEDED, ROUND, BLACK, RAW",
                  "GUAVA, LARGE (KILO PERA), RAW",
                  "GUAVA, RAW",
                  "JACK FRUIT, RIPE, RAW",
                  "MANGOSTEEN, RAW",
                  "POMEGRANATE, RAW",
                  "POMELO, RAW",
                  "RAMBUTAN, RAW",
                  "WATER MELON, DARK GREEN, RAW",
                  "WOODAPPLE, RAW",
                  // 8
                  "HAM, ADDED WITH ONION, TEMPERED",
                  "MEATBALLS, ADDED WITH ONION, TEMPERED",
                  "MEATBALLS, CURRY W/COCONUT MILK",
                  "SAUSAGES, ADDED WITH ONION, TEMPERED",
                  "SAUSAGES, STIR FRIED",
                  // 9
                  "BEEF, CURRY W/O COCONUT MILK",
                  "BEEF, STIR FRIED",
                  "CHICKEN, CURRY W/ COCONUT MILK",
                  "CHICKEN, CURRY W/O COCONUT MILK",
                  "CHICKEN, DEEP FRIED",
                  "CHICKEN, TEMPERED",
                  "PORK, CURRY W/O COCONUT MILK",
                  "PORK, STIR FRIED",
                  // 10
                  "EGG, POULTRY, FRIED",
                  "EGG, POULTRY, OMLET",
                  "EGG, POULTRY, WHOLE, BOILED",
                  "EGG, WHOLE, BOILED & TEMPERED, W/ COCONUT MILK",
                  // 11
                  "CANNED FISH, CURRY W/ COCONUT MILK, TEMPERED",
                  "CUTTLE FISH, ADDED WITH ONION, TEMPERED",
                  "CUTTLE FISH, CURRY W/ COCONUT MILK",
                  "CUTTLE FISH, CURRY W/COCONUT MILK",
                  "DRIED SKIPJACK TUNA (BALAYA) AND LEEKS, TEMPERED",
                  "HURULLA, ADDED WITH ONION, TEMPERED",
                  "HURULLA, CURRY W/COCONUT MILK, TEMPERED",
                  "MACKEREL, ADDED WITH ONION, TEMPERED",
                  "MACKEREL, CURRY W/ COCONUT MILK, TEMPERED",
                  "PRAWNS, ADDED WITH ONION, TEMPERED",
                  "PRAWNS, CURRY W/ COCONUT MILK, TEMPERED",
                  "SAIL FISH (THALAPATH), DEEP FRIED",
                  "SALAYA, ADDED WITH ONION, TEMPERED",
                  "SALAYA, CURRY W/ COCONUT MILK, TEMPERED",
                  "SALAYA, DRIED, CURRY W/ COCONUT MILK, TEMPERED",
                  "SKIPJACK TUNA (BALAYA), DRIED, CURRY W/ COCONUT MILK",
                  "SKIPJACK TUNA (BALAYA), DRIED, DEEP FRIED",
                  "SKIPJACK TUNA (BALAYA), DRIED, DEEP FRIED",
                  "SMOOTHBELLY SARDINELLA (KEERAMIN), DRIED, DEEP FRIED",
                  "SPRATS, DRIED, ADDED WITH ONION, TEMPERED",
                  "SPRATS, DRIED, CURRY, W/ COCONUT MILK",
                  "SPRATS, DRIED, DEEP FRIED",
                  "SPRATS, FRESH, CURRY W/COCONUT MILK, TEMPERED",
                  "THILAPIA, CURRY W/ COCONUT MILK",
                  "THILAPIA, DEEP FRIED",
                  "TUNA (KELAWALLA), CURRY W/O COCONUT MILK",
                  "TUNA (KELAWALLA), DEEP FRIED",
                  // 12
                  "BEANS, CURRY W/COCONUT MILK",
                  "BEANS, TEMPERED",
                  "BENGAL GRAM, CURRY W/COCONUT MILK",
                  "CASHEW NUT, ROASTED",
                  "CASHEW, CURRY W/COCONUT MILK",
                  "CHICKPEA, BOILED",
                  "CHICKPEA, BOILED AND TEMPERED",
                  "CHICKPEA, CURRY W/ COCONUT MILK",
                  "COCONUT SAMBOL",
                  "COCONUT SCRAPING, FRESH",
                  "COCONUT WATER",
                  "COWPEA, BOILED",
                  "COWPEA, CURRY W/ COCONUT MILK",
                  "COWPEA, CURRY W/ COCONUT MILK, TEMPERED",
                  "DHAL AND DRIED FISH, CURRY W/ COCONUT MILK",
                  "DHAL AND SPINACH, CURRY W/ COCONUT MILK",
                  "DHAL, CURRY W/ COCONUT MILK",
                  "DOSA/THOSE",
                  "GREEN GRAM, BOILED",
                  "GREEN GRAM, CURRY W/ COCONUT MILK",
                  "GREEN GRAM, CURRY W/ COCONUT MILK, TEMPERED",
                  "IDLI",
                  "JACK SEEDS, CURRY W/COCONUT MILK",
                  "KIRI HODI",
                  "PAPADUM, FRIED",
                  "PEANUTS, DRY, ROASTED",
                  "SOYA MEAT AND POTATO, CURRY W/ COCONUT MILK, TEMPERED",
                  "SOYA MEAT, CURRY W/ COCONUT MILK",
                  "SOYA MEAT, TEMPERED",
                  "UPPUMA",
                  "WADE, DHAL",
                  "WADE, ULUNDU",
                  // 15
                  "AGGALA, RICE FLOUR",
                  "CAKE, CHOCOLATE",
                  "CAKE, CHOCOLATE, ICING",
                  "CAKE, FRUIT",
                  "CAKE, SPONGE",
                  "LAWARIYA",
                  "WATALAPPAN",
                  // 16
                  "CHILI PASTE",
                  "CHUTNEY, MANGO"
                  );




  int n = 63;
  int outerIndex;
  int numFoodsInRecipe;

  ArrayList<String> recipeList = new ArrayList<>();



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_select_recipe);
    Intent intent=getIntent();

    portion_list = intent.getStringArrayListExtra("portion_list");
    portion_id_list = intent.getIntegerArrayListExtra("portion_id_list");
    portionID = intent.getIntExtra("portion_id", 1000);
    userID = intent.getIntExtra("userID", 0);
    isSamePortions = intent.getIntExtra("isSamePortions", 0);
    recipeCodeList = intent.getStringArrayListExtra("recipeCodeList");
    recipeNameList = intent.getStringArrayListExtra("recipeNameList");
    FROM_ACTIVITY = intent.getStringExtra("FROM_ACTIVITY");

    filename = intent.getStringExtra("filename");
    if (filename == null) {
      filename = "";
    }
    if (recipeCodeList == null) {
      recipeCodeList = new ArrayList<String>();
    }

    if (recipeNameList == null) {
      recipeNameList = new ArrayList<String>();
    }
    // 1
    recipeList.add("1");
    recipeList.add("2");
    recipeList.add("3");
    recipeList.add("4");
    recipeList.add("5");
    recipeList.add("6");
    recipeList.add("7");
    recipeList.add("8");
    recipeList.add("9");
    recipeList.add("10");
    recipeList.add("11");
    recipeList.add("12");
    recipeList.add("13");
    recipeList.add("14");
    recipeList.add("15");
    recipeList.add("16");
    recipeList.add("17");
    recipeList.add("18");
    recipeList.add("19");
    recipeList.add("20");
    recipeList.add("21");
    recipeList.add("22");
    recipeList.add("23");
    recipeList.add("24");
    recipeList.add("25");
    recipeList.add("26");
    recipeList.add("27");
    recipeList.add("28");
    recipeList.add("29");
    recipeList.add("30");
    recipeList.add("31");
    recipeList.add("32");
    recipeList.add("33");
    recipeList.add("34");
    recipeList.add("35");
    recipeList.add("36");
    recipeList.add("37");
    recipeList.add("38");
    recipeList.add("39");
    recipeList.add("40");
    // 2
    recipeList.add("41");
    recipeList.add("42");
    recipeList.add("43");
    recipeList.add("44");
    recipeList.add("45");
    recipeList.add("46");
    recipeList.add("47");
    recipeList.add("48");
    recipeList.add("49");
    // 3
    recipeList.add("50");
    recipeList.add("51");
    recipeList.add("52");
    recipeList.add("53");
    recipeList.add("54");
    recipeList.add("55");
    recipeList.add("56");
    recipeList.add("57");
    // 4
    recipeList.add("58");
    recipeList.add("59");
    recipeList.add("60");
    recipeList.add("61");
    recipeList.add("62");
    recipeList.add("63");
    recipeList.add("64");
    recipeList.add("65");
    recipeList.add("66");
    recipeList.add("67");
    recipeList.add("68");
    recipeList.add("69");
    recipeList.add("70");
    // 5
    recipeList.add("71");
    recipeList.add("72");
    recipeList.add("73");
    recipeList.add("74");
    recipeList.add("75");
    recipeList.add("76");
    recipeList.add("77");
    recipeList.add("78");
    recipeList.add("79");
    recipeList.add("80");
    recipeList.add("81");
    recipeList.add("82");
    recipeList.add("83");
    recipeList.add("84");
    recipeList.add("85");
    recipeList.add("86");
    recipeList.add("87");
    recipeList.add("88");
    recipeList.add("89");
    recipeList.add("90");
    recipeList.add("91");
    recipeList.add("92");
    recipeList.add("93");
    recipeList.add("94");
    recipeList.add("95");
    recipeList.add("96");
    recipeList.add("97");
    recipeList.add("98");
    recipeList.add("99");
    recipeList.add("100");
    recipeList.add("101");
    recipeList.add("102");
    recipeList.add("103");
    recipeList.add("104");
    recipeList.add("105");
    recipeList.add("106");
    recipeList.add("107");
    recipeList.add("108");
    recipeList.add("109");
    recipeList.add("110");
    recipeList.add("111");
    recipeList.add("112");
    recipeList.add("113");
    recipeList.add("114");
    recipeList.add("115");
    recipeList.add("116");
    recipeList.add("117");
    recipeList.add("118");
    recipeList.add("119");
    recipeList.add("120");
    recipeList.add("121");
    recipeList.add("122");
    recipeList.add("123");
    // 6
    recipeList.add("124");
    recipeList.add("125");
    recipeList.add("126");
    recipeList.add("127");
    recipeList.add("128");
    recipeList.add("129");
    recipeList.add("130");
    // 7
    recipeList.add("131");
    recipeList.add("132");
    recipeList.add("133");
    recipeList.add("134");
    recipeList.add("135");
    recipeList.add("136");
    recipeList.add("137");
    recipeList.add("138");
    recipeList.add("139");
    recipeList.add("140");
    recipeList.add("141");
    recipeList.add("142");
    recipeList.add("143");
    recipeList.add("144");
    recipeList.add("145");
    recipeList.add("146");
    recipeList.add("147");
    recipeList.add("148");
    recipeList.add("149");
    recipeList.add("150");
    // 8
    recipeList.add("151");
    recipeList.add("152");
    recipeList.add("153");
    recipeList.add("154");
    recipeList.add("155");
    recipeList.add("156");
    // 9
    recipeList.add("157");
    recipeList.add("158");
    recipeList.add("159");
    recipeList.add("160");
    recipeList.add("161");
    recipeList.add("162");
    recipeList.add("163");
    // 10
    recipeList.add("164");
    recipeList.add("165");
    recipeList.add("166");
    recipeList.add("167");
    // 11
    recipeList.add("168");
    recipeList.add("169");
    recipeList.add("170");
    recipeList.add("171");
    recipeList.add("172");
    recipeList.add("173");
    recipeList.add("174");
    recipeList.add("175");
    recipeList.add("176");
    recipeList.add("177");
    recipeList.add("178");
    recipeList.add("179");
    recipeList.add("180");
    recipeList.add("181");
    recipeList.add("182");
    recipeList.add("183");
    recipeList.add("184");
    recipeList.add("185");
    recipeList.add("186");
    recipeList.add("187");
    recipeList.add("188");
    recipeList.add("189");
    recipeList.add("190");
    recipeList.add("191");
    recipeList.add("192");
    recipeList.add("193");
    recipeList.add("194");
    // 12
    recipeList.add("195");
    recipeList.add("196");
    recipeList.add("197");
    recipeList.add("198");
    recipeList.add("199");
    recipeList.add("200");
    recipeList.add("201");
    recipeList.add("202");
    recipeList.add("203");
    recipeList.add("204");
    recipeList.add("205");
    recipeList.add("206");
    recipeList.add("207");
    recipeList.add("208");
    recipeList.add("209");
    recipeList.add("210");
    recipeList.add("211");
    recipeList.add("212");
    recipeList.add("213");
    recipeList.add("214");
    recipeList.add("215");
    recipeList.add("216");
    recipeList.add("217");
    recipeList.add("218");
    recipeList.add("219");
    recipeList.add("220");
    recipeList.add("221");
    recipeList.add("222");
    recipeList.add("223");
    recipeList.add("224");
    recipeList.add("225");
    recipeList.add("226");
    // 15
    recipeList.add("227");
    recipeList.add("228");
    recipeList.add("229");
    recipeList.add("230");
    recipeList.add("231");
    recipeList.add("232");
    recipeList.add("233");
    // 16
    recipeList.add("234");
    recipeList.add("235");

    expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
    expandableListDetail = ExpandableListDataPump.getData();
    expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
    expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
    expandableListView.setAdapter(expandableListAdapter);
    expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

      @Override
      public void onGroupExpand(int groupPosition) {

      }
    });

    expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

      @Override
      public void onGroupCollapse(int groupPosition) {

      }
    });

    expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
      @Override
      public boolean onChildClick(ExpandableListView parent, View v,
                                  int groupPosition, int childPosition, long id) {
        recipeName = expandableListDetail.get(
                expandableListTitle.get(groupPosition)).get(
                childPosition);

        // find index for the foods in this recipe


        recipe_idx = recipe_list.indexOf(recipeName);
        System.out.println("Recipe name: " + recipeName + " Recipe index: " + recipe_idx);
        // add recipe code and name to their respective lists
        recipeCodeList.add(recipeList.get(recipe_idx));
        recipeNameList.add(recipeName);
        numFoodsInRecipe = numFoodsInRecipe + 1;
        // add recipe code and portionID to filename
        // if the portionID is the default. then we must be doing a same portions meal so it needs to be updated to whatever the chose portion size is
        try {
        if(portionID == 1000 && isSamePortions == 1) {
          portionID = portion_id_list.get(0);
        }
        } catch (Exception e) {
          e.printStackTrace();

        }
        filename = filename + recipeList.get(recipe_idx) + "-" + portionID + "_";

        System.out.println("\n\n\n\nfilename in recipe activity = " + filename);

        if (isSamePortions == 1 ) { // same portion so go to image capture
          selectAddFoodCapture(v, recipeName, 1);
        } else if (isSamePortions == 0) {
          selectPortionSize(v, recipeName, 0); // need to select portion size
        }


        return false;
      }
    });
  }

  public void selectPortionSize(View view, String recipeName, int isSamePortions) {

    System.out.println("RECIPE IsSamePortions = " + isSamePortions);

    Intent intent = new Intent(this, SelectPortionSizeActivity.class);

    intent.putExtra("portion_list", portion_list);
    intent.putExtra("portion_id_list", portion_id_list);
    intent.putExtra("food_name", recipeName);
    intent.putExtra("userID", userID);
    intent.putExtra("numFoodsInRecipe", numFoodsInRecipe);
    intent.putExtra("isSamePortions", isSamePortions);
    intent.putExtra("recipeCodeList", recipeCodeList);
    intent.putExtra("recipeNameList", recipeNameList);
    intent.putExtra("filename", filename);
    intent.putExtra("FROM_ACTIVITY", "SELECT_RECIPE");


    startActivity(intent);
  }

  public void selectAddFoodCapture(View view, String recipeName, int isSamePortions) {
    portion_list.add(portion_list.get(0));
    portion_id_list.add(portion_id_list.get(0));

    // update portion id in filename
    filename = filename.replace("1000",Integer.toString(portion_id_list.get(0)));

    Intent intent;
    intent = new Intent(this, CaptureImageUploadImFmActivity.class);

    intent.putExtra("portion_list", portion_list);
    intent.putExtra("portion_id_list", portion_id_list);
    intent.putExtra("recipeName", recipeName);
    intent.putExtra("userID", userID);
    intent.putExtra("portion_id", portionID);
    intent.putExtra("portion_size", portionSize);
    intent.putExtra("recipeCodeList", recipeCodeList);
    intent.putExtra("recipeNameList", recipeNameList);
    intent.putExtra("filename",filename);
    intent.putExtra("FROM_ACTIVITY", "SELECT_RECIPE");
    intent.putExtra("isSamePortions", isSamePortions);



    startActivity(intent);
  }

}
