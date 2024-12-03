// 房价策略接口
interface PriceStrategy {
    double calculatePrice(double basePrice);
}

// 普通用户策略：全价
class NormalPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;  // 不打折，原价
    }
}

// 金卡用户策略：8折
class GoldCardPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.8;  // 打8折
    }
}

// 银卡用户策略：9折
class SilverCardPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;  // 打9折
    }
}



// 用户类，持有一个策略对象
class User {
    private PriceStrategy priceStrategy;

    public User(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    // 计算价格
    public double calculatePrice(double basePrice) {
        return priceStrategy.calculatePrice(basePrice);
    }
}

// 房间类，表示一个房间
class Room {
    private double basePrice;

    public Room(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}


public class HotelReservationSystem {
    public static void main(String[] args) {
        // 创建不同的策略对象
        PriceStrategy normalStrategy = new NormalPriceStrategy();
        PriceStrategy goldCardStrategy = new GoldCardPriceStrategy();
        PriceStrategy silverCardStrategy = new SilverCardPriceStrategy();

        // 创建不同的用户对象
        User normalUser = new User(normalStrategy);
        User goldCardUser = new User(goldCardStrategy);
        User silverCardUser = new User(silverCardStrategy);

        // 创建一个房间，基本价格为 500
        Room room = new Room(500);

        // 打印不同用户的房价
        System.out.println("Normal User Price: " + normalUser.calculatePrice(room.getBasePrice()));
        System.out.println("Gold Card User Price: " + goldCardUser.calculatePrice(room.getBasePrice()));
        System.out.println("Silver Card User Price: " + silverCardUser.calculatePrice(room.getBasePrice()));
    }
}
