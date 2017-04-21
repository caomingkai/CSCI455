// Name: Mingkai Cao
// USC NetID: 7151889244
// CS 455 PA1
// Spring 2017
import java.lang.Math;
/**
 * class CoinTossSimulatorTester
 *
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.

 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
public class CoinTossSimulatorTester {
  public static void main(String[] args){

    CoinTossSimulator sim = new CoinTossSimulator();

    System.out.println("After constructor:  ");
    System.out.println("Number of trials [exp:0]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(10);
    System.out.println("After run(10):  ");
    System.out.println("Number of trials [exp:10]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(11);
    System.out.println("After run(11):  ");
    System.out.println("Number of trials [exp:21]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(12);
    System.out.println("After run(12):  ");
    System.out.println("Number of trials [exp:33]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(100);
    System.out.println("After run(100):  ");
    System.out.println("Number of trials [exp:133]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(1000);
    System.out.println("After run(1000):  ");
    System.out.println("Number of trials [exp:1133]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(1000000);
    System.out.println("After run(1000000):  ");
    System.out.println("Number of trials [exp:1001133]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.reset();
    System.out.println("After reset():  ");
    System.out.println("Number of trials [exp:0]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    int start = 3000;
    int step = 1;
    int end = 4600;
    int times = 100;
    int noQualifyNum = 0;
    double noQualifyRate = 0;
    System.out.println("----------------------------------------------------");
    for(int i = start; i <= end; i = i + step){
        for(int k = 0; k <times ; k++){
            sim.run(i);
            int twoHeads = sim.getTwoHeads();
            int twoTails = sim.getTwoTails();
            int headTails = sim.getHeadTails();

            int twoHeadsPercent = (int)Math.round( twoHeads / (double)i * 100 );
            int twoTailsPercent = (int)Math.round( twoTails / (double)i * 100 );
            int headTailsPercent = (int)Math.round( headTails / (double)i * 100 );
            // System.out.println( "numOfTrials : " + i);
            // System.out.println( "twoHeads : " + twoHeads);
            // System.out.println( "twoTails : " + twoTails);
            // System.out.println( "headTails : " + headTails);
            // System.out.println( "twoHeadsPercent : " + twoHeadsPercent);
            // System.out.println( "twoTailsPercent : " + twoTailsPercent);
            // System.out.println( "headTailsPercent : " + headTailsPercent);
            // System.out.println("----------------");
            if(twoHeadsPercent > 26 || twoHeadsPercent < 24 ||
               twoTailsPercent > 26 || twoTailsPercent < 24 ||
               headTailsPercent > 51 || headTailsPercent < 49){
                   noQualifyNum++;
            }
            sim.reset();
        }
        System.out.println( "rate: " + noQualifyNum + " out of " + times);
        noQualifyRate = (int)Math.round((double)noQualifyNum / (double)times * 100)/100.0;
        noQualifyNum = 0;
        System.out.println(i + " : " + noQualifyRate);
        System.out.println("----------------------------------------------------");
    }
  }

}
