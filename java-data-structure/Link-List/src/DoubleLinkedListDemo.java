public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("双向链表的测试");

        /**先创建节点*/
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        HeroNode2 newHeroNode = new HeroNode2(2,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况：");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();


    }
}


/**创建一个双向链表的类*/
class DoubleLinkedList{
    /**先初始化一个头节点,头结点不要动，不存放具体的数据*/
    private  HeroNode2 head = new HeroNode2(0,"","");

    /**返回头节点*/
    public HeroNode2 getHead(){
        return head;
    }

    /**遍历双向链表的方法，显示链表[遍历]*/
    public void list() {
        /**判断链表是否为空*/
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }

        /**因为是头结点，不能动，因此我们需要一个辅助变量来遍历*/
        HeroNode2 temp = head.next;
        while (true){
            if(temp == null)
                break;
            System.out.println(temp);

            /**将temp后移，一定小心*/
            temp = temp.next;
        }
    }

    /**添加一个节点到双向链表的最后*/
    public void  add(HeroNode2 heroNode2){
        /**因为head节点不能动，因此我们需要一个辅助遍历temp*/
        HeroNode2 temp = head;

        /**遍历链表，找到最后*/
        while (true)
        {
            if(temp.next == null)
            {
                break;
            }
            temp = temp.next;
        }
        /**TODO:1.当退出while循环时候，temp就指向了链表的最后
        形成一个双向链表*/
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    /**修改一个节点的内容，可以看到双向链表的节点内容的修改
     * 和单向链表一样，只是节点类型改成HeroNode2
     */
    public void update(HeroNode2 newHeroNode)
    {
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }

        /**找到需要修改的节点,根据no编号
         * 定义一个辅助变量*/

        HeroNode2 temp = head.next;

        boolean flag = false;

        while(true)
        {
            if(temp == null)
            {
                break;
            }

            if(temp.no == newHeroNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag)
        {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
        else
        {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**TODO:1.在双向链表删除一个节点
     *说明：
     * 1.对于双向链表，我们可以找到要删除的这个节点
     * 2.找到后，自我删除即可
     * */
    public void del (int no)
    {
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;

        boolean flag = false;

        while (true)
        {
            if(temp == null)
            {
                break;
            }
            if(temp.no == no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag)
        {
           temp.pre.next = temp.next;
           if(temp.next != null)
           {
               temp.next.pre = temp.next;
           }
        }else
        {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }
}
/**定义HeroNode2,每个HeroNode对象就就是一个节点*/
class HeroNode2{
    public int no;
    public String name;
    public String nickname;

    /**指向下一个节点，默认为null*/
    public HeroNode2  next;

    /**指向前一个节点，默认是null*/
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no,String name,String nickname)
    {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**为了显示方法，我们重新toString*/
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
