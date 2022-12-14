package dependency.plantvillage.com.cheeses3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExpandableListDataPump {
    public static Map<String, List<String>> getData() {
        Map<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> cereals= new ArrayList<String>();
        List<String> roots_tubers= new ArrayList<String>();
        List<String> vit_a_vegetable = new ArrayList<String>();
        List<String> green_vegetable = new ArrayList<String>();
        List<String> other_vegetable = new ArrayList<String>();
        List<String> vit_a_fruit = new ArrayList<String>();
        List<String> other_fruit = new ArrayList<>();
        List<String> organ_meat = new ArrayList<>();
        List<String> flesh_meat = new ArrayList<>();
        List<String> eggs = new ArrayList<>();
        List<String> fish = new ArrayList<>();
        List<String> legumes_nuts_seeds = new ArrayList<>();
        List<String> sweets = new ArrayList<>();
        List<String> spices_cond_bev = new ArrayList<>();

        cereals.add("BIRIYANI, CHICKEN");
        cereals.add("BREAD, WHITE");
        cereals.add("BUN, CURRANT");
        cereals.add("BUN, FISH");
        cereals.add("BUN, JAM");
        cereals.add("BUN, SEENI");
        cereals.add("BUN, SEENI SAMBOL");
        cereals.add("BURGER, CHICKEN, WITH BUN");
        cereals.add("CHINESE ROLLS, FISH");
        cereals.add("CORN, BOILED");
        cereals.add("CUP CAKE, ICED");
        cereals.add("CUTLET, FISH");
        cereals.add("DONUT");
        cereals.add("FRIED RICE, CHICKEN");
        cereals.add("HOPPERS");
        cereals.add("HOPPERS, EGG");
        cereals.add("HOPPERS, HONEY");
        cereals.add("KOTTU, CHICKEN");
        cereals.add("MACARONI, MIXED WITH VEGETABLES");
        cereals.add("MILK RICE");
        cereals.add("NOODLES, ADDED WITH VEGETABLES");
        cereals.add("NOODLES, PLAIN, BOILED");
        cereals.add("PARATA");
        cereals.add("PASTA, MIXED WITH VEGETABLE");
        cereals.add("PASTRY, VEGETABLE");
        cereals.add("PATTIS, VEGETABLE");
        cereals.add("PITTU, W/ RICE FLOUR");
        cereals.add("PIZZA, WITH CHICKEN TOPPING");
        cereals.add("POPCORN, SALTED");
        cereals.add("RICE, RED, SAMBA, BOILED");
        cereals.add("RICE, WHITE, SAMBA, BOILED");
        cereals.add("ROTI, COCONUT");
        cereals.add("ROTI, EGG");
        cereals.add("ROTI, VEGETABLE");
        cereals.add("SAMAPOSHA/THRIPOSHA, PORRIDGE");
        cereals.add("SAMOSA, VEGETABLE");
        cereals.add("SANDWICH, VEGETABLE");
        cereals.add("STRING HOPPERS, W/ RICE FLOUR");
        cereals.add("THALAPA");
        cereals.add("VIYANA ROLLS");

        roots_tubers.add("CASSAVA, BOILED");
        roots_tubers.add("CASSAVA, CURRY W/ COCONUT MILK");
        roots_tubers.add("FRENCH FRIES");
        roots_tubers.add("POTATO AND BEANS, CURRY W/ COCONUT MILK");
        roots_tubers.add("POTATO AND CAPSICUM, CURRY W/ COCONUT MILK");
        roots_tubers.add("POTATO AND DRIED FISH, CURRY W/ COCONUT MILK");
        roots_tubers.add("POTATO, CURRY W/ COCONUT MILK");
        roots_tubers.add("POTATO, TEMPERED");
        roots_tubers.add("SWEET POTATO, BOILED");

        vit_a_vegetable.add("CARROT AND BEANS, BOILED");
        vit_a_vegetable.add("CARROT AND POTATO, CURRY W/ COCONUT MILK");
        vit_a_vegetable.add("CARROT, CURRY W/ COCONUT MILK");
        vit_a_vegetable.add("CARROT, SALAD W/ TOMATO");
        vit_a_vegetable.add("CARROT, SALAD W/SCRAPED COCONUT");
        vit_a_vegetable.add("PUMPKIN, CURRY W/ COCONUT MILK");
        vit_a_vegetable.add("RADDISH, CURRY W/ COCONUT MILK");
        vit_a_vegetable.add("SWEET POTATO, CURRY W/ COCONUT MILK");

        green_vegetable.add("AMARANTHUS LEAVES (THAMPALA), MALLUM, TEMPERED");
        green_vegetable.add("CABBAGE LEAVES, MALLUM, TEMPERED");
        green_vegetable.add("CABBAGE LEAVES, TEMPERED");
        green_vegetable.add("DRUMSTICK LEAVES, MALLUM, TEMPERED");
        green_vegetable.add("GOTUKOLA, SALAD, RAW");
        green_vegetable.add("GREEN LEAFY VEGETABLE PORRIDGE (KOLA KENDA)");
        green_vegetable.add("KANKUN, TEMPERED");
        green_vegetable.add("KATHURUMURUNGA (AGATI), MALLUM, TEMPERED");
        green_vegetable.add("KATHURUMURUNGA, MALLUM, TEMPERED");
        green_vegetable.add("LEEKS, TEMPERED");
        green_vegetable.add("MUKUNUWENNA, MALLUM, TEMPERED");
        green_vegetable.add("ONION LEAVES, TEMPERED");
        green_vegetable.add("SPINACH, CURRY W/ COCONUT MILK");

        other_vegetable.add("AMBARELLA, CURRY W/COCONUT MILK");
        other_vegetable.add("ASH PLANTAIN, DEEP FRIED");
        other_vegetable.add("ASH PUMPKING, CURRY W/COCONUT MILK");
        other_vegetable.add("ASHPLANTAIN, CURRY W/COCONUT MILK");
        other_vegetable.add("BEET ROOT, CURRY W/ COCONUT MILK");
        other_vegetable.add("BEET ROOT, TEMPERED");
        other_vegetable.add("BELL PEPPER, GREEN, RAW");
        other_vegetable.add("BITTER GOURD, CURRY W/ COCONUT MILK");
        other_vegetable.add("BITTER GOURD, DEEP FRIED, SALAD");
        other_vegetable.add("BITTER GOURD, TEMPERED");
        other_vegetable.add("BREAD FRUIT, BOILED");
        other_vegetable.add("BREAD FRUIT, CURRY W/ COCONUT MILK");
        other_vegetable.add("BRINJAL AND DRIED FISH, TEMPERED");
        other_vegetable.add("BRINJAL, CURRY W/ COCONUT MILK");
        other_vegetable.add("BRINJAL, MOJU");
        other_vegetable.add("BRINJAL, TEMPERED");
        other_vegetable.add("CABBAGE, CURRY W/ COCONUT MILK");
        other_vegetable.add("CAPSICUM, CURRY W/ COCONUT MILK");
        other_vegetable.add("CAPSICUM, TEMPERED");
        other_vegetable.add("CAULI FLOWER, CURRY W/COCONUT MILK");
        other_vegetable.add("CUCUMBER, CURRY W/ COCONUT MILK");
        other_vegetable.add("CUCUMBER, SALAD W/ TOMATO");
        other_vegetable.add("DRUMSTICK, CURRY W/ COCONUT MILK");
        other_vegetable.add("GREEN EGG PLANT, TEMPERED");
        other_vegetable.add("GREEN EGGPLANT, CURRY W/ COCONUT MILK");
        other_vegetable.add("GREEN SALAD, RAW");
        other_vegetable.add("JACK, BOILED");
        other_vegetable.add("JACK, MALLUM");
        other_vegetable.add("JACKFRUIT, CURRY W/ COCONUT MILK, TEMPERED");
        other_vegetable.add("LADIES FINGERS, CURRY W/ COCONUT MILK");
        other_vegetable.add("LADIES FINGERS, TEMPERED");
        other_vegetable.add("LASIA STEM, CURRY W/COCONUT MILK");
        other_vegetable.add("LEEKS, CURRY W/ COCONUT MILK");
        other_vegetable.add("LONG BEANS, CURRY W/ COCONUT MILK");
        other_vegetable.add("LONG BEANS, TEMPERED");
        other_vegetable.add("LUNU MIRIS (CHILI SAMBOL)");
        other_vegetable.add("MANGO, CURRY W/COCONUT MILK");
        other_vegetable.add("MUSHROOM, CURRY W/ COCONUT MILK");
        other_vegetable.add("MUSHROOM, DEEP FRIED (BATTER FRIED)");
        other_vegetable.add("MUSHROOM, TEMPERED");
        other_vegetable.add("ONION, SAMBOL, TEMPERED");
        other_vegetable.add("PLANTAIN FLOWER, CURRY W/ COCONUT MILK");
        other_vegetable.add("PLANTAIN STEM, CURRY W/ COCONUT MILK");
        other_vegetable.add("RIDGE GOURD, CURRY W/ COCONUT MILK");
        other_vegetable.add("SAAMBAR");
        other_vegetable.add("SALAD LEAVES, RAW");
        other_vegetable.add("SNAKE GOURD, CURRY W/ COCONUT MILK");
        other_vegetable.add("SPINY GOURD, CURRY W/COCONUT MILK");
        other_vegetable.add("TENDER JACK FRUIT (POLOS), CURRY W/ COCONUT MILK");
        other_vegetable.add("TENDER JACKFRUIT (POLOS), MALLUM");
        other_vegetable.add("TURKEY BERRY, MALLUM, TEMPERED");
        other_vegetable.add("WINGED BEANS, CURRY W/ COCONUT MILK");
        other_vegetable.add("WINGED BEANS, TEMPERED");

        vit_a_fruit.add("MANGO, KARTHAKOLOMBAN, RAW");
        vit_a_fruit.add("MANGO, RIPE, RAW");
        vit_a_fruit.add("ORANGES");
        vit_a_fruit.add("PAPAYA, RIPE");
        vit_a_fruit.add("PASSION FRUIT, RAW");
        vit_a_fruit.add("PINEAPPLE, RAW");
        vit_a_fruit.add("STAR FRUIT, RAW");

        other_fruit.add("AMBARELLA, RAW");
        other_fruit.add("APPLE, BIG, RAW");
        other_fruit.add("AVACADO");
        other_fruit.add("BANANA, AMBUL, RAW");
        other_fruit.add("BANANA, ANAMALU, RAW");
        other_fruit.add("BANANA, CAVENDISH, RAW");
        other_fruit.add("CEYLON OLIVES, RAW");
        other_fruit.add("CUSTARD APPLE, RAW");
        other_fruit.add("DATES, DRY, PALE BROWN, RAW");
        other_fruit.add("GOOSEBERRY, RAW");
        other_fruit.add("GRAPES, SEEDED, ROUND, BLACK, RAW");
        other_fruit.add("GUAVA, LARGE (KILO PERA), RAW");
        other_fruit.add("GUAVA, RAW");
        other_fruit.add("JACK FRUIT, RIPE, RAW");
        other_fruit.add("MANGOSTEEN, RAW");
        other_fruit.add("POMEGRANATE, RAW");
        other_fruit.add("POMELO, RAW");
        other_fruit.add("RAMBUTAN, RAW");
        other_fruit.add("WATER MELON, DARK GREEN, RAW");
        other_fruit.add("WOODAPPLE, RAW");

        organ_meat.add("HAM, ADDED WITH ONION, TEMPERED");
        organ_meat.add("MEATBALLS, ADDED WITH ONION, TEMPERED");
        organ_meat.add("MEATBALLS, CURRY W/COCONUT MILK");
        organ_meat.add("SAUSAGES, ADDED WITH ONION, TEMPERED");
        organ_meat.add("SAUSAGES, STIR FRIED");

        flesh_meat.add("BEEF, CURRY W/O COCONUT MILK");
        flesh_meat.add("BEEF, STIR FRIED");
        flesh_meat.add("CHICKEN, CURRY W/ COCONUT MILK");
        flesh_meat.add("CHICKEN, CURRY W/O COCONUT MILK");
        flesh_meat.add("CHICKEN, DEEP FRIED");
        flesh_meat.add("CHICKEN, TEMPERED");
        flesh_meat.add("PORK, CURRY W/O COCONUT MILK");
        flesh_meat.add("PORK, STIR FRIED");

        eggs.add("EGG, POULTRY, OMLET");
        eggs.add("EGG, POULTRY, WHOLE, BOILED");
        eggs.add("EGG, WHOLE, BOILED & TEMPERED, W/ COCONUT MILK");

        fish.add("CANNED FISH, CURRY W/ COCONUT MILK, TEMPERED");
        fish.add("CUTTLE FISH, ADDED WITH ONION, TEMPERED");
        fish.add("CUTTLE FISH, CURRY W/ COCONUT MILK");
        fish.add("CUTTLE FISH, CURRY W/COCONUT MILK");
        fish.add("DRIED SKIPJACK TUNA (BALAYA) AND LEEKS, TEMPERED");
        fish.add("HURULLA, ADDED WITH ONION, TEMPERED");
        fish.add("HURULLA, CURRY W/COCONUT MILK, TEMPERED");
        fish.add("MACKEREL, ADDED WITH ONION, TEMPERED");
        fish.add("MACKEREL, CURRY W/ COCONUT MILK, TEMPERED");
        fish.add("PRAWNS, ADDED WITH ONION, TEMPERED");
        fish.add("PRAWNS, CURRY W/ COCONUT MILK, TEMPERED");
        fish.add("SAIL FISH (THALAPATH), DEEP FRIED");
        fish.add("SALAYA, ADDED WITH ONION, TEMPERED");
        fish.add("SALAYA, CURRY W/ COCONUT MILK, TEMPERED");
        fish.add("SALAYA, DRIED, CURRY W/ COCONUT MILK, TEMPERED");
        fish.add("SKIPJACK TUNA (BALAYA), DRIED, CURRY W/ COCONUT MILK");
        fish.add("SKIPJACK TUNA (BALAYA), DRIED, DEEP FRIED");
        fish.add("SKIPJACK TUNA (BALAYA), DRIED, DEEP FRIED");
        fish.add("SMOOTHBELLY SARDINELLA (KEERAMIN), DRIED, DEEP FRIED");
        fish.add("SPRATS, DRIED, ADDED WITH ONION, TEMPERED");
        fish.add("SPRATS, DRIED, CURRY, W/ COCONUT MILK");
        fish.add("SPRATS, DRIED, DEEP FRIED");
        fish.add("SPRATS, FRESH, CURRY W/COCONUT MILK, TEMPERED");
        fish.add("THILAPIA, CURRY W/ COCONUT MILK");
        fish.add("THILAPIA, DEEP FRIED");
        fish.add("TUNA (KELAWALLA), CURRY W/O COCONUT MILK");
        fish.add("TUNA (KELAWALLA), DEEP FRIED");

        legumes_nuts_seeds.add("BEANS, CURRY W/COCONUT MILK");
        legumes_nuts_seeds.add("BEANS, TEMPERED");
        legumes_nuts_seeds.add("BENGAL GRAM, CURRY W/COCONUT MILK");
        legumes_nuts_seeds.add("CASHEW NUT, ROASTED");
        legumes_nuts_seeds.add("CASHEW, CURRY W/COCONUT MILK");
        legumes_nuts_seeds.add("CHICKPEA, BOILED");
        legumes_nuts_seeds.add("CHICKPEA, BOILED AND TEMPERED");
        legumes_nuts_seeds.add("CHICKPEA, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("COCONUT SAMBOL");
        legumes_nuts_seeds.add("COCONUT SCRAPING, FRESH");
        legumes_nuts_seeds.add("COCONUT WATER");
        legumes_nuts_seeds.add("COWPEA, BOILED");
        legumes_nuts_seeds.add("COWPEA, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("COWPEA, CURRY W/ COCONUT MILK, TEMPERED");
        legumes_nuts_seeds.add("DHAL AND DRIED FISH, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("DHAL AND SPINACH, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("DHAL, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("DOSA/THOSE");
        legumes_nuts_seeds.add("GREEN GRAM, BOILED");
        legumes_nuts_seeds.add("GREEN GRAM, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("GREEN GRAM, CURRY W/ COCONUT MILK, TEMPERED");
        legumes_nuts_seeds.add("IDLI");
        legumes_nuts_seeds.add("JACK SEEDS, CURRY W/COCONUT MILK");
        legumes_nuts_seeds.add("KIRI HODI");
        legumes_nuts_seeds.add("PAPADUM, FRIED");
        legumes_nuts_seeds.add("PEANUTS, DRY, ROASTED");
        legumes_nuts_seeds.add("SOYA MEAT AND POTATO, CURRY W/ COCONUT MILK, TEMPERED");
        legumes_nuts_seeds.add("SOYA MEAT, CURRY W/ COCONUT MILK");
        legumes_nuts_seeds.add("SOYA MEAT, TEMPERED");
        legumes_nuts_seeds.add("UPPUMA");
        legumes_nuts_seeds.add("WADE, DHAL");
        legumes_nuts_seeds.add("WADE, ULUNDU");

        sweets.add("CAKE, CHOCOLATE");
        sweets.add("CAKE, CHOCOLATE, ICING");
        sweets.add("CAKE, FRUIT");
        sweets.add("CAKE, SPONGE");
        sweets.add("LAWARIYA");
        sweets.add("WATALAPPAN");

        spices_cond_bev.add("CHILI PASTE");
        spices_cond_bev.add("CHUTNEY, MANGO");

        expandableListDetail.put("Cereals", cereals);
        expandableListDetail.put("White roots and tubers", roots_tubers);
        expandableListDetail.put("Vitamin A rich vegetables and tubers", vit_a_vegetable);
        expandableListDetail.put("Dark green leafy vegetables", green_vegetable);
        expandableListDetail.put("Other vegetables", other_vegetable);
        expandableListDetail.put("Vitamin A rich fruits", vit_a_fruit);
        expandableListDetail.put("Other fruits", other_fruit);
        expandableListDetail.put("Organ meat", organ_meat);
        expandableListDetail.put("Flesh meat", flesh_meat);
        expandableListDetail.put("Eggs", eggs);
        expandableListDetail.put("Fish and sea food", fish);
        expandableListDetail.put("Legumes, nuts and seeds", legumes_nuts_seeds);
        expandableListDetail.put("Sweets", sweets);
        expandableListDetail.put("Spices, condiments, beverages", spices_cond_bev);




        return expandableListDetail;
    }
}