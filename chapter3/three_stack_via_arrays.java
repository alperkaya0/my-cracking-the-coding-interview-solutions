public class three_stack_via_arrays {
    public static void main(String[] args) {
        FixedStacks fixedStacks = new FixedStacks(3, 10);
        fixedStacks.push(1, 1);
        fixedStacks.push(2, 1);
        fixedStacks.push(3, 1);
        fixedStacks.push(4, 1);
        fixedStacks.push(5, 1);
        fixedStacks.push(6, 1);
        fixedStacks.push(7, 1);
        fixedStacks.push(8, 1);
        fixedStacks.push(9, 1);
        fixedStacks.push(10, 1);
        fixedStacks.push(1, 2);
        fixedStacks.push(2, 2);
        fixedStacks.pop(2);
        System.out.println(fixedStacks.pop(2));
        printarr(fixedStacks.values);
        printarr(fixedStacks.sizes);
    }
    public static void printarr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(i != arr.length - 1 ? (arr[i] + ", ") : (arr[i]));
        }
        System.out.println("]");
    }
}

class FixedStacks {
    int stack_num = 3;
    int stack_size;
    int[] values;
    int[] sizes;

    FixedStacks(int stack_num, int stack_size) {
        this.stack_num = stack_num;
        this.stack_size = stack_size;
        this.values = new int[stack_num * stack_size];
        this.sizes = new int[stack_num];
    }

    public int indexoftop(int stack_num) {
        int offset = stack_size * (stack_num - 1);
        int idx = offset + sizes[stack_num - 1] - 1;
        return idx;
    }

    public void push(int item, int stack_num) {
        if (this.isFull(stack_num)) {
            throw new StackOverflowError("Stack is full!");
        } else {
            sizes[stack_num - 1]++;
            int idx = indexoftop(stack_num);
            values[idx] = item;
        }
    }

    public boolean isFull(int stack_num) {
        return sizes[stack_num - 1] == stack_size;
    }

    public boolean isEmpty(int stack_num) {
        return sizes[stack_num - 1] == 0;
    }

    public int pop(int stack_num) {
        if (!isEmpty(stack_num)) {
            int res = values[indexoftop(stack_num)];
            values[indexoftop(stack_num)] = 0;
            sizes[stack_num - 1]--;
            return res;
        } else {
            throw new StackOverflowError("Stack is empty!");
        }
    }

    public int peek(int stack_num) {
        if (!isEmpty(stack_num)) {
            return values[indexoftop(stack_num)];    
        } else {
            throw new StackOverflowError("Stack is empty!");
        }
    }
}