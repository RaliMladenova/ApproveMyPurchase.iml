package handlers;

public class ExecutiveMeeting extends Approver {
    private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();

    public static ExecutiveMeeting getInstance() {
        return INSTANCE;
    }

    @Override
    public void approve(Request request) {
        int cost = request.getCost();
        int id = request.getId();
        System.out.println("Purchase with id " + id + " that costs " + cost + " requires an approval of executive meeting.");
    }

    @Override
    protected boolean canApprove(Request request) {
        return false;
    }
}



