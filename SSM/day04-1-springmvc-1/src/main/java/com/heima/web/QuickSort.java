package com.heima.web;

import java.util.Arrays;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={5,2,7,9,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr ,int low,int high){
        if(low<high){
            int i=low,j=high,p=arr[low];
            while(i<j){
                while(i<j&&arr[j]>=p){
                    j--;
                }
                if(i<j){
                    arr[i++]=arr[j];
                }
                while (i<j&&arr[i]<=p) {
                    i++;
                }
                if(i<j){
                    arr[j--]=arr[i];
                }
            }
            arr[i]=p;
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);
        }

    }
}
