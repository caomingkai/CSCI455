// Name: Mingkai Cao
// USC NetID: 7151889244
// CS 455 PA1
// Spring 2017

import java.util.Random;

/**
 * class CoinTossSimulator
 *
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.

 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 */
public class CoinTossSimulator {
    /**
       @param twoHeadsNumTotal  cumulative results of TWO_HEAD after run() is executed.
       @param twoTailsNumTotal  cumulative results of TWO_TAIL after run() is executed.
       @param headTailNumTotal  cumulative results of HEAD_TAIL after run() is executed.
    */

    private int twoHeadsNumTotal;
    private int twoTailsNumTotal;
    private int headTailNumTotal;

    /**
        Creates a CoinTossSimulator object with no trials done yet.
    */
    public CoinTossSimulator() {
        twoHeadsNumTotal = 0;
        twoTailsNumTotal = 0;
        headTailNumTotal = 0;
    }


    /**
      Runs the simulation for numTrials more trials. Multiple calls to this
      without a reset() between them add these trials to the simulation
      already completed.
      For only one coin toss-result, assumes:
        1 stands for the head
        0 stands for the tail
      Then for tow coins toss-result combination:
        0 stands for two-tails result
        1 stands for head-tail result
        2 stands for two-heads result
      @param numTrials  number of trials to for simulation; must be >= 1
    */
    public void run(int numTrials) {

        final int RANDOM_BOUNDRY = 2; // boundry for Random.nextInt()
        int tossResult1;    //toss result for the 1st coin
        int tossResult2;    //toss result for the 2nd coin
        int tossResult;     //toss result for the two coins

        Random  toss = new Random();

        for(int i=0; i<numTrials; i++){
            tossResult1 = toss.nextInt(RANDOM_BOUNDRY);
            tossResult2 = toss.nextInt(RANDOM_BOUNDRY);
            tossResult = tossResult1 + tossResult2;

            if(tossResult == 0){
                twoTailsNumTotal++;
            }else if(tossResult == 2){
                twoHeadsNumTotal++;
            }else{
                headTailNumTotal++;
            }
        }
    }


    /**
        Get number of trials performed since last reset.
    */
    public int getNumTrials() {
        return (headTailNumTotal + twoHeadsNumTotal + twoTailsNumTotal); //
    }


    /**
        Get number of trials that came up two heads since last reset.
    */
    public int getTwoHeads() {
        return twoHeadsNumTotal;
    }


    /**
        Get number of trials that came up two tails since last reset.
    */
    public int getTwoTails() {
        return twoTailsNumTotal;
    }


    /**
        Get number of trials that came up one head and one tail since last reset.
    */
    public int getHeadTails() {
        return headTailNumTotal;
    }


    /**
        Resets the simulation, so that subsequent runs start from 0 trials done.
    */
    public void reset() {
        twoHeadsNumTotal = 0;
        twoTailsNumTotal = 0;
        headTailNumTotal = 0;
    }
}
