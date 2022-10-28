import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Cpu {
    private Process process;
    private ArrayList<SharedResource> srl;
    private int rbs; //Resource being used

    public Cpu(){
        rbs =0;

    }

    public Cpu(Process process, ArrayList srl) {
        this.process = process;
        this.srl = srl;
    }

    public void stageProcess(Process process){
        this.process = process;
    }

    public int executeProcess(ArrayList<SharedResource> srl,int index, int task){

        int srlIndex = index;
        process.setRunning();
        if(task == 0) {

            int random = (int) (Math.random() * 100);
            System.out.println("Adding Data for Index " + srlIndex);
            srl.get(srlIndex).setData(random);
            System.out.println("Data Added: = "+ random);
        }else if (task == 1) {
            System.out.println("Deleting Data for Index " + srlIndex);
            if(srl.get(srlIndex).getData() != 0)
                srl.get(srlIndex).setData(0);
            System.out.println("Data Deleted: = " + srl.get(srlIndex).getData());
        }else if(task == 2) {
            System.out.println("Reading Data for Index " + srlIndex);
            System.out.println("Data: "+srl.get(srlIndex).getData());
        }else {
            System.out.println("Calculating Data");
            int total = 0;

            for(SharedResource srTmp : srl){
                total = srTmp.getData()+total;
            }
            System.out.println("Total: "+total);
            process.setTerminated();
            return srlIndex;
        }

        process.setTerminated();
        return srlIndex+1;
    }

    public Process getProcess( ) {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public List getSrl( ) {
        return srl;
    }

    public void setSrl(ArrayList<SharedResource> srl) {
        this.srl = srl;
    }

    public int getRbs( ) {
        return rbs;
    }

    public void setRbs(int rbs) {
        this.rbs = rbs;
    }

    @Override
    public String toString( ) {
        return "Cpu{" +
                "process=" + process +
                ", sharedResource=" + srl +
                '}';
    }
}
