/**
 * Minimum heap sınıfı
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Yığını tutacak dizi(değiştirmeyin)
    public int es;//Eleman sayısı(değiştirmeyin)

    public BinaryHeap() {//değiştirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//değiştirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//değiştirmeyin, kullanın
    public int solCocuk(int konum){ return 2*konum;}//değiştirmeyin, kullanın
    public int sagCocuk(int konum){return 2*konum+1;}//değiştirmeyin, kullanın
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){
        dizi[++es]=eleman;
        int konum = es;
        while(ebeveyn(konum) > 0 && dizi[ebeveyn(konum)].compareTo(dizi[konum])>0) {
            T gecici = dizi[konum];
            dizi[konum]= dizi[ebeveyn(konum)];
            dizi[ebeveyn(konum)] = gecici;
            konum = ebeveyn(konum);
        }
    }
    public T sil(){
        T silinen=dizi[1];
        int konum=1;
        dizi[konum]=dizi[es];
        es--;
        while(solCocuk(konum)<=es+1&&dizi[solCocuk(konum)].compareTo(dizi[konum])<0||sagCocuk(konum)<=es+1&&dizi[sagCocuk(konum)].compareTo(dizi[konum])<0){
            int temp_konum;
            if (dizi[solCocuk(konum)].compareTo(dizi[sagCocuk(konum)])<0)
                temp_konum=solCocuk(konum);
            else
                temp_konum=sagCocuk(konum);
            T temp=dizi[konum];
            dizi[konum]=dizi[temp_konum];
            dizi[temp_konum]=temp;
            konum=temp_konum;
        }
        return silinen;
    }
    
}
