package ParkingLot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

/**停车场的类
 * 属性：
 * 1.常规车位的总数
 * 2.小车位的总数
 * 3.残疾车位的总数
 * 4.可用的常规车位
 * 5.可用的小车位
 * 6.可用的残疾车车位
 * 方法：
 * 1.给入口的车分配车位
 * 2.将空闲的车位标记成空闲状态*/
public class ParkingLot {
    private int regularSpaceCount;
    private int compactSpaceCount;
    private int handicappedSpaceCount;

    //用队列来查询各类型的停车位情况
    private Queue<Integer> regularSpacesAvailable;
    private Queue<Integer> compactSpacesAvailable;
    private Queue<Integer> handicappedSpacesAvailable;

    //用映射来储存所有停车位
    private Map<Integer, ParkingSpace> parkingSpace;

    public ParkingLot(int regularSpaceCount, int compactSpaceCount, int handicappedSpaceCount) {
        this.compactSpaceCount = compactSpaceCount;
        this.regularSpaceCount = regularSpaceCount;
        this.handicappedSpaceCount = handicappedSpaceCount;

        regularSpacesAvailable = new LinkedList<>();
        compactSpacesAvailable = new LinkedList<>();
        handicappedSpacesAvailable = new LinkedList<>();

        parkingSpace = new HashMap<>();

        initParkingSpace();
    }

    //初始化ParkingSpace
    private void initParkingSpace() {
        int id = 1;

        for (int i = 0; i < regularSpaceCount; i++) {
            ParkingSpace space = new ParkingSpace(id++, ParkingSpaceType.REGULAR, i + 1);
            parkingSpace.put(space.getId(), space);
            regularSpacesAvailable.offer(space.getId());
        }
        for (int i = 0; i < compactSpaceCount; i++) {
            ParkingSpace space = new ParkingSpace(id++, ParkingSpaceType.COMPACT, i + 1);
            parkingSpace.put(space.getId(), space);
            compactSpacesAvailable.offer(space.getId());
        }
        for (int i = 0; i < handicappedSpaceCount; i++) {
            ParkingSpace space = new ParkingSpace(id++, ParkingSpaceType.HANDICAPPED, i + 1);
            parkingSpace.put(space.getId(), space);
            handicappedSpacesAvailable.offer(space.getId());
        }
    }

    //根据车辆的类型选择是否有停车位选择：根据队列性质，可以实现先去近的停车位停车
    public int parkCar(Car car) {
        ParkingSpaceType carType = car.getType();
        int spaceId = -1;

        switch (carType) {
            case REGULAR:
                if (!regularSpacesAvailable.isEmpty()) {
                    spaceId = regularSpacesAvailable.poll();
                }
                break;
            case COMPACT:
                if (!compactSpacesAvailable.isEmpty()) {
                    spaceId = compactSpacesAvailable.poll();
                }
                else if (!regularSpacesAvailable.isEmpty()) {
                    spaceId = regularSpacesAvailable.poll();
                }
                break;
            case HANDICAPPED:
                if (!handicappedSpacesAvailable.isEmpty()) {
                    spaceId = handicappedSpacesAvailable.poll();
                }
                break;
        }

        if (spaceId != -1) {
            System.out.println("Car parked successfully in space " + spaceId);
        }
        else {
            System.out.println("No available space for this type of car!");
        }
        return spaceId;
    }

    public void freeSpace(int spaceId) {
        if (parkingSpace.containsKey(spaceId)) {
            ParkingSpace space = parkingSpace.get(spaceId);

            switch (space.getType()) {
                case REGULAR:
                    regularSpacesAvailable.offer(spaceId);
                    break;
                case COMPACT:
                    compactSpacesAvailable.offer(spaceId);
                    break;
                case HANDICAPPED:
                    handicappedSpacesAvailable.offer(spaceId);
                    break;
            }

            System.out.println("Space " + spaceId + " freed successfully!");
        }
        else {
            System.out.println("Invalid space id!");
        }
    }

}
