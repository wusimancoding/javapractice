package houserent.view;

import houserent.domain.House;
import houserent.service.HouseService;
import houserent.utils.Utility;

/**
 * 1.显示界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的增删改查
 */
public class HouseView {

    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户选择
    private HouseService houseService = new HouseService(10);//设置数组大小为10

    //编写delHouse()接收输入的ID号码，调动Service的del方法；
    public void delHouse() {
        System.out.println("============请输入待删除的房屋编号(-1退出)===========");
        int deleteId = Utility.readInt();
        if(deleteId == -1) {
            System.out.println("放弃删除房屋信息");
            return;
        }
        char choice = Utility.readConfirmSelection();//该方法有循环判断逻辑，确认是否删除
        if(choice == 'Y') {
            if(houseService.del(deleteId)) {
                System.out.println("删除房屋信息成功");
            }else{
                System.out.println("房屋删除失败");
            }
        }else {
            System.out.println("已放弃删除房屋信息");
        }
    }

    //编写addHouse()接收输入，创建House对象，调用add方法;
    public void addHouse() {
        System.out.println("============添加房屋===========");
        System.out.println("姓名");
        String name = Utility.readString(8);//名字长度限制不超过8位
        System.out.println("电话");
        String phone = Utility.readString(12);
        System.out.println("地址");
        String address = Utility.readString(19);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);

        //创建一个新的House对象,注意ID是系统分配的，用户不输入
        House house = new House(0, name, phone, address, rent, state);
        if(houseService.add(house)) {
            System.out.println("============房屋添加成功===========");
        } else {
            System.out.println("============房屋添加失败===========");
        }
    }

    //编写listHouse()显示房屋列表
    public void listHouse() {
        System.out.println("============房屋列表===========");
        System.out.println("编号  房主  电话 地址  月租  状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("==========房屋列表显示完毕=========");
    }
    //显示主菜单
    public void mainMenu() {

        do{
            System.out.println("============房屋出租系统=============");
            System.out.println("\t\t\t1 新 增 房 屋");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删 除 房 源");
            System.out.println("\t\t\t4 修 改 房 源");
            System.out.println("\t\t\t5 显 示 房 源");
            System.out.println("\t\t\t6 退      出");
            System.out.println("请输入你的选择(1 - 6)");
            key = Utility.readChar();
            switch(key) {
                case'1':
                    addHouse();
                    break;
                case'2':
                    System.out.println("查找");
                    break;
                case'3':
                    delHouse();
                    System.out.println("删除");
                    break;
                case'4':
                    System.out.println("修改");
                    break;
                case'5':
                    listHouse();
                    break;
                case'6':
                    System.out.println("退出");
                    loop = false;
                    break;
            }

        }
        while (loop);
    }
}
