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
        boolean boo=false;
        boolean isWord=piecePlacement.matches("[a-zA-Z]+");
        if(isWord){
            if(piecePlacement.length()==3){
                byte a=(byte)piecePlacement.charAt(0);
                byte b=(byte)piecePlacement.charAt(1);
                byte c=(byte)piecePlacement.charAt(2);
                if(a>='A'&& a<='H'){
                    if(b>='A'&& b<='H'){
                        if(c>='A'&& c<='Y'){
                            boo= true;
                        }else if(c>='a'&& c<='y'){
                            boo= true;
                        }
                    }
                }
            }
        }
        return boo;
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
        if(placement==""||placement==null){
            return false;
        }
        boolean boo=false;
        boolean isWord=placement.matches("[a-zA-Z]+");
        int l=placement.length();
        char[][]ch=new char[l/3][3];
        byte a;
        byte b;
        byte c;
        if(l>=1 & l<=24){
            if(l%3==0){
                if(isWord){
                    for(int i=0;i<(l/3);i++){
                        for(int m=0;m<3;m++){
                            ch[i][m]=placement.charAt((i*3+m));
                        }
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
        for(int i=0;i<(l/3);i++){
            a=(byte)ch[i][0];
            b=(byte)ch[i][1];
            c=(byte)ch[i][2];
            if(a>='A'&& a<='H'){
                if(b>='A'&& b<='H'){
                    if(c>='A'&& c<='Y'){
                        boo= true;
                    }else if(c>='a'&& c<='y'){
                        boo= true;
                    }else{
                        boo=false;
                    }
                }else{
                    boo=false;
                }
            }else{
                boo=false;
            }
            if(boo==false){
                return false;
            }
        }

        if((l/3)>1){
            for(int i=1;i<(l/3);i++){
                for(int m=1;m<(l/3);m++){
                    if(i==m){
                        continue;
                    }else if(ch[i][0]==ch[m][0]){
                        boo=false;
                    }
                }
            }
        }
        return boo;
    }

    /**
     * Determine whether a placement sequence is valid.  To be valid, the placement
     * sequence must be well-formed and each piece placement must be a valid placement
     * (with the pieces ordered according to the order in which they are played).
     *
     * @param placement A placement sequence string
     * @return True if the placement sequence is valid
     */
    static boolean isPlacementSequenceValid(String placement) {
        // FIXME Task 5: determine whether a placement sequence is valid
        return false;
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
