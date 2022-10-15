## 前言

**这个程度算是自己独立写的第一个Java程序，当个课设还是不错的，程序基本功能都可以实现，不过大家也别要求太高，毕竟是初学者，如果想整成个毕设啥的也可以，自己加个壳啥的就行，问题不大。**

大家也可以去看一下我博客上写的：

这个系统相比大家都很熟悉，在大学课程肯定会有老师带着大家去开发这个程序，因为我之前没写过，所以这里就简单的再复习一下这个系统的写法

> **如果想去看原视频的，老师分析的更好更全面，大家可以去看看学习一下。**
>
> bilibili.com/video/BV17F411T7Ao?p=116&vd_source=94fb2114c3889338d33bcb41c3e25538

## 代码结构

App.java：主入口及登录界面

getVerificationCode.java：生成验证码程序

StudentsSystem.java：图书管理系统主程序，登录成功后跳转

User.java：JavaBean程序

Students.java：JavaBean程序

## java版本要求

**jdk>=12**

## 学生管理系统登录界面需求文档

### 需求：

​	为学生管理系统书写一个登陆、注册、忘记密码的功能。

​	只有用户登录成功之后，才能进入到学生管理系统中进行增删改查操作。

### 分析：

#### 登录界面：

```java
System.out.println("欢迎来到学生管理系统");
System.out.println("请选择操作1登录 2注册 3忘记密码");
```

#### 用户类：

​	属性：用户名、密码、身份证号码、手机号码

#### 注册功能：

​	1，用户名需要满足以下要求：

​		验证要求：

​			用户名唯一

​			用户名长度必须在3~15位之间 

​			只能是字母加数字的组合，但是不能是纯数字

​	2，密码键盘输入两次，两次一致才可以进行注册。

​	3，身份证号码需要验证。

​		验证要求：

​			长度为18位

​			不能以0为开头

​			前17位，必须都是数字

​			最为一位可以是数字，也可以是大写X或小写x

​	4，手机号验证。

​		验证要求：

​			长度为11位

​			不能以0为开头

​			必须都是数字

#### 登录功能：

​	1，键盘录入用户名

​	2，键盘录入密码

​	3，键盘录入验证码

验证要求：

​		用户名如果未注册，直接结束方法，并提示：用户名未注册，请先注册

​		判断验证码是否正确，如不正确，重新输入

​		再判断用户名和密码是否正确，有3次机会

#### 忘记密码：

​       1，键盘录入用户名，判断当前用户名是否存在，如不存在，直接结束方法，并提示：未注册

​	2，键盘录入身份证号码和手机号码

​	3，判断当前用户的身份证号码和手机号码是否一致，

​			如果一致，则提示输入密码，进行修改。

​			如果不一致，则提示：账号信息不匹配，修改失败。

#### 验证码规则：

​	长度为5

​	由4位大写或者小写字母和1位数字组成，同一个字母可重复

​	数字可以出现在任意位置

比如：

​	aQa1K





## 学生管理系统主程序需求文档

### 需求：

​	采取控制台的方式去书写学生管理系统。

### 分析：

![](https://img1.plumstar.cn/upload5image-20221012165025758.png)

#### 初始菜单：

```java
"-------------欢迎来到黑马学生管理系统----------------"
"1：添加学生"
"2：删除学生"
"3：修改学生"
"4：查询学生"
"5：退出"
"请输入您的选择:"
```

#### 学生类：

​	属性：id、姓名、年龄、家庭住址

#### 添加功能：

​	键盘录入每一个学生信息并添加，需要满足以下要求：

* id唯一

#### 删除功能：

​	键盘录入要删除的学生id，需要满足以下要求：

* id存在删除
* id不存在，需要提示不存在，并回到初始菜单

#### 修改功能：

​	键盘录入要修改的学生id，需要满足以下要求

* id存在，继续录入其他信息
* id不存在，需要提示不存在，并回到初始菜单

#### 查询功能：

​	打印所有的学生信息，需要满足以下要求

* 如果没有学生信息，提示：当前无学生信息，请添加后再查询
* 如果有学生信息，需要按照以下格式输出。（不用过于纠结对齐的问题）

```java
id			姓名		年龄		家庭住址
heima001	张三		23		 南京
heima002	李四		24		 北京
heima003	王五		25		 广州
heima004	赵六	 	26		 深圳
```

## 最后

如有问题请联系我：qq-1275895583；或者博客写个评论