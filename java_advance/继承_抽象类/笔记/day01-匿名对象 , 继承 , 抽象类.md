#      		 day01-匿名对象 , 继承 , 抽象类

## 今日目标

- ##### 面向对象回顾

- ##### 匿名对象介绍

- ##### 面向对象特征 - 继承

- ##### 抽象类的使用

- ##### 模板设计模式

## 1 面向对象回顾 

- ##### 面向对象的核心思想是什么 ? 

  - 用代码来模拟现实生活中的事物 , 比如学生类表示学生事物 , 对象表示的就是具体的学生 , 有了类就可以描述万千世界所有的事物了

- ##### 现有的类还是先有的对象 ? 

  - 对象是根据类创建出来的 , 所有现有的类 , 再有对象

- ##### Java类的创建 ? 

  - 类名建议使用大驼峰命名法 , 每个单词首字母需要大写
  - Java规定 , 一个Java文件中可以定义多个类 , 但是只能有一个类使用public修饰 , public修饰的类名需要和java文件名保持一致
  - 按照规范 , 实际工作之时 , 建议一个Java文件中只能有一个类

- ##### 类中的组成成分 ?

  - 1 成员变量
  - 2 成员方法 
  - 3 构造方法
  - 4 内部类(后面学)
  - 5 代码块(后面学)

  <img src="D:\传智播客\上海-JavaSE进阶面授\day01【复习回顾、继承、抽象类】\笔记\img\image-20210329163755741.png" alt="image-20210329163755741" style="zoom: 80%;" />

- ##### 创建对象所使用的关键字 ? 

  - new关键字

- ##### 创建对象的格式 ?

  - 类名 对象名 = new 类名(参数列表);

- ##### 调用对象的成员 ? 

  - 调用成员变量 : 对象名.成员变量名
  - 调用成员方法 : 对象名.成员方法名(参数)

- ##### 定义构造方法的格式 ?

  - 修饰符  类名(参数){ ... }

- ##### 定义构造方法的特点 ? 

  - 没有返回值 ,  连void都没有
  - 方法名与类名相同
  - 构造方法可以进行重载定义

- ##### 构造方法的作用 ?

  - 空参构造 : 初始化对象的数据为默认值
  - 有参构造 : 初始化对象时 , 为对象的属性赋值

- ##### 面向对象三大特征是什么 ?

  - 封装 , 继承 , 多态 

- ##### 封装的思想及其作用 ? 

  - 思想 : 把实现细节隐藏 , 对外提供公共的访问方式
  - 作用 : 提高代码的安全性 , 提高代码的复用性

- ##### 封装的步骤 ?

  - 把成员变量进行private修饰
  - 提供对应的setter和getter方法

- ##### this关键字的含义 ?

  - this代表的是本类对象的引用
  - 在构造方法中 , this代表的是new的对象
  - 在成员方法中 , this代表的是调用此方法的对象

- ##### this关键字的作用 ?

  - 主要用于区分局部变量和成员变量同名的问题

## 2 匿名对象介绍

- ##### 什么是匿名对象 ? 

  - 没有变量接收的对象 , 称作为匿名对象

- ##### 匿名对象的使用 ? 

  - 直接使用匿名对象调用方法
  - 匿名对象作为方法传参
  - 匿名对象作为方法的返回值

- 代码实现

  ```java
  package com.itheima.anonymous;
  
  /*
      匿名对象 :
          没有对象名接收的对象 , 称作为匿名对象
          有对象名接收的对象 , 称作有名对象
  
      注意 : 一般使用一次的对象 , 我们可以采用匿名对象
  
      匿名对象的使用 :
          1 使用匿名对象直接调用方法
          2 使用匿名对象作为方法的传参
          3 使用匿名对象作为方法的返回值
   */
  public class Demo1 {
      public static void main(String[] args) {
  
  //        Student s = new Student();
  //        s.study();
  //        1 使用匿名对象直接调用方法
          new Student().study();
  
  
  //        Student s2 = new Student();
  //        useStudent(s2);
  //        2 使用匿名对象作为方法的传参
          useStudent(new Student());
      }
  
      public static void useStudent(Student s) {
          s.study();
      }
  
      public static Student getStudent() {
  //        Student s = new Student();
  //        return s;
          // 3 使用匿名对象作为方法的返回值
          return new Student();
      }
  }
  class Student {
      public void study() {
          System.out.println("学生学习...");
      }
  }
  ```
  
