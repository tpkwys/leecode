package com.aaron.demo;

/**
 * @program: leecode
 * @description: 两数相加
 * @author: tianpanke
 * @create: 2020-05-18
 **/
public class Algorithm2 {
    /**
     * desc:给出两个非空的链表用来表示两个非负的整数。其中，
     * 它们各自的位数是按照逆序的方式存储，并且 它们的每个
     * 节点只能存储一位数字。如果，我们将这两个数相加起来，
     * 则返回一个新的链表来表示它们的和。您可以假设这两个数除了
     * 不会以0开头。
     */
    class ListNode{
        int  val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public static void main(String[] args) {

    }

    /**
     *algorithm:链表简单遍历;注意遍历结束条件和进位
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(max(m,n))
     */
    public ListNode addTwoNumbers(ListNode node1,ListNode node2){
       ListNode head=null;
       ListNode temp=null;
       int forward=0;
        while (node1!=null||node2!=null||forward>0){
            int value1=0;
            int value2=0;
            if(node1!=null){
                value1=node1.val;
                node1=node1.next;//指针后移
            }
            if(node2!=null){
                value2=node2.val;
                node2=node2.next; //指针后移
            }
            int curr=(value1+value2+forward)%10;
            ListNode newNode=new ListNode(curr);
            if(head==null){//第一个节点求值
                head=newNode;
                temp=newNode;
            }else {//后续节点求值
                temp.next=newNode;
                temp=newNode;
            }
            forward=(value1+value2+forward)/10;
        }
        return head;
    }
}
