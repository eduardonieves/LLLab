package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	private int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		((SNode<E>) nuevo).setNext(first); 
		first = (SNode<E>) nuevo; 
		if(length == 0)
			last = first;
		length++; 

	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(target == last)
			last = (SNode<E>) nuevo;
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo);
		length++; 

	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if (target == first)
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = findNodePrevTo(target);  
			this.addNodeAfter(prevNode, nuevo); 
		}

	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (first == null)
			throw new NoSuchElementException("getFirstNode() : linked list is empty..."); 

		// the linked list is not empty....
		return first;

	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (last == null)
			throw new NoSuchElementException("getLastNode(): Empty list."); 
			
		// the linked list is not empty....
		return last; 

	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (target == last)  
			throw new NoSuchElementException("getNextNode(...) : target is the last node."); 
		else 
			return ((SNode<E>) target).getNext();

	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (target == first)  
			throw new NoSuchElementException("getPrevNode(...) : target is the first node."); 
		else 
			return findNodePrevTo(target);

	}

	public int length() {
		// TODO Auto-generated method stub
		return this.length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		if(target == first){
			first = first.getNext();
//			first.setNext(first.getNext());
		}else{
		
		SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
		prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		length--; 

	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}
	
	public Node<E> findNodePrevTo(Node<E> target) {
		// Pre: target is a node in the list
		if (target == first) 
			return null; 
		else { 
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}



}
