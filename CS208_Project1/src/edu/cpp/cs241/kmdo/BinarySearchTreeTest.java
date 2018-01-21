package edu.cpp.cs241.kmdo;

import java.util.Scanner;

public class BinarySearchTreeTest
{

    public static void main(String[] args)
    {
	System.out.println("Please enter the intial sequence of variables:");
	Scanner userInput = new Scanner(System.in);
	String input = "";
	input = userInput.nextLine();
	System.out.println(input);
	String[] userVariables = input.split(" ");
	
	BinarySearchTree<String> tree = new BinarySearchTree<>(null);
	for(int i = 0; i < userVariables.length; i++)
	    tree.addEntry(userVariables[i]);
	System.out.println("Inorder: ");
	tree.inorderTraverse();
	userInput.close();
    }
}