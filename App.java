package Students;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----------------黑马学生信息管理系统登录系统----------------");
            System.out.println("1:登录");
            System.out.println("2:注册");
            System.out.println("3:忘记密码");
            System.out.println("4:退出程序");

            System.out.println("请输入你的选择:");
            String choose = sc.next();

            loop:
            switch (choose) {
                case "1":
                    login(list);
                    break;
                case "2":
                    register(list);
                    break;
                case "3":
                    forgetPassword(list);
                    break;
                case "4":
                    break loop;
                default:
                    System.out.println("该选项不存在,请重新选择");
            }
        }

    }

    //注册账号
    public static void register(ArrayList<User> list) {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        //录入用户名
        while (true) {
            System.out.println("请输入你想注册的用户名:");
            String username = sc.next();

            boolean flag = checkUsername(list, username);
            if (flag == false) {
                continue;
            }
            System.out.println("添加成功");
            user.setUsername(username);
            break;

        }
        //录入密码
        while (true) {
            System.out.println("请输入密码:");
            String password = sc.next();

            System.out.println("请再次输入密码:");
            String password1 = sc.next();

            boolean flag = checkPassword(password, password1);

            if (!flag) {
                continue;
            }

            System.out.println("设置密码成功");
            user.setPassword(password);

            break;
        }

        //录入身份证号
        while (true) {
            System.out.println("请输入身份证号:");
            String identityNumber = sc.next();

            boolean flag = checkIdentityNumber(identityNumber);

            if (!flag) {
                continue;
            }
            System.out.println("身份证符合要求,添加成功");

            user.setIdentityNumber(identityNumber);

            break;

        }

        //录入手机号
        while (true) {
            System.out.println("请输入手机号码");
            String phoneNumber = sc.next();

            boolean flag = checkPhoneNumber(phoneNumber);
            if (!flag) {
                continue;
            }
            System.out.println("手机号添加成功");
            user.setPhoneNumber(phoneNumber);
            break;
        }
        //添加用户对象到数组中
        list.add(user);
    }

    //登录系统
    public static void login(ArrayList<User> list) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.println("请输入用户名:");
            String username = sc.next();
            int flag = containsIndex(list, username);

            if (flag < 0) {
                System.out.println("用户未注册,请先注册");
                return;
            }
            System.out.println("请输入您的密码:");
            String password = sc.next();

            while (true) {
                //调取生成验证码方法获取验证码
                getVerificationCode code = new getVerificationCode();

                String rightCode = code.getIdentifying();
                System.out.println("正确的验证码为:" + rightCode + "\n请输入验证码");
                String userCode = sc.next();

                //判断验证码是否正确
                if (userCode.equalsIgnoreCase(rightCode)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码输入错误，请重新输入");
                    continue;
                }
            }

            //检查用户名和密码是否正确,封装一下username和password
            User userInfo = new User(username, password, null, null);
            boolean flagLogin = checkLogin(list, userInfo);
            if (flagLogin) {
                System.out.println("登录成功,欢迎使用学生管理系统");
                //进入学生信息管理系统
                StudentsSystem sy = new StudentsSystem();
                sy.app();
                return;
            } else {
                if (i == 2) {
                    System.out.println("登录失败,当前用户名或密码错误,用户被锁定，请联系工作人员");
                    return;
                } else {
                    System.out.println("登录失败,当前用户名或密码错误,请重新输入,还剩下" + (2 - i) + "次机会");
                }
            }
        }
    }

    //检查键盘录入用户名是否符合规定
    public static boolean checkUsername(ArrayList<User> list, String username) {
        if (containsIndex(list, username) > 0) {
            System.out.println("您输入的用户名已经存在,请重新输入");
            return false;
        }

        int len = username.length();
        if (len < 3 || len > 15) {
            System.out.println("username长度需要在3-15之间,您输入的用户名长度不符合,请重新输入");
            return false;
        }

        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("您输入的用户名存在符号或您输入的用户名为纯数字,不符合要求,请重新输入");
            return false;
        }

        int count1 = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                count1++;
            }
        }
        if (count1 <= 0) {
            System.out.println("您输入的用户名存在符号或您输入的用户名为纯数字,不符合要求,请重新输入");
            return false;
        }
        return true;
    }

    //判断集合中是否有
    public static int containsIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String username1 = user.getUsername();
            if (username1.equals(username)) {
                return i;
            }
        }
        return -1;
    }

    //检查密码格式
    public static boolean checkPassword(String p, String p1) {
        if (!(p.equals(p1))) {
            System.out.println("两次输入密码不一致,请重新输入");
            return false;
        }
        return true;
    }

    //检查身份证信息
    public static boolean checkIdentityNumber(String identityNumber) {
        if (!(identityNumber.length() == 18)) {
            System.out.println("你输入的身份证长度不符合18位,请重新输入");
            return false;
        }

        char c = identityNumber.charAt(0);
        if (c == '0') {
            System.out.println("身份证号不能以0开头,请重新输入");
            return false;
        }

        for (int i = 0; i < identityNumber.length() - 1; i++) {
            char c1 = identityNumber.charAt(i);
            if (c1 < '0' || c1 > '9') {
                System.out.println("身份证号只能为纯数字,您输入的身份证不合法,请重新输入");
                return false;
            }
        }

        char lastC = identityNumber.charAt(identityNumber.length() - 1);
        if (!(lastC >= '0' && lastC <= '9' || lastC == 'X' || lastC == 'x')) {
            System.out.println("您输入的身份证最后一位不符合要求,请重新输入(最后一位可以为数字以及Z和z)");
            return false;
        }
        return true;
    }

    //检查手机号格式
    public static boolean checkPhoneNumber(String phoneNumber) {
        char c = phoneNumber.charAt(0);
        if (c == '0') {
            System.out.println("手机号格式错误,第一位不能为0,请重新输入");
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char c1 = phoneNumber.charAt(i);
            if (!(c1 >= '0' && c1 <= '9')) {
                System.out.println("手机号格式错误,请重新输入");
                return false;
            }
        }
        return true;
    }

    //检查集合中是否存在与用户输入的username以及password一样数据
    public static boolean checkLogin(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            //集合中的username和password与用户输入的username和password进行比较
            if (user.getUsername().equals(userInfo.getUsername()) && user.getPassword().equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //忘记密码功能
    public static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "请输入你想找回密码的账号: "
        );
        String username = sc.next();
        int index = containsIndex(list, username);
        if (index < 0) {
            System.out.println("该用户不存在，请先注册");
            return;
        }
        while (true) {
            System.out.println("请输入身份证号");
            String personID = sc.next();
            System.out.println("请输入手机号码:");
            String phoneNumber = sc.next();

            User user = list.get(index);

            if (!(user.getIdentityNumber().equals(personID) && user.getPhoneNumber().equals(phoneNumber))) {
                System.out.println("身份证号或密码错误,请重新输入");
                continue;
            } else {
                break;
            }
        }
        User user = list.get(index);
        while (true) {
            System.out.println("请输入修改后的密码");
            String p1 = sc.next();
            System.out.println("请再次输入修改后的密码: ");
            String p = sc.next();

            boolean flag = checkPassword(p, p1);
            if (!flag) {
                System.out.println("两次输入密码不一致,请重新输入");
            }
            System.out.println("密码修改成功");
            user.setPassword(p1);
            break;
        }
    }
}

