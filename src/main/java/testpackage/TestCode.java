package testpackage;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


// timestamp|customer1|product1
// Loyal Customer i.e. Customer visited both the days and have seen three or more distinct product
// return list of those customer.
 /*
        yes: t1|C1|P1, t1|C2|P1, t1|C2|P2
        dayBeforeYest: t2|C2|P1 t2|C2|P2 t2|C2|P3 t2|C1|P1 t1|C1|P1 t1|C1|P1
         */

public class TestCode {

    public static void main(String[] args) {
        List<String> yesterdayCustomers = List.of("t1|C1|P1", "t1|C2|P1", "t1|C2|P1");
        List<String> dayBeforeYesterdayCustomers = List.of("t2|C2|P1", "t2|C2|P2", "t2|C2|P3", "t2|C1|P1", "t2|C1|P1", "t2|C1|P1");

        Map<String, Set<String>> customersVisitedYesterday = yesterdayCustomers.stream().
                map(s -> s.split("\\|")).collect
                        (Collectors.groupingBy(arr -> arr[1],
                                Collectors.mapping(arr -> arr[2],
                                        Collectors.toSet())));

        Map<String, Set<String>> customerVisitedBothDays = dayBeforeYesterdayCustomers.stream()
                .map(s -> s.split("\\|"))
                .filter(arr -> customersVisitedYesterday.containsKey(arr[1]))
                .collect(Collectors.groupingBy(
                        arr -> arr[1], // customer
                        Collectors.mapping(
                                arr -> arr[2], // product
                                Collectors.toSet()
                        )
                ));

        customerVisitedBothDays.forEach((customer, products) ->
                products.addAll(customersVisitedYesterday.get(customer)));

        customerVisitedBothDays.forEach((k, v) -> {
            if (v.size() > 2)
                System.out.println(k);
        });
    }
}
