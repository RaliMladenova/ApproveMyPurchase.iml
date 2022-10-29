package handlers;

import common.Type;

public class Director extends Approver {

    @Override
    public void approve(Request request) {
        int cost = request.getCost();
        int id = request.getId();
        if (canApprove(request)) {
            System.out.println("Director approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
        next.approve(request);
    }

    @Override
    protected boolean canApprove(Request request) {
        int cost = request.getCost();
        Type type = request.getType();
        if(cost < 0)
            return false;
        switch (type) {
            case CONSUMABLES:
                if (cost > 300 && cost <= 500) {
                    return true;
                } break;
            case CLERICAL:
                if (cost <= 1000) {
                    return true;
                } break;
            case GADGETS:
                if (cost <= 1500) {
                    return true;
                } break;
            case GAMING:
                if (cost <= 3500) {
                    return true;
                } break;
            case PC:
                if (cost <= 6000) {
                    return true;
                } break;
            default:
                return false;
        }
        return false;
    }
}


