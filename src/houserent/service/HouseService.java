package houserent.service;

import houserent.domain.House;

/**
 * 1.����house[]������House����
 * 2.��ӦhouseView�ĵ���
 * 3.��ɶԷ��ݵĸ��ֲ���
 */
public class HouseService {

    private House[] houses;//����house����
    private int houseNums = 1;//��¼��ǰ�ж��ٸ�������Ϣ
    private int idCounter = 1;//��¼��ǰid�������ĸ�ֵ

    public HouseService(int size) {
        //new houses;
        houses = new House[size];//������һ��HouseService����ָ�������С
        //��ʼ��һ������
        houses[0] = new House(1,"zdd","112","������",2000,"δ����");
    }

    public boolean del(int delId) {
        //���ҵ�ɾ���ķ�����Ϣ��Ӧ���±꣬��һ������ID
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()) {
                index = i;//ʹ��index��¼i;
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

    //add����������¶��󣬷���boolean���ж��Ƿ���ӳɹ�
    public boolean add(House newHouse) {
        if(houseNums == houses.length) {
            System.out.println("�������������������");
            return false;
        }
        houses[houseNums++] = newHouse;
        //������Ҫ���һ��id�������Ļ���
        newHouse.setId(++idCounter);
        return true;
    }
    public House[] list() {
        return houses;
    }
}
