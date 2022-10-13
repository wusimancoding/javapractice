package houserent.service;

import houserent.domain.House;

/**
 * 1.定义house[]，保存House对象
 * 2.响应houseView的调用
 * 3.完成对房屋的各种操作
 */
public class HouseService {

    private House[] houses;//保存house对象
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前id增长到哪个值

    public HouseService(int size) {
        //new houses;
        houses = new House[size];//当创建一个HouseService对象，指定数组大小
        //初始化一个对象
        houses[0] = new House(1,"zdd","112","海淀区",2000,"未出租");
    }

    public boolean del(int delId) {
        //先找到删除的房屋信息对应的下标，不一定等于ID
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()) {
                index = i;//使用index记录i;
            }
        }
        if(index == -1) {
            return false;
        }
        for (int i = 0; i < houseNums; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
        return true;
    }

    //add方法，添加新对象，返回boolean，判断是否添加成功
    public boolean add(House newHouse) {
        if(houseNums == houses.length) {
            System.out.println("数组已满，不能再添加");
            return false;
        }
        houses[houseNums++] = newHouse;
        //我们需要设计一个id自增长的机制
        newHouse.setId(++idCounter);
        return true;
    }
    public House[] list() {
        return houses;
    }
}
