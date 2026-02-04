package condition;

class EmailNotificationSender implements NotificationSender {

    @Override
    public void send(String to, String message) {
        System.err.println(to + ": " + message);
    }
}
