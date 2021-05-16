import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        /**创建哈希表*/
        HashTab hashTab = new HashTab(7);

        /**写一个简单的菜单*/
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();
            switch (key)
            {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    /**创建 雇员*/
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}

/**创建HashTable 管理多条链表*/
class HashTab{
    private EmpLinkedList[] empLinkedListsArray;

    /**表示有多少条链表*/
    private int size;

    /**构造器*/
    public HashTab(int size)
    {
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    /**添加雇员*/
    public void add(Emp emp)
    {
        /**根据员工的id，得到该员工应当添加到那条链表*/

        int empLinkedListNo = hashFun(emp.id);

        /**TODO:1.将emp添加到对应的链表中*/
        empLinkedListsArray[empLinkedListNo].add(emp);
    }

    /**遍历所有的链表，遍历hashtab*/
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    /**TODO:2.根据输入的id，查找雇员*/
    public void findEmpById(int id)
    {
        /**使用散列函数确定到哪条链表查找*/
        int empLinkedListNo = hashFun(id);

        Emp emp = empLinkedListsArray[empLinkedListNo].findEmpById(id);
        if(emp != null)
        {
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNo + 1), id);
        }else
        {
            System.out.println("在哈希表中，没有找到该雇员~");
        }

    }

    /**编写散列函数，使用一个简单的取模法*/
    public int hashFun(int id)
    {
        return id % size;
    }

}

/**表示一个雇员*/
class Emp {
    public int id;
    public String name;

    /**默认是null*/
    public Emp next;

    public Emp(int id,String name)
    {
        super();
        this.id = id;
        this.name = name;
    }
}

/**创建EmpLinkedList 表示链表*/
class EmpLinkedList{
    //头指针，执行第一个Emp，因此我们这个链表的head是指向第一个Emp；
    /**默认是null*/
    private Emp head;

    /**添加雇员到链表
     说明：
     假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
     因此我们将该雇员直接加入到本链表的最后即可
     */
    public void add(Emp emp)
    {
        /**如果是添加第一个雇员*/
        if(head == null)
        {
            head = emp;
            return;
        }

        /**如果不是第一个雇员，则使用一个辅助指针，帮助定位到最后*/
        Emp curEmp = head;
        while (true)
        {
            if(curEmp.next == null)
            {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    /**遍历链表的雇员信息*/
    public void list(int no)
    {
        if(head == null)
        {
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");

        /**辅助指针*/
        Emp curEmp = head;

        while (true)
        {
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null)
            {
                break;
            }

            curEmp = curEmp.next;
        }
        System.out.println();
    }

    /**根据id查找雇员
     * 如果找到就返回Emp，如果没有找到，就返回null
     * */
    public Emp findEmpById(int id)
    {
        if(head == null)
        {
            System.out.println("链表为空");
            return null;
        }

        Emp curEmp = head;
        while (true)
        {
            if(curEmp.id == id)
            {
                break;
            }
            if(curEmp.next == null)
            {
                curEmp = null;
            }
            curEmp = curEmp.next;
        }
        return  curEmp;
    }


}