- ##### 代码实践：注册案例

  ![image-20210329172935229](D:\传智播客\上海-JavaSE进阶面授\day01【复习回顾、继承、抽象类】\笔记\img\image-20210329172935229.png)

  ```java
  package com.itheima.anonymous;
  
  import java.util.ArrayList;
  import java.util.Scanner;
  
  /*
      需求 :
          1 创建用户(User)对象 , 对象数据采用键盘录入而来
          2 用户(User)包含的属性 :
              用户名   (username)
              手机号码 (phonNumber)
              登录密码 (password)
              确认密码 (confirm)
              电子邮箱 (email)
              性别     (sex)
              出生日期 (birthday)
          3 如果登录密码和确认密码不一致 , 重新输入
          4 把用户(User)对象 ,添加到ArrayList集合中 , 打印集合对象即可
   */
  public class Demo2 {
      public static void main(String[] args) {
          // 创建集合对象
          ArrayList<User> list = new ArrayList<>();
  
          // 创建键盘录入对象 , 录入用户的数据
          Scanner sc = new Scanner(System.in);
          System.out.println("请输入用户名:");
          String username = sc.nextLine();
          System.out.println("请输入手机号码:");
          String phoneNumber = sc.nextLine();
          System.out.println("请输入登录密码:");
          String password = sc.nextLine();
          System.out.println("请输入确认密码:");
          // 如果登录密码 , 和确认密码不一致 , 需要重新输入确认密码
          String confirm;
          while (true) {
              confirm = sc.nextLine();
              if (password.equals(confirm)) {
                  break;
              } else {
                  System.out.println("您输入的登录密码和确认密码不一致, 请重新输入...");
              }
          }
          System.out.println("请输入电子邮箱:");
          String email = sc.nextLine();
          System.out.println("请输入性别:");
          String sex = sc.nextLine();
          System.out.println("请输入出生日期:");
          String birthday = sc.nextLine();
  
          // 把用户对象添加到集合中
          list.add(new User(username, phoneNumber, password, confirm, email, sex, birthday));
  
          // 遍历集合
          for (int i = 0; i < list.size(); i++) {
              // 获取集合中的用户对象
              User u = list.get(i);
              System.out.println(u.getUsername() + "---" + u.getPhonNumber() + "---" + u.getPassword() 
              + "---" + u.getConfirm()  + "---" + u.getEmail() + "---" + u.getSex() + "---" + u.getBirthday() );
          }
      }
  }
  ```
  
  ```java
  package com.itheima.anonymous;
// 用户类
  public class User {
      private String username;
      private String phoneNumber;
      private String password;
      private String confirm;
      private String email;
      private String sex;
      private String birthday;
  
  
      public User() {
      }
  
      public User(String username, String phonNumber, String password, String confirm, String email, String sex, String birthday) {
          this.username = username;
          this.phoneNumber = phonNumber;
          this.password = password;
          this.confirm = confirm;
          this.email = email;
          this.sex = sex;
          this.birthday = birthday;
      }
  
      public String getUsername() {
          return username;
      }
  
      public void setUsername(String username) {
          this.username = username;
      }
  
      public String getPhonNumber() {
          return phoneNumber;
      }
  
      public void setPhonNumber(String phonNumber) {
          this.phoneNumber = phonNumber;
      }
  
      public String getPassword() {
          return password;
      }
  
      public void setPassword(String password) {
          this.password = password;
      }
  
      public String getConfirm() {
          return confirm;
      }
  
      public void setConfirm(String confirm) {
          this.confirm = confirm;
      }
  
      public String getEmail() {
          return email;
      }
  
      public void setEmail(String email) {
          this.email = email;
      }
  
      public String getSex() {
          return sex;
      }
  
      public void setSex(String sex) {
          this.sex = sex;
      }
  
      public String getBirthday() {
          return birthday;
      }
  
      public void setBirthday(String birthday) {
          this.birthday = birthday;
      }
  }
  ```

## 3 继承

#### 3.1 为什么学习继承 ?

- 继承是将多个类的相同属性和行为抽取到单独一个类中，那么多个类无需再定义这些共性属性和行为，只要继承这个单独类即可继承这些属性和行为了
- 多个类称为子类（派生类），单独的这个类称为父类(基类 或超类)

#### 3.2 继承的格式 ?

- 使用关键字extends进行连接子类与父类
- 举例 : public class Student extends People{ ... }

#### 3.3 继承的好处 ?

