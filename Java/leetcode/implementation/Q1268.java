package leetcode.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/search-suggestions-system/ (Search Suggestions System)
 * @classfication: implementation
 * @reference: https://leetcode.com/problems/search-suggestions-system/discuss/436674/C%2B%2BJavaPython-Sort-and-Binary-Search-the-Prefix
 * (using TreeMap, O(N))
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.19 (O)
 **/
public class Q1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        Arrays.sort(products);

        for(int i=0;i<searchWord.length();i++) {
            String typing = searchWord.substring(0, i+1);
            List<String> list = new ArrayList<>();

            for(String product : products) {
                if(list.size() == 3) break;

                int subStrLen = product.length() < i+1 ? product.length() : i+1;

                String productSubStr = product.substring(0, subStrLen);
                if(typing.equals(productSubStr)) {
                    list.add(product);
                }
            }

            result.add(list);
        }

        return result;
    }
}
