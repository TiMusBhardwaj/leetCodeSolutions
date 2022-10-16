package com.sumit.array;

public class MyHashMapImpl {
	
	
	public static void main(String[] args) {
		
		MyHashMap map = new MyHashMap();
		map.put(1, 1);
		map.put(1, 2);
		map.put(2, 3);
		System.out.println(map.get(6));
		map.put(2, 4);
		map.put(3, 7);
		System.out.println(map.get(2));
		map.remove(2);
		System.out.println(map.get(3));
		
		
	}
	
	static class MyHashMap {
		
		ListNode [] nodes = new ListNode[100000];

	    public MyHashMap() {
	        
	    	
	    }
	    
	    public void put(int key, int value) {
	        
	    	int index = getIndex(key);
	    	ListNode node = nodes[index];
	    	if (node == null) {
	    		node = new ListNode(-1, -1);
	    		nodes[index] = node;
	    	}
	    	node = findNode(node, key);
	    	if (node.next == null) {
	    		node.next = new ListNode(key, value);
	    	}else 
	    		node.next.val = value;
	    }
	    
	    public int get(int key) {
	    	
	    	int index = getIndex(key);
	    	ListNode node = nodes[index];
	    	if (node == null) {
	    		return -1;
	    	}
	    	node = findNode(node, key);
	    	if (node.next == null) {
	    		return -1;
	    	}
	    	return node.next.val;
	        
	    }
	    
	    public void remove(int key) {
	        
	    	int index = getIndex(key);
	    	ListNode node = nodes[index];
	    	if (node == null) {
	    		return ;
	    	}
	    	node = findNode(node, key);
	    	if (node.next !=null) {
	    		node.next = node.next.next;
	    	}
	    }
	    
	    private int getIndex(int key) {
	    	
	    	return Integer.hashCode(key) % nodes.length;
	    }
	    
	    private ListNode findNode(ListNode node, int key) {
	    	
	    	while(node.next !=null && node.next.key != key) {
	    		node = node.next;
	    	}
	    	return node;
	    }
	    
	    class ListNode{
            int key, val;
            ListNode next;

            ListNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
	}

	

}
