import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        //ekle metodunu yazınız
        int h = hash(deger);
        if(dizi[h] == null)
            dizi[h] = new LinkedList<>();
        dizi[h].add(deger);
        
    }
    public boolean sil(int deger){
        //sil metodunu yazınız
        int h = hash(deger);
        if(dizi[h] == null)
            return false;
        int konum = dizi[h].indexOf(deger);
        if(konum == -1)
            return false;
        dizi[h].remove(konum);
        return true;
    }
    public void yenidenOzetle() {
        //yenidenOzetle metodunu yazınız
        int boyut=gelecek_asal(dizi.length*2);
        LinkedList<Integer>[] eskitablo=dizi;
        dizi=new LinkedList[boyut];
        for(LinkedList<Integer>x:eskitablo){
            if(x!=null)
                for (int i:x){
                    ekle(i);
                }
        }

    }
    private boolean asal(int indis){
        for (int i = 2; i <=Math.sqrt(indis)+1; i++) {
            if (indis%i==0)
                return false;
        }
        return true;
    }
    private int gelecek_asal(int indis){
        while (!asal(indis))
            indis++;
        return indis;
    }
}
