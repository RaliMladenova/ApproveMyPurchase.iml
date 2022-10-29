package handlers;

import common.Type;
public class VicePresident extends Approver{
    @Override
    public void approve(Request request) {
        int cost = request.getCost();
        int id = request.getId();
        if (canApprove(request)) {
            System.out.println("Vice President approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Vice President.");
        next.approve(request);
    }

    @Override
    protected boolean canApprove(Request request) {
        int cost = request.getCost();
        Type type = request.getType();
        if(cost < 0)
            return false;
        if(type == Type.CONSUMABLES && (cost > 500 && cost <= 700))
            return true;
        else if(type == Type.CLERICAL && cost <= 1500)
            return true;
        else if(type == Type.GADGETS && cost <= 2000)
            return true;
        else if(type == Type.GAMING && cost <= 4500)
            return true;
        else if(type == Type.PC && cost <= 6500)
            return true;
        else
            return false;
    }
}


