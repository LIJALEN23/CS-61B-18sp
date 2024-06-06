package ParkingLot;

/** 车位的类
 *  属性：
 *  1. id
 *  2. 车位类型
 *  3. 车位到入口的距离
 *
 *  方法：
 *  1. 构造函数
 *  2. 获得id
 *  3. 获得车位类型
 *  4. 获得车位到入口的距离*/
public class ParkingSpace {
    private int id;
    private ParkingSpaceType type;
    private int distanceToEntrance;

    public ParkingSpace(int id, ParkingSpaceType type, int distanceToEntrance) {
        this.distanceToEntrance = distanceToEntrance;
        this.type = type;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ParkingSpaceType getType() {
        return type;
    }

    public int getDistanceToEntrance() {
        return distanceToEntrance;
    }
}
