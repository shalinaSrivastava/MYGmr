package com.max.ecomaxgo.maxpe.dth.model;

public class DetailComplaint {
    String ComplaintId;
    String ComplaintStatus;
    String OpenComplaint;
    String AssignedTo;
    String TxnTs;
    String remarks;
    String ResponseCode;
    String ResponseMessage;
    String ResponseDescription;

    public DetailComplaint(String complaintId, String complaintStatus, String openComplaint, String assignedTo, String txnTs, String remarks, String responseCode, String responseMessage, String responseDescription) {
        ComplaintId = complaintId;
        ComplaintStatus = complaintStatus;
        OpenComplaint = openComplaint;
        AssignedTo = assignedTo;
        TxnTs = txnTs;
        this.remarks = remarks;
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
        ResponseDescription = responseDescription;
    }

    public String getComplaintId() {
        return ComplaintId;
    }

    public String getComplaintStatus() {
        return ComplaintStatus;
    }

    public String getOpenComplaint() {
        return OpenComplaint;
    }

    public String getAssignedTo() {
        return AssignedTo;
    }

    public String getTxnTs() {
        return TxnTs;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }
}
