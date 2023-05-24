public class Account
{
    private String anm;
    private String ano;
    private String bnm;
    public String getAnm() {
        return anm;
    }
    public void setAnm(String anm) {
        this.anm = anm;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getBnm() {
        return bnm;
    }
    public void setBnm(String bnm) {
        this.bnm = bnm;
    }

    public void display(){
        System.out.println("Account Name : "+anm);
        System.out.println("Account Number : "+ano);
        System.out.println("Bank Name : "+bnm);
    }
}