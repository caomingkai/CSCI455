// Name: Mingkai Cao
// USC NetID: 7151889244
// CS 455 PA1
// Spring 2017

import java.lang.Math;

/**
 * class CoinTossSimulatorTester
 *
 * Test drive for class CoinTossSimulator
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

    sim.run(1);
    System.out.println("After run(1):  ");
    System.out.println("Number of trials [exp:1]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(10);
    System.out.println("After run(10):  ");
    System.out.println("Number of trials [exp:11]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(100);
    System.out.println("After run(100):  ");
    System.out.println("Number of trials [exp:111]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(1000);
    System.out.println("After run(1000):  ");
    System.out.println("Number of trials [exp:1111]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(1000000);
    System.out.println("After run(1000000):  ");
    System.out.println("Number of trials [exp:1001111]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    sim.run(10000000);
    System.out.println("After run(10000000):  ");
    System.out.println("Number of trials [exp:11001111]:  "+ sim.getNumTrials());
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

    sim.run(1000);
    System.out.println("After run(1000):  ");
    System.out.println("Number of trials [exp:1000]:  "+ sim.getNumTrials());
    System.out.println("Two-head tosses:  " + sim.getTwoHeads() );
    System.out.println("Two-tail tosses:  " + sim.getTwoTails() );
    System.out.println("one-head one-tail tosses:  " + sim.getHeadTails() );
    System.out.println("Tosses add up correctly?:  " + (sim.getNumTrials() ==  sim.getTwoHeads() + sim.getHeadTails() + sim.getTwoTails() ) );
    System.out.println();

    // int start = 3000;
    // int step = 1;
    // int end = 4600;
    // int times = 100;
    // int noQualifyNum = 0;
    // double noQualifyRate = 0;
    // System.out.println("----------------------------------------------------");
    // for(int i = start; i <= end; i = i + step){
    //     for(int k = 0; k <times ; k++){
    //         sim.run(i);
    //         int twoHeads = sim.getTwoHeads();
    //         int twoTails = sim.getTwoTails();
    //         int headTails = sim.getHeadTails();
    //
    //         int twoHeadsPercent = (int)Math.round( twoHeads / (double)i * 100 );
    //         int twoTailsPercent = (int)Math.round( twoTails / (double)i * 100 );
    //         int headTailsPercent = (int)Math.round( headTails / (double)i * 100 );
    //         if(twoHeadsPercent > 26 || twoHeadsPercent < 24 ||
    //            twoTailsPercent > 26 || twoTailsPercent < 24 ||
    //            headTailsPercent > 51 || headTailsPercent < 49){
    //                noQualifyNum++;
    //         }
    //         sim.reset();
    //     }
    //     System.out.println( "rate: " + noQualifyNum + " out of " + times);
    //     noQualifyRate = (int)Math.round((double)noQualifyNum / (double)times * 100)/100.0;
    //     noQualifyNum = 0;
    //     System.out.println(i + " : " + noQualifyRate);
    //     System.out.println("----------------------------------------------------");
    // }
  }

}
