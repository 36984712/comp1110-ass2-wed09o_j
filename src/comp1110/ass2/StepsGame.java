package comp1110.ass2;

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

    /**
     * Determine whether a placement sequence is valid.  To be valid, the placement
     * sequence must be well-formed and each piece placement must be a valid placement
     * (with the pieces ordered according to the order in which they are played).
     *
     * @param placement A placement sequence string
     * @return True if the placement sequence is valid
     */
    public static boolean isPlacementSequenceValid(String placement) {
        // FIXME Task 5: determine whether a placement sequence is valid
        boolean b1=true;
        boolean b2=false;
        if(isPlacementWellFormed(placement)==false){
            b1=false;
        }
        if(b1==true){
            int l=placement.length()/3;
            String string[]=new String[l];
            int centerx[]=new int[l];
            int centery[]=new int[l];
            for(int i=0; i<l;i++){
                string[i]=placement.substring(i*3,i*3+1);
                char c=placement.charAt(i*3+2);
                if(c>=65&&c<=74){
                    centerx[i]=(int)c-64;
                    centery[i]=1;
                }else if(c>=75&&c<=84){
                    centerx[i]=(int)c-74;
                    centery[i]=2;
                }else if(c>=85&&c<=89){
                    centerx[i]=(int)c-84;
                    centery[i]=3;
                }else if(c>=97&&c<=101){
                    centerx[i]=(int)c-91;
                    centery[i]=3;
                }else if(c>=102&&c<=111){
                    centerx[i]=(int)c-101;
                    centery[i]=4;
                }else if(c>=112&&c<=121){
                    centerx[i]=(int)c-111;
                    centery[i]=5;
                }
            }
            for(int a=0;a<l;a++){
                String s=string[a];
                int x=centerx[a];
                int y=centery[a];
                b2=out(s,x,y);
                if(b2==false){
                    break;
                }
            }
        }

        return b1&&b2;
    }

    static boolean out(String string, int x, int y){
        boolean boo=false;
        if(string.equals("AA")||string.equals("AB")||string.equals("AC")||string.equals("AD")||string.equals("AE")||string.equals("AF")||string.equals("AG")||string.equals("AH")||string.equals("CA")||string.equals("CB")||string.equals("CC")||string.equals("CD")||string.equals("CE")||string.equals("CF")||string.equals("CG")||string.equals("CH")||string.equals("DA")||string.equals("DB")||string.equals("DC")||string.equals("DD")||string.equals("DE")||string.equals("DF")||string.equals("DG")||string.equals("DH")||string.equals("FA")||string.equals("FB")||string.equals("FC")||string.equals("FD")||string.equals("FF")||string.equals("FG")||string.equals("FH")||string.equals("GA")||string.equals("GB")||string.equals("GC")||string.equals("GD")||string.equals("GE")||string.equals("GF")||string.equals("GG")||string.equals("GH")||string.equals("HA")||string.equals("HB")||string.equals("HC")||string.equals("HD")||string.equals("HE")||string.equals("HF")||string.equals("HG")|| string.equals("HH")){
            if(x>=2&&x<=9&&y>=2&&y<=4){
                boo=true;
            }
        }
        if(string.equals("BA")||string.equals("BG")||string.equals("EC")||string.equals("EE")) {
            if (x >= 1 && x <= 9 && y >= 2 && y <= 4) {
                boo = true;
            }
        }
        if(string.equals("BB")||string.equals("BH")||string.equals("ED")||string.equals("EF")){
                if(x>=2&&x<=9&&y>=1&&y<=4){
                    boo=true;
                }
            }
        if(string.equals("BC")||string.equals("BE")||string.equals("EA")||string.equals("EG")){
                if(x>=2&&x<=10&&y>=2&&y<=4){
                    boo=true;
                }
            }

        if(string.equals("BD")||string.equals("BF")||string.equals("EB")||string.equals("EH")){
                if(x>=2&&x<=9&&y>=2&&y<=5){
                    boo=true;
                }
            }
        return boo;
    }



    static boolean layout(String string1, String string2, int x1, int y1, int x2, int y2){
        boolean boo=false;
        return boo;
    }
    static boolean back(String string1, String string2, int x1, int y1, int x2, int y2){
        boolean boo=false;
        return boo;
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
        return null;
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
        return null;
    }
}
