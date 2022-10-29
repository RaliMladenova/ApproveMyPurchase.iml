package handlers;


public abstract class Approver {
    protected Approver next;

    public abstract void approve(Request request);

    protected abstract boolean canApprove(Request request);

    public Approver registerNext(Approver next) {
        this.next = next;
        return next;
    }

}
