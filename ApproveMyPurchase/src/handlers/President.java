package handlers;

import common.Type;

public class President extends Approver{
    @Override
    public void approve(Request request) {
        int cost = request.getCost();
        int id = request.getId();
        if (canApprove(request)) {
            System.out.println("President approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " isn't approved by the President.");
        next.approve(request);
    }

    @Override
    protected boolean canApprove(Request request) {
        int cost = request.getCost();
        Type type = request.getType();
        if(cost < 0)
            return false;
        switch(type) {
            case CONSUMABLES:
                if(cost > 700 && cost <= 1000)
                    return true;
                break;
            case  CLERICAL:
                if(cost <= 2000)
                    return true;
                break;
            case  GADGETS:
                if(cost <= 3000)
                    return true;
                break;
            case GAMING:
                if(cost <= 5000)
                    return true;
                break;
            case  PC:
                if(cost <= 8000)
                    return true;
                break;
            default:
                return false;
        }
        return false;
    }
}
