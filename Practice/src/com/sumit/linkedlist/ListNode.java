package com.sumit.linkedlist;

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
		return " val=" + val;
	}
}

class DoubleListNode {
	int val;
	DoubleListNode next;
	DoubleListNode prev;

	DoubleListNode() {
	}

	DoubleListNode(int val) {
		this.val = val;
	}

	DoubleListNode(int val, DoubleListNode next, DoubleListNode prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}
	@Override
	public String toString() {
		return " val=" + val;
	}
}
