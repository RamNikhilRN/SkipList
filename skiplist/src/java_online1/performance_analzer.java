package java_online1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class performance_analzer {

    private static class StopWatch {
        private long startTime;
        private long stopTime;
        private long cumulativeTime;
        private boolean started;

        public void start() {
            if (started) {
                return;
            }
            startTime = System.currentTimeMillis();
            started = true;
        }

        public void stop() {
            if (!started) {
                return;
            }
            stopTime = System.currentTimeMillis();
            cumulativeTime += (stopTime  - startTime);
            startTime = stopTime = 0;
            started = false;
        }

        public void reset() {
            started = false;
            cumulativeTime = 0;
        }

        public long cumulativeTime() {
            return cumulativeTime;
        }

    }

    public static int [] INPUT_SIZES = new int [] {100000, 500000, 1000000, 5000000, 10000000, 15000000};
    public static int NUM_TRIALS = 1000;
    public static int INSERT_TIME_INDEX = 0;
    public static int DELETE_TIME_INDEX = 1;
    public static int FIND_TIME_INDEX = 2;
    public static int CLOSESTKEYAFTER_TIME_INDEX = 3;

    private static int [] keys = new int[INPUT_SIZES[INPUT_SIZES.length-1]+NUM_TRIALS];
    // times in milliseconds
    private static double [][] cumTimes = new double[4][INPUT_SIZES.length];

    private static int getRandomNumberInRange(int max) {
		Random r = new Random();
        for(int i= 0 ; i <= max;i++){

        }       
		return r.nextInt(max);
	}

    // populate dictionary up to the next input size
    private static void populate(OrderedDictionary<Integer,Integer> dict,int nextInputSize) {
       
        Scanner reader = new Scanner(System.in);
        
          
        System.out.println("Please select the numnber of keys or press 0 to exit :/n 1. 100000 /n 2. 500000 /n 3. 1000000 /n 4. 5000000 /n 5. 10000000 /n 6. 15000000");
        int val = reader.nextInt();
        do{

            switch(val)
            {
                case 0 :
                        break;
                case 1: 
                        getRandomNumberInRange(100000);
                        break;
                                
                            
                case 2: 
                        getRandomNumberInRange(500000);
                        break;
                
                case 3: 
                        getRandomNumberInRange(1000000);
                        break;
                case 4: 
                        getRandomNumberInRange(5000000);
                        break;
                case 5: 
                         getRandomNumberInRange(10000000);
                        break;
                            
                case 6: 
                        getRandomNumberInRange(15000000);
                       break;
                 
                       
                default: System.out.println("Invalid");
            }
             

        }while(val != 0);


        reader.close();
        
    }

    
    private static List<Integer> keysForSuccessfulFind(int [] sortedKeyArr, int sampleSize) {
        List<Integer> lst = new ArrayList<>();
        Random random = new Random();
        int i=0;
        while (i < sampleSize) {
            int idx = random.nextInt(sortedKeyArr.length);
            int key = sortedKeyArr[idx];
            if (lst.contains(key)) {
                continue;
            }
            lst.add(key);
            i++;
        }
        return lst;
    }


    private static List<Integer> keysForUnsuccessfulFind(int [] sortedKeyArr, int sampleSize) {
        List<Integer> lst = new ArrayList<>();
        /**
         * Complete the code similar to keysForSuccessfulFind
         */
        Random random = new Random();
        int i=0;
        while (i < sampleSize) {
            int idx = random.nextInt(sortedKeyArr.length);
            int key = sortedKeyArr[idx +2];
            if (!(lst.contains(key))) {
                
                break;
            }
        }
        return lst;
    }


    public static void dumpPerformanceStats() {
        
    }

    public static void measurePerformance(SkipList<Integer> dict) {
        List<Integer> lst = new ArrayList<>();
        
        for (int i=0; i < keys.length; i++) {
            keys[i] = lst.get(i);
        }
        StopWatch watch = new StopWatch();
        for (int i=0; i < INPUT_SIZES.length; i++) {
            
        }
        dumpPerformanceStats();
    }

    public static void main(String [] args) {
       
       SkipList<Integer> sl = new  SkipList<>();
       StopWatch watch = new StopWatch();
       Scanner reader = new Scanner(System.in);  
       System.out.println("Enter list size: ");
       int lsize = 5000000; 
       
       long findelement_time=0;
       long insert_time=0;
       long remove_time=0;
       int[] test = new int[lsize];       
        for (int i =0 ; i<=lsize; i++) {
            watch.start();
           sl.insert(i);
            watch.stop();
            insert_time=watch.cumulativeTime();
           System.out.println("Adding"+ i);
          
       }
       sl.printList();
      System.out.println("time taken for insert " + watch.cumulativeTime()); 
 
      watch.start();
      sl.findelement(1999);
       watch.stop();
       findelement_time=watch.cumulativeTime();
       System.out.println("time taken for find " + watch.cumulativeTime()); 
      watch.start();
      sl.remove(1999);
      watch.stop();
      remove_time=watch.cumulativeTime();
      System.out.println("time taken to delete the element is :"+watch.cumulativeTime());
      watch.start();
      System.out.println("Enter the number to find the next closest key after: ");
      int val=reader.nextInt();
      sl. closetKeyAfter(val);
      watch.stop();
      reader.close();
      System.out.println("Time taken to find the closest element to find"+val+"is "+watch.cumulativeTime());
      System.out.println("Time taken to insert is: "+insert_time+"\n TIme taken to find the element is : "+findelement_time+"\n Time taken to remove the element is: "+remove_time);

      
    }

}
