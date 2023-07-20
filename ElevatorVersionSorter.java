package org.example;


import java.util.Arrays;

class ElevatorVersion {

    public static boolean isVersionsEqual(String v1, String v2) {
        return v1.equals(v2);
    }

    public static boolean isVersionGreater(String v1, String v2) {

        if (isVersionsEqual(v1, v2)) {
            return false;
        }

        String[] v1Tokens = v1.split("\\.");
        String[] v2Tokens = v2.split("\\.");


        int minTokLength = Math.min(v1Tokens.length, v2Tokens.length);
        for (int i = 0; i < minTokLength; i++) {
            int n1 = Integer.parseInt(v1Tokens[i]);
            int n2 = Integer.parseInt(v2Tokens[i]);
            if (n1 < n2) {
                return false;
            }
            else if (n1 > n2) {
                return true;
            }
            // continue on equal
        }

        return v1Tokens.length > v2Tokens.length;
    }
    public static boolean isVersionLesser(String v1, String v2) {

        if (isVersionsEqual(v1, v2)) {
            return false;
        }

        return !isVersionGreater(v1, v2);

    }

    static void swap(String[] versions, int i, int j)
    {
        String temp = versions[i];
        versions[i] = versions[j];
        versions[j] = temp;
    }

    static int partition(String[] versions, int low, int high)
    {
        String pivot = versions[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (ElevatorVersion.isVersionLesser(versions[j], pivot)) {
                i++;
                ElevatorVersion.swap(versions, i, j);
            }
        }
        ElevatorVersion.swap(versions, i + 1, high);
        return (i + 1);
    }

    public static void sortVersions(String[] versions, int low, int high) {


        if (low < high) {

            int pi = partition(versions, low, high);


            sortVersions(versions, low, pi - 1);
            sortVersions(versions, pi + 1, high);
        }

    }

}




class Solution {
    public static String[] solution(String[] l) {
        String[] sol = l.clone();

        ElevatorVersion.sortVersions(sol, 0,l.length - 1);

        return sol;
    }
}
public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Solution.solution(new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"})));

    }
}
