package linkedlist;

import java.util.Scanner;

public class SingletonLinkedList {

	class Node{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	public static Node Head;
	public static Node Tail;
	public static int Size = 0;
	public void addFirst(int data)
	{
		Node newNode = new Node(data);
		if(Head == null)
		{
			Tail = Head = newNode;
			Size++;
			return;
		}
		newNode.next = Head;
		Head = newNode;
		Size++;

	}
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		if(Head == null)
		{
			Tail = Head = newNode;
			Size++;

			return;
		}
		Tail.next = newNode;
		Tail = newNode;
		Size++;

	}
	public void addAtIndex(int index,int data)
	{	
		Node newNode = new Node(data);
		if(Head == null)
		{
			Tail = Head = newNode;
			Size++;
			return;
		}
		if(index > Size)
		{
			System.out.println("Invalid Index");
			return;
		}
		Node temp = Head;
		int i = 0; 
        while(i<index-1)
        {
        	temp = temp.next;
        	i++;
        }
        newNode.next = temp;
        temp.next = newNode;
        Size++;
		
	}
	public static void print()
	{
		Node temp = Head;
		int i = 0; 
        while(i<Size)
        {
        	System.out.print(temp.data + "-> ");
        	temp = temp.next;
        	i++;
        }
        System.out.println();
//        System.out.println(Tail.next);
	}
	public static int search(int data)
	{
		int key = data;
		int i = 0;
		Node temp = Head;
		while(i<Size)
		{
			if(key == temp.data)
			{
				return i;
				
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}
	public static void removeFirst()
	{
		if(Head == null)
		{
			System.out.println("Empty LinkedList");
			return;
		}
		Node val = Head;
		Head = Head.next;
		System.out.println("Removed " + val.data);
	}
	public static void removeLast()
	{
		if(Head == null)
		{
			System.out.println("Empty LinkedList");
			return;
		}
		Node val = Tail;
		Node temp = Head.next;
		int i = 0;
		while(i<Size-2)
		{
			temp = temp.next;
			i++;
		}
		Tail = temp;
		Tail.next = null;
		System.out.println("Removed " + val.data);
	}
	public static void main(String [] arg)
	{
		SingletonLinkedList ll = new SingletonLinkedList();
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		while(exit != true)
		{
			System.out.println("1.AddFirst\n2.AddLast\n3.AddAtIndex\n4.RemoveFirst\n5.ReomveLast\n6.PrintLinkedList\n7.SearchByValue\n0.Exit");
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter Value");
				ll.addFirst(sc.nextInt());
				break;
			case 2:
				System.out.println("Enter Value");
				ll.addLast(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter Index And Value");
				ll.addAtIndex(sc.nextInt(), sc.nextInt());

				break;
			case 4:
				ll.removeFirst();
				break;
			case 5:
				ll.removeLast();
				break;
			case 6:
				ll.print();
				break;
			case 7:
				System.out.println("Enter Key");
				ll.search(sc.nextInt());
				break;
			case 0:
				exit = true;
				System.out.println("Thank You");
				break;
			}
		}
		
		
	}
}
