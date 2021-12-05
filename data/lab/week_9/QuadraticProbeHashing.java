public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        //Karesel sondalama ekleme işlemini gerçekleştirin
        int konum = hash(eleman);
        int i = 0;
        while(true) {
            HashEntry<T> hucre = dizi[(konum+i*i)%dizi.length];
            if(hucre == null || !hucre.isActive) {
                dizi[(konum+i*i)%dizi.length] = new HashEntry<>(eleman);
                break;
            }
            i++;
        }
        elemanSayisi++;
    }

    public boolean sil(T eleman){
        //karesel sondalama silme işlemini gerçekleştirin
        int konum = hash(eleman);
        int sayac = 0;
        while(dizi[ks(konum,sayac)]==null|| !dizi[ks(konum,sayac)].isActive || dizi[ks(konum,sayac)].equals(eleman)){
            sayac++;
            if(sayac>dizi.length)
                return false;
        }
        dizi[ks(konum,sayac)].isActive = false;
        elemanSayisi--;
        return true;
            
    }
    public int ks(int konum, int sayac){
        return (konum + (sayac*sayac))%dizi.length;
    }

}
