import java.util.Arrays;

public class backtracking {

    //permutations with backtracking
    public static void permutations(String str,String perm,int idx){
        if(str.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i)+str.substring(i+1);
            permutations(newStr, perm + currChar , idx+1);


        }
    }

    //backtracking with obstacles

    public static void pathRestriction(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            pathRestriction(p+'D', maze, r+1, c);

        }if(c<maze[0].length-1){
            pathRestriction(p+'R', maze, r, c+1);

        }

    }
    //backtracking with erasing the changes we have made and executing the another condition
    static void allpath(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        
        if(!maze[r][c]){
            return;
        }
        maze[r][c] =false;
        if(r<maze.length-1){
            allpath(p+'D', maze, r+1, c);

        }if(c<maze[0].length-1){
            allpath(p+'R', maze, r, c+1);

        }
        if(r>0){
            allpath(p+'U', maze, r-1, c);
        }
        if(c>0){
            allpath(p+'L', maze, r, c-1);
        }
        maze[r][c] = true;

    }
    static void allpathcount(String p,boolean[][] maze,int r,int c,int[][] path , int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            for(int[] arr:path){
                path[r][c]=step;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        
        if(!maze[r][c]){
            return;
        }
        maze[r][c] =false;
        path[r][c]=step;
        if(r<maze.length-1){
            allpathcount(p+'D', maze, r+1, c, path ,step+1);

        }if(c<maze[0].length-1){
            allpathcount(p+'R', maze, r, c+1,path,step+1);

        }
        if(r>0){
            allpathcount(p+'U', maze, r-1, c,path,step+1);
        }
        if(c>0){
            allpathcount(p+'L', maze, r, c-1,path,step+1);
        }
        maze[r][c] = true;
        path[r][c] =0;

    }

    
    
    
    public static void main(String[] args) {
        String str = "ABC";
        permutations(str, "", 0);

        boolean[][] board = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int[][] path = new int[board.length][board[0].length];
        //pathRestriction(" ", board,0 , 0);
        //allpath("", board, 0, 0);
        allpathcount("", board, 0, 0, path, 1);
    }
    
}
