package ke.com.mtugo.dtos;

public class MpesaPaymentRequestDto {

    private Integer BusinessShortCode;
    private String Password;
    private String Timestamp;
    private String TransactionType;
    private Integer Amount;
    private Long PartyA;
    private Integer PartyB;
    private Long PhoneNumber;
    private String CallBackURL;
    private String AccountReference;
    private String TransactionDesc;

    public Integer getBusinessShortCode() {
        return BusinessShortCode;
    }

    public void setBusinessShortCode(Integer businessShortCode) {
        BusinessShortCode = businessShortCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Long getPartyA() {
        return PartyA;
    }

    public void setPartyA(Long partyA) {
        PartyA = partyA;
    }

    public Integer getPartyB() {
        return PartyB;
    }

    public void setPartyB(Integer partyB) {
        PartyB = partyB;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCallBackURL() {
        return CallBackURL;
    }

    public void setCallBackURL(String callBackURL) {
        CallBackURL = callBackURL;
    }

    public String getAccountReference() {
        return AccountReference;
    }

    public void setAccountReference(String accountReference) {
        AccountReference = accountReference;
    }

    public String getTransactionDesc() {
        return TransactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        TransactionDesc = transactionDesc;
    }

    @Override
    public String toString() {
        return this.BusinessShortCode + " " + this.PartyA + " " + this.PartyB + " ";
    }
}
