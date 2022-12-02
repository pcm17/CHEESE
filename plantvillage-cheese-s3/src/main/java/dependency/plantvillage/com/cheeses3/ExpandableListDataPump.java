package dependency.plantvillage.com.cheeses3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExpandableListDataPump {
    public static Map<String, List<String>> getData() {
        Map<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> carb= new ArrayList<String>();
        List<String> protein= new ArrayList<String>();
        List<String> vegetable = new ArrayList<String>();
        List<String> fruit = new ArrayList<String>();
        List<String> liquid = new ArrayList<String>();
        List<String> snack = new ArrayList<String>();
        List<String> seasoning_sauce = new ArrayList<>();

        carb.add("Bánh mỳ");
        carb.add("Bún đậu mắm tôm");
        carb.add("Cơm rang trứng");
        carb.add("Miến thịt gà, miền Bắc");
        carb.add("Mỳ ăn liền nấu trứng");
        carb.add("Mỳ gạo nấu thịt lợn");
        carb.add("Phở bò xào");
        carb.add("Xôi gấc");
        carb.add("Xôi lạc miền Bắc");
        carb.add("Xôi ruốc");

        protein.add("Cá trắm cỏ kho dưa chua thịt ba chỉ");
        protein.add("Cánh gà chiên mắm");
        protein.add("Thịt chân giò lợn, luộc");
        protein.add("Thịt gà ta nướng");
        protein.add("Thịt gà ta rang");
        protein.add("Thịt lợn nửa nạc, nửa mỡ, luộc");

        vegetable.add("Cá chép om dưa");
        vegetable.add("Cải cúc nấu thịt băm");
        vegetable.add("Cải xanh luộc");
        vegetable.add("Cải xanh nấu canh");
        vegetable.add("Canh chua thịt lợn nạc");
        vegetable.add("Canh cua mướp, mồng tơi, rau đay");
        vegetable.add("Canh riêu cua");
        vegetable.add("Khoai tây ninh xương");
        vegetable.add("Măng tươi nấu vịt");
        vegetable.add("Ngao nấu chua");
        vegetable.add("Rau muống xào");
        vegetable.add("Rau ngót nấu thịt");

        fruit.add("Bưởi");
        fruit.add("Cam");
        fruit.add("Dưa hấu");
        fruit.add("Quả thanh long");
        fruit.add("Quít");
        fruit.add("Táo tây");

        liquid.add("Chè đỗ xanh");
        liquid.add("Chè hạt sen");
        liquid.add("Chè thập cẩm");
        liquid.add("Kem hộp Merino hương dâu");
        liquid.add("Kem que Merino Cacao - Sô cô la");
        liquid.add("Nước mía đá");

        snack.add("Bánh tráng trộn");
        snack.add("Khoai lang tẩm bột chiên/rán");
        snack.add("Sữa chua đánh đá");


        expandableListDetail.put("Carbohydrates", carb);
        expandableListDetail.put("Proteins (meat, fish, egg, tofu)", protein);
        expandableListDetail.put("Vegetables", vegetable);
        expandableListDetail.put("Fruits", fruit);
        expandableListDetail.put("Liquids (drinks, soups, yoghurt/ice cream", liquid);
        expandableListDetail.put("Snacks (cakes, crackers, other foods)", snack);
        expandableListDetail.put("Seasoning, Sauces", seasoning_sauce);



        return expandableListDetail;
    }
}