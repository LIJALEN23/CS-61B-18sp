package ParkingLot;

/** 车的类
 *  属性：
 *  1. 车的类型
 *  方法
 *  1. 构造函数
 *  2. 获得车的类型*/
public class Car {
    private ParkingSpaceType type;

    public Car(ParkingSpaceType type) {
        this.type = type;
    }

    public ParkingSpaceType getType() {
        return type;
    }
}
