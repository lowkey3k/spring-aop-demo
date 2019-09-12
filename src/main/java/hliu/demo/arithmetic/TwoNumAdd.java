package hliu.demo.arithmetic;

/**
 * @author LiHaitao
 * @description TwoNumAdd:
 * @date 2019/9/10 14:54
 **/
public class TwoNumAdd {
    public static void main(String[] args) {


    }

    @SuppressWarnings("all")
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num2 + num1 + temp;
            temp = sum >= 10 ? 1 : 0;
            int a = sum % 10;
            node.next = new ListNode(a);
            node = node.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                if (temp == 1) {
                    node.next = new ListNode(temp);
                }
            }
        }
        return head.next;
    }
       /* ListNode node;
        int temp = 0;
        int a = l1.val + l2.val;
        if (a >= 10) {
            temp = 1;
        }
        int a1 = a % 10;
        node = new ListNode(a1);
        l1 = l1.next;
        l2 = l2.next;
        ListNode head = node;

        while (l1 != null || l2 != null) {

            int a2 = l1.val + l2.val + temp;
            int a3 = a2 % 10;

            node.next = new ListNode(a3);
            System.out.println(node.val);
            node = node.next;
            temp = 0;
            if (a2 >= 10) {
                temp = 1;
            }


            if (l1.next != null) {
                l1 = l1.next;
            } else {
                l1.val = 0;
            }
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                l2.val = 0;
            }

        }
        if (temp == 1) {
            node.next = new ListNode(temp);
        }
        return head;
    }*/
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}



