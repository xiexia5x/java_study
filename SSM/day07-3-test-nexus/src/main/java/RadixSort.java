/**
 * @PROJECT_NAME: Java_ssm_spring
 * @DESCRIPTION:
 * @USER: wangqiankun
 * @DATE: 2021/6/17 17:53
 */
public class RadixSort {
    public static void sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组order[i]用来表示该位是i的数的个数
        while(m <= d)//只能三次
        {
            for(int i = 0; i < number.length; i++)
            {
                //第一次运算时,n=1,lsd取的是个位数
                //第二次运算时,n=10,lsd取的是十位数,以此类推
                int lsd = ((number[i] / n) % 10);//个位//十位
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;//个//十//覆盖
            k = 0;
            m++;
        }
    }
    public static void main(String[] args)
    {
        int[]data =
                {278, 109, 63, 930, 589, 184, 505, 269, 8, 83,};
        RadixSort.sort(data, 3);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
}

