package co.cue.edu.ticventory.ticventory.notification.models;
/**
 * Enum que define los diferentes tipos de notificación disponibles.
 */
public enum NotificationType {
    VENCIMIENTO(0),
    PRESTAMO(1),
    CANCELACION(2),
    SOLICITUD(3);

    private final int typeCode;

    NotificationType(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public static NotificationType fromInt(int i) {
        for (NotificationType type : NotificationType.values()) {
            if (type.getTypeCode() == i) {
                return type;
            }
        }
        return null;
    }
}
