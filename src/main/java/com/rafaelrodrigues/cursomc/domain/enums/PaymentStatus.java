package com.rafaelrodrigues.cursomc.domain.enums;

public enum PaymentStatus {
    PENDING(1, "Pending"),
    PAID(2, "Paid"),
    CANCELED(3, "Canceled");

    private final int cod;
    private final String description;

    PaymentStatus(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static PaymentStatus toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (PaymentStatus status : PaymentStatus.values()) {
            if (cod.equals(status.getCod())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + cod);
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
}
