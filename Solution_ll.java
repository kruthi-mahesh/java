import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution_ll
{
    public static Node removeDuplicates(Node head) {
    // if head is null or list only has 1 element
    if( head == null || head.next == null){
        return head;
    }

    // if list is more than 2 elements
    Node current = head;
    while( current.next != null ){
        // If current is a duplicate of previous
        if( current.data == current.next.data ){
            // set previous' next pointer to skip over current node
            current.next = current.next.next;
        }
        else{ // node is not duplicate of previous
            current = current.next;
        }
    }
    return head;
}
    public static Node removeDuplicates(Node head) {
    // if head is null or list only has 1 element
    if( head == null || head.next == null){
        return head;
    }

    // if list is more than 2 elements
    Node current = head;
    while( current.next != null ){
        // If current is a duplicate of previous
        if( current.data == current.next.data ){
            // set previous' next pointer to skip over current node
            current.next = current.next.next;
        }
        else{ // node is not duplicate of previous
            current = current.next;
        }
    }
    return head;
}