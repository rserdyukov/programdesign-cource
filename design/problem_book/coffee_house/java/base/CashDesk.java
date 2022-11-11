package base;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    public CashDesk() {
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) { this.worker = worker; }

    public void addVisitorToQueue(Visitor visitor) {
        visitorList.add(visitor);
    }

    public Visitor getFirstVisitor() {
        return visitorList.isEmpty()? null : visitorList.get(0);
    }

    List<Visitor> getVisitorList() {
        return visitorList;
    }
    void removeVisitor(Visitor visitor) {
        visitorList.remove(visitor);
    }

    private Worker worker = null;
    private final List<Visitor> visitorList = new ArrayList<>();
}
