package edu.nyu.cs.pqs.ps1;

public class NumberofIslands {

  static public int numIslands (char[][] grid) {
    int rows=grid.length;
    int cols;
    if(rows==0){
      cols=0;
    }else{
      cols =grid[0].length;
    }
    
    int num=0;
    for (int i=0; i<rows; i++){
      for (int j=0; j<cols; j++){
        if(grid[i][j] =='1'){
          num++;
          recur(grid, i, j, rows, cols);
        }
      }
    }
    return num;
  }

  public static void recur( char[][] grid, int i, int j, int rows, int cols){
    grid[i][j]='N';
    if(i>=1){
      if(grid[i-1][j] =='1'){
        recur(grid, i-1, j, rows, cols);
      }
    }
    if(i<=rows-2){
      if (grid[i+1][j] =='1'){
        recur(grid, i+1, j, rows, cols);
      }
    }
    if(j>=1){
      if(grid[i][j-1]=='1'){
        recur(grid, i, j-1, rows, cols);
      }
    }
    if(j<=cols-2){
      if(grid[i][j+1]=='1'){
        recur(grid, i, j+1, rows, cols);
      }
    }
  }

  public static void main(String[] args) {


  }

}
