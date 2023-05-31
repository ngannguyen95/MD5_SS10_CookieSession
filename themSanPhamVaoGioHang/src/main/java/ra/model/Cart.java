package ra.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProduct(){
        return products;
    }
 // check xem sản phẩm có trong giỏ hàng chưa
   private boolean checkItemInCart(Product product){
       for (Map.Entry<Product,Integer> entry: products.entrySet()) {
           if (entry.getKey().getId().equals(product.getId())){
               return true;
           }
       }
       return false;
   }
   // tìm ra sản phẩm có trong giỏ hàng
   private Map.Entry<Product,Integer> selectItemInCart(Product product){
       for (Map.Entry<Product,Integer> entry : products.entrySet()) {
           if (entry.getKey().getId().equals(product.getId())){
               return entry;
           }
       }
       return null;
   }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }


   public void removeProduct(Product product){
//        if (!checkItemInCart(product)){
//            products.put(product,1);
//        }else {
            Map.Entry<Product,Integer> itemEntry=selectItemInCart(product);
            Integer newQuantity= itemEntry.getValue()-1;
            if (itemEntry.getValue()==0){
                newQuantity=0;
            }
            products.replace(itemEntry.getKey(),newQuantity);
//        }
   }
   public Integer countProductQuantity(){
        Integer productQuantity = 0;
       for (Map.Entry<Product,Integer> entry: products.entrySet()) {
           productQuantity += entry.getValue();
       }
       return productQuantity;
   }
   public Integer countItemQuantity(){
        return products.size();
   }
   public Float countTotalPayment(){
        float  payment = 0;
       for (Map.Entry<Product,Integer> entry: products.entrySet()) {
           payment += entry.getKey().getPrice()*(float)entry.getValue();
       }
       return payment;
   }

}
