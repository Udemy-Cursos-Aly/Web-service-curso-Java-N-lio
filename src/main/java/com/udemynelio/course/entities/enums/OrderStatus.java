package com.udemynelio.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT("Aguardando pagamento"),
    PAID("Pago"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELED("Cancelado");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static OrderStatus valueOfOrderStatus(String description) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getDescription().equals(description))
                return value;
        }

        throw new IllegalArgumentException("Status inválido!");
    }
}
