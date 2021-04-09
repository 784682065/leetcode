class Solution24 {

    public static void main(String[] args) {

        //head = [1,2,3,4]
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;

        Solution24 solution24 = new Solution24();

        head = solution24.swapPairs1(head);
        System.out.printf(head.toString());
    }


    /**
     * 设置one two 互换， three作为下一个节点在递归
     * @param head 需要交换的
     * @return 交换后的listNode
     */
    public ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs2(three);

        return two;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;


            temp.next = node2;   // 对next的更改会影响到原先的ListNode

            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }

        return dummyHead.next;
    }


    public ListNode swapPairs(ListNode head) {

        // 没有元素或者只有一个元素则直接交换
        if (head == null || head.next == null) return head;


        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 位置指针位置初始化
        ListNode point = dummyHead;

        ListNode fir, sec;
        while (point.next != null) {
            // 节点做交换
            fir = point.next;

            sec = point.next.next;
            if (sec == null) {
                //说明是奇数个node 最后一个不需要交换
                break;
            }

            // 衔接未曾迁移的
            point.next = sec;

            // 交换两个元素
            fir.next = sec.next;
            sec.next = fir;

            //移动位置
            point = fir;

        }

        return dummyHead.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
