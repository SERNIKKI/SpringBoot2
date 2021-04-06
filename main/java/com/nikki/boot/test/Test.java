package com.nikki.boot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) {
//        String coordinates = "c7";
//        char[] chars = coordinates.toCharArray();
//        int x = chars[0] - 'a' + 1;
//        int y = chars[1] - '0';
//        System.out.println(x + " " + y);
//        System.out.println((x + y) % 2 != 0);
//        System.out.println(areSentencesSimilar("qbaVXO Msgr aEWD v ekcb","Msgr aEWD ekcb"));
        int[][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        findingUsersActiveMinutes(logs,5);
    }
    public static void findingUsersActiveMinutes(int[][] logs, int k) {
        int[] answer = new int[k];
        if(logs.length==0)
            System.exit(0);
        int[] scores = new int[k];
        for (int i = 0;i<k;i++){
            scores[i] = logs[i][0];
            System.out.print(scores[i] + " ");
        }
        int[] a1 = getNum(scores);
        int[][] a2 = new int[scores.length][k];
        for (int i = 0;i<scores.length;i++){
            a2[i][0] = scores[i];
        }
        int a3 = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < scores.length;i++){
            for (int j = 0;j<logs.length;j++){
                if(scores[i]==logs[j][0]){
                    a2[i][a3] = logs[j][1];
                    a3++;
                }
            }
            list.add(a3);
            a3=0;
        }
        int[] get = new int[k];
        for (int i = 0;i<scores.length;i++){
            int j = list.get(i);
            int[] scores1 = new int[j];
            for (int x = 0;x < j;x++){
                scores1[x] = a2[i][x];
            }
            get[i] = getNum(scores1).length;
        }
        for (int i = 0;i<get.length;i++){
            
        }
    }
    public static int[] getNum(int[] scores){
        int[] newScores = new int[scores.length];
        int index = 0;
        boolean isRepetition = false;
        newScores[index++] = scores[0];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < index; j++) {
                if (scores[i] == newScores[j]) {
                    isRepetition = true;
                    break;
                }
            }
            if (isRepetition == false) {
                newScores[index++] = scores[i];
            }
            isRepetition = false;
        }
        scores = new int[index];
        System.arraycopy(newScores, 0, scores, 0, index);
        newScores = null;
        return scores;
    }

//        int x = logs[0][0];
//        List<Integer> num = new ArrayList<>();
//        num.add(logs[0][1]);
//        int a = 0;
//
//        for (int i = 1;i<logs.length;i++){
//            if(logs[i][0]!=x){
//                a++;
//            }
//        }
//        int[][] ids = new int[a+1][k];
//        for (int i = 0;i<a+1;i++){
//            ids[i][0] = i;
//        }
//        int abs = 0;
//        for(int i = 0;i<a+1;i++){
//            for (int j = 0;j<logs.length;j++){
//                if(ids[i][0]==logs[i][j]){
//                    ids[i][abs] = logs[i][j];
//                    abs++;
//                }
//            }
//            abs = 0;
//        }
//        for(int i = 0;i<ids.length;i++){
//            for(int j = 0;j<ids[i].length;j++){
//                System.out.println(ids[i][j]);
//            }
//        }
    public String getS(String s, int k){
        StringTokenizer st = new StringTokenizer(s," ,?.!:\"\"''\n#");
        List<String> wordList = new ArrayList<>();
        while (st.hasMoreElements()) {
            wordList.add(st.nextToken());
        }
        String str = "";
        for(int i = 0;i < k;i++){
            if(i==k-1){
                str = str + wordList.get(i);
            }else {
                str = str + wordList.get(i) + " ";
            }
        }
        return str;
    }
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        StringTokenizer st1 = new StringTokenizer(sentence1," ,?.!:\"\"''\n#");
        StringTokenizer st2 = new StringTokenizer(sentence2," ,?.!:\"\"''\n#");
        List<String> wordList1 = new ArrayList<>();
        while (st1.hasMoreElements()) {
            wordList1.add(st1.nextToken());
        }
        List<String> wordList2 = new ArrayList<>();
        while (st2.hasMoreElements()) {
            wordList2.add(st2.nextToken());
        }
        if(wordList1.size() == 1){
            for (int i = 0;i<wordList2.size();i++){
                if(wordList2.get(i).equals(wordList1.get(0))){
                    if(i>0&&i<wordList2.size()){
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }
        if(wordList2.size() == 1){
            for (int i = 0;i<wordList1.size();i++){
                if(wordList1.get(i).equals(wordList2.get(0))){
                    if(i>0&&i<wordList1.size()){
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }
        int j = 0;
        List<Integer> ints = new ArrayList<>();
        if(wordList1.size()>=wordList2.size()){
            for (int i = 0;i < wordList1.size();i++){
                if(wordList1.get(i).equals(wordList2.get(j))){
                    j++;
                    ints.add(i);
                    if(j==wordList2.size()&&(i<=wordList1.size()-1)&&(i-(wordList2.size()-1)>=0)){
                        return true;
                    }
                }else if(j!=0){
                    return false;
                }
            }
            return false;
        }
        j = 0;
        List<Integer> ints1 = new ArrayList<>();
        if(wordList2.size()>=wordList1.size()){
            for (int i = 0;i < wordList2.size();i++){
                if(wordList2.get(i).equals(wordList1.get(j))){
                    j++;
                    ints1.add(i);
                    if(j==wordList1.size()&&(i<=wordList2.size()-1)&&(i-(wordList1.size()-1)>=0)){
                        return true;
                    }
                }else if(j!=0){
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
