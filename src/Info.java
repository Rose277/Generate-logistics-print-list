public class Info {

    private String originatingSite;//始发网点

    private String sender;//寄件人

    private String senderPhone;//寄件人电话

    private String shipperCompany;//寄件公司

    private String senderAddress;//寄件人地址

    private String receiver;//收件人

    private String receiverPhone;//收件人电话

    private String recipientCompany;//收件公司

    private String receiverAddress;//收件地址

    private String setPackageAddress;//集包地

    private String orderNumber;//订单号

    private String count;//数量

    private String trackingNumber;//物流单号

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOriginatingSite() {
        return originatingSite;
    }

    public void setOriginatingSite(String originatingSite) {
        this.originatingSite = originatingSite;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getShipperCompany() {
        return shipperCompany;
    }

    public void setShipperCompany(String shipperCompany) {
        this.shipperCompany = shipperCompany;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getRecipientCompany() {
        return recipientCompany;
    }

    public void setRecipientCompany(String recipientCompany) {
        this.recipientCompany = recipientCompany;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSetPackageAddress() {
        return setPackageAddress;
    }

    public void setSetPackageAddress(String setPackageAddress) {
        this.setPackageAddress = setPackageAddress;
    }
}
