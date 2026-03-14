public class Transaction {
    private String transactionId;
    private Product[] items;
    private int totalItems;

    public Transaction(String transactionId) {
        this.transactionId = transactionId;
        this.items = new Product[50]; 
        this.totalItems = 0;
    }

    public double processSale(){
        double total = 0;

        for(int i = 0; i < totalItems; i++){
            Product p = items[i];

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() - (p.getPrice() * discount);

            total += finalPrice;
        }

        return total;
    }

    public void addItem(Product item){
        if(totalItems < items.length){
            items[totalItems] = item;
            totalItems++;
        }else{
            System.out.println("Keranjang penuh");
        }
    }

    public void addItem(Product item, int quantity){
        for(int i = 0; i < quantity; i++){
            addItem(item);
        }
    }
}