- 提高代码的复用性
- 提高代码的维护性
- 让类与类产生了关系(继承关系) , 是多态的前提

```java
package com.itheima.extends_demo;
/*

    学生类 : 姓名(name) , 课程名称(course) , 所在班级(className)  , 查看课表(lookForm) , 填写反馈数据(write)
    老师类 : 姓名(name) , 课程名称(course) , 部门名称(department) , 查看课表(lookForm) , 发布试题(release)

    设计 : 把学生类 和 老师类的共性内容抽取到一个单独的类中(Person),存储共性内容
    父类 : 姓名(name) , 课程名称(course) ,  查看课表(lookForm)

 */
public class ExtendsDemo1 {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("张三");
        s.setCourse("Java");
        s.setClassName("三年二班");

        s.lookForm();
        s.write();
    }
}
```

```java
package com.itheima.extends_demo;
/*
    此类定义的是子类的共性成员
 */
public class Person {
    private String name;
    private String course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void lookForm(){
        System.out.println("查看课表");
    }

}

```

```java

package com.itheima.extends_demo;
/*
    子类只需要定义自己特有的成员 , 共性的成员需要抽取到父类中
 */
public class Student extends Person{
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void write(){
        System.out.println("填写反馈数据");
    }
}

```

```java

package com.itheima.extends_demo;

/*
    子类只需要定义自己特有的成员 , 共性的成员需要抽取到父类中
 */
public class Teacher extends Person {

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void release() {
        System.out.println("发布试题....");
    }
}

```

#### 3.5 继承后,子类对象内存图解

![image-20210330193948869](D:\传智播客\上海-JavaSE进阶面授\day01【复习回顾、继承、抽象类】\笔记\img\image-20210330193948869.png)

#### 3.6 继承的特点

- ##### Java只支持单继承 , 不支持多继承 , 但是可以多层继承

  - 简单理解 : 一个儿子只能有一个亲爹

- ##### 为什么不支持多继承 ?

  - 因为一个子类如果继承多个父类 , 父类有相同的方法声明, 子类会产生继承冲突 , 所以不允许

#### 3.7 继承中成员的发访问特点

- ##### 成员变量 

  - 访问特点-就近原则 : 局部有访问局部的 , 局部没有访问本类成员的 , 本类成员没有访问父类非私有成员

- ##### 成员方法

  - 访问特点-就近原则 : 子类有调用子类的 , 子类没有调用父类的

- ##### 构造方法

  - 子类所有的构造方法都会默认去访问父类的空参数构造方法
    - 原因 : 因为子类在初始化时 , 可能会用到父类的数据 , 所以通过访问父类的构造 , 先给父类进行初始化
  - 如果进行初始化呢 ?
    - 每个构造方法中默认第一条语句都会有一个super()
  - 如果父类没有空参数构造 , 那么子类如果进行给父类初始化 ? 
    - 子类可以通过super(...)访问父类的有参数构造方法
    - 子类通过this(..)访问子类的有参构造 , 在通过有参构造区访问父类的有参构造 , 不推荐
  - 注意事项 : 
    - super(...) 和 this(...) 因为二者都需要放在构造方法的第一条可执行语句, 所以二者不能共存 

#### 3.8 方法重写

- ##### 什么是方法重写 ?

  - 子类和父类出现了一模一样的方法的声明(方法名 , 参数列表)

- ##### 为什么要学习方法重写 ?

  - 当子类需要使用父类的功能 , 但是父类的功能又满足不了子类 , 那么子类需要重写 , 这样既可以使用父类的功能 ,也可以增加新的功能

- ##### 如果进行方法重写 ?

  - 子类和父类的方法声明一样 , 方法体中的内容重新定义

- ##### Override注解是做什么的，有什么用？

  - @Override是放在重写后的方法上，作为重写是否正确的校验注解，加上该注解后如果重写错误，编译阶段会出现错误提示。建议重写方法都加@Override注解，代码安全，优雅！

- ##### 方法重写的注意事项 ?

  - 私有的方法无法重写
  - 重写的方法与被重写的方法 , 名字 , 参数列表需要保持一致
  - 子类重写父类方法时，子类方法访问权限必须大于或者等于父类方法权限 （暂时了解 ：缺省 < protected < public）
    - 一般保持一致即可

#### 3.9 this和super关键字的区别

