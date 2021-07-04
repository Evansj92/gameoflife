public class GameOfLife
{
    public static void main(String[] args)
    {
        // Assumptions & Comments
        // Currently this iteration of the code only produces two evolutions and is rather simple, 
        // due to being sick with Covid for the past week and still recovering.
        // Assuming a boundry of 10 by 10 for the field for inital rapid implementation as otherwise the box would be infinite.         
        // If a more rigorious and efficient implentation is required then a neighbour-by-neighbour approach would be better to determine
        // if each individual cells neighbour is alive or dead. This approach would identify the number of each alive neighbours as required.
       
        int M = 10, N = 10;
  
        // Creating a grid to hold the inital cell seeds
        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
  
        // Showing the grid
        System.out.println("First Evolution");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextEvolution(grid, M, N);
    }
  
    // Updating the grid
    static void nextEvolution(int grid[][], int M, int N)
    {
        int[][] evolve = new int[M][N];
  
        // Looping through each cell
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding amount of neighbours alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
  
                // Subtracted the cell from its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];
  
                // Setting the scenarios
  
                // Underpopulation
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    evolve[l][m] = 0;
  
                // Overcrowding
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    evolve[l][m] = 0;
  
                // Creating Life
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    evolve[l][m] = 1;
  
                // Survival
                else
                    evolve[l][m] = grid[l][m];
            }
        }
  
        System.out.println("Second Evolution");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (evolve[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
} 
