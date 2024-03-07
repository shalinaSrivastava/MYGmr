package com.max.ecomaxgo.maxpe.dashboad.modle;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.List;

public class Rank {

@SerializedName("status")
@Expose
private String status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private Data data;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Rank withStatus(String status) {
this.status = status;
return this;
}

public String getError() {
return error;
}

public void setError(String error) {
this.error = error;
}

public Rank withError(String error) {
this.error = error;
return this;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Rank withMessage(String message) {
this.message = message;
return this;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

public Rank withData(Data data) {
this.data = data;
return this;
}
public class MyRank {

@SerializedName("rank")
@Expose
private String rank;
@SerializedName("amount")
@Expose
private String amount;

public String getRank() {
    return rank;
}

public void setRank(String rank) {
    this.rank = rank;
}

public MyRank withRank(String rank) {
    this.rank = rank;
    return this;
}

public String getAmount() {
    return amount;
}

public void setAmount(String amount) {
    this.amount = amount;
}

public MyRank withAmount(String amount) {
    this.amount = amount;
    return this;
}

}
public class Top {

@SerializedName("rank")
@Expose
private String rank;
@SerializedName("name")
@Expose
private String name;
@SerializedName("amount")
@Expose
private String amount;

public String getRank() {
    return rank;
}

public void setRank(String rank) {
    this.rank = rank;
}

public Top withRank(String rank) {
    this.rank = rank;
    return this;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Top withName(String name) {
    this.name = name;
    return this;
}

public String getAmount() {
    return amount;
}

public void setAmount(String amount) {
    this.amount = amount;
}

public Top withAmount(String amount) {
    this.amount = amount;
    return this;
}

}

    public class Data {

        @SerializedName("forRankAmount")
        @Expose
        private String forRankAmount;
        @SerializedName("myRank")
        @Expose
        private MyRank myRank;
        @SerializedName("topList")
        @Expose
        private List<Top> topList = null;

        public String getForRankAmount() {
            return forRankAmount;
        }

        public void setForRankAmount(String forRankAmount) {
            this.forRankAmount = forRankAmount;
        }

        public Data withForRankAmount(String forRankAmount) {
            this.forRankAmount = forRankAmount;
            return this;
        }

        public MyRank getMyRank() {
            return myRank;
        }

        public void setMyRank(MyRank myRank) {
            this.myRank = myRank;
        }

        public Data withMyRank(MyRank myRank) {
            this.myRank = myRank;
            return this;
        }

        public List<Top> getTopList() {
            return topList;
        }

        public void setTopList(List<Top> topList) {
            this.topList = topList;
        }

        public Data withTopList(List<Top> topList) {
            this.topList = topList;
            return this;
        }

    }

}


