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
        //EFBCFlAFnGFSBFqFGhHANDDP
        allpossible.clear();
        ArrayList allcorrectpossible=new ArrayList();
        ArrayList x=new ArrayList();
        Set set=new HashSet();
        if(placement.equals("")){
            permutation(objective,0,(objective.length()/3)-1);
            for(int i=0;i<allpossible.size();i++){
                if(isPlacementSequenceValid(allpossible.get(i).toString())){
                    set.add(allpossible.get(i).toString().substring(0,3));
                }
            }
        }else if(placement.equals(objective)){
            return set;
        }else {
            permutation(objective,0,(objective.length()/3)-1);
            for(int i=0;i<allpossible.size();i++){
                if(isPlacementSequenceValid(allpossible.get(i).toString())){
                    allcorrectpossible.add(allpossible.get(i));
                }
            }

            for(int i=0;i<allcorrectpossible.size()-1;i++){
                String s1=allcorrectpossible.get(i).toString();
                String s=s1.substring(0,placement.length());
                if(s.equals(placement)){
                    set.add(s1.substring(placement.length(),placement.length()+3));
                }
            }
        }
        return set;
    }
    static ArrayList allpossible=new ArrayList();

    public static void permutation(String string, int start, int end){

        if(start==end){
            allpossible.add(string);

        }else{
            for(int i=start;i<=end;i++){
                string=swap(string,start,i);
                permutation(string,start+1,end);
                string=swap(string,start,i);
            }
        }
    }
    private static String swap(String string, int x, int y){
        String[] str=new String[string.length()/3];
        for(int i=0;i<str.length;i++){
            str[i]=string.substring(i*3,i*3+3);
        }
        String temp=str[x];
        str[x]=str[y];
        str[y]=temp;
        String newstring="";
        for(int i=0;i<str.length;i++){

            newstring+=str[i];
        }
        return newstring;
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
        allpossible.clear();

        String a[] = new String[8];
        String b[] = new String[8];
        String c[] = new String[50];

        ArrayList threech = new ArrayList();
        String three = "";
        for (int x = 0; x < 8; x++) {
            a[x] = asciiToString(String.valueOf(65 + x));
        }
        for (int x = 0; x < 8; x++) {
            b[x] = asciiToString(String.valueOf(65 + x));
        }
        for (int x = 0; x < 50; x++) {
            if (x < 25) {
                c[x] = asciiToString(String.valueOf(65 + x));
            } else {
                c[x] = asciiToString(String.valueOf(72 + x));
            }
        }
        for (int x = 0; x < 8; x++) {
            three += a[x].toString();
            for (int y = 0; y < 8; y++) {
                three += b[y].toString();
                for (int z = 0; z < 50; z++) {
                    three += c[z];
                    threech.add(three);
                    three = three.substring(0, 2);
                }
                three = three.substring(0, 1);
            }
            three = "";
        }
        int l=placement.length()/3;
        int num=8-l;
        ArrayList x=new ArrayList();
        ArrayList y=new ArrayList();
        x.add(placement);
        for(int r=0;r<num;r++){
            for(int i=0;i<x.size();i++){
                placement=x.get(i).toString();
                for(int m=0;m<3200;m++){
                    placement+=threech.get(m).toString();
                    if(isPlacementSequenceValid(placement)){
                        y.add(placement);
                    }
                    placement=x.get(i).toString();
                }
            }
            x.clear();
            for(int n=0;n<y.size();n++){
                x.add(y.get(n));
            }
            y.clear();
        }
        int le=x.size();
        String ss[]=new String[le];

        for(int i=0;i<le;i++){
            ss[i]=x.get(i).toString();
        }
        return  ss;
    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String c = value;
            sbu.append((char) Integer.parseInt(c));
        return sbu.toString();
    }
}
