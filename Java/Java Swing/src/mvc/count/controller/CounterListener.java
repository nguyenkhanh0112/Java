package mvc.count.controller;

import mvc.count.view.CounterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterListener implements ActionListener {
    private CounterView ctv;

    public CounterListener(CounterView ctv) {
        this.ctv = ctv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("UP"))
            this.ctv.increment();
        else if(src.equals("DOWN"))
            this.ctv.decrement();
        else if(src.equals("RESET"))
            this.ctv.reset();
    }
}
