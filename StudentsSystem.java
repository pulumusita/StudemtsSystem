package Students;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsSystem {
    public static void app() {
        ArrayList<Students> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("----------------黑马学生信息管理系统----------------");
            System.out.println("1:添加学生信息");
            System.out.println("2:删除学生信息");
            System.out.println("3:修改学生信息");
            System.out.println("4:查询学生信息");
            System.out.println("5:退出学生信息管理系统");
            System.out.println("请输入您的选择:");
            String choose = sc.next();

            switch (choose) {
                case "1":
                    addStudents(list);
                    break;
                case "2":
                    deleteStudents(list);
                    break;
                case "3":
                    changeStudents(list);
                    break;
                case "4":
                    queryStudents(list);
                    break;
                case "5":
                    System.out.println("退出\n");
                    break loop;
                default:
                    System.out.println("没有这个选项,请重新输入\n");
            }
        }
    }

    //添加学生信息
    public static ArrayList<Students> addStudents(ArrayList<Students> list) {
        Scanner sc = new Scanner(System.in);
        Students s = new Students();
        while (true) {
            System.out.println("请输入学生的id");
            String id = sc.next();
            //如果id存在,则接着循环，用户重新输入
            if (contains(list, id)) {
                System.out.println("当前录入id已经存在,请重新输入id");
            }
            //id不存在，跳出循环
            else {
                s.setId(id);
                break;
            }
        }
        System.out.println("请输入学生的姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生的家庭住址");
        String address = sc.next();
        s.setAddress(address);
        list.add(s);
        System.out.println("添加成功\n");
        return list;
    }


    public static void deleteStudents(ArrayList<Students> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想删除的学生的id");
        String id = sc.next();
        //这里if判断以及remove中不能使用id,因为id为String类型,我第一次踩坑了,大家注意
        if (containsIndex(list, id) >= 0) {
            list.remove(containsIndex(list, id));
            System.out.println("删除" + containsIndex(list, id) + "的信息成功");
        } else {
            System.out.println(
                    "该学生信息不存在，删除失败"
            );
        }


    }

    //查询学生信息
    public static void queryStudents(ArrayList<Students> list) {
        Scanner sc = new Scanner(System.in);
        //判断集合中是否有信息
        if (list.size() == 0) {
            System.out.println("系统中无数据，请先添加后再查询\n");
            return;
        }
        System.out.println("**************学生信息列表**************");
        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Students s = list.get(i);
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());
        }
    }

    //修改学生信息
    public static void changeStudents(ArrayList<Students> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想修改的学生id:");
        String id = sc.next();
        //这里用containsIndex方法进行判断吗,如果不存在需要重新输入
        if (containsIndex(list, id) == -1) {
            System.out.println("id为 " + id + " 的学生不存在,请重新输入");
            return;
        }

        Students s = list.get(containsIndex(list, id));

        loop:
        while (true) {
            System.out.println("**************学生信息修改系统**************");
            System.out.println("1:修改学生id");
            System.out.println("2:修改学生姓名");
            System.out.println("3:修改学生年龄");
            System.out.println("4:查询学生家庭住址");
            System.out.println("5:退出修改系统");
            System.out.println("请选择你想修改的选项");

            String choose = sc.next();

            switch (choose) {
                case "1":
                    System.out.println("请输入修改后的id");
                    String sid = sc.next();
                    s.setId(sid);
                    break;
                case "2":
                    System.out.println("请输入修改后的姓名");
                    String name = sc.next();
                    s.setName(name);
                    break;
                case "3":
                    System.out.println("请输入修改后的年龄");
                    int age = sc.nextInt();
                    s.setAge(age);
                    break;
                case "4":
                    System.out.println("请输入修改后的家庭住址");
                    String address = sc.next();
                    s.setAddress(address);
                    break;
                case "5":
                    break loop;
                default:
                    System.out.println("没有这个选项，请重新输入\n");
            }
            System.out.println("修改信息成功\n");
        }
    }

    //判断id在集合中是否存在
    public static boolean contains(ArrayList<Students> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Students stu = list.get(i);
            String sid = stu.getId();
            if (id.equals(sid)) {
                return true;
            }
        }
        return false;
    }

    //查询集合中是否存在该id的学生，存在返回该学生id，不存在返回-1
    public static int containsIndex(ArrayList<Students> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Students s = list.get(i);
            String sid = s.getId();
            if (sid.equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
