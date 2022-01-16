import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class LabGraph2<T> extends AbstractGraph2<T> implements Comparator<AbstractGraph3<T>> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LabGraph2<T> donecek = new LabGraph2<>();
        for(Vertex<T> v: this.vertices)
            donecek.addVertex(v.value);
        for(Vertex<T> v: this.vertices)
            for(Edge<T> e: v.edges)
                donecek.addEdge(e.from.value, e.to.value);
        return donecek;
    }
    public static <T> void kenarListesi(AbstractGraph3<T> g) {
        for(Vertex<T> v:g.vertices){
            for(Edge<T> e:v.edges){
                System.out.println(e.from.value +"->"+e.to.value);
            }
        }
    }
    @Override
    public int compare(AbstractGraph3<T> g1, AbstractGraph3<T> g2) {
        if(g1.vertices.size()>(g2.vertices.size()))
            return 1;
        else if(g1.vertices.size()<(g2.vertices.size()))
            return -1;
        else 
            return 0;
        
    }
    @Override
    public void removeVertex(T deger) {
        Vertex<T> silinecek = verticesMap.get(deger);
        if(silinecek == null)
            return;
        vertices.remove(silinecek);
        //Giren kenarların silinmesi
        for(Vertex<T> v: this.vertices){
            Edge<T> silinecekKenar = null;
            for(Edge<T> e: v.edges){
                if(e.to.value.equals(deger)){
                    silinecekKenar = e;
                    break;
                }
            }
            if(silinecekKenar != null)
                v.edges.remove(silinecekKenar);
        }  
    } 
    @Override
    public List<T> topologicalSort() {
        ArrayList<T> list=new ArrayList<>();
        LabGraph2<T> clone= null;
        try {
            clone = (LabGraph2<T>) clone();
            while(clone.vertices.size()>0){
                for (Vertex<T>v:vertices){
                    if (clone.inDegree(v.value)==0){
                        list.add(v.value);
                        clone.removeVertex(v.value);
                    }
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
