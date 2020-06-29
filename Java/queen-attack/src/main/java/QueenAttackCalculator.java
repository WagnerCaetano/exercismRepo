public class QueenAttackCalculator {

    private Queen queenA;
    private Queen queenB;

    public QueenAttackCalculator(Queen queenA , Queen queenB){
        verifyQueens(queenA,queenB);

        this.queenA = queenA;
        this.queenB = queenB;
    }

    public static void verifyQueens(Queen queenA , Queen queenB)
    {
        if(queenA == null || queenB == null)
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");

        if(queenA.equals(queenB))
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
    }

    public boolean canQueensAttackOneAnother(){
        boolean canAttackRow,canAttackColumn,canAttackDiagonal;

        canAttackColumn = this.queenB.getColumn()==this.queenA.getColumn();
        canAttackRow = this.queenB.getRow()==this.queenA.getRow();
        canAttackDiagonal = isInDiagonal(queenA,queenB);

        return canAttackColumn || canAttackRow || canAttackDiagonal;
    }

    public static boolean isInDiagonal(Queen queenA,Queen queenB)
    {
        int first = (queenA.getRow()>queenB.getRow()) ? queenA.getRow() - queenB.getRow()
                : queenB.getRow() - queenA.getRow();
        int second = (queenA.getColumn()>queenB.getColumn()) ? queenA.getColumn() - queenB.getColumn()
                : queenB.getColumn() - queenA.getColumn();
        return first==second;
    }

}
