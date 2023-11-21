package chapter18.node06.recorddemo;

/** JDK14 新特性 record */
public class Order {
    private final int orderId;
    private final String orderName;

    public Order(int orderId, String orderName){
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int orderId() {
        return orderId;
    }

    public String orderName() {
        return orderName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + orderId;
        result = prime * result + ((orderName == null) ? 0 : orderName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (orderId != other.orderId)
            return false;
        if (orderName == null) {
            if (other.orderName != null)
                return false;
        } else if (!orderName.equals(other.orderName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
    }

    
}
