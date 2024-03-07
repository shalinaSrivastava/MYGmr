package com.max.ecomaxgo.maxpe.upi_bhim.upi_model;

import com.olive.upi.transport.model.Account;
import com.olive.upi.transport.model.Bank;
import com.olive.upi.transport.model.BeneVpa;
import com.olive.upi.transport.model.Collectbeneblock;
import com.olive.upi.transport.model.CustomerBankAccounts;
import com.olive.upi.transport.model.CustomerVpa;
import com.olive.upi.transport.model.PendingReqVo;
import com.olive.upi.transport.model.TranHistory;

import java.util.ArrayList;

public class Upi {
    private static ArrayList<Bank> banks;
    private static ArrayList<Account> accounts;
    private static ArrayList<CustomerBankAccounts> customerBankAccounts;
    private static ArrayList<CustomerVpa> customerVpa;

    private static ArrayList<BeneVpa> beneVpa;
    private static ArrayList<BeneIfsc> beneIfsc;
    private static ArrayList<Collectbeneblock> collectbeneblocks;
    private static ArrayList<PendingReqVo> pendingReqVos;
    private static ArrayList<TranHistory> tranHistory;
    private static ArrayList<TranHistory> query;
    private static int selectedBank;

    public static final String AggregtorCode = "MAXPE";
    public static final String MerchantId = "MAXPE";
    public static final String MerchChanId = "OLIVEAPP";
    public static final String Submerchantid = "OLIVE";
    public static final String MerchantVpa = "maxpe@axis";
    public static final String MCC = "7322";

 /*   public static final String[][] temp = {
        {"max","8810609988","9110XXXXXXX8655","918810609988","298655","01-JAN-2025","0125","nu4xsnidw5h682aygu9iu6eby95ypuiquwc1ftf4byzquqmurkssz8ap9pm7ykslbsh1fpi2pablnrqhsey5yhf5k1125vg6hcgwsu0jwbbpdpomckugpy5l090ibx3wn822uhr5wzppb8fgd9dj3s5htv81zylvp38vtiycc808q2237im0zwvk3t8g8g4ee58brm8gieboounrjzd37rhzpi8nkn2bikva95vvj1s8zx1pn8h2khv33509m7xb"},
        {"ravi","9354090876","9110XXXXXXX2596","919354090876","922596","01-JAN-2025","0125","g99kphwto433smrb09ytie7l5iea3pb7vs83jtyigjcqysrnwofvrzl46b57owmsotsqvbij3wvv7bdqjp261f16w7jf2gcs5xfr8vst76o8qvs6bptqsnykezswhje0mdtvgc2gp1whtgkgehf5kq3ms7p2rbzybsmeutgfov9fnxr3q9zmh0pdbpyuhf90wm9t4gzjg0xzgd0s5l1dl44uyhjox9pb4rp05xha6anq3jcixi7pxixfdcpos0pf"},
        {"anukriti","8826632178","9110XXXXXXX9014","918826632178","359014","01-JAN-2025","0125","grgzdc7h7t9c4zvhv9gwxpveciyvnm5b6ed19ngyp978tzwqela7wijw4spq1xjwlctaurad0fqdcp3lj5b48loxv1kew9h8fqeds9x2ffxhegw37b2s49ylhjinu21fd8w898ae07qus5jk3h17v2e30tgdwi9evnno8mymzqyfhaq7aoadzuog3fzsvqj5fo5t5nmtwspgq7lsyasy76kuorvpmccsdfh7udhr35f51981n6e8jpxif6m047wa"},
        {"akansha","6394401975","9110XXXXXXX2402","916394401975","532402","01-JAN-2025","0125","p3dyiatit8p9s0ketwmwv0l4egqipjtnkwktgt8j0x688j26okk0qfb7a0p33n7448pkub5kii6vqoykkntw2i6etghe61hlrch75vplf88skhvschye6ieyeq52f6sw0f8lzb956jf7dzxxnj4jkqu6gleb8m5yvsiau2ayueu7f5awckrb3ch23gff6mx4ylbvsbm6nw8nsktcvntztz1xhmy7zqntoiqh5gbf1m6jejbfzi6qy8eunv7mlvy7"},
        {"shalina","8299582385","9110xxxxxxx9491","918299582385","289491","01-JAN-2025","0125","e9k0ilebbt1cehz4fzhfx5o3gy6rwo227b1usbq34nx0atjhm93smi7f05cls5b0x84w0f8zmsoaz5i9rkimi0fz0bbdrr4mwoa5ydcbs0l7w3lf8z662hegzwc0h19fdyj49l7uva2vvvxdelxkxdkzhlxlbkyost6fp9xk1tp55e97vyfx3vn2a9w488h4ykh94tkq78urt0x8qu9e0ddkzey5pwtinvlx7b7e908dvwgu19scmaztwrp1821z"},

    };*/

    private static String URI = "";
    private static String Sign = "";

