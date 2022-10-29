import common.Type;
import handlers.Approver;
import handlers.Manager;
import handlers.Request;
public class PurchaseApprovalExecutor {

    public static void execute() {
        Approver manager = new Manager();
        ApprovalChainGenerator.generate(manager);
        //Be free to modify method below this line

        manager.approve(new Request(1, 15000, Type.CONSUMABLES));
        manager.approve(new Request(2, 5000, Type.PC));
        manager.approve(new Request(3, 5000, Type.PC));
        manager.approve(new Request(4, 3000, Type.CLERICAL));
    }
}
