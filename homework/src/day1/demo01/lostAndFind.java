package day1.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class lostAndFind {
    public static void main(String[] args) throws ParseException {
        Lost[] lostArray= new Lost[5];
        Lost one = new Lost("2013-7-20 20:20","三教");
        Lost two = new Lost("2013-7-27 10:20","二教");
        Lost three = new Lost("2013-7-25 20:20","五教");
        Lost four = new Lost("2012-6-25 20:45","八教");
        Lost five = new Lost("2015-5-4 15:55","二教");


        lostArray[0] = one;
        lostArray[1] = two;
        lostArray[2] = three;
        lostArray[3] = four;
        lostArray[4] = five;

        Solution.sortLost(lostArray);
        System.out.println("=============");
        Scanner sc = new Scanner(System.in);
        String keyword = sc.nextLine();
        Lost[] list = Solution.selectByKeyword(lostArray,keyword);


        for (int i = 0; i < list.length; i++) {
            System.out.println("时间"+list[i].getDate()+"位置"+list[i].getSite());
        }
    }


}


class Solution {

    /**
     * 失物排序方法
     * @param lostArray 待排序的失物数组
     */
    public static void sortLost(Lost[] lostArray) throws ParseException {


            SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm");
            ArrayList<Date> dateList = new ArrayList<>();
            /**
             * 字符串转时间
             */
        for (int i = 0; i < lostArray.length; i++) {
            Lost lost = lostArray[i];
            String str = lost.getDate();
            dateList.add(format.parse(str));
        }
            /**
             * 打印时间
             */
            System.out.println("排序前：");
            for (int i = 0; i < dateList.size(); i++) {
                Date d = dateList.get(i);
                System.out.println("时间"+lostArray[i].getDate()+"位置"+lostArray[i].getSite());
            }
           /**冒泡排序
            */
            Lost tempLost ;
            Date tempDate ;
            for (int i = dateList.size()- 1; i > 0; --i) {
                for (int j = 0; j < i; ++j) {
                    /**
                     * 从大到小的排序
                     */
                    if(dateList.get(j).before(dateList.get(j+1))){
                    tempDate = dateList.get(j);
                    dateList.set(j, dateList.get(j+1));
                    dateList.set(j+1, tempDate);

                        tempLost = lostArray[j];
                        lostArray[j]=lostArray[j+1];
                        lostArray[j+1]=tempLost;
                    }
                }
            }
            /**
             * 打印排序之后的列表
             */

            System.out.println("排序后：");
        for (int i = 0; i < dateList.size(); i++) {
          Date d = dateList.get(i);
            System.out.println("时间"+lostArray[i].getDate()+"位置"+lostArray[i].getSite());
        }
        }



    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    /**
     *遍历数组，比对数组元素中的字符串属性，返回符合条件的数组元素
     */
    public static  Lost[] selectByKeyword(Lost[] lostArray,String keyword){
        int n = 0;
        Lost[] tempLostArray= new Lost[lostArray.length];

        for (int i = 0; i < lostArray.length; i++) {
            Lost lost = lostArray[i];
            String str = lost.getSite();

            if (str.contains(keyword)) {
                tempLostArray[n]=lostArray[i];
                n++;
            }





        }
        System.out.println(n);
        Lost[] newLostArray = new Lost[n];
         System.arraycopy(tempLostArray,0,newLostArray,0,n);
          return newLostArray;
    }


}