   // public static int tempSelect = -1;
    public static int subscriptionId = -1;

    public static void setUri(Account ac){
        Upi.URI = "upi://pay?pa="+ac.getVpa()+"&cu=INR&am=0&pn="+ac.getName()+"&refUrl=https://www.axisbank.com&orgid=400005&mode=01&purpose=00";
    }

    public static ArrayList<CustomerVpa> getCustomerVpa() {
        return customerVpa;
    }

    public static void setCustomerVpa(ArrayList<CustomerVpa> customerVpa) {
        Upi.customerVpa = customerVpa;
    }

    public static ArrayList<TranHistory> getQuery() {
        return query;
    }

    public static void setQuery(ArrayList<TranHistory> query) {
        Upi.query = query;
    }

    public static String getUri(){
        return Upi.URI;
    }

    public static String getSign(){
        return Upi.Sign;
    }

    public static void setSign(String Sign){
        Upi.Sign = Sign;
    }

    public static ArrayList<TranHistory> getTranHistory() {
        return tranHistory;
    }

    public static void setTranHistory(ArrayList<TranHistory> tranHistory) {
        Upi.tranHistory = tranHistory;
    }

    public static ArrayList<Collectbeneblock> getCollectbeneblocks() {
        return collectbeneblocks;
    }

    public static void setCollectbeneblocks(ArrayList<Collectbeneblock> collectbeneblocks) {
        Upi.collectbeneblocks = collectbeneblocks;
    }

    public static ArrayList<PendingReqVo> getPendingReqVos() {
        return pendingReqVos;
    }

    public static void setPendingReqVos(ArrayList<PendingReqVo> pendingReqVos) {
        Upi.pendingReqVos = pendingReqVos;
    }

    public static void setBene(ArrayList<BeneVpa> bene)
    {
        ArrayList<BeneVpa> beneVpa = new ArrayList<>();
        ArrayList<BeneIfsc> beneIfsc = new ArrayList<>();

        for(BeneVpa b : bene)
        {
            String vpa = b.getVpa();
            int len = vpa.length();
            if(len > 10)
            {
                if(vpa.substring(len-10,len).equals(".ifsc.npci")){

                    String s[] = vpa.substring(0,len-10).split("@");
                    BeneIfsc i = new BeneIfsc();
                    i.setAccount(s[0]);
                    i.setIfsc(s[1]);
                    i.setName(b.getName());
                    i.setVpa(b.getVpa());

                    beneIfsc.add(i);
                }
                else
                    beneVpa.add(b);
            }
            else{
                beneVpa.add(b);
            }
        }
        Upi.setBeneVpa(beneVpa);
        Upi.setBeneIfsc(beneIfsc);
    }


    public static ArrayList<BeneVpa> getBeneVpa() {
        return beneVpa;
    }

    public static void setBeneVpa(ArrayList<BeneVpa> beneVpa) {
        Upi.beneVpa = beneVpa;
    }


    public static ArrayList<BeneIfsc> getBeneIfsc() {
        return beneIfsc;
    }

    public static void setBeneIfsc(ArrayList<BeneIfsc> beneIfsc) {
        Upi.beneIfsc = beneIfsc;
    }



    public static Bank getSelectedBank() {
        return banks.get(selectedBank);
    }

    public static String getBankLogo(String bankiin) {
        int i=0;
        for (Bank b : banks)
        {
            if(bankiin.equals(b.getIin())) {
                return b.getLogo();
            }
            i++;
        }
        return "";
    }

    public static void setSelectedBank(int selectedBank) {
        Upi.selectedBank = selectedBank;
    }

    public static void setSelectedBank(Bank bank) {
        int i=0;
        for (Bank b : banks)
        {
            if(b.getIin() == bank.getIin()) {
                setSelectedBank(i);
                break;
            }
            i++;
        }
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        Upi.accounts = accounts;
    }

    public static ArrayList<Bank> getBanks() {
        return banks;
    }

    public static void setBanks(ArrayList<Bank> banks) {
        Upi.banks = banks;
    }

    public static ArrayList<CustomerBankAccounts> getCustomerBankAccounts() {
        return customerBankAccounts;
    }

    public static void setCustomerBankAccounts(ArrayList<CustomerBankAccounts> customerBankAccounts) {
        Upi.customerBankAccounts = customerBankAccounts;
    }

    public static void setCustomerBankAccounts(Account account,Bank bank) {
        ArrayList<Account> ac = new ArrayList<>();
        ac.add(account);
        CustomerBankAccounts cb = new CustomerBankAccounts();
        cb.setAccounts(ac);
        cb.setBankName(bank.getName());
        cb.setBankCode(bank.getIin());
        ArrayList<CustomerBankAccounts> customerBankAccounts = new ArrayList<>();
        customerBankAccounts.add(cb);
        Upi.customerBankAccounts = customerBankAccounts;
    }
}
