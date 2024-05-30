/** 理解静态方法和静态变量
 *  静态方法：
 *       直接调用类使用
 *       不能访问非静态变量
 *  静态变量：
 *      保存类级别的数据，不依赖于实例。
 *      共享全局状态或资源。
 *      静态方法中的数据访问。
 *      定义不可修改的常量。
 * */

public class Cat {
    public String name;
    public static String noise;

    public Cat(String name, String noise) {
        this.name = name;
        this.noise = noise;
    }

    public void play() {
        System.out.println(noise + " I am " + name + " cat!");
    }

    public static void anger() {
        noise = noise.toUpperCase();
    }

    public static void calm() {
        noise = noise.toLowerCase();
    }

    public static void main(String[] args) {
        Cat cream =  new Cat("cream", "Meow!");
        Cat tubbs = new Cat("tubbs", "Nyan!");

        cream.play();
        tubbs.play();

        Cat.anger();

        cream.calm();

        cream.play();
        tubbs.play();
    }

}
