import java.util.*;

public class DebtCalculator {
    public static void main(String[] args) {
        //String[] ar = {"Alex Blake 2", "Blake Alex 2", "Casey Alex 5", "Blake Casey 7", "Alex Blake 4", "Alex Casey 4", "John, Casey, 3"};
        //                                 borrower (receive), lender (give), amount
        List<String> tst1 = Arrays.asList("John", "Casey", "3");
        List<String> tst2 = Arrays.asList("Blake", "Alex", "2");
        List<String> tst3 = Arrays.asList("Alex", "Blake", "2");
        List<String> tst4 = Arrays.asList("Casey", "Alex", "5");
        List<String> tst5 = Arrays.asList("Blake", "Casey", "7");
        List<String> tst6 = Arrays.asList("Alex", "Blake", "4");
        List<String> tst7 = Arrays.asList("Alex", "Casey", "4");

        List<List<String>> wo = new ArrayList<>(Arrays.asList(tst1, tst2, tst3, tst4, tst5, tst6, tst7));

        /*wo.add(tst1);
        wo.add(tst2);
        wo.add(tst3);
        wo.add(tst4);
        wo.add(tst5);
        wo.add(tst6);
        wo.add(tst7);
        //System.out.println(wo);*/

        System.out.println(smallestNegativeBalance(wo));
    }

    //[[Alex, Blake, 5], [Blake, Alex, 3], [Casey, Alex, 7], [Casey, Alex, 4], [Casey, Alex, 2], [John, Casey, 3]]
    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        //System.out.println(debts);
        //find person and balance
        Map<String, Double> map = new HashMap<>();
        for(List<String> lst : debts){              //lst => [borrower, lender, amount]
            if (!map.containsKey(lst.get(0))){
                map.put(lst.get(0), -(Double.parseDouble(lst.get(2))));
            } else if (map.containsKey(lst.get(0))) {
                map.put(lst.get(0), map.get(lst.get(0)) - Integer.parseInt(lst.get(2)));
            }
            if (!map.containsKey(lst.get(1))) {
                map.put(lst.get(1), Double.parseDouble(lst.get(2)));
            } else if (map.containsKey(lst.get(1))) {
                map.put(lst.get(1), map.get(lst.get(1)) + Integer.parseInt(lst.get(2)));
            }
        }
        //find min balance
        double minBalance = Collections.min(map.values());
        List<String> res = new ArrayList<>();

        if(minBalance<0){
            for(Map.Entry<String, Double> k : map.entrySet()){
                if(k.getValue() == minBalance){
                    res.add(k.getKey());
                }
            }
            res.sort(null);
        }else{
            res.add("Nobody has a negative balance");
        }
        return res;
    }
}
