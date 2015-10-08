package test;

/* This program is used to perform merge sort on linkedList */

public class MergeSortLinkedList {

	private static class linkedList{
		int data;
		linkedList next;
	}
	
	public static void main(String[] args) {
		linkedList listNode = new linkedList();
		listNode.data = 9;

		listNode.next = new linkedList();
		listNode.next.data = 8;

		listNode.next.next = new linkedList();;
		listNode.next.next.data = 7;

		listNode.next.next.next = new linkedList();
		listNode.next.next.next.data = 6;

		listNode.next.next.next.next = new linkedList();
		listNode.next.next.next.next.data = 5;

		listNode.next.next.next.next.next = new linkedList();
		listNode.next.next.next.next.next.data = 4;

		listNode.next.next.next.next.next.next = new linkedList();
		listNode.next.next.next.next.next.next.data = 3;


		listNode = partitionList(listNode);
		printList(listNode);
	}

	private static linkedList partitionList(linkedList startNode) {
		if(startNode.next == null)
			return startNode;
		linkedList tortoise = startNode;
		linkedList hare = startNode;
		linkedList prevTortoise = null; 
		while(hare!=null){
			if(hare.next != null){
				hare = hare.next.next;
				prevTortoise = tortoise;
				tortoise = tortoise.next;
			}
			else hare = null;
		}
		prevTortoise.next = null;
		startNode = partitionList(startNode);
		tortoise = partitionList(tortoise);
		return mergeParts(startNode,tortoise);
	}
	
	private static linkedList  addDataToLinkedList(linkedList mergeList,linkedList Node){
		if(mergeList == null){
			mergeList = Node;
		}
		else{
			mergeList.next = Node;
			mergeList = mergeList.next;
		}
		mergeList.next = null;
		return mergeList;
	}

	private static linkedList mergeParts(linkedList startNode,linkedList lastNode) {

		linkedList mergeList = null;
		linkedList start = null;
		while(startNode!=null && lastNode!=null){
			if(startNode.data > lastNode.data){
				linkedList temp = lastNode;
				lastNode = lastNode.next;
				mergeList = addDataToLinkedList(mergeList,temp); 
				
			} else {
				linkedList temp = startNode;
				startNode = startNode.next;
				mergeList = addDataToLinkedList(mergeList,temp); 
			}
			if(start == null)
				start = mergeList;
		}
		
		if(startNode!=null){
			mergeList.next = startNode;
		}
		
		if(lastNode!=null){
			mergeList.next = lastNode;
		}

		return start;
	}

	private static void printList(linkedList listNode) {

		while(listNode != null){
			System.out.println(listNode.data );
			listNode = listNode.next;
		}

	}

}
