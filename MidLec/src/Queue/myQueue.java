package Queue;

class myQueue {

    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int numberOfItems;

    //constructor
    public myQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        numberOfItems = 0;
    }

    //insert an item to queue
    public void enQueue(int i) {
        //increment rear and insert item
        if(numberOfItems==0){
            queueArray[numberOfItems] = i;
        }
        else
        {
            for(int j=numberOfItems-1; j>=0; j--)
            {
                if(i > queueArray[j])
                {
                    queueArray[j+1] = queueArray[j];

                }
                else
                {
                    break;

                }

            }
            queueArray[++rear] = i;
            int nItems = 0;
            nItems++;
        }
    }

    //remove an item from queue
    public int deQueue() {
        //return item and decrement count
        return queueArray[--numberOfItems];
    }

    //view item from top of stack
    public int peek() {
        return queueArray[numberOfItems-1];
    }

    //check if stack is empty
    public boolean isEmpty() {
        return (numberOfItems == 0);
    }

    //check if stack is full
    public boolean isFull() {
        return (numberOfItems == maxSize);
    }
}

