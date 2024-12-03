// 飞行行为接口及实现类
interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}

class UnableFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am flapping my wings, but I can't fly.");
    }
}

// 游泳行为接口及实现类
interface SwimBehavior {
    void swim();
}

class AbleSwim implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("I am swimming gracefully.");
    }
}

class UnableSwim implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("I can't swim, I drown.");
    }
}




// 鸟类的抽象类
abstract class Bird {
    protected FlyBehavior flyBehavior;
    protected SwimBehavior swimBehavior;

    public Bird(FlyBehavior flyBehavior, SwimBehavior swimBehavior) {
        this.flyBehavior = flyBehavior;
        this.swimBehavior = swimBehavior;
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performSwim() {
        swimBehavior.swim();
    }
}

// 具体的鸟类：老鹰
class Eagle extends Bird {
    public Eagle() {
        super(new FlyWithWings(), new UnableSwim()); // 老鹰会飞，但不会游泳
    }

    @Override
    public void display() {
        System.out.println("I am an Eagle.");
    }
}

// 具体的鸟类：企鹅
class Penguin extends Bird {
    public Penguin() {
        super(new UnableFly(), new AbleSwim()); // 企鹅不会飞，但能游泳
    }

    @Override
    public void display() {
        System.out.println("I am a Penguin.");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird eagle = new Eagle();
        Bird penguin = new Penguin();

        // 测试老鹰
        System.out.println("Testing Eagle:");
        eagle.display();
        eagle.performFly();
        eagle.performSwim();

        System.out.println();

        // 测试企鹅
        System.out.println("Testing Penguin:");
        penguin.display();
        penguin.performFly();
        penguin.performSwim();
    }
}


