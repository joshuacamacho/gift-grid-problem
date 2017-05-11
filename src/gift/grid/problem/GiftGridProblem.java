/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift.grid.problem;

import java.util.LinkedList;

/**
 *
 * @author Josh
 */
public class GiftGridProblem {
 static int R = 5, C = 5;
static int memo[][] = new int[R][C];
static int curMax=0;
static LinkedList<String> dir;
static String[][] directions = new String[R][C];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dir=new LinkedList<String>();
        for (int r=0 ; r != R ; r++){
            for (int c = 0 ; c != C ; c++){
                memo[r][c] = -1;
                directions[r][c]="";
            }
                
        }   
        int field[][] = {
            {1,    50,100,3,4},
            {10000, 90, 20,3,10},
            {1,2,9002,1,2},
            {1,2,3,4,5},
            {1,2,3,4,5}
        };
        
         int res = max(0, 0, field);
         System.out.println("\n"+res);
         
         for(int i=0; i<dir.size(); i++){
             System.out.println(dir.get(i));
         }
         System.out.println(directions[0][0]);
         for (int r=0 ; r != R ; r++){
            for (int c = 0 ; c != C ; c++){
                System.out.print(memo[r][c]+" ");
                System.out.print(directions[r][c]+" ");
            }
           System.out.println("\n");
        } 
    }
   


    public static int max(int r, int c, int[][] field) {
        if(r==R || c==C ) return 0; 
        if (memo[r][c] != -1) {
            System.out.println("\nBASECASE r was "+r+" c was "+c+"memo was "+memo[r][c]);
            return memo[r][c];
        }
        int down = 0, right = 0;
        if (r != R) down = max(r+1, c, field);
        if (c != C) right = max(r, c+1, field);
        int m = Math.max(down, right);
        
//        System.out.print("\nr is "+r +" c is "+c);
//        
//            System.out.print(" Down was " +down);
//        
//            System.out.print("\n Right was " +right);
//            System.out.print("\nm wwas "+m);
        memo[r][c] = (field[r][c] + m);
        String dire="";
        if(m==down) dire="Down";
        else if(m==right) dire="Right";
        directions[r][c]=directions[r][c].concat(dire+ " ");
//        System.out.println("\nmemo[r][c] was+" +memo[r][c]);
//        if(true){
//            if(curMax<memo[r][c]){
//                curMax=memo[r][c];
//                if(down>right) dir.push("Down");
//                if(right>down) dir.push("Right");
//            }
//        }
        return memo[r][c];
    }
    
    

}
