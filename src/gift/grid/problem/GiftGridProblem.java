/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift.grid.problem;


import java.util.HashMap;

import java.util.Map;
import java.util.Random;


/**
 *
 * @author Josh
 */
public class GiftGridProblem {

static Map dirMap; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dirMap = new HashMap<String, String>();
       
        Random rand = new Random();

        int size=10;
        int field[][]= new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                field[i][j]=rand.nextInt(size*4);
            }
        }
       
        print(field);
         int max = getMaxValue(field);
         System.out.println("\nMaximum Path Value: "+max);
//         System.out.println("------Path-------");
//         printRoute(dirMap);
        
//// 
    }

   public static void print(int[][] array){
       int rows=array.length;
       int columns=array[0].length;
            for(int i = 0; i<rows; i++)
     {
         for(int j = 0; j<columns; j++)
         {
             System.out.printf("%8s",array[i][j]);
         }
         System.out.println();
     }
   }

     public static int getMaxValue(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;
 
        int[] maxValues = new int[cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                int left = 0;
                int up = 0;
                int diag=0;
                if(i > 0) {
                    up = maxValues[j];
                }
 
                if(j > 0) {
                    left = maxValues[j - 1];
                }
                //Diagonal would never give optimal path
                
                String di="";
                int m = Math.max(left, up);
                int o=i;
                int p=j;
                if(left != 0 && left==m){
                    di="right";
                    p--;
                }else if(up!=0){
                    di="down";
                    o--;
                }
                dirMap.put("("+o+","+p+")", di+ " to ("+i+","+j+")");
               System.out.println("("+o+","+p+")"+ di+ " to ("+i+","+j+")");
                maxValues[j] = Math.max(left, up) + values[i][j];
            }
        }
        
        return maxValues[cols - 1];
    }

    private static void printRoute(Map dirMap) {
        
        System.out.println("(0,0) "+ dirMap.get("(0,0)"));
        String full = (String) dirMap.get("(0,0)");
        String coord = full.substring(full.length() - 5);
        int count=1;
        while(dirMap.containsKey(coord)){
            
            full = (String) dirMap.get(coord);
            System.out.println(coord +" "+ full);
//            int offset=5;
            
//            if(count>8) offset=6;
//            System.out.println(StringUtils.substringAfterLast(path, "/"))
            coord = full.substring(full.length()-5);
//            count++;
            if(!dirMap.containsKey(coord)) System.out.println("didint have"+coord);
            
        }
    }
    
}
