package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides the text interface for the Steps Game
 *
 * The game is based directly on Smart Games' IQ-Steps game
 * (http://www.smartgames.eu/en/smartgames/iq-steps)
 */
public class StepsGame {

    /**
     * Determine whether a piece placement is well-formed according to the following:
     * - it consists of exactly three characters
     * - the first character is in the range A .. H (shapes)
     * - the second character is in the range A .. H (orientations)
     * - the third character is in the range A .. Y and a .. y (locations)
     *
     * @param piecePlacement A string describing a piece placement
     * @return True if the piece placement is well-formed
     */
    static boolean isPiecePlacementWellFormed(String piecePlacement) {
        // FIXME Task 2: determine whether a piece placement is well-formed
        int pieceCharAscii;
        pieceCharAscii = (int)piecePlacement.charAt(0);
        if (pieceCharAscii<65||pieceCharAscii>72)
            return false;
        pieceCharAscii = (int)piecePlacement.charAt(1);
        if (pieceCharAscii<65||pieceCharAscii>72)
            return false;
        pieceCharAscii = (int)piecePlacement.charAt(2);
        return (pieceCharAscii>=65&&pieceCharAscii<=89)||(pieceCharAscii>=97&&pieceCharAscii<=121);
    }

    /**
     * Determine whether a placement string is well-formed:
     *  - it consists of exactly N three-character piece placements (where N = 1 .. 8);
     *  - each piece placement is well-formed
     *  - no shape appears more than once in the placement
     *
     * @param placement A string describing a placement of one or more pieces
     * @return True if the placement is well-formed
     */
    static boolean isPlacementWellFormed(String placement) {
        // FIXME Task 3: determine whether a placement is well-formed
        // It is empty
        if (placement==null||placement=="")
            return false;
        if (placement.length()%3!=0)
            return false;
        //Loop to show every element is in the range
        for(int i=0;i<placement.length();i++){
            if ((i%3==0||i%3==1) && ((int)placement.charAt(i)<65||(int)placement.charAt(i)>72))
                return false;
            if (i%3==2 && ((int)placement.charAt(i)<65||(int)placement.charAt(i)>89)&&
                    ((int)placement.charAt(i)<97||(int)placement.charAt(i)>121))
                return false;
        }
        //Loop for recognise the same items
        for (int i=0;i<placement.length()/3-1;i++)
            for (int j=i+1;j<placement.length()/3;j++){
                if (placement.charAt(i*3)==placement.charAt(j*3)&&
                        placement.charAt(i*3+1)==placement.charAt(j*3+1)&&
                        placement.charAt(i*3+2)==placement.charAt(j*3+2))
                    return false;
            }
        return true;
    }
    /*
     *   Determine whether a piece is valid
     */
    static boolean isValidPlacement(String piecePlacement,int position){
        if ((int)piecePlacement.charAt(0)-65!=1 && (int)piecePlacement.charAt(0)-65!=4){
            if (position<10||position>39||position%10==0||position%10==9)
                return false;
        }
        else if ((int)piecePlacement.charAt(0)-65==1){
            if ((int)piecePlacement.charAt(1)-65==0||(int)piecePlacement.charAt(1)-65==6){
                if (position<10||position>39||position%10==9)
                    return false;}
            else if ((int)piecePlacement.charAt(1)-65==1||(int)piecePlacement.charAt(1)-65==7){
                if (position>39||position%10==0||position%10==9)
                    return false;}
            else if ((int)piecePlacement.charAt(1)-65==2||(int)piecePlacement.charAt(1)-65==4){
                if (position<10||position>39||position%10==0)
                    return false; }
            else{
                if (position<10||position%10==0||position%10==9)
                    return false; }
        }
        else{
            if ((int)piecePlacement.charAt(1)-65==0||(int)piecePlacement.charAt(1)-65==6){
                if (position<10||position>39||position%10==0)
                    return false;}
            else if ((int)piecePlacement.charAt(1)-65==1||(int)piecePlacement.charAt(1)-65==7){
                if (position<10||position%10==0||position%10==9)
                    return false;}
            else if ((int)piecePlacement.charAt(1)-65==2||(int)piecePlacement.charAt(1)-65==4){
                if (position<10||position>39||position%10==9)
                    return false; }
            else{
                if (position>39||position%10==0||position%10==9)
                    return false; }
        }
        return true;
    }

    /*
     * Determine whether a piece is not overlap
     */

    static boolean isOverlap (int[] location, String piecePlacement, int position,int i){
        if (position>=0 && position<10){
            if (location[position+10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position+10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (position!=0 && position!=9){
                if (location[position+1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position+1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
                if (location[position-1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position-1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
            }
            else if (position==0){
                if (location[position+1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position+1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
            }
            else {
                if (location[position-1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position-1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
            }
        }
        else if (position<50 && position>=40){
            if (location[position-10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position-10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (position!=40 && position !=49){
                if (location[position+1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position+1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
                if (location[position-1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position-1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
            }
            else if (position==40){
                if (location[position+1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position+1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
            }
            else {
                if (location[position-1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                    return true;
                else if (location[position-1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                    return true;
            }
        }
        else if (position%10==0){
            if (location[position+1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position+1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position+10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position+10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position-10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position-10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
        }
        else if (position%10 == 9){
            if (location[position-1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position-1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position+10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position+10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position-10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position-10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
        }
        else {
            if (location[position+10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position+10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position-10]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position-10]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position+1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position+1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
            if (location[position-1]==1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] !=0)
                return true;
            else if (location[position-1]==-1 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][i] ==-1)
                return true;
        }

        return false;
    }

    /**
     * Determine whether a placement sequence is valid.  To be valid, the placement
     * sequence must be well-formed and each piece placement must be a valid placement
     * (with the pieces ordered according to the order in which they are played).
     *
     * @param placement A placement sequence string
     * @return True if the placement sequence is valid
     */

    private static int [][][] mask = {
            {{-1,1,0,1,-1,1,-1,0,0},{-1,1,-1,0,-1,1,0,1,0},{0,0,-1,1,-1,1,0,1,-1},{0,1,0,1,-1,0,-1,1,-1},
                    {0,-1,1,-1,1,-1,0,0,1},{0,-1,0,0,1,-1,1,-1,1},{1,0,0,-1,1,-1,0,-1,0},{1,-1,1,-1,1,0,0,-1,0}},
            {{0,1,0,0,-1,1,0,1,-1},{0,0,0,1,-1,1,-1,1,0},{-1,1,0,1,-1,0,0,1,0},{0,1,-1,1,-1,1,0,0,0},
                    {0,-1,0,-1,1,0,1,-1,0},{1,-1,0,-1,1,-1,0,0,0},{0,-1,1,0,1,-1,0,-1,0},{0,0,0,-1,1,-1,0,-1,1}},
            {{0,1,0,0,-1,1,-1,1,0},{-1,0,0,1,-1,1,0,1,0},{0,1,-1,1,-1,0,0,1,0},{0,1,0,1,-1,1,0,0,-1},
                    {0,-1,0,-1,1,0,0,-1,1},{0,-1,0,-1,1,-1,1,0,0},{1,-1,0,0,1,-1,0,-1,0},{0,0,1,-1,1,-1,0,-1,0}},
            {{0,1,0,1,-1,0,0,1,-1},{0,1,0,1,-1,1,-1,0,0},{-1,1,0,0,-1,1,0,1,0},{0,0,-1,1,-1,1,0,1,0},
                    {0,-1,0,0,1,-1,1,-1,0},{1,0,0,-1,1,-1,0,-1,0},{0,-1,1,-1,1,0,0,-1,0},{0,-1,0,-1,1,-1,0,0,1}},
            {{0,1,0,1,-1,0,-1,1,0},{-1,1,0,1,-1,1,0,0,0},{0,1,-1,0,-1,1,0,1,0},{0,0,0,1,-1,1,0,1,-1},
                    {0,-1,0,0,1,-1,0,-1,1},{0,0,0,-1,1,-1,1,-1,0},{1,-1,0,-1,1,0,0,-1,0},{0,-1,1,-1,1,-1,0,0,0}},
            {{0,0,-1,0,-1,1,-1,1,0},{-1,0,0,1,-1,0,0,1,-1},{0,1,-1,1,-1,0,-1,0,0},{-1,1,0,0,-1,1,0,0,-1},
                    {1,0,0,-1,1,0,0,-1,1},{0,-1,1,-1,1,0,1,0,0},{1,-1,0,0,1,-1,0,0,1},{0,0,1,0,1,-1,1,-1,0}},
            {{0,1,-1,0,-1,1,-1,1,0},{-1,0,0,1,-1,1,0,1,-1},{0,1,-1,1,-1,0,-1,1,0},{-1,1,0,1,-1,1,0,0,-1},
                    {1,-1,0,-1,1,0,0,-1,1},{0,-1,1,-1,1,-1,1,0,0},{1,-1,0,0,1,-1,0,-1,1},{0,0,1,-1,1,-1,1,-1,0}},
            {{0,1,-1,1,-1,0,0,1,-1},{0,1,0,1,-1,1,-1,0,-1},{-1,1,0,0,-1,1,-1,1,0},{-1,0,-1,1,-1,1,0,1,0},
                    {1,-1,0,0,1,-1,1,-1,0},{1,0,1,-1,1,-1,0,-1,0},{0,-1,1,-1,1,0,0,-1,1},{0,-1,0,-1,1,-1,1,0,1}}
    };

    public static boolean isPlacementSequenceValid(String placement) {
        // FIXME Task 5: determine whether a placement sequence is valid
        // Determine if the placement is placed well
        if (!isPlacementWellFormed(placement))
            return false;
        // location variable record the piece placement on whole board
        int[] location = new int[50];

        for (int i=0;i<=placement.length()/3-1;i++){
            // twice test
            for (int j=i+1;j<placement.length()/3;j++){
                if (placement.charAt(i*3)==placement.charAt(j*3))
                    return false;
            }

            // Copy the single piece placement
            String piecePlacement = String.valueOf(placement.charAt(i*3))+String.valueOf(placement.charAt(i*3+1))+
                    String.valueOf(placement.charAt(i*3+2));

            // Position of the Mask
            int position;
            if ((int)piecePlacement.charAt(2)<91)
                position = (int)piecePlacement.charAt(2)-65;
            else
                position = (int)piecePlacement.charAt(2)-97+25;

            // Recognise if the piece of placement is well
            if (!isPiecePlacementWellFormed(piecePlacement))
                return false;

            //valid piece test
            if (!isValidPlacement(piecePlacement,position))
                return false;
            // Put the piece placement into the board array
            for (int j=0;j<9;j++){
                if (j/3 == 0) {
                    if (position-11+j>=0 && position-11+j>=(Math.floor(position/10)-1)*10 && position-11+j<Math.floor(position/10)*10)
                        location[j + position - 11] = mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j];
                    else if (position-11+j<0 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j]!=0)
                        return false;
                    else if (position-11+j<(Math.floor(position/10)-1)*10||position-11+j>=Math.floor(position/10)*10)
                        if (mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j]!=0)
                            return false;
                }
                else if (j/3 == 1){
                    if (position-1+j-3>=(Math.floor(position/10)*10) && position-1+j-3<(Math.floor(position/10)+1)*10)
                        location[j-3+position-1]= mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j];
                    else if (mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j]!=0)
                        return false;
                    else if (position-1+j-3<(Math.floor(position/10))*10||position-1-3+j>=Math.floor(position/10+1)*10)
                        if (mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j]!=0)
                            return false;
                }
                else{
                    if (position+9+j-6<50 && position+9+j-6>=(Math.floor(position/10)+1)*10 && position+9+j-6<(Math.floor(position/10)+2)*10)
                        location[j-6+position+9] = mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j];
                    else if (position+9+j-6<0 && mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j]!=0)
                        return false;
                    else if (position+9+j-6<(Math.floor(position/10)+1)*10||position+9-6+j>=Math.floor(position/10+2)*10)
                        if (mask[(int)piecePlacement.charAt(0)-65][(int)piecePlacement.charAt(1)-65][j]!=0)
                            return false;
                }
            }
            if (i == placement.length()/3-1)
                continue;
            // Decide can the new piece can put in the board
            String piecePlacementNew = String.valueOf(placement.charAt((i+1)*3))+String.valueOf(placement.charAt((i+1)*3+1))+
                    String.valueOf(placement.charAt((i+1)*3+2));

            // position of new piece
            int positionNew;
            if ((int)piecePlacementNew.charAt(2)<91)
                positionNew = (int)piecePlacementNew.charAt(2)-65;
            else
                positionNew = (int)piecePlacementNew.charAt(2)-97+25;

            if(!isPiecePlacementWellFormed(piecePlacementNew))
                return false;

            // Recognise the up-lay and the low-lay whether it is same place
            for (int j=0;j<9;j++){
                if (j/3==0){
                    if (positionNew-11+j>=0 && positionNew-11+j>=(Math.floor(positionNew/10)-1)*10 && positionNew-11+j<Math.floor(positionNew/10)*10){
                        if (location[j+positionNew-11]==1 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]!=0)
                            return false;
                        else if (location[j+positionNew-11]==-1 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]==-1)
                            return false;
                        if (isOverlap(location,piecePlacementNew,positionNew+j-11,j))
                            return false;
                    }
                    else if (positionNew-11+j<0 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]!=0)
                        return false;

                }
                else if (j/3==1){
                    if (positionNew-1+j-3>=(Math.floor(positionNew/10)*10) && positionNew-1+j-3<(Math.floor(positionNew/10)+1)*10){
                        if (location[j+positionNew-1-3]==1 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]!=0)
                            return false;
                        else if (location[j+positionNew-1-3]==-1 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]==-1)
                            return false;
                        if (isOverlap(location,piecePlacementNew,positionNew+j-1-3,j))
                            return false;
                    }
                    else if (mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]!=0)
                        return false;

                }
                else {
                    if (positionNew+9+j-6<50 && positionNew+9+j-6>=(Math.floor(positionNew/10)+1)*10 && positionNew+9+j-6<(Math.floor(positionNew/10)+2)*10){
                        if (location[j+positionNew+9-6]==1 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]!=0)
                            return false;
                        else if (location[j+positionNew+9-6]==-1 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]==-1)
                            return false;
                        if (isOverlap(location,piecePlacementNew,positionNew+j+9-6,j))
                            return false;
                    }
                    else if (positionNew+9+j-6>=50 && mask[(int)piecePlacementNew.charAt(0)-65][(int)piecePlacementNew.charAt(1)-65][j]!=0)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * Given a string describing a placement of pieces and a string describing
     * an (unordered) objective, return a set of all possible next viable
     * piece placements.   A viable piece placement must be a piece that is
     * not already placed (ie not in the placement string), and which will not
     * obstruct any other unplaced piece.
     *
     * @param placement A valid sequence of piece placements where each piece placement is drawn from the objective
     * @param objective A valid game objective, but not necessarily a valid placement string
     * @return An set of viable piece placements
     */
    static Set<String> getViablePiecePlacements(String placement, String objective) {
        // FIXME Task 6: determine the correct order of piece placements
        Set<String> set = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.clear();
        set.clear();

        // put string objective into the arrayList, which is contain the string except placement
        for (int i=0;i<objective.length()/3;i++){
            // Select one of the piecePlacement in the objective
            String piecePlacement = String.valueOf(objective.charAt(i*3))+String.valueOf(objective.charAt(i*3+1))+
                    String.valueOf(objective.charAt(i*3+2));
            if (placement.contains(piecePlacement))
                continue;

            arrayList.add(piecePlacement);
        }
        // Loop to get next piece
        for (int i=0;i<arrayList.size();i++){
            if (!isPlacementSequenceValid(placement+arrayList.get(i)))
                continue;
            int count = 0;
            for (int j=0;j<arrayList.size();j++){
                if (i==j)
                    continue;
                if (isPlacementSequenceValid(arrayList.get(i)+arrayList.get(j)))
                    count++;
            }
            if (count == arrayList.size()-1)
                set.add(arrayList.get(i));
        }

        return set;
    }



    /**
     * Return an array of all solutions to the game, given a starting placement.
     *
     * @param placement  A valid piece placement string.
     * @return An array of strings, each describing a solution to the game given the
     * starting point provided by placement.
     */
    static String[] getSolutions(String placement) {
        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
        //allpossible.clear();

        String[][] pieces = {
                {"AAL" , "AAM" , "AAN" , "AAO" , "AAP" , "AAQ" , "AAR" , "AAS" , "AAV" , "AAW" , "AAX" , "AAY" , "AAa" , "AAb" , "AAc" , "AAd" , "AAg" , "AAh" , "AAi" , "AAj" , "AAk" , "AAl" , "AAm" , "AAn" , "ABL" , "ABM" , "ABN" , "ABO" , "ABP" , "ABQ" , "ABR" , "ABS" , "ABV" , "ABW" , "ABX" , "ABY" , "ABa" , "ABb" , "ABc" , "ABd" , "ABg" , "ABh" , "ABi" , "ABj" , "ABk" , "ABl" , "ABm" , "ABn" , "ACL" , "ACM" , "ACN" , "ACO" , "ACP" , "ACQ" , "ACR" , "ACS" , "ACV" , "ACW" , "ACX" , "ACY" , "ACa" , "ACb" , "ACc" , "ACd" , "ACg" , "ACh" , "ACi" , "ACj" , "ACk" , "ACl" , "ACm" , "ACn" , "ADL" , "ADM" , "ADN" , "ADO" , "ADP" , "ADQ" , "ADR" , "ADS" , "ADV" , "ADW" , "ADX" , "ADY" , "ADa" , "ADb" , "ADc" , "ADd" , "ADg" , "ADh" , "ADi" , "ADj" , "ADk" , "ADl" , "ADm" , "ADn" , "AEL" , "AEM" , "AEN" , "AEO" , "AEP" , "AEQ" , "AER" , "AES" , "AEV" , "AEW" , "AEX" , "AEY" , "AEa" , "AEb" , "AEc" , "AEd" , "AEg" , "AEh" , "AEi" , "AEj" , "AEk" , "AEl" , "AEm" , "AEn" , "AFL" , "AFM" , "AFN" , "AFO" , "AFP" , "AFQ" , "AFR" , "AFS" , "AFV" , "AFW" , "AFX" , "AFY" , "AFa" , "AFb" , "AFc" , "AFd" , "AFg" , "AFh" , "AFi" , "AFj" , "AFk" , "AFl" , "AFm" , "AFn" , "AGL" , "AGM" , "AGN" , "AGO" , "AGP" , "AGQ" , "AGR" , "AGS" , "AGV" , "AGW" , "AGX" , "AGY" , "AGa" , "AGb" , "AGc" , "AGd" , "AGg" , "AGh" , "AGi" , "AGj" , "AGk" , "AGl" , "AGm" , "AGn" , "AHL" , "AHM" , "AHN" , "AHO" , "AHP" , "AHQ" , "AHR" , "AHS" , "AHV" , "AHW" , "AHX" , "AHY" , "AHa" , "AHb" , "AHc" , "AHd" , "AHg" , "AHh" , "AHi" , "AHj" , "AHk" , "AHl" , "AHm" , "AHn"},
                {"BAK" , "BAL" , "BAM" , "BAN" , "BAO" , "BAP" , "BAQ" , "BAR" , "BAS" , "BAU" , "BAV" , "BAW" , "BAX" , "BAY" , "BAa" , "BAb" , "BAc" , "BAd" , "BAf" , "BAg" , "BAh" , "BAi" , "BAj" , "BAk" , "BAl" , "BAm" , "BAn" , "BBB" , "BBC" , "BBD" , "BBE" , "BBF" , "BBG" , "BBH" , "BBI" , "BBL" , "BBM" , "BBN" , "BBO" , "BBP" , "BBQ" , "BBR" , "BBS" , "BBV" , "BBW" , "BBX" , "BBY" , "BBa" , "BBb" , "BBc" , "BBd" , "BBg" , "BBh" , "BBi" , "BBj" , "BBk" , "BBl" , "BBm" , "BBn" , "BCL" , "BCM" , "BCN" , "BCO" , "BCP" , "BCQ" , "BCR" , "BCS" , "BCT" , "BCV" , "BCW" , "BCX" , "BCY" , "BCa" , "BCb" , "BCc" , "BCd" , "BCe" , "BCg" , "BCh" , "BCi" , "BCj" , "BCk" , "BCl" , "BCm" , "BCn" , "BCo" , "BDL" , "BDM" , "BDN" , "BDO" , "BDP" , "BDQ" , "BDR" , "BDS" , "BDV" , "BDW" , "BDX" , "BDY" , "BDa" , "BDb" , "BDc" , "BDd" , "BDg" , "BDh" , "BDi" , "BDj" , "BDk" , "BDl" , "BDm" , "BDn" , "BDq" , "BDr" , "BDs" , "BDt" , "BDu" , "BDv" , "BDw" , "BDx" , "BEL" , "BEM" , "BEN" , "BEO" , "BEP" , "BEQ" , "BER" , "BES" , "BET" , "BEV" , "BEW" , "BEX" , "BEY" , "BEa" , "BEb" , "BEc" , "BEd" , "BEe" , "BEg" , "BEh" , "BEi" , "BEj" , "BEk" , "BEl" , "BEm" , "BEn" , "BEo" , "BFL" , "BFM" , "BFN" , "BFO" , "BFP" , "BFQ" , "BFR" , "BFS" , "BFV" , "BFW" , "BFX" , "BFY" , "BFa" , "BFb" , "BFc" , "BFd" , "BFg" , "BFh" , "BFi" , "BFj" , "BFk" , "BFl" , "BFm" , "BFn" , "BFq" , "BFr" , "BFs" , "BFt" , "BFu" , "BFv" , "BFw" , "BFx" , "BGK" , "BGL" , "BGM" , "BGN" , "BGO" , "BGP" , "BGQ" , "BGR" , "BGS" , "BGU" , "BGV" , "BGW" , "BGX" , "BGY" , "BGa" , "BGb" , "BGc" , "BGd" , "BGf" , "BGg" , "BGh" , "BGi" , "BGj" , "BGk" , "BGl" , "BGm" , "BGn" , "BHB" , "BHC" , "BHD" , "BHE" , "BHF" , "BHG" , "BHH" , "BHI" , "BHL" , "BHM" , "BHN" , "BHO" , "BHP" , "BHQ" , "BHR" , "BHS" , "BHV" , "BHW" , "BHX" , "BHY" , "BHa" , "BHb" , "BHc" , "BHd" , "BHg" , "BHh" , "BHi" , "BHj" , "BHk" , "BHl" , "BHm" , "BHn"},
                {"CAL" , "CAM" , "CAN" , "CAO" , "CAP" , "CAQ" , "CAR" , "CAS" , "CAV" , "CAW" , "CAX" , "CAY" , "CAa" , "CAb" , "CAc" , "CAd" , "CAg" , "CAh" , "CAi" , "CAj" , "CAk" , "CAl" , "CAm" , "CAn" , "CBL" , "CBM" , "CBN" , "CBO" , "CBP" , "CBQ" , "CBR" , "CBS" , "CBV" , "CBW" , "CBX" , "CBY" , "CBa" , "CBb" , "CBc" , "CBd" , "CBg" , "CBh" , "CBi" , "CBj" , "CBk" , "CBl" , "CBm" , "CBn" , "CCL" , "CCM" , "CCN" , "CCO" , "CCP" , "CCQ" , "CCR" , "CCS" , "CCV" , "CCW" , "CCX" , "CCY" , "CCa" , "CCb" , "CCc" , "CCd" , "CCg" , "CCh" , "CCi" , "CCj" , "CCk" , "CCl" , "CCm" , "CCn" , "CDL" , "CDM" , "CDN" , "CDO" , "CDP" , "CDQ" , "CDR" , "CDS" , "CDV" , "CDW" , "CDX" , "CDY" , "CDa" , "CDb" , "CDc" , "CDd" , "CDg" , "CDh" , "CDi" , "CDj" , "CDk" , "CDl" , "CDm" , "CDn" , "CEL" , "CEM" , "CEN" , "CEO" , "CEP" , "CEQ" , "CER" , "CES" , "CEV" , "CEW" , "CEX" , "CEY" , "CEa" , "CEb" , "CEc" , "CEd" , "CEg" , "CEh" , "CEi" , "CEj" , "CEk" , "CEl" , "CEm" , "CEn" , "CFL" , "CFM" , "CFN" , "CFO" , "CFP" , "CFQ" , "CFR" , "CFS" , "CFV" , "CFW" , "CFX" , "CFY" , "CFa" , "CFb" , "CFc" , "CFd" , "CFg" , "CFh" , "CFi" , "CFj" , "CFk" , "CFl" , "CFm" , "CFn" , "CGL" , "CGM" , "CGN" , "CGO" , "CGP" , "CGQ" , "CGR" , "CGS" , "CGV" , "CGW" , "CGX" , "CGY" , "CGa" , "CGb" , "CGc" , "CGd" , "CGg" , "CGh" , "CGi" , "CGj" , "CGk" , "CGl" , "CGm" , "CGn" , "CHL" , "CHM" , "CHN" , "CHO" , "CHP" , "CHQ" , "CHR" , "CHS" , "CHV" , "CHW" , "CHX" , "CHY" , "CHa" , "CHb" , "CHc" , "CHd" , "CHg" , "CHh" , "CHi" , "CHj" , "CHk" , "CHl" , "CHm" , "CHn" },
                {"DAL" , "DAM" , "DAN" , "DAO" , "DAP" , "DAQ" , "DAR" , "DAS" , "DAV" , "DAW" , "DAX" , "DAY" , "DAa" , "DAb" , "DAc" , "DAd" , "DAg" , "DAh" , "DAi" , "DAj" , "DAk" , "DAl" , "DAm" , "DAn" , "DBL" , "DBM" , "DBN" , "DBO" , "DBP" , "DBQ" , "DBR" , "DBS" , "DBV" , "DBW" , "DBX" , "DBY" , "DBa" , "DBb" , "DBc" , "DBd" , "DBg" , "DBh" , "DBi" , "DBj" , "DBk" , "DBl" , "DBm" , "DBn" , "DCL" , "DCM" , "DCN" , "DCO" , "DCP" , "DCQ" , "DCR" , "DCS" , "DCV" , "DCW" , "DCX" , "DCY" , "DCa" , "DCb" , "DCc" , "DCd" , "DCg" , "DCh" , "DCi" , "DCj" , "DCk" , "DCl" , "DCm" , "DCn" , "DDL" , "DDM" , "DDN" , "DDO" , "DDP" , "DDQ" , "DDR" , "DDS" , "DDV" , "DDW" , "DDX" , "DDY" , "DDa" , "DDb" , "DDc" , "DDd" , "DDg" , "DDh" , "DDi" , "DDj" , "DDk" , "DDl" , "DDm" , "DDn" , "DEL" , "DEM" , "DEN" , "DEO" , "DEP" , "DEQ" , "DER" , "DES" , "DEV" , "DEW" , "DEX" , "DEY" , "DEa" , "DEb" , "DEc" , "DEd" , "DEg" , "DEh" , "DEi" , "DEj" , "DEk" , "DEl" , "DEm" , "DEn" , "DFL" , "DFM" , "DFN" , "DFO" , "DFP" , "DFQ" , "DFR" , "DFS" , "DFV" , "DFW" , "DFX" , "DFY" , "DFa" , "DFb" , "DFc" , "DFd" , "DFg" , "DFh" , "DFi" , "DFj" , "DFk" , "DFl" , "DFm" , "DFn" , "DGL" , "DGM" , "DGN" , "DGO" , "DGP" , "DGQ" , "DGR" , "DGS" , "DGV" , "DGW" , "DGX" , "DGY" , "DGa" , "DGb" , "DGc" , "DGd" , "DGg" , "DGh" , "DGi" , "DGj" , "DGk" , "DGl" , "DGm" , "DGn" , "DHL" , "DHM" , "DHN" , "DHO" , "DHP" , "DHQ" , "DHR" , "DHS" , "DHV" , "DHW" , "DHX" , "DHY" , "DHa" , "DHb" , "DHc" , "DHd" , "DHg" , "DHh" , "DHi" , "DHj" , "DHk" , "DHl" , "DHm" , "DHn" },
                {"EAL" , "EAM" , "EAN" , "EAO" , "EAP" , "EAQ" , "EAR" , "EAS" , "EAT" , "EAV" , "EAW" , "EAX" , "EAY" , "EAa" , "EAb" , "EAc" , "EAd" , "EAe" , "EAg" , "EAh" , "EAi" , "EAj" , "EAk" , "EAl" , "EAm" , "EAn" , "EAo" , "EBL" , "EBM" , "EBN" , "EBO" , "EBP" , "EBQ" , "EBR" , "EBS" , "EBV" , "EBW" , "EBX" , "EBY" , "EBa" , "EBb" , "EBc" , "EBd" , "EBg" , "EBh" , "EBi" , "EBj" , "EBk" , "EBl" , "EBm" , "EBn" , "EBq" , "EBr" , "EBs" , "EBt" , "EBu" , "EBv" , "EBw" , "EBx" , "ECK" , "ECL" , "ECM" , "ECN" , "ECO" , "ECP" , "ECQ" , "ECR" , "ECS" , "ECU" , "ECV" , "ECW" , "ECX" , "ECY" , "ECa" , "ECb" , "ECc" , "ECd" , "ECf" , "ECg" , "ECh" , "ECi" , "ECj" , "ECk" , "ECl" , "ECm" , "ECn" , "EDB" , "EDC" , "EDD" , "EDE" , "EDF" , "EDG" , "EDH" , "EDI" , "EDL" , "EDM" , "EDN" , "EDO" , "EDP" , "EDQ" , "EDR" , "EDS" , "EDV" , "EDW" , "EDX" , "EDY" , "EDa" , "EDb" , "EDc" , "EDd" , "EDg" , "EDh" , "EDi" , "EDj" , "EDk" , "EDl" , "EDm" , "EDn" , "EEK" , "EEL" , "EEM" , "EEN" , "EEO" , "EEP" , "EEQ" , "EER" , "EES" , "EEU" , "EEV" , "EEW" , "EEX" , "EEY" , "EEa" , "EEb" , "EEc" , "EEd" , "EEf" , "EEg" , "EEh" , "EEi" , "EEj" , "EEk" , "EEl" , "EEm" , "EEn" , "EFB" , "EFC" , "EFD" , "EFE" , "EFF" , "EFG" , "EFH" , "EFI" , "EFL" , "EFM" , "EFN" , "EFO" , "EFP" , "EFQ" , "EFR" , "EFS" , "EFV" , "EFW" , "EFX" , "EFY" , "EFa" , "EFb" , "EFc" , "EFd" , "EFg" , "EFh" , "EFi" , "EFj" , "EFk" , "EFl" , "EFm" , "EFn" , "EGL" , "EGM" , "EGN" , "EGO" , "EGP" , "EGQ" , "EGR" , "EGS" , "EGT" , "EGV" , "EGW" , "EGX" , "EGY" , "EGa" , "EGb" , "EGc" , "EGd" , "EGe" , "EGg" , "EGh" , "EGi" , "EGj" , "EGk" , "EGl" , "EGm" , "EGn" , "EGo" , "EHL" , "EHM" , "EHN" , "EHO" , "EHP" , "EHQ" , "EHR" , "EHS" , "EHV" , "EHW" , "EHX" , "EHY" , "EHa" , "EHb" , "EHc" , "EHd" , "EHg" , "EHh" , "EHi" , "EHj" , "EHk" , "EHl" , "EHm" , "EHn" , "EHq" , "EHr" , "EHs" , "EHt" , "EHu" , "EHv" , "EHw" , "EHx" },
                {"FAL" , "FAM" , "FAN" , "FAO" , "FAP" , "FAQ" , "FAR" , "FAS" , "FAV" , "FAW" , "FAX" , "FAY" , "FAa" , "FAb" , "FAc" , "FAd" , "FAg" , "FAh" , "FAi" , "FAj" , "FAk" , "FAl" , "FAm" , "FAn" , "FBL" , "FBM" , "FBN" , "FBO" , "FBP" , "FBQ" , "FBR" , "FBS" , "FBV" , "FBW" , "FBX" , "FBY" , "FBa" , "FBb" , "FBc" , "FBd" , "FBg" , "FBh" , "FBi" , "FBj" , "FBk" , "FBl" , "FBm" , "FBn" , "FCL" , "FCM" , "FCN" , "FCO" , "FCP" , "FCQ" , "FCR" , "FCS" , "FCV" , "FCW" , "FCX" , "FCY" , "FCa" , "FCb" , "FCc" , "FCd" , "FCg" , "FCh" , "FCi" , "FCj" , "FCk" , "FCl" , "FCm" , "FCn" , "FDL" , "FDM" , "FDN" , "FDO" , "FDP" , "FDQ" , "FDR" , "FDS" , "FDV" , "FDW" , "FDX" , "FDY" , "FDa" , "FDb" , "FDc" , "FDd" , "FDg" , "FDh" , "FDi" , "FDj" , "FDk" , "FDl" , "FDm" , "FDn" , "FEL" , "FEM" , "FEN" , "FEO" , "FEP" , "FEQ" , "FER" , "FES" , "FEV" , "FEW" , "FEX" , "FEY" , "FEa" , "FEb" , "FEc" , "FEd" , "FEg" , "FEh" , "FEi" , "FEj" , "FEk" , "FEl" , "FEm" , "FEn" , "FFL" , "FFM" , "FFN" , "FFO" , "FFP" , "FFQ" , "FFR" , "FFS" , "FFV" , "FFW" , "FFX" , "FFY" , "FFa" , "FFb" , "FFc" , "FFd" , "FFg" , "FFh" , "FFi" , "FFj" , "FFk" , "FFl" , "FFm" , "FFn" , "FGL" , "FGM" , "FGN" , "FGO" , "FGP" , "FGQ" , "FGR" , "FGS" , "FGV" , "FGW" , "FGX" , "FGY" , "FGa" , "FGb" , "FGc" , "FGd" , "FGg" , "FGh" , "FGi" , "FGj" , "FGk" , "FGl" , "FGm" , "FGn" , "FHL" , "FHM" , "FHN" , "FHO" , "FHP" , "FHQ" , "FHR" , "FHS" , "FHV" , "FHW" , "FHX" , "FHY" , "FHa" , "FHb" , "FHc" , "FHd" , "FHg" , "FHh" , "FHi" , "FHj" , "FHk" , "FHl" , "FHm" , "FHn"},
                {"GAL" , "GAM" , "GAN" , "GAO" , "GAP" , "GAQ" , "GAR" , "GAS" , "GAV" , "GAW" , "GAX" , "GAY" , "GAa" , "GAb" , "GAc" , "GAd" , "GAg" , "GAh" , "GAi" , "GAj" , "GAk" , "GAl" , "GAm" , "GAn" , "GBL" , "GBM" , "GBN" , "GBO" , "GBP" , "GBQ" , "GBR" , "GBS" , "GBV" , "GBW" , "GBX" , "GBY" , "GBa" , "GBb" , "GBc" , "GBd" , "GBg" , "GBh" , "GBi" , "GBj" , "GBk" , "GBl" , "GBm" , "GBn" , "GCL" , "GCM" , "GCN" , "GCO" , "GCP" , "GCQ" , "GCR" , "GCS" , "GCV" , "GCW" , "GCX" , "GCY" , "GCa" , "GCb" , "GCc" , "GCd" , "GCg" , "GCh" , "GCi" , "GCj" , "GCk" , "GCl" , "GCm" , "GCn" , "GDL" , "GDM" , "GDN" , "GDO" , "GDP" , "GDQ" , "GDR" , "GDS" , "GDV" , "GDW" , "GDX" , "GDY" , "GDa" , "GDb" , "GDc" , "GDd" , "GDg" , "GDh" , "GDi" , "GDj" , "GDk" , "GDl" , "GDm" , "GDn" , "GEL" , "GEM" , "GEN" , "GEO" , "GEP" , "GEQ" , "GER" , "GES" , "GEV" , "GEW" , "GEX" , "GEY" , "GEa" , "GEb" , "GEc" , "GEd" , "GEg" , "GEh" , "GEi" , "GEj" , "GEk" , "GEl" , "GEm" , "GEn" , "GFL" , "GFM" , "GFN" , "GFO" , "GFP" , "GFQ" , "GFR" , "GFS" , "GFV" , "GFW" , "GFX" , "GFY" , "GFa" , "GFb" , "GFc" , "GFd" , "GFg" , "GFh" , "GFi" , "GFj" , "GFk" , "GFl" , "GFm" , "GFn" , "GGL" , "GGM" , "GGN" , "GGO" , "GGP" , "GGQ" , "GGR" , "GGS" , "GGV" , "GGW" , "GGX" , "GGY" , "GGa" , "GGb" , "GGc" , "GGd" , "GGg" , "GGh" , "GGi" , "GGj" , "GGk" , "GGl" , "GGm" , "GGn" , "GHL" , "GHM" , "GHN" , "GHO" , "GHP" , "GHQ" , "GHR" , "GHS" , "GHV" , "GHW" , "GHX" , "GHY" , "GHa" , "GHb" , "GHc" , "GHd" , "GHg" , "GHh" , "GHi" , "GHj" , "GHk" , "GHl" , "GHm" , "GHn"},
                {"HAL" , "HAM" , "HAN" , "HAO" , "HAP" , "HAQ" , "HAR" , "HAS" , "HAV" , "HAW" , "HAX" , "HAY" , "HAa" , "HAb" , "HAc" , "HAd" , "HAg" , "HAh" , "HAi" , "HAj" , "HAk" , "HAl" , "HAm" , "HAn" , "HBL" , "HBM" , "HBN" , "HBO" , "HBP" , "HBQ" , "HBR" , "HBS" , "HBV" , "HBW" , "HBX" , "HBY" , "HBa" , "HBb" , "HBc" , "HBd" , "HBg" , "HBh" , "HBi" , "HBj" , "HBk" , "HBl" , "HBm" , "HBn" , "HCL" , "HCM" , "HCN" , "HCO" , "HCP" , "HCQ" , "HCR" , "HCS" , "HCV" , "HCW" , "HCX" , "HCY" , "HCa" , "HCb" , "HCc" , "HCd" , "HCg" , "HCh" , "HCi" , "HCj" , "HCk" , "HCl" , "HCm" , "HCn" , "HDL" , "HDM" , "HDN" , "HDO" , "HDP" , "HDQ" , "HDR" , "HDS" , "HDV" , "HDW" , "HDX" , "HDY" , "HDa" , "HDb" , "HDc" , "HDd" , "HDg" , "HDh" , "HDi" , "HDj" , "HDk" , "HDl" , "HDm" , "HDn" , "HEL" , "HEM" , "HEN" , "HEO" , "HEP" , "HEQ" , "HER" , "HES" , "HEV" , "HEW" , "HEX" , "HEY" , "HEa" , "HEb" , "HEc" , "HEd" , "HEg" , "HEh" , "HEi" , "HEj" , "HEk" , "HEl" , "HEm" , "HEn" , "HFL" , "HFM" , "HFN" , "HFO" , "HFP" , "HFQ" , "HFR" , "HFS" , "HFV" , "HFW" , "HFX" , "HFY" , "HFa" , "HFb" , "HFc" , "HFd" , "HFg" , "HFh" , "HFi" , "HFj" , "HFk" , "HFl" , "HFm" , "HFn" , "HGL" , "HGM" , "HGN" , "HGO" , "HGP" , "HGQ" , "HGR" , "HGS" , "HGV" , "HGW" , "HGX" , "HGY" , "HGa" , "HGb" , "HGc" , "HGd" , "HGg" , "HGh" , "HGi" , "HGj" , "HGk" , "HGl" , "HGm" , "HGn" , "HHL" , "HHM" , "HHN" , "HHO" , "HHP" , "HHQ" , "HHR" , "HHS" , "HHV" , "HHW" , "HHX" , "HHY" , "HHa" , "HHb" , "HHc" , "HHd" , "HHg" , "HHh" , "HHi" , "HHj" , "HHk" , "HHl" , "HHm" , "HHn"}
        };
        int[] flag = {0,0,0,0,0,0,0,0};
        if (placement != ""){
            for (int i = 0; i < placement.length()/3; i++){
                switch (placement.charAt(i*3)){
                    case 'A': flag[0] = 1;break;
                    case 'B': flag[1] = 1;break;
                    case 'C': flag[2] = 1;break;
                    case 'D': flag[3] = 1;break;
                    case 'E': flag[4] = 1;break;
                    case 'F': flag[5] = 1;break;
                    case 'G': flag[6] = 1;break;
                    case 'H': flag[7] = 1;break;
                }
            }
        }

        int l=placement.length()/3;
        int num=8-l;
        ArrayList x=new ArrayList();
        ArrayList y=new ArrayList();
        x.add(placement);
        for(int r=0;r<num;r++){
            int[] flagu = flag.clone();
            for(int i=0;i<x.size();i++){
                placement = x.get(i).toString();
                for(int m = 0; m < 8; m++){
                    if (flagu[m] == 1) continue;
                    for (int n = 0;n < pieces[m].length; n++){
                        placement += pieces[m][n];
                        if(isPlacementSequenceValid(placement)){
                            y.add(placement);
                        }
                    }
                    placement=x.get(i).toString();
                }
            }
            x.clear();
            for(int n = 0; n < y.size(); n++){
                x.add(y.get(n));
            }
            y.clear();
        }

        int le = x.size();
        String ss[] = new String[le];

        for(int i = 0;i<le;i++){
            ss[i] = x.get(i).toString();
        }

        return ss;
    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String c = value;
            sbu.append((char) Integer.parseInt(c));
        return sbu.toString();
    }
}
