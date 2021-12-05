class Araba<T>
        implements Comparable<T>{
    public int modelYili;
    public double motorHacmi;
    public String marka;
    public String plaka;

    public Araba(String marka, int modelYili, double motorHacmi, String plaka) {
        this.marka = marka;
        this.modelYili = modelYili;
        this.motorHacmi = motorHacmi;
        this.plaka = plaka;
    }

    @Override
    public int compareTo(T o) {
      if(modelYili>((Araba) o).modelYili)
          return 1;
      else if(modelYili==((Araba) o).modelYili)
          return 0;
      else return -1;
    }
}