package com.hannonhill.technical;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluate {

  private static boolean debug = false;;

  private static HashMap<Integer, Integer> secretMap = new HashMap<Integer, Integer>();

  private static int xpulled = 0, ypulled = 0, xcalc = 0, ycalc = 0, addpulled = 0, addcalc = 0;


  public static void main(String[] args){
    if (args.length < 1) {
      //System.out.println("Usage: Evaluate.java <int:upperbound> <boolean:debug>");
      System.out.println("Usage: Evaluate.java <int:upperbound>");
    } else {
      try {
        int upperBound = Integer.parseInt(args[0]);

        if (upperBound <= 0) {
          System.err.println("Error: upper bound must be greater than zero");
        } else {
          /* 
           * uncomment to enable debug mode enabling via String argument
          if(args.length == 2){
            debug = Boolean.parseBoolean(args[1]);
            if (debug) {
              System.out.println("DEBUG on");
            }
          }
           */

          System.out.println("isAdditive: " + isAdditive(upperBound));
          if (debug){
            int executes = xcalc + ycalc + addcalc;
            int pulls = xpulled + ypulled + addpulled;
            double ratio = (double) pulls / executes;
            System.out.println(xcalc + ":" + xpulled + ", " + ycalc + ":" + ypulled + ", " + addcalc + ":" + addpulled);
            System.out.println("secret() executed: " + executes + " times, value pulled from map: " + pulls + " times.");
            System.out.println("executes:pulls::1:" + ratio);
          }
        }

      } catch (NumberFormatException e){
        System.err.println("Error: invalid <upperbound> format - must be an integer greater than 0");
      }
    }
  }

  private static ArrayList<Integer> eratosthenes(int n) {
    ArrayList<Integer> primes = new ArrayList<Integer>();

    //array to represent the whether all the numbers between 1 and n-1 are prime
    boolean[] primeCandidates = new boolean[n];

    //we'll never need to try a number greater than the root of the max
    double maxRoot = Math.sqrt(n);

    //go through each prime and eliminate composites made of i
    for (int i = 2; i < maxRoot; i++) {
      if (!primeCandidates[i]) {
        primes.add(i);
        if (debug){
          System.out.println("Primes added: " + i);
        }
        //remove candidacy for each multiple of i
        for (int j = 2 * i; j < n; j += i) {
          primeCandidates[j] = true;
        }
      }

    }

    for (int i = (int) maxRoot; i < n; i++){
      if (!primeCandidates[i]) {
        primes.add(i);
        if (debug){
          System.out.println("Primes added: " + i);
        }
      }
    }
    return primes;
  }

  private static boolean isAdditive(int n){

    ArrayList<Integer> primes = eratosthenes(n);
    for (int i = 0; i < primes.size() - 1; i++) {
      int primex = primes.get(i);

      //by each other prime number, starting from i+1(the previous will have been calculated for sure)
      for (int j = i + 1; j < primes.size(); j++) {
        int primey = primes.get(j);

        //Check the map to see if the function result has been calculated.
        Integer additive = secretMap.get(primex + primey);
        if (additive == null) {
          additive = Secret.secret(primex + primey);
          addcalc++;
        } else {
          addpulled++;
        }

        Integer x = secretMap.get(primex);
        if (x == null) {
          x = Secret.secret(primex);
          xcalc++;
        } else {
          xpulled++;
        }

        Integer y = secretMap.get(primey);
        if (y == null) {
          y = Secret.secret(primey);
          ycalc++;
        } else {
          ypulled++;
        }
        if (debug) {
          System.out.println("evaluating: secret(" + (primex + primey) + ") = secret(" + primex + ") + secret(" + primey + ")");
        }
        //if it's not additive...
        if (additive != (x + y)) {
          if (debug) {
            System.out.println(">>>previous parameters NOT additive, exiting...");
          }
          return false;
        }

        //if we haven't a need to return, then store these and continue looping
        secretMap.put(primex + primey, additive);
        secretMap.put(primex, x);
        secretMap.put(primey, y);

      }
    }
    return true;
  }
}
