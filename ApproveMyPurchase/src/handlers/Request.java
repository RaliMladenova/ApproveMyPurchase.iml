package handlers;

import common.Type;

public class Request {
    private int id;
    private int cost;
    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Request(int id, int cost, Type type) {
        this.setId(id);
        this.setCost(cost);
        this.setType(type);
    }
}

