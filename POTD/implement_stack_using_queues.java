package LeetCode.POTD;

import java.util.*;
public class implement_stack_using_queues {
    Queue<Integer> q;

    public implement_stack_using_queues() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int size = q.size();
        int temp = -1;

        while(size != 0)
        {
            temp = q.remove();
            size--;
            if(size!= 0)
            {
                q.add(temp);
            }
        }

        return temp;
    }

    public int top() {
        int size = q.size();
        int temp = -1;

        while(size != 0)
        {
            temp = q.remove();
            size--;
            q.add(temp);
        }

        return temp;
    }

    public boolean empty() {
        return q.isEmpty() ? true : false;
    }
}
