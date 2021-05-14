import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Stack;

public class SingleLinkedListDemo{
    public static void main(String[] args) {
        /**进行测试 先创建节点*/

        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        /**创建要给链表*/
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        /**加入*/
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        /**测试一下单链表的反转功能*/
        System.out.println("原来链表的情况~");
        singleLinkedList.list();

        /**反转单链表*/
      /*  System.out.println("反转单链表~~");
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();*/

        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        reversePrint(singleLinkedList.getHead());

       /* //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示一把
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~~");
        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
        singleLinkedList.list();

        //测试一下 求单链表中有效节点的个数
        System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2

        //测试一下看看是否得到了倒数第K个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println("res=" + res);
*/
    }
    /**查找单链表中的倒数第k个节点[新浪面试题]
     * 思路:
     * 1.编写一个方法，接收head个节点，同时接收一个index
     * 2.index表示的是倒数第index个节点
     * 3.先把链表从头到尾遍历，得到链表的总长度getLength
     * 4.得到size后，我们从链表的第一个开始遍历(size-index)个，就可以得到
     * 5.如果找到了，则返回该节点，否则返回null
     * */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next == null)
        {
            return null;
        }

        /**第一个遍历得到链表的长度(节点个数)*/
        int size = getLength(head);

        /**
         *第二次遍历,size-index位置，就是我们倒数的第k个节点
         * 先做一个index的校验
         */
        if(index <= 0 || index > size)
        {
            return null;
        }

        /**
         * 定义给辅助变量，for循环定义到倒数的index
         */
        HeroNode cur = head.next;
        for(int i = 0; i <size - index;i++)
        {
            cur = cur.next;
        }
        return  cur;

    }

    /**
     * 获取到单链表的节点个数(如果是带头结点的链表。需求不统计头结点)
     */
    public static int getLength(HeroNode head)
    {
        if(head.next == null) {
            return 0;
        }

        int length = 0;

        /**定义一个辅助的变量，这里我们没有统计头节点*/
        HeroNode cur = head.next;
        while (cur != null)
        {
            length++;
            cur = cur.next;
        }
        return length;
    }
    /**方式二:
     * 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点
     * 就实现了逆序打印的效果
     * */
    public static void reversePrint(HeroNode head){
        if (head.next == null)
        {
            /**空链表，不打印*/
            return;
        }

        /**创建要给一个栈，将各个节点压入到栈*/
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        /**将链表的所有节点压入栈*/
        while(cur != null)
        {
            stack.push(cur);

            /**cur后移，这样就可以压入下一个节点了*/
            cur = cur.next;
        }

        /**将栈中的节点进行打印，pop出栈*/
        while (stack.size() > 0)
        {
            /**stack的特点是先进先出*/
            System.out.println(stack.pop());
        }
    }

    /**将单链表反转*/
    public static void reversetList(HeroNode head){
        /**如果当前链表为空，或者只有一个节点，无需反转，直接返回*/
        if(head.next  == null || head.next.next == null)
        {
            return;
        }

        /**定义一个辅助的指针(变量)，帮助我们遍历原来的链表*/
        HeroNode cur = head.next;

        /**指向当前节点[cur]的下一个节点*/
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0,"","");

        /**遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的
         * 最前端
         */
        while (cur != null)
        {
            /**先暂时保存当前节点的下一个节点，因为后面需要使用*/
            next = cur.next;

            /**将cur的下一个节点指向新的链表的最前端*/
            cur.next = reverseHead.next;

            /**将cur连接到新的链表上*/
            reverseHead.next = cur;

            /**让cur后移*/
            cur = next;
        }

        /**将head.next指向reverseHead.next 实现单链表的反转*/
        head.next = reverseHead.next;
    }
}

/**定义SingleLinkedList管理我们的英雄*/
class SingleLinkedList {

    /**先初始化一个头结点,头结点不要动,不存放具体数据*/
    private HeroNode head = new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    /**添加节点到单向链表
     * 思路：当不考虑编号顺序的时候
     * 1.找到当前链表的最后节点
     * 2.讲最后节点的next指向新的节点
     * */
    public void add(HeroNode heroNode)
    {
        //TODO:1.因为head节点不能动，因此我们需要一个复辅助遍历temp;
        HeroNode temp = head;
        while (true){
            /**遍历链表,找到最后*/
            if(temp.next == null){
                break;
            }
            /**如果没有找到最后，将temp后移*/
            temp = temp.next;
        }
        //TODO:2.当退出while循环时候，temp就指指向了链表的最后
        /**将最后节点的next指向新的节点*/
        temp.next = heroNode;
    }

    //TODO:3.第二种方式在添加英雄前，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode)
    {
        /**
         * 因为头节点不能动，因此我们任然通过一个辅助指针(变量)来帮助找到添加
         * 的位置，因为是单链表，因此我们找的temp是位于位置的前一个节点，否则插入不了
         * */
        HeroNode temp = head;
        /**flag标记添加的编号是否存在，默认是false*/
        Boolean flag = false;

        /**说明temp已经在链表的最后*/
        while (true) {
            if(temp.next == null){
                break;
            }
            /**位置找到，就在temp的后面插入*/
            if(temp.next.no > heroNode.no) {
                break;
            }
            else if(temp.next.no == heroNode.no){
             /**说明编号已经存在*/
             flag = true;
             break;
            }
            /**后移遍历链表*/
            temp = temp.next;

            /**判断flag的值*/
            if(flag){
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
            }
            else
            {
                /**插入到链表中，temp的后面*/
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }
    }

    /**TODO:4.修改节点的信息，根据no编号来修改，即no编号不能改
    说明：根据newHeroNode的no来修改*/

    public void update(HeroNode newHeroNode)
    {
        /**判断是否为空*/
        if (head.next == null)
        {
            System.out.println("链表为空");
            return;
        }

        /**找到需要修改的节点，根据no编号，定义一个辅助变量*/
        HeroNode temp = head.next;
        /**表示是否找到该节点*/
        boolean flag = false;

        while (true)
        {
            if(temp == null)
            {
                /**已经遍历完链表*/
            }
            if(temp.no == newHeroNode.no)
            {
                /**找到*/
                flag = true;
                break;
            }
            temp = temp.next;
        }

        /**根据flag判断是否找到要修改的节点*/
        if(flag)
        {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else
        {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }

    }

    /**TODO:5.删除节点
     * 思路：
     * 1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2.说明我们在比较时，是temp.next.no和需要删除的节点的no比较
     * */
    public void del(int no){
        HeroNode temp = head;

        /**标志是否找到待删除节点*/
        boolean flag = false;
        while (true){
            if(temp.next == null)
            {
                break;
            }
            if(temp.next.no == no){
                /**找到待删除节点的前一个节点temp*/
                flag = true;
                break;
            }
            temp = temp.next;
        }

        /**判断flag*/
        if(flag)
        {
            temp.next = temp.next.next;
        }
        else{
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**TODO:6.遍历链表 */
    public void list()
    {
        /**判断链表是否为空*/
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }

        /**因为头节点，不能动，因此我们需要一个辅助变量来遍历*/
        HeroNode temp = head.next;
        while (true)
        {
            /**判断是否到链表最后*/
            if(temp == null )
            {
                break;
            }

            /**输出节点的信息*/
            System.out.println(temp);

            /**将temp后移，一定小心*/
            temp = temp.next;
        }
    }

}

/**定义HeroNode,每个HeroNode对象就是一个节点*/
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    /**指向下一个节点*/
    public HeroNode next;

    //构造器
    public HeroNode(int no,String name,String nickname)
    {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法：我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
