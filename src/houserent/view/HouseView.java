package houserent.view;

import houserent.domain.House;
import houserent.service.HouseService;
import houserent.utils.Utility;

/**
 * 1.��ʾ����
 * 2.�����û�����
 * 3.����HouseService��ɶԷ�����Ϣ����ɾ�Ĳ�
 */
public class HouseView {

    private boolean loop = true;//������ʾ�˵�
    private char key = ' ';//�����û�ѡ��
    private HouseService houseService = new HouseService(10);//���������СΪ10

    //��дdelHouse()���������ID���룬����Service��del������
    public void delHouse() {
        System.out.println("============�������ɾ���ķ��ݱ��(-1�˳�)===========");
        int deleteId = Utility.readInt();
        if(deleteId == -1) {
            System.out.println("����ɾ��������Ϣ");
            return;
        }
        char choice = Utility.readConfirmSelection();//�÷�����ѭ���ж��߼���ȷ���Ƿ�ɾ��
        if(choice == 'Y') {
            if(houseService.del(deleteId)) {
                System.out.println("ɾ��������Ϣ�ɹ�");
            }else{
                System.out.println("����ɾ��ʧ��");
            }
        }else {
            System.out.println("�ѷ���ɾ��������Ϣ");
        }
    }

    //��дaddHouse()�������룬����House���󣬵���add����;
    public void addHouse() {
        System.out.println("============��ӷ���===========");
        System.out.println("����");
        String name = Utility.readString(8);//���ֳ������Ʋ�����8λ
        System.out.println("�绰");
        String phone = Utility.readString(12);
        System.out.println("��ַ");
        String address = Utility.readString(19);
        System.out.println("���⣺");
        int rent = Utility.readInt();
        System.out.println("״̬��");
        String state = Utility.readString(3);

        //����һ���µ�House����,ע��ID��ϵͳ����ģ��û�������
        House house = new House(0, name, phone, address, rent, state);
        if(houseService.add(house)) {
            System.out.println("============������ӳɹ�===========");
        } else {
            System.out.println("============�������ʧ��===========");
        }
    }

    //��дlistHouse()��ʾ�����б�
    public void listHouse() {
        System.out.println("============�����б�===========");
        System.out.println("���  ����  �绰 ��ַ  ����  ״̬");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("==========�����б���ʾ���=========");
    }
    //��ʾ���˵�
    public void mainMenu() {

        do{
            System.out.println("============���ݳ���ϵͳ=============");
            System.out.println("\t\t\t1 �� �� �� ��");
            System.out.println("\t\t\t2 �� �� �� Դ");
            System.out.println("\t\t\t3 ɾ �� �� Դ");
            System.out.println("\t\t\t4 �� �� �� Դ");
            System.out.println("\t\t\t5 �� ʾ �� Դ");
            System.out.println("\t\t\t6 ��      ��");
            System.out.println("���������ѡ��(1 - 6)");
            key = Utility.readChar();
            switch(key) {
                case'1':
                    addHouse();
                    break;
                case'2':
                    System.out.println("����");
                    break;
                case'3':
                    delHouse();
                    System.out.println("ɾ��");
                    break;
                case'4':
                    System.out.println("�޸�");
                    break;
                case'5':
                    listHouse();
                    break;
                case'6':
                    System.out.println("�˳�");
                    loop = false;
                    break;
            }

        }
        while (loop);
    }
}
