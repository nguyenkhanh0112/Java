package mvc.count;

import mvc.count.model.CounterModel;
import mvc.count.view.CounterView;

public class Test1 {
    public static void main(String[] args) {
        CounterModel ct = new CounterModel();
        ct.increment();
        ct.increment();
        ct.increment();
        System.out.println(ct.getValue());
        ct.decrement();
        System.out.println(ct.getValue());

        CounterView ctv = new CounterView();
    }
}
