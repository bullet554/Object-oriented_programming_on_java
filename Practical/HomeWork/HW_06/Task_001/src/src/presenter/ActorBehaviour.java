package presenter;

public interface ActorBehaviour {
    void setMakeOrder(boolean makeOrder);

    void setTakeOrder(boolean pickUpOrder);

    boolean isMakeOrder();

    boolean isTakeOrder();
}