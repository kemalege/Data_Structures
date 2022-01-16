import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.*;

class EdgeComparator<T extends Comparable<T>> implements Comparator<Edge<T>> {
    
    public int compare(Edge<T> e1, Edge<T> e2){
        return e1.to.value.compareTo(e2.to.value)*-1;
    }
}

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    @Override
    public List<T> dfs(T baslangic) {
        
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(verticesMap.get(baslangic));
        List<T> visited = new ArrayList<>();
        while(!stack.isEmpty()) {
            Vertex<T> mevcut = stack.pop();
            if(visited.contains(mevcut.value))
                continue;
            visited.add(mevcut.value);
            List<Edge<T>> kenarlar = new ArrayList<Edge<T>>(mevcut.edges);
            Collections.sort(kenarlar, new EdgeComparator<>());
            for(Edge<T> kenar: kenarlar)
                stack.push(kenar.to);
        }
        return visited;
    }
    
    @Override
    public List<T> bfs(T baslangic) {
        List<T> donecek = new ArrayList<>();
        ArrayDeque<T> f = new ArrayDeque<>();
        HashSet<T> visited = new HashSet<>();
        
        f.add(baslangic);
        while(!f.isEmpty()){
            T eleman = f.remove();
            if(visited.contains(eleman))
                continue;
            visited.add(eleman);
            donecek.add(eleman);
            List<Edge<T>> v = verticesMap.get(eleman).edges;
            List<T> komsular = new ArrayList<>();
            
            for(Edge<T> a:v){
                if(!visited.contains(a))
                    komsular.add(a.to.value);
            }
            Collections.sort(komsular);
            for(T c:komsular)
                f.add(c);
        }
        return donecek;
    }
}
