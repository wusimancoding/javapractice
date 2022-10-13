package houserent;

import houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，并且显示主菜单，是整个程序入口
        new HouseView().mainMenu();
        //这个地方不需要接收，因为后面用不到，只调用即可
        System.out.println("=====已退出房屋出租系统=====");
    }
}
