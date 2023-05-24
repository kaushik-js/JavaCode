public class CurrentAccount extends Account{

    private String tinno;
  

    public CurrentAccount(String anm,String ano,String bnm,String tinno) {
        super.setAnm(anm);
        super.setAno(ano);
        super.setBnm(bnm);
        this.tinno = tinno;
    }

    public String getTinno() {
        return tinno;
    }

    public void display(){
        super.display();
        System.out.println("TIN Number : "+tinno);
    }
    
    
}
