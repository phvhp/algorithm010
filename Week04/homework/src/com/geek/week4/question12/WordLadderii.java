package com.geek.week4.question12;

//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转
// 换后得到的单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回一个空列表。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
// Related Topics 广度优先搜索 数组 字符串 回溯算法

import java.util.*;

public class WordLadderii {

    class Solution {
        private static final int INF = 1 << 20;
        private Map<String, Integer> wordId;
        private ArrayList<String> idWord;
        private ArrayList<Integer>[] edges;

        public Solution() {
            wordId = new HashMap<>();
            idWord = new ArrayList<>();
        }

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            int id = 0;
            for (String word : wordList) {
                if (!wordId.containsKey(word)) {
                    wordId.put(word, id++);
                    idWord.add(word);
                }
            }
            if (!wordId.containsKey(endWord)) {
                return new ArrayList<>();
            }
            if (!wordId.containsKey(beginWord)) {
                wordId.put(beginWord, id++);
                idWord.add(beginWord);
            }

            edges = new ArrayList[idWord.size()];
            for (int i = 0; i < idWord.size(); i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < idWord.size(); i++) {
                for (int j = i + 1; j < idWord.size(); j++) {
                    if (transformCheck(idWord.get(i), idWord.get(j))) {
                        edges[i].add(j);
                        edges[j].add(i);
                    }
                }
            }

            int dest = wordId.get(endWord);
            List<List<String>> res = new ArrayList<>();
            int[] cost = new int[id];
            for (int i = 0; i < id; i++) {
                cost[i] = INF;
            }

            Queue<ArrayList<Integer>> q = new LinkedList<>();
            ArrayList<Integer> tmpBegin = new ArrayList<>();
            tmpBegin.add(wordId.get(beginWord));
            q.add(tmpBegin);
            cost[wordId.get(beginWord)] = 0;

            while (!q.isEmpty()) {
                ArrayList<Integer> now = q.poll();
                int last = now.get(now.size() - 1);
                if (last == dest) {
                    ArrayList<String> tmp = new ArrayList<>();
                    for (int index : now) {
                        tmp.add(idWord.get(index));
                    }
                    res.add(tmp);
                } else {
                    for (int i = 0; i < edges[last].size(); i++) {
                        int to = edges[last].get(i);
                        if (cost[last] + 1 <= cost[to]) {
                            cost[to] = cost[last] + 1;
                            ArrayList<Integer> tmp = new ArrayList<>(now); tmp.add(to);
                            q.add(tmp);
                        }
                    }
                }
            }
            return res;
        }

        boolean transformCheck(String str1, String str2) {
            int differences = 0;
            for (int i = 0; i < str1.length() && differences < 2; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    ++differences;
                }
            }
            return differences == 1;
        }
    }

}
