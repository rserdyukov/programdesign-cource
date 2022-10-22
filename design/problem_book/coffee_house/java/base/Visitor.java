package base;

import java.util.Random;

public class Visitor {
    public Visitor(CoffeeHouse model) {
        this.model = model;

        var menu = model.getMenu();

        Random rand = new Random();
        desiredProduct = menu.get(rand.nextInt(menu.size()));

        var cashDeskList = model.getCashDeskList();
        cashDesk = cashDeskList.get(rand.nextInt(cashDeskList.size()));
        cashDesk.addVisitorToQueue(this);
    }

    public void process(long currentTime) {
        if (nextActionTime == 0) {
            nextActionTime = currentTime + Settings.VISITOR_WAITING_TIME;
        }
        if (currentTime >= nextActionTime) {
            model.addRating(0);
            model.visitorLeave(this);
            System.out.println("Time=" + currentTime + " Visitor leave by timeout " + this);
        }
    }

    public void askDesiredProduct(long currentTime) {
        var requestStatus = model.requestProduct(desiredProduct);
        if (requestStatus == VisitorRequestStatus.SUCCESS) {
            model.takeProduct(desiredProduct);
            model.addRating(successRating);
            model.visitorLeave(this);
            System.out.println("Time=" + currentTime + " Visitor(" + hashCode() + ") leave with product " + desiredProduct);
        }
        else if (requestStatus == VisitorRequestStatus.PRODUCT_MISSING) {
            failDesiredProduct(currentTime, desiredProduct);
        }
    }

    public void givePreparedProduct(long currentTime, Product product) {
        model.addRating(successRating);
        model.visitorLeave(this);
        System.out.println("Time=" + currentTime + " Visitor(" + hashCode() + ") leave with product " + product);
    }

    public void failDesiredProduct(long currentTime, Product product) {
        model.addRating(1);
        model.visitorLeave(this);
        System.out.println("Time=" + currentTime + " Visitor(" + hashCode() + ") leave without product " + product);
    }

    public Product getDesiredProduct() {
        return desiredProduct;
    }

    public CashDesk getCashDesk() {
        return cashDesk;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Visitor(").append(hashCode()).append(")");
        builder.append(" desiredProduct=[").append(desiredProduct).append("]");
        builder.append(" queuePos=").append(cashDesk.getVisitorList().indexOf(this));
        return builder.toString();
    }

    protected CoffeeHouse model = null;
    protected CashDesk cashDesk = null;
    protected Product desiredProduct = null;
    protected long nextActionTime = 0;
    protected int successRating = 5;
}
