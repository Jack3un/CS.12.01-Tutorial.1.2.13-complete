public class Crossword
{
    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares)
    {
        this.puzzle = new Square[blackSquares.length][blackSquares[0].length];
        int counter = 1;
        for(int i = 0; i < blackSquares.length; i++)
        {
            for(int j = 0; j < blackSquares[i].length; j++)
            {
                boolean label = toBeLabeled(i, j, blackSquares);
                if(label)
                {
                    puzzle[i][j] = new Square(blackSquares[i][j], counter);
                    counter++;
                }
                else
                {
                    puzzle[i][j] = new Square(blackSquares[i][j], 0);
                }
            }
        }
    }

    private boolean toBeLabeled(int i, int j, boolean[][] blackSquares)
    {
        if(blackSquares[i][j]) return false;
        if(i == 0 || blackSquares[i-1][j]) return true;
        return j == 0 || blackSquares[i][j - 1];
    }

    public Square[][] getPuzzle()
    {
        return puzzle;
    }

}

