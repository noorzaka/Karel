import stanford.karel.SuperKarel;

import javax.swing.*;

import static java.lang.Math.max;

public class Homework extends SuperKarel {
    private int cols;
    private int rows;
    private int moves;
    public void moveToEnd() {
        while (frontIsClear()) {
            move();
            moves++;
        }
    }
    public void findKarelWorldDimensions() {
        cols = 1;
        rows = 1;
        moves = 0;
        while (frontIsClear()) {
            move();
            cols++;}
        turnLeft();
        while (frontIsClear()) {
            move();
            rows++;}
        turnLeft();
        while (frontIsClear()) {
            move();}
        turnLeft();
        while (frontIsClear()) {
            move();}
        turnLeft();}
    public void moveDiagonally() {
        while (frontIsClear() && leftIsClear()) {
            putBeeper();
            move();
            turnLeft();
            move();
            turnRight();
            moves += 2;}
        putBeeper();
        turnAround();
        moveToEnd();
           turnAround();}
    public void drawTheOtherDiagonal() {
        while (noBeepersPresent() && frontIsClear()) {
            putBeeper();
            move();
            turnRight();
            move();
            turnLeft();
            moves += 2;}
        putBeeper();
        returnToTheStartPoint();}

    public void returnToTheStartPoint() {
        turnAround();
         moveToEnd();
        turnAround();}

    public void moveAsPlusSign() {
        int coulmnsHalf = cols / 2;
        int rowsHalf = rows / 2;
        for (int i = 0; i < coulmnsHalf; i++) {
            move();
            moves++;}
        putBeeper();
        turnLeft();
        while (frontIsClear()) {
            move();
            putBeeper();
            moves++;}
        turnRight();
         moveToEnd();
        turnRight();
        for (int i = 0; i < rowsHalf; i++) {
            move();
            moves++;}
        turnRight();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;}
            else { putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnLeft();
        moveToEnd();
        turnLeft();}

    public void moveDuplicate() {
        for (int i = 0; i < (cols / 2) - 1; i++) {
            move();
            moves++;}
        turnLeft();
        while (frontIsClear()) {
            putBeeper();
            move();
            moves++;}
        turnRight();
        putBeeper();
        move();
        moves++;
        turnRight();
        while (frontIsClear()) {
            putBeeper();
            move();
            moves++;}
        putBeeper();
        turnLeft();
        moveToEnd();
        turnLeft();
        for (int i = 0; i < (rows / 2) - 1; i++) {
            move();
            moves++;}
        turnLeft();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;} else {
                putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnRight();
        move();
        moves++;
        turnRight();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;}
            else {putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnRight();
        moveToEnd();
        turnLeft();
        turnAround();
        moveToEnd();
        turnAround();}

    public void dublicateRows() {
        turnLeft();
        for (int i = 0; i < (rows / 2) - 1; i++) {
            move();
            moves++;}
        turnRight();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;}
            else { putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnLeft();
        move();
        moves++;
        turnLeft();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;}
            else {putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnLeft();
        moveToEnd();
        turnLeft();
        for (int i = 0; i < (cols / 2); i++) {
            move();
            moves++;}
        turnLeft();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;}
            else {putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnLeft();
        moveToEnd();
        turnLeft();
        moveToEnd();
        turnLeft();}

