package co.cue.edu.ticventory.ticventory.notification.models;
/**
 * Enum que define los diferentes canales de notificación disponibles.
 */
public enum NotificationChannel {
    SISTEMA_INTERNO(0),
    CORREO(1),
    SMS(2),
    WHATSAPP(3);

    private final int channelCode;

    NotificationChannel(int channelCode) {
        this.channelCode = channelCode;
    }

    public int getChannelCode() {
        return channelCode;
    }

    public static NotificationChannel fromInt(int i) {
        for (NotificationChannel channel : NotificationChannel.values()) {
            if (channel.getChannelCode() == i) {
                return channel;
            }
        }
        return null;
    }
}
