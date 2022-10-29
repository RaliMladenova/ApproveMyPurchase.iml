package handlers;

import common.Type;
public class Manager extends Approver {
    @Override
    public void approve(Request request) {
        int cost = request.getCost();
        int id = request.getId();
        if (canApprove(request)) {
            System.out.println("Manager approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + request.getId() + " needs approval from higher position than Manager.");
        next.approve(request);
    }

    @Override
    protected boolean canApprove(Request request) {
        int cost = request.getCost();
        Type type = request.getType();
        if(cost < 0)
            return false;
        else if (type == Type.CONSUMABLES && (cost > 0 && cost <= 300)) {
            return true;
        } else if (type == Type.CLERICAL && cost <= 500) {
            return true;
        } else if (type == Type.GADGETS && cost <= 1000) {
            return true;
        } else if (type == Type.GAMING && cost <= 3000) {
            return true;
        } else if (type == Type.PC && cost <= 5000) {
            return true;
        } else
            return false;
    }
}