    public void duplicateColumns() {
        for (int i = 0; i < (cols / 2) - 1; i++) {
            move();
            moves++;}
        turnLeft();
        putBeeper();
        while (frontIsClear()) {
            move();
            moves++;
            putBeeper();}
        turnRight();
        move();
        moves++;
        turnRight();
        putBeeper();
        while (frontIsClear()) {
            move();
            moves++;
            putBeeper();}
        turnLeft();
        moveToEnd();
        turnLeft();
        for (int i = 0; i < (rows / 2); i++) {
            move();
            moves++;}
        turnLeft();
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                moves++;
            } else {putBeeper();
                move();
                moves++;}}
        putBeeper();
        turnLeft();
        moveToEnd();
        turnLeft();}

    public int noOfNodesPerChamber() {   //>=7
        int m = Math.max(rows, cols);
        int noOfNode = m / 4;
        if ((m - (noOfNode * 4)) >= 3) {
            return noOfNode;}
        while (noOfNode > 0) {
            noOfNode--;
            if (m - (noOfNode * 4) >= 3) {
                return noOfNode;}}
        return 0; }

    public void divideAsPatterns() {
        int noOfNodes = noOfNodesPerChamber();
        int fourChambers = 4;
        int m = Math.max(rows, cols);
        while (frontIsClear()) {
            for (int j = 0; j < noOfNodes && fourChambers > 0; j++) {
                move();
                moves++;}
            fourChambers--;
            putBeeper();
            if (frontIsClear()) {
                move();
                moves++;}}
        turnAround();
        for (int i = 0; i < m - (noOfNodes * 4) - 3 && noBeepersPresent(); i++) {
            putBeeper();
            move();
            moves++;}
        if (noBeepersPresent() && (m > 7))
            putBeeper();}

    void twoOrThreeChambers() {
        int m = max(rows, cols);
        for (int i = 0; i < m / 2; i++) {
            if (frontIsClear()) {
                move();
                moves++;
                putBeeper();
                if (frontIsClear()) {
                    move();
                    moves++;}}}}
    public  void karelIsMoving (){
        if (cols == 2 && rows == 2)
        {  moveDiagonally();
        turnRight();move(); moves++; turnLeft();}
        else if (cols % 2 == 0 && rows % 2 == 0 && rows == cols) {
            moveDiagonally();
            drawTheOtherDiagonal();}
        else if (cols % 2 != 0 && rows % 2 != 0  &&  (rows>2 &&cols>2)) {
            moveAsPlusSign();}
        else if (cols % 2 == 0 && rows % 2 == 0 &&  (rows>2 &&cols>2))
            moveDuplicate();
        else if (rows % 2 == 0 && cols % 2 != 0  &&  (rows>2 &&cols>2))
            dublicateRows();
        else if (rows % 2 != 0 && cols % 2 == 0  &&  (rows>2 &&cols>2))
            duplicateColumns();
        else if (rows >= 7 && cols == 1) {
            turnLeft();
            divideAsPatterns();
            moveToEnd();
            turnLeft();}
        else if (cols >= 7 && rows == 1) {
            divideAsPatterns();
        moveToEnd();
        turnAround();}
        else if (rows == 2 && cols >= 7) {
            divideAsPatterns();
            turnRight();
            move();
            moves++;
            turnLeft();
            while (frontIsClear()) {
                move();
                moves++;}
            turnAround();
            divideAsPatterns();
        moveToEnd(); turnLeft(); move(); moves++;turnLeft();}
        else if (cols == 2 && rows >= 7) {
            turnLeft();
            divideAsPatterns();
            moveToEnd();
            turnLeft();
            move();
            moves++;
            turnLeft();
            divideAsPatterns();
        moveToEnd();turnRight(); move();moves++;turnAround();}
        else if (rows == 1 && cols <= 6) {
            twoOrThreeChambers();
            turnAround(); moveToEnd(); turnAround();}
        else if (cols == 1 && rows <= 6) {
             turnLeft();
            twoOrThreeChambers();
            turnAround();
            moveToEnd();
            turnLeft();
        }
        else if (rows == 2 &&(cols <= 6 && cols!=2)) {
            twoOrThreeChambers();
            turnLeft();
            move();
            moves++;
            turnLeft();
            moveToEnd();
            turnAround();
            twoOrThreeChambers();
          turnRight();move(); moves++;turnRight();moveToEnd();turnAround(); }
        else if(cols==2 &&( rows <= 6 && rows !=2)) {
            turnLeft();
            twoOrThreeChambers();
            turnRight();
            move();
            moves++;
            turnLeft();
            turnAround();
            moveToEnd();
            turnAround();
            twoOrThreeChambers();
        turnAround(); moveToEnd(); turnRight(); move(); moves++; turnAround();}}
    public void run() {
        setBeepersInBag(1000);
        findKarelWorldDimensions();
        karelIsMoving();
        System.out.println(moves);
    }
}


