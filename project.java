/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningtree;

import java.util.Scanner;

/**
 *
 * @author kashif
 */
public class LearningTree {
    //MAIN HEAD OF TREE 
    node root;
    
    
    
   
    //CREATES NODES
    public void addNode(int key,String name){
        node newNode=new node(key,name);
        // IF ROOT IS NULL WE ASSIGN THE NODE THAT WE HAVE JUST CREATED AS ROOT NODE
        if(root==null){
            root=newNode;
            //THE MAIN MAGIC HAPPENS HERE
        }else{
            //SO NOW WE HAVE CREATED A NEW NODE(NODE IS BASICALLY LIKE A NEW ELEMENT )
            node focusnode=root;
            node parent;
            
            while(true){
                parent=focusnode;
                if(key<focusnode.key){
                    focusnode=focusnode.rightchild;
                if(focusnode==null){
                    parent.rightchild=newNode;
                    return;
                }
                }else{
                    focusnode=focusnode.leftchild;
                    if(focusnode==null){
                        parent.leftchild=newNode;
                        return;
                    }
                }
            }
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public void inorderTraverseTree(node focusnode){
        if(focusnode!=null){
            inorderTraverseTree(focusnode.leftchild);
            System.out.println(focusnode);
            inorderTraverseTree(focusnode.rightchild);
            
        }
    }
    /*private node findnode(String val){
        String value=val;
        node focusnode =root;
        node parentnode;
        parentnode=focusnode;
        String str="";
        while(focusnode.key!=0){
            if(value!=focusnode.name){
                findnode(value);
                focusnode=focusnode.leftchild;
                
                str=str+"0";
                
                
            }else if(value==focusnode.name){
                
                System.out.println(str);
            }
           
        }
        return focusnode;
    }*/
    private static void generateCodes(node node, String s) {
        if (node != null) {
            if (node.rightchild != null)
                generateCodes(node.rightchild, s + "1");

            if (node.leftchild != null)
                generateCodes(node.leftchild, s + "0");

            if (node.leftchild == null && node.rightchild == null)
                codes.put(node.character.charAt(0), s);
        }
    }
    public static void main(String[] args) {
         LearningTree tree=new LearningTree();
         node node=new node(10,"k");
         generateCodes(node,"k");
        String encode;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter sentence to encode");
        encode=scan.next();
         String str=encode;
         int spaceCount=0;
         int l=encode.length();
          int count=0;
          for(int i=0;i<str.length();i++)
          if(str.charAt(i)==' '){
              spaceCount++;
          }
          
          char ch;
        for(char i='a'; i<='z'; i++)
            {
                count = 0;
                for(int j=0; j<l; j++)
                {
                    ch=encode.charAt(j); //extracting characters of the string one by one
                    if(ch==i) //first checking the whole string for 'a', then 'b' and so on
                        count++;
                    //increasing count of those aplhabets which are present in the string
                   
                    
                }
                if(count!=0)//printing only those alphabets whose count is not '0'
                {
                    System.out.println(i+"\t\t"+count);
                    String val = String.valueOf(i);
                    tree.addNode(count,val);
                }    
        // TODO code application logic here

            }
        
        
       tree.addNode(spaceCount, "space");
       /* tree.addNode(15, "police officer");
        tree.addNode(40, "custom officer");*/
        tree.inorderTraverseTree(tree.root);
       // tree.findnode("k");
    }
    
}
// NODE CLASS TO MAKE TREE
class node{
    int key;
    String name;
    //two childs because we can only move in two directions in tree left and right 
    node leftchild;
    node rightchild;
  //CONSTRUCTOR TO MAKE NODES  
    node(int key,String name){
        this.key=key;
        this.name=name;
    }
    
    public String toString(){
        return name +"name has"+key;
    }
}
