public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        Vertex<T> vertex = verticesMap.get(deger);
        if(vertex != null)
            return vertex.edges.size();
        return -1;
    }
    public static<T> T enCokCikan(AbstractGraph3<T> g) {
        int max=0;
        T maxVertex = null;
    
        for(Vertex<T> v:g.vertices){
           
            if(v != null && v.edges.size() > max){
                max= v.edges.size();
                maxVertex=v.value;
            }
        }
        return maxVertex;
    }

    @Override
    public int inDegree(T deger) {
        Vertex<T> vertex=verticesMap.get(deger);
        if(vertex==null)
            return -1;
        int id=0;
        for (Vertex<T> v:vertices)
            for (Edge<T> e:v.edges)
                if(e.to.value.equals(deger))
                    id++;
        return id;
    }
}