- this : 代表的是本类的对象
- super : 代表的是父类数据存储空间(可以看做成父类的对象)
- 使用 : 
  - 调用变量 : 
    - this.变量名 : 访问本类的成员变量
    - super.变量名 : 访问父类的成员变量
  - 调用方法 : 
    - this.方法名(...) : 访问本类的成员方法
    - super.方法名(...): 访问父类的成员方法
  - 调用构造 : 
    - this.构造方法名(...) : 访问本类的构造方法
    - super.构造方法名(....) : 访问父类的构造方法

## 4 抽象类

#### 4.1 抽象类 : 

- 抽象类其实就是为抽象方法提供存活的空间 , 需要在类的前面加上上abstract关键字进行修饰
- 抽象类的作用主要是规范子类必须实现某种规则

#### 4.2 抽象方法 : 

- 一个方法要么有方法体 , 要么是一个抽象方法 

#### 4.3 抽象类的注意事项 : 

- 抽象方法和抽象类必须使用abstract关键字进行修饰
- 抽象类中可以抽象方法 , 也可以有非抽象方法 , 抽象方法必须存在抽象类中
  - 抽象方法的作用 : 让子类必须实现此功能
  - 非抽象方法的作用 : 让子类去继承此功能
- 抽象类不能实例化
- 抽象类的子类
  - 要么是一个抽象类 
  - 要么重写所有的抽象方法

```java
/*
    注意事项
        1 抽象方法和抽象类必须用关键字 abstract
        2 抽象类中可以有抽象方法 , 也可由非抽象方法
          但是抽象方法必须存在抽象类中
          非抽象方法 : 让子类去继承 , 提高代码的复用性
          抽象方法 : 让子类必须完成某些功能(规范)
        3 抽象类不能进行实例化(不能创建对象)
        4 抽象的子类
            要么重写所有的抽象方法
            要么这个子类是一个抽象类

        抽象类虽然不能创建对象 , 但是存在构造方法
        构造方法存在的意义 : 让子类去通过super访问 , 从而给抽象类中的私有变量赋值
 */
public class AnimalTest {
    public static void main(String[] args) {
        // 抽象类不能进行实例化(不能创建对象)
        // Animal a = new Animal();
    }
}
```

```java
// 抽象类案例
public abstract class Animal {
    private String breed;
    private String color;

    public Animal() {
    }

    public Animal(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 抽象方法
    public abstract void eat();

    public void drink(){
        System.out.println("喝水....");
    }
}

```

```java
public class Dog extends Animal{
    public Dog(){
    }

    public Dog(String breed , String color){// breed = "边牧" ,color = "黑白"
        super(breed , color);
    }
    @Override
    public void eat() {
        System.out.println("狗吃骨头!");
    }
}
```

```java
/*
    需求：
    定义猫类（Cat）和狗类（Dog）

	猫类成员方法：eat（猫吃鱼）drink（喝水…）
	狗类成员方法：eat（狗吃肉）drink（喝水…）

	向上抽取父类 :
	    Animal类 : 品种 , 颜色 , eat（);  , drink（）{喝水…}

 */
public class AnimalTest {
    public static void main(String[] args) {
        // 空参构造 + set
//        Dog d1 = new Dog();
//        d1.setBreed("哈士奇");
//        d1.setColor("黑白相间");
//        System.out.println(d1.getBreed() + "---" + d1.getColor());
//        d1.drink();
//        d1.eat();

        // 全参构造
        Dog d2 = new Dog("边牧" , "黑白");
        System.out.println(d2.getBreed() + "---" + d2.getColor());
    }
}

```



## 5 模板设计模式

#### 5.1 设计模式 

- 一套良好的编码风格 , 经过众多的开发人员不断的测试总结而来

#### 5.2 模板设计模式 

- 可以把抽象类 , 看做一个模板 , 非抽象方法理解为模板的通过格式 , 抽象方法是使用者具体完成的业务逻辑

- 模板已经定义好了通用的结构 , 使用者只要关心自己需要的那部分实现的功能即可

```java
public abstract class Template {

    public void write() {
        System.out.println("<<我的爸爸>>");

        // 正文
        body();

        System.out.println("啊~这就是我的爸爸.");
    }

    public abstract void body();
}

public class Tom extends Template {
    @Override
    public void body() {
        System.out.println("那是一个秋天 , 风儿那么缠绵 ,记忆中,那天爸爸骑车送我放学回家 , " +
                "我的脚卡在了自行车链中 , 爸爸蹬不动, 他就站起来蹬!"
        );
    }
}

public class Test {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.write();
    }
}
```

