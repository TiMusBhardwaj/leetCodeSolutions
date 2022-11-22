package com.sumit.linkedlist;
class MyLinkedList {
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		
		
		list.addAtIndex(0, 10);
		list.addAtIndex(0, 20);
		list.addAtIndex(0, 30);
		list.addAtIndex(0, 40);
		list.addAtIndex(0, 50);
		list.addAtIndex(6, 6);
		list.addAtIndex(3, 33);
		
		list.addAtHead(44);
		list.print();
		list.deleteAtIndex(0);
		list.deleteAtIndex(0);
		list.deleteAtIndex(3);
		list.print();
		System.out.println(list.get(3));
	}
	
	private void print() {
		DoubleListNode cuNode = dummyHead;
		while(cuNode.next !=null) {
			System.out.print("-- " + cuNode.next.val);
			cuNode = cuNode.next;
		}
		System.out.println();
	}
	
	DoubleListNode dummyHead;
	DoubleListNode dummyTail;

    public MyLinkedList() {
    	
    	dummyHead = new DoubleListNode(-1);
    	dummyTail = new DoubleListNode(-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int index) {
    	DoubleListNode cuNode = dummyHead;
    	while (index-- >= 0 && cuNode.next !=null) {
			cuNode = cuNode.next;
		}
        return cuNode.val;
    }
    
    public void addAtHead(int val) {
    	
    	DoubleListNode node = new DoubleListNode(val);
    	node.next = dummyHead.next;
    	node.prev = dummyHead;
    	dummyHead.next.prev = node;
    	dummyHead.next = node;
        
    }
    
    public void addAtTail(int val) {
        
    	DoubleListNode node = new DoubleListNode(val);
    	node.prev = dummyTail.prev;
    	node.next = dummyTail;
    	dummyTail.prev.next = node;
    	dummyTail.prev = node;
    	
    	
    }
    
    public void addAtIndex(int index, int val) {
    	DoubleListNode cuNode = dummyHead;
    	while (index-- > 0 && cuNode.next !=null) {
			cuNode = cuNode.next;
		}
    	if (cuNode.next !=null) {
    		DoubleListNode node = new DoubleListNode(val);
    		node.next = cuNode.next;
    		node.prev = cuNode;
    		cuNode.next.prev = node;
    		cuNode.next = node;
    	}
    }
    
    public void deleteAtIndex(int index) {
    	
    	DoubleListNode cuNode = dummyHead;
    	while (index-- > 0 && cuNode.next !=null) {
			cuNode = cuNode.next;
		}
    	if (cuNode.next !=null && cuNode.next.next !=null) {
    		cuNode.next = cuNode.next.next;
    		cuNode.next.prev = cuNode;
    	}
        
    }
}