import java.util.Comparator;

public class ProComparator implements Comparator<Process> {
public int compare(Process p1, Process p2){
        if(p1.getPriority() > p2.getPriority()){
            return 1;
        }
        else if(p1.getPriority() < p2.getPriority()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